package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.HocVien;
import model.KhoaHoc;
import model.LopHoc;

public class LopHocDAOImpl implements LopHocDAO {

	@Override
	public List<LopHoc> getList() {
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * FROM LOPHOC";
		List<LopHoc> list = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LopHoc lophoc = new LopHoc();
				KhoaHoc khoahoc = new KhoaHoc();
				HocVien hocvien = new HocVien();
				lophoc.setMa_lop_hoc(rs.getInt("ma_lop_hoc"));
				lophoc.setKhoaHoc(khoahoc);
				khoahoc.setMa_khoa_hoc(rs.getInt("ma_khoa_hoc"));
				lophoc.setHocvien(hocvien);
				hocvien.setMa_hoc_vien(rs.getInt("ma_hoc_vien"));
				lophoc.setNgay_dang_ky(rs.getDate("ngay_dang_ky"));
				lophoc.setTinh_trang(rs.getBoolean("tinh_trang"));
				list.add(lophoc);
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int createOrUpdate(LopHoc lophoc) {
		try {
			Connection conn = ConnectDB.getConnection();
			String sql = "INSERT INTO LOPHOC(ma_lop_hoc, ma_khoa_hoc, ma_hoc_vien, ngay_dang_ky, tinh_trang) VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE ma_khoa_hoc = VALUES(ma_khoa_hoc), ma_hoc_vien = VALUES(ma_hoc_vien), ngay_dang_ky = VALUES(ngay_dang_ky), tinh_trang = VALUES(tinh_trang);";
			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, lophoc.getMa_lop_hoc());
			ps.setInt(2, lophoc.getKhoaHoc().getMa_khoa_hoc());
			ps.setInt(3, lophoc.getHocvien().getMa_hoc_vien());
			ps.setDate(4, new Date(lophoc.getNgay_dang_ky().getTime()));
			ps.setBoolean(5, lophoc.isTinh_trang());
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
	public int delete(LopHoc lophoc) {
		try {
			Connection conn = ConnectDB.getConnection();
			String sql = "DELETE FROM LOPHOC WHERE ma_lop_hoc=?";
			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, lophoc.getMa_lop_hoc());
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
