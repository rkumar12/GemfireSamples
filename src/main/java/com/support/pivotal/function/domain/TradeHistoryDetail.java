package com.support.pivotal.function.domain;

import java.io.Serializable;

public class TradeHistoryDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7859287909863037651L;

	private int tradeHistorDetailId;
	private String name;
	private int date;

	public TradeHistoryDetail() {

	}

	public TradeHistoryDetail(int tradeHistorDetailId, String name, int date) {

		this.tradeHistorDetailId = tradeHistorDetailId;
		this.name = name;
		this.date = date;
	}

	public int getTradeHistorDetailId() {
		return tradeHistorDetailId;
	}

	public void setTradeHistorDetailId(int tradeHistorDetailId) {
		this.tradeHistorDetailId = tradeHistorDetailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

}
