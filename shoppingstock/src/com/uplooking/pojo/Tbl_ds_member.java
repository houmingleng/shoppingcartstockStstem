package com.uplooking.pojo;

import java.sql.Timestamp;

public class Tbl_ds_member {
    //��Աid ����
    private int memberid;
    //��¼�˺�
    private String account;
    //��¼����
    private String logpwd;
    private String sex;
    //��ʵ����
    private String realname;
    private String mobile;
    //ע������
    private Timestamp regdate;
    //����
    private String place;
    // Ĭ��Ϊ0   ״̬ 0 ���� 1�쳣
    private int stat;
    //����
    private int score;
    //��ע
    private String note;
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getLogpwd() {
		return logpwd;
	}
	public void setLogpwd(String logpwd) {
		this.logpwd = logpwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Tbl_ds_member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tbl_ds_member(int memberid, String account, String logpwd, String sex, String realname, String mobile,
			Timestamp regdate, String place, int stat, int score, String note) {
		super();
		this.memberid = memberid;
		this.account = account;
		this.logpwd = logpwd;
		this.sex = sex;
		this.realname = realname;
		this.mobile = mobile;
		this.regdate = regdate;
		this.place = place;
		this.stat = stat;
		this.score = score;
		this.note = note;
	}
	@Override
	public String toString() {
		return "Tbl_ds_member [memberid=" + memberid + ", account=" + account + ", logpwd=" + logpwd + ", sex=" + sex
				+ ", realname=" + realname + ", mobile=" + mobile + ", regdate=" + regdate + ", place=" + place
				+ ", stat=" + stat + ", score=" + score + ", note=" + note + "]";
	}
    
    
    
}
