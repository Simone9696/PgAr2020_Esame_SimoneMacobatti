package it.unibs.ing.arnaldo.esame;

import java.util.ArrayList;
import java.util.List;

public class Tabellone {

	private static final String ROMA = "Roma";

	private static final String START = "Start";

	private static final String MILANO = "Milano";

	private static final String BRESCIA = "Brescia";
	
	private List<Casella> caselle = new ArrayList<Casella>();
	
	public void inizializzaStandard() {
		
		caselle = new ArrayList<Casella>();
		
		caselle.add(new Casella(START));
		caselle.add(new Proprieta("Borgosatollo", 20000, 50000, 1, 2));
		caselle.add(new Stazione(ROMA));
		caselle.add(new Eredita());
		caselle.add(new Interessi());
		caselle.add(new Proprieta("Sirmione", 200000, 400000, 2, 4));
		caselle.add(new Mutuo());
		caselle.add(new Proprieta("Polaveno", 25000, 30000, 3, 2)); 
		caselle.add(new Proprieta("Bagolino", 40000, 90000, 1, 2));
		caselle.add(new Incidente());
		caselle.add(new Interessi());
		caselle.add(new Affitto());
		caselle.add(new Mutuo());
		caselle.add(new Proprieta("Orzinuovi", 60000, 40000, 1, 3));
		caselle.add(new Eredita());
		caselle.add(new Interessi());
		caselle.add(new Proprieta("Verolanuova", 1, 10, 1, 2)); 
		caselle.add(new Incidente());
		caselle.add(new Interessi());
		caselle.add(new Eredita());
		caselle.add(new Stazione(MILANO));
		caselle.add(new Mutuo());
		caselle.add(new Affitto());
		caselle.add(new Proprieta("Dello", 10000, 50000, 2, 5));
		caselle.add(new Proprieta("Pisogne", 100000, 300000, 4, 3));
		caselle.add(new Eredita());
		caselle.add(new Interessi());
		caselle.add(new Proprieta("Edolo", 100000, 150000, 4, 2));
		caselle.add(new Proprieta("Marmentino", 20000, 60000, 3, 2));
		caselle.add(new Eredita());
		caselle.add(new Interessi());
		caselle.add(new Mutuo());
		caselle.add(new Stazione(BRESCIA));
		caselle.add(new Proprieta("Rezzato", 45000, 100000, 3, 2));
		caselle.add(new Incidente());
		
	}
	
	public int getDimensione() {
		return caselle.size();
	}
	
	public Casella getCasella(int id) {
		return caselle.get(id);
	}

	public List<Casella> getCaselle() {
		return caselle;
	}
	
	/**
	 * Controlla se un certo giocatore possiede tutte le proprietà di un gruppo
	 * @param gruppo il gruppo di proprietà
	 * @param giocatore il giocatore
	 * @return true se il giocatore le possiede tutte, false altrimenti
	 */
	public boolean controllaGruppoCompleto(int gruppo, Giocatore giocatore) {
		boolean completo = true;
		for (Casella casella : caselle) {
			if (casella instanceof Proprieta) {
				if (((Proprieta) casella).getGruppo() == gruppo && !giocatore.equals(((Proprieta) casella).getProprietario())) {
					completo = false;
				} // se anche una sola non la possiede allora non le ha tutte
			}
		}
		return completo;
	}
	
}
