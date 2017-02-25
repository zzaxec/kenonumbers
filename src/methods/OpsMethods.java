package methods;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList; 
import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JButton;


/**
 * Diese Klasse enthaelt alle Methoden, die zur Berechnung und Datenauswertung geschrieben und verwendet werden.
 * Jede Methode besitzt eine eigene Kommentierung zum vereinfachtem Verstï¿½ndnis.
 * @author zzaxec
 *
 */
/**
 * @author zzaxec
 *
 */
public class OpsMethods {
	/**
	 * Diese Methode speichert Zahlen, welche als Strings eingegeben wurden in ein
	 * eindimensionales Array durch schrittweise unterteilung des Strings.
	 * @param txt der zu zerlegene String, der die Zahlen enthÃ¤lt, welche gespeichert werden muessen
	 * @param data 
	 */
	public static int[] saveArray(String txt){
		int[] temp = new int[20];
		int count = 0;
		String number = "";
		
		for(int i=0; i<txt.length(); i++){
			if(txt.substring(i, i+1).equals(",")){
				temp[count] = Integer.parseInt(number);
				number = "";
				count++;
			}else{
				number += txt.substring(i, i+1);
			}
		}
		return temp;
	}
	
	/**
	 * 
	 * @param txt
	 * @return
	 */
	public static int countNumbers(String txt){
		String tempTxt = txt;
		int erg = 0;
		for(int i=0; i<tempTxt.length(); i++){
			if(tempTxt.substring(i, i+1).equals(",")){
				erg++;
			}
		}
		return erg;
	}
	
	/**
	 * 
	 * @param txt1
	 * @param txt2
	 * @return
	 */
	public static boolean catchDouble(String txt1, String txt2){
		boolean erg = true;
		String compare = "";
		for(int i=0; i<txt1.length(); i++){
			if(txt1.substring(i, i+1).equals(",")){
				if(compare.equals(txt2)){
					erg = false;
				}else
					compare = "";
			}else{
				compare += txt1.substring(i, i+1);
			}
		}
		return erg;
	}
	
	/**
	 * 
	 * @param but
	 * @param arr
	 */
	public static void lastNumbers(JButton but, int[] arr){
		String temp = "";
		for(int i=0; i<arr.length; i++){
			temp += arr[i] + " ";
		}
		but.setEnabled(false);
		but.setText(temp);
	}
	
	/**
	 * 
	 * @param liste
	 * @param keno
	 */
	public static void generateNumbers(ArrayList<int[]> liste, int[] keno){
		Random r = new Random();
		int number;
		for(int i=0; i<6; i++){
			number = r.nextInt(70)+1;
			while(findInArray(keno,number)){
				number = r.nextInt(70)+1;
			}
			while(findInArray(liste.get(liste.size()-1),number)){
				number = r.nextInt(70)+1;
			}
			keno[i] = number;
		}
	}
	
	/**
	 * Diese Methode generiert neue KENO-Zahlen fuer die naechste Ziehung. Dabei berücksichtigt er nur Zahlen,
	 * dessen Wahrscheinlichkeit sich um einen vorher festgelegten Wert von der Durchschnittswahrscheinlichkeit variiert
	 * und die Zahlen der letzten Ziehung vernachlässigt werden.
	 * Die Toleranz der Variierung liegt derzeit bei 3%.
	 * @param liste die Liste mit jeder Ziehung (Datensatz)
	 * @param keno das Array der generierten Zahlen fuer die naechste Ziehung
	 * @param stats die Statistiken jeder Ziffer
	 */
	public static void generateNumbers2(ArrayList<int[]> liste,int[] keno, double[] stats){
		// Zaehler berechnen
		int erg = 0;
		for(int i=0; i<stats.length; i++){
			erg += stats[i];
		}
		// Nenner berechnen
		int size = stats.length;

		// Noetige Deklarationen
		Random r = new Random();
		int[] zahlen = new int[70];
		double medium = computeMedium(stats);
		double threshholdLow = medium-3.0, threshholdhigh = medium + 3.0;
		
		// Letzte, vorletzte und vorvorletzte Ziehung
		int last = liste.size()-1, last1 = liste.size()-2, last2 = liste.size()-3;
		
		// Fuelle das Array mit den Zahlen von 1 bis 70
		for(int i=0; i<zahlen.length; i++){
			zahlen[i] = i+1;
		}
		//Streiche die Zahlen der letzten Ziehungen
//		for(int i=0; i<liste.get(last).length; i++){
//			zahlen[liste.get(last)[i]-1] = 0;
//		}
		//Streiche die Zahlen der vorletzten Ziehung
//		for(int i=0; i<liste.get(last).length; i++){
//			zahlen[liste.get(last1)[i]-1] = 0;
//		}
		//Streiche die Zahlen der vorvorletzten Ziehung
		for(int i=0; i<liste.get(last).length; i++){
			zahlen[liste.get(last2)[i]-1] = 0;
		}
		
		int count1= 10, count2 = 5;
		int zufall, indexZaehler=0;
		
		while(count1>0){
			zufall = r.nextInt(70)+1;
			if(stats[zufall-1]<medium){
				keno[indexZaehler] = zufall;
				indexZaehler++;
				count1--;
			}else
				continue;
		}
		while(count2>0){
			zufall = r.nextInt(70)+1;
			if(stats[zufall-1]>medium){
				keno[indexZaehler] = zufall;
				indexZaehler++;
				count2--;
			}else
				continue;
		}
		
		
		System.out.println(medium);
	}
	

	
	//Sortieralgorithmus welches die Values einer Map aufsteigend sortiert
	static <K,V extends Comparable<? super V>>
	SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
	        new Comparator<Map.Entry<K,V>>() {
	            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	                int res = e1.getValue().compareTo(e2.getValue());
	                return res != 0 ? res : 1;
	            }
	        }
	    );
	    sortedEntries.addAll(map.entrySet());
	    return sortedEntries;
	}
	
	/**
	 * 
	 * @param stats
	 * @return
	 */
	public static Double computeMedium(double[] stats){
		double erg = 0.0;
		for(int i=0; i<stats.length; i++){
			erg += stats[i];
		}
		erg = erg / stats.length;
		return erg;
	}
	
	/**
	 * 
	 * @param array
	 * @param x
	 * @return
	 */
	public static boolean findInArray(int[] array, int x){
		boolean erg = false;
		for(int i=0; i<array.length; i++){
			if(array[i] == x)
				erg = true;
		}
		return erg;
	}
	
	
	/**
	 * 
	 * @param liste
	 * @return
	 */
	public static String computeStats(ArrayList<int[]> liste){
		String erg = "";
		int relative = liste.size();
		int[] stat = new int[70];
		// Zï¿½hle die Hï¿½ufigkeit der bisherigen Zahlen
		for(int i=0; i<liste.size(); i++){
			for(int j=0; j<liste.get(i).length; j++){
				stat[liste.get(i)[j]-1]++;
			}
		}
		for(int i=0; i<stat.length; i++){
			String lengthStr = Integer.toString(i);
			int laenge = lengthStr.length();
			if(i%2==0)
				erg += "\n";
			if(laenge == 1)
				erg += "Zahl :   "+(i+1)+" - "+Math.round( (double) stat[i]/relative * 100)+"%"+"          ";
			else
				erg += "Zahl : "+(i+1)+" - "+Math.round( (double) stat[i]/relative * 100)+"%"+"          ";
		}
		return erg;
	}
	
	/**
	 * 
	 * @param liste
	 * @param container
	 */
	public static void computeStatistik(ArrayList<int[]> liste, double[] container){
		double relative = liste.size();
		int[] stat = new int[70];
		// Zaehle die Haeufigkeit der bisherigen Zahlen
		for(int i=0; i<liste.size(); i++){
			for(int j=0; j<liste.get(i).length; j++){
				stat[liste.get(i)[j]-1]++;
			}
		}
		
		
		for(int i=0; i<container.length; i++){
			container[i] = Math.round((stat[i]/relative)*100);
		}
		
	}
}
