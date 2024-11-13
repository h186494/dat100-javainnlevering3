package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.Bilde;
import no.hvl.dat100.oppgave2.Tekst;

public class Blogg {

	private Innlegg[] innleggtab;
	private int nesteledig;

	public Blogg() {
		this.innleggtab = new Innlegg[20];
		this.nesteledig = 0;
	}

	public Blogg(int lengde) {
		this.innleggtab = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return this.nesteledig;
	}

	public Innlegg[] getSamling() {
		return this.innleggtab;

	}

	public int finnInnlegg(Innlegg innlegg) {

		for (int i = 0; i < this.nesteledig; i++) {
			if (innleggtab[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (int i = 0; i < this.nesteledig; i++) {
			if (innleggtab[i].erLik(innlegg)) {
				return true;
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		if (this.nesteledig < this.innleggtab.length) {
			return true;
		}
		return false;

	}

	public boolean leggTil(Innlegg innlegg) {

		if (finnes(innlegg)) {
			return false;
		} else {
			this.innleggtab[nesteledig] = innlegg;
			this.nesteledig++;
		}
		return true;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.nesteledig).append("\n");
		for (Innlegg innlegg : innleggtab) {
			str.append(innlegg.toString());}
		return str.toString();
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] tmpList = new Innlegg[this.innleggtab.length*2];
		int i = 0;
		for(Innlegg innlegg:this.innleggtab) {
			tmpList[i++] = innlegg;
		}
		this.innleggtab = tmpList;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		int i = 0;
		if (finnes(innlegg)) {
			return false;
		} else {
			if(nesteledig  == this.innleggtab.length) {
				Innlegg[] tmpList = new Innlegg[innleggtab.length+1];
				for(Innlegg val: this.innleggtab) {
					tmpList[i++] = val;
				}
				tmpList[nesteledig] = innlegg;
				this.innleggtab = tmpList;
				return true;
			}
			else {
			this.innleggtab[nesteledig] = innlegg;
			this.nesteledig++;
			}
		}
		
		return true;
		

	}

	public boolean slett(Innlegg innlegg) {
		LinkedHashSet<Innlegg> tmpList = new LinkedHashSet<>(Arrays.asList(this.innleggtab));
		if(tmpList.contains(innlegg)) {
			tmpList.remove(innlegg);
		}
		else {
			return false;
		}
		
		this.innleggtab = tmpList.toArray(new Innlegg[0]);
		return true;
	}

	public int[] search(String keyword) {
		HashSet<Integer> tmpList = new HashSet<>();

		for(Innlegg innlegg: this.innleggtab) {
			if(innlegg instanceof Tekst) {
				Tekst tekst = (Tekst)innlegg;
				if(tekst.getTekst().equals(keyword)) {
					tmpList.add(innlegg.getId());
				}
				
			}
		}
		int[] lst = new int[tmpList.size()];
		int i = 0;
		for(int val:tmpList) {
			lst[i++] = val;
		}
		return lst;

	}
}