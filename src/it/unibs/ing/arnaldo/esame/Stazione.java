package it.unibs.ing.arnaldo.esame;

public class Stazione extends Casella {

	public Stazione(String nome) {
		super(nome);
		id_stazione = contatore++;
	}
	
	private int id_stazione;
	private static int contatore = 0;
	
	public int getId_stazione() {
		return id_stazione;
	}
	
	@Override
	public void azione(Giocatore giocatore) {
		if (Utility.vuoiViaggiare()) {
			int stazione = Utility.scegliStazione(this);
			giocatore.setCasellaAttuale(stazione);
		}
	}
	
	@Override
	public String toString() {
		return "Stazione " + super.getNome() + "[id_stazione=" + id_stazione + "]";
	}
	
	
}
