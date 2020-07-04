package it.unibs.ing.arnaldo.esame;

public class Mutuo extends Imprevisto {

	private static final String RATA = "E' arrivata la rata del mutuo da pagare... (-50000 I€€€)";

	/**
	 * Setta una penalità dovuta al pagamento del mutuo
	 */
	public Mutuo() {
		super();
		setDescr(RATA);
		setPenalita(50000);
	}

	
}
