package com.uplooking.service;

import java.util.List;

import com.uplooking.pojo.Page;
import com.uplooking.pojo.Tbl_sj_goodsinfo;

public interface Tbl_sj_goodsinfoService {
	 // ������
		List<Tbl_sj_goodsinfo> findAll();
		//��ҳ��ѯ����
		Page findPage(int pageNum,int pageSize);
}
