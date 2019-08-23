/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : 127.0.0.1:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 23/08/2019 13:21:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL COMMENT '学生id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '学生姓名',
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '学生密码',
  `cid` int(11) NULL DEFAULT NULL COMMENT '班级id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '八戒', '234', 1);
INSERT INTO `student` VALUES (2, '悟空', '234', 1);
INSERT INTO `student` VALUES (3, '沙僧', '234', 1);
INSERT INTO `student` VALUES (4, '唐僧', '234', 1);
INSERT INTO `student` VALUES (5, '刘德华', '123', 1);
INSERT INTO `student` VALUES (7, '王宝强', '123', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `birth` date NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `statu` int(255) NULL DEFAULT 0,
  `regTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '刘飞', '123456', '2019-08-12', '男', '304265966@qq.com', 0, '2019-08-12 18:17:46');
INSERT INTO `user` VALUES (2, '李飞', '123456', '2019-08-06', '男', '304265966@qq.com', 0, '2019-08-12 18:18:24');
INSERT INTO `user` VALUES (3, '静静', '123456', '2019-08-05', '女', '304265966@qq.com', 0, '2019-08-12 18:19:11');
INSERT INTO `user` VALUES (4, '晓华', '123456', '2019-08-08', '女', '304265966@qq.com', 0, '2019-08-12 18:19:39');
INSERT INTO `user` VALUES (5, '李四', '123456', '2019-08-01', '男', '304265966@qq.com', 0, '2019-08-12 18:20:07');
INSERT INTO `user` VALUES (6, '张三', '123456', '2019-08-03', '男', '304265966@qq.com', 0, '2019-08-08 18:20:36');

SET FOREIGN_KEY_CHECKS = 1;
