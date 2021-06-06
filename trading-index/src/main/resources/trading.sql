/*
Navicat MySQL Data Transfer

Source Server         : Joe
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : trading

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2021-06-06 21:16:22
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int(10) NOT NULL AUTO_INCREMENT,
  `aname` varchar(50) COLLATE utf8_bin NOT NULL,
  `apwd` varchar(50) COLLATE utf8_bin NOT NULL,
  `realname` varchar(50) COLLATE utf8_bin NOT NULL,
  `tel` varchar(50) COLLATE utf8_bin NOT NULL,
  `status` int(5) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `totalprice` double(100,0) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for `cartitem`
-- ----------------------------
DROP TABLE IF EXISTS `cartitem`;
CREATE TABLE `cartitem` (
  `iid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `gid` int(10) NOT NULL,
  `gname` varchar(50) COLLATE utf8_bin NOT NULL,
  `cid` int(10) NOT NULL,
  `num` int(5) NOT NULL,
  `price` double(50,0) NOT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cartitem
-- ----------------------------

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `coid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `gid` int(10) NOT NULL,
  `gname` varchar(50) COLLATE utf8_bin NOT NULL,
  `gtype` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`coid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `gid` int(10) NOT NULL,
  `content` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`comid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `gid` int(10) NOT NULL AUTO_INCREMENT,
  `gname` varchar(50) COLLATE utf8_bin NOT NULL,
  `gtype` varchar(50) COLLATE utf8_bin NOT NULL,
  `userid` int(10) NOT NULL,
  `num` int(50) NOT NULL,
  `date` date NOT NULL,
  `colnum` int(100) DEFAULT NULL,
  `price` double(255,0) NOT NULL,
  `status` int(5) NOT NULL,
  `content` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`gid`),
  KEY `fk_userid` (`userid`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO goods VALUES ('1', '台灯', '电子用品', '1', '1', '2021-06-01', null, '30', '1', '9.5成新，明亮');
INSERT INTO goods VALUES ('2', '手机', '电子用品', '1', '1', '2021-06-02', null, '2500', '1', '好用');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `oid` int(100) NOT NULL AUTO_INCREMENT,
  `buyuid` int(10) NOT NULL,
  `selluid` int(10) NOT NULL,
  `totalprice` double(255,0) NOT NULL,
  `address` varchar(50) COLLATE utf8_bin NOT NULL,
  `date` date NOT NULL,
  `status` int(5) NOT NULL,
  PRIMARY KEY (`oid`),
  KEY `fk_buyuid` (`buyuid`),
  KEY `fk_selluid` (`selluid`),
  CONSTRAINT `fk_buyuid` FOREIGN KEY (`buyuid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_selluid` FOREIGN KEY (`selluid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO order VALUES ('1', '1', '1', '19', '怀化', '2021-06-02', '1');

-- ----------------------------
-- Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `oiid` int(10) NOT NULL AUTO_INCREMENT,
  `gid` int(10) NOT NULL,
  `gname` varchar(50) COLLATE utf8_bin NOT NULL,
  `num` int(5) NOT NULL,
  `price` double(10,0) NOT NULL,
  `oid` int(10) NOT NULL,
  PRIMARY KEY (`oiid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO orderitem VALUES ('1', '1', '台灯', '2', '30', '1');
INSERT INTO orderitem VALUES ('2', '2', '手机', '1', '2500', '1');

-- ----------------------------
-- Table structure for `pic`
-- ----------------------------
DROP TABLE IF EXISTS `pic`;
CREATE TABLE `pic` (
  `gid` int(10) NOT NULL,
  `pic` varchar(50) COLLATE utf8_bin NOT NULL,
  `ptype` varchar(50) COLLATE utf8_bin NOT NULL,
  `pid` int(10) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pic
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) COLLATE utf8_bin NOT NULL,
  `upwd` varchar(50) COLLATE utf8_bin NOT NULL,
  `realname` varchar(10) COLLATE utf8_bin NOT NULL,
  `tel` varchar(50) COLLATE utf8_bin NOT NULL,
  `address` varchar(50) COLLATE utf8_bin NOT NULL,
  `status` int(5) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'ql', 'aaa', '乔龙', '17674501750', '衡阳', '1');
