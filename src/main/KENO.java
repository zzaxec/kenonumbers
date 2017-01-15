package main;

import javax.swing.JFrame;

import gui.KenoFrame;


/**
 * Main-Klasse
 * @author zzaxec
 * Version 1.3.0
 */

public class KENO {
	public static void main(String[] args){
		KenoFrame f = new KenoFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
