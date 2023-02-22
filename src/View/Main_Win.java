package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;

public class Main_Win extends JFrame {
	private JPanel contentPane;
	
	public Main_Win() {
		this.init();
	}
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("PHẦN MỀM QUẢN LÝ HỒ SƠ SINH VIÊN");
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel_Tools = new JPanel();
		panel_Tools.setLayout(new BorderLayout());
		getContentPane().add(panel_Tools,BorderLayout.NORTH);
		JPanel jp = new JPanel();
		panel_Tools.add(jp,BorderLayout.CENTER);
		jp.setLayout(new GridLayout(1,4));
		Font font = new Font("Arial",Font.BOLD,18);
		
		JButton button_Add = new JButton("Thêm hồ sơ");
		jp.add(button_Add);
		button_Add.setFont(font);
		
		JButton button_Update = new JButton("Sửa hồ sơ");
		jp.add(button_Update);
		button_Update.setFont(font);
		
		JButton button_Del = new JButton("Xóa hồ sơ");
		jp.add(button_Del);
		button_Del.setFont(font);
		
		JButton button_Print = new JButton("In danh sách");
		jp.add(button_Print);
		button_Print.setFont(font);
		
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(1,2));
		panel_Tools.add(jp2,BorderLayout.SOUTH);
		
		JPanel panel_Arrange = new JPanel();
		jp2.add(panel_Arrange);
		panel_Arrange.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mã sinh viên", "Họ và tên", "Ngày sinh", "Dân tộc", "Quê quán", "Ngành đào tạo"}));
		panel_Arrange.add(comboBox);
		
		JButton btnSpXp = new JButton("Sắp xếp");
		btnSpXp.setFont(new Font("Arial", Font.BOLD, 18));
		panel_Arrange.add(btnSpXp);
		
		
		
		JPanel panel_Search = new JPanel();
		jp2.add(panel_Search);
		panel_Search.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextField tf_Search = new JTextField();
		tf_Search.setColumns(15);
		panel_Search.add(tf_Search);
		tf_Search.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JButton btnTmKim = new JButton("Tìm Kiếm");
		panel_Search.add(btnTmKim);
		btnTmKim.setFont(font);
		
		
	    String[] column_Name = {" ","Mã sinh viên","Họ và tên","Giới tính","Ngày sinh","Dân tộc","CMND","Quê quán","Ngành ĐT"};
		//Object[][] data = null;
	    String[][] data= {{"1","1","1","1","1","1","1","1","1",},{"1","1","1","1","1","1","1","1","1",}
	    ,{"1","1","1","1","1","1","1","1","1",},{"1","1","1","1","1","1","1","1","1",},{"1","1","1","1","1","1","1","1","1",}};
		DefaultTableModel df = new DefaultTableModel(data, column_Name);
	    JTable table = new JTable(df);
	    table.setFont(new Font("Arial",Font.PLAIN,18));
	    JScrollPane panel_Table = new JScrollPane(table);
	    getContentPane().add(panel_Table,BorderLayout.CENTER);
	}
}
