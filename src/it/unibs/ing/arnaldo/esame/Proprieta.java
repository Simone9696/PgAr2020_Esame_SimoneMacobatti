package it.unibs.ing.arnaldo.esame;

public class Proprieta extends Casella {

	private static final double RENDITA = 0.05;
	private static final double TASSA = 0.1;
	Giocatore proprietario = null;
	int valoreCasa;
	int valoreAlbergo;
	boolean casa= false;
	boolean albergo = false;
	int gruppo;
	int moltiplicatore;
	
	public Proprieta() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Proprieta(String nome, int valoreCasa, int valoreAlbergo, int gruppo, int moltiplicatore) {
		super(nome);
		this.valoreCasa = valoreCasa;
		this.valoreAlbergo = valoreAlbergo;
		this.gruppo = gruppo;
		this.moltiplicatore = moltiplicatore;
	}



	public int getValoreCasa() {
		return valoreCasa;
	}



	public void setValoreCasa(int valoreCasa) {
		this.valoreCasa = valoreCasa;
	}



	public int getValoreAlbergo() {
		return valoreAlbergo;
	}



	public void setValoreAlbergo(int valoreAlbergo) {
		this.valoreAlbergo = valoreAlbergo;
	}



	public int getGruppo() {
		return gruppo;
	}



	public void setGruppo(int gruppo) {
		this.gruppo = gruppo;
	}



	public int getMoltiplicatore() {
		return moltiplicatore;
	}



	public void setMoltiplicatore(int moltiplicatore) {
		this.moltiplicatore = moltiplicatore;
	}



	public Giocatore getProprietario() {
		return proprietario;
	}



	public void setProprietario(Giocatore proprietario) {
		this.proprietario = proprietario;
	}



	@Override
	public void azione(Giocatore giocatore) {
		if (proprietario == null) { // se nessuno ha ancora comprato
			Utility.puoiAcquistare(this);
			if (valoreCasa < giocatore.getPatrimonio()) {
				if (Utility.vuoiAcquistareCasa()) {
					giocatore.setPatrimonio(giocatore.getPatrimonio() - valoreCasa);
					proprietario = giocatore;
					casa = true;
				}
			} 
			if (valoreAlbergo < giocatore.getPatrimonio()) {
				if (Utility.vuoiAcquistareAlbergo()) {
					giocatore.setPatrimonio(giocatore.getPatrimonio() - valoreAlbergo);
					proprietario = giocatore;
					albergo = true;
				}
			} else {
				Utility.povero();
			}
		} else if (proprietario.equals(giocatore)) { // se è del giocatore
			if (Main.partita.getTabellone().controllaGruppoCompleto(gruppo, giocatore)) // e se possiede tutto il gruppo
				giocatore.setPatrimonio(giocatore.getPatrimonio() + rendita() * moltiplicatore);
			else 
				giocatore.setPatrimonio(giocatore.getPatrimonio() + rendita());
		} else if (proprietario != null){ // se è di un altro giocatore
			if (Main.partita.getTabellone().controllaGruppoCompleto(gruppo, proprietario)) {
				giocatore.setPatrimonio(giocatore.getPatrimonio() - tassa() * moltiplicatore);
				proprietario.setPatrimonio(proprietario.getPatrimonio() + tassa() * moltiplicatore);
			} else {
				giocatore.setPatrimonio(giocatore.getPatrimonio() - tassa());
				proprietario.setPatrimonio(proprietario.getPatrimonio() + tassa());
			}
		}
	}



	private int tassa() {
		
		if (casa) return (int) (valoreCasa * TASSA);
		return (int) (valoreAlbergo * TASSA);
	}



	private int rendita() {
		// TODO Auto-generated method stub
		if (casa) return (int) (valoreCasa * RENDITA);
		return (int) (valoreAlbergo * RENDITA);
	}
}
