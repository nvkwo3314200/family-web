/*
Navicat MySQL Data Transfer

Source Server         : 192.168.11.188
Source Server Version : 50639
Source Host           : 192.168.11.188:3306
Source Database       : family_web

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-05-14 19:03:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for type_param
-- ----------------------------
DROP TABLE IF EXISTS `type_param`;
CREATE TABLE `type_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT '' COMMENT 'use_type; human_type; obj_type',
  `option` varchar(255) DEFAULT NULL,
  `key_word` varchar(255) DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type_param
-- ----------------------------
INSERT INTO `type_param` VALUES ('1', 'use_type', '日用品', '纸巾;洗衣;宝宝贴', null);
INSERT INTO `type_param` VALUES ('2', 'use_type', '电子用品', '电子', null);
INSERT INTO `type_param` VALUES ('3', 'use_type', '健身', '健身', null);
INSERT INTO `type_param` VALUES ('4', 'use_type', '服装', '服饰;服装;衣服;上衣;裤;鞋子;', null);
INSERT INTO `type_param` VALUES ('5', 'use_type', '玩具', '玩具;', null);
INSERT INTO `type_param` VALUES ('6', 'use_type', '儿童相关', '车;', null);
INSERT INTO `type_param` VALUES ('7', 'human_type', '男', '男', null);
INSERT INTO `type_param` VALUES ('8', 'human_type', '女', '女', null);
INSERT INTO `type_param` VALUES ('9', 'human_type', '儿童', '童', null);
INSERT INTO `type_param` VALUES ('10', 'obj_type', '口红', '口红', null);
INSERT INTO `type_param` VALUES ('11', 'use_type', '化妆品', '化妆;隔离霜;BB霜;CC霜;粉底液;眼影;眼线液;护唇膏;口红;唇彩;散粉;修容粉;腮红;妆', null);
INSERT INTO `type_param` VALUES ('12', 'use_type', '饰品', '耳环;耳坠;耳钉;耳罩;项链;项圈;丝巾;围巾;长毛衣链;胸针;胸花;胸章;腰链;腰带;腰巾;手镯;手链;臂环;戒指;指环;脚链;脚镯;钮扣;钥匙扣;手机链;手机挂饰;包饰;发夹;头花;发梳;发冠;发簪;发罩;发束', null);
