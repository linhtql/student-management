CREATE DATABASE QLHV;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hocvien
-- ----------------------------
DROP TABLE IF EXISTS `hocvien`;
CREATE TABLE `hocvien` (
  `ma_hocvien` int(11) NOT NULL AUTO_INCREMENT,
  `ho_ten` varchar(255) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `gioi_tinh` bit(1) NOT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `tinh_trang` bit(1) NOT NULL,
  PRIMARY KEY (`ma_hocvien`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for khoahoc
-- ----------------------------
DROP TABLE IF EXISTS `khoahoc`;
CREATE TABLE `khoahoc` (
  `ma_khoahoc` int(11) NOT NULL AUTO_INCREMENT,
  `ten_khoahoc` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_ket_thuc` date DEFAULT NULL,
  `tinh_trang` bit(1) NOT NULL,
  PRIMARY KEY (`ma_khoahoc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for lophoc
-- ----------------------------
DROP TABLE IF EXISTS `lophoc`;
CREATE TABLE `lophoc` (
  `ma_lophoc` int(11) NOT NULL AUTO_INCREMENT,
  `ma_khoahoc` int(11) DEFAULT NULL,
  `ma_hocvien` int(11) DEFAULT NULL,
  `ngay_dang_ky` date DEFAULT NULL,
  `tinh_trang` bit(1) NOT NULL,
  PRIMARY KEY (`ma_lophoc`),
  KEY `FK_nsk96k2rdocji4oakgsv51nuq` (`ma_hocvien`),
  KEY `FK_pvhxvf4oy1n5bp8tvn8a6tcnu` (`ma_khoahoc`),
  CONSTRAINT `FK_nsk96k2rdocji4oakgsv51nuq` FOREIGN KEY (`ma_hocvien`) REFERENCES `hocvien` (`ma_hocvien`),
  CONSTRAINT `FK_pvhxvf4oy1n5bp8tvn8a6tcnu` FOREIGN KEY (`ma_khoahoc`) REFERENCES `khoahoc` (`ma_khoahoc`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

CREATE TABLE `taikhoan` (
    `username`  varchar(255)  PRIMARY KEY NOT NULL ,
    `password` varchar(255) NOT NULL
    )
    