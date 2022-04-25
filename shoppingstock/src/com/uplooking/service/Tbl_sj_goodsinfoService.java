package com.uplooking.service;

import java.util.List;

import com.uplooking.pojo.Page;
import com.uplooking.pojo.Tbl_sj_goodsinfo;

public interface Tbl_sj_goodsinfoService {
	 // 查所有
		List<Tbl_sj_goodsinfo> findAll();
		//分页查询数据
		Page findPage(int pageNum,int pageSize);
}
