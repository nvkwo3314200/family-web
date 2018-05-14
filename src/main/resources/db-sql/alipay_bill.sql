/*
Navicat MySQL Data Transfer

Source Server         : 192.168.11.188
Source Server Version : 50639
Source Host           : 192.168.11.188:3306
Source Database       : family_web

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-05-14 17:40:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for alipay_bill
-- ----------------------------
DROP TABLE IF EXISTS `alipay_bill`;
CREATE TABLE `alipay_bill` (
  `id` int(11) DEFAULT NULL,
  `transaction_id` varchar(255) NOT NULL,
  `shop_order_id` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `pay_date` datetime DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `counterparty` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `amount` float(7,3) DEFAULT NULL,
  `income_expenses` varchar(255) DEFAULT NULL,
  `trade_status` varchar(255) DEFAULT NULL,
  `service_charge` float(7,3) DEFAULT NULL,
  `refund` varchar(255) DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `funded_status` varchar(255) DEFAULT NULL,
  `use_type` varchar(255) DEFAULT NULL,
  `human_type` varchar(255) DEFAULT NULL,
  `obj_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
