package com.uplooking.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uplooking.util.MybatisFactory;
import com.uplooking.dao.Tbl_sj_addressMapper;
import com.uplooking.pojo.Tbl_sj_address;

public class Tbl_sj_addressServiceImpl implements Tbl_sj_addressService {

	@Override
	public List<Tbl_sj_address> findAll(int memberid) {
		SqlSession session = MybatisFactory.getsqlsession();
		Tbl_sj_addressMapper tsam = session.getMapper(Tbl_sj_addressMapper.class);
		List<Tbl_sj_address> lists = tsam.findAll(memberid);
		MybatisFactory.close(session);
		return lists;
	}

}
