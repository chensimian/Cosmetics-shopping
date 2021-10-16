package com.wyu.bean;

public class BuyGoods {
	private int num;//数量
	private int money;//总金额
	private Goods goods;//商品
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public BuyGoods(int num, int money, Goods goods) {
		super();
		this.num = num;
		this.money = money;
		this.goods = goods;
	}
	public BuyGoods() {
		super();
	}
	@Override
	public String toString() {
		return "BuyGoods [num=" + num + ", money=" + money + ", goods=" + goods + "]";
	}
	
}
