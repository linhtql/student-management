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

import model.KhoaHoc;
import service.KhoaHocService;
import service.KhoaHocServiceImpl;

public class KhoaHocController {

	private JButton btnSubmit;
	private JTextField jtfMaKhoaHoc;
	private JTextField jtfTenKhoaHoc;
	private JDateChooser jdcNbd, jdcNkt;
	private JTextArea jtaMoTa;
	private JCheckBox jcbTinhTrang;
	JLabel jlbMsg;

	private KhoaHoc khoaHoc = null;
	private KhoaHocService khoahocService = null;

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(JButton btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	public JTextField getJtfMaKhoaHoc() {
		return jtfMaKhoaHoc;
	}

	public void setJtfMaKhoaHoc(JTextField jtfMaKhoaHoc) {
		this.jtfMaKhoaHoc = jtfMaKhoaHoc;
	}

	public JTextField getJtfTenKhoaHoc() {
		return jtfTenKhoaHoc;
	}

	public void setJtfTenKhoaHoc(JTextField jtfTenKhoaHoc) {
		this.jtfTenKhoaHoc = jtfTenKhoaHoc;
	}

	public JDateChooser getJdcNbd() {
		return jdcNbd;
	}

	public void setJdcNbd(JDateChooser jdcNbd) {
		this.jdcNbd = jdcNbd;
	}

	public JDateChooser getJdcNkt() {
		return jdcNkt;
	}

	public void setJdcNkt(JDateChooser jdcNkt) {
		this.jdcNkt = jdcNkt;
	}

	public JTextArea getJtaMoTa() {
		return jtaMoTa;
	}

	public void setJtaMoTa(JTextArea jtaMoTa) {
		this.jtaMoTa = jtaMoTa;
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

	public KhoaHoc getKhoaHoc() {
		return khoaHoc;
	}

	public void setKhoaHoc(KhoaHoc khoaHoc) {
		this.khoaHoc = khoaHoc;
	}

	public KhoaHocService getKhoahocService() {
		return khoahocService;
	}

	public void setKhoahocService(KhoaHocService khoahocService) {
		this.khoahocService = khoahocService;
	}

	public KhoaHocController(JButton btnSubmit, JTextField jtfMaKhoaHoc, JTextField jtfTenKhoaHoc, JDateChooser jdcNbd,
			JDateChooser jdcNkt, JTextArea jtaMoTa, JCheckBox jcbTinhTrang, JLabel jlbMsg) {
		super();
		this.btnSubmit = btnSubmit;
		this.jtfMaKhoaHoc = jtfMaKhoaHoc;
		this.jtfTenKhoaHoc = jtfTenKhoaHoc;
		this.jdcNbd = jdcNbd;
		this.jdcNkt = jdcNkt;
		this.jtaMoTa = jtaMoTa;
		this.jcbTinhTrang = jcbTinhTrang;
		this.jlbMsg = jlbMsg;

		this.khoahocService = new KhoaHocServiceImpl();
	}

	public void setView(KhoaHoc khoaHoc) {
		this.khoaHoc = khoaHoc;

		jtfMaKhoaHoc.setText("" + khoaHoc.getMa_khoa_hoc());
		jtfTenKhoaHoc.setText("" + khoaHoc.getTen_khoa_hoc());
		jdcNbd.setDate(khoaHoc.getNgay_bat_dau());
		jdcNkt.setDate(khoaHoc.getNgay_ket_thuc());
		jcbTinhTrang.setSelected(khoaHoc.isTinh_trang());
		jtaMoTa.setText(khoaHoc.getMo_ta());
	}

	public void setEvetnt() {
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (jtfTenKhoaHoc.getText().length() == 0 || jdcNbd.getDate() == null || jdcNkt.getDate() == null) {
					jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc !!");
				} else {
					if (showDialog()) {
						int id = Integer.parseInt(jtfMaKhoaHoc.getText());
						khoaHoc.setMa_khoa_hoc(id);
						khoaHoc.setTen_khoa_hoc(jtfTenKhoaHoc.getText());
						khoaHoc.setNgay_bat_dau(jdcNbd.getDate());
						khoaHoc.setNgay_ket_thuc(jdcNkt.getDate());
						khoaHoc.setTinh_trang(jcbTinhTrang.isSelected());
						khoaHoc.setMo_ta(jtaMoTa.getText());

						int lastId = khoahocService.createOrUpdate(khoaHoc);
						if (lastId == 0) {
							jtfMaKhoaHoc.setText("" + id);
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
