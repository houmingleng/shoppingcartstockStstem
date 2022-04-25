package com.uplooking.pojo;

import java.sql.Timestamp;

public class Tbl_sj_goodsinfo {
       private int goodsid;
       private long spflag;
       private String name;
       private int typeid;//外键 1，衣服 2 鞋子 3 包包
       private float price;
       private String make;
       private Timestamp makedate;
       private int amount;
       private int stat; // 0未推送 1推送 默认为0
       private String color;
       private String note;
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public long getSpflag() {
		return spflag;
	}
	public void setSpflag(long spflag) {
		this.spflag = spflag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public Timestamp getMakedate() {
		return makedate;
	}
	public void setMakedate(Timestamp makedate) {
		this.makedate = makedate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Tbl_sj_goodsinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tbl_sj_goodsinfo(int goodsid, long spflag, String name, int typeid, float price, String make,
			Timestamp makedate, int amount, int stat, String color, String note) {
		super();
		this.goodsid = goodsid;
		this.spflag = spflag;
		this.name = name;
		this.typeid = typeid;
		this.price = price;
		this.make = make;
		this.makedate = makedate;
		this.amount = amount;
		this.stat = stat;
		this.color = color;
		this.note = note;
	}
	@Override
	public String toString() {
		return "Tbl_sj_goodsinfo [goodsid=" + goodsid + ", spflag=" + spflag + ", name=" + name + ", typeid=" + typeid
				+ ", price=" + price + ", make=" + make + ", makedate=" + makedate + ", amount=" + amount + ", stat="
				+ stat + ", color=" + color + ", note=" + note + "]";
	}
       
       
       
       
       
}
