package com.support.pivotal.function.domain;

import java.io.Serializable;

public class Trade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6135932201164518894L;

	private TradeId tradeId;

	private String tradeName;
	public Trade(){
		
	}

	public Trade(TradeId tradeId, String tradeName) {
		this.tradeId = tradeId;
		this.tradeName = tradeName;
	}

	public TradeId getTradeId() {
		return tradeId;
	}

	public void setTradeId(TradeId tradeId) {
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

		Trade other = (Trade) o;
		return ((this.tradeId == other.tradeId) && (this.tradeName.equals(other
				.getTradeName())));

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (int) tradeId.getTradeId() * tradeName.hashCode();
	}
}
