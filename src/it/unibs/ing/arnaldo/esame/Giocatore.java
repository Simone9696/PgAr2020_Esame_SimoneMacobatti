package it.unibs.ing.arnaldo.esame;

import it.unibs.fp.mylib.NumeriCasuali;

public class Giocatore {

	private static final int PATRIMONIO_INIZIALE = 200000;
	
	private String nome;
	private int id;
	private static int contatore = 0;
	private int casellaAttuale = 0;
	private int patrimonio = PATRIMONIO_INIZIALE;
	
	public Giocatore(String nome) {
		super();
		this.nome = nome;
		id = contatore++;
	}
	
	public int lanciaDado(int numDadi) {
		int ris = 0;
		for (int i = 0; i < numDadi; i++)
			ris += NumeriCasuali.estraiIntero(1, 6);
		return ris;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCasellaAttuale() {
		return casellaAttuale;
	}

	public void setCasellaAttuale(int casellaAttuale) {
		this.casellaAttuale = casellaAttuale;
	}

	public int getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(int patrimonio) {
		this.patrimonio = patrimonio;
	}

	public int getId() {
		return id;
	}
	
	
	
}
