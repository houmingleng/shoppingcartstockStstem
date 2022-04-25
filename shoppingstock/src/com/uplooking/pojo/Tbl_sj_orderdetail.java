package com.uplooking.pojo;

public class Tbl_sj_orderdetail {
       private int detailid;
       private int orderflag;
       private int spflag;
       private int salecount;
       private int stat;
       private float disct;
       private String note;
	public int getDetailid() {
		return detailid;
	}
	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}
	public int getOrderflag() {
		return orderflag;
	}
	public void setOrderflag(int orderflag) {
		this.orderflag = orderflag;
	}
	public int getSpflag() {
		return spflag;
	}
	public void setSpflag(int spflag) {
		this.spflag = spflag;
	}
	public int getSalecount() {
		return salecount;
	}
	public void setSalecount(int salecount) {
		this.salecount = salecount;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public float getDisct() {
		return disct;
	}
	public void setDisct(float disct) {
		this.disct = disct;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Tbl_sj_orderdetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tbl_sj_orderdetail(int detailid, int orderflag, int spflag, int salecount, int stat, float disct,
			String note) {
		super();
		this.detailid = detailid;
		this.orderflag = orderflag;
		this.spflag = spflag;
		this.salecount = salecount;
		this.stat = stat;
		this.disct = disct;
		this.note = note;
	}
	@Override
	public String toString() {
		return "Tbl_sj_orderdetail [detailid=" + detailid + ", orderflag=" + orderflag + ", spflag=" + spflag
				+ ", salecount=" + salecount + ", stat=" + stat + ", disct=" + disct + ", note=" + note + "]";
	}
       
       
       
       
}
