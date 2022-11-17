package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.dangnhap_control;
import model.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Form_Login extends JFrame {
	private JPanel contentPane;
	private JTextField tfUser;
	private JPasswordField pfPass;
	String userText, pwdText;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Login frame = new Form_Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Form_Login() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 384, 282);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setForeground(Color.CYAN);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUser = new JLabel("USERNAME");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUser.setBounds(37, 53, 80, 27);
		contentPane.add(lblUser);

		JLabel lblPass = new JLabel("PASSWORD");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPass.setBounds(37, 117, 80, 27);
		contentPane.add(lblPass);

		tfUser = new JTextField();
		tfUser.setBounds(142, 55, 172, 28);
		contentPane.add(tfUser);
		tfUser.setColumns(10);

		pfPass = new JPasswordField();
		pfPass.setBounds(142, 119, 172, 28);
		contentPane.add(pfPass);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setIcon(new ImageIcon(getClass().getResource("/images/key.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnLogin) {
					Login lg = new Login();
					lg.setUsername(tfUser.getText().trim());
					lg.setPassword(pfPass.getText().trim());

					dangnhap_control a = new dangnhap_control();
					a.check_login(lg);

				}
			}
		});
		btnLogin.setBounds(37, 190, 95, 32);
		contentPane.add(btnLogin);

		JButton btnReset = new JButton("RESET");
		btnReset.setIcon(new ImageIcon(getClass().getResource("/images/edit-clear.png")));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnReset) {
					tfUser.setText("");
					pfPass.setText("");
				}
			}
		});
		btnReset.setBounds(142, 190, 95, 32);
		contentPane.add(btnReset);

		JCheckBox chckbxPass = new JCheckBox("Show PassWord");
		chckbxPass.setBackground(new Color(192, 192, 192));
		chckbxPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == chckbxPass) {
					if (chckbxPass.isSelected())
						pfPass.setEchoChar((char) 0);
					else {
						pfPass.setEchoChar('*');
					}
				}
			}
		});
		chckbxPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxPass.setBounds(142, 153, 122, 27);
		contentPane.add(chckbxPass);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(getClass().getResource("/images/logout.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCancel) {
					int click = JOptionPane.showConfirmDialog(null, "Do you want to exit?");
					if (click == JOptionPane.YES_OPTION)
						System.exit(0);
				}
			}
		});
		btnCancel.setBounds(252, 190, 95, 32);
		contentPane.add(btnCancel);
	}
}
