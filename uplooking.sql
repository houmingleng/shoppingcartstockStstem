/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : 127.0.0.1:3306
Source Database       : uplooking

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2018-06-26 16:33:00
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tbl_up_goodsinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_up_goodsinfo`;
CREATE TABLE `tbl_up_goodsinfo` (
  `goodsid` int(11) NOT NULL auto_increment,
  `spflag` varchar(50) default NULL,
  `name` varchar(50) default NULL,
  `typeid` int(11) default NULL,
  `price` float default NULL,
  `place` varchar(50) default NULL,
  `makedate` datetime default NULL,
  `amount` int(11) default NULL,
  `stat` int(11) default NULL,
  `color` varchar(30) default NULL,
  PRIMARY KEY  (`goodsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_up_goodsinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_up_goodstype`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_up_goodstype`;
CREATE TABLE `tbl_up_goodstype` (
  `typeid` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `desc` varchar(50) default NULL,
  PRIMARY KEY  (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_up_goodstype
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_up_order`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_up_order`;
CREATE TABLE `tbl_up_order` (
  `orderid` int(11) NOT NULL auto_increment,
  `orderflag` varchar(50) default NULL,
  `orderdate` datetime default NULL,
  `customer` varchar(30) default NULL,
  `stat` int(11) default NULL,
  `note` varchar(100) default NULL,
  PRIMARY KEY  (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_up_order
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_up_orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_up_orderdetail`;
CREATE TABLE `tbl_up_orderdetail` (
  `detailid` int(11) NOT NULL auto_increment,
  `orderflag` varchar(50) default NULL,
  `spflag` varchar(255) default NULL,
  `salecount` int(11) default NULL,
  `stat` int(11) default NULL,
  `disct` float default NULL,
  PRIMARY KEY  (`detailid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_up_orderdetail
-- ----------------------------
