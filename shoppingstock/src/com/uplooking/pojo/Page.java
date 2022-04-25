package com.uplooking.pojo;

import java.util.List;

public class Page {
	 // 每页几个
	private int pageSize;
	// 第几页
	private int pageNum;
	// 共几页
	private int pageCount;
	//共多少条记录
	private int count;
	//页面分页后展示的数据
	private List<Tbl_sj_goodsinfo> lists;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Tbl_sj_goodsinfo> getLists() {
		return lists;
	}
	public void setLists(List<Tbl_sj_goodsinfo> lists) {
		this.lists = lists;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Page(int pageSize, int pageNum, int pageCount, int count, List<Tbl_sj_goodsinfo> lists) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.pageCount = pageCount;
		this.count = count;
		this.lists = lists;
	}
	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", pageNum=" + pageNum + ", pageCount=" + pageCount + ", count=" + count
				+ ", lists=" + lists + "]";
	}
	
	
	
	  

}
