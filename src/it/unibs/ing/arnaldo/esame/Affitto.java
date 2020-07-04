package it.unibs.ing.arnaldo.esame;

public class Affitto extends Probabilita {

	private static final String AFFITTO = "Puoi riscuotere l'affitto delle tue case. (+100000 I€€€)";

	/**
	 * Setta il premio dovuto all'affitto
	 */
	public Affitto() {
		super();
		setDescr(AFFITTO);
		setPremio(100000);
	}

}
