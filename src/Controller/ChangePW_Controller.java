package Controller;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import View.ChangePW_Win;
import View.Login_Win;
import View.Main_Win;
import View.Login_Win;
public class ChangePW_Controller implements ActionListener{	
	public void actionPerformed(ActionEvent e) {
		ChangePW_Win cw = new ChangePW_Win();
		cw.setVisible(true);
	}


}
