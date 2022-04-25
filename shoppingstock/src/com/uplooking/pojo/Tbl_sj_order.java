package com.uplooking.pojo;

import java.sql.Timestamp;

public class Tbl_sj_order {
      private int orderid;
      private int orderflag;
      private Timestamp orderdate;
      private int memberid;
      private int stat;
      private String note;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getOrderflag() {
		return orderflag;
	}
	public void setOrderflag(int orderflag) {
		this.orderflag = orderflag;
	}
	public Timestamp getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Tbl_sj_order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tbl_sj_order(int orderid, int orderflag, Timestamp orderdate, int memberid, int stat, String note) {
		super();
		this.orderid = orderid;
		this.orderflag = orderflag;
		this.orderdate = orderdate;
		this.memberid = memberid;
		this.stat = stat;
		this.note = note;
	}
	@Override
	public String toString() {
		return "Tbl_sj_order [orderid=" + orderid + ", orderflag=" + orderflag + ", orderdate=" + orderdate
				+ ", memberid=" + memberid + ", stat=" + stat + ", note=" + note + "]";
	}
      
      
}
