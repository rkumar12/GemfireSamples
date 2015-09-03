package com.support.pivotal.function.domain;

import java.io.Serializable;

public class TradeHistoryId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -144704810530469237L;

	private int tradeHistoryId;

	private TradeId tradeId;
	
	public TradeHistoryId() {
		// TODO Auto-generated constructor stub
	}
	
	public TradeHistoryId(int tradeHistoryId, TradeId tradeId){
		this.tradeHistoryId=tradeHistoryId;
		this.tradeId=tradeId;
	}
	
	@Override
	public int hashCode() {
		return ((int) tradeHistoryId * 31 + (this.getTradeId().getTradeId() * 31));
	}

	public int getTradeHistoryId() {
		return tradeHistoryId;
	}

	public void setTradeHistoryId(int tradeHistoryId) {
		this.tradeHistoryId = tradeHistoryId;
	}

	public TradeId getTradeId() {
		return tradeId;
	}

	public void setTradeId(TradeId tradeId) {
		this.tradeId = tradeId;
	}


	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof TradeHistoryId))
			return false;

		TradeHistoryId other = (TradeHistoryId) o;
		return ((this.tradeHistoryId == other.tradeHistoryId) && (this
				.getTradeId().getTradeId() == other.getTradeId().getTradeId()));

	}


}
