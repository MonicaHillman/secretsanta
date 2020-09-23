package nucleo;

import java.io.Serializable;

public class Participante implements Serializable {

	private String nome;
	private String codinome;
	private int indexRecebedor;
	private Participante destinatario;
	private Participante remetente;

	// Método construtor
	public Participante(String nome, String codinome) {
		this.nome = nome;
		this.codinome = codinome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodinome() {
		return codinome;
	}

	public void setCodinome(String codinome) {
		this.codinome = codinome;
	}

	// Checa se foi inserido codinome
	public boolean hasCodinome() {
		return !codinome.equals("");
	}

	// Checa se o participante tem destinatário
	public boolean hasDestinatario() {
		return destinatario != null;
	}

	public String getDestinatarioNome() {
		return destinatario.getNome();
	}

	public void setDestinatario(Participante destinatario) {
		this.destinatario = destinatario;
	}

	// Reset
	public void resetDestinatario() {
		this.destinatario = null;
	}

	// Checa se o participante tem remetente
	public boolean hasRemetente() {
		return remetente != null;
	}

	public String getRemetenteNome() {
		return remetente.getNome();
	}

	public void setRemetente(Participante remetente) {
		this.remetente = remetente;
	}

	// Reset
	public void resetRemetente() {
		this.remetente = null;
	}

	public int getIndexRecebedor() {
		return this.indexRecebedor;
	}

	public void setIndexRecebedor(int indexRecebedor) {
		this.indexRecebedor = indexRecebedor;
	}

	@Override
	public boolean equals(Object arg) {
		// TODO Auto-generated method stub
		return nome.equals(arg.toString());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome;
	}

}