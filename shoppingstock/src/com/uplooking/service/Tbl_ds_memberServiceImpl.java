package com.uplooking.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uplooking.dao.Tbl_ds_memberMapper;
import com.uplooking.pojo.Tbl_ds_member;
import com.uplooking.util.MybatisFactory;

public class Tbl_ds_memberServiceImpl implements Tbl_ds_memberService {

	@Override
	public List<Tbl_ds_member> findAll() {
		SqlSession session = MybatisFactory.getsqlsession();
		Tbl_ds_memberMapper tdmm = session.getMapper(Tbl_ds_memberMapper.class);
		List<Tbl_ds_member> lists = tdmm.findAll();
		MybatisFactory.close(session);
		return lists;
	}

}
