package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Win_Add_Reset_Controller;
import Database.DAO;
import Model.SinhVien;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Add_Win extends JFrame {

	private JPanel panel_Main;
	public JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox_gt;
	private JComboBox comboBox;

	
	public Add_Win() {
		setTitle("Thêm hồ sơ");
		setSize(700,240);
		setLocationRelativeTo(null);
		panel_Main = new JPanel();
		setContentPane(panel_Main);
		panel_Main.setLayout(new BorderLayout(0, 0));
		JPanel contentPane = new JPanel();	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_Main.add(contentPane);
		contentPane.setLayout(new GridLayout(4,4,20,0));
		
		JLabel lblNewLabel = new JLabel("Mã sinh viên");
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		contentPane.add(textField);
		//textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Họ và tên");
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		contentPane.add(textField_1);
		textField_1.setColumns(13);
		
		JLabel lblNewLabel_2 = new JLabel("CMTND");
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		contentPane.add(textField_2);
		textField_2.setColumns(13);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày sinh");
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		contentPane.add(textField_3);
		textField_3.setColumns(13);
		JLabel lblNewLabel_4 = new JLabel("Quê quán");
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Dân tộc");
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		contentPane.add(textField_5);
		textField_5.setColumns(13);
		
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
		
		JPanel panel0 = new JPanel();
		panel0.setLayout(new GridLayout(2,1));
		panel_Main.add(panel0, BorderLayout.SOUTH);
		
		JLabel jbnt = new JLabel("",SwingConstants.CENTER);
		panel0.add(jbnt);
		
		JPanel panel = new JPanel();
		panel0.add(panel);
		
		JButton button_Luu = new JButton("Lưu");
		panel.add(button_Luu);
		button_Luu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DAO d = new DAO();
				SinhVien sv = getSinhVien();
				int check=d.addSV(sv);
				if(check>0)
				{
					jbnt.setText("Thêm thành công");
					jbnt.setForeground(Color.blue);
				}
				else {
					jbnt.setText("Thêm thất bại");
					jbnt.setForeground(Color.red);
				}
						
				d.closeConnection();			
				reset();}	
				
		});
		
		JButton button_reset = new JButton("Nhập lại");
		button_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
				
			}
		});
		
		panel.add(button_reset);
		setVisible(true);
	}
	public  void reset() {
		this.textField.setText(null);
		this.textField_1.setText(null);
		this.textField_2.setText(null);
		this.textField_3.setText(null);
		this.textField_4.setText(null);
		this.textField_5.setText(null);
		this.comboBox.setSelectedIndex(0);
		this.comboBox_gt.setSelectedIndex(0);
	}
	public SinhVien getSinhVien() {
		SinhVien sv = new SinhVien();
		sv.setMSV(textField.getText());
		sv.setHoTen(textField_1.getText());
		sv.setCMND(textField_2.getText());
		sv.setNgaySinh(textField_3.getText());		
		sv.setQueQuan(textField_4.getText());
		sv.setDanToc(textField_5.getText());
		sv.setGioiTinh((String) comboBox_gt.getSelectedItem());
		sv.setNganhDaoTao((String) comboBox.getSelectedItem());
		return sv;
	}
	
}
