package com.uplooking.dao;

import java.util.List;

import com.uplooking.pojo.Tbl_sj_order;

public interface Tbl_sj_orderMapper {
	// 查询所有订单列表
     List<Tbl_sj_order> findAll();
}
