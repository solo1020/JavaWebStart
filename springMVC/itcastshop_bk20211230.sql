-- MySQL dump 10.13  Distrib 5.7.32, for Linux (x86_64)
--
-- Host: localhost    Database: itcastshop
-- ------------------------------------------------------
-- Server version	5.7.32-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `name` varchar(50) DEFAULT NULL,
  `money` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('lucy',5500),('tom',10000),('dataSourceBean',200);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `cid` varchar(50) NOT NULL,
  `cname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('1','手机数码'),('172934bd636d485c98fd2d3d9cccd409','运动户外'),('2','电脑办公'),('3','家具家居'),('4','鞋靴箱包'),('5','图书音像'),('567890','testCategory'),('6','母婴孕婴'),('67890','测试用品'),('afdba41a139b4320a74904485bdb7719','汽车用品');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mybatis_order`
--

DROP TABLE IF EXISTS `mybatis_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mybatis_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '下单用户id',
  `number` varchar(32) NOT NULL COMMENT '订单号',
  `createtime` datetime NOT NULL COMMENT '创建订单时间',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_orders_1` (`user_id`),
  CONSTRAINT `FK_orders_id` FOREIGN KEY (`user_id`) REFERENCES `mybatis_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mybatis_order`
--

LOCK TABLES `mybatis_order` WRITE;
/*!40000 ALTER TABLE `mybatis_order` DISABLE KEYS */;
INSERT INTO `mybatis_order` VALUES (3,1,'1000010','2015-02-04 13:22:35',NULL),(4,1,'1000011','2015-02-03 13:22:41',NULL),(5,10,'1000012','2015-02-12 16:13:23',NULL);
/*!40000 ALTER TABLE `mybatis_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mybatis_user`
--

DROP TABLE IF EXISTS `mybatis_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mybatis_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mybatis_user`
--

LOCK TABLES `mybatis_user` WRITE;
/*!40000 ALTER TABLE `mybatis_user` DISABLE KEYS */;
INSERT INTO `mybatis_user` VALUES (1,'王五',NULL,'2',NULL),(10,'张三','2014-07-10','1','北京市'),(16,'张小明',NULL,'1','河南郑州'),(22,'陈小明',NULL,'1','河南郑州'),(24,'张三丰',NULL,'1','河南郑州'),(25,'陈小明',NULL,'1','河南郑州'),(26,'王五',NULL,NULL,NULL);
/*!40000 ALTER TABLE `mybatis_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderitem` (
  `itemid` varchar(50) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `pid` varchar(50) DEFAULT NULL,
  `oid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `fk_0001` (`pid`),
  KEY `fk_0002` (`oid`),
  CONSTRAINT `fk_0001` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `fk_0002` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
INSERT INTO `orderitem` VALUES ('0f93c83d-690e-4bf3-a250-a5d7ec4a3a06',1,3999,'17','b431456a-87e4-4833-aef2-e21205e23f03'),('2a947160-da14-4b39-a88c-8292a1176400',1,10288,'39','0f3eaf60-9b6a-4694-a494-f95cbe51f258'),('3360db25-010a-48ec-b17f-1619c44123d3',3,6894,'11','300ffbc2-089f-4237-b834-b89dcd1aa2ae'),('40a8e17b-3aab-4d48-8af7-1e16ac775943',1,2599,'10','d37b8662-158e-4dc0-b2a7-b5602d35ccd8'),('5ddc97b0-908b-4a80-93e3-b48435858082',1,3999,'17','d37b8662-158e-4dc0-b2a7-b5602d35ccd8'),('8a9bc7fb-fc53-40cd-9aa3-00ad2ad8949c',1,4199,'33','d37b8662-158e-4dc0-b2a7-b5602d35ccd8'),('8f620b22-d99a-4880-b7a6-d003ed5f496f',1,2599,'10','0f3eaf60-9b6a-4694-a494-f95cbe51f258'),('999dcccf-779f-4e91-87e1-7edec1d3414c',1,3699,'35','9d1904af-0a1a-492e-9cbe-506920c4171f'),('c68e743e-bf20-43c2-b018-25f4bfd22d99',1,4499,'34','b431456a-87e4-4833-aef2-e21205e23f03'),('c85316d9-19fa-42d5-b1ba-40812939c1f5',1,2599,'10','c09f1400-f497-4dc5-929d-057de8b96a95'),('cdce23c2-ded4-4543-a454-9b79b27789be',2,11998,'42','300ffbc2-089f-4237-b834-b89dcd1aa2ae'),('e08432b8-fdd8-4763-8570-9c2f28b25fbb',1,1299,'1','9d1904af-0a1a-492e-9cbe-506920c4171f'),('f3e4d618-996f-47e0-a41f-3f64e362382f',1,10288,'39','c09f1400-f497-4dc5-929d-057de8b96a95');
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `oid` varchar(50) NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `uid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('0f3eaf60-9b6a-4694-a494-f95cbe51f258','2021-07-09 01:39:34',12887,0,NULL,'zhangsan','','9a099686-31fc-4a81-a784-929e152c3259'),('300ffbc2-089f-4237-b834-b89dcd1aa2ae','2021-07-10 00:54:36',18892,0,NULL,'zhangsan','','9a099686-31fc-4a81-a784-929e152c3259'),('9d1904af-0a1a-492e-9cbe-506920c4171f','2021-06-30 00:54:48',4998,0,NULL,NULL,NULL,NULL),('b431456a-87e4-4833-aef2-e21205e23f03','2021-06-30 00:51:48',8498,0,NULL,NULL,NULL,NULL),('c09f1400-f497-4dc5-929d-057de8b96a95','2021-07-09 01:04:33',12887,0,NULL,'zhangsan','',NULL),('d37b8662-158e-4dc0-b2a7-b5602d35ccd8','2021-07-09 00:49:16',10797,0,NULL,'zhangsan','15623434333',NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `pid` varchar(50) NOT NULL,
  `pname` varchar(50) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `shop_price` double DEFAULT NULL,
  `pimage` varchar(200) DEFAULT NULL,
  `pdate` date DEFAULT NULL,
  `is_hot` int(11) DEFAULT NULL,
  `pdesc` varchar(255) DEFAULT NULL,
  `pflag` int(11) DEFAULT NULL,
  `cid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `sfk_0001` (`cid`),
  CONSTRAINT `sfk_0001` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('1','小米 4c 标准版',1399,1299,'products/1/c_0001.jpg','2015-11-02',1,'小米 4c 标准版 全网通 白色 移动联通电信4G手机 双卡双待',0,'1'),('10','华为 Ascend Mate7',2699,2599,'products/1/c_0010.jpg','2015-11-02',1,'华为 Ascend Mate7 月光银 移动4G手机 双卡双待双通6英寸高清大屏，纤薄机身，智能超八核，按压式指纹识别！!选择下方“移动老用户4G飞享合约”，无需换号，还有话费每月返还！',0,'1'),('11','vivo X5Pro',2399,2298,'products/1/c_0014.jpg','2015-11-02',1,'移动联通双4G手机 3G运存版 极光白【购机送蓝牙耳机+蓝牙自拍杆】新升级3G运行内存·双2.5D弧面玻璃·眼球识别技术',0,'1'),('12','努比亚（nubia）My 布拉格',1899,1799,'products/1/c_0013.jpg','2015-11-02',0,'努比亚（nubia）My 布拉格 银白 移动联通4G手机 双卡双待【嗨11，下单立减100】金属机身，快速充电！布拉格相机全新体验！',0,'1'),('13','华为 麦芒4',2699,2499,'products/1/c_0012.jpg','2015-11-02',1,'华为 麦芒4 晨曦金 全网通版4G手机 双卡双待金属机身 2.5D弧面屏 指纹解锁 光学防抖',0,'1'),('14','vivo X5M',1899,1799,'products/1/c_0011.jpg','2015-11-02',0,'vivo X5M 移动4G手机 双卡双待 香槟金【购机送蓝牙耳机+蓝牙自拍杆】5.0英寸大屏显示·八核双卡双待·Hi-Fi移动KTV',0,'1'),('15','Apple iPhone 6 (A1586)',4399,4288,'products/1/c_0015.jpg','2015-11-02',1,'Apple iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机长期省才是真的省！点击购机送费版，月月送话费，月月享优惠，畅享4G网络，就在联通4G！',0,'1'),('16','华为 HUAWEI Mate S 臻享版',4200,4087,'products/1/c_0016.jpg','2015-11-03',0,'华为 HUAWEI Mate S 臻享版 手机 极昼金 移动联通双4G(高配)满星评价即返30元话费啦；买就送电源+清水套+创意手机支架；优雅弧屏，mate7升级版',0,'1'),('17','索尼(SONY) E6533 Z3+',4099,3999,'products/1/c_0017.jpg','2015-11-02',0,'索尼(SONY) E6533 Z3+ 双卡双4G手机 防水防尘 涧湖绿索尼z3专业防水 2070万像素 移动联通双4G',0,'1'),('18','HTC One M9+',3599,3499,'products/1/c_0018.jpg','2015-11-02',0,'HTC One M9+（M9pw） 金银汇 移动联通双4G手机5.2英寸，8核CPU，指纹识别，UltraPixel超像素前置相机+2000万/200万后置双镜头相机！降价特卖，惊喜不断！',0,'1'),('19','HTC Desire 826d 32G 臻珠白',1599,1469,'products/1/c_0020.jpg','2015-11-05',1,'后置1300万+UltraPixel超像素前置摄像头+【双】前置扬声器+5.5英寸【1080p】大屏！',0,'1'),('2','中兴 AXON',2699,2699,'products/1/c_0002.jpg','2015-11-02',1,'中兴 AXON 天机 mini 压力屏版 B2015 华尔金 移动联通电信4G 双卡双待',0,'1'),('20','小米 红米2A 增强版 白色',649,549,'products/1/c_0019.jpg','2015-11-02',0,'新增至2GB 内存+16GB容量！4G双卡双待，联芯 4 核 1.5GHz 处理器！',0,'1'),('21','魅族 魅蓝note2 16GB 白色',1099,999,'products/1/c_0021.jpg','2015-11-02',0,'现货速抢，抢完即止！5.5英寸1080P分辨率屏幕，64位八核1.3GHz处理器，1300万像素摄像头，双色温双闪光灯！',0,'1'),('22','三星 Galaxy S5 (G9008W) 闪耀白',2099,1999,'products/1/c_0022.jpg','2015-11-02',1,'5.1英寸全高清炫丽屏，2.5GHz四核处理器，1600万像素',0,'1'),('23','sonim XP7700 4G手机',1799,1699,'products/1/c_0023.jpg','2015-11-09',1,'三防智能手机 移动/联通双4G 安全 黑黄色 双4G美国军工IP69 30天长待机 3米防水防摔 北斗',0,'1'),('24','努比亚（nubia）Z9精英版 金色',3988,3888,'products/1/c_0024.jpg','2015-11-02',1,'移动联通电信4G手机 双卡双待真正的无边框！金色尊贵版！4GB+64GB大内存！',0,'1'),('25','Apple iPhone 6 Plus (A1524) 16GB 金色',5188,4988,'products/1/c_0025.jpg','2015-11-02',0,'Apple iPhone 6 Plus (A1524) 16GB 金色 移动联通电信4G手机 硬货 硬实力',0,'1'),('26','Apple iPhone 6s (A1700) 64G 玫瑰金色',6388,6088,'products/1/c_0026.jpg','2015-11-02',0,'Apple iPhone 6 Plus (A1524) 16GB 金色 移动联通电信4G手机 硬货 硬实力',0,'1'),('27','三星 Galaxy Note5（N9200）32G版',5588,5388,'products/1/c_0027.jpg','2015-11-02',0,'旗舰机型！5.7英寸大屏，4+32G内存！不一样的SPen更优化的浮窗指令！赠无线充电板！',0,'1'),('28','三星 Galaxy S6 Edge+（G9280）32G版 铂光金',5999,5888,'products/1/c_0028.jpg','2015-11-02',0,'赠移动电源+自拍杆+三星OTG金属U盘+无线充电器+透明保护壳',0,'1'),('29','LG G4（H818）陶瓷白 国际版',3018,2978,'products/1/c_0029.jpg','2015-11-02',0,'李敏镐代言，F1.8大光圈1600万后置摄像头，5.5英寸2K屏，3G+32G内存，LG年度旗舰机！',0,'1'),('3','华为荣耀6',1599,1499,'products/1/c_0003.jpg','2015-11-02',0,'荣耀 6 (H60-L01) 3GB内存标准版 黑色 移动4G手机',0,'1'),('30','微软(Microsoft) Lumia 640 LTE DS (RM-1113)',1099,999,'products/1/c_0030.jpg','2015-11-02',0,'微软首款双网双卡双4G手机，5.0英寸高清大屏，双网双卡双4G！',0,'1'),('31','宏碁（acer）ATC705-N50 台式电脑',2399,2299,'products/1/c_0031.jpg','2015-11-02',0,'爆款直降，满千减百，品质宏碁，特惠来袭，何必苦等11.11，早买早便宜！',0,'2'),('32','Apple MacBook Air MJVE2CH/A 13.3英寸',6788,6688,'products/1/c_0032.jpg','2015-11-02',0,'宽屏笔记本电脑 128GB 闪存',0,'2'),('33','联想（ThinkPad） 轻薄系列E450C(20EH0001CD)',4399,4199,'products/1/c_0033.jpg','2015-11-02',0,'联想（ThinkPad） 轻薄系列E450C(20EH0001CD)14英寸笔记本电脑(i5-4210U 4G 500G 2G独显 Win8.1)',0,'2'),('34','联想（Lenovo）小新V3000经典版',4599,4499,'products/1/c_0034.jpg','2015-11-02',0,'14英寸超薄笔记本电脑（i7-5500U 4G 500G+8G SSHD 2G独显 全高清屏）黑色满1000減100，狂减！火力全开，横扫3天！',0,'2'),('3441e2cd-45b5-4596-aec5-4675d253c75b','xxxxxx',3999.98,899,'upload_product_img\\friends.s08e16.aac.720p.x264.mp4_20201224_021429.094.jpg','2021-07-14',1,'tomato先生',0,'3'),('35','华硕（ASUS）经典系列R557LI',3799,3699,'products/1/c_0035.jpg','2015-11-02',0,'15.6英寸笔记本电脑（i5-5200U 4G 7200转500G 2G独显 D刻 蓝牙 Win8.1 黑色）',0,'2'),('36','华硕（ASUS）X450J',4599,4399,'products/1/c_0036.jpg','2015-11-02',0,'14英寸笔记本电脑 （i5-4200H 4G 1TB GT940M 2G独显 蓝牙4.0 D刻 Win8.1 黑色）',0,'2'),('37','戴尔（DELL）灵越 飞匣3000系列',3399,3299,'products/1/c_0037.jpg','2015-11-03',0,' Ins14C-4528B 14英寸笔记本（i5-5200U 4G 500G GT820M 2G独显 Win8）黑',0,'2'),('38','惠普(HP)WASD 暗影精灵',5699,5499,'products/1/c_0038.jpg','2015-11-02',0,'15.6英寸游戏笔记本电脑(i5-6300HQ 4G 1TB+128G SSD GTX950M 4G独显 Win10)',0,'2'),('39','Apple 配备 Retina 显示屏的 MacBook',11299,10288,'products/1/c_0039.jpg','2015-11-02',0,'Pro MF840CH/A 13.3英寸宽屏笔记本电脑 256GB 闪存',0,'2'),('4','联想 P1',2199,1999,'products/1/c_0004.jpg','2015-11-02',0,'联想 P1 16G 伯爵金 移动联通4G手机充电5分钟，通话3小时！科技源于超越！品质源于沉淀！5000mAh大电池！高端商务佳配！',0,'1'),('40','机械革命（MECHREVO）MR X6S-M',6799,6599,'products/1/c_0040.jpg','2015-11-02',0,'15.6英寸游戏本(I7-4710MQ 8G 64GSSD+1T GTX960M 2G独显 IPS屏 WIN7)黑色',0,'2'),('41','神舟（HASEE） 战神K660D-i7D2',5699,5499,'products/1/c_0041.jpg','2015-11-02',0,'15.6英寸游戏本(i7-4710MQ 8G 1TB GTX960M 2G独显 1080P)黑色',0,'2'),('42','微星（MSI）GE62 2QC-264XCN',6199,5999,'products/1/c_0042.jpg','2015-11-02',0,'15.6英寸游戏笔记本电脑（i5-4210H 8G 1T GTX960MG DDR5 2G 背光键盘）黑色',0,'2'),('43','雷神（ThundeRobot）G150S',5699,5499,'products/1/c_0043.jpg','2015-11-02',0,'15.6英寸游戏本 ( i7-4710MQ 4G 500G GTX950M 2G独显 包无亮点全高清屏) 金',0,'2'),('44','惠普（HP）轻薄系列 HP',3199,3099,'products/1/c_0044.jpg','2015-11-02',0,'15-r239TX 15.6英寸笔记本电脑（i5-5200U 4G 500G GT820M 2G独显 win8.1）金属灰',0,'2'),('45','未来人类（Terrans Force）T5',10999,9899,'products/1/c_0045.jpg','2015-11-02',0,'15.6英寸游戏本（i7-5700HQ 16G 120G固态+1TB GTX970M 3G GDDR5独显）黑',0,'2'),('46','戴尔（DELL）Vostro 3800-R6308 台式电脑',3299,3199,'products/1/c_0046.jpg','2015-11-02',0,'（i3-4170 4G 500G DVD 三年上门服务 Win7）黑',0,'2'),('47','联想（Lenovo）H3050 台式电脑',5099,4899,'products/1/c_0047.jpg','2015-11-11',0,'（i5-4460 4G 500G GT720 1G独显 DVD 千兆网卡 Win10）23英寸',0,'2'),('48','Apple iPad mini 2 ME279CH/A',2088,1888,'products/1/c_0048.jpg','2015-11-02',0,'（配备 Retina 显示屏 7.9英寸 16G WLAN 机型 银色）',0,'2'),('49','小米（MI）7.9英寸平板',1399,1299,'products/1/c_0049.jpg','2015-11-02',0,'WIFI 64GB（NVIDIA Tegra K1 2.2GHz 2G 64G 2048*1536视网膜屏 800W）白色',0,'2'),('5','摩托罗拉 moto x（x+1）',1799,1699,'products/1/c_0005.jpg','2015-11-01',0,'摩托罗拉 moto x（x+1）(XT1085) 32GB 天然竹 全网通4G手机11月11天！MOTO X震撼特惠来袭！1699元！带你玩转黑科技！天然材质，原生流畅系统！',0,'1'),('50','Apple iPad Air 2 MGLW2CH/A',2399,2299,'products/1/c_0050.jpg','2015-11-12',0,'（9.7英寸 16G WLAN 机型 银色）',0,'2'),('6','魅族 MX5 16GB 银黑色',1899,1799,'products/1/c_0006.jpg','2015-11-02',0,'魅族 MX5 16GB 银黑色 移动联通双4G手机 双卡双待送原厂钢化膜+保护壳+耳机！5.5英寸大屏幕，3G运行内存，2070万+500万像素摄像头！长期省才是真的省！',0,'1'),('7','三星 Galaxy On7',1499,1398,'products/1/c_0007.jpg','2015-11-14',0,'三星 Galaxy On7（G6000）昂小七 金色 全网通4G手机 双卡双待新品火爆抢购中！京东尊享千元良机！5.5英寸高清大屏！1300+500W像素！评价赢30元话费券！',0,'1'),('8','NUU NU5',1288,1190,'products/1/c_0008.jpg','2015-11-02',0,'NUU NU5 16GB 移动联通双4G智能手机 双卡双待 晒单有礼 晨光金香港品牌 2.5D弧度前后钢化玻璃 随机附赠手机套+钢化贴膜 晒单送移动电源+蓝牙耳机',0,'1'),('9','乐视（Letv）乐1pro（X800）',2399,2299,'products/1/c_0009.jpg','2015-11-02',0,'乐视（Letv）乐1pro（X800）64GB 金色 移动联通4G手机 双卡双待乐视生态UI+5.5英寸2K屏+高通8核处理器+4GB运行内存+64GB存储+1300万摄像头！',0,'1');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) DEFAULT NULL,
  `roleDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'院长','负责全面工作'),(2,'研究员','课程研发工作'),(3,'讲师','授课工作'),(4,'助教','协助解决学生的问题'),(6,'辅导员','辅导学生日常生活');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'zhangsan','zhangsan@itcast.cn','123','13888888888'),(2,'lisi','lisi@itcast.cn','123','13999999999'),(3,'wangwu','wangwu@itcast.cn','123','18599999999');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `userId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1),(1,2),(2,2),(2,3);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uid` varchar(50) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('15202021-db20-437a-afc2-953c25e6d4ff','','','','',NULL,NULL,NULL,0,'d7af92ad-3ab1-47d9-897c-e15ac32d04d0'),('48900322-e5c1-4169-8ebc-5055637ccd27','','','','',NULL,NULL,NULL,0,'589d3b27-9bb0-4dcb-b15a-e877fc1db4f3'),('5cf11a23-7e2b-4bf7-bd87-14dc9cce29b2','5454','545','','',NULL,NULL,NULL,0,'402061c1-1095-4a00-b505-d9d34ed5d9e1'),('9a099686-31fc-4a81-a784-929e152c3259','zhangsan','123','zhangsan','qzloveyao@126.com',NULL,'1986-01-01','female',1,'e3a96138-f7b1-4a00-a887-01484f138f45');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-30 23:30:06
