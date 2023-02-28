package View;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ChangePW_Controller;
import Database.DAO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.security.auth.kerberos.DelegationPermission;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Win extends JFrame {
	Main_Win mw;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	ChangePW_Controller dn;
	public Login_Win() {
		this.init();
	}
	public void init() {
		setTitle("Đăng nhập tài khoản");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,150);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2,2));
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản:");
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mật khẩu:");
		panel.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		panel.add(passwordField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setSize(100,50);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout());
		
		JLabel jb_1= new JLabel("",SwingConstants.CENTER);
		jb_1.setFont(new Font("Arial",Font.PLAIN,10));
		jb_1.setForeground(Color.red);
		panel_1.add(jb_1);
		
	
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DAO dao = new DAO();
				if(dao.login(textField.getText(), passwordField.getText())) {
					Main_Win mw = new Main_Win();
					mw.setVisible(true);
					dispose();
				}
				else
					jb_1.setText("     Sai tên tài khoản hoặc mật khẩu     ");
				dao.closeConnection();
				
			}
		});
	
		
		panel_1.add(btnNewButton);	
		
		JButton btnNewButton_1 = new JButton("Đổi mật khẩu");
		panel_1.add(btnNewButton_1);
		ChangePW_Controller cc = new ChangePW_Controller();
		btnNewButton_1.addActionListener(cc);
	}
public static void main(String[] args) {
	Login_Win lw = new Login_Win();
	lw.setVisible(true);
}
}
