package it.unibs.ing.arnaldo.esame;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class Partita {

	private static final int SOGLIA_VINCITA = 1000000;

	private static final int NUMERO_DADI = 2;

	private Tabellone tabellone = new Tabellone();
	
	public void nuovaPartita() {
		
		Utility.benvenuto();
		
		tabellone.inizializzaStandard();
		
		ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();
		ArrayList<Giocatore> classificaPerdenti = new ArrayList<Giocatore>();
		
		int numGiocatori = InputDati.leggiIntero("Scegliere il numero di giocatori (MAX 4): ", 1, 4);
		
		for (int i = 0; i < numGiocatori; i++) {
			giocatori.add(new Giocatore(InputDati.leggiStringa("Inserire nome del giocatore " + (i + 1) + ": ")));
		}
		
		int lancio = 0;
		int posizione = 0;
		int dimensione = tabellone.getDimensione();
		boolean finished = false;
		
		while (!finished) {
				
			for (int i = 0; i < giocatori.size(); i++) { // mano
				
				Giocatore giocatore = giocatori.get(i);
				Utility.turno(giocatore);
				if (!Utility.vuoiContinuare()) {
					finished = true;
					break;
				}
				lancio = giocatore.lanciaDado(NUMERO_DADI);
				Utility.lanciaDado(lancio);
				posizione = giocatore.getCasellaAttuale();
				int temp = posizione + lancio;
				if (temp < dimensione) {
					giocatore.setCasellaAttuale(temp);
				} else {
					giocatore.setCasellaAttuale(temp % dimensione);
				}
				Casella casella = tabellone.getCasella(giocatore.getCasellaAttuale());
				casella.azione(giocatore);
				Utility.stampaDescrizione(casella);
				Utility.stampaSituazione(giocatore);
				
				if (giocatore.getPatrimonio() >= SOGLIA_VINCITA) {
					Utility.haiVinto(giocatori);
					finished = true;
					break;
				} else if (giocatore.getPatrimonio() <= 0) {
					Utility.haiPerso();
					classificaPerdenti.add(giocatore);
					giocatori.remove(giocatore);
					i--;
				}
				
				if (giocatori.isEmpty()) {
					Utility.nessunVincitore(classificaPerdenti);
					finished = true;
				}
			}
			
			
		}
			
		Utility.arrivederci();
	}
	
	public Tabellone getTabellone() {
		return tabellone;
	}
}
