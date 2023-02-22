package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class Del_Win extends JFrame {

	private JPanel contentPane;
	public Del_Win() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Bạn có chắc chắn muốn xóa không?");
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Có");
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Không");
		contentPane.add(btnNewButton_1);
	}

}
