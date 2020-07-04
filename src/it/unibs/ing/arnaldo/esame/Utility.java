package it.unibs.ing.arnaldo.esame;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class Utility {

	private static final String POVERO = "\nNon hai abbastanza soldi per proseguire gli acquisti.";
	private static final String VUOI_COMPRARE_UN_ALBERGO = "\nVuoi comprare un albergo? ";
	private static final String VUOI_COMPRARE_UNA_CASA = "\nVuoi comprare una casa? ";
	private static final String IL_COSTO_DI_UN_ALBERGO_E = "Il costo di un albergo e': ";
	private static final String IL_COSTO_DI_UNA_CASA_E = "Il costo di una casa e': ";
	private static final String PUOI_COMPRARE = "Puoi comprare una casa o un albergo (se hai abbastanza soldi): ";
	private static final String CLASSIFICA_PERDENTI = "Ecco la classifica secondo l'ordine di sconfitta:\n";
	private static final String NESSUN_VINCITORE = "\nNessuno è riuscito a vincere.";
	private static final String VUOI_VIAGGIARE = "\nVuoi spostarti in un'altra stazione? ";
	private static final String ALTRA_PARTITA = "\nVuoi fare un'altra partita? ";
	private static final String DIGITARE_ID_DELLA_STAZIONE = "\nDigitare ID della stazione: ";
	private static final String STAZIONI_DISPONIBILI = "Stazioni disponibili: \n";
	private static final String SCEGLI_UNA_STAZIONE_DI_DESTINAZIONE = "\nScegli una stazione di destinazione.";
	private static final String ARRIVEDERCI = "\nAlla prossima!";
	private static final String BENVENUTO = "\nBenvenuto in Unipoly™ !";
	private static final String CONTINUARE = "\nVuoi continuare con un nuovo lancio? (N per uscire dal gioco) ";
	private static final String PERSO = "\nMi dispiace, hai perso la partita.";
	private static final String CLASSIFICA = "Ecco la classifica:\n";
	private static final String COMPLIMENTI = "Complimenti, hai vinto la partita!";

	public static void nuovaPartita() {
		
	}

	public static void haiVinto(ArrayList<Giocatore> giocatori) {
		System.out.println(COMPLIMENTI);
		System.out.println(CLASSIFICA);
		
		for (Giocatore giocatore : giocatori) {
			System.out.println(giocatore.getNome() + " ha raggiunto " + giocatore.getPatrimonio() + " I€€€");
		}
		
	}

	public static void haiPerso() {
		System.out.println(PERSO);
		
	}

	public static void lanciaDado(int lancio) {
		System.out.println("\nHai fatto " + lancio);
		
	}

	public static void stampaSituazione(Giocatore giocatore) {
		System.out.println("Situazione attuale:\n"
				+ "Nome: " + giocatore.getNome() + "\n"
				+ "Patrimonio: " + (giocatore.getPatrimonio() > 0 ? giocatore.getPatrimonio() : 0) + "\n"
				+ "Casella attuale: " + giocatore.getCasellaAttuale() + "\n");
		
	}

	public static boolean vuoiContinuare() {
		
		return InputDati.yesOrNo(CONTINUARE);
	}

	public static void benvenuto() {
		System.out.println(BENVENUTO);
		
	}

	public static void arrivederci() {
		System.out.println(ARRIVEDERCI);
		
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
		System.out.println(SCEGLI_UNA_STAZIONE_DI_DESTINAZIONE);
		System.out.println(STAZIONI_DISPONIBILI);
		for (Stazione staz : stazioni) {
			System.out.println(staz.toString());
		}
		int scelta;
		
		do {
			scelta = InputDati.leggiIntero(DIGITARE_ID_DELLA_STAZIONE, 0, stazioni.size());
		} while (scelta == stazione.getId_stazione());
		
		if (scelta > stazione.getId_stazione())
			return stazioni.get(scelta - 1).getId();
		return stazioni.get(scelta).getId();
	}

	public static boolean altraPartita() {

		return InputDati.yesOrNo(ALTRA_PARTITA);
	}

	public static boolean vuoiViaggiare() {
		
		return InputDati.yesOrNo(VUOI_VIAGGIARE);
	}

	public static void turno(Giocatore giocatore) {
		System.out.println("E' il turno di " + giocatore.getNome() + "\n");
		
	}

	public static void nessunVincitore(ArrayList<Giocatore> classificaPerdenti) {
		System.out.println(NESSUN_VINCITORE);
		System.out.println(CLASSIFICA_PERDENTI);
		
		for (Giocatore giocatore : classificaPerdenti) {
			System.out.println(giocatore.getNome());
		}
		
	}

	public static void puoiAcquistare(Proprieta proprieta, Giocatore giocatore) {
		System.out.println(PUOI_COMPRARE);
		stampaSituazione(giocatore);
		System.out.println(IL_COSTO_DI_UNA_CASA_E + proprieta.getValoreCasa());
		System.out.println(IL_COSTO_DI_UN_ALBERGO_E + proprieta.getValoreAlbergo());
		
	}

	public static boolean vuoiAcquistareCasa() {
		
		return InputDati.yesOrNo(VUOI_COMPRARE_UNA_CASA);
	}

	public static boolean vuoiAcquistareAlbergo() {
		
		return InputDati.yesOrNo(VUOI_COMPRARE_UN_ALBERGO);
	}

	public static void povero() {
		System.out.println(POVERO);
		
	}
}
