/*
 Navicat Premium Data Transfer

 Source Server         : 房屋
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : house

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 05/06/2023 23:31:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_lessee
-- ----------------------------
DROP TABLE IF EXISTS `tb_lessee`;
CREATE TABLE `tb_lessee`  (
  `lesseeID` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `lesseeSEX` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '性别',
  `lesseeNAME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '姓名',
  `lesseeAGE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '年龄',
  `lesseeMoney` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '租金',
  `lesseeTime` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '租房时间',
  PRIMARY KEY (`lesseeID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_lessee
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `User_name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `Password_` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户密码',
  `IsLogin` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否登录',
  PRIMARY KEY (`User_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('123', '456789', b'0');
INSERT INTO `tb_user` VALUES ('147', '222', b'0');
INSERT INTO `tb_user` VALUES ('159', '4561', b'0');
INSERT INTO `tb_user` VALUES ('520', '1236', b'0');
INSERT INTO `tb_user` VALUES ('753', '1234', b'0');

SET FOREIGN_KEY_CHECKS = 1;
