package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.KhoaHoc;

public class KhoaHocDAOImpl implements KhoaHocDAO {

	@Override
	public List<KhoaHoc> getList() {
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * FROM KHOAHOC";
		List<KhoaHoc> list = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				KhoaHoc khoaHoc = new KhoaHoc();
				khoaHoc.setMa_khoa_hoc(rs.getInt("ma_khoa_hoc"));
				khoaHoc.setTen_khoa_hoc(rs.getString("ten_khoa_hoc"));
				khoaHoc.setNgay_bat_dau(rs.getDate("ngay_bat_dau"));
				khoaHoc.setNgay_ket_thuc(rs.getDate("ngay_ket_thuc"));
				khoaHoc.setMo_ta(rs.getString("mo_ta"));
				khoaHoc.setTinh_trang(rs.getBoolean("tinh_trang"));
				list.add(khoaHoc);
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int createOrUpdate(KhoaHoc khoaHoc) {
		try {
			Connection conn = ConnectDB.getConnection();
			String sql = "INSERT INTO KHOAHOC(ma_khoa_hoc, ten_khoa_hoc, ngay_bat_dau, ngay_ket_thuc, mo_ta, tinh_trang) VALUES(?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE ten_khoa_hoc = VALUES(ten_khoa_hoc), ngay_bat_dau = VALUES(ngay_bat_dau), ngay_ket_thuc = VALUES(ngay_ket_thuc), mo_ta = VALUES(mo_ta), tinh_trang = VALUES(tinh_trang);";
			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, khoaHoc.getMa_khoa_hoc());
			ps.setString(2, khoaHoc.getTen_khoa_hoc());
			ps.setDate(3, new Date(khoaHoc.getNgay_bat_dau().getTime()));
			ps.setDate(4, new Date(khoaHoc.getNgay_ket_thuc().getTime()));
			ps.setString(5, khoaHoc.getMo_ta());
			ps.setBoolean(6, khoaHoc.isTinh_trang());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			int generatedKey = 0;
			if (rs.next()) {
				generatedKey = rs.getInt(1);
			}
			ps.close();
			conn.close();
			return generatedKey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(KhoaHoc khoaHoc) {
		try {
			Connection conn = ConnectDB.getConnection();
			String sql = "DELETE FROM KHOAHOC WHERE ma_khoa_hoc=?";
			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, khoaHoc.getMa_khoa_hoc());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int generatedKey = 0;
			if (rs.next()) {
				generatedKey = rs.getInt(1);
			}
			ps.close();
			conn.close();
			return generatedKey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
