/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : xiangmubiao

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 31/10/2019 16:52:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_ds_address
-- ----------------------------
DROP TABLE IF EXISTS `tbl_ds_address`;
CREATE TABLE `tbl_ds_address`  (
  `addrid` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) NULL DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stat` int(11) NULL DEFAULT 0,
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`addrid`) USING BTREE,
  INDEX `address_memberid`(`memberid`) USING BTREE,
  CONSTRAINT `fk_08` FOREIGN KEY (`memberid`) REFERENCES `tbl_ds_member` (`memberid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_ds_goodsinfo
-- ----------------------------
DROP TABLE IF EXISTS `tbl_ds_goodsinfo`;
CREATE TABLE `tbl_ds_goodsinfo`  (
  `goodsid` int(11) NOT NULL AUTO_INCREMENT,
  `entflag` bigint(20) NULL DEFAULT NULL,
  `spflag` bigint(20) NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `typeid` int(11) NULL DEFAULT NULL,
  `price` float NULL DEFAULT NULL,
  `place` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `makedate` datetime(0) NULL,
  `amount` int(255) NULL DEFAULT NULL,
  `unit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `color` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`goodsid`) USING BTREE,
  INDEX `tbl_typeid`(`typeid`) USING BTREE,
  INDEX `tbl_en`(`entflag`) USING BTREE,
  INDEX `spflag`(`spflag`) USING BTREE,
  CONSTRAINT `fk_06` FOREIGN KEY (`entflag`) REFERENCES `tbl_ds_seller` (`entflag`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_07` FOREIGN KEY (`typeid`) REFERENCES `tbl_ds_goodstype` (`typeid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_ds_goodstype
-- ----------------------------
DROP TABLE IF EXISTS `tbl_ds_goodstype`;
CREATE TABLE `tbl_ds_goodstype`  (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`typeid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_ds_member
-- ----------------------------
DROP TABLE IF EXISTS `tbl_ds_member`;
CREATE TABLE `tbl_ds_member`  (
  `memberid` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logpwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `regdate` datetime(6) NULL DEFAULT NULL,
  `place` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stat` int(11) NULL DEFAULT 0,
  `score` int(11) NULL DEFAULT NULL,
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`memberid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_ds_member
-- ----------------------------
INSERT INTO `tbl_ds_member` VALUES (1, 'root', '1234', '???', '??????', '12344124123', '2019-10-29 16:00:00.000000', '??????', 0, 1000, '??????????????????');
INSERT INTO `tbl_ds_member` VALUES (2, 'aaa', '123', '???', '??????', '123123', '2019-10-09 14:32:03.000000', '??????', 0, 500, '?????????');
INSERT INTO `tbl_ds_member` VALUES (3, 'bbb', '123', '???', '??????', '888545412', '2019-10-08 14:33:03.000000', '??????', 0, 0, '?????????');
INSERT INTO `tbl_ds_member` VALUES (4, 'ccc', '123', '???', '??????', '6668596', '2019-10-29 14:33:07.000000', '??????', 0, 0, '?????????');
INSERT INTO `tbl_ds_member` VALUES (5, 'ddd', '123', '???', '??????', '2442908', '2019-10-31 14:33:10.000000', '??????', 0, 0, '?????????');

-- ----------------------------
-- Table structure for tbl_ds_order
-- ----------------------------
DROP TABLE IF EXISTS `tbl_ds_order`;
CREATE TABLE `tbl_ds_order`  (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `orderflag` bigint(20) NULL DEFAULT NULL,
  `sellerid` bigint(20) NULL DEFAULT NULL,
  `orderdate` datetime(0) NULL,
  `memberid` int(11) NOT NULL,
  `stat` int(11) NOT NULL DEFAULT 1,
  `push` bit(1) NULL DEFAULT b'0',
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE,
  INDEX `tbl_sell`(`sellerid`) USING BTREE,
  INDEX `tbl_me`(`memberid`) USING BTREE,
  INDEX `orderflag`(`orderflag`) USING BTREE,
  CONSTRAINT `fk_09` FOREIGN KEY (`memberid`) REFERENCES `tbl_ds_member` (`memberid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_10` FOREIGN KEY (`sellerid`) REFERENCES `tbl_ds_seller` (`entflag`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_ds_orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `tbl_ds_orderdetail`;
CREATE TABLE `tbl_ds_orderdetail`  (
  `detailid` int(11) NOT NULL AUTO_INCREMENT,
  `orderflag` bigint(20) NOT NULL,
  `spflag` bigint(20) NOT NULL,
  `salecount` int(11) NOT NULL,
  `stat` int(11) NOT NULL DEFAULT 0,
  `disct` float NULL DEFAULT 1,
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`detailid`) USING BTREE,
  INDEX `tbl_or`(`orderflag`) USING BTREE,
  INDEX `tbl_sp`(`spflag`) USING BTREE,
  CONSTRAINT `fk_11` FOREIGN KEY (`orderflag`) REFERENCES `tbl_ds_order` (`orderflag`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_12` FOREIGN KEY (`spflag`) REFERENCES `tbl_ds_goodsinfo` (`spflag`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_ds_seller
-- ----------------------------
DROP TABLE IF EXISTS `tbl_ds_seller`;
CREATE TABLE `tbl_ds_seller`  (
  `recordid` int(11) NOT NULL AUTO_INCREMENT,
  `entname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `entflag` bigint(20) NOT NULL,
  `token` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `servicepath` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' ',
  `stat` int(11) NOT NULL,
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`recordid`) USING BTREE,
  INDEX `entflag`(`entflag`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_sj_address
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sj_address`;
CREATE TABLE `tbl_sj_address`  (
  `addrid` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) NOT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `zip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stat` int(11) NULL DEFAULT 0,
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`addrid`) USING BTREE,
  INDEX `tbl_mberid`(`memberid`) USING BTREE,
  CONSTRAINT `fk_02` FOREIGN KEY (`memberid`) REFERENCES `tbl_sj_member` (`memberid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_sj_address
-- ----------------------------
INSERT INTO `tbl_sj_address` VALUES (1, 1, '???????????????', '448000', 0, '??????????????????????????????');
INSERT INTO `tbl_sj_address` VALUES (2, 1, '??????', '420800', 0, '??????????????????????????????');
INSERT INTO `tbl_sj_address` VALUES (3, 2, '??????', '330000', 0, '??????????????????????????????');

-- ----------------------------
-- Table structure for tbl_sj_goodsinfo
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sj_goodsinfo`;
CREATE TABLE `tbl_sj_goodsinfo`  (
  `goodsid` int(11) NOT NULL AUTO_INCREMENT,
  `spflag` bigint(20) NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `typeid` int(11) NULL DEFAULT NULL,
  `price` float(50, 0) NULL DEFAULT NULL,
  `make` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `makedate` datetime(0) NULL,
  `amount` int(11) NULL DEFAULT NULL,
  `stat` int(11) NULL DEFAULT 0,
  `unit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `color` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`goodsid`) USING BTREE,
  INDEX `goodsinfo_typeid`(`typeid`) USING BTREE,
  INDEX `spflag`(`spflag`) USING BTREE,
  CONSTRAINT `fk_01` FOREIGN KEY (`typeid`) REFERENCES `tbl_sj_goodstype` (`typeid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_sj_goodsinfo
-- ----------------------------
INSERT INTO `tbl_sj_goodsinfo` VALUES (1, 123, 'DSP??????', 1, 499, '??????', '2019-10-30 14:09:39', 52, 1, '???', '50*60*40', '???,???', '??????????????????');
INSERT INTO `tbl_sj_goodsinfo` VALUES (2, 124, 'DSP??????', 1, 549, '??????', '2019-10-30 14:12:16', 404, 1, '???', '50*60*60', '???,???', '??????????????????');
INSERT INTO `tbl_sj_goodsinfo` VALUES (3, 125, 'DSP??????', 3, 699, '??????', '2019-10-30 14:13:05', 88, 1, '???', '50*40', '???,???,???', '??????????????????');
INSERT INTO `tbl_sj_goodsinfo` VALUES (4, 126, '????????????', 2, 399, '??????', '2019-10-30 14:14:40', 99, 0, '???', '42', '???,???', '??????????????????');
INSERT INTO `tbl_sj_goodsinfo` VALUES (5, 127, 'Nike??????', 1, 1499, '??????', '2019-10-30 14:09:39', 88, 0, '???', '50*60*40', '???,???', '??????????????????');
INSERT INTO `tbl_sj_goodsinfo` VALUES (6, 128, 'Nike??????', 1, 1549, '??????', '2019-10-30 14:12:16', 100, 1, '???', '50*60*60', '???,???', '??????????????????');
INSERT INTO `tbl_sj_goodsinfo` VALUES (7, 129, 'DSP????????????', 1, 1699, '??????', '2019-10-30 14:13:05', 88, 1, '???', '55*65*70', '???,???,???', '??????????????????');
INSERT INTO `tbl_sj_goodsinfo` VALUES (8, 130, 'Nike-AJ10', 2, 4399, '??????', '2019-10-30 14:14:40', 10, 1, '???', '42', '???,???', '??????????????????');
INSERT INTO `tbl_sj_goodsinfo` VALUES (9, 131, 'adidas??????', 1, 799, '??????', '2019-10-30 14:09:39', 88, 1, '???', '50*60*40', '???,???', '??????????????????');
INSERT INTO `tbl_sj_goodsinfo` VALUES (10, 132, 'adidas??????', 1, 649, '??????', '2019-10-30 14:12:16', 120, 0, '???', '50*60*60', '???,???', '??????????????????');
INSERT INTO `tbl_sj_goodsinfo` VALUES (11, 133, 'Nike????????????', 1, 3699, '??????', '2019-10-30 14:13:05', 28, 1, '???', '55*65*70', '???,???,???', '??????????????????');
INSERT INTO `tbl_sj_goodsinfo` VALUES (12, 134, 'LV??????', 3, 43399, '??????', '2019-10-30 14:14:40', 99, 1, '???', '40*20*20', '???,???,???,???', '??????????????????');

-- ----------------------------
-- Table structure for tbl_sj_goodstype
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sj_goodstype`;
CREATE TABLE `tbl_sj_goodstype`  (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`typeid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_sj_goodstype
-- ----------------------------
INSERT INTO `tbl_sj_goodstype` VALUES (1, '??????', '??????????????????');
INSERT INTO `tbl_sj_goodstype` VALUES (2, '??????', '??????????????????');
INSERT INTO `tbl_sj_goodstype` VALUES (3, '?????????', '?????????????????????');

-- ----------------------------
-- Table structure for tbl_sj_member
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sj_member`;
CREATE TABLE `tbl_sj_member`  (
  `memberid` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logpwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `regdate` datetime(0) NULL,
  `place` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stat` int(11) NULL DEFAULT 0,
  `score` int(11) NULL DEFAULT NULL,
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`memberid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_sj_member
-- ----------------------------
INSERT INTO `tbl_sj_member` VALUES (1, 'admin', '123', '???', '??????', '12344124', '2019-10-29 16:00:00', '??????', 0, 100, '??????????????????');
INSERT INTO `tbl_sj_member` VALUES (2, 'qqq', 'qqq', '???', '??????', '555512', '2019-10-29 16:00:00', '??????', 0, 0, '???????????????????????????');

-- ----------------------------
-- Table structure for tbl_sj_order
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sj_order`;
CREATE TABLE `tbl_sj_order`  (
  `orderid` int(11) NOT NULL,
  `orderflag` bigint(255) NULL DEFAULT NULL,
  `orderdate` datetime(0) NULL DEFAULT NULL,
  `memberid` int(11) NULL DEFAULT NULL,
  `stat` int(11) NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE,
  INDEX `orderflag`(`orderflag`) USING BTREE,
  INDEX `wj_18`(`memberid`) USING BTREE,
  CONSTRAINT `wj_18` FOREIGN KEY (`memberid`) REFERENCES `tbl_ds_member` (`memberid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_sj_order
-- ----------------------------
INSERT INTO `tbl_sj_order` VALUES (1, 520, '2019-10-16 14:25:50', 1, 1, '???????????????');
INSERT INTO `tbl_sj_order` VALUES (2, 521, '2019-10-22 14:27:52', 3, 5, '???????????????');
INSERT INTO `tbl_sj_order` VALUES (3, 522, '2019-10-12 14:28:17', 2, 1, '???????????????');
INSERT INTO `tbl_sj_order` VALUES (4, 523, '2019-10-16 14:36:06', 5, 1, '?????????');
INSERT INTO `tbl_sj_order` VALUES (5, 524, '2019-10-19 14:36:10', 4, 1, '?????????');

-- ----------------------------
-- Table structure for tbl_sj_orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sj_orderdetail`;
CREATE TABLE `tbl_sj_orderdetail`  (
  `detailid` int(11) NOT NULL AUTO_INCREMENT,
  `orderflag` bigint(20) NOT NULL,
  `spflag` bigint(20) NOT NULL,
  `salecount` int(11) NOT NULL,
  `stat` int(11) NOT NULL DEFAULT 0,
  `disct` float NULL DEFAULT 1,
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`detailid`) USING BTREE,
  INDEX `orderflag_tab2222`(`orderflag`) USING BTREE,
  INDEX `tbl_sf`(`spflag`) USING BTREE,
  CONSTRAINT `fk_04` FOREIGN KEY (`orderflag`) REFERENCES `tbl_sj_order` (`orderflag`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_05` FOREIGN KEY (`spflag`) REFERENCES `tbl_sj_goodsinfo` (`spflag`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_sj_orderdetail
-- ----------------------------
INSERT INTO `tbl_sj_orderdetail` VALUES (1, 520, 123, 10, 0, 1, '?????????????????????');
INSERT INTO `tbl_sj_orderdetail` VALUES (2, 523, 129, 20, 0, 1, '2');
INSERT INTO `tbl_sj_orderdetail` VALUES (3, 522, 130, 11, 0, 1, '3');
INSERT INTO `tbl_sj_orderdetail` VALUES (4, 521, 126, 55, 0, 1, '4');
INSERT INTO `tbl_sj_orderdetail` VALUES (5, 524, 128, 35, 0, 1, '5');

SET FOREIGN_KEY_CHECKS = 1;
