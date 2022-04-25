package com.uplooking.dao;

import java.util.List;

import com.uplooking.pojo.Tbl_sj_goodsinfo;

public interface Tbl_sj_goodsinfoMapper {
	   
	 // 查所有
	List<Tbl_sj_goodsinfo> findAll();
	//  查从哪个开始  每页显示几条
	public List<Tbl_sj_goodsinfo> findPage(int pageNum,int pageSize);
	
	// 查总记录数
     int findCount();

}
