package com.uplooking.dao;

import java.util.List;

import com.uplooking.pojo.Tbl_sj_member;

public interface Tbl_sj_memberMapper {
	  // ע�������û�
       int add(Tbl_sj_member tdm);
       //�ж��û����Ƿ��Ѵ���
       Tbl_sj_member findOne(String account);
       //�������л�Ա��Ϣ
       List<Tbl_sj_member> findAll();
       //�޸ĵ�ǰ��¼�Ļ�Ա������Ϣ
       int update(Tbl_sj_member tbl);
}
