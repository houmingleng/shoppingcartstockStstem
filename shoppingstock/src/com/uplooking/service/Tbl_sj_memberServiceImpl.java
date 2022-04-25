package com.uplooking.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uplooking.dao.Tbl_sj_memberMapper;
import com.uplooking.pojo.Tbl_sj_member;
import com.uplooking.util.MybatisFactory;

public class Tbl_sj_memberServiceImpl implements Tbl_sj_memberService {

	@Override
	public int add(Tbl_sj_member tdm) {
		SqlSession session = MybatisFactory.getsqlsession();
		Tbl_sj_memberMapper tdmm = session.getMapper(Tbl_sj_memberMapper.class);
		int i = tdmm.add(tdm);
		session.commit();
		MybatisFactory.close(session);
		return i;
		
	}

	@Override
	public Tbl_sj_member findOne(String account) {
		SqlSession session = MybatisFactory.getsqlsession();
		Tbl_sj_memberMapper tdmm = session.getMapper(Tbl_sj_memberMapper.class);
		Tbl_sj_member tdm = tdmm.findOne(account);
		MybatisFactory.close(session);
		return tdm;
	}

	@Override
	public List<Tbl_sj_member> findAll() {
		SqlSession session = MybatisFactory.getsqlsession();
		Tbl_sj_memberMapper tdmm = session.getMapper(Tbl_sj_memberMapper.class);
        List<Tbl_sj_member> lists = tdmm.findAll();
        MybatisFactory.close(session);
		return lists;
	}

	@Override
	public int update(Tbl_sj_member tbl) {
		SqlSession session = MybatisFactory.getsqlsession();
		Tbl_sj_memberMapper tdmm = session.getMapper(Tbl_sj_memberMapper.class);
        int i = tdmm.update(tbl);
		session.commit();
        MybatisFactory.close(session);
		return i;
	}


}
