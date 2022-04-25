package com.uplooking.pojo;

public class Tbl_sj_address {
      private int addrid;
      private int memberid;//所属商家id
      private String address;
      private String zip;//邮编
      private int stat;//默认为0 0为默认收获地址
      private String note;
	public int getAddrid() {
		return addrid;
	}
	public void setAddrid(int addrid) {
		this.addrid = addrid;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
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
	public Tbl_sj_address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tbl_sj_address(int addrid, int memberid, String address, String zip, int stat, String note) {
		super();
		this.addrid = addrid;
		this.memberid = memberid;
		this.address = address;
		this.zip = zip;
		this.stat = stat;
		this.note = note;
	}
	@Override
	public String toString() {
		return "Tbl_sj_address [addrid=" + addrid + ", memberid=" + memberid + ", address=" + address + ", zip=" + zip
				+ ", stat=" + stat + ", note=" + note + "]";
	}

      
      
      
      
}
