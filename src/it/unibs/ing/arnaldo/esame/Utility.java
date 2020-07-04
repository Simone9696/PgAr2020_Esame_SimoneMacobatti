package it.unibs.ing.arnaldo.esame;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class Utility {

	public static void nuovaPartita() {
		
	}

	public static void haiVinto(ArrayList<Giocatore> giocatori) {
		System.out.println("Complimenti, hai vinto la partita!");
		System.out.println("Ecco la classifica:\n");
		
		for (Giocatore giocatore : giocatori) {
			System.out.println(giocatore.getNome() + " ha raggiunto " + giocatore.getPatrimonio() + " I€€€");
		}
		
	}

	public static void haiPerso() {
		System.out.println("Mi dispiace, hai perso la partita.");
		
	}

	public static void lanciaDado(int lancio) {
		System.out.println("Hai fatto " + lancio);
		
	}

	public static void stampaSituazione(Giocatore giocatore) {
		System.out.println("Situazione attuale:\n"
				+ "Nome: " + giocatore.getNome() + "\n"
				+ "Patrimonio: " + (giocatore.getPatrimonio() > 0 ? giocatore.getPatrimonio() : 0) + "\n"
				+ "Casella attuale: " + giocatore.getCasellaAttuale() + "\n");
		
	}

	public static boolean vuoiContinuare() {
		
		return InputDati.yesOrNo("Vuoi continuare con un nuovo lancio? ");
	}

	public static void benvenuto() {
		System.out.println("Benvenuto in Unipoly™ !");
		
	}

	public static void arrivederci() {
		System.out.println("Alla prossima!");
		
	}

	public static void stampaDescrizione(Casella casella) {
		System.out.println(casella.getDescr());
		
	}

	public static int scegliStazione(Stazione stazione) {
		
		Tabellone tabellone = Main.partita.getTabellone();
		ArrayList<Stazione> stazioni = new ArrayList<Stazione>();
		for (Casella staz : tabellone.getCaselle()) {
			if (staz instanceof Stazione && stazione.getId() != staz.getId()) stazioni.add((Stazione) staz);
		}
		System.out.println("Scegli una stazione di destinazione.");
		System.out.println("Stazioni disponibili: \n");
		for (Stazione staz : stazioni) {
			System.out.println(staz.toString());
		}
		int scelta;
		
		do {
			scelta = InputDati.leggiIntero("Digitare ID della stazione: ", 0, stazioni.size());
		} while (scelta == stazione.getId_stazione());
		
		if (scelta > stazione.getId_stazione())
			return stazioni.get(scelta - 1).getId();
		return stazioni.get(scelta).getId();
	}

	public static boolean altraPartita() {

		return InputDati.yesOrNo("Vuoi fare un'altra partita? ");
	}

	public static boolean vuoiViaggiare() {
		
		return InputDati.yesOrNo("Vuoi spostarti in un'altra stazione? ");
	}

	public static void turno(Giocatore giocatore) {
		System.out.println("E' il turno di " + giocatore.getNome() + "\n");
		
	}

	public static void nessunVincitore(ArrayList<Giocatore> classificaPerdenti) {
		System.out.println("Nessuno è riuscito a vincere.");
		System.out.println("Ecco la classifica secondo l'ordine di sconfitta:\n");
		
		for (Giocatore giocatore : classificaPerdenti) {
			System.out.println(giocatore.getNome());
		}
		
	}

	public static void puoiAcquistare(Proprieta proprieta) {
		System.out.println("Puoi comprare una casa o un albergo (se hai abbastanza soldi): ");
		System.out.println("Il costo di una casa e': " + proprieta.getValoreCasa());
		System.out.println("Il costo di un albergo e': " + proprieta.getValoreAlbergo());
		
	}

	public static boolean vuoiAcquistareCasa() {
		// TODO Auto-generated method stub
		return InputDati.yesOrNo("Vuoi comprare una casa? ");
	}

	public static boolean vuoiAcquistareAlbergo() {
		// TODO Auto-generated method stub
		return InputDati.yesOrNo("Vuoi comprare un albergo? ");
	}

	public static void povero() {
		System.out.println("Non hai abbastanza soldi per poter comprare.");
		
	}
}
