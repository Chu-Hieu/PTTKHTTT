package View;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.DAO;
import Model.SinhVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class Main_SV_Win extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel df;
	private JTable table;
	public Main_SV_Win(String userName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel_1 = new JPanel();
	    contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT,15,5));
		
		JLabel jb_dmk = new JLabel("Đổi mật khẩu");
		jb_dmk.setFont(new Font("Arial",Font.PLAIN,12));
		jb_dmk.addMouseListener(new MouseListener() {
			
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
				jb_dmk.setForeground(Color.black);
				jb_dmk.setFont(new Font("Arial",Font.PLAIN,12));
				jb_dmk.setText("Đổi mật khẩu");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jb_dmk.setFont(new Font("Arial",Font.ITALIC,12));
				jb_dmk.setForeground(Color.blue);
				jb_dmk.setText("<html><u>Đổi mật khẩu</u>");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				ChangePW_Win cw = new ChangePW_Win(userName);
				cw.setVisible(true);
			}
		});
		panel.add(jb_dmk);
		
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
		panel.add(jb_dx);
		
		String[] column_Name = {" ","Mã sinh viên","Họ và tên","Giới tính","Ngày sinh","Dân tộc","CMND","Quê quán","Ngành ĐT"};
		String[][] data = null;
		
		df = new DefaultTableModel(data, column_Name);
		table = new JTable(df);
	    showTable("select * from HSSV");
	    JScrollPane panel_Table = new JScrollPane(table);
	    contentPane.add(panel_Table,BorderLayout.CENTER);
	    
	    JLabel lblNewLabel = new JLabel("            ");
	    contentPane.add(lblNewLabel, BorderLayout.WEST);
	    
	    JLabel lblNewLabel_1 = new JLabel("            ");
	    contentPane.add(lblNewLabel_1, BorderLayout.EAST);
	    
	    JLabel lblNewLabel_2 = new JLabel("            ");
	    contentPane.add(lblNewLabel_2, BorderLayout.SOUTH);
	    
	    
	}
	public void showTable(String sql) {
		DAO dao = new DAO();
		df.getDataVector().removeAllElements();
		int i=1;
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

}
