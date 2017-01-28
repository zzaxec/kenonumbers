package gui;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import dataGUI.Datapanel;
import dataGUI.Datawindow;
import methods.OpsMethods;


public class KenoPanel extends JPanel{
	ArrayList<int[]> daten = new ArrayList<int[]>();
	private int[] randomKenoNumbs;
	private int arrayLaenge;
	private double[] statistics = new double[70];
	
	

	//Buttons
	JButton add = new JButton("Ziehung hinzufügen"), 
			generate = new JButton("Generiere"),
			display = new JButton("Willkommen Millionär!"),
			saveState = new JButton("Speichern"),
			loadState = new JButton("Laden"),
			lastNumbers = new JButton(""),
			stats = new JButton("Statistik"),
			numb1 = new JButton("1"),
			numb2 = new JButton("2"),
			numb3 = new JButton("3"),
			numb4 = new JButton("4"),
			numb5 = new JButton("5"),
			numb6 = new JButton("6"),
			numb7 = new JButton("7"),
			numb8 = new JButton("8"),
			numb9 = new JButton("9"),
			numb10 = new JButton("10"),
			numb11 = new JButton("11"),
			numb12 = new JButton("12"),
			numb13 = new JButton("13"),
			numb14 = new JButton("14"),
			numb15 = new JButton("15"),
			numb16 = new JButton("16"),
			numb17 = new JButton("17"),
			numb18 = new JButton("18"),
			numb19 = new JButton("19"),
			numb20 = new JButton("20"),
			numb21 = new JButton("21"),
			numb22 = new JButton("22"),
			numb23 = new JButton("23"),
			numb24 = new JButton("24"),
			numb25 = new JButton("25"),
			numb26 = new JButton("26"),
			numb27 = new JButton("27"),
			numb28 = new JButton("28"),
			numb29 = new JButton("29"),
			numb30 = new JButton("30"),
			numb31 = new JButton("31"),
			numb32 = new JButton("32"),
			numb33 = new JButton("33"),
			numb34 = new JButton("34"),
			numb35 = new JButton("35"),
			numb36 = new JButton("36"),
			numb37 = new JButton("37"),
			numb38 = new JButton("38"),
			numb39 = new JButton("39"),
			numb40 = new JButton("40"),
			numb41 = new JButton("41"),
			numb42 = new JButton("42"),
			numb43 = new JButton("43"),
			numb44 = new JButton("44"),
			numb45 = new JButton("45"),
			numb46 = new JButton("46"),
			numb47 = new JButton("47"),
			numb48 = new JButton("48"),
			numb49 = new JButton("49"),
			numb50 = new JButton("50"),
			numb51 = new JButton("51"),
			numb52 = new JButton("52"),
			numb53 = new JButton("53"),
			numb54 = new JButton("54"),
			numb55 = new JButton("55"),
			numb56 = new JButton("56"),
			numb57 = new JButton("57"),
			numb58 = new JButton("58"),
			numb59 = new JButton("59"),
			numb60 = new JButton("60"),
			numb61 = new JButton("61"),
			numb62 = new JButton("62"),
			numb63 = new JButton("63"),
			numb64 = new JButton("64"),
			numb65 = new JButton("65"),
			numb66 = new JButton("66"),
			numb67 = new JButton("67"),
			numb68 = new JButton("68"),
			numb69 = new JButton("69"),
			numb70 = new JButton("70");
	//Panels
	JPanel 	helpPanel = new JPanel(),
			displayPanel = new JPanel(), 
			general = new JPanel();
	
	JDialog dia = new JDialog(),
			statistiken = new JDialog();
	
	JTextPane txt = new JTextPane();
	
	//Constructor
	public KenoPanel(){		
		setLayout(new BorderLayout());
		
		//ActionListener
		ActionListener aktion = new getAction();
		
		//Buttons modifizieren
		display.setEnabled(false);
		add.addActionListener(aktion);
		saveState.addActionListener(aktion);
		loadState.addActionListener(aktion);
		generate.addActionListener(aktion);
		stats.addActionListener(aktion);
		
		//
		displayPanel.add(display);
		displayPanel.add(stats);
		
		//
		helpPanel.add(saveState);
		helpPanel.add(loadState);
		helpPanel.add(add);
		helpPanel.add(generate);
		
		//
		general.setLayout(new GridLayout(10,7));
		
		general.add(numb1);
		numb1.setBorderPainted(false);
		numb1.setEnabled(false);
		general.add(numb2);
		numb2.setBorderPainted(false);
		numb2.setEnabled(false);
		general.add(numb3);
		numb3.setBorderPainted(false);
		numb3.setEnabled(false);
		general.add(numb4);
		numb4.setBorderPainted(false);
		numb4.setEnabled(false);
		general.add(numb5);
		numb5.setBorderPainted(false);
		numb5.setEnabled(false);
		general.add(numb6);
		numb6.setBorderPainted(false);
		numb6.setEnabled(false);
		general.add(numb7);
		numb7.setBorderPainted(false);
		numb7.setEnabled(false);
		general.add(numb8);
		numb8.setBorderPainted(false);
		numb8.setEnabled(false);
		general.add(numb9);
		numb9.setBorderPainted(false);
		numb9.setEnabled(false);
		general.add(numb10);
		numb10.setBorderPainted(false);
		numb10.setEnabled(false);
		general.add(numb11);
		numb11.setBorderPainted(false);
		numb11.setEnabled(false);
		general.add(numb12);
		numb12.setBorderPainted(false);
		numb12.setEnabled(false);
		general.add(numb13);
		numb13.setBorderPainted(false);
		numb13.setEnabled(false);
		general.add(numb14);
		numb14.setBorderPainted(false);
		numb14.setEnabled(false);
		general.add(numb15);
		numb15.setBorderPainted(false);
		numb15.setEnabled(false);
		general.add(numb16);
		numb16.setBorderPainted(false);
		numb16.setEnabled(false);
		general.add(numb17);
		numb17.setBorderPainted(false);
		numb17.setEnabled(false);
		general.add(numb18);
		numb18.setBorderPainted(false);
		numb18.setEnabled(false);
		general.add(numb19);
		numb19.setBorderPainted(false);
		numb19.setEnabled(false);
		general.add(numb20);
		numb20.setBorderPainted(false);
		numb20.setEnabled(false);
		general.add(numb21);
		numb21.setBorderPainted(false);
		numb21.setEnabled(false);
		general.add(numb22);
		numb22.setBorderPainted(false);
		numb22.setEnabled(false);
		general.add(numb23);
		numb23.setBorderPainted(false);
		numb23.setEnabled(false);
		general.add(numb24);
		numb24.setBorderPainted(false);
		numb24.setEnabled(false);
		general.add(numb25);
		numb25.setBorderPainted(false);
		numb25.setEnabled(false);
		general.add(numb26);
		numb26.setBorderPainted(false);
		numb26.setEnabled(false);
		general.add(numb27);
		numb27.setBorderPainted(false);
		numb27.setEnabled(false);
		general.add(numb28);
		numb28.setBorderPainted(false);
		numb28.setEnabled(false);
		general.add(numb29);
		numb29.setBorderPainted(false);
		numb29.setEnabled(false);
		general.add(numb30);
		numb30.setBorderPainted(false);
		numb30.setEnabled(false);
		general.add(numb31);
		numb31.setBorderPainted(false);
		numb31.setEnabled(false);
		general.add(numb32);
		numb32.setBorderPainted(false);
		numb32.setEnabled(false);
		general.add(numb33);
		numb33.setBorderPainted(false);
		numb33.setEnabled(false);
		general.add(numb34);
		numb34.setBorderPainted(false);
		numb34.setEnabled(false);
		general.add(numb35);
		numb35.setBorderPainted(false);
		numb35.setEnabled(false);
		general.add(numb36);
		numb36.setBorderPainted(false);
		numb36.setEnabled(false);
		general.add(numb37);
		numb37.setBorderPainted(false);
		numb37.setEnabled(false);
		general.add(numb38);
		numb38.setBorderPainted(false);
		numb38.setEnabled(false);
		general.add(numb39);
		numb39.setBorderPainted(false);
		numb39.setEnabled(false);
		general.add(numb40);
		numb40.setBorderPainted(false);
		numb40.setEnabled(false);
		general.add(numb41);
		numb41.setBorderPainted(false);
		numb41.setEnabled(false);
		general.add(numb42);
		numb42.setBorderPainted(false);
		numb42.setEnabled(false);
		general.add(numb43);
		numb43.setBorderPainted(false);
		numb43.setEnabled(false);
		general.add(numb44);
		numb44.setBorderPainted(false);
		numb44.setEnabled(false);
		general.add(numb45);
		numb45.setBorderPainted(false);
		numb45.setEnabled(false);
		general.add(numb46);
		numb46.setBorderPainted(false);
		numb46.setEnabled(false);
		general.add(numb47);
		numb47.setBorderPainted(false);
		numb47.setEnabled(false);
		general.add(numb48);
		numb48.setBorderPainted(false);
		numb48.setEnabled(false);
		general.add(numb49);
		numb49.setBorderPainted(false);
		numb49.setEnabled(false);
		general.add(numb50);
		numb50.setBorderPainted(false);
		numb50.setEnabled(false);
		general.add(numb51);
		numb51.setBorderPainted(false);
		numb51.setEnabled(false);
		general.add(numb52);
		numb52.setBorderPainted(false);
		numb52.setEnabled(false);
		general.add(numb53);
		numb53.setBorderPainted(false);
		numb53.setEnabled(false);
		general.add(numb54);
		numb54.setBorderPainted(false);
		numb54.setEnabled(false);
		general.add(numb55);
		numb55.setBorderPainted(false);
		numb55.setEnabled(false);
		general.add(numb56);
		numb56.setBorderPainted(false);
		numb56.setEnabled(false);
		general.add(numb57);
		numb57.setBorderPainted(false);
		numb57.setEnabled(false);
		general.add(numb58);
		numb58.setBorderPainted(false);
		numb58.setEnabled(false);
		general.add(numb59);
		numb59.setBorderPainted(false);
		numb59.setEnabled(false);
		general.add(numb60);
		numb60.setBorderPainted(false);
		numb60.setEnabled(false);
		general.add(numb61);
		numb61.setBorderPainted(false);
		numb61.setEnabled(false);
		general.add(numb62);
		numb62.setBorderPainted(false);
		numb62.setEnabled(false);
		general.add(numb63);
		numb63.setBorderPainted(false);
		numb63.setEnabled(false);
		general.add(numb64);
		numb64.setBorderPainted(false);
		numb64.setEnabled(false);
		general.add(numb65);
		numb65.setBorderPainted(false);
		numb65.setEnabled(false);
		general.add(numb66);
		numb66.setBorderPainted(false);
		numb66.setEnabled(false);
		general.add(numb67);
		numb67.setBorderPainted(false);
		numb67.setEnabled(false);
		general.add(numb68);
		numb68.setBorderPainted(false);
		numb68.setEnabled(false);
		general.add(numb69);
		numb69.setBorderPainted(false);
		numb69.setEnabled(false);
		general.add(numb70);
		numb70.setBorderPainted(false);
		numb70.setEnabled(false);
		
		
		add(displayPanel,BorderLayout.NORTH);
		add(general,BorderLayout.CENTER);
		add(helpPanel,BorderLayout.SOUTH);
	}
	
	/**
	 * 
	 * @author zzaxec
	 *
	 */
	private class getAction implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource().equals(add)){
				Datawindow ziehung = new Datawindow();
			}
			if(e.getSource().equals(saveState)){
				speichereZustand();
			}
			if(e.getSource().equals(loadState)){
				try {
					ladeZustand();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				dia.setVisible(true);
				dia.setModal(true);
				dia.setTitle("Letzte Ziehung");
				dia.setSize(400, 200);
				dia.setDefaultCloseOperation(2);
				dia.setLocation(400, 400);
				OpsMethods.lastNumbers(lastNumbers, daten.get(daten.size()-1));
				dia.add(lastNumbers);
				
				OpsMethods.computeStatistik(daten, statistics);
				
			}
			if(e.getSource().equals(generate)){
				arrayLaenge = OpsMethods.laengederMap(daten,statistics);
				randomKenoNumbs = new int[arrayLaenge];
				OpsMethods.generateNumbers2(daten,randomKenoNumbs, statistics);
				Arrays.sort(randomKenoNumbs);
				String temp = "";
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				display.setText("");
				for(int i=0; i<randomKenoNumbs.length; i++){
					temp += Double.toString(statistics[randomKenoNumbs[i]-1])+" | ";
				}
				display.setText(temp);
				System.out.println(randomKenoNumbs.length);
				
				// Markiere die generierten Zahlen
				for(int i=0; i<=70; i++){
					if( i == 0)
						continue;
					if(OpsMethods.findInArray(randomKenoNumbs,i)){
						general.getComponent(i-1).setBackground(Color.WHITE);
					}else
						general.getComponent(i-1).setBackground(null);
				}
			}
			if(e.getSource().equals(stats)){
				statistiken.setVisible(true);
				statistiken.setModal(true);
				statistiken.setTitle("Statistik");
				statistiken.setSize(300, 650);
				statistiken.setDefaultCloseOperation(2);
				statistiken.setLocation(700, 10);
				statistiken.setResizable(false);
				txt.setText(OpsMethods.computeStats(daten));
				statistiken.add(txt);
				txt.setEditable(false);
				
			}
		}
	}
	
	/**
	 * 
	 */
	public void speichereZustand(){
		ArrayList<int[]> temp = Datapanel.getDataBase();
		//füge neue Ziehungen hinzu
		for(int j=0; j<temp.size(); j++){
			daten.add(temp.get(j));
		}
		
		
		OutputStream fos = null;

		try
		{
		  fos = new FileOutputStream( "state.ser" );
		  ObjectOutputStream o = new ObjectOutputStream( fos );
		  o.writeObject(daten);
		}
		catch ( IOException e ) { System.err.println( e ); }
		finally { try { fos.close(); } catch ( Exception e ) { e.printStackTrace(); } }
	}
	
	
	/**
	 * @throws ClassNotFoundException 
	 * 
	 */
	public void ladeZustand() throws ClassNotFoundException{
		InputStream fis = null;

		try
		{
		  fis = new FileInputStream( "state.ser" );
		  ObjectInputStream o = new ObjectInputStream( fis );
		  daten = (ArrayList<int[]>) o.readObject();
		}
		catch ( IOException e ) { System.err.println( e ); }
		finally { try { fis.close(); } catch ( Exception e ) { } }
	}

}