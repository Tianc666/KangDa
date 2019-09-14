/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : localhost:3306
 Source Schema         : crazyape

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 12/09/2019 10:42:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for excel
-- ----------------------------
DROP TABLE IF EXISTS `excel`;
CREATE TABLE `excel`  (
  `id` int(11) NOT NULL,
  `salmedicinename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售药品名',
  `salamount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salprice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `saldate` datetime(0) NULL DEFAULT NULL,
  `salname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of excel
-- ----------------------------
INSERT INTO `excel` VALUES (1, '阿莫西林', '15', '20', '2019-09-01 00:12:12', '王铁柱');
INSERT INTO `excel` VALUES (2, '康泰克', '16', '30', '2019-09-12 20:11:10', '翠花');
INSERT INTO `excel` VALUES (3, '牛黄解毒', '17', '20', '2019-09-30 22:10:12', '小赵');
INSERT INTO `excel` VALUES (4, '莲花清瘟', '18', '40', '2019-09-15 18:20:12', '祁德隆');
INSERT INTO `excel` VALUES (5, 'VC', '100', '69', '2019-09-21 15:12:15', '隆冬强');
INSERT INTO `excel` VALUES (6, '胃肠安', '19', '50', '2019-09-27 00:10:10', '金肛狼');

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine`  (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_medicineid` int(11) NULL DEFAULT NULL COMMENT '药品id',
  `m_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `m_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '货品状态（退货标识）',
  `m_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '药品价格',
  `m_inventory` int(11) NULL DEFAULT NULL COMMENT '库存',
  `m_pastdate` date NULL DEFAULT NULL COMMENT '过期时间',
  `m_classify` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品分类',
  `m_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注（添加进货退货信息纯文本记录）',
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES (1, 1, '阿莫西林', '2', 20.00, 10, '2019-09-05', '消炎药', '2019.9.1销售5；2019.9.5销售1；2019.9.6退货2');
INSERT INTO `medicine` VALUES (3, 3, '999感冒灵颗粒', '', 15.00, 1, '2020-09-12', '感冒药', NULL);
INSERT INTO `medicine` VALUES (4, 4, '阿司匹林', '', 55.00, 20, '2019-09-09', '感冒药', NULL);
INSERT INTO `medicine` VALUES (5, 5, '感冒清热冲剂', NULL, 15.00, 80, '2020-11-01', '感冒药', NULL);
INSERT INTO `medicine` VALUES (6, 6, '布洛芬', NULL, 10.00, 50, '2020-05-01', '感冒药', NULL);
INSERT INTO `medicine` VALUES (7, 7, '苯海拉明', '2', 15.00, 60, '2020-07-01', '感冒药', '2019.8.29退货1');
INSERT INTO `medicine` VALUES (8, 8, '黄连素片', NULL, 24.00, 30, '2019-11-01', '消化不良', NULL);
INSERT INTO `medicine` VALUES (9, 9, '吗丁啉', NULL, 23.00, 15, '2020-04-01', '消化不良', NULL);
INSERT INTO `medicine` VALUES (10, 10, '红霉素', '2', 15.00, 9, '2020-05-01', '抗菌药', '2019.9.6退货2');
INSERT INTO `medicine` VALUES (11, 11, '氟哌酸', NULL, 36.00, 20, '2020-12-11', '抗菌药', NULL);

-- ----------------------------
-- Table structure for salesmessage
-- ----------------------------
DROP TABLE IF EXISTS `salesmessage`;
CREATE TABLE `salesmessage`  (
  `sm_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '销售信息表id（主键）',
  `sm_medicineid` int(11) NULL DEFAULT NULL COMMENT '药品id',
  `sm_userid` int(11) NULL DEFAULT NULL COMMENT '关联用户id',
  `sm_data` datetime(0) NULL DEFAULT NULL COMMENT '销售时间',
  `sm_inventory` int(255) NULL DEFAULT NULL COMMENT '当前库存',
  PRIMARY KEY (`sm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of salesmessage
-- ----------------------------
INSERT INTO `salesmessage` VALUES (1, 11, 2, '2019-09-01 20:12:36', 3);
INSERT INTO `salesmessage` VALUES (2, 10, 3, '2019-09-02 21:12:36', 6);
INSERT INTO `salesmessage` VALUES (3, 9, 7, '2019-09-03 12:36:00', 1);
INSERT INTO `salesmessage` VALUES (4, 5, 3, '2019-09-04 20:12:36', 1);
INSERT INTO `salesmessage` VALUES (5, 7, 2, '2019-09-05 21:01:04', 6);
INSERT INTO `salesmessage` VALUES (6, 6, 7, '2019-09-06 21:12:36', 1);
INSERT INTO `salesmessage` VALUES (7, 4, 2, '2019-09-07 09:10:00', 15);
INSERT INTO `salesmessage` VALUES (8, 3, 7, '2019-09-08 20:12:36', 1);
INSERT INTO `salesmessage` VALUES (9, 2, 3, '2019-09-09 20:12:36', 9);
INSERT INTO `salesmessage` VALUES (10, 1, 2, '2019-09-10 21:12:10', 5);
INSERT INTO `salesmessage` VALUES (11, 3, 3, '2019-09-11 12:20:42', 11);
INSERT INTO `salesmessage` VALUES (12, 2, 7, '2019-09-12 20:01:04', 2);
INSERT INTO `salesmessage` VALUES (13, 2, 2, '2019-09-13 16:01:04', 13);
INSERT INTO `salesmessage` VALUES (14, 4, 7, '2019-09-14 15:01:04', 5);
INSERT INTO `salesmessage` VALUES (15, 6, 2, '2019-09-15 21:01:04', 55);
INSERT INTO `salesmessage` VALUES (16, 5, 3, '2019-09-16 21:01:04', 3);
INSERT INTO `salesmessage` VALUES (17, 7, 2, '2019-09-17 14:01:04', 2);
INSERT INTO `salesmessage` VALUES (18, 8, 3, '2019-09-18 10:01:04', 12);
INSERT INTO `salesmessage` VALUES (19, 9, 7, '2019-09-19 09:01:04', 43);
INSERT INTO `salesmessage` VALUES (20, 1, 3, '2019-09-20 15:01:04', 20);
INSERT INTO `salesmessage` VALUES (21, 1, 2, '2019-09-21 21:01:04', 13);
INSERT INTO `salesmessage` VALUES (22, 3, 2, '2019-09-22 21:01:04', 16);
INSERT INTO `salesmessage` VALUES (23, 5, 2, '2019-09-23 01:04:00', 26);
INSERT INTO `salesmessage` VALUES (24, 7, 3, '2019-09-24 21:01:04', 30);
INSERT INTO `salesmessage` VALUES (25, 8, 7, '2019-09-25 21:01:04', 1);
INSERT INTO `salesmessage` VALUES (26, 4, 2, '2019-09-26 15:01:04', 5);
INSERT INTO `salesmessage` VALUES (27, 6, 3, '2019-09-27 21:01:04', 9);
INSERT INTO `salesmessage` VALUES (28, 7, 2, '2019-09-28 16:01:04', 36);
INSERT INTO `salesmessage` VALUES (29, 2, 3, '2019-09-29 21:16:00', 24);
INSERT INTO `salesmessage` VALUES (30, 1, 3, '2019-09-30 21:16:07', 36);
INSERT INTO `salesmessage` VALUES (31, 11, 7, '2019-09-01 00:12:36', 9);
INSERT INTO `salesmessage` VALUES (32, 11, 2, '2019-09-01 11:12:39', 10);
INSERT INTO `salesmessage` VALUES (33, 10, 3, '2019-09-01 12:00:00', 10);
INSERT INTO `salesmessage` VALUES (34, 9, 3, '2019-09-01 11:13:22', 50);
INSERT INTO `salesmessage` VALUES (35, 8, 2, '2019-09-01 11:30:47', 10);
INSERT INTO `salesmessage` VALUES (36, 5, 3, '2019-09-07 11:28:48', 10);
INSERT INTO `salesmessage` VALUES (37, 7, 2, '2019-09-01 13:14:58', 100);
INSERT INTO `salesmessage` VALUES (40, 6, 7, '2019-09-01 15:22:30', 15);
INSERT INTO `salesmessage` VALUES (41, 7, 2, '2019-09-01 15:22:30', 15);
INSERT INTO `salesmessage` VALUES (42, 5, 2, '2019-09-01 15:22:30', 15);
INSERT INTO `salesmessage` VALUES (47, 7, 3, '2019-09-13 00:00:00', 20);
INSERT INTO `salesmessage` VALUES (48, 4, 3, '2019-09-10 00:00:00', 60);
INSERT INTO `salesmessage` VALUES (49, 3, 7, '2019-09-14 00:00:00', 67);
INSERT INTO `salesmessage` VALUES (50, 1, 3, '2019-09-21 06:02:30', 199);
INSERT INTO `salesmessage` VALUES (51, 3, 2, '2019-09-27 12:20:30', 123);
INSERT INTO `salesmessage` VALUES (52, 5, 7, '2019-09-10 20:12:45', 111);
INSERT INTO `salesmessage` VALUES (53, 6, 2, '2019-09-10 00:00:00', 199);
INSERT INTO `salesmessage` VALUES (54, 7, 3, '2019-09-04 23:34:55', 21);
INSERT INTO `salesmessage` VALUES (55, 7, 3, '2019-09-30 07:23:23', 76);
INSERT INTO `salesmessage` VALUES (56, 5, 2, '2019-09-22 04:22:00', 123);
INSERT INTO `salesmessage` VALUES (57, 11, 3, '2019-09-18 04:55:56', 32);
INSERT INTO `salesmessage` VALUES (58, 2, 2, '2019-09-21 15:25:26', 67);
INSERT INTO `salesmessage` VALUES (59, 1, 7, '2019-09-22 09:45:55', 36);
INSERT INTO `salesmessage` VALUES (60, 9, 2, '2019-09-11 16:01:42', 34);
INSERT INTO `salesmessage` VALUES (61, 8, 2, '2019-09-28 06:24:45', 68);
INSERT INTO `salesmessage` VALUES (62, 7, 7, '2019-09-08 06:34:23', 67);
INSERT INTO `salesmessage` VALUES (63, 6, 3, '2019-09-12 18:45:21', 23);
INSERT INTO `salesmessage` VALUES (64, 5, 7, '2019-09-30 05:22:54', 89);
INSERT INTO `salesmessage` VALUES (65, 3, 3, '2019-09-12 13:45:22', 89);
INSERT INTO `salesmessage` VALUES (66, 4, 2, '2019-09-08 17:33:23', 67);
INSERT INTO `salesmessage` VALUES (67, 5, 3, '2019-09-08 02:34:00', 45);
INSERT INTO `salesmessage` VALUES (68, 6, 3, '2019-09-10 08:12:13', 56);
INSERT INTO `salesmessage` VALUES (69, 7, 7, '2019-09-20 12:23:51', 86);
INSERT INTO `salesmessage` VALUES (70, 1, 2, '2019-09-19 21:44:34', 98);
INSERT INTO `salesmessage` VALUES (71, 6, 3, '2019-09-18 23:45:12', 67);
INSERT INTO `salesmessage` VALUES (72, 5, 3, '2019-09-11 03:45:32', 30);
INSERT INTO `salesmessage` VALUES (73, 7, 7, '2019-09-17 08:32:41', 89);
INSERT INTO `salesmessage` VALUES (74, 8, 2, '2019-09-19 03:56:56', 76);
INSERT INTO `salesmessage` VALUES (75, 6, 3, '2019-09-04 16:45:43', 67);
INSERT INTO `salesmessage` VALUES (76, 5, 3, '2019-09-18 17:45:43', 17);
INSERT INTO `salesmessage` VALUES (77, 8, 1, '2019-09-12 00:00:00', 500);

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`  (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '进货表id',
  `s_medicineid` int(11) NULL DEFAULT NULL COMMENT '进货药品id（关联medicine表）',
  `s_count` int(11) NULL DEFAULT NULL COMMENT '添加药品数量',
  `s_data` date NULL DEFAULT NULL COMMENT '添加药品时间',
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES (1, 5, 50, '2019-09-11');
INSERT INTO `stock` VALUES (2, 5, 50, '2019-09-12');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_limit` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '郭德纲', '1', 0);
INSERT INTO `user` VALUES (2, '于谦', '2', 2);
INSERT INTO `user` VALUES (3, 'rose', '1', 1);
INSERT INTO `user` VALUES (6, 'root', '1', 0);
INSERT INTO `user` VALUES (7, '哈哈哈', '1', 3);
INSERT INTO `user` VALUES (8, '小名', '1', NULL);
INSERT INTO `user` VALUES (10, '哆啦A梦', '2', NULL);
INSERT INTO `user` VALUES (11, '', '', NULL);
INSERT INTO `user` VALUES (12, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
