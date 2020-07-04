package it.unibs.ing.arnaldo.esame;

public class Probabilita extends Casella {

	
	private int premio;
	private String descr;
	
	public Probabilita() {
		super();
		premio = 0;
	}
	
	public int getPremio() {
		return premio;
	}
	public void setPremio(int premio) {
		this.premio = premio;
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
		giocatore.setPatrimonio(getPremio() + giocatore.getPatrimonio()); 
	}
}
