/*
 Navicat Premium Data Transfer

 Source Server         : simian
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : db_shopping

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 04/07/2021 13:51:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uid` int(11) NOT NULL,
  `level` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_address_id`(`uid`) USING BTREE,
  CONSTRAINT `fk_address_id` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES (8, '广东揭阳', '陈思绵', '136201692601', 14, 0);
INSERT INTO `tb_address` VALUES (9, '五邑大学', '陈思绵', '13620192601', 15, 0);

-- ----------------------------
-- Table structure for tb_cart
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart`  (
  `id` int(11) NOT NULL,
  `pid` int(11) NOT NULL DEFAULT 0,
  `Num` int(11) NULL DEFAULT NULL,
  `money` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `pid`) USING BTREE,
  INDEX `fk_cart_pid`(`pid`) USING BTREE,
  CONSTRAINT `fk_cart_id` FOREIGN KEY (`id`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_cart_pid` FOREIGN KEY (`pid`) REFERENCES `tb_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_cart
-- ----------------------------
INSERT INTO `tb_cart` VALUES (11, 3, 3, 234);
INSERT INTO `tb_cart` VALUES (11, 4, 1, 89);
INSERT INTO `tb_cart` VALUES (14, 7, 1, 200);
INSERT INTO `tb_cart` VALUES (15, 11, 1, 185);

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pubdate` date NULL DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` int(11) NOT NULL,
  `star` tinyint(4) NOT NULL DEFAULT 0,
  `intro` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `typeid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_typeid`(`typeid`) USING BTREE,
  CONSTRAINT `fk_typeid` FOREIGN KEY (`typeid`) REFERENCES `tb_goods_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 325 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES (1, 'Sialia专业化妆刷套装粉底腮红散粉眼影刷超柔软刷毛全套美妆工具\r', '2021-06-17', '1.jpg', 90, 3, '品牌: Sialia品名: 绿野仙踪12支装产地: 中国颜色分类: 绿野仙踪12支装带包 绿野仙踪12支装带包+清洗液 绿野仙踪12支装+美妆蛋保质期: 3年适合肤质: 任何肤质刷毛材质: 人造纤维美妆工具分类: 眼影刷功效: 其他/other 防水 妆前打底刷柄类型: 短杆规格类型: 正常规格\r', 2);
INSERT INTO `tb_goods` VALUES (2, 'MSQ/魅丝蔻14支芭蕉化妆刷套装超柔软散粉眼影刷全套刷子美妆工具\r纳米丝仿生毛 柔软不扎脸\r\r', '2021-06-01', '2.jpg', 149, 4, '品牌: MSQ/魅丝蔻化妆刷/刷包单品: 14支芭蕉化妆套刷产地: 中国美容工具分类: 化妆刷颜色分类: 14支芭蕉（刷包礼盒版） 14支芭蕉（刷桶礼盒版） 14支芭蕉（包桶礼盒版）保质期: 无适合肤质: 任何肤质刷毛材质: 人造纤维美妆工具分类: 脸部美容化妆用具功效: 其他/other刷柄类型: 短杆规格类型: 正常规格', 2);
INSERT INTO `tb_goods` VALUES (3, '化妆刷套装眼影散粉眉刷粉底腮红高光遮瑕套刷全套刷子工具超柔软\r', '2021-07-07', '3.jpg', 22, 5, '品牌: DUESI/蝶语诗\r品名: SYY10只化妆刷套装\r产地: 中国\r适合肤质: 任何肤质\r刷毛材质: 人造纤维', 2);
INSERT INTO `tb_goods` VALUES (4, '3个|李佳埼美妆蛋 葫芦海绵粉扑 干湿两用气垫不吃粉彩妆化妆工具\r', '2021-07-02', '4.jpg', 19, 5, '品牌名称：欧伊俪\r产品参数：\r\r产品名称：欧伊俪\r 美妆蛋套装品牌: 欧伊俪\r品名: 美妆蛋套装\r产地: 中国美容工具\r保质期: 3年\r适合肤质: 任何肤质美妆\r工具分类: 脸部美容化妆用具美容工具\r品种: 彩妆蛋\r规格类型: 正常规格\r', 2);
INSERT INTO `tb_goods` VALUES (5, 'red earth红地球干湿两用美妆蛋化妆蛋粉扑海绵蛋美容工具正品\r', '2021-07-02', '5.jpg', 39, 5, '品牌名称：red earth/红地球\r产品参数：\r\r产品名称：red earth/红地球\r 品牌: red earth/红地球\r品名: redearth美妆蛋\r产地: 其他/other美容\r工具分类: 化妆粉扑\r颜色分类: 经典款水滴形 水滴形 水滴单切面 鼠标三切形 迷你三角形 丝绒单切面\r适合肤质: 任何肤质\r美妆工具分类: 脸部美容化妆用具美容工具品种: 化妆粉扑\r规格类型: 正常规格\r', 2);
INSERT INTO `tb_goods` VALUES (6, '纪梵希散粉粉扑通用可替换四宫格蜜粉粉饼定妆粉扑面扑化妆工具', '2021-06-01', '6.jpg', 23, 5, '产品名称: other/其他\r 化妆扑粉品牌: other/其他\r化妆/美容工具单品: 化妆扑粉\r产地: 中国\r美容工具分类: 化妆粉扑\r保质期: 5年\r适合肤质: 任何肤质\r美妆工具分类: 脸部美容化妆用具\r功效: 其他/other\r美容工具品种: 化妆粉扑\r规格类型: 正常规格\r', 2);
INSERT INTO `tb_goods` VALUES (7, '现货 TOM FORD TF 银管口红 闪亮钻石唇膏05 06havoc 07Stunner\r', '2021-07-08', '7.jpg', 230, 5, '产品名称: Tom Ford/汤姆福特 Lip Color唇膏\r品牌: Tom Ford/汤姆福特\r单品: Lip Color唇膏\r产地: 其他/other\r颜色分类: 05clash 促销 06# HAVOC 促销 07# Stunner 促销 04Firestar 促销 08# 促销 18# DESTROY 19# SYNTHETICA\r保质期: 3年\r适合肤质: 任何肤质\r功效: 滋润 保湿\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r', 2);
INSERT INTO `tb_goods` VALUES (8, '2件99 曼妮芬美妆跨界联名变色唇膏花园限定版#259珠光紫素颜口红\r品牌25周年限量发售！花园系列新色上市\r', '2021-07-02', '8.jpg', 69, 5, '产品名称：曼妮芬 \r品牌: 曼妮芬\r品名: 花园系列轻润水光变色唇膏\r产地: 中国净含量: 1.8g\r颜色分类: 525 蔷薇红 259 鸢尾紫 225珠光樱花粉 258 雏菊黄 125珠光奶油橘批准文号: 粤G妆网备字2021034379\r功效: 提升气色 滋润 保湿 补水\r规格类型: 正常规格\r是否为特殊用途化妆品: 否限期\r使用日期范围: 2024-03-28至2024-04-10质地: 水光', 2);
INSERT INTO `tb_goods` VALUES (9, '美宝莲fitme妆前乳女隔离霜高保湿妆前打底遮瑕补水隐形毛孔平价\r', '2021-05-04', '9.jpg', 119, 5, '产品名称：Maybelline/美宝莲 美宝莲\r品牌: Maybelline/美宝莲妆前乳\r单品: 美宝莲定制妆前乳\r产地: 中国\r颜色分类: 保湿版 控油版\r批准文号: 鄂G妆网备字2019003023\r是否防晒: 否\r功效: 提亮肤色\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r限期使用日期范围: 2022-11-30至2023-10', 2);
INSERT INTO `tb_goods` VALUES (10, '赫恩男士防晒霜乳防紫外线晒黑美白户外专用高男生脸部隔离喷雾\r防晒黑 防晒伤 持久防晒\r', '2021-06-01', '10.jpg', 79, 5, '品牌名称：H＆E/赫恩\r男士护理单品: 男士防晒霜套装\r产地: 中国批准文号: 国妆特字G20190372\r适合肤质: 任何肤质\r上市时间: 2018年\r功效: 美白 防晒\r规格类型: 正常规格\r是否为特殊用途化妆品: 是\r', 2);
INSERT INTO `tb_goods` VALUES (11, '5盒韩国JM面膜女补水保湿美白淡斑水母男士旗舰店官方正品专用\r', '2021-06-01', '11.jpg', 185, 5, '品牌: JMSOLUTION \r品名: JM solution水母弹润面膜\r 产地: 韩国 \r功效: 活肤滋润 补水 滋养肌肤 弹力紧致 细腻光滑 化妆品\r净含量: 10片 10.0片 \r规格类型: 正常规格 \r是否为特殊用途化妆品: 否 \r限期使用日期范围: 2021-11-30至2022-11-2\r', 1);
INSERT INTO `tb_goods` VALUES (12, '会员专享价屈臣氏理肤泉B5多效保湿修护面膜滋润补水敏感肌10片\r', '2021-06-01', '12.jpg', 165, 5, '品牌: Watsons/屈臣氏面膜单品: 理肤泉B5多效保湿面膜组合产地: 中国面膜分类: 贴片式批准文号: 苏G妆网备字2019000242功效: 修护 补水 保湿 滋润 眼部抗皱化妆品净含量: 10片规格类型: 正常规格是否为特殊用途化妆品: 否限期使用日期范围: 2022-12-21至2023-05-02化妆品保质期: 36个月', 1);
INSERT INTO `tb_goods` VALUES (13, 'Bb LABORATORIES/苾莱宝【直营】Bb LABORATORIES/苾莱宝清洁面膜\r¥ 218.00\r', '2021-07-06', '13.jpg', 218, 5, '产品名称：Bb LABORATORIES/苾莱宝 ...\r品牌: Bb LABORATORIES/苾莱宝\r品名: 复活草面膜\r产地: 日本\r适合肤质: 任何肤质\r功效: 补水 保湿化妆品\r净含量: 175g/ml\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r', 1);
INSERT INTO `tb_goods` VALUES (14, 'Mario Badescu净痘精华液温和MB小粉瓶祛痘水杨酸粉刺去闭口29ml\r', '2021-07-11', '14.jpg', 129, 5, '产品名称：MARIO BADESCU SKIN CARE ...\r品牌: MARIO BADESCU SKIN CARE\r品名: 净痘精华温和版\r产地: 美国\r适合肤质: 所有肤质\r功效: 祛痘化妆品\r净含量: 29mL\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r限期使用日期范围: 2022-07-01至2023-04-01化妆品\r保质期: 30个月\r', 1);
INSERT INTO `tb_goods` VALUES (15, '立即购买】谷雨光感水光甘草修护精华水去黄提亮爽肤水补水保湿\r谷雨全新[光感水] 8重蕴能精粹 焕肤级提亮\r', '2021-06-02', '15.jpg', 239, 5, '产品名称：谷雨 光感水\r品牌: 谷雨品名: 光感水\r批准文号: 粤G妆网备字2016106929\r适合肤质: 任何肤质\r上市时间: 2020年\r功效: 改善黯沉 提亮肤色化妆品\r净含量: 145ml\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r限期使用日期范围: 2022-02-02至2022-06-30化妆品\r保质期: 36个月\r', 1);
INSERT INTO `tb_goods` VALUES (16, '欧莱雅大海王者防晒霜多重防护隔离液轻薄持久40ml', '2021-05-01', '16.jpg', 210, 5, '产品名称：L\'OREAL /欧莱雅 新多重...\r品牌: L\'OREAL /欧莱雅欧莱雅\r单品: 新多重防护隔离液(水感倍护)SPF50+/PA++++\r批准文号: 国妆特字G20200215\r功效: 防晒化妆品净含量: 40ml\r规格类型: 正常规格\r是否为特殊用途化妆品: 是\r限期使用日期范围: 2023-09-13至2023-0\r', 1);
INSERT INTO `tb_goods` VALUES (17, '日本资生堂安热沙安耐晒防晒霜女60ml*2瓶小金瓶防晒乳隔离脸部男\r价格\r', '2021-06-08', '17.jpg', 308, 5, '品牌: ANESSA/安热沙 \r品名: 金瓶防晒乳\r 产地: 日本 \r功效: 滋润 控油 防晒 化妆品\r净含量: 60ml 规格类型: 正常规格 \r是否为特殊用途化妆品: 否 \r限期使用日期范围: 2022-05-20至2023-04-20 \r化妆品保质期: 36个月', 1);
INSERT INTO `tb_goods` VALUES (18, '马应龙眼霜瞳话官网正品英淡化黑眼圈眼袋补水熬夜精华保湿按摩\r淡化黑眼圈补水保湿\r', '2021-07-06', '18.jpg', 198, 5, '品牌: 马应龙\r品名: TH003\r净含量: 15g/ml\r批准文号: 鄂G妆网备字2017000983\r适合肤质: 中性\r肤质功效: 眼部提拉紧致 去黑眼圈 眼部补水 眼部保湿\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r', 1);
INSERT INTO `tb_goods` VALUES (19, 'AHC韩国B5玻尿酸深层清洁面保湿控油女男士学生敏感肌洗面奶180ml\r', '2021-07-02', '19.jpg', 192, 5, '产品名称：A.H.C/爱和纯 高效玻尿...\r品牌: A.H.C/爱和纯\r品名: 高效玻尿酸B5洗面奶洁面\r分类: 洁面乳/膏适合\r肤质: 任何肤质\r起泡程度: 泡沫\r功效: 补水 保湿 深层清洁化妆品\r净含量: 180ml\r规格类型: 正常规格\r是否为特殊用途化妆品: 否限期\r使用日期范围: 2022-09-30至2023-08-31\r化妆品保质期: 36个月\r', 1);
INSERT INTO `tb_goods` VALUES (20, '美国eltamd氨基酸洗面奶泡沫洁面乳男女深层清洁敏感肌温和207ml\r', '2021-07-02', '20.jpg', 88, 4, '产品名称: Elta MD Elta MD 氨基酸泡沫洁面乳207ml\r品牌: Elta MD\r品名: Elta MD 氨基酸泡沫洁面乳207ml\r产地: 美国\r洁面分类: 洁面乳\r保质期: 3年\r适合肤质: 任何肤质\r起泡程度: 泡沫\r上市时间: 2019年\r原料成分: 佛手柑\r功效: 清洁毛孔 水润 净透肌底化妆品\r净含量: 207\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r', 1);
INSERT INTO `tb_goods` VALUES (21, '颜右色男士洗面奶补水保湿淡化痘印去黑头专用洁面乳护肤品套装\r', '2021-07-02', '22.jpg', 168, 5, '产品名称：左颜右色 男士洗面奶\r品牌: 左颜右色\r品名: 男士洗面奶\r批准文号: 粤G妆网备字2018171116\r适合肤质: 任何肤质\r上市时间: 2018年\r功效: 清洁 抗痘 控油 去黑头 深层清洁化妆品净含量: 450g规格类型: 正常规格\r是否为特殊用途化妆品: 否\r限期使用日期范围: 2022-11-23至2022-11-25\r化妆品保质期: 36个月\r', 3);
INSERT INTO `tb_goods` VALUES (22, 'AHC男士洗面奶控油去黑头专用祛痘美白补水保湿洁面除螨虫护肤品\r原装进口 假一赔十 控油祛痘 收敛毛孔\r', '2021-07-05', '23.jpg', 259, 5, '产品名称：A.H.C/爱和纯 AHC男士抗...\r品牌: A.H.C/爱和纯单品: AHC男士抗痘提亮洗面奶\r功效: 补水 保湿 抗痘 深层清洁化妆品\r净含量: 180.0ml\r是否为特殊用途化妆品: 否\r限期使用日期范围: 2021-09-30至2022-09', 3);
INSERT INTO `tb_goods` VALUES (23, '遮瑕 自然呈现肌肤光泽，细腻养肤', '2021-06-02', '24.jpg', 399, 5, '产品名称：SHAKEUP 滋润亮白遮瑕BB霜...\r品牌: SHAKEUP\r品名: 滋润亮白遮瑕BB霜(自然色)\r产地: 英国\r颜色分类: 自然色1 小麦色1 古铜色1\r适合肤质: 任何肤质功效: 保湿 修饰肤色 提升气色 隐形毛孔\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r', 3);
INSERT INTO `tb_goods` VALUES (24, '男士素颜霜遮瑕膏美白懒人BB霜遮痘印自然面霜修颜粉底液化妆品\r一抹变帅 自然提亮遮瑕不假白 无需卸妆\r', '2021-02-24', '25.jpg', 59, 5, '产品名称：SIVSAZ 臻皙焕亮美白素颜霜\r品牌: SIVSAZ\r品名: 臻皙焕亮美白素颜霜\r批准文号: 国妆特字G20200830\r适合肤质: 任何肤质\r功效: 提亮肤色 美白 祛斑 补水 保湿化妆品\r净含量: 50g规格类型: 正常规格\r为特殊用途化妆品: 是\r产品类别: 祛斑类限期使用日期范围: 2023-10-01至2023-10-3', 3);
INSERT INTO `tb_goods` VALUES (25, '尊蓝男士化妆品遮瑕淡妆粉底bb霜初学者全套专用新手彩妆套装正品\r旗舰店正品 自然遮痘印 初学者妆容化妆\r', '2021-07-28', '26.jpg', 499, 5, '品牌: PRIME BLUE/尊蓝\r品名: 男士粉底液套装\r产地: 中国\r颜色分类: 自然色基础套装（买就送化妆教程） 小麦色基础套装（买就送化妆教程） 自然色懒人套装（买就送化妆教程） 小麦色懒人套装（买就送化妆教程） 自然色新手全套（买就送修眉套装+化妆教程） 小麦色新手全套（买就送修眉套装+化妆教程）\r批准文号: 粤G妆网备字2020035138\r功效: 其他规格类型: 正常规格\r是否为特殊用途化妆品: 否\r', 3);
INSERT INTO `tb_goods` VALUES (26, '妮维雅小蓝管水活畅透精华露擦脸的男士护肤化妆品补水保湿正品\r补水保湿 经典小蓝管\r', '2021-07-06', '27.jpg', 105, 5, '品牌: Nivea/妮维雅男士护理\r单品: 男士水活畅透精华露组合\r产地: 中国\r批准文号: 沪G妆网备字2016011840\r保质期: 3年\r适合肤质: 任何肤质\r上市时间: 2015年\r功效: 补水 保湿 控油 滋润 舒缓肌肤化妆品\r净含量: 套装容量规格类型: 正常规格\r是否为特殊用途化妆品: 否\r', 3);
INSERT INTO `tb_goods` VALUES (27, 'Toc Man男士粉底液自然色素颜遮瑕bb霜遮黑眼圈痘印斑专用化妆品\r遮盖黑眼圈、痘印、斑点，均匀肤色自然变帅\r', '2021-06-01', '28.jpg', 159, 5, '产品名称：Toc Man 酷感男士粉底液\r品牌: Toc Man\r品名: 酷感男士粉底液\r产地: 中国\r净含量: 45ml\r颜色分类: 酷感男士粉底液-00#浅藕色 酷感男士粉底液-01#自然色 酷感男士粉底液-02#小麦色 00#浅藕色粉底液+洁面膏 01#自然色粉底液+洁面膏 02#小麦色+洁面膏批准文号: 粤G妆网备字2020216127\r保质期: 3年\r适合肤质: 任何肤质\r功效: 控油 修饰肤色 修颜 提升气色 隐形毛孔\r规格类型: 正常规格是\r', 3);
INSERT INTO `tb_goods` VALUES (28, '欧莱雅男士锐能抗皱紧致眼霜淡化黑眼圈干细纹保湿补水护肤化妆品\r', '2021-06-01', '29.jpg', 99, 5, '品牌: L\'OREAL /欧莱雅欧莱雅\r单品: 男士锐能抗皱紧致眼霜\r产地: 中国\r批准文号: 苏G妆网备字2017003289\r功效: 提拉紧致 去黑眼圈 去眼袋化妆品\r净含量: 15g/ml\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r', 3);
INSERT INTO `tb_goods` VALUES (29, '杰威尔睡眠面膜免洗男士补水面膜温润保湿收缩毛孔夜间化妆护肤品\r', '2021-06-16', '30.jpg', 158, 5, '产品名称：JVR/杰威尔 男士深海矿物...\r品牌: JVR/杰威尔男士护理\r单品: 男士深海矿物补水修护睡眠面膜\r批准文号: 粤G妆网备字2018164670\r适合肤质: 任何肤质\r上市时间: 2015年\r功效: 补水 保湿 收缩毛孔 滋润 舒缓肌肤化妆品\r净含量: 120g\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r限期使用日期范围: 2021-12-16至2022-12-15\r化妆品保质期: 36个月\r', 3);
INSERT INTO `tb_goods` VALUES (30, '极男男士洗面奶除螨控油补水保湿深层清洁专用氨基酸洁面乳男套装\r草本配方除螨 约旦进口海盐 除螨率99.79%\r', '2021-04-13', '21.jpg', 158, 3, '产品名称：极男 海盐净颜控油洁面乳\r品牌: 极男品名: 海盐净颜控油洁面乳\r批准文号: 粤G妆网备字2021094769适合肤质: 任何肤质功效: 净化毛孔 清洁 净爽畅透化妆品\r净含量: 200g 202g 206g 207g\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r限期使用日期范围: 2023-04-30至2023-05-31化妆品保质期: 36个月\r', 3);
INSERT INTO `tb_goods` VALUES (31, '袋鼠妈妈 孕妇护肤舒纹套装 孕妇化妆品 补水保湿哺乳期孕期护肤\r袋鼠妈妈 源自澳洲\r', '2021-07-07', '32.jpg', 218, 2, '产品参数：\r\r品牌: Kangaroo Mommy/袋鼠妈妈\r颜色分类: 保湿舒纹款 润泽舒纹款\r适用阶段: 全阶段\r货号: DsTz04509\r功效: 补水\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r', 4);
INSERT INTO `tb_goods` VALUES (32, '迪凯瑞妈妈婴儿温和养肤系列 母婴套装护肤品3件套 孕妇专用 包邮\r', '2021-01-21', '33.jpg', 95, 2, '品牌: 迪凯瑞面部护理套装\r单品: 其他/other产地: 瑞士\r颜色分类: 母婴3件套 水乳霜 母婴5件套 洁面水乳眼霜面霜 母婴3件套 洁面水乳 妈妈婴儿温和保湿洁面膏 妈妈婴儿温和保湿养肤凝露 妈妈婴儿温和保湿养肤凝乳 妈妈婴儿温和保湿养肤凝霜 妈妈婴儿温和保湿啫喱眼霜\r适合肤质: 任何肤质\r功效: 补水 保湿\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r', 4);
INSERT INTO `tb_goods` VALUES (33, '日本原装asnami安弥儿孕妇专用护肤品天然补水舒润保湿水乳套装\r', '2019-10-02', '34.jpg', 128, 5, '品牌: asnami\r颜色分类: 舒润保湿化妆水120ml 舒润保湿乳液100ml 化妆水120ml+乳液100ml 洁面泡沫150ml+化妆水120ml+乳液100ml 身体护理油120ml 保湿精华30ml\r批准文号: 国妆特字G20160001\r适用阶段: 备孕 产后 \r全阶段货号: ANEZH001\r功效: 保湿\r规格类型: 正常规格\r是否为特殊用途化妆品: 是\r产品类别: 防晒类\r', 4);
INSERT INTO `tb_goods` VALUES (34, 'UKU屏障修护乳 保湿修复平衡水油敏感肌肤专用护肤品母婴可用\r', '2020-06-17', '35.jpg', 158, 5, '品牌: UKU品名: UKU屏障修护乳\r产地: 其他/other\r保质期: 3年\r适合肤质: 所有肤质\r上市时间: 2015年月份: 10月\r功效: 修护 增加皮肤弹性\r化妆品净含量: 100g/mL\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r', 4);
INSERT INTO `tb_goods` VALUES (35, '澳梦母婴芦荟胶孕妇护肤品面霜哺乳期可用补水化妆品孕期专用天然\r', '2021-01-26', '36.jpg', 58, 3, '产品名称：AOMG/澳梦 芦荟胶母婴专用\r品牌: AOMG/澳梦品名: 芦荟胶母婴专用\r产地: 中国\r批准文号: 沪G妆网备字2016018902\r适合肤质: 所有肤质\r上市时间: 2010/1\r功效: 修护 改善皱纹 保湿化妆品\r净含量: 50g规格类型: 正常规格\r是否为特殊用途化妆品: 否\r限期使用日期范围: 2021-10-04至2022-10-\r09', 4);
INSERT INTO `tb_goods` VALUES (36, '巴布豆婴儿润肤乳宝宝霜保湿秋冬滋润补水多效霜护肤品幼儿童面霜\r', '2020-11-05', '37.jpg', 158, 5, '品牌: Bobdog/巴布豆系列(型号): BOB-50086巴布豆婴儿保湿润肤霜\r容量: 35G\r适用年龄: 新生 1个月 2个月 3个月 4个月 5个月 6个月 7个月 8个月 9个月 10个月 11个月 12个月 13个月 14个月 15个月 16个月 17个月 18个月 19个月 20个月 21个月 22个月 23个月 2岁 3岁 4岁 5岁 6岁 7岁 8岁 9岁 10岁 11岁 12岁 13岁 14岁\r产地: 中国大陆净含量: 31g(含)-50g(含)\r颜色分类: 巴布豆婴儿保湿润肤霜35G\r是否为特殊用途化妆品: 否\r', 4);
INSERT INTO `tb_goods` VALUES (37, '迪士尼新生婴儿儿童面霜宝宝霜滋润秋冬保湿补水擦脸油润肤护肤品\r滋润嫩弹、自然多效呵护\r', '2021-06-29', '38.jpg', 42, 2, '品牌: Disney/迪士尼\r系列: 儿童倍润保湿润肤霜\r容量: 50g\r适用年龄: 8个月 9个月 10个月 11个月 12个月 13个月 14个月 15个月 16个月 17个月 18个月 19个月 20个月 21个月 22个月 23个月 2岁 25个月 26个月 27个月 28个月 29个月 30个月 31个月 32个月 33个月 34个月 35个月 3岁 4岁 5岁 6岁 7岁 8岁 9岁 10岁 11岁 12岁 13岁 14岁\r产地: 中国大陆\r净含量: 50mL\r颜色分类: DDN3009-MM沁润保湿霜50ml DDN3010-MM防皴倍润霜50ml DDN3011-MM山茶油舒润霜50ml DDN3001-M矢车菊舒敏保湿霜50ml XHDDN3002倍润润肤面霜（矢车菊+橄榄精华）50g DDN3007-S三色堇舒缓补水霜50ml XHDDN3008舒润防皴面霜（三色堇+橄榄精华）50g\r是否为特殊用途化妆品: 否\r', 4);
INSERT INTO `tb_goods` VALUES (38, '【爆款推荐】日本原装asnami安弥儿孕妇专用护肤品套装5件套\r价格\r', '2021-01-21', '39.jpg', 940, 2, '品牌: asnami\r颜色分类: 【镶金礼盒5件套】赠身体乳 【无礼盒5件套】赠身体乳 【镶金礼盒5件套】赠眼霜 【无礼盒5件套】赠眼霜\r适用阶段: 备孕 产后 全阶段\r货号: 海藻高保湿5件套功效: 保湿 滋润 舒缓肌肤 \r补水规格类型: 正常规格\r是否为特殊用途化妆品: 否\r', 4);
INSERT INTO `tb_goods` VALUES (39, '养诗清控油清痘水乳精华套装油皮痘肌乳糖酸淡化痘印正品护肤品\r控制油脂分泌，滋养保湿肌肤，修护痘印\r', '2021-06-30', '40.jpg', 145, 3, '品牌: life engines\r品名: 养诗清面部护理套装\r产地: 中国\r颜色分类: 清痘水120ml+清痘乳100ml+平衡精华30ml 清痘水120ml 清痘乳100ml 清痘精华30ml 清痘水120ml+清痘乳100ml 清痘乳+养诗清面膜 清痘水+清痘乳+平衡精华+面膜 清痘水+清痘乳+洗面奶 清痘水+清痘乳+平衡精华+洗面奶\r批准文号: 沪G妆网备字2020010601\r保质期: 3年适合肤质: 油性肤质\r上市时间: 2020年\r功效: 抗痘 控油 舒缓肌肤 修护 持久保湿\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r限期使用日期范围: 2020-07-31至2023-05\r', 4);
INSERT INTO `tb_goods` VALUES (40, '袋鼠妈妈 孕妇护肤品套装保湿孕妇化妆品 补水天然怀孕期官网正品\r宠肤有道 燕窝一套源源输送孕肌营养\r', '2021-07-03', '31.jpg', 899, 4, '品牌: Kangaroo Mommy/袋鼠妈妈\r颜色分类: 燕窝深润保湿6件套 燕窝保湿锁水6件套 燕窝保湿亮颜6件套 燕窝保湿防晒6件套\r适用阶段: 全阶段\r货号: xrtz601\r功效: 滋润\r规格类型: 正常规格\r是否为特殊用途化妆品: 否\r', 4);

-- ----------------------------
-- Table structure for tb_goods_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_type`;
CREATE TABLE `tb_goods_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` int(11) NULL DEFAULT NULL,
  `Parent` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_goods_type
-- ----------------------------
INSERT INTO `tb_goods_type` VALUES (1, '护肤', 1, 0);
INSERT INTO `tb_goods_type` VALUES (2, '彩妆', 1, 0);
INSERT INTO `tb_goods_type` VALUES (3, '男士专区', 1, 0);
INSERT INTO `tb_goods_type` VALUES (4, '母婴专区', 1, 0);
INSERT INTO `tb_goods_type` VALUES (5, '男士专区', 1, 0);

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  `money` int(11) NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `aid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_order_uid`(`uid`) USING BTREE,
  INDEX `fk_order_aid`(`aid`) USING BTREE,
  CONSTRAINT `fk_order_aid` FOREIGN KEY (`aid`) REFERENCES `tb_address` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_order_uid` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('20201227232936375', 14, 73, '1', '2020-12-27 23:29:36', 8);
INSERT INTO `tb_order` VALUES ('20210621112211783', 15, 23, '1', '2021-06-21 11:22:11', 9);
INSERT INTO `tb_order` VALUES ('20210621112852903', 15, 50, '1', '2021-06-21 11:28:52', 9);
INSERT INTO `tb_order` VALUES ('20210702221003480', 15, 370, '1', '2021-07-02 22:10:03', 9);

-- ----------------------------
-- Table structure for tb_orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `tb_orderdetail`;
CREATE TABLE `tb_orderdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Oid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `Money` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_order_pid`(`pid`) USING BTREE,
  INDEX `fk_order_id`(`Oid`) USING BTREE,
  CONSTRAINT `fk_order_id` FOREIGN KEY (`Oid`) REFERENCES `tb_order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_order_pid` FOREIGN KEY (`pid`) REFERENCES `tb_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_orderdetail
-- ----------------------------
INSERT INTO `tb_orderdetail` VALUES (10, '20210621112211783', 2, 1, 23);
INSERT INTO `tb_orderdetail` VALUES (11, '20210621112852903', 1, 1, 50);
INSERT INTO `tb_orderdetail` VALUES (12, '20210702221003480', 11, 2, 370);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `flag` int(11) NULL DEFAULT NULL,
  `role` int(11) NULL DEFAULT NULL,
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (6, 'admin', '123456', '2407359193@qq.com', '女', 1, 0, '2018012218370268135d');
INSERT INTO `tb_user` VALUES (11, 'simian', 'e10adc3949ba59abbe56e057f20f883e', '2385115506@qq.com', '男', 1, 1, '20201223151457858cc');
INSERT INTO `tb_user` VALUES (12, 'chenyuanji', 'fcea920f7412b5da7be0cf42b8c93759', '2385115506@qq.com', '男', 0, 1, '20201223162134143cf');
INSERT INTO `tb_user` VALUES (14, 'chen', '123456', '2385115506@qq.com', '男', 1, 1, '202012272038541561c4');
INSERT INTO `tb_user` VALUES (15, 'caiyunzhi', '1234567', '2385115506@qq.com', '男', 1, 1, '20210621111636720130');

SET FOREIGN_KEY_CHECKS = 1;
