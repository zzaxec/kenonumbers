package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * 
 * @author zzaxec
 *
 */
public class KenoFrame extends JFrame{
	int breite = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()- getWidth())/4);
	int hoehe = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()- getHeight())/4);
	
	BufferedImage im;

	//Constructor
	public KenoFrame(){
		try {
			im = ImageIO.read(new File("icons/zzaxec.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle("KENO");
		setSize(1200, 500);
		setResizable(false);
		setIconImage(im);
		setLocation(breite, hoehe);
		KenoPanel cont = new KenoPanel();
		add(cont);
	}
}