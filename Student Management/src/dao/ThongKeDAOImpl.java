package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.KhoaHocBean;
import bean.LopHocBean;

public class ThongKeDAOImpl implements ThongKeDAO {

	@Override
	public List<LopHocBean> getListByLopHoc() {
		try {
			Connection conn = ConnectDB.getConnection();
			String sql = "SELECT ngay_dang_ky, COUNT(*) as so_luong FROM LOPHOC GROUP BY ngay_dang_ky;";

			List<LopHocBean> list = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LopHocBean lophocbean = new LopHocBean();
				lophocbean.setNgayDangKy(rs.getString("ngay_dang_ky"));
				lophocbean.setSoLuongHocVien(rs.getInt("so_luong"));
				list.add(lophocbean);
			}
			ps.close();
			conn.close();
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return null;
	}

	@Override
	public List<KhoaHocBean> getListByKhoaHoc() {
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT ten_khoa_hoc, ngay_bat_dau, ngay_ket_thuc FROM KHOAHOC WHERE tinh_trang = TRUE ORDER BY ngay_bat_dau ASC;";
		List<KhoaHocBean> list = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				KhoaHocBean khoaHocBean = new KhoaHocBean();
				khoaHocBean.setTen_khoa_hoc(rs.getString("ten_khoa_hoc"));
				khoaHocBean.setNgay_bat_dau(rs.getDate("ngay_bat_dau"));
				khoaHocBean.setNgay_ket_thuc(rs.getDate("ngay_ket_thuc"));
				list.add(khoaHocBean);
			}
			ps.close();
			conn.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
