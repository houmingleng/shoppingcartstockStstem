/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : 127.0.0.1:3306
Source Database       : jd

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2018-06-26 16:33:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tbl_jd_goodstype`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_jd_goodstype`;
CREATE TABLE `tbl_jd_goodstype` (
  `typeid` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `desc` varchar(50) default NULL,
  PRIMARY KEY  (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_jd_goodstype
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_jd_seller`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_jd_seller`;
CREATE TABLE `tbl_jd_seller` (
  `recordid` int(11) NOT NULL auto_increment,
  `entname` varchar(30) default NULL,
  `entflag` varchar(50) default NULL,
  `token` varchar(50) default NULL,
  `stat` int(11) default NULL,
  PRIMARY KEY  (`recordid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_jd_seller
-- ----------------------------
