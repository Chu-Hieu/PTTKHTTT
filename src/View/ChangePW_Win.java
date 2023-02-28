package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.DAO;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePW_Win extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;
	private JPasswordField passwordField_1;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JPanel panel_2;
	private JButton btnLu;
	private JLabel lblNewLabel_4;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePW_Win frame = new ChangePW_Win();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ChangePW_Win() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(350,200);
		this.setTitle("Đổi mật khẩu");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(4,2));
		
		lblNewLabel_4 = new JLabel("Tài Khoản:");
		panel.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel = new JLabel("Mật khẩu cũ:");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel.add(textField);
		
		lblNewLabel_1 = new JLabel("Mật khẩu mới:");
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		panel.add(passwordField);
		
		lblNewLabel_2 = new JLabel("Xác nhận mật khẩu:");
		panel.add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		panel.add(passwordField_1);
			
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNewLabel_3 = new JLabel("",SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		btnLu = new JButton("Lưu");
		btnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getText().equals(passwordField_1.getText())) {
					DAO dao = new DAO();
					if(dao.login(textField_1.getText(), textField.getText())) {
						dao.updateAcc(textField_1.getText(), passwordField.getText());
						lblNewLabel_3.setText("Đổi mật khẩu thành công");
						lblNewLabel_3.setForeground(Color.blue);
					}
					else
					{
						lblNewLabel_3.setText("Sai tài khoản hoặc mật khẩu");
						lblNewLabel_3.setForeground(Color.red);
					}
					dao.closeConnection();
				}
				else {
					lblNewLabel_3.setText("Mật khẩu mới không giống nhau");
					lblNewLabel_3.setForeground(Color.red);
				}
			}
		});
		panel_2.add(btnLu);
	}
}
