package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		Blogg samling = null; 
		Scanner leser = null;
		try {
		File fil = new File(mappe+filnavn);
		leser = new Scanner(fil);
		String linje;
		samling = new Blogg(Integer.parseInt(leser.nextLine()));
		while(leser.hasNextLine()){
			linje = leser.nextLine();
			if(linje.equals(BILDE)) {
				String[] tmpList = new String[6];
				for(int i = 0; i<6; i++) {
					tmpList[i] = leser.nextLine();
					
				}
				Bilde tmp = new Bilde(
						Integer.parseInt(tmpList[1]),
						tmpList[2],
						tmpList[3],
						Integer.parseInt(tmpList[4]),
						tmpList[5],
						tmpList[6]);
				samling.leggTil(tmp);
			}
			else if(linje.equals(TEKST)) {
				String[] tmpList = new String[5];
				for(int j = 0; j<5; j++) {
					tmpList[j] = leser.nextLine();
					
				}
				Tekst tmp = new Tekst(
						Integer.parseInt(tmpList[1]),
						tmpList[2],
						tmpList[3],
						Integer.parseInt(tmpList[4]),
						tmpList[5]);
				samling.leggTil(tmp);
			}
			
			
			
		}
		}
		catch(Exception e) {
			System.out.println("Du må legge inn en gyldig fil");
		}
		finally {  
		leser.close(); 
		
		} 
		return samling;
		
	}
}
