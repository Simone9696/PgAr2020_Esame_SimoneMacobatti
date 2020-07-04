package it.unibs.ing.arnaldo.esame;

public class Main {

	static Partita partita = new Partita();
	
	public static void main(String[] args) {

		do {
			partita.nuovaPartita();
		} while (Utility.altraPartita());

	}

}
