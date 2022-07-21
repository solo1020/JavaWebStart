/*
Navicat MySQL Data Transfer

Source Server         : docker-localhost
Source Server Version : 50736
Source Host           : 127.0.0.1:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50736
File Encoding         : 65001

Date: 2022-06-12 00:38:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `money` double(7,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'zhangsan', '5000.00');
INSERT INTO `account` VALUES ('2', 'wangwu', '1000.00');
INSERT INTO `account` VALUES ('3', 'tom', '13000.00');
INSERT INTO `account` VALUES ('4', 'jerry', '500.00');
INSERT INTO `account` VALUES ('6', 'spring annotation', '11111.00');

-- ----------------------------
-- Table structure for `springboot_user`
-- ----------------------------
DROP TABLE IF EXISTS `springboot_user`;
CREATE TABLE `springboot_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of springboot_user
-- ----------------------------
INSERT INTO `springboot_user` VALUES ('1', 'zhangsan', '123');
INSERT INTO `springboot_user` VALUES ('2', 'lisi', '234');

-- ----------------------------
-- Table structure for `springcloud_order`
-- ----------------------------
DROP TABLE IF EXISTS `springcloud_order`;
CREATE TABLE `springcloud_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `number` int(11) DEFAULT NULL COMMENT '数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '总额',
  `product_name` varchar(40) DEFAULT NULL COMMENT '商品名',
  `username` varchar(40) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of springcloud_order
-- ----------------------------

-- ----------------------------
-- Table structure for `springcloud_product`
-- ----------------------------
DROP TABLE IF EXISTS `springcloud_product`;
CREATE TABLE `springcloud_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(40) DEFAULT NULL COMMENT '名称',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `product_desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `caption` varchar(255) DEFAULT NULL COMMENT '标题',
  `inventory` int(11) DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of springcloud_product
-- ----------------------------

-- ----------------------------
-- Table structure for `springcloud_user`
-- ----------------------------
DROP TABLE IF EXISTS `springcloud_user`;
CREATE TABLE `springcloud_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) DEFAULT NULL COMMENT '用户名',
  `password` varchar(40) DEFAULT NULL COMMENT '密码',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `balance` decimal(10,2) DEFAULT NULL COMMENT '余额',
  `address` varchar(80) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of springcloud_user
-- ----------------------------
