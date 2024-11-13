package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {
	

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		try {
		PrintWriter skriver = new PrintWriter(mappe+filnavn);
		
		skriver.println(samling.toString());
		skriver.close();
		return true;
		}
		catch(Exception e){
			System.out.print("Skriv inn gyldig filnavn");
			return false;
		}
	}
}
