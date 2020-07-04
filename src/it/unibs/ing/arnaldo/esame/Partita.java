package it.unibs.ing.arnaldo.esame;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class Partita {

	private static final String INSERIRE_NOME_DEL_GIOCATORE = "Inserire nome del giocatore ";

	private static final String SCEGLIERE_IL_NUMERO_DI_GIOCATORI_MAX_4 = "Scegliere il numero di giocatori (MAX 4): ";

	private static final int SOGLIA_VINCITA = 1000000;

	private static final int NUMERO_DADI = 2;

	private Tabellone tabellone = new Tabellone();
	
	/**
	 * Gestisce una partita
	 */
	public void nuovaPartita() {
		
		Utility.benvenuto();
		
		tabellone.inizializzaStandard();
		
		ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();
		ArrayList<Giocatore> classificaPerdenti = new ArrayList<Giocatore>();
		
		int numGiocatori = InputDati.leggiIntero(SCEGLIERE_IL_NUMERO_DI_GIOCATORI_MAX_4, 1, 4);
		
		for (int i = 0; i < numGiocatori; i++) {
			giocatori.add(new Giocatore(InputDati.leggiStringa(INSERIRE_NOME_DEL_GIOCATORE + (i + 1) + ": ")));
		}
		
		int lancio = 0;
		int posizione = 0;
		int dimensione = tabellone.getDimensione();
		boolean finished = false;
		
		while (!finished) { 
				
			for (int i = 0; i < giocatori.size(); i++) { // ciclo di una mano
				
				Giocatore giocatore = giocatori.get(i);
				Utility.turno(giocatore);
				
				if (!Utility.vuoiContinuare()) { // chiede se si vuole continuare o interrompere il gioco 
					finished = true;
					break;
				}
				
				lancio = giocatore.lanciaDado(NUMERO_DADI); 
				Utility.lanciaDado(lancio);
				
				posizione = giocatore.getCasellaAttuale();
				int temp = posizione + lancio;
				
				if (temp < dimensione) { // se non è fuoriuscito dalle caselle
					giocatore.setCasellaAttuale(temp);
				} else { // altrimenti ricomincia dall'inizio
					giocatore.setCasellaAttuale(temp % dimensione);
				}
				
				Casella casella = tabellone.getCasella(giocatore.getCasellaAttuale()); // prende la casella su cui si trova il giocatore
				
				Utility.stampaDescrizione(casella);
				casella.azione(giocatore); // secondo le varie implementazioni si svolgono le diverse azioni
				
				Utility.stampaSituazione(giocatore);
				
				if (giocatore.getPatrimonio() >= SOGLIA_VINCITA) { // se uno vince la partita finisce
					Utility.haiVinto(giocatori); // stampa la classifica dei giocatori
					finished = true;
					break;
				} else if (giocatore.getPatrimonio() <= 0) { // se uno perde viene rimosso e la partita continua
					Utility.haiPerso();
					classificaPerdenti.add(giocatore); // si tiene traccia dei perdenti
					giocatori.remove(giocatore);
					i--;
				}
				
				if (giocatori.isEmpty()) { // se tutti hanno perso la partita finisce
					Utility.nessunVincitore(classificaPerdenti); // stampa la classifica in ordine di sconfitta
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
