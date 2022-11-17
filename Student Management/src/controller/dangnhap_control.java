package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.ConnectDB;
import model.Login;
import views.MainJFrame;

public class dangnhap_control {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public void check_login(Login lg) {
		conn = ConnectDB.getConnection();
		String sql = "select * from TAIKHOAN where username=? and password=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, lg.getUsername());
			stmt.setString(2, lg.getPassword());

			rs = stmt.executeQuery();

			if (rs.next()) {
				Login getlg = new Login();
				lg.setUsername(rs.getString("username"));
				lg.setPassword(rs.getString("password"));

				JOptionPane.showMessageDialog(null, "Login Success!");
				MainJFrame frame = new MainJFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			} else {
				JOptionPane.showMessageDialog(null, "Login Fail!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}
}
