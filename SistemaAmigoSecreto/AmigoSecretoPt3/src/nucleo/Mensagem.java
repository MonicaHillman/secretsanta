package nucleo;

import java.io.Serializable;

public class Mensagem implements Serializable {

	private String nome;
	private String codinome;
	private String textoMensagem;

	// Método construtor
	public Mensagem(String codinome, String nome, String textoMensagem) {
		this.codinome = codinome;
		this.nome = nome;
		this.textoMensagem = textoMensagem;
	}

	public String getRemetente() {
		return codinome;
	}

	public String getDestinatario() {
		return nome;
	}

	public String getMensagem() {
		return textoMensagem;
	}

	public void setDestinatario(String nome) {
		this.nome = nome;
	}

	public void setRemetente(String codinome) {
		this.codinome = codinome;
	}

	public void setMensagem(String textoMensagem) {
		this.textoMensagem = textoMensagem;
	}
}
