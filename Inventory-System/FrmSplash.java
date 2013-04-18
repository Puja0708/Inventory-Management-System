/*
********************************************************************************
*																			   *
* Programmer: Philip V. Naparan                                                *
* Contact No.: 639186443161                                                    *
* E-mail Address: philipnaparan@yahoo.com                                      *
* Website: http://www.naparansoft.cjb.net                                      *
*    													   					   *
* "MABUHAY ANG MGA PINOY","PLEASE DON'T FORGET TO VOTE"                        *
*    													   					   *
* Note:																		   *
*      This is not intended to used in a big business because this system was  *
*      created for small business only. If you own a big business and planning *
*      to have a best software for your business then contact me. :-)          *
*																			   *
********************************************************************************
*/

import javax.swing.*;
import java.awt.*;

public class FrmSplash extends JWindow implements Runnable{
	public void run(){
		JLabel SplashLabel = new JLabel(new ImageIcon("images/splash.jpg"));
		Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
		
		getContentPane().add(SplashLabel,BorderLayout.CENTER);
		
		setSize(490,300);
		setLocation((screen.width - 490)/2,((screen.height-300)/2));
		show();
	}
}