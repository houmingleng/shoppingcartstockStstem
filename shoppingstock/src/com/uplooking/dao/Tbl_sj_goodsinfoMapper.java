package com.uplooking.dao;

import java.util.List;

import com.uplooking.pojo.Tbl_sj_goodsinfo;

public interface Tbl_sj_goodsinfoMapper {
	   
	 // ������
	List<Tbl_sj_goodsinfo> findAll();
	//  ����ĸ���ʼ  ÿҳ��ʾ����
	public List<Tbl_sj_goodsinfo> findPage(int pageNum,int pageSize);
	
	// ���ܼ�¼��
     int findCount();

}
