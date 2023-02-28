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
	public ChangePW_Win(String userName) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(350,185);
		this.setTitle("Đổi mật khẩu");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3,2));
		
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
					if(dao.login(userName, textField.getText())) {
						dao.updateAcc(userName, passwordField.getText());
						lblNewLabel_3.setText("Đổi mật khẩu thành công");
						lblNewLabel_3.setForeground(Color.blue);
					}
					else if(dao.loginAccSV(userName, textField.getText())) {
						dao.updateAccSV(userName, passwordField.getText());
						lblNewLabel_3.setText("Đổi mật khẩu thành công");
						lblNewLabel_3.setForeground(Color.blue);
					}
					else
					{
						lblNewLabel_3.setText("Mật khẩu cũ không đúng");
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
