package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import controller.KhoaHocController;
import controller.LopHocController;
import model.HocVien;
import model.KhoaHoc;
import model.LopHoc;

public class LopHocJFrame extends JFrame {

	private JPanel jpnRoot;
	private JTextField jtfMaKhoaHoc;
	private JTextField jtfMaLopHoc;

	private JPanel contentPane;
	private JTextField jtfMaHocVien;

	public LopHocJFrame(LopHoc lopHoc, KhoaHoc khoaHoc, HocVien hocVien) {
		setBounds(100, 100, 799, 375);
		jpnRoot = new JPanel();
		jpnRoot.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jpnRoot);
		jpnRoot.setLayout(null);

		JButton btnSubmit = new JButton("L\u01B0u d\u1EEF li\u1EC7u");
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(new Color(0, 128, 0));
		btnSubmit.setIcon(null);
		btnSubmit.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSubmit.setBounds(660, 10, 125, 31);
		jpnRoot.add(btnSubmit);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin l\u1EDBp h\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(255, 0, 0)));
		panel.setBounds(10, 51, 775, 277);
		jpnRoot.add(panel);
		panel.setLayout(null);

		JLabel jlbMaHocVien = new JLabel("M\u00E3 H\u1ECDc Vi\u00EAn");
		jlbMaHocVien.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbMaHocVien.setBounds(29, 111, 101, 28);
		panel.add(jlbMaHocVien);

		JLabel jlbTinhTrang = new JLabel("T\u00ECnh tr\u1EA1ng");
		jlbTinhTrang.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbTinhTrang.setBounds(406, 39, 89, 28);
		panel.add(jlbTinhTrang);

		JCheckBox chckbxNewCheckBox = new JCheckBox("K\u00EDch ho\u1EA1t");
		chckbxNewCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(517, 43, 93, 21);
		panel.add(chckbxNewCheckBox);

		JLabel jlbMaLopHoc = new JLabel("M\u00E3 l\u1EDBp h\u1ECDc");
		jlbMaLopHoc.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbMaLopHoc.setBounds(29, 35, 101, 28);
		panel.add(jlbMaLopHoc);

		jtfMaLopHoc = new JTextField();
		jtfMaLopHoc.setColumns(10);
		jtfMaLopHoc.setBounds(140, 39, 221, 26);
		panel.add(jtfMaLopHoc);

		JLabel jlbMaKhoaHoc = new JLabel("M\u00E3 Kh\u00F3a H\u1ECDc");
		jlbMaKhoaHoc.setBounds(29, 73, 101, 28);
		panel.add(jlbMaKhoaHoc);
		jlbMaKhoaHoc.setFont(new Font("Arial", Font.PLAIN, 16));

		jtfMaKhoaHoc = new JTextField();
		jtfMaKhoaHoc.setBounds(140, 75, 221, 26);
		panel.add(jtfMaKhoaHoc);
		jtfMaKhoaHoc.setColumns(10);

		JLabel jlbNbd_1 = new JLabel("Ng\u00E0y \u0110\u0103ng K\u00FD");
		jlbNbd_1.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbNbd_1.setBounds(406, 111, 101, 28);
		panel.add(jlbNbd_1);

		JDateChooser jdcNdk = new JDateChooser();
		jdcNdk.setBounds(517, 111, 221, 28);
		panel.add(jdcNdk);

		jtfMaHocVien = new JTextField();
		jtfMaHocVien.setColumns(10);
		jtfMaHocVien.setBounds(140, 118, 221, 26);
		panel.add(jtfMaHocVien);

		JLabel jlbMsg = new JLabel("");
		jlbMsg.setForeground(Color.RED);
		jlbMsg.setFont(new Font("Arial", Font.PLAIN, 18));
		jlbMsg.setBounds(10, 13, 291, 23);
		jpnRoot.add(jlbMsg);

		LopHocController controller = new LopHocController(btnSubmit, jtfMaLopHoc, jtfMaKhoaHoc, jtfMaHocVien, jdcNdk,
				chckbxNewCheckBox, jlbMsg);
		controller.setView(lopHoc, khoaHoc, hocVien);
		controller.setEvetnt();

	}
}
