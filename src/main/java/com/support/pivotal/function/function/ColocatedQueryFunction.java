package com.support.pivotal.function.function;

import java.util.Properties;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.execute.FunctionAdapter;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;
import com.gemstone.gemfire.cache.execute.ResultSender;
import com.gemstone.gemfire.cache.query.FunctionDomainException;
import com.gemstone.gemfire.cache.query.NameResolutionException;
import com.gemstone.gemfire.cache.query.Query;
import com.gemstone.gemfire.cache.query.QueryInvocationTargetException;
import com.gemstone.gemfire.cache.query.QueryService;
import com.gemstone.gemfire.cache.query.TypeMismatchException;

public class ColocatedQueryFunction extends FunctionAdapter implements
		Declarable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2124639242332079180L;

	public void init(Properties arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(FunctionContext ctx) {
		String arguments = (String) ctx.getArguments();
		ResultSender<Object> resultSender = ctx.getResultSender();
		
		Cache cacheInstance = CacheFactory.getAnyInstance();
		QueryService queryService = cacheInstance.getQueryService();
		Query newQuery = queryService
				.newQuery(arguments);
		try {
			Object execute = newQuery.execute((RegionFunctionContext)ctx);
			resultSender.lastResult(execute);
		} catch (FunctionDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultSender.lastResult(null);
		} catch (TypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultSender.lastResult(null);
		} catch (NameResolutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultSender.lastResult(null);
		} catch (QueryInvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultSender.lastResult(null);
		}

	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "ColocatedQueryFunction";
	}

}
