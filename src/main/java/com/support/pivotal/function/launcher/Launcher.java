package com.support.pivotal.function.launcher;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.execute.Execution;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.cache.execute.ResultCollector;
import com.gemstone.gemfire.cache.query.FunctionDomainException;
import com.gemstone.gemfire.cache.query.NameResolutionException;
import com.gemstone.gemfire.cache.query.QueryInvocationTargetException;
import com.gemstone.gemfire.cache.query.TypeMismatchException;
import com.support.pivotal.function.domain.Trade;
import com.support.pivotal.function.domain.TradeHistory;
import com.support.pivotal.function.domain.TradeHistoryDetail;
import com.support.pivotal.function.domain.TradeHistoryId;
import com.support.pivotal.function.domain.TradeId;

public class Launcher {
	public static void main(String[] args) throws InterruptedException,
			FunctionDomainException, TypeMismatchException,
			NameResolutionException, QueryInvocationTargetException {
		ClientCache cache = new ClientCacheFactory().set("cache-xml-file",
				"colocated-client-cache.xml").create();
		Region<TradeId, Trade> regionOne = cache.getRegion("trades");
		Region<TradeHistoryId, TradeHistory> regionTwo = cache
				.getRegion("trades_history");
		System.out.println(regionOne);
		System.out.println(regionTwo);
		for (int i = 0; i < 10; i++) {
			TradeId tradeId = new TradeId();
			tradeId.setTradeId(i);
			TradeHistoryId tradeHistoryId = new TradeHistoryId(i, tradeId);
			regionOne.put(tradeId, new Trade(tradeId, "tradeName" + i));
			regionTwo.put(tradeHistoryId, new TradeHistory(tradeHistoryId, i,
					"tradeName" + i, new TradeHistoryDetail(i, "name" + i,
							i * 1000)));

		}

		//Execution onServers = FunctionService.onServers(PoolManager.find("client")).withArgs("SELECT * FROM /trades_history tradeHistory, /trades trade WHERE trade.tradeId.tradeId = tradeHistory.tradeHistoryId.tradeId.tradeId");
		//Object execute = onServers.execute("ColocatedQueryFunction");
		//System.out.println(execute);

		Execution onRegion = FunctionService
				.onRegion(regionOne)
				.withArgs(
						"SELECT * FROM /trades_history tradeHistory, /trades trade WHERE trade.tradeId.tradeId = tradeHistory.tradeHistoryId.tradeId.tradeId");
		ResultCollector execute2 = (ResultCollector)onRegion.execute("ColocatedQueryFunction");
		Object result = execute2.getResult();
		System.out.println(execute2);
		System.out.println(result);
		

		/*
		 * QueryService queryService = cache.getQueryService(); Query newQuery =
		 * queryService .newQuery(
		 * "SELECT * FROM /trades_history tradeHistory, /trades trade WHERE trade.tradeId.tradeId = tradeHistory.tradeHistoryId.tradeId.tradeId"
		 * ); Object execute = newQuery.execute(); System.out.println(execute);
		 */

	}
}
