package com.support.pivotal.function.domain;

import java.io.Serializable;

public class TradeHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3078114755628450230L;
	
	private TradeHistoryId tradeHistoryId;
	
	private int tradeId;
	
	private String tradeName;
	
	private TradeHistoryDetail historyDetails;
	public TradeHistory(){
		
	}
	
	public TradeHistory(TradeHistoryId tradeHistoryId,int tradeId, String tradeName, TradeHistoryDetail historyDetails){
		this.tradeHistoryId=tradeHistoryId;
		this.tradeId=tradeId;
		this.tradeName=tradeName;
		this.historyDetails=historyDetails;
	}
	
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof Trade))
			return false;

		TradeHistory other = (TradeHistory) o;
		return ((this.tradeId == other.tradeId) && (this.tradeName.equals(other
				.getTradeName())));

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (int) tradeId * tradeName.hashCode();
	}

	public TradeHistoryId getTradeHistoryId() {
		return tradeHistoryId;
	}

	public void setTradeHistorId(TradeHistoryId tradeHistoryId) {
		this.tradeHistoryId = tradeHistoryId;
	}

}
