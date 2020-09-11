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


-- utility のデータベース構造をダンプしています
CREATE DATABASE IF NOT EXISTS `utility` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `utility`;

--  テーブル utility.prefectures の構造をダンプしています
CREATE TABLE IF NOT EXISTS `prefectures` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prefecture` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4;

-- テーブル utility.prefectures: ~47 rows (約) のデータをダンプしています
DELETE FROM `prefectures`;
/*!40000 ALTER TABLE `prefectures` DISABLE KEYS */;
INSERT INTO `prefectures` (`id`, `prefecture`) VALUES
	(1, '北海道'),
	(2, '青森県'),
	(3, '岩手県'),
	(4, '宮城県'),
	(5, '秋田県'),
	(6, '山形県'),
	(7, '福島県'),
	(8, '茨城県'),
	(9, '栃木県'),
	(10, '群馬県'),
	(11, '埼玉県'),
	(12, '千葉県'),
	(13, '東京都'),
	(14, '神奈川県'),
	(15, '新潟県'),
	(16, '富山県'),
	(17, '石川県'),
	(18, '福井県'),
	(19, '山梨県'),
	(20, '長野県'),
	(21, '岐阜県'),
	(22, '静岡県'),
	(23, '愛知県'),
	(24, '三重県'),
	(25, '滋賀県'),
	(26, '京都府'),
	(27, '大阪府'),
	(28, '兵庫県'),
	(29, '奈良県'),
	(30, '和歌山県'),
	(31, '鳥取県'),
	(32, '島根県'),
	(33, '岡山県'),
	(34, '広島県'),
	(35, '山口県'),
	(36, '徳島県'),
	(37, '香川県'),
	(38, '愛媛県'),
	(39, '高知県'),
	(40, '福岡県'),
	(41, '佐賀県'),
	(42, '長崎県'),
	(43, '熊本県'),
	(44, '大分県'),
	(45, '宮崎県'),
	(46, '鹿児島県'),
	(47, '沖縄県');
/*!40000 ALTER TABLE `prefectures` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
