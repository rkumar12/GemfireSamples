package com.support.pivotal.function.domain;

import java.io.Serializable;
import java.util.Properties;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryOperation;
import com.gemstone.gemfire.cache.PartitionResolver;

public class CustomPartitionResolver implements PartitionResolver, Declarable {

	public void close() {
		// TODO Auto-generated method stub

	}

	public String getName() {
		// TODO Auto-generated method stub
		return "customPartitionResolver";
	}

	public Serializable getRoutingObject(EntryOperation opDetails) {
		Serializable key = (Serializable) opDetails.getKey();
		if (key instanceof TradeId) {
			return key;
		} else if (key instanceof TradeHistoryId) {
			return ((TradeHistoryId) key).getTradeId();
		}
		return null;
	}

	public void init(Properties arg0) {
		// TODO Auto-generated method stub
		
	}

}
