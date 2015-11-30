package com.support.pivotal.function.function;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.FunctionAdapter;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.FunctionException;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;
import com.support.pivotal.function.domain.Trade;
import com.support.pivotal.function.domain.TradeId;

public class MultiGetFunction extends FunctionAdapter implements Declarable{

	  private static final long serialVersionUID = 1L;
	  public static final String ID = "mutiGetFunction";
	  
	  @Override
	  public void execute(FunctionContext fc) {
	    if (!(fc instanceof RegionFunctionContext)){
	      throw new FunctionException("This is a data aware function, and has to be called using FunctionService.onRegion.");
	    }
	    RegionFunctionContext context = (RegionFunctionContext)fc;
//	    Region<TradeKey, Trade> tradeRegion = PartitionRegionHelper.getLocalDataForContext(context);
	    Region<TradeId, Trade> tradeRegion = context.getDataSet();
	    
	    @SuppressWarnings("unchecked")
	    Set<TradeId> keys = (Set<TradeId>)context.getFilter();
	    Set<TradeId> keysTillSecondLast = new HashSet<TradeId>();
	    int setSize = keys.size();
	    System.out.println("Rajiv key size"+tradeRegion.keySet().size());
	    Iterator<TradeId> keysIterator = keys.iterator();
	    for (int i = 0; i < (setSize - 1); i++) {
	      keysTillSecondLast.add(keysIterator.next());
	    }
	    
	    for (TradeId k : keysTillSecondLast) {
	      Trade trade = tradeRegion.get(k);
	      String tradeStatus = (trade == null) ? "null" : trade.toString();
	      context.getResultSender().sendResult(tradeStatus);
	    }
	    TradeId lastResult = keysIterator.next();
	    Trade trade = tradeRegion.get(lastResult);
	    String tradeStatus = (trade == null) ? "null" : trade.toString();
	    context.getResultSender().lastResult(tradeStatus);
	  }

	  @Override
	  public String getId() {
	    return "MultiGetFunction";
	  }

	public void init(Properties arg0) {
		// TODO Auto-generated method stub
		
	}
}
