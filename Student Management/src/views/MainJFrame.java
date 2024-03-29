package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.DanhMucBean;
import controller.ChuyenManHinhController;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MainJFrame extends JFrame {

	private JPanel jpnRoot, jpnView, jpnMenu, jpnTrangChu, jpnHocVien;
	private JLabel jlbTrangChu, jlbHocVien;

	public MainJFrame() {
		setTitle("QU\u1EA2N L\u00DD H\u1ECCC VI\u00CAN");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1224, 676);
		jpnRoot = new JPanel();
		jpnRoot.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jpnRoot);
		jpnRoot.setLayout(null);

		jpnMenu = new JPanel();
		jpnMenu.setBackground(new Color(128, 128, 128));
		jpnMenu.setBounds(0, 0, 290, 636);
		jpnRoot.add(jpnMenu);
		jpnMenu.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 5, 333, 73);
		jpnMenu.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("QU\u1EA2N L\u00DD H\u1ECCC VI\u00CAN");
		lblNewLabel.setIcon(new ImageIcon(MainJFrame.class.getResource("/images/outline_groups_white_24dp.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 24, 249, 39);
		panel.add(lblNewLabel);

		jpnTrangChu = new JPanel();
		jpnTrangChu.setBackground(new Color(0, 128, 0));
		jpnTrangChu.setBounds(10, 116, 280, 54);
		jpnMenu.add(jpnTrangChu);
		jpnTrangChu.setLayout(null);

		jlbTrangChu = new JLabel("M\u00E0n H\u00ECnh Ch\u00EDnh");
		jlbTrangChu.setIcon(
				new ImageIcon(MainJFrame.class.getResource("/images/outline_important_devices_white_24dp.png")));
		jlbTrangChu.setForeground(Color.WHITE);
		jlbTrangChu.setFont(new Font("Arial", Font.BOLD, 16));
		jlbTrangChu.setBounds(48, 10, 229, 44);
		jpnTrangChu.add(jlbTrangChu);

		jpnHocVien = new JPanel();
		jpnHocVien.setBackground(new Color(0, 128, 0));
		jpnHocVien.setBounds(10, 180, 280, 54);
		jpnMenu.add(jpnHocVien);
		jpnHocVien.setLayout(null);

		jlbHocVien = new JLabel("Qu\u1EA3n L\u00FD H\u1ECDc Vi\u00EAn");
		jlbHocVien.setIcon(new ImageIcon(MainJFrame.class.getResource("/images/outline_groups_white_24dp.png")));
		jlbHocVien.setForeground(Color.WHITE);
		jlbHocVien.setFont(new Font("Arial", Font.BOLD, 16));
		jlbHocVien.setBounds(48, 10, 224, 44);
		jpnHocVien.add(jlbHocVien);

		JPanel jpnKhoaHoc = new JPanel();
		jpnKhoaHoc.setBackground(new Color(0, 128, 0));
		jpnKhoaHoc.setBounds(10, 244, 280, 54);
		jpnMenu.add(jpnKhoaHoc);
		jpnKhoaHoc.setLayout(null);

		JLabel jlbKhoaHoc = new JLabel("Qu\u1EA3n L\u00FD Kh\u00F3a H\u1ECDc");
		jlbKhoaHoc.setIcon(
				new ImageIcon(MainJFrame.class.getResource("/images/outline_format_list_bulleted_white_24dp.png")));
		jlbKhoaHoc.setForeground(Color.WHITE);
		jlbKhoaHoc.setFont(new Font("Arial", Font.BOLD, 16));
		jlbKhoaHoc.setBounds(48, 10, 223, 44);
		jpnKhoaHoc.add(jlbKhoaHoc);

		JPanel jpnLopHoc = new JPanel();
		jpnLopHoc.setBackground(new Color(0, 128, 0));
		jpnLopHoc.setBounds(10, 308, 280, 54);
		jpnMenu.add(jpnLopHoc);
		jpnLopHoc.setLayout(null);

		JLabel jlbLopHoc = new JLabel("Qu\u1EA3n L\u00FD L\u1EDBp H\u1ECDc");
		jlbLopHoc.setIcon(new ImageIcon(MainJFrame.class.getResource("/images/outline_school_white_24dp.png")));
		jlbLopHoc.setForeground(Color.WHITE);
		jlbLopHoc.setFont(new Font("Arial", Font.BOLD, 16));
		jlbLopHoc.setBounds(48, 10, 214, 44);
		jpnLopHoc.add(jlbLopHoc);

		JPanel jpnThongKe = new JPanel();
		jpnThongKe.setBackground(new Color(0, 128, 0));
		jpnThongKe.setBounds(10, 372, 280, 54);
		jpnMenu.add(jpnThongKe);
		jpnThongKe.setLayout(null);

		JLabel jlbThongKe = new JLabel("Th\u1ED1ng K\u00EA D\u1EEF Li\u1EC7u");
		jlbThongKe.setIcon(
				new ImageIcon(MainJFrame.class.getResource("/images/outline_signal_cellular_alt_white_24dp.png")));
		jlbThongKe.setForeground(Color.WHITE);
		jlbThongKe.setFont(new Font("Arial", Font.BOLD, 16));
		jlbThongKe.setBounds(48, 10, 230, 44);
		jpnThongKe.add(jlbThongKe);

		JLabel lblNewLabel_2 = new JLabel("\u0110\u1EC1 t\u00E0i : Qu\u1EA3n L\u00FD H\u1ECDc Vi\u00EAn");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(41, 478, 212, 26);
		jpnMenu.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("H\u1ECD v\u00E0 t\u00EAn : Tr\u1EA7n Quang Linh");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(41, 525, 239, 26);
		jpnMenu.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("MSSV : 20IT222");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(41, 576, 239, 26);
		jpnMenu.add(lblNewLabel_2_1_1);

		jpnView = new JPanel();
		jpnView.setBackground(new Color(102, 205, 170));
		jpnView.setBounds(300, 10, 900, 616);
		jpnRoot.add(jpnView);

		List<DanhMucBean> listItem = new ArrayList<>();
		listItem.add(new DanhMucBean("TrangChu", jpnTrangChu, jlbTrangChu));
		listItem.add(new DanhMucBean("HocVien", jpnHocVien, jlbHocVien));
		listItem.add(new DanhMucBean("KhoaHoc", jpnKhoaHoc, jlbKhoaHoc));
		listItem.add(new DanhMucBean("LopHoc", jpnLopHoc, jlbLopHoc));
		listItem.add(new DanhMucBean("ThongKe", jpnThongKe, jlbThongKe));

		ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
		controller.setView(jpnTrangChu, jlbTrangChu);
		controller.setEvent(listItem);
	}
}
