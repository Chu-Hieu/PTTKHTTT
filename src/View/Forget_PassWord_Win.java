package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.DAO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Forget_PassWord_Win extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public Forget_PassWord_Win() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(320,150);
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 2, 5, 2));
		
		JLabel lblNewLabel = new JLabel("Tài Khoản:");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu mới:");
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("", SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				lblNewLabel.setForeground(Color.black);
				if(dao.forget_PassWord(textField.getText(), textField_1.getText())) {
					lblNewLabel_2.setText("Đổi mật khẩu thành công");
					lblNewLabel_2.setForeground(Color.blue);
				}
				else {
					lblNewLabel_2.setText("Đổi mật khẩu thất bại");
					lblNewLabel_2.setForeground(Color.red);
					lblNewLabel.setForeground(Color.red);
				}
				dao.closeConnection();
			}
		});
		panel_1.add(btnNewButton);
	}

}
