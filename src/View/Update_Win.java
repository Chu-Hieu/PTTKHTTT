package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Database.DAO;
import Model.SinhVien;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update_Win extends JFrame {

	private JPanel panel_Main;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JComboBox comboBox_gt;
	private JComboBox comboBox;
	private String maSV;
	private JLabel lblNewLabel;
	public Update_Win() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Sửa hồ sơ");
		setSize(600,250);
		setLocationRelativeTo(null);
		panel_Main = new JPanel();
		setContentPane(panel_Main);
		panel_Main.setLayout(new BorderLayout(0, 0));
		JPanel contentPane = new JPanel();	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_Main.add(contentPane);
		contentPane.setLayout(new GridLayout(4,4,0,0));
		
		JButton jb = new JButton("Xác nhận MSV");
		jb.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				maSV = textField.getText();
				String sql = "select * from HSSV where maSV like N'"+textField.getText()+"'";
				DAO dao = new DAO();
				SinhVien sv=dao.getHSSVUpdate(sql);
				setHSSV(sv);
				dao.closeConnection();
				lblNewLabel.setText("");
			}
		});
		contentPane.add(jb);
		
		textField = new JTextField();
		textField.setColumns(10);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Họ và tên");
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CMTND");
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày sinh");
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Quê quán");
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Dân tộc");
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Giới tính");
		contentPane.add(lblNewLabel_6);
		
		comboBox_gt = new JComboBox();
		comboBox_gt.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ", "Giới tính thứ 3"}));
		contentPane.add(comboBox_gt);
		JLabel lblNewLabel_7 = new JLabel("Ngành đào tạo");
		contentPane.add(lblNewLabel_7);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ATTT", "CNTT", "DTVT"}));
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel_Main.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNewLabel = new JLabel("",SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton button_Luu = new JButton("Cập nhật");
		button_Luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				if(dao.UpdateHSSV(sqlUpdate(maSV))>0) {
					lblNewLabel.setText("Cập nhật thành công");
					lblNewLabel.setForeground(Color.blue);
				}
				else {
					lblNewLabel.setText("Cập nhật thất bại");
					lblNewLabel.setForeground(Color.red);
				}
				dao.closeConnection();
			}
		});
		panel_1.add(button_Luu);
		
		setVisible(true);
	}
	public void setHSSV(SinhVien sv) {
		textField.setText(sv.getMSV());
		textField_1.setText(sv.getHoTen());
		textField_2.setText(sv.getCMND());
		textField_3.setText(sv.getNgaySinh());
		textField_4.setText(sv.getQueQuan());
		textField_5.setText(sv.getDanToc());
		comboBox_gt.setSelectedItem(sv.getGioiTinh());
		comboBox.setSelectedItem(sv.getNganhDaoTao());
	}
	public String sqlUpdate(String maSV) {
		String sql ="UPDATE HSSV SET maSV = N'"+textField.getText()+"' ,"
				+"hoVaTen = N'"+textField_1.getText()+"' ,"
				+"CMND = N'"+textField_2.getText()+"' ,"
				+"ngaySinh = N'"+textField_3.getText()+"' ,"
				+"queQuan = N'"+textField_4.getText()+"' ,"
				+"danToc = N'"+textField_5.getText()+"' ,"
				+"gioiTinh = N'"+comboBox_gt.getSelectedItem().toString()+"' ,"
				+"nganhDT = N'"+comboBox.getSelectedItem().toString()+"'"
				+" where maSV like N'"+maSV+"'";
		return sql;
	}
}
