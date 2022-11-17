package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import controller.KhoaHocController;
import controller.QuanLyKhoaHocController;
import model.KhoaHoc;

public class KhoaHocJFrame extends JFrame {

	private JPanel jpnRoot;
	private JTextField jtfTenKhoaHoc;
	private JTextField jtfMaKhoaHoc;

	private JPanel contentPane;

	public KhoaHocJFrame(KhoaHoc khoaHoc) {
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
				"Th\u00F4ng tin kh\u00F3a h\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(255, 0, 0)));
		panel.setBounds(10, 51, 775, 277);
		jpnRoot.add(panel);
		panel.setLayout(null);

		JLabel jlbNbd = new JLabel("Ng\u00E0y b\u1EAFt \u0111\u1EA7u");
		jlbNbd.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbNbd.setBounds(29, 111, 101, 28);
		panel.add(jlbNbd);

		JLabel jlbTinhTrang = new JLabel("T\u00ECnh tr\u1EA1ng");
		jlbTinhTrang.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbTinhTrang.setBounds(406, 39, 89, 28);
		panel.add(jlbTinhTrang);

		JCheckBox chckbxNewCheckBox = new JCheckBox("K\u00EDch ho\u1EA1t");
		chckbxNewCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(517, 43, 93, 21);
		panel.add(chckbxNewCheckBox);

		JTextArea jtaMota = new JTextArea();
		jtaMota.setBounds(517, 94, 221, 134);
		panel.add(jtaMota);

		JDateChooser jdcNbd = new JDateChooser();
		jdcNbd.setBounds(140, 111, 221, 28);
		panel.add(jdcNbd);

		JLabel jlbMaKhoaHoc = new JLabel("M\u00E3 kh\u00F3a h\u1ECDc");
		jlbMaKhoaHoc.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbMaKhoaHoc.setBounds(29, 35, 101, 28);
		panel.add(jlbMaKhoaHoc);

		jtfMaKhoaHoc = new JTextField();
		jtfMaKhoaHoc.setColumns(10);
		jtfMaKhoaHoc.setBounds(140, 39, 221, 26);
		panel.add(jtfMaKhoaHoc);

		JLabel jlbTenKhoaHoc = new JLabel("T\u00EAn Kh\u00F3a H\u1ECDc");
		jlbTenKhoaHoc.setBounds(29, 73, 101, 28);
		panel.add(jlbTenKhoaHoc);
		jlbTenKhoaHoc.setFont(new Font("Arial", Font.PLAIN, 16));

		jtfTenKhoaHoc = new JTextField();
		jtfTenKhoaHoc.setBounds(140, 75, 221, 26);
		panel.add(jtfTenKhoaHoc);
		jtfTenKhoaHoc.setColumns(10);

		JLabel jlbNbd_1 = new JLabel("Ng\u00E0y k\u1EBFt th\u00FAc");
		jlbNbd_1.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbNbd_1.setBounds(29, 157, 101, 28);
		panel.add(jlbNbd_1);

		JDateChooser jdcNkt = new JDateChooser();
		jdcNkt.setBounds(140, 157, 221, 28);
		panel.add(jdcNkt);

		JLabel lblMoTa = new JLabel("M\u00F4 t\u1EA3");
		lblMoTa.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMoTa.setBounds(406, 90, 81, 28);
		panel.add(lblMoTa);

		JLabel jlbMsg = new JLabel("");
		jlbMsg.setForeground(Color.RED);
		jlbMsg.setFont(new Font("Arial", Font.PLAIN, 18));
		jlbMsg.setBounds(10, 13, 291, 23);
		jpnRoot.add(jlbMsg);

		KhoaHocController controller = new KhoaHocController(btnSubmit, jtfMaKhoaHoc, jtfTenKhoaHoc, jdcNbd, jdcNkt,
				jtaMota, chckbxNewCheckBox, jlbMsg);
		controller.setView(khoaHoc);
		controller.setEvetnt();

	}
}
