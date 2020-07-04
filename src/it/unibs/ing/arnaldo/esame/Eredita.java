package it.unibs.ing.arnaldo.esame;

public class Eredita extends Probabilita {

	private static final String EREDITA = "Hai ereditato dei beni da un tuo lontano parente! (+50000 I€€€)";

	/**
	 * Setta il premio dovuto ad una eredità
	 */
	public Eredita() {
		super();
		setDescr(EREDITA);
		setPremio(50000);
	}

}
