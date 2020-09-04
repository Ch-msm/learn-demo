/*
 Navicat Premium Data Transfer

 Source Server         : 我的mysql
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : ch-msm.top:62853
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 03/09/2020 17:58:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `gender` int(255) UNSIGNED NULL DEFAULT 0 COMMENT '性别：0 未知，1 男，2 女',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '省',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `loginTime` datetime(0) NULL DEFAULT NULL COMMENT '最后一次登录时间',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '加密后的密码',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE COMMENT '用户名唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
