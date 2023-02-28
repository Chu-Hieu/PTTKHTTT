package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.DAO;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Del_Win extends JFrame {

	private JPanel contentPane;
	public Del_Win(String sql) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(250,110);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Bạn có chắc chắn muốn xóa không?");
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Có");
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DAO dao = new DAO();
				dao.deleteData(sql);
				dispose();
			}
		});
		JButton btnNewButton_1 = new JButton("Không");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		setVisible(true);
	}

}
