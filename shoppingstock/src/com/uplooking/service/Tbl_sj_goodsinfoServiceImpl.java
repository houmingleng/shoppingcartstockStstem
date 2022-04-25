package com.uplooking.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uplooking.dao.Tbl_sj_goodsinfoMapper;
import com.uplooking.pojo.Page;
import com.uplooking.pojo.Tbl_sj_goodsinfo;
import com.uplooking.util.MybatisFactory;

public class Tbl_sj_goodsinfoServiceImpl implements Tbl_sj_goodsinfoService{

	@Override
	public List<Tbl_sj_goodsinfo> findAll() {
		SqlSession session = MybatisFactory.getsqlsession();
		Tbl_sj_goodsinfoMapper tsgm = session.getMapper(Tbl_sj_goodsinfoMapper.class);
		List<Tbl_sj_goodsinfo> lists = tsgm.findAll();
		MybatisFactory.close(session);
		return lists;
	}

	@Override
	public Page findPage(int pageNum, int pageSize) {
		SqlSession session = MybatisFactory.getsqlsession();
		Tbl_sj_goodsinfoMapper tsgm = session.getMapper(Tbl_sj_goodsinfoMapper.class);
		List<Tbl_sj_goodsinfo> lists = tsgm.findPage((pageNum-1)*pageSize, pageSize);
        int count = tsgm.findCount();
        //通过三元运算符，算出总页数
        int pageCount = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        Page page = new Page(pageSize, pageNum, pageCount, count, lists);
		MybatisFactory.close(session);
        return page;
	}

}
