package gui;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * 
 * @author zzaxec
 *
 */
public class KenoFrame extends JFrame{
	int breite = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()- getWidth())/3);
	int hoehe = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()- getHeight())/4);
	//Constructor
	public KenoFrame(){
		setTitle("KENO 1.4.0");
		setSize(1200, 500);
		setResizable(false);
		setLocation(breite, hoehe);
		KenoPanel cont = new KenoPanel();
		add(cont);
	}

}