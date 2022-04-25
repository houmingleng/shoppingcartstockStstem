package com.uplooking.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uplooking.dao.Tbl_sj_orderdetailMapper;
import com.uplooking.pojo.Tbl_sj_order;
import com.uplooking.pojo.Tbl_sj_orderdetail;
import com.uplooking.util.MybatisFactory;

public class Tbl_sj_orderdetailServiceImpl implements Tbl_sj_orderdetailService{

	@Override
	public List<Tbl_sj_orderdetail> findAll() {
		SqlSession session = MybatisFactory.getsqlsession();
		Tbl_sj_orderdetailMapper tsom = session.getMapper(Tbl_sj_orderdetailMapper.class);
		List<Tbl_sj_orderdetail> lists = tsom.findAll();
		MybatisFactory.close(session);
		return lists;
	}

}
