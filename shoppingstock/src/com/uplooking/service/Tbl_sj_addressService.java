package com.uplooking.service;

import java.util.List;

import com.uplooking.pojo.Tbl_sj_address;

public interface Tbl_sj_addressService {
	//ͨ����¼�Ļ�Աid��ѯ������������ջ���ַ
    List<Tbl_sj_address> findAll(int memberid);
}
