-- --------------------------------------------------------
-- ホスト:                          127.0.0.1
-- サーバーのバージョン:                   10.5.4-MariaDB - mariadb.org binary distribution
-- サーバー OS:                      Win64
-- HeidiSQL バージョン:               11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- novelgame のデータベース構造をダンプしています
CREATE DATABASE IF NOT EXISTS `novelgame` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;
USE `novelgame`;

--  テーブル novelgame.administer の構造をダンプしています
CREATE TABLE IF NOT EXISTS `administer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ad_name` varchar(50) DEFAULT NULL,
  `ad_pass` varchar(50) DEFAULT NULL,
  `ad_loginid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ad_loginid` (`ad_loginid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- テーブル novelgame.administer: ~2 rows (約) のデータをダンプしています
DELETE FROM `administer`;
/*!40000 ALTER TABLE `administer` DISABLE KEYS */;
INSERT INTO `administer` (`id`, `ad_name`, `ad_pass`, `ad_loginid`) VALUES
	(1, '天月 紫苑', 'mikofox1123', 'ez8kgy24'),
	(2, 'administer', 'root99', 'root');
/*!40000 ALTER TABLE `administer` ENABLE KEYS */;

--  テーブル novelgame.affilication_office の構造をダンプしています
CREATE TABLE IF NOT EXISTS `affilication_office` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ao_name` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ao_name` (`ao_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.affilication_office: ~9 rows (約) のデータをダンプしています
DELETE FROM `affilication_office`;
/*!40000 ALTER TABLE `affilication_office` DISABLE KEYS */;
INSERT INTO `affilication_office` (`id`, `ao_name`) VALUES
	(9, 'ぷろだくしょんバオバブ'),
	(7, 'シグマ・セブン'),
	(4, 'ネヴァーランド・アーツ'),
	(6, 'パワー・ライズ'),
	(1, 'フリーランス'),
	(2, 'プロ・フィット'),
	(5, 'ラブトラックス'),
	(3, '東京俳優生活協同組合'),
	(8, '賢プロダクション');
/*!40000 ALTER TABLE `affilication_office` ENABLE KEYS */;

--  テーブル novelgame.allage_brand の構造をダンプしています
CREATE TABLE IF NOT EXISTS `allage_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ab_name` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `co_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ab_name` (`ab_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.allage_brand: ~0 rows (約) のデータをダンプしています
DELETE FROM `allage_brand`;
/*!40000 ALTER TABLE `allage_brand` DISABLE KEYS */;
INSERT INTO `allage_brand` (`id`, `ab_name`, `co_id`) VALUES
	(1, 'ARIA', 1);
/*!40000 ALTER TABLE `allage_brand` ENABLE KEYS */;

--  テーブル novelgame.animation_va の構造をダンプしています
CREATE TABLE IF NOT EXISTS `animation_va` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `av_name` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `av_namespell` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `av_gender` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL,
  `av_place` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `av_birthday` date DEFAULT NULL,
  `av_blood` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL,
  `av_debut` year(4) DEFAULT NULL,
  `ao_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `av_name` (`av_name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.animation_va: ~10 rows (約) のデータをダンプしています
DELETE FROM `animation_va`;
/*!40000 ALTER TABLE `animation_va` DISABLE KEYS */;
INSERT INTO `animation_va` (`id`, `av_name`, `av_namespell`, `av_gender`, `av_place`, `av_birthday`, `av_blood`, `av_debut`, `ao_id`) VALUES
	(1, '高森 奈津美', 'たかもり なつみ', '女性', '山梨県甲府市', '1987-02-14', 'A', '2009', 2),
	(2, '種崎 敦美', 'たねざき あつみ', '女性', '大分県', '9999-09-27', 'A', NULL, 3),
	(3, 'あさみ ほとり', 'あさみ ほとり', '女性', '富山県', '9999-10-22', 'O', NULL, 4),
	(4, '田口 宏子', 'たぐち ひろこ', '女性', '神奈川県', '1974-03-29', 'AB', NULL, 3),
	(5, '生天目 仁美', 'なばため ひとみ', '女性', '神奈川県横浜市', '1976-08-04', 'B', '2003', 8),
	(6, '野々瀬 ミオ', 'ののせ みお', '女性', '東京都', '9999-02-11', NULL, NULL, 1),
	(7, '後藤 麻衣', 'ごとう まい', '女性', '北海道帯広市', '1982-08-22', 'B', '2003', 8),
	(8, '氷青', 'ひょうせい', '女性', '千葉県', '1973-04-21', NULL, '1990', 6),
	(9, '黒河 奈美', 'くろかわ なみ', '女性', '大阪府', '1980-01-25', NULL, '2001', 9),
	(10, '伊藤 静', 'いとう しづか', '女性', '東京都', '1980-12-05', 'O', '2003', 8),
	(11, '結下 みちる', 'ゆいもと みちる', '女性', '東京都', '9999-02-25', 'AB', '2004', 1),
	(12, '高野 直子', 'たかの なおこ', '女性', '東京都', '1968-06-16', 'AB', '1996', 7);
/*!40000 ALTER TABLE `animation_va` ENABLE KEYS */;

--  テーブル novelgame.brand の構造をダンプしています
CREATE TABLE IF NOT EXISTS `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `br_name` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `co_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `br_name` (`br_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.brand: ~7 rows (約) のデータをダンプしています
DELETE FROM `brand`;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` (`id`, `br_name`, `co_id`) VALUES
	(1, 'オーガスト(AUGUST)', 1),
	(2, 'ぱれっと', 2),
	(3, 'SWEET&TEA', 2),
	(4, 'Recette', 2),
	(5, 'ゆずソフト', 3),
	(6, 'Lump of Sugar', 4),
	(7, 'QUINCE SOFT', 4);
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;

--  テーブル novelgame.club の構造をダンプしています
CREATE TABLE IF NOT EXISTS `club` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cl_name` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cl_name` (`cl_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.club: ~0 rows (約) のデータをダンプしています
DELETE FROM `club`;
/*!40000 ALTER TABLE `club` DISABLE KEYS */;
INSERT INTO `club` (`id`, `cl_name`) VALUES
	(1, 'ロケット野郎');
/*!40000 ALTER TABLE `club` ENABLE KEYS */;

--  テーブル novelgame.company の構造をダンプしています
CREATE TABLE IF NOT EXISTS `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `co_name` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `co_year` year(4) DEFAULT NULL,
  `co_address` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `co_name` (`co_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.company: ~4 rows (約) のデータをダンプしています
DELETE FROM `company`;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` (`id`, `co_name`, `co_year`, `co_address`) VALUES
	(1, '株式会社葉月', NULL, '東京都中野区東中野2-22-20 ホシノ第二ビル3F'),
	(2, '株式会社クリアレーヴ', '2002', '東京都三鷹市下連雀3-32-3　名取屋興産ビル2階201号'),
	(3, '株式会社ユノス', NULL, '大阪府大阪市'),
	(4, '有限会社ランプオブシュガー', NULL, '東京都台東区台東１丁目２７番１１号やわらぎビル３階');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;

--  テーブル novelgame.graphic_creator の構造をダンプしています
CREATE TABLE IF NOT EXISTS `graphic_creator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gc_name` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `gc_gender` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL,
  `gc_place` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `gc_birthday` date DEFAULT NULL,
  `gc_blood` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL,
  `br_id` int(11) DEFAULT NULL,
  `cl_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `gc_name` (`gc_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.graphic_creator: ~5 rows (約) のデータをダンプしています
DELETE FROM `graphic_creator`;
/*!40000 ALTER TABLE `graphic_creator` DISABLE KEYS */;
INSERT INTO `graphic_creator` (`id`, `gc_name`, `gc_gender`, `gc_place`, `gc_birthday`, `gc_blood`, `br_id`, `cl_id`) VALUES
	(1, '弥弛', NULL, NULL, NULL, NULL, 1, NULL),
	(2, 'ぺぺる', NULL, NULL, NULL, NULL, 1, NULL),
	(3, '阿舎利ん_16', NULL, NULL, NULL, NULL, 1, NULL),
	(4, '里見藤久', NULL, NULL, NULL, NULL, NULL, NULL),
	(5, '北川由貴', NULL, NULL, NULL, NULL, NULL, NULL),
	(6, 'ゆうろ', NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `graphic_creator` ENABLE KEYS */;

--  テーブル novelgame.illustrator の構造をダンプしています
CREATE TABLE IF NOT EXISTS `illustrator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `il_name` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `il_gender` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL,
  `il_place` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `il_birthday` date DEFAULT NULL,
  `il_blood` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL,
  `br_id` int(11) DEFAULT NULL,
  `cl_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `il_name` (`il_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.illustrator: ~2 rows (約) のデータをダンプしています
DELETE FROM `illustrator`;
/*!40000 ALTER TABLE `illustrator` DISABLE KEYS */;
INSERT INTO `illustrator` (`id`, `il_name`, `il_gender`, `il_place`, `il_birthday`, `il_blood`, `br_id`, `cl_id`) VALUES
	(1, 'べっかんこう', NULL, NULL, '9999-10-16', NULL, 1, 1),
	(2, '夏野イオ', NULL, NULL, NULL, NULL, 1, NULL);
/*!40000 ALTER TABLE `illustrator` ENABLE KEYS */;

--  テーブル novelgame.platform の構造をダンプしています
CREATE TABLE IF NOT EXISTS `platform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pl_name` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pl_name` (`pl_name`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.platform: ~21 rows (約) のデータをダンプしています
DELETE FROM `platform`;
/*!40000 ALTER TABLE `platform` DISABLE KEYS */;
INSERT INTO `platform` (`id`, `pl_name`) VALUES
	(19, '3DS'),
	(18, 'DS'),
	(20, 'android'),
	(21, 'iOS'),
	(9, 'ps'),
	(10, 'ps2'),
	(11, 'ps3'),
	(12, 'ps4'),
	(13, 'ps5'),
	(15, 'psVita'),
	(14, 'psp'),
	(17, 'switch'),
	(16, 'wii'),
	(8, 'win10'),
	(3, 'win2000'),
	(6, 'win7'),
	(7, 'win8'),
	(1, 'win98'),
	(2, 'winMe'),
	(5, 'winVista'),
	(4, 'winXP');
/*!40000 ALTER TABLE `platform` ENABLE KEYS */;

--  テーブル novelgame.producer の構造をダンプしています
CREATE TABLE IF NOT EXISTS `producer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pr_name` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `pr_gender` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL,
  `pr_place` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `pr_birthday` date DEFAULT NULL,
  `pr_blood` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL,
  `br_id` int(11) DEFAULT NULL,
  `cl_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pr_name` (`pr_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.producer: ~0 rows (約) のデータをダンプしています
DELETE FROM `producer`;
/*!40000 ALTER TABLE `producer` DISABLE KEYS */;
INSERT INTO `producer` (`id`, `pr_name`, `pr_gender`, `pr_place`, `pr_birthday`, `pr_blood`, `br_id`, `cl_id`) VALUES
	(1, 'るね', NULL, NULL, NULL, NULL, 1, NULL);
/*!40000 ALTER TABLE `producer` ENABLE KEYS */;

--  テーブル novelgame.product_gc の構造をダンプしています
CREATE TABLE IF NOT EXISTS `product_gc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pi_id` int(11) NOT NULL,
  `gc_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pi_id` (`pi_id`,`gc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.product_gc: ~11 rows (約) のデータをダンプしています
DELETE FROM `product_gc`;
/*!40000 ALTER TABLE `product_gc` DISABLE KEYS */;
INSERT INTO `product_gc` (`id`, `pi_id`, `gc_id`) VALUES
	(2, 1, 3),
	(1, 1, 4),
	(3, 1, 5),
	(4, 1, 6),
	(6, 2, 3),
	(5, 2, 4),
	(7, 2, 5),
	(8, 2, 6),
	(10, 3, 3),
	(9, 3, 4),
	(11, 3, 5),
	(12, 3, 6);
/*!40000 ALTER TABLE `product_gc` ENABLE KEYS */;

--  テーブル novelgame.product_il の構造をダンプしています
CREATE TABLE IF NOT EXISTS `product_il` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pi_id` int(11) NOT NULL,
  `il_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pi_id` (`pi_id`,`il_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.product_il: ~2 rows (約) のデータをダンプしています
DELETE FROM `product_il`;
/*!40000 ALTER TABLE `product_il` DISABLE KEYS */;
INSERT INTO `product_il` (`id`, `pi_id`, `il_id`) VALUES
	(1, 1, 1),
	(2, 2, 1),
	(3, 3, 1);
/*!40000 ALTER TABLE `product_il` ENABLE KEYS */;

--  テーブル novelgame.product_info の構造をダンプしています
CREATE TABLE IF NOT EXISTS `product_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `br_id` int(11) NOT NULL,
  `release_date` date NOT NULL,
  `series` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `engine` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `pi_comment` text COLLATE utf8mb4_bin DEFAULT NULL,
  `pi_text` text COLLATE utf8mb4_bin DEFAULT NULL,
  `change_date` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.product_info: ~41 rows (約) のデータをダンプしています
DELETE FROM `product_info`;
/*!40000 ALTER TABLE `product_info` DISABLE KEYS */;
INSERT INTO `product_info` (`id`, `title`, `br_id`, `release_date`, `series`, `engine`, `pi_comment`, `pi_text`, `change_date`) VALUES
	(1, '夜明け前より瑠璃色な', 1, '2005-09-22', '夜明け前より瑠璃色な', 'Ethornell', '無印版', '大昔に月に渡った人々が作ったスフィア王国（月王国）。だが、500年から660年前頃に起こった第1次〜第4次オイディプス戦争以降、地球との関係は冷え切った状態が続いており、地球における唯一の窓口である「満弦ヶ崎中央連絡港市」に王国の大使館、月人居住区画、王立月博物館などが設置されているものの、一般市民の月との往還はほとんどなくなっていた。そんな満弦ヶ崎中央連絡港市に住む朝霧家に、月王国の王女がホームステイすることになった。 ', '2006-10-14 09:35:40'),
	(2, '夜明け前より瑠璃色な -Brighter than dawning blue-', 1, '2006-12-07', '夜明け前より瑠璃色な', 'Ethornell', 'PS2版。', '性描写のカットだけでなく、新ヒロイン追加やストーリーに若干手直しが入っていたりと、ボリュームや世界観設定が増えている。', '2007-08-20 09:35:40'),
	(3, '夜明け前より瑠璃色な -Brighter than dawning blue- for PC', 1, '2009-02-27', '夜明け前より瑠璃色な', 'Ethornell', 'PS2版をPCに移植したもの。', 'ストーリーの加筆修正が加えられているPS2版に性描写を加えた完成形。', '2010-12-14 09:35:40'),
	(4, '夜明け前より瑠璃色な -Moonlight Cradle-', 1, '2009-02-27', '夜明け前より瑠璃色な', 'Ethornell', 'アフターストーリー、最終章。-Brighter than dawning blue- for PCのアフターストーリ＆Trueルート完結編に加え、新ヒロインが追加されている。', '本作は -Brighter than dawning blue- for PCの続編にあたり、各キャラクターの後日談と最終章が描かれているが、新キャラクターであるシンシア・マルグリットのストーリーに関しては新規シナリオとなっており、ストーリーの開始時間はフィーナが留学を終えて月へ帰った後となっている。 ', '2010-12-14 09:35:40'),
	(5, 'FORTUNE ARTERIAL', 1, '2008-01-25', NULL, 'Ethornell', NULL, '海上交通の要である「珠津島」（たまつしま）。そこには、桜の名所・珠津山や枯れない池と伝えられる千年泉がある。支倉孝平は、父親の海外転勤を機に7年ぶりに珠津島へ戻り、6年制・全寮制の英国パブリックスクール風名門校「修智館学院」（しゅうちかんがくいん）へ転入する。幼馴染みである悠木姉妹との再会、八幡平司という友人を得るなど、順調なスタートに見えた学院生活だったが、悪戯好きの生徒会長・千堂伊織の策略により、千堂の妹で生徒会副会長である千堂瑛里華が入っている風呂場へ突入することに。一躍有名人となるものの、会長の策略と判明して騒ぎも終結。瑛里華とも仲直りを果たした。しかし伊織は孝平に、自らと瑛里華が吸血鬼であることを明かす。', '2010-08-14 09:35:40'),
	(6, '穢翼のユースティア', 1, '2011-04-28', NULL, 'Ethornell', NULL, '《ノーヴァス・アイテル》は、かつて人間が神に見捨てられ、世界が混沌の濁流に飲み込まれた時、聖女イレーヌが神に許しを請い、それを受けいれた神によって空に浮かせられた都市である。以後数百年、代々引き継がれた聖女イレーヌの力によって、この浮遊都市は守られてきた。《ノーヴァス・アイテル》には貴族が住む上層と、民衆が住む下層の2つの区域があった。10数年前、《終わりの夕焼け（トラジェディア）》と呼ばれる光が天蓋を覆い、《ノーヴァス・アイテル》の下層の一部が地盤沈下した。後に《大崩落（グラン・フォルテ）》と呼ばれるこの悲劇では多くの人々が死に、生き残った人々の生活も激変させた。地盤沈下した区域は後に「牢獄」と呼ばれるようになる。牢獄の周囲は断崖絶壁となり、他の層とは容易に行き来ができなくなった。国が《特別被災地区》として見放し、無秩序状態に陥った牢獄で、ボルツ・グラードは《不蝕金鎖》（ふしょくきんさ）と呼ばれる組織を作り、下層との物資をやり取りする仕組みを作って物流を独占した。そして手をこまねくだけの取り残された役人に代わって規律を作り、復興に尽力することによって、牢獄の事実上トップの組織となった。今でも《不蝕金鎖》は牢獄を支えている。かつて《不蝕金鎖》で暗殺者として働いていたカイムは、今は娼館街の何でも屋として生きている。ある日、ボルツの息子で《不蝕金鎖》の頭であるジークフリードから依頼を受け、上層から売られた女性たちを連れて牢獄へ向かう馬車を迎えに行ったが、そこで見たのは女性たちの惨殺死体であった。その中で1人だけ生きていたのは、背中に羽が生える羽化病に罹患した少女ユースティアであった。', '2012-03-28 09:35:40'),
	(7, '大図書館の羊飼い', 1, '2013-01-25', '大図書館の羊飼い', 'Ethornell', NULL, '学生数5万人、教職員8000人を数える国内有数の学校法人「汐美学園」。数多くの学生寮、各種スポーツ施設はもちろん、カフェレストランから路面電車まで備える充実ぶりで、特に「大図書館」は国立図書館に次ぐ規模と言われている。筧京太郎はここ大図書館で、幽霊部員だらけの「図書部」に所属し、1人でゆったりと本を読んでいた。4月。どんな願いでも叶えてくれることで有名な謎の羊飼いから「今日、貴方の運命を変える出来事があるでしょう」というメールをもらった筧は、白崎つぐみと知り合う。友人の桜庭玉藻と共に学園をもっと楽しくするための活動を始めていたつぐみは、玉藻や筧の友人・高峰一景と共に図書部へ入部する。生徒からの相談を受け付け、悩みを解決することで学園を楽しくしようという活動を通じ、鈴木佳奈と御園千莉も入部した。コスプレによるビラ配りで知名度を上げた図書部は多数の依頼を受けるようになり、図書委員の小太刀凪からの注意を受けつつ、6月には独自のイベント「ミナフェス」を成功させた。図書部の6人は何れも羊飼いから同様のメールを受け取っていたことから、活動と並行して羊飼いの謎を追っていたが、京太郎だけがついに正体を突き止めた。そして7月。図書部の活動を通し、筧は特定の女性の悩みと付き合い、深く触れあうようになる。', '2013-05-12 09:35:40'),
	(8, '大図書館の羊飼い〜放課後しっぽデイズ〜', 1, '2013-09-27', '大図書館の羊飼い', 'Ethornell', '主人公たちを外の視点から描いたスピンオフ作品。', '幼馴染みの桐島慶と土岐のぞみしか今は所属していない「ネコ写真部」。野良猫の写真を撮ってはホームページにアップしたり、学園祭で写真を売ったりしている。当然部室はなく、打合せは大食堂「アプリオ」で行っている。4月、部屋が隣同士である2人のマンションに、田舎で幼馴染みだった藤宮朔夜が家出してきた。2人の話に憧れ、反対するであろう母親に黙って汐美学園に合格したまではよかったが、そのことを打ち明けるとやはり大反対。結局荷物を持って慶の部屋にやってきたのだった。お金もわずかで住む所もないため、広い慶の部屋にのぞみと朔夜が、狭いのぞみの部屋に慶が住むこととなり、朔夜は無事に入学式を迎えた。朔夜もネコ写真部に入って一段落した5月、学園で一番ネコが集まる通称「ネコ広場」に新校舎が建設されることとなった。何とか阻止しようとする3人。しかし生徒会には建設延期の理由がないと拒否され、紹介された図書部でもよい案は出てこない。ネコ広場、そしてネコ写真部はどうなるのか。そしてのぞみと朔夜の2人の恋の決着は。', '2013-04-15 09:35:40'),
	(9, '大図書館の羊飼い -Dreaming Sheep-', 1, '2014-03-28', '大図書館の羊飼い', 'Ethornell', 'アフターストーリー。', '白崎つぐみ、桜庭玉藻、御園千莉、鈴木佳奈、小太刀凪、望月真帆、芹沢水結、嬉野紗弓実が筧京太郎と結ばれた後のストーリーが計8本。さらに、筧と多岐川葵が結ばれるストーリーと、筧が誰とも結ばれずに夏休みに突入した後～最終シナリオ開始までのストーリー1本が収録されている。メインヒロインはつぐみのみ、最終シナリオで生徒会長になった後のストーリーになっている。おまけストーリー13本の中には、土岐のぞみ、藤宮朔夜が桐島慶と恋人同士になった後のストーリー1本ずつと、白崎さよりが汐美学園に入った後のストーリー1本が含まれている。さより偏はPC版のみ収録されており、コンシューマー版には含まれていない。 ', '2015-02-18 09:35:40'),
	(10, '千の刃濤、桃花染の皇姫', 1, '2016-09-23', '千の刃濤、桃花染の皇姫', 'Ethornell', NULL, '皇国歴2142年、世界の大半を支配するオルブライト共和国（略称「共和国」）は豊葦原瑞籬内皇国（とよあしはらのみずがきのうちのすめらみことのくに）（略称「皇国」）への侵攻を開始。首都・天京の防壁「呪壁」は原因不明の障害により機能せず、皇国を守護する「武人」も空爆で大半が死亡した。皇国宰相・小此木時彦が皇帝「蘇芳帝」を弑逆し、皇国は敗戦する。 敗戦から三年後、先代蘇芳帝の唯一の娘にして正統なる帝位継承者である宮国朱璃は、母を殺した小此木時彦に復讐するため、天京へ帰還する。戦争の中で記憶を失った武人の鴇田宗仁、現在の皇帝「翡翠帝」こと鴇田奏海、若くして「齋巫女」を務める椎葉古杜音、武人の地下組織「奉刀会」を率いる稲生滸、共和国総督の娘エルザ・ヴァレンタインと出会い、物語が始まる。 ', '2017-08-18 09:35:40'),
	(11, 'あいりすミスティリア!〜少女のつむぐ夢の秘跡〜', 1, '2017-12-19', NULL, 'Ethornell', 'ブラウザゲーム。', '主人公である「冥王」は、世界を作った神々の1人として、輪廻転生を管理する役割を担っていた。ある日、輪廻をつかさどる世界樹が原因不明の大炎上を起こし、冥王の尽力により世界樹は消失こそ免れたがその大半が焼け落ちてしまった。輪廻転生を行うための世界樹が休眠状態に陥ってしまったことにより人間界では新たに人が産まれなくなってしまった。 それから1年、冥王は世界樹の聖霊ユーと出会い、世界樹の力の源である種子が人間界に飛び散ってしまったことを知る。 さっそく冥王は世界樹を元に戻すため人間界に赴くも、信仰が薄れた事によって人間界での冥王の力はあまりにも弱くなっていた。それでも、身体に種子を宿した少女アシュリーの活躍によりなんとか種子を持ち帰ることに成功した。 それから2か月、冥王は冥界に「エディア・ローファ樹理学園」を創立、そこに身体に種子を宿した少女たちを集め、彼女たちをアイリスと名付けた', '2018-01-15 09:35:40'),
	(12, '千の刃濤、桃花染の皇姫 -花あかり-', 1, '2019-09-27', '千の刃濤、桃花染の皇姫', 'Ethornell', 'アフターストーリー。', 'ファンディスク。各ヒロインとの後日談やエピソードに加え、本編では攻略対象ではなかった登場人物とのエピソードも収録。', '2019-11-16 09:35:40'),
	(13, 'ましろ色シンフォニー', 2, '2009-10-30', NULL, NULL, NULL, NULL, '2011-03-10 09:35:40'),
	(14, 'みんな捧げちゃう!', 2, '2013-02-28', NULL, NULL, NULL, NULL, '2015-04-12 09:35:40'),
	(15, '恋がさくころ桜どき', 2, '2014-06-27', NULL, NULL, NULL, NULL, '2016-07-13 09:35:40'),
	(16, '9-nine- ここのつここのかここのいろ', 2, '2017-04-28', '9-nine-', '吉里吉里Z', 'シリーズ4部作の1作目', NULL, '2018-06-18 09:35:40'),
	(17, '9-nine- そらいろそらうたそらのおと', 2, '2018-04-27', '9-nine-', '吉里吉里Z', 'シリーズ4部作の2作目', NULL, '2019-06-24 09:35:40'),
	(18, '9-nine- はるいろはるこいはるのかぜ', 2, '2019-04-26', '9-nine-', '吉里吉里Z', 'シリーズ4部作の3作目', NULL, '2019-07-09 09:35:40'),
	(19, '9-nine- ゆきいろゆきはなゆきのあと', 2, '2020-04-24', '9-nine-', '吉里吉里Z', 'シリーズ4部作の4作目', NULL, '2020-09-10 09:35:40'),
	(20, '枯れない世界と終わる花', 3, '2016-11-25', NULL, NULL, NULL, NULL, '2018-10-16 09:35:40'),
	(21, 'しゅがてん！', 4, '2017-02-24', NULL, NULL, NULL, NULL, '2018-10-16 09:35:40'),
	(22, '天神乱漫 -LUCKY or UNLUCKY!?-', 5, '2009-05-29', NULL, NULL, NULL, NULL, '2010-01-23 09:35:40'),
	(23, 'DRACU-RIOT!', 5, '2012-03-30', NULL, NULL, NULL, NULL, '2014-04-10 09:35:40'),
	(24, '天色*アイルノーツ', 5, '2013-07-26', NULL, NULL, NULL, NULL, '2014-07-20 09:35:40'),
	(25, 'サノバウィッチ', 5, '2015-02-27', NULL, NULL, NULL, NULL, '2016-05-15 09:35:40'),
	(26, '千恋*万花', 5, '2016-07-29', NULL, NULL, NULL, NULL, '2017-02-06 09:35:40'),
	(27, 'RIDDLE JOKER', 5, '2018-03-30', NULL, NULL, NULL, NULL, '2019-03-12 09:35:40'),
	(28, 'タユタマ -Kiss on my Deity-', 6, '2008-07-11', 'タユタマ', NULL, NULL, NULL, '2009-09-19 09:35:40'),
	(29, 'タユタマ -It\'s happy days-', 6, '2009-05-29', 'タユタマ', NULL, NULL, NULL, '2012-05-14 09:35:40'),
	(30, 'Hello,good-bye', 6, '2010-12-17', NULL, NULL, NULL, NULL, '2011-01-14 09:35:40'),
	(31, '学☆王 -THE ROYAL SEVEN STARS-', 6, '2012-01-27', '学☆王', NULL, NULL, NULL, '2013-08-14 09:35:40'),
	(32, '学☆王 -It\'s Heartful Days-', 6, '2012-08-10', '学☆王', NULL, NULL, NULL, '2012-08-12 09:35:40'),
	(33, '花色ヘプタグラム', 6, '2012-10-26', NULL, NULL, NULL, NULL, '2012-10-26 09:35:40'),
	(34, 'Magical Charming!', 6, '2013-05-31', NULL, NULL, NULL, NULL, '2013-05-31 09:35:40'),
	(35, '世界と世界の真ん中で', 6, '2014-01-31', NULL, NULL, NULL, NULL, '2014-01-31 09:35:40'),
	(36, '運命線上のφ', 6, '2014-10-31', NULL, NULL, NULL, NULL, '2014-10-31 09:35:40'),
	(37, '恋想リレーション', 6, '2015-05-29', NULL, NULL, NULL, NULL, '2015-11-27 09:35:40'),
	(38, 'コドモノアソビ', 6, '2015-11-27', NULL, NULL, NULL, NULL, '2015-11-27 09:35:40'),
	(39, 'タユタマ2 -you\'re the only one-', 6, '2016-09-23', 'タユタマ', NULL, NULL, NULL, '2016-09-23 09:35:40'),
	(40, 'タユタマ2 -After Stories-', 6, '2017-04-28', 'タユタマ', NULL, NULL, NULL, '2017-04-28 09:35:40'),
	(41, 'もののあはれは彩の頃。', 7, '2017-09-29', NULL, NULL, NULL, NULL, '2017-09-29 09:35:40');
/*!40000 ALTER TABLE `product_info` ENABLE KEYS */;

--  テーブル novelgame.product_pl の構造をダンプしています
CREATE TABLE IF NOT EXISTS `product_pl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pi_id` int(11) NOT NULL,
  `pl_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pi_id` (`pi_id`,`pl_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.product_pl: ~11 rows (約) のデータをダンプしています
DELETE FROM `product_pl`;
/*!40000 ALTER TABLE `product_pl` DISABLE KEYS */;
INSERT INTO `product_pl` (`id`, `pi_id`, `pl_id`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(3, 1, 3),
	(4, 1, 4),
	(5, 2, 10),
	(6, 3, 3),
	(7, 3, 4),
	(8, 3, 5),
	(9, 4, 3),
	(10, 4, 4),
	(11, 4, 5);
/*!40000 ALTER TABLE `product_pl` ENABLE KEYS */;

--  テーブル novelgame.product_pr の構造をダンプしています
CREATE TABLE IF NOT EXISTS `product_pr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pi_id` int(11) NOT NULL,
  `pr_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pi_id` (`pi_id`,`pr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.product_pr: ~2 rows (約) のデータをダンプしています
DELETE FROM `product_pr`;
/*!40000 ALTER TABLE `product_pr` DISABLE KEYS */;
INSERT INTO `product_pr` (`id`, `pi_id`, `pr_id`) VALUES
	(1, 1, 1),
	(2, 2, 1),
	(3, 3, 1);
/*!40000 ALTER TABLE `product_pr` ENABLE KEYS */;

--  テーブル novelgame.product_sc の構造をダンプしています
CREATE TABLE IF NOT EXISTS `product_sc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pi_id` int(11) NOT NULL,
  `sc_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pi_id` (`pi_id`,`sc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.product_sc: ~2 rows (約) のデータをダンプしています
DELETE FROM `product_sc`;
/*!40000 ALTER TABLE `product_sc` DISABLE KEYS */;
INSERT INTO `product_sc` (`id`, `pi_id`, `sc_id`) VALUES
	(1, 1, 1),
	(2, 2, 1),
	(3, 3, 1);
/*!40000 ALTER TABLE `product_sc` ENABLE KEYS */;

--  テーブル novelgame.product_sw の構造をダンプしています
CREATE TABLE IF NOT EXISTS `product_sw` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pi_id` int(11) NOT NULL,
  `sw_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pi_id` (`pi_id`,`sw_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.product_sw: ~12 rows (約) のデータをダンプしています
DELETE FROM `product_sw`;
/*!40000 ALTER TABLE `product_sw` DISABLE KEYS */;
INSERT INTO `product_sw` (`id`, `pi_id`, `sw_id`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(3, 1, 3),
	(4, 1, 5),
	(5, 2, 1),
	(6, 2, 2),
	(7, 2, 3),
	(8, 2, 5),
	(9, 3, 1),
	(10, 3, 2),
	(11, 3, 3),
	(12, 3, 5);
/*!40000 ALTER TABLE `product_sw` ENABLE KEYS */;

--  テーブル novelgame.product_va の構造をダンプしています
CREATE TABLE IF NOT EXISTS `product_va` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pi_id` int(11) NOT NULL,
  `va_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pi_id` (`pi_id`,`va_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.product_va: ~32 rows (約) のデータをダンプしています
DELETE FROM `product_va`;
/*!40000 ALTER TABLE `product_va` DISABLE KEYS */;
INSERT INTO `product_va` (`id`, `pi_id`, `va_id`) VALUES
	(1, 1, 7),
	(2, 1, 8),
	(3, 1, 9),
	(4, 1, 10),
	(5, 1, 11),
	(6, 1, 12),
	(7, 1, 13),
	(8, 2, 7),
	(9, 2, 8),
	(10, 2, 9),
	(11, 2, 10),
	(12, 2, 11),
	(13, 2, 12),
	(14, 2, 13),
	(15, 2, 14),
	(16, 3, 7),
	(17, 3, 8),
	(18, 3, 9),
	(19, 3, 10),
	(20, 3, 11),
	(21, 3, 12),
	(22, 3, 13),
	(23, 3, 14),
	(24, 4, 7),
	(25, 4, 8),
	(26, 4, 9),
	(27, 4, 10),
	(28, 4, 11),
	(29, 4, 12),
	(30, 4, 13),
	(31, 4, 14),
	(32, 4, 15);
/*!40000 ALTER TABLE `product_va` ENABLE KEYS */;

--  テーブル novelgame.scenario_writer の構造をダンプしています
CREATE TABLE IF NOT EXISTS `scenario_writer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sw_name` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `sw_gender` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL,
  `sw_place` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `sw_birthday` date DEFAULT NULL,
  `sw_blood` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL,
  `br_id` int(11) DEFAULT NULL,
  `cl_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sw_name` (`sw_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.scenario_writer: ~4 rows (約) のデータをダンプしています
DELETE FROM `scenario_writer`;
/*!40000 ALTER TABLE `scenario_writer` DISABLE KEYS */;
INSERT INTO `scenario_writer` (`id`, `sw_name`, `sw_gender`, `sw_place`, `sw_birthday`, `sw_blood`, `br_id`, `cl_id`) VALUES
	(1, '榊原 拓', NULL, NULL, NULL, NULL, 1, NULL),
	(2, '内田 ヒロユキ', NULL, NULL, NULL, NULL, 1, NULL),
	(3, '安西 秀明', NULL, NULL, NULL, NULL, 1, NULL),
	(4, '加賀宮 考一', NULL, NULL, NULL, NULL, 1, NULL),
	(5, '岡田 留奈', NULL, NULL, NULL, NULL, 1, NULL);
/*!40000 ALTER TABLE `scenario_writer` ENABLE KEYS */;

--  テーブル novelgame.sound_creator の構造をダンプしています
CREATE TABLE IF NOT EXISTS `sound_creator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sc_name` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `sc_gender` varchar(2) COLLATE utf8mb4_bin NOT NULL,
  `sc_place` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `sc_birthday` date DEFAULT NULL,
  `sc_blood` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL,
  `br_id` int(11) DEFAULT NULL,
  `cl_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sc_name` (`sc_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.sound_creator: ~0 rows (約) のデータをダンプしています
DELETE FROM `sound_creator`;
/*!40000 ALTER TABLE `sound_creator` DISABLE KEYS */;
INSERT INTO `sound_creator` (`id`, `sc_name`, `sc_gender`, `sc_place`, `sc_birthday`, `sc_blood`, `br_id`, `cl_id`) VALUES
	(1, 'ActivePlanets', '団体', NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `sound_creator` ENABLE KEYS */;

--  テーブル novelgame.voice_actor の構造をダンプしています
CREATE TABLE IF NOT EXISTS `voice_actor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `va_name` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `va_namespell` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `va_gender` varchar(2) COLLATE utf8mb4_bin NOT NULL,
  `va_place` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `va_birthday` date DEFAULT NULL,
  `va_blood` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL,
  `va_debut` year(4) DEFAULT NULL,
  `ao_id` int(11) DEFAULT NULL,
  `av_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `va_name` (`va_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- テーブル novelgame.voice_actor: ~15 rows (約) のデータをダンプしています
DELETE FROM `voice_actor`;
/*!40000 ALTER TABLE `voice_actor` DISABLE KEYS */;
INSERT INTO `voice_actor` (`id`, `va_name`, `va_namespell`, `va_gender`, `va_place`, `va_birthday`, `va_blood`, `va_debut`, `ao_id`, `av_id`) VALUES
	(1, '小鳥居 夕花', 'ことりい ゆうか', '女性', '山梨県甲府市', '1987-02-14', 'A', '2012', NULL, 1),
	(2, '桐谷 華', 'きりたに はな', '女性', '大分県', '9999-09-27', 'A', NULL, NULL, 2),
	(3, '沢澤 砂羽', 'さわさわ さわ', '女性', '大分県', '9999-09-27', 'A', NULL, NULL, 2),
	(4, '秋野 花', 'あきの はな', '女性', '富山県', '9999-10-22', 'O', NULL, NULL, 3),
	(5, '夏野 こおり', 'なつの こおり', '女性', '神奈川県', '1974-03-29', 'AB', '1995', NULL, 4),
	(6, '榊原 ゆい', 'さかきばら ゆい', '女性', '兵庫県', '9999-10-13', NULL, '1999', 4, NULL),
	(7, '手塚 まき', 'てづか まき', '女性', '神奈川県横浜市', '1976-08-04', 'B', NULL, NULL, 5),
	(8, '成瀬 未亜', 'なるせ みあ', '女性', '東京都', '9999-02-11', 'O', '2000', 1, 6),
	(9, '安玖深 音', 'あぐみ おと', '女性', '北海道帯広市', '1982-08-22', 'B', '2003', 1, 7),
	(10, '海原 エレナ', 'かいばら えれな', '女性', '千葉県', '1973-04-21', NULL, '1999', NULL, 8),
	(11, '本山 美奈', 'もとやま みな', '女性', '大阪府', '1998-01-25', NULL, NULL, NULL, 9),
	(12, '三咲 里奈', 'みさき りな', '女性', '東京都', '1980-12-05', 'O', '2003', NULL, 10),
	(13, '雅 姫乃', 'みやび ひめの', '女性', '東京都', '1968-06-16', 'AB', '1996', NULL, 12),
	(14, '佐本 二厘', 'さもと ふうり', '女性', '東京都', '9999-02-25', 'AB', '2004', NULL, 11),
	(15, '遠野 そよぎ', 'とおの そよぎ', '女性', NULL, NULL, NULL, '2003', NULL, NULL);
/*!40000 ALTER TABLE `voice_actor` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
