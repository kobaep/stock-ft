package com.psa.domain;

public class Stock {
	private String symbol;
	private Double close;
	private Double open1;
	private Double open2;
	private Double high;
	private Double low;
	private Double last;
	private Double buyVol;
	private Double sellVol;
	private Double buyVal;
	private Double sellVal;
	private Double tval;
	private Double tvol;
	private Double askV1;
	private Double askV2;
	private Double bidV1;
	private Double bidV2;
	private Integer spread;

	public Stock() {}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getOpen1() {
		return open1;
	}

	public void setOpen1(Double open1) {
		this.open1 = open1;
	}

	public Double getOpen2() {
		return open2;
	}

	public void setOpen2(Double open2) {
		this.open2 = open2;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getLast() {
		return last;
	}

	public void setLast(Double last) {
		this.last = last;
	}

	public Double getBuyVol() {
		return buyVol;
	}

	public void setBuyVol(Double buyVol) {
		this.buyVol = buyVol;
	}

	public Double getSellVol() {
		return sellVol;
	}

	public void setSellVol(Double sellVol) {
		this.sellVol = sellVol;
	}

	public Double getBuyVal() {
		return buyVal;
	}

	public void setBuyVal(Double buyVal) {
		this.buyVal = buyVal;
	}

	public Double getSellVal() {
		return sellVal;
	}

	public void setSellVal(Double sellVal) {
		this.sellVal = sellVal;
	}

	public Double getTval() {
		return tval;
	}

	public void setTval(Double tval) {
		this.tval = tval;
	}

	public Double getTvol() {
		return tvol;
	}

	public void setTvol(Double tvol) {
		this.tvol = tvol;
	}

	public Double getAskV1() {
		return askV1;
	}

	public void setAskV1(Double askV1) {
		this.askV1 = askV1;
	}

	public Double getAskV2() {
		return askV2;
	}

	public void setAskV2(Double askV2) {
		this.askV2 = askV2;
	}

	public Double getBidV1() {
		return bidV1;
	}

	public void setBidV1(Double bidV1) {
		this.bidV1 = bidV1;
	}

	public Double getBidV2() {
		return bidV2;
	}

	public void setBidV2(Double bidV2) {
		this.bidV2 = bidV2;
	}

	public Integer getSpread() {
		return spread;
	}

	public void setSpread(Integer spread) {
		this.spread = spread;
	}

	@Override
	public String toString() {
		return "Stock{" +
				"symbol='" + symbol + '\'' +
				", close=" + close +
				", open1=" + open1 +
				", open2=" + open2 +
				", high=" + high +
				", low=" + low +
				", last=" + last +
				", buyVol=" + buyVol +
				", sellVol=" + sellVol +
				", buyVal=" + buyVal +
				", sellVal=" + sellVal +
				", tval=" + tval +
				", tvol=" + tvol +
				", askV1=" + askV1 +
				", askV2=" + askV2 +
				", bidV1=" + bidV1 +
				", bidV2=" + bidV2 +
				", spread=" + spread +
				'}';
	}
}