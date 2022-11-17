package views;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class TrangChuJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrangChuJPanel() {
		setBackground(SystemColor.control);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		panel.setBounds(10, 10, 286, 164);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(37, 10, 61, 122);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(TrangChuJPanel.class.getResource("/images/outline_event_white_24dp.png")));

		JLabel lblNewLabel_1 = new JLabel("100");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_1.setBounds(159, 10, 45, 33);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Kh\u00F3a H\u1ECDc");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_2.setBounds(82, 128, 122, 31);
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(306, 10, 286, 164);
		add(panel_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TrangChuJPanel.class.getResource("/images/outline_groups_white_24dp.png")));
		lblNewLabel_3.setBounds(37, 10, 61, 122);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_1_1 = new JLabel("100");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(159, 10, 45, 33);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("H\u1ECDc Vi\u00EAn");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_2_1.setBounds(82, 128, 122, 31);
		panel_1.add(lblNewLabel_2_1);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(119, 136, 153));
		panel_1_1_1.setBounds(602, 10, 286, 164);
		add(panel_1_1_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(
				new ImageIcon(TrangChuJPanel.class.getResource("/images/outline_mark_email_unread_white_24dp.png")));
		lblNewLabel_3_1_1.setBounds(37, 10, 61, 122);
		panel_1_1_1.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("100");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_1_1_1_1.setBounds(159, 10, 45, 33);
		panel_1_1_1.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("H\u00F2m Th\u01B0");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_2_1_1_1.setBounds(63, 123, 135, 31);
		panel_1_1_1.add(lblNewLabel_2_1_1_1);

	}

}
