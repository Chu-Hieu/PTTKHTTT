package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import Database.DAO;
import View.Main_Win;

public class PrintList_Controller implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		String data = dao.getListText();
		dao.closeConnection();
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(fc);
		if(returnVal==JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				PrintWriter pw = new PrintWriter(file.getAbsolutePath());
				pw.print(data);
				pw.flush();
				pw.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
}
