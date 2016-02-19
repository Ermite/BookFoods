/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : bookfoods

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-11-05 21:51:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cusername` varchar(50) DEFAULT NULL COMMENT '用户名',
  `cpassword` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `cemail` varchar(50) DEFAULT NULL COMMENT '用户Email',
  `ctype` int(11) DEFAULT '1' COMMENT '用户类型',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES ('1', 'gyj', '123123', '233@qq.com', '1');
INSERT INTO `customers` VALUES ('2', 'tyy', '123123', '239@qq.com', '1');
INSERT INTO `customers` VALUES ('3', 'aaa', 'aaaaaa', 'aa@qq.com', '1');
INSERT INTO `customers` VALUES ('4', 'qq', 'qqqqqq', 'q@q.q', '1');
INSERT INTO `customers` VALUES ('5', '111', '222222', '111@222.com', '1');
INSERT INTO `customers` VALUES ('6', 'ttt', '123456', '230@qq.com', '1');
INSERT INTO `customers` VALUES ('7', 'tttyy', '123456', '111@qq.com', '1');
INSERT INTO `customers` VALUES ('8', 'wang1', '123123', '123@qq.com', '1');
INSERT INTO `customers` VALUES ('12', 'wang2', '123123', '1232@qq.com', '1');
INSERT INTO `customers` VALUES ('13', 'wang3', '123123', 'wang3@qq.com', '1');
INSERT INTO `customers` VALUES ('16', 'wang4', '123123', 'wang4@qq.com', '1');
INSERT INTO `customers` VALUES ('18', 'wang5', '123123', 'wang5@qq.com', '1');
INSERT INTO `customers` VALUES ('19', 'wang6', '123123', 'wang6@qq.com', '1');

-- ----------------------------
-- Table structure for foods
-- ----------------------------
DROP TABLE IF EXISTS `foods`;
CREATE TABLE `foods` (
  `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT '食物id',
  `fname` varchar(50) DEFAULT NULL COMMENT '食物名称',
  `fnumber` int(11) DEFAULT '100' COMMENT '库存',
  `fimg` varchar(50) DEFAULT NULL COMMENT '食物图片描述',
  `fprice` double(10,2) DEFAULT '10.00' COMMENT '价格',
  `fsale` int(11) DEFAULT '0' COMMENT '食物销售量',
  `mid` int(11) DEFAULT NULL COMMENT '菜单id',
  `fdelivery_type` int(11) DEFAULT '0' COMMENT '配送类型（0 免费，1 收费）',
  `fcharge` double(10,2) DEFAULT '1.00' COMMENT '配送费',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of foods
-- ----------------------------
INSERT INTO `foods` VALUES ('1', '热狗', '100', '1a.jpg', '20.00', '5', '4', '1', '1.00');
INSERT INTO `foods` VALUES ('2', '热狗2', '100', '1p.jpg', '20.00', '5', '4', '1', '1.00');
INSERT INTO `foods` VALUES ('3', '鱼香肉丝', '100', '11a.jpg', '21.00', '2', '5', '1', '1.00');
INSERT INTO `foods` VALUES ('4', '宫保鸡丁', '100', '22a.jpg', '22.00', '3', '5', '0', '1.00');
INSERT INTO `foods` VALUES ('5', '水煮肉片', '100', '33a.jpg', '23.00', '2', '6', '0', '1.00');
INSERT INTO `foods` VALUES ('6', '过油肉', '100', '44a.jpg', '19.00', '2', '6', '0', '1.00');
INSERT INTO `foods` VALUES ('7', '好吃的1', '123', '3p.png', '23.00', '6', '6', '0', '1.00');
INSERT INTO `foods` VALUES ('8', '好吃的2', '110', '5664ced3f1f12be0cf5d00cc6d03e5fd374673.jpg', '23.00', '6', '6', '0', '1.00');
INSERT INTO `foods` VALUES ('9', '好吃的3', '10', '5aa684f66f9c1812664e3932bcc2ee0482162.jpg', '22.00', '6', '5', '0', '1.00');
INSERT INTO `foods` VALUES ('10', '热狗', '10', '1a.jpg', '12.00', '1', '1', '0', '1.00');
INSERT INTO `foods` VALUES ('11', '热狗2', '10', '1p.jpg', '12.00', '1', '1', '0', '1.00');
INSERT INTO `foods` VALUES ('12', '鱼香肉丝', '100', '11a.jpg', '10.00', '0', '2', '0', '1.00');
INSERT INTO `foods` VALUES ('13', '测试1', '100', '__29669409__9570296.jpg', '10.00', '0', '1', '0', '1.00');
INSERT INTO `foods` VALUES ('14', '测试2', '100', '__48236677__1250479.jpg', '10.00', '0', '1', '0', '1.00');
INSERT INTO `foods` VALUES ('15', '美味1', '100', '1.jpg', '10.00', '0', '1', '0', '1.00');
INSERT INTO `foods` VALUES ('16', '美味2', '100', '10b.jpg', '10.00', '0', '1', '0', '1.00');
INSERT INTO `foods` VALUES ('17', '美味3', '100', '3.jpg', '10.00', '0', '1', '0', '1.00');
INSERT INTO `foods` VALUES ('18', '美味4', '100', '4.jpg', '10.00', '0', '1', '0', '1.00');
INSERT INTO `foods` VALUES ('19', '美味5', '100', '4b.jpg', '10.00', '0', '2', '0', '1.00');
INSERT INTO `foods` VALUES ('20', '美味6', '100', 'hj.jpg', '10.00', '0', '2', '0', '1.00');
INSERT INTO `foods` VALUES ('21', '美味7', '100', 'f1a7337d4ffb0b42717586a45a90b255148504.jpg', '10.00', '0', '2', '0', '1.00');
INSERT INTO `foods` VALUES ('22', '美味8', '100', 'wogas.jpg', '10.00', '0', '2', '0', '1.00');

-- ----------------------------
-- Table structure for menus
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `mtype` int(11) DEFAULT '1' COMMENT '菜单类型',
  `rid` int(11) DEFAULT NULL COMMENT '餐厅ID',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES ('1', '热狗', '1', '1');
INSERT INTO `menus` VALUES ('2', '家常菜', '1', '1');
INSERT INTO `menus` VALUES ('3', '热菜', '1', '1');
INSERT INTO `menus` VALUES ('4', '热狗', '1', '6');
INSERT INTO `menus` VALUES ('5', '家常菜', '1', '6');
INSERT INTO `menus` VALUES ('6', '热菜', '1', '6');

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '留言id',
  `cname` varchar(50) DEFAULT NULL COMMENT '留言人姓名',
  `cemail` varchar(50) DEFAULT NULL COMMENT '留言人Email',
  `message_info` varchar(50) DEFAULT NULL COMMENT '留言内容',
  `cphone` int(11) DEFAULT NULL COMMENT '电话',
  `cityname` varchar(50) DEFAULT NULL COMMENT '留言人所在城市',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES ('1', '田亚英', 'ben@dan.com', '我是田亚英！！我就是就是就是就是田亚英！！', '7474741', '太原');
INSERT INTO `messages` VALUES ('2', '123', '123@qq.com', '1223323', '123456', '太原');

-- ----------------------------
-- Table structure for restaurants
-- ----------------------------
DROP TABLE IF EXISTS `restaurants`;
CREATE TABLE `restaurants` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '餐厅id',
  `rname` varchar(50) DEFAULT NULL COMMENT '餐厅名称',
  `rlocation` varchar(50) DEFAULT NULL COMMENT '餐厅位置',
  `rtype` int(11) DEFAULT '1',
  `rclick_rate` int(11) DEFAULT '0' COMMENT '点击量',
  `rimg` varchar(50) DEFAULT NULL COMMENT '餐厅图片',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of restaurants
-- ----------------------------
INSERT INTO `restaurants` VALUES ('1', '德得轩韩国自主烤肉', '北京杏花岭区旱西关街10号', '1', '77289', 'ddx.jpg');
INSERT INTO `restaurants` VALUES ('2', '东港海逸', '太原杏花岭区新建路179号杏花岭区东缉虎营35号', '1', '222218', 'dg.jpg');
INSERT INTO `restaurants` VALUES ('3', '圣鲸美食汇', '北京迎泽区开化寺街42号巴黎春天百货7层', '1', '98670', 'sj.jpg');
INSERT INTO `restaurants` VALUES ('4', '黄记煌三汁焖锅', '太原迎泽区开化寺街巴黎春天6层', '1', '11094', 'hj.jpg');
INSERT INTO `restaurants` VALUES ('5', 'Wogas咖啡西餐生活馆', '北京小店区长风街北美新天地2楼', '1', '2850', 'wogas.jpg');
INSERT INTO `restaurants` VALUES ('6', '老太原菜馆', '太原迎泽区迎泽大街南宫广场滨河味道南宫店旁', '1', '66', 'lty.jpg');
INSERT INTO `restaurants` VALUES ('7', '梦回山城自助餐厅', '杏花岭区解放路万达广场不夜城22号（解放大楼对面城坊街往西50米）', '1', '2322', 'sc.jpg');
INSERT INTO `restaurants` VALUES ('8', '红玫瑰快捷餐厅', '太原清徐县森泰大街红玫瑰蛋糕2层（家家乐超市对面）', '1', '234', '5aa684f66f9c1812664e3932bcc2ee0482162.jpg');
INSERT INTO `restaurants` VALUES ('9', '火宴山', '太原迎泽区柳巷贵都购物中心8层', '1', '432', '__29669409__9570296.jpg');
INSERT INTO `restaurants` VALUES ('10', '青春故事烩', '北京万柏林区千峰南路美特好往南50米', '1', '3432', 'f1a7337d4ffb0b42717586a45a90b255148504.jpg');
INSERT INTO `restaurants` VALUES ('11', '万家渡', '太原小店区体育路161号体旅大厦一层（亲贤街茂业百货北侧）', '1', '1234', '__48236677__1250479.jpg');
INSERT INTO `restaurants` VALUES ('12', '政协宾馆', '北京杏花岭区东缉虎营35号', '1', '656', '5664ced3f1f12be0cf5d00cc6d03e5fd374673.jpg');

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `cid` int(11) DEFAULT '0' COMMENT '预定人ID',
  `stype` int(11) DEFAULT '0' COMMENT '购车类型（提交，未提交）',
  `scount` int(11) DEFAULT '1' COMMENT '购物车里的项目数',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------
INSERT INTO `shoppingcart` VALUES ('1', '1', '0', '4');
INSERT INTO `shoppingcart` VALUES ('2', '2', '0', '1');
INSERT INTO `shoppingcart` VALUES ('4', '3', '0', '1');
INSERT INTO `shoppingcart` VALUES ('5', '4', '0', '1');
INSERT INTO `shoppingcart` VALUES ('6', '5', '0', '1');
INSERT INTO `shoppingcart` VALUES ('7', '7', '0', '1');
INSERT INTO `shoppingcart` VALUES ('8', '16', '0', '1');
INSERT INTO `shoppingcart` VALUES ('9', '13', '0', '1');
INSERT INTO `shoppingcart` VALUES ('10', '18', '0', '1');
INSERT INTO `shoppingcart` VALUES ('11', '19', '0', '1');

-- ----------------------------
-- Table structure for shoppingcartitem
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcartitem`;
CREATE TABLE `shoppingcartitem` (
  `sci_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车项目ID',
  `sid` int(11) DEFAULT NULL COMMENT '购物车ID',
  `fid` int(11) DEFAULT NULL COMMENT '食物id',
  `fcount` int(11) DEFAULT '1' COMMENT '食物数量',
  `sci_booktime` varchar(50) DEFAULT NULL COMMENT '预定时间',
  `cid` int(11) DEFAULT '0' COMMENT '下单人',
  PRIMARY KEY (`sci_id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppingcartitem
-- ----------------------------
INSERT INTO `shoppingcartitem` VALUES ('9', '4', '1', '16', '2015-10-09 14:39:28', '3');
INSERT INTO `shoppingcartitem` VALUES ('10', '4', '2', '16', '2015-10-09 14:39:30', '3');
INSERT INTO `shoppingcartitem` VALUES ('11', '4', '3', '2', '2015-10-09 14:39:34', '3');
INSERT INTO `shoppingcartitem` VALUES ('12', '4', '6', '3', '2015-10-09 14:39:38', '3');
INSERT INTO `shoppingcartitem` VALUES ('17', '2', '2', '5', '2015-10-29 14:54:26', '2');
INSERT INTO `shoppingcartitem` VALUES ('18', '2', '1', '4', '2015-10-29 14:54:28', '2');
INSERT INTO `shoppingcartitem` VALUES ('19', '2', '4', '2', '2015-10-29 14:54:32', '2');
INSERT INTO `shoppingcartitem` VALUES ('20', '2', '9', '2', '2015-10-29 14:54:35', '2');
INSERT INTO `shoppingcartitem` VALUES ('21', '7', '10', '7', '2015-10-30 08:35:32', '7');
INSERT INTO `shoppingcartitem` VALUES ('77', '10', '10', '3', '2015-11-05 19:41:12', '18');
INSERT INTO `shoppingcartitem` VALUES ('78', '10', '11', '3', '2015-11-05 19:41:12', '18');
INSERT INTO `shoppingcartitem` VALUES ('79', '10', '13', '7', '2015-11-05 19:41:13', '18');
INSERT INTO `shoppingcartitem` VALUES ('80', '10', '14', '3', '2015-11-05 19:41:13', '18');
INSERT INTO `shoppingcartitem` VALUES ('81', '10', '15', '2', '2015-11-05 19:41:13', '18');
INSERT INTO `shoppingcartitem` VALUES ('82', '10', '17', '2', '2015-11-05 19:41:15', '18');
INSERT INTO `shoppingcartitem` VALUES ('112', '1', '1', '1', '2015-11-05 21:50:02', '1');
INSERT INTO `shoppingcartitem` VALUES ('113', '1', '2', '1', '2015-11-05 21:50:03', '1');
INSERT INTO `shoppingcartitem` VALUES ('114', '1', '3', '1', '2015-11-05 21:50:04', '1');
INSERT INTO `shoppingcartitem` VALUES ('115', '1', '4', '1', '2015-11-05 21:50:05', '1');
