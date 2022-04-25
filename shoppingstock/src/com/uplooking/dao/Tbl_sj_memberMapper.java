package com.uplooking.dao;

import java.util.List;

import com.uplooking.pojo.Tbl_sj_member;

public interface Tbl_sj_memberMapper {
	  // 注册增加用户
       int add(Tbl_sj_member tdm);
       //判断用户名是否已存在
       Tbl_sj_member findOne(String account);
       //遍历所有会员信息
       List<Tbl_sj_member> findAll();
       //修改当前登录的会员个人信息
       int update(Tbl_sj_member tbl);
}
