package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import controller.HocVienController;
import model.HocVien;

import javax.swing.ButtonGroup;

public class HocVienJFrame extends JFrame {

	private JPanel jpnRoot;
	private JTextField jtfHoten;
	private JTextField jtfSdt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField jtfMaHocVien;

	public HocVienJFrame(HocVien hocVien) {
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
				"Th\u00F4ng tin h\u1ECDc vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(255, 0, 0)));
		panel.setBounds(10, 51, 775, 277);
		jpnRoot.add(panel);
		panel.setLayout(null);

		JLabel jlbNS = new JLabel("Ng\u00E0y sinh");
		jlbNS.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbNS.setBounds(29, 111, 89, 28);
		panel.add(jlbNS);

		JLabel jlbGioiTinh = new JLabel("Gi\u1EDBi t\u00EDnh");
		jlbGioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbGioiTinh.setBounds(29, 149, 89, 28);
		panel.add(jlbGioiTinh);

		JLabel jlbTinhTrang = new JLabel("T\u00ECnh tr\u1EA1ng");
		jlbTinhTrang.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbTinhTrang.setBounds(29, 187, 89, 28);
		panel.add(jlbTinhTrang);

		JCheckBox chckbxNewCheckBox = new JCheckBox("K\u00EDch ho\u1EA1t");
		chckbxNewCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(124, 191, 93, 21);
		panel.add(chckbxNewCheckBox);

		JRadioButton jrdbtNam = new JRadioButton("Nam");
		buttonGroup.add(jrdbtNam);
		jrdbtNam.setFont(new Font("Arial", Font.PLAIN, 16));
		jrdbtNam.setBounds(124, 153, 103, 21);
		panel.add(jrdbtNam);

		JRadioButton jrdbtNu = new JRadioButton("N\u1EEF");
		buttonGroup.add(jrdbtNu);
		jrdbtNu.setFont(new Font("Arial", Font.PLAIN, 16));
		jrdbtNu.setBounds(246, 153, 103, 21);
		panel.add(jrdbtNu);

		JLabel jlbSdt = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		jlbSdt.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbSdt.setBounds(404, 35, 103, 28);
		panel.add(jlbSdt);

		jtfSdt = new JTextField();
		jtfSdt.setColumns(10);
		jtfSdt.setBounds(517, 39, 221, 26);
		panel.add(jtfSdt);

		JLabel jlbDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9");
		jlbDiaChi.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbDiaChi.setBounds(404, 90, 103, 28);
		panel.add(jlbDiaChi);

		JTextArea jtaDiaChi = new JTextArea();
		jtaDiaChi.setBounds(517, 94, 221, 134);
		panel.add(jtaDiaChi);

		JDateChooser jdcNgaySinh = new JDateChooser();
		jdcNgaySinh.setBounds(128, 111, 221, 28);
		panel.add(jdcNgaySinh);

		JLabel jlbMaHocVien = new JLabel("M\u00E3 h\u1ECDc vi\u00EAn");
		jlbMaHocVien.setFont(new Font("Arial", Font.PLAIN, 16));
		jlbMaHocVien.setBounds(29, 35, 89, 28);
		panel.add(jlbMaHocVien);

		jtfMaHocVien = new JTextField();
		jtfMaHocVien.setColumns(10);
		jtfMaHocVien.setBounds(128, 39, 221, 26);
		panel.add(jtfMaHocVien);

		JLabel jlbHoTen = new JLabel("H\u1ECD v\u00E0 t\u00EAn ");
		jlbHoTen.setBounds(29, 73, 89, 28);
		panel.add(jlbHoTen);
		jlbHoTen.setFont(new Font("Arial", Font.PLAIN, 16));

		jtfHoten = new JTextField();
		jtfHoten.setBounds(128, 77, 221, 26);
		panel.add(jtfHoten);
		jtfHoten.setColumns(10);

		JLabel jlbMsg = new JLabel("");
		jlbMsg.setForeground(Color.RED);
		jlbMsg.setFont(new Font("Arial", Font.PLAIN, 18));
		jlbMsg.setBounds(10, 13, 291, 23);
		jpnRoot.add(jlbMsg);

		HocVienController controller = new HocVienController(btnSubmit, jtfHoten, jtfMaHocVien, jdcNgaySinh, jrdbtNam,
				jrdbtNu, jtfSdt, jtaDiaChi, chckbxNewCheckBox, jlbMsg);
		controller.setView(hocVien);
		controller.setEvent();
	}
}
