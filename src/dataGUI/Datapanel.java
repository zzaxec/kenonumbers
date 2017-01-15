package dataGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import methods.OpsMethods;

public class Datapanel extends JPanel{
	//Buttons
	JButton but1 = new JButton("1"),
			but2 = new JButton("2"),
			but3 = new JButton("3"),
			but4 = new JButton("4"),
			but5 = new JButton("5"),
			but6 = new JButton("6"),
			but7 = new JButton("7"),
			but8 = new JButton("8"),
			but9 = new JButton("9"),
			but0 = new JButton("0"),
			clear = new JButton("Löschen"),
			add = new JButton("Hinzufügen"),
			display = new JButton("Geben Sie die Zahlen der letzten Ziehung ein"),
			zahlen = new JButton(""),
			saveIntoArray = new JButton("Speichern"),
			undo = new JButton("Rückgängig");
	//Panels
	JPanel keyboard = new JPanel(),
			anzeige = new JPanel(),
			optionalpanel = new JPanel();
	
	
	private boolean start = false;
	
	private int tempcount;
	
	private static ArrayList<int[]> dataBase;
	

	// Get- und Setfunktionen
	public static ArrayList<int[]> getDataBase() {
		return dataBase;
	}

	//Constructor
	public Datapanel(){
		dataBase = new ArrayList<int[]>();
		//Layout erstellen
		setLayout(new BorderLayout());
		
		// Listener
		ActionListener aktion = new ActListener();
		ActionListener otherBut = new DiverseButtons();
		
		
		
		//Das Panel hat ein Gitterlayout fuer die Tastatur
		keyboard.setLayout(new GridLayout(4, 1));
		
		//Die Anzeige befindet sich ueberhalb der Tastatur
		anzeige.add(display);
		anzeige.add(zahlen);
		
		//Optionale Buttons auf diesem Panel
		optionalpanel.add(saveIntoArray);
		optionalpanel.add(undo);
		
		
		//Binding an die ActionListener
		but0.addActionListener(aktion);
		but1.addActionListener(aktion);
		but2.addActionListener(aktion);
		but3.addActionListener(aktion);
		but4.addActionListener(aktion);
		but5.addActionListener(aktion);
		but6.addActionListener(aktion);
		but7.addActionListener(aktion);
		but8.addActionListener(aktion);
		but9.addActionListener(aktion);
		add.addActionListener(otherBut);
		
		
		//Die Buttons modifizieren
		display.setEnabled(false);
		zahlen.setEnabled(false);
		saveIntoArray.addActionListener(otherBut);
		clear.addActionListener(otherBut);
		undo.addActionListener(otherBut);
		
		//Tastatur aufbauen
		keyboard.add(but0);
		keyboard.add(but1);
		keyboard.add(but2);
		keyboard.add(but3);
		keyboard.add(but4);
		keyboard.add(but5);
		keyboard.add(but6);
		keyboard.add(but7);
		keyboard.add(but8);
		keyboard.add(clear);
		keyboard.add(but9);
		keyboard.add(add);
		
		add(anzeige, BorderLayout.NORTH);
		add(keyboard, BorderLayout.CENTER);
		add(optionalpanel, BorderLayout.SOUTH);
		
	}
	
	/**
	 * 
	 * @author Hakan
	 *
	 */
	private class ActListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(but0) && gibEingabe().length()<2 ){
				zahlen.setText(gibEingabe()+"0");
			}
			if(e.getSource().equals(but1) && gibEingabe().length()<2 ){
				zahlen.setText(gibEingabe()+"1");
			}
			if(e.getSource().equals(but2) && gibEingabe().length()<2 ){
				zahlen.setText(gibEingabe()+"2");
			}
			if(e.getSource().equals(but3) && gibEingabe().length()<2 ){
				zahlen.setText(gibEingabe()+"3");
			}
			if(e.getSource().equals(but4) && gibEingabe().length()<2 ){
				zahlen.setText(gibEingabe()+"4");
			}
			if(e.getSource().equals(but5) && gibEingabe().length()<2 ){
				zahlen.setText(gibEingabe()+"5");
			}
			if(e.getSource().equals(but6) && gibEingabe().length()<2 ){
				zahlen.setText(gibEingabe()+"6");
			}
			if(e.getSource().equals(but7) && gibEingabe().length()<2 ){
				zahlen.setText(gibEingabe()+"7");
			}
			if(e.getSource().equals(but8) && gibEingabe().length()<2 ){
				zahlen.setText(gibEingabe()+"8");
			}
			if(e.getSource().equals(but9) && gibEingabe().length()<2 ){
				zahlen.setText(gibEingabe()+"9");
			}
		}
	}
	
	/**
	 * 
	 * @author Hakan
	 *
	 */
	private class DiverseButtons implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(clear)){
				zahlen.setText("");
			}
			if(e.getSource().equals(add) && !start){
				start = true;
				display.setText("");
				tempcount = Integer.parseInt(gibEingabe());
			}
			if(e.getSource().equals(add) && start && OpsMethods.countNumbers(gibAnzeige())<=19 && OpsMethods.catchDouble(gibAnzeige(), gibEingabe())){
				tempcount = Integer.parseInt(gibEingabe());
				display.setText(gibAnzeige()+Integer.toString(tempcount)+",");
				zahlen.setText("");
			}
			if(e.getSource().equals(saveIntoArray) && OpsMethods.countNumbers(gibAnzeige())==20 ){
				dataBase.add(OpsMethods.saveArray(gibAnzeige()));
				display.setText("Neue Zahlen eingeben bitte!");
				start = false;
			}
			if(e.getSource().equals(undo)){
				display.setText(gibAnzeige().substring(0, gibAnzeige().length()-3));
			}
		}
		
	}
	
	
	//Weitere Methoden
	public String gibAnzeige(){
		return display.getText();
	}
	
	public String gibEingabe(){
		return zahlen.getText();
	}
}
