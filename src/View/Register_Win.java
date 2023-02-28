package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Database.DAO;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register_Win extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
	private JLabel lblNewLabel_3;
	public Register_Win() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setSize(300,160);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Mã sinh viên:");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu:");
		panel.add(lblNewLabel_1);
		
		textField_1 = new JPasswordField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Xác nhận mật khẩu:");
		panel.add(lblNewLabel_2);
		
		textField_2 = new JPasswordField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Đăng ký");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setForeground(Color.black);
				lblNewLabel_2.setForeground(Color.black);
				if(textField_1.getText().equals(textField_2.getText())){
					DAO dao = new DAO();
					if(dao.register(textField.getText(), textField_1.getText())){
						lblNewLabel_3.setText("Đăng ký thành công");
						lblNewLabel_3.setForeground(Color.blue);
					}
					else {
						lblNewLabel_3.setText("Đăng ký không thành công");
						lblNewLabel_3.setForeground(Color.red);
						lblNewLabel.setForeground(Color.red);
					}
					dao.closeConnection();
				}
				else {
					lblNewLabel_3.setText("Đăng ký không thành công");
					lblNewLabel_3.setForeground(Color.red);
					lblNewLabel_2.setForeground(Color.red);
				}
			}
		});
		panel_1.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("",SwingConstants.CENTER);
		contentPane.add(lblNewLabel_3, BorderLayout.CENTER);
	}

}
