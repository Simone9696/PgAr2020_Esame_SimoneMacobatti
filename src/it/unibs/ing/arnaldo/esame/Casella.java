package it.unibs.ing.arnaldo.esame;

public class Casella implements Azione {

	private String nome;
	private int id;
	private static int contatore = 0;
	
	public Casella(String nome) {
		super();
		this.nome = nome;
		id = contatore++;
	}
	
	public Casella() {
		super();
		id = contatore++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void azione(Giocatore giocatore) {
		
	}

	public String getDescr() {
		
		return nome;
	}

	public int getId() {
		return id;
	}
	
	
}
