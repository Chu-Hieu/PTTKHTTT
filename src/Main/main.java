package Main;

import java.awt.Font;

import javax.swing.JFrame;

import View.Add_Win;
import View.Del_Win;
import View.Login_Win;
import View.Main_Win;

public class main {
	public static void main(String[] args) {
		Main_Win mw = new Main_Win();
		mw.setVisible(true);
		
		Login_Win lw = new Login_Win();
		lw.setVisible(false);
		
		Add_Win aw = new Add_Win();
		aw.setVisible(false);
		
		Del_Win dw = new Del_Win();
		dw.setVisible(false);
	}
}
