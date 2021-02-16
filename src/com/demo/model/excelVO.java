package com.demo.model;

public class excelVO {
	String currency;
	String buyRate;
	String buyCash;
	String buyInTime;
	String buyDay10;
	String buyDay30;
	String buyDay60;
	String buyDay90;
	String buyDay120;
	String buyDay150;
	String buyDay180;

	String sellRate;
	String sellCash;
	String sellInTime;
	String sellDay10;
	String sellDay30;
	String sellDay60;
	String sellDay90;
	String sellDay120;
	String sellDay150;
	String sellDay180;

	public excelVO(String currency, String buyRate, String buyCash, String buyInTime, String buyDay10, String buyDay30,
			String buyDay60, String buyDay90, String buyDay120, String buyDay150, String buyDay180, String sellRate,
			String sellCash, String sellInTime, String sellDay10, String sellDay30, String sellDay60, String sellDay90,
			String sellDay120, String sellDay150, String sellDay180) {
		super();
		this.currency = currency;
		this.buyRate = buyRate;
		this.buyCash = buyCash;
		this.buyInTime = buyInTime;
		this.buyDay10 = buyDay10;
		this.buyDay30 = buyDay30;
		this.buyDay60 = buyDay60;
		this.buyDay90 = buyDay90;
		this.buyDay120 = buyDay120;
		this.buyDay150 = buyDay150;
		this.buyDay180 = buyDay180;
		this.sellRate = sellRate;
		this.sellCash = sellCash;
		this.sellInTime = sellInTime;
		this.sellDay10 = sellDay10;
		this.sellDay30 = sellDay30;
		this.sellDay60 = sellDay60;
		this.sellDay90 = sellDay90;
		this.sellDay120 = sellDay120;
		this.sellDay150 = sellDay150;
		this.sellDay180 = sellDay180;
	}

	public excelVO() {
		super();
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBuyRate() {
		return buyRate;
	}

	public void setBuyRate(String buyRate) {
		this.buyRate = buyRate;
	}

	public String getBuyCash() {
		return buyCash;
	}

	public void setBuyCash(String buyCash) {
		this.buyCash = buyCash;
	}

	public String getBuyInTime() {
		return buyInTime;
	}

	public void setBuyInTime(String buyInTime) {
		this.buyInTime = buyInTime;
	}

	public String getBuyDay10() {
		return buyDay10;
	}

	public void setBuyDay10(String buyDay10) {
		this.buyDay10 = buyDay10;
	}

	public String getBuyDay30() {
		return buyDay30;
	}

	public void setBuyDay30(String buyDay30) {
		this.buyDay30 = buyDay30;
	}

	public String getBuyDay60() {
		return buyDay60;
	}

	public void setBuyDay60(String buyDay60) {
		this.buyDay60 = buyDay60;
	}

	public String getBuyDay90() {
		return buyDay90;
	}

	public void setBuyDay90(String buyDay90) {
		this.buyDay90 = buyDay90;
	}

	public String getBuyDay120() {
		return buyDay120;
	}

	public void setBuyDay120(String buyDay120) {
		this.buyDay120 = buyDay120;
	}

	public String getBuyDay150() {
		return buyDay150;
	}

	public void setBuyDay150(String buyDay150) {
		this.buyDay150 = buyDay150;
	}

	public String getBuyDay180() {
		return buyDay180;
	}

	public void setBuyDay180(String buyDay180) {
		this.buyDay180 = buyDay180;
	}

	public String getSellRate() {
		return sellRate;
	}

	public void setSellRate(String sellRate) {
		this.sellRate = sellRate;
	}

	public String getSellCash() {
		return sellCash;
	}

	public void setSellCash(String sellCash) {
		this.sellCash = sellCash;
	}

	public String getSellInTime() {
		return sellInTime;
	}

	public void setSellInTime(String sellInTime) {
		this.sellInTime = sellInTime;
	}

	public String getSellDay10() {
		return sellDay10;
	}

	public void setSellDay10(String sellDay10) {
		this.sellDay10 = sellDay10;
	}

	public String getSellDay30() {
		return sellDay30;
	}

	public void setSellDay30(String sellDay30) {
		this.sellDay30 = sellDay30;
	}

	public String getSellDay60() {
		return sellDay60;
	}

	public void setSellDay60(String sellDay60) {
		this.sellDay60 = sellDay60;
	}

	public String getSellDay90() {
		return sellDay90;
	}

	public void setSellDay90(String sellDay90) {
		this.sellDay90 = sellDay90;
	}

	public String getSellDay120() {
		return sellDay120;
	}

	public void setSellDay120(String sellDay120) {
		this.sellDay120 = sellDay120;
	}

	public String getSellDay150() {
		return sellDay150;
	}

	public void setSellDay150(String sellDay150) {
		this.sellDay150 = sellDay150;
	}

	public String getSellDay180() {
		return sellDay180;
	}

	public void setSellDay180(String sellDay180) {
		this.sellDay180 = sellDay180;
	}

	@Override
	public String toString() {
		return "excelVO [currency=" + currency + ", buyRate=" + buyRate + ", buyCash=" + buyCash + ", buyInTime="
				+ buyInTime + ", buyDay10=" + buyDay10 + ", buyDay30=" + buyDay30 + ", buyDay60=" + buyDay60
				+ ", buyDay90=" + buyDay90 + ", buyDay120=" + buyDay120 + ", buyDay150=" + buyDay150 + ", buyDay180="
				+ buyDay180 + ", sellRate=" + sellRate + ", sellCash=" + sellCash + ", sellInTime=" + sellInTime
				+ ", sellDay10=" + sellDay10 + ", sellDay30=" + sellDay30 + ", sellDay60=" + sellDay60 + ", sellDay90="
				+ sellDay90 + ", sellDay120=" + sellDay120 + ", sellDay150=" + sellDay150 + ", sellDay180=" + sellDay180
				+ "]";
	}

}
