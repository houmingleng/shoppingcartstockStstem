package com.uplooking.dao;

import java.util.List;

import com.uplooking.pojo.Tbl_sj_address;

public interface Tbl_sj_addressMapper {
	 //通过登录的会员id查询它下面的所有收货地址
     List<Tbl_sj_address> findAll(int memberid);
}
