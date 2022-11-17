package views;

import javax.swing.JPanel;

import controller.QuanLyThongKeController;

public class ThongKeJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ThongKeJPanel() {
		setLayout(null);

		JPanel jpnRoot = new JPanel();
		jpnRoot.setBounds(10, 10, 880, 586);
		add(jpnRoot);
		jpnRoot.setLayout(null);

		JPanel jpnTren = new JPanel();
		jpnTren.setBounds(0, 0, 880, 293);
		jpnRoot.add(jpnTren);

		JPanel jpnDuoi = new JPanel();
		jpnDuoi.setBounds(0, 291, 880, 295);
		jpnRoot.add(jpnDuoi);

		QuanLyThongKeController controller = new QuanLyThongKeController();
		controller.setDataToChart1(jpnTren);
		controller.setDataToChart2(jpnDuoi);

	}
}
