package it.unibs.ing.arnaldo.esame;

public class Imprevisto extends Casella {

	
	private int penalita;
	private String descr;
	
	public Imprevisto() {
		super();
		penalita = 0;
	}
	
	public int getPenalita() {
		return penalita;
	}
	public void setPenalita(int penalita) {
		this.penalita = penalita;
	}
	
	@Override
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	@Override
	public void azione(Giocatore giocatore) {
		giocatore.setPatrimonio(giocatore.getPatrimonio() - getPenalita()); 
	}
}
