package com.uplooking.service;

import java.util.List;

import com.uplooking.pojo.Tbl_sj_order;

public interface Tbl_sj_orderService {
	// 查询所有订单列表
    List<Tbl_sj_order> findAll();
}
