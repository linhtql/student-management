package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import model.HocVien;
import service.HocVienService;
import service.HocVienServiceImpl;

public class HocVienController {

	private JButton btnSubmit;
	private JTextField jtfHoTen;
	private JTextField jtfMaHocVien;
	private JDateChooser jdcNgaySinh;
	private JRadioButton jrdNam;
	private JRadioButton jrdNu;
	private JTextField jtfSdt;
	private JTextArea jtaDiaChi;
	private JCheckBox jcbTinhTrang;
	private JLabel jlbMsg;

	private HocVien hocvien = null;
	private HocVienService hocvienService = null;

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(JButton btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	public JTextField getJtfHoTen() {
		return jtfHoTen;
	}

	public void setJtfHoTen(JTextField jtfHoTen) {
		this.jtfHoTen = jtfHoTen;
	}

	public JTextField getJtfMaHocVien() {
		return jtfMaHocVien;
	}

	public void setJtfMaHocVien(JTextField jtfMaHocVien) {
		this.jtfMaHocVien = jtfMaHocVien;
	}

	public JDateChooser getJdcNgaySinh() {
		return jdcNgaySinh;
	}

	public void setJdcNgaySinh(JDateChooser jdcNgaySinh) {
		this.jdcNgaySinh = jdcNgaySinh;
	}

	public JRadioButton getJrdNam() {
		return jrdNam;
	}

	public void setJrdNam(JRadioButton jrdNam) {
		this.jrdNam = jrdNam;
	}

	public JRadioButton getJrdNu() {
		return jrdNu;
	}

	public void setJrdNu(JRadioButton jrdNu) {
		this.jrdNu = jrdNu;
	}

	public JTextField getJtfSdt() {
		return jtfSdt;
	}

	public void setJtfSdt(JTextField jtfSdt) {
		this.jtfSdt = jtfSdt;
	}

	public JTextArea getJtaDiaChi() {
		return jtaDiaChi;
	}

	public void setJtaDiaChi(JTextArea jtaDiaChi) {
		this.jtaDiaChi = jtaDiaChi;
	}

	public JCheckBox getJcbTinhTrang() {
		return jcbTinhTrang;
	}

	public void setJcbTinhTrang(JCheckBox jcbTinhTrang) {
		this.jcbTinhTrang = jcbTinhTrang;
	}

	public JLabel getJlbMsg() {
		return jlbMsg;
	}

	public void setJlbMsg(JLabel jlbMsg) {
		this.jlbMsg = jlbMsg;
	}

	public HocVienController(JButton btnSubmit, JTextField jtfHoTen, JTextField jtfMaHocVien, JDateChooser jdcNgaySinh,
			JRadioButton jrdNam, JRadioButton jrdNu, JTextField jtfSdt, JTextArea jtaDiaChi, JCheckBox jcbTinhTrang,
			JLabel jlbMsg) {
		super();
		this.btnSubmit = btnSubmit;
		this.jtfHoTen = jtfHoTen;
		this.jtfMaHocVien = jtfMaHocVien;
		this.jdcNgaySinh = jdcNgaySinh;
		this.jrdNam = jrdNam;
		this.jrdNu = jrdNu;
		this.jtfSdt = jtfSdt;
		this.jtaDiaChi = jtaDiaChi;
		this.jcbTinhTrang = jcbTinhTrang;
		this.jlbMsg = jlbMsg;

		this.hocvienService = new HocVienServiceImpl();
	}

	public void setView(HocVien hocvien) {
		this.hocvien = hocvien;
		jtfMaHocVien.setText("" + hocvien.getMa_hoc_vien());
		jtfHoTen.setText(hocvien.getHo_ten());
		if (hocvien.isGioi_tinh()) {
			jrdNam.setSelected(true);
			jrdNu.setSelected(false);
		} else {
			jrdNam.setSelected(false);
			jrdNu.setSelected(true);
		}
		jdcNgaySinh.setDate(hocvien.getNgay_sinh());
		jtfSdt.setText(hocvien.getSo_dien_thoai());
		jtaDiaChi.setText(hocvien.getDia_chi());
		jcbTinhTrang.setSelected(hocvien.isTinh_trang());
	}

	public void setEvent() {
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (jtfHoTen.getText().length() == 0 || jdcNgaySinh.getDate() == null) {
					jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc !");

				} else {
					if (showDialog()) {
						int id = Integer.parseInt(jtfMaHocVien.getText());
						hocvien.setMa_hoc_vien(id);
						hocvien.setHo_ten(jtfHoTen.getText());
						hocvien.setNgay_sinh(jdcNgaySinh.getDate());
						hocvien.setGioi_tinh(jrdNam.isSelected());
						hocvien.setSo_dien_thoai(jtfSdt.getText());
						hocvien.setDia_chi(jtaDiaChi.getText());
						hocvien.setTinh_trang(jcbTinhTrang.isSelected());
						int lastId = hocvienService.createOrUpdate(hocvien);
						if (lastId == 0) {
							jtfMaHocVien.setText("" + id);
							jlbMsg.setText("Cập nhật dữ liệu thành công !");
						}
					}
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnSubmit.setBackground(new Color(0, 200, 83));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSubmit.setBackground(new Color(100, 221, 23));
			}
		});

	}

	private boolean showDialog() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo",
				JOptionPane.YES_NO_OPTION);
		return dialogResult == JOptionPane.YES_OPTION;
	}

}
