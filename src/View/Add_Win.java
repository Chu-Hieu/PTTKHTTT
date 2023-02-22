package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;

public class Add_Win extends JFrame {

	private JPanel panel_Main;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	
	public Add_Win() {
		setTitle("Thêm hồ sơ");
		setSize(600,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel_Main = new JPanel();
		setContentPane(panel_Main);
		panel_Main.setLayout(new BorderLayout(0, 0));
		JPanel contentPane = new JPanel();	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_Main.add(contentPane);
		contentPane.setLayout(new GridLayout(4,4,0,0));
		
		JLabel lblNewLabel = new JLabel("Mã sinh viên");
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
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
		
		JComboBox comboBox_gt = new JComboBox();
		comboBox_gt.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ", "Giới tính thứ 3"}));
		contentPane.add(comboBox_gt);
		
		JLabel lblNewLabel_7 = new JLabel("Ngành đào tạo");
		contentPane.add(lblNewLabel_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ATTT", "CNTT", "DTVT"}));
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel_Main.add(panel, BorderLayout.SOUTH);
		
		JButton button_Luu = new JButton("Lưu");
		panel.add(button_Luu);
		
		JButton button_reset = new JButton("Nhập lại");
		panel.add(button_reset);
	}

}
