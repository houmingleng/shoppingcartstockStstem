package com.uplooking.dao;

import java.util.List;

import com.uplooking.pojo.Tbl_sj_address;

public interface Tbl_sj_addressMapper {
	 //ͨ����¼�Ļ�Աid��ѯ������������ջ���ַ
     List<Tbl_sj_address> findAll(int memberid);
}
