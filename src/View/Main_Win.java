package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

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

import Controller.Add_Controller;
import Controller.PrintList_Controller;
import Controller.Update_Controller;
import Database.DAO;
import Model.SinhVien;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class Main_Win extends JFrame {
	private JPanel contentPane;
	private DefaultTableModel df;
	private JTable table;
	private String sqlselect = "select * from HSSV";
	private int i=1;
	public Main_Win(String userName) {
		this.init(userName);
	}
	public void init(String userName) {
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
		Font font = new Font("Arial",Font.BOLD,18);
		jp.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button_Add = new JButton("Thêm hồ sơ");		
		jp.add(button_Add);
		button_Add.setFont(font);
		Add_Controller ac = new Add_Controller();
		button_Add.addActionListener(ac);
		
		JButton button_Update = new JButton("Sửa hồ sơ");
		jp.add(button_Update);
		button_Update.setFont(font);
		Update_Controller uc = new Update_Controller();
		button_Update.addActionListener(uc);
		
		JButton button_Del = new JButton("Xóa hồ sơ");
		jp.add(button_Del);
		button_Del.setFont(font);
		button_Del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s =getSQLdelete();
				new Del_Win(s);
			}
		});
		
		JButton button_Print = new JButton("In danh sách");
		button_Print.addActionListener(new PrintList_Controller());
		jp.add(button_Print);
		button_Print.setFont(font);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton button_doiMK = new JButton("Đổi mật khẩu");
		button_doiMK.setFont(font);
		jp.add(button_doiMK);
		button_doiMK.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangePW_Win cw = new ChangePW_Win(userName);
				cw.setVisible(true);
			}
		});
		
		JLabel jb_dx = new JLabel("Đăng xuất");
		jb_dx.setFont(new Font("Arial",Font.PLAIN,12));
		jb_dx.addMouseListener(new MouseListener() {
			
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
				jb_dx.setForeground(Color.black);
				jb_dx.setFont(new Font("Arial",Font.PLAIN,12));
				jb_dx.setText("Đăng xuất");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jb_dx.setFont(new Font("Arial",Font.ITALIC,12));
				jb_dx.setForeground(Color.red);
				jb_dx.setText("<html><u>Đăng xuất</u>");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Login_Win lw = new Login_Win();
				lw.setVisible(true);
				dispose();
				
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(jb_dx);
		jp.add(panel);
			
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(1,3));
		panel_Tools.add(jp2,BorderLayout.SOUTH);
		
		JPanel panel_Arrange = new JPanel();
		jp2.add(panel_Arrange);
		panel_Arrange.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mã sinh viên", "Họ và tên", "Ngày sinh", "Dân tộc", "Quê quán", "Ngành đào tạo"}));
		panel_Arrange.add(comboBox);
		
		JButton btnSpXp = new JButton("Sắp xếp");
		btnSpXp.setFont(new Font("Arial", Font.BOLD, 18));
		panel_Arrange.add(btnSpXp);
		btnSpXp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = comboBox.getSelectedItem().toString();
				String sql;
				if(s.equals("Mã sinh viên")) {
					sql="select * from HSSV order by maSV";
				}
				else if(s.equals("Họ và tên")) {
					sql="select * from HSSV order by hoVaTen";
				}
				else if(s.equals("Ngày sinh")) {
					sql="select * from HSSV order by ngaySinh";
				}
				else if(s.equals("Dân tộc")) {
					sql="select * from HSSV order by danToc";
				}
				else if(s.equals("Quê quán")) {
					sql="select * from HSSV order by queQuan";
				}
				else  {
					sql="select * from HSSV order by nganhDT";
				}
				showTable(sql);
			}
		});
				
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
		btnTmKim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = tf_Search.getText();
				String sql = "select * from HSSV where maSV like'%"+s+"%' or hoVaTen like'%"+s+"%' or"
						+" CMND like'%"+s+"%'";
				showTable(sql);						
			}
		});
		
		JButton jb_reset = new JButton("Tải lại");
		jb_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTable(sqlselect);
			}
		});
		jb_reset.setFont(font);
		JPanel jp_reset = new JPanel();
		//jp_reset.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		jp_reset.add(jb_reset);
		jp2.add(jp_reset);
		
	    String[] column_Name = {" ","Mã sinh viên","Họ và tên","Giới tính","Ngày sinh","Dân tộc","CMND","Quê quán","Ngành ĐT"};
		String[][] data = null;
		
		df = new DefaultTableModel(data, column_Name);
		table = new JTable(df);
	    showTable(sqlselect);
	    table.setFont(new Font("Arial",Font.PLAIN,14));
	    JScrollPane panel_Table = new JScrollPane(table);
	    getContentPane().add(panel_Table,BorderLayout.CENTER);
	    
	    JLabel lblNewLabel = new JLabel("                ");
	    contentPane.add(lblNewLabel, BorderLayout.WEST);
	    
	    JLabel lblNewLabel_1 = new JLabel("                 ");
	    contentPane.add(lblNewLabel_1, BorderLayout.EAST);
	   
	  
	}
	public void showTable(String sql) {
		DAO dao = new DAO();
		df.getDataVector().removeAllElements();
		i=1;
		ArrayList<SinhVien> list = dao.getList(sql);
		for(SinhVien sv:list) {
			df.addRow(new Object[] {
				i,sv.getMSV(),sv.getHoTen(),sv.getGioiTinh(),sv.getNgaySinh(),sv.getDanToc(),sv.getCMND(),sv.getQueQuan(),sv.getNganhDaoTao()	
			});
			i++;
		}
		table.setModel(df);
		dao.closeConnection();
	}
	public String getSQLdelete() {
		int[] rs=table.getSelectedRows();
		if(rs.length<1)
			return "";
		String sql = "delete from HSSV where maSV like N'" +table.getValueAt(rs[0],1)+ "'";
		for(int i = 1;i < rs.length;i++) {
			sql=sql+" or maSV like N'"+table.getValueAt(rs[i], 1)+"'";
		}
		
		return sql;
	}
}
