package it.unibs.ing.arnaldo.esame;

public class Incidente extends Imprevisto {

	private static final String INCIDENTE = "Sei stato coinvolto in un incidente stradale. Devi pagare i danni. (-150000 I€€€)";

	/**
	 * Setta la penalità dovuta a un incidente
	 */
	public Incidente() {
		super();
		setDescr(INCIDENTE);
		setPenalita(150000);
	}

	
}
