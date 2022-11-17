package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import model.HocVien;
import model.KhoaHoc;
import model.LopHoc;
import service.LopHocService;
import service.LopHocServiceImpl;

public class LopHocController {

	private JButton btnSubmit;
	private JTextField jtfMaLopHoc;
	private JTextField jtfMaKhoaHoc;
	private JTextField jtfMaHocVien;
	private JDateChooser jdcNdk;
	private JCheckBox jcbTinhTrang;
	JLabel jlbMsg;

	private KhoaHoc khoaHoc = null;
	private HocVien hocVien = null;

	private LopHoc lopHoc = null;
	private LopHocService lopHocService = null;

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(JButton btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	public JTextField getJtfMaLopHoc() {
		return jtfMaLopHoc;
	}

	public void setJtfMaLopHoc(JTextField jtfMaLopHoc) {
		this.jtfMaLopHoc = jtfMaLopHoc;
	}

	public JTextField getJtfMaKhoaHoc() {
		return jtfMaKhoaHoc;
	}

	public void setJtfMaKhoaHoc(JTextField jtfMaKhoaHoc) {
		this.jtfMaKhoaHoc = jtfMaKhoaHoc;
	}

	public JTextField getJtfMaHocVien() {
		return jtfMaHocVien;
	}

	public void setJtfMaHocVien(JTextField jtfMaHocVien) {
		this.jtfMaHocVien = jtfMaHocVien;
	}

	public JDateChooser getJdcNdk() {
		return jdcNdk;
	}

	public void setJdcNdk(JDateChooser jdcNdk) {
		this.jdcNdk = jdcNdk;
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

	public LopHoc getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
	}

	public LopHocService getLopHocService() {
		return lopHocService;
	}

	public void setLopHocService(LopHocService lopHocService) {
		this.lopHocService = lopHocService;
	}

	public KhoaHoc getKhoaHoc() {
		return khoaHoc;
	}

	public void setKhoaHoc(KhoaHoc khoaHoc) {
		this.khoaHoc = khoaHoc;
	}

	public HocVien getHocVien() {
		return hocVien;
	}

	public void setHocVien(HocVien hocVien) {
		this.hocVien = hocVien;
	}

	public LopHocController(JButton btnSubmit, JTextField jtfMaLopHoc, JTextField jtfMaKhoaHoc, JTextField jtfMaHocVien,
			JDateChooser jdcNdk, JCheckBox jcbTinhTrang, JLabel jlbMsg) {
		super();
		this.btnSubmit = btnSubmit;
		this.jtfMaLopHoc = jtfMaLopHoc;
		this.jtfMaKhoaHoc = jtfMaKhoaHoc;
		this.jtfMaHocVien = jtfMaHocVien;
		this.jdcNdk = jdcNdk;
		this.jcbTinhTrang = jcbTinhTrang;
		this.jlbMsg = jlbMsg;

		this.lopHocService = new LopHocServiceImpl();
	}

	public void setView(LopHoc lopHoc, KhoaHoc khoaHoc, HocVien hocVien) {
		this.lopHoc = lopHoc;
		lopHoc.setKhoaHoc(khoaHoc);
		lopHoc.setHocvien(hocVien);
		this.khoaHoc = khoaHoc;
		this.hocVien = hocVien;
		jtfMaLopHoc.setText("" + lopHoc.getMa_lop_hoc());
		jtfMaKhoaHoc.setText("" + lopHoc.getKhoaHoc().getMa_khoa_hoc());
		jtfMaHocVien.setText("" + lopHoc.getHocvien().getMa_hoc_vien());
		jdcNdk.setDate(lopHoc.getNgay_dang_ky());
		jcbTinhTrang.setSelected(lopHoc.isTinh_trang());
	}

	public void setEvetnt() {
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (jdcNdk.getDate() == null) {
					jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc !!");
				} else {
					if (showDialog()) {

						int id = Integer.parseInt(jtfMaLopHoc.getText());
						lopHoc.setMa_lop_hoc(id);
						lopHoc.setKhoaHoc(khoaHoc);
						khoaHoc.setMa_khoa_hoc(Integer.parseInt(jtfMaKhoaHoc.getText()));
						lopHoc.setHocvien(hocVien);
						hocVien.setMa_hoc_vien(Integer.parseInt(jtfMaHocVien.getText()));
						lopHoc.setNgay_dang_ky(jdcNdk.getDate());
						lopHoc.setTinh_trang(jcbTinhTrang.isSelected());

						int lastId = lopHocService.createOrUpdate(lopHoc);
						if (lastId == 0) {
							jtfMaLopHoc.setText("" + id);
							jlbMsg.setText("Cập nhập dữ liệu thành công !");
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
				btnSubmit.setBackground(new Color(100, 211, 23));
			}
		});

	}

	private boolean showDialog() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo",
				JOptionPane.YES_NO_OPTION);
		return dialogResult == JOptionPane.YES_OPTION;
	}

}
