package com.uplooking.dao;

import java.util.List;

import com.uplooking.pojo.Tbl_ds_member;

public interface Tbl_ds_memberMapper {
	// 查询所有买家会员
     List<Tbl_ds_member> findAll();
}
