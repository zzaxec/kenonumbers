
package dataGUI;


import java.awt.Toolkit;

import javax.swing.JFrame;


/**
 *
 * @author zzaxec
 *
 */
public class Datawindow extends JFrame{

	int	breite	= (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2);
	int	hoehe		= (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 4);

	// Constructor
	public Datawindow(){
		setTitle("");
		setSize(500, 300);
		setResizable(false);
		setLocation(this.breite, this.hoehe);
		Datapanel datenfenster = new Datapanel();
		add(datenfenster);
		setVisible(true);
		setDefaultCloseOperation(1);
	}
}
