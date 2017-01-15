package main;

import javax.swing.JFrame;

import gui.KenoFrame;


/**
 * Main-Klasse
 * @author zzaxec
 * Version 2.1
 */

public class KENO {
	public static void main(String[] args){
		KenoFrame f = new KenoFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
