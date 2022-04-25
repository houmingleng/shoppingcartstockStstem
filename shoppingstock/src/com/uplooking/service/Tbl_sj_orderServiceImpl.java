package com.uplooking.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uplooking.dao.Tbl_sj_orderMapper;
import com.uplooking.pojo.Tbl_sj_order;
import com.uplooking.util.MybatisFactory;

public class Tbl_sj_orderServiceImpl implements Tbl_sj_orderService {

	@Override
	public List<Tbl_sj_order> findAll() {
		SqlSession session = MybatisFactory.getsqlsession();
		Tbl_sj_orderMapper tsom = session.getMapper(Tbl_sj_orderMapper.class);
		List<Tbl_sj_order> lists = tsom.findAll();
		MybatisFactory.close(session);
		return lists;
	}

}
