package com.support.pivotal.function.domain;

import java.io.Serializable;

public class TradeId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6975697801809864727L;
	
	private int tradeId;

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof TradeId))
			return false;

		TradeId other = (TradeId) o;
		return this.tradeId == other.tradeId;

	}

	@Override
	public int hashCode() {
		return (int) tradeId * 31;
	}
}
