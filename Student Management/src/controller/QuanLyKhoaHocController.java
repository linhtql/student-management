package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.HocVien;
import model.KhoaHoc;
import service.KhoaHocService;
import service.KhoaHocServiceImpl;
import utility.ClassTableModel;
import views.HocVienJFrame;
import views.KhoaHocJFrame;

public class QuanLyKhoaHocController {
	private JPanel jpnView;
	private JButton btnAdd;
	private JButton btnDelete;
	private JTextField jtfSearch;

	private final String[] COLUMNS = { "STT", "Mã khóa học", "Tên khóa học", "Ngày bắt đầu", "Ngày kết thúc", "Mô tả",
			"Tình trạng" };

	private KhoaHoc khoahoc = null;

	private KhoaHocService khoaHocService = null;

	private TableRowSorter<TableModel> rowSorter = null;

	public QuanLyKhoaHocController(JPanel jpnView, JButton btnAdd, JButton btnDelete, JTextField jtfSearch) {
		super();
		this.jpnView = jpnView;
		this.btnAdd = btnAdd;
		this.jtfSearch = jtfSearch;
		this.btnDelete = btnDelete;

		this.khoaHocService = new KhoaHocServiceImpl();
	}

	public QuanLyKhoaHocController() {
		super();
		this.khoaHocService = new KhoaHocServiceImpl();
	}

	public void setDateToTable() {
		List<KhoaHoc> listItem = khoaHocService.getList();

		DefaultTableModel model = new ClassTableModel().setTableKhoaHoc(listItem, COLUMNS);
		JTable table = new JTable(model);

		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);

		jtfSearch.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = jtfSearch.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = jtfSearch.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					selectedRowIndex = table.convertRowIndexToView(selectedRowIndex);

					KhoaHoc khoaHoc = new KhoaHoc();
					khoaHoc.setMa_khoa_hoc((int) model.getValueAt(selectedRowIndex, 1));
					khoaHoc.setTen_khoa_hoc(model.getValueAt(selectedRowIndex, 2).toString());
					khoaHoc.setNgay_bat_dau((Date) model.getValueAt(selectedRowIndex, 3));
					khoaHoc.setNgay_ket_thuc((Date) model.getValueAt(selectedRowIndex, 4));
					khoaHoc.setMo_ta(model.getValueAt(selectedRowIndex, 5) != null
							? model.getValueAt(selectedRowIndex, 5).toString()
							: "");
					khoaHoc.setTinh_trang((boolean) model.getValueAt(selectedRowIndex, 6));
					KhoaHocJFrame frame = new KhoaHocJFrame(khoaHoc);
					frame.setTitle("Thông tin khóa học");
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.addWindowListener(new java.awt.event.WindowAdapter() {
						@Override
						public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//					        if (JOptionPane.showConfirmDialog(frame, 
//					            "Are you sure you want to close this window?", "Close Window?", 
//					            JOptionPane.YES_NO_OPTION,
//					            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
//					            System.exit(0);
//					        }
							setDateToTable();
						}
					});

				} else {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					selectedRowIndex = table.convertRowIndexToView(selectedRowIndex);

					KhoaHoc khoaHoc = new KhoaHoc();
					khoaHoc.setMa_khoa_hoc((int) model.getValueAt(selectedRowIndex, 1));

					btnDelete.addMouseListener(new MouseListener() {

						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void mouseClicked(MouseEvent e) {
							JOptionPane.showConfirmDialog(null, "Bạn muốn xóa dữ liệu hay không?", "Thông báo",
									JOptionPane.YES_NO_OPTION);

							int la = khoaHocService.delete(khoaHoc);
							if (la == 0) {
								JOptionPane.showMessageDialog(null, "Thành công !");
								setDateToTable();
							} else
								JOptionPane.showMessageDialog(null, "Thất bại !");

						}
					});
				}
				super.mouseClicked(e);
			}
		});

		// design
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.setRowHeight(50);
		table.validate();
		table.repaint();

		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(table);
		scroll.setPreferredSize(new Dimension(1350, 400));
		jpnView.removeAll();
		jpnView.setLayout(new CardLayout());
		jpnView.add(scroll);
		jpnView.validate();
		jpnView.repaint();
	}

	public void setEvent() {
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KhoaHocJFrame frame = new KhoaHocJFrame(new KhoaHoc());
				frame.setTitle("Thông tin khóa học");
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				frame.setVisible(true);
				frame.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent windowEvent) {
						setDateToTable();
					}
				});

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(0, 200, 83));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(new Color(100, 221, 23));
			}
		});

	}
}
