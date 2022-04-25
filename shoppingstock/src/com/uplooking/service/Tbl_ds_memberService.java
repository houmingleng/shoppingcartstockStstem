package com.uplooking.service;

import java.util.List;

import com.uplooking.pojo.Tbl_ds_member;

public interface Tbl_ds_memberService {
	// 查询所有买家会员
    List<Tbl_ds_member> findAll();
}
