package com.support.pivotal.function.domain;

import java.io.Serializable;

public class TradeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6975697801809864727L;

	public TradeId() {

	}

	public TradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public TradeId(int tradeId, String tradeName) {
		this.tradeId = tradeId;
		this.tradeName = tradeName;
	}

	private int tradeId;

	private String tradeName;

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
		if (!(o instanceof TradeId))
			return false;

		TradeId other = (TradeId) o;
		return this.tradeId == other.getTradeId()
				&& this.tradeName.equals(other.getTradeName());

	}

	@Override
	public int hashCode() {
		return (int) tradeId * 31 * tradeName.hashCode();
	}

}
