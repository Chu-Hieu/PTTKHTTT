package View;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login_Win extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public Login_Win() {
		this.init();
	}
	public void init() {
		setTitle("Đăng nhập tài khoản");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,150);
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
		
		JLabel jb_1= new JLabel("     Sai tên tài khoản hoặc mật khẩu     ",SwingConstants.CENTER);
		jb_1.setFont(new Font("Arial",Font.PLAIN,10));
		jb_1.setForeground(Color.red);
		panel_1.add(jb_1);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		panel_1.add(btnNewButton);
	}

}