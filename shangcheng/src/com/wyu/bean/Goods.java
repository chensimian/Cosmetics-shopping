package com.wyu.bean;


public class Goods {
	private int id;
	private String name;
	private String pubdate;
	private String picture;
	private int price;
	private int star;
	private String intro;
	private int typeid;
	private String typeName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Goods(int id, String name, String pubdate, String picture, int price, int star, String intro, int typeid,
			String typeName) {
		super();
		this.id = id;
		this.name = name;
		this.pubdate = pubdate;
		this.picture = picture;
		this.price = price;
		this.star = star;
		this.intro = intro;
		this.typeid = typeid;
		this.typeName = typeName;
	}
	public Goods() {
		super();
	}
	
}
