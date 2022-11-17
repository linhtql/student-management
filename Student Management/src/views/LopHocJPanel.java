package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.QuanLyHocVienController;
import controller.QuanLyLopHocController;

public class LopHocJPanel extends JPanel {

	private JTextField jtfSearch;

	public LopHocJPanel() {
		setLayout(null);

		JPanel jpnRoot = new JPanel();
		jpnRoot.setBounds(0, 0, 900, 606);
		add(jpnRoot);
		jpnRoot.setLayout(null);

		jtfSearch = new JTextField();
		jtfSearch.setBounds(20, 10, 190, 27);
		jtfSearch.setColumns(10);
		jpnRoot.add(jtfSearch);

		JPanel jpnView = new JPanel();
		jpnView.setBounds(20, 47, 870, 549);
		jpnRoot.add(jpnView);

		JButton btnAdd = new JButton("+ Th\u00EAm m\u1EDBi");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(0, 128, 0));
		btnAdd.setBounds(758, 10, 132, 27);
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 16));
		jpnRoot.add(btnAdd);

		JButton btnDelete = new JButton("- X\u00F3a");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDelete.setBackground(new Color(0, 128, 0));
		btnDelete.setBounds(616, 10, 132, 27);
		jpnRoot.add(btnDelete);

		QuanLyLopHocController controller = new QuanLyLopHocController(jpnView, btnAdd, btnDelete, jtfSearch);
		controller.setDateToTable();
		controller.setEvent();

	}

}
