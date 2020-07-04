package it.unibs.ing.arnaldo.esame;

public class Interessi extends Probabilita {

	private static final String INTERESSI = "Il tuo capitale in banca ha appena maturato gli interessi! (+130000 I€€€)";

	/**
	 * Setta il premio dovuto agli interessi bancari
	 */
	public Interessi() {
		super();
		setDescr(INTERESSI);
		setPremio(130000);
	}

}
