
package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import dataGUI.Datapanel;
import dataGUI.Datawindow;
import methods.OpsMethods;


public class KenoPanel extends JPanel{

	ArrayList<int[]>						daten				= new ArrayList<int[]>();
	private int[]								randomKenoNumbs;
	private int									arrayLaenge;
	private double[]						statistics	= new double[70];
	private ArrayList<Integer>	over30			= new ArrayList<Integer>(), exact20 = new ArrayList<Integer>(),
			exact10 = new ArrayList<Integer>(), lastDraw = new ArrayList<Integer>();

	private ArrayList<Integer>	neueZahlen	= new ArrayList<Integer>();

	// Buttons
	JButton											add					= new JButton("Ziehung hinzufügen"), generate = new JButton("Generiere"),
			display = new JButton("Willkommen Millionär!"), saveState = new JButton("Speichern"),
			loadState = new JButton("Laden"), lastNumbers = new JButton(""), stats = new JButton("Statistik"),
			numb1 = new JButton("1"), numb2 = new JButton("2"), numb3 = new JButton("3"), numb4 = new JButton("4"),
			numb5 = new JButton("5"), numb6 = new JButton("6"), numb7 = new JButton("7"), numb8 = new JButton("8"),
			numb9 = new JButton("9"), numb10 = new JButton("10"), numb11 = new JButton("11"), numb12 = new JButton("12"),
			numb13 = new JButton("13"), numb14 = new JButton("14"), numb15 = new JButton("15"), numb16 = new JButton("16"),
			numb17 = new JButton("17"), numb18 = new JButton("18"), numb19 = new JButton("19"), numb20 = new JButton("20"),
			numb21 = new JButton("21"), numb22 = new JButton("22"), numb23 = new JButton("23"), numb24 = new JButton("24"),
			numb25 = new JButton("25"), numb26 = new JButton("26"), numb27 = new JButton("27"), numb28 = new JButton("28"),
			numb29 = new JButton("29"), numb30 = new JButton("30"), numb31 = new JButton("31"), numb32 = new JButton("32"),
			numb33 = new JButton("33"), numb34 = new JButton("34"), numb35 = new JButton("35"), numb36 = new JButton("36"),
			numb37 = new JButton("37"), numb38 = new JButton("38"), numb39 = new JButton("39"), numb40 = new JButton("40"),
			numb41 = new JButton("41"), numb42 = new JButton("42"), numb43 = new JButton("43"), numb44 = new JButton("44"),
			numb45 = new JButton("45"), numb46 = new JButton("46"), numb47 = new JButton("47"), numb48 = new JButton("48"),
			numb49 = new JButton("49"), numb50 = new JButton("50"), numb51 = new JButton("51"), numb52 = new JButton("52"),
			numb53 = new JButton("53"), numb54 = new JButton("54"), numb55 = new JButton("55"), numb56 = new JButton("56"),
			numb57 = new JButton("57"), numb58 = new JButton("58"), numb59 = new JButton("59"), numb60 = new JButton("60"),
			numb61 = new JButton("61"), numb62 = new JButton("62"), numb63 = new JButton("63"), numb64 = new JButton("64"),
			numb65 = new JButton("65"), numb66 = new JButton("66"), numb67 = new JButton("67"), numb68 = new JButton("68"),
			numb69 = new JButton("69"), numb70 = new JButton("70"), test = new JButton("Algorithmus 2");
	// Panels
	JPanel											helpPanel		= new JPanel(), displayPanel = new JPanel(), general = new JPanel();

	JDialog											dia					= new JDialog(), statistiken = new JDialog();

	JTextPane										txt					= new JTextPane();

	// Constructor
	public KenoPanel(){
		setLayout(new BorderLayout());

		// ActionListener
		ActionListener aktion = new getAction();

		// Buttons modifizieren
		this.display.setEnabled(false);
		this.add.addActionListener(aktion);
		this.saveState.addActionListener(aktion);
		this.loadState.addActionListener(aktion);
		this.generate.addActionListener(aktion);
		this.stats.addActionListener(aktion);
		this.test.addActionListener(aktion);

		//
		this.displayPanel.add(this.display);
		this.displayPanel.add(this.stats);

		//
		this.helpPanel.add(this.saveState);
		this.helpPanel.add(this.loadState);
		this.helpPanel.add(this.add);
		this.helpPanel.add(this.generate);
		this.helpPanel.add(this.test);

		//
		this.general.setLayout(new GridLayout(10, 7));

		this.general.add(this.numb1);
		this.numb1.setBorderPainted(false);
		this.numb1.setEnabled(false);
		this.general.add(this.numb2);
		this.numb2.setBorderPainted(false);
		this.numb2.setEnabled(false);
		this.general.add(this.numb3);
		this.numb3.setBorderPainted(false);
		this.numb3.setEnabled(false);
		this.general.add(this.numb4);
		this.numb4.setBorderPainted(false);
		this.numb4.setEnabled(false);
		this.general.add(this.numb5);
		this.numb5.setBorderPainted(false);
		this.numb5.setEnabled(false);
		this.general.add(this.numb6);
		this.numb6.setBorderPainted(false);
		this.numb6.setEnabled(false);
		this.general.add(this.numb7);
		this.numb7.setBorderPainted(false);
		this.numb7.setEnabled(false);
		this.general.add(this.numb8);
		this.numb8.setBorderPainted(false);
		this.numb8.setEnabled(false);
		this.general.add(this.numb9);
		this.numb9.setBorderPainted(false);
		this.numb9.setEnabled(false);
		this.general.add(this.numb10);
		this.numb10.setBorderPainted(false);
		this.numb10.setEnabled(false);
		this.general.add(this.numb11);
		this.numb11.setBorderPainted(false);
		this.numb11.setEnabled(false);
		this.general.add(this.numb12);
		this.numb12.setBorderPainted(false);
		this.numb12.setEnabled(false);
		this.general.add(this.numb13);
		this.numb13.setBorderPainted(false);
		this.numb13.setEnabled(false);
		this.general.add(this.numb14);
		this.numb14.setBorderPainted(false);
		this.numb14.setEnabled(false);
		this.general.add(this.numb15);
		this.numb15.setBorderPainted(false);
		this.numb15.setEnabled(false);
		this.general.add(this.numb16);
		this.numb16.setBorderPainted(false);
		this.numb16.setEnabled(false);
		this.general.add(this.numb17);
		this.numb17.setBorderPainted(false);
		this.numb17.setEnabled(false);
		this.general.add(this.numb18);
		this.numb18.setBorderPainted(false);
		this.numb18.setEnabled(false);
		this.general.add(this.numb19);
		this.numb19.setBorderPainted(false);
		this.numb19.setEnabled(false);
		this.general.add(this.numb20);
		this.numb20.setBorderPainted(false);
		this.numb20.setEnabled(false);
		this.general.add(this.numb21);
		this.numb21.setBorderPainted(false);
		this.numb21.setEnabled(false);
		this.general.add(this.numb22);
		this.numb22.setBorderPainted(false);
		this.numb22.setEnabled(false);
		this.general.add(this.numb23);
		this.numb23.setBorderPainted(false);
		this.numb23.setEnabled(false);
		this.general.add(this.numb24);
		this.numb24.setBorderPainted(false);
		this.numb24.setEnabled(false);
		this.general.add(this.numb25);
		this.numb25.setBorderPainted(false);
		this.numb25.setEnabled(false);
		this.general.add(this.numb26);
		this.numb26.setBorderPainted(false);
		this.numb26.setEnabled(false);
		this.general.add(this.numb27);
		this.numb27.setBorderPainted(false);
		this.numb27.setEnabled(false);
		this.general.add(this.numb28);
		this.numb28.setBorderPainted(false);
		this.numb28.setEnabled(false);
		this.general.add(this.numb29);
		this.numb29.setBorderPainted(false);
		this.numb29.setEnabled(false);
		this.general.add(this.numb30);
		this.numb30.setBorderPainted(false);
		this.numb30.setEnabled(false);
		this.general.add(this.numb31);
		this.numb31.setBorderPainted(false);
		this.numb31.setEnabled(false);
		this.general.add(this.numb32);
		this.numb32.setBorderPainted(false);
		this.numb32.setEnabled(false);
		this.general.add(this.numb33);
		this.numb33.setBorderPainted(false);
		this.numb33.setEnabled(false);
		this.general.add(this.numb34);
		this.numb34.setBorderPainted(false);
		this.numb34.setEnabled(false);
		this.general.add(this.numb35);
		this.numb35.setBorderPainted(false);
		this.numb35.setEnabled(false);
		this.general.add(this.numb36);
		this.numb36.setBorderPainted(false);
		this.numb36.setEnabled(false);
		this.general.add(this.numb37);
		this.numb37.setBorderPainted(false);
		this.numb37.setEnabled(false);
		this.general.add(this.numb38);
		this.numb38.setBorderPainted(false);
		this.numb38.setEnabled(false);
		this.general.add(this.numb39);
		this.numb39.setBorderPainted(false);
		this.numb39.setEnabled(false);
		this.general.add(this.numb40);
		this.numb40.setBorderPainted(false);
		this.numb40.setEnabled(false);
		this.general.add(this.numb41);
		this.numb41.setBorderPainted(false);
		this.numb41.setEnabled(false);
		this.general.add(this.numb42);
		this.numb42.setBorderPainted(false);
		this.numb42.setEnabled(false);
		this.general.add(this.numb43);
		this.numb43.setBorderPainted(false);
		this.numb43.setEnabled(false);
		this.general.add(this.numb44);
		this.numb44.setBorderPainted(false);
		this.numb44.setEnabled(false);
		this.general.add(this.numb45);
		this.numb45.setBorderPainted(false);
		this.numb45.setEnabled(false);
		this.general.add(this.numb46);
		this.numb46.setBorderPainted(false);
		this.numb46.setEnabled(false);
		this.general.add(this.numb47);
		this.numb47.setBorderPainted(false);
		this.numb47.setEnabled(false);
		this.general.add(this.numb48);
		this.numb48.setBorderPainted(false);
		this.numb48.setEnabled(false);
		this.general.add(this.numb49);
		this.numb49.setBorderPainted(false);
		this.numb49.setEnabled(false);
		this.general.add(this.numb50);
		this.numb50.setBorderPainted(false);
		this.numb50.setEnabled(false);
		this.general.add(this.numb51);
		this.numb51.setBorderPainted(false);
		this.numb51.setEnabled(false);
		this.general.add(this.numb52);
		this.numb52.setBorderPainted(false);
		this.numb52.setEnabled(false);
		this.general.add(this.numb53);
		this.numb53.setBorderPainted(false);
		this.numb53.setEnabled(false);
		this.general.add(this.numb54);
		this.numb54.setBorderPainted(false);
		this.numb54.setEnabled(false);
		this.general.add(this.numb55);
		this.numb55.setBorderPainted(false);
		this.numb55.setEnabled(false);
		this.general.add(this.numb56);
		this.numb56.setBorderPainted(false);
		this.numb56.setEnabled(false);
		this.general.add(this.numb57);
		this.numb57.setBorderPainted(false);
		this.numb57.setEnabled(false);
		this.general.add(this.numb58);
		this.numb58.setBorderPainted(false);
		this.numb58.setEnabled(false);
		this.general.add(this.numb59);
		this.numb59.setBorderPainted(false);
		this.numb59.setEnabled(false);
		this.general.add(this.numb60);
		this.numb60.setBorderPainted(false);
		this.numb60.setEnabled(false);
		this.general.add(this.numb61);
		this.numb61.setBorderPainted(false);
		this.numb61.setEnabled(false);
		this.general.add(this.numb62);
		this.numb62.setBorderPainted(false);
		this.numb62.setEnabled(false);
		this.general.add(this.numb63);
		this.numb63.setBorderPainted(false);
		this.numb63.setEnabled(false);
		this.general.add(this.numb64);
		this.numb64.setBorderPainted(false);
		this.numb64.setEnabled(false);
		this.general.add(this.numb65);
		this.numb65.setBorderPainted(false);
		this.numb65.setEnabled(false);
		this.general.add(this.numb66);
		this.numb66.setBorderPainted(false);
		this.numb66.setEnabled(false);
		this.general.add(this.numb67);
		this.numb67.setBorderPainted(false);
		this.numb67.setEnabled(false);
		this.general.add(this.numb68);
		this.numb68.setBorderPainted(false);
		this.numb68.setEnabled(false);
		this.general.add(this.numb69);
		this.numb69.setBorderPainted(false);
		this.numb69.setEnabled(false);
		this.general.add(this.numb70);
		this.numb70.setBorderPainted(false);
		this.numb70.setEnabled(false);

		add(this.displayPanel, BorderLayout.NORTH);
		add(this.general, BorderLayout.CENTER);
		add(this.helpPanel, BorderLayout.SOUTH);
	}

	/**
	 *
	 * @author zzaxec
	 *
	 */
	private class getAction implements ActionListener{

		public void actionPerformed( ActionEvent e ){

			if (e.getSource().equals(KenoPanel.this.add)) {
				new Datawindow();
			}
			if (e.getSource().equals(KenoPanel.this.saveState)) {
				speichereZustand();
			}
			if (e.getSource().equals(KenoPanel.this.loadState)) {
				try {
					ladeZustand();
				}
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				KenoPanel.this.dia.setVisible(true);
				KenoPanel.this.dia.setModal(true);
				KenoPanel.this.dia.setTitle("Letzte Ziehung");
				KenoPanel.this.dia.setSize(400, 200);
				KenoPanel.this.dia.setDefaultCloseOperation(2);
				KenoPanel.this.dia.setLocation(400, 400);
				OpsMethods.lastNumbers(KenoPanel.this.lastNumbers, KenoPanel.this.daten.get(KenoPanel.this.daten.size() - 1));
				KenoPanel.this.dia.add(KenoPanel.this.lastNumbers);

				OpsMethods.computeStatistik(KenoPanel.this.daten, KenoPanel.this.statistics);

				OpsMethods.deleteAll(KenoPanel.this.over30, KenoPanel.this.exact20, KenoPanel.this.exact10,
						KenoPanel.this.lastDraw, KenoPanel.this.neueZahlen);

				OpsMethods.newAlgorithm(KenoPanel.this.daten, KenoPanel.this.statistics, KenoPanel.this.over30,
						KenoPanel.this.exact20, KenoPanel.this.exact10, KenoPanel.this.lastDraw);

			}
			if (e.getSource().equals(KenoPanel.this.generate)) {
				KenoPanel.this.arrayLaenge = OpsMethods.laengederMap(KenoPanel.this.daten, KenoPanel.this.statistics);
				KenoPanel.this.randomKenoNumbs = new int[KenoPanel.this.arrayLaenge];
				OpsMethods.generateNumbers2(KenoPanel.this.daten, KenoPanel.this.randomKenoNumbs, KenoPanel.this.statistics);
				Arrays.sort(KenoPanel.this.randomKenoNumbs);
				String temp = "";
				try {
					Thread.sleep(1500);
				}
				catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				KenoPanel.this.display.setText("");
				for (int i = 0; i < KenoPanel.this.randomKenoNumbs.length; i++) {
					temp += Double.toString(KenoPanel.this.statistics[KenoPanel.this.randomKenoNumbs[i] - 1]) + " | ";
				}
				if (e.getSource().equals(KenoPanel.this.test)) {

				}
				KenoPanel.this.display.setText(temp);

				// Markiere die generierten Zahlen
				for (int i = 0; i <= 70; i++) {
					if (i == 0) {
						continue;
					}
					if (OpsMethods.findInArray(KenoPanel.this.randomKenoNumbs, i)) {
						KenoPanel.this.general.getComponent(i - 1).setBackground(Color.WHITE);
					} else {
						KenoPanel.this.general.getComponent(i - 1).setBackground(null);
					}
				}
			}
			if (e.getSource().equals(KenoPanel.this.stats)) {
				KenoPanel.this.statistiken.setVisible(true);
				KenoPanel.this.statistiken.setModal(true);
				KenoPanel.this.statistiken.setTitle("Statistik");
				KenoPanel.this.statistiken.setSize(300, 650);
				KenoPanel.this.statistiken.setDefaultCloseOperation(2);
				KenoPanel.this.statistiken.setLocation(700, 10);
				KenoPanel.this.statistiken.setResizable(false);
				KenoPanel.this.txt.setText(OpsMethods.computeStats(KenoPanel.this.daten));
				KenoPanel.this.statistiken.add(KenoPanel.this.txt);
				KenoPanel.this.txt.setEditable(false);

			}

			if (e.getSource().equals(KenoPanel.this.test)) {
				OpsMethods.generateNew(KenoPanel.this.over30, KenoPanel.this.exact20, KenoPanel.this.exact10,
						KenoPanel.this.lastDraw, KenoPanel.this.neueZahlen);

				Collections.sort(KenoPanel.this.neueZahlen);

				Frame f = new Frame();
				JOptionPane alert = new JOptionPane();
				String numbers = "";
				for (int x : KenoPanel.this.neueZahlen) {
					numbers += x + "  ";
				}
				alert.showMessageDialog(f, numbers);

			}
		}
	}

	/**
	 *
	 */
	public void speichereZustand(){
		ArrayList<int[]> temp = Datapanel.getDataBase();
		// füge neue Ziehungen hinzu
		for (int j = 0; j < temp.size(); j++) {
			this.daten.add(temp.get(j));
		}

		OutputStream fos = null;

		try {
			fos = new FileOutputStream("state.ser");
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(this.daten);
		}
		catch (IOException e) {
			System.err.println(e);
		}
		finally {
			try {
				fos.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @throws ClassNotFoundException
	 *
	 */
	public void ladeZustand() throws ClassNotFoundException{
		InputStream fis = null;

		try {
			fis = new FileInputStream("state.ser");
			ObjectInputStream o = new ObjectInputStream(fis);
			this.daten = (ArrayList<int[]>) o.readObject();
		}
		catch (IOException e) {
			System.err.println(e);
		}
		finally {
			try {
				fis.close();
			}
			catch (Exception e) {
			}
		}
	}

}