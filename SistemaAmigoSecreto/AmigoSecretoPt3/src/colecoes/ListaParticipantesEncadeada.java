package colecoes;

import java.io.Serializable;

import nucleo.Participante;

public class ListaParticipantesEncadeada implements ListaDeParticipantes {

	private NodoParticipante inicio = null;
	private NodoParticipante fim = null;
	private int quantidadeDeParticipantes = 0;

	public void adicionarUmParticipante(Participante participante) {
		NodoParticipante aux = new NodoParticipante();
		aux.setInfo(participante);
		if (this.quantidadeDeParticipantes == 0) {
			this.inicio = aux;
			this.fim = aux;
		} else {
			this.fim.setProx(aux);
			this.fim = aux;
		}
		this.quantidadeDeParticipantes++;
	}

	public void adicionarUmParticipanteNoInicio(Participante participante) {
		NodoParticipante aux = new NodoParticipante();
		aux.setInfo(participante);
		if (this.quantidadeDeParticipantes == 0) {
			this.inicio = aux;
			this.fim = aux;
		} else {
			aux.setProx(this.inicio);
			this.inicio = aux;
		}
		this.quantidadeDeParticipantes++;
	}

	public Participante getParticipante(int indice) {
		if (indice >= 0 && indice < this.quantidadeDeParticipantes) {
			NodoParticipante aux = this.inicio;
			for (int i = 0; i < indice; i++) {
				aux = aux.getProx();
			}
			return aux.getInfo();
		}
		return null;
	}

	public Participante getParticipante(String nome) {
		if (this.quantidadeDeParticipantes > 0) {
			Participante participanteAux;
			NodoParticipante temp = this.inicio;
			while (temp != null) {
				participanteAux = temp.getInfo();
				if (nome.equals(participanteAux.getNome())) {
					return participanteAux;
				}
				temp = temp.getProx();
			}
		}
		return null;
	}

	public int tamanho() {
		return this.quantidadeDeParticipantes;
	}

	private class NodoParticipante implements Serializable {

		private Participante info;
		private NodoParticipante prox;

		public Participante getInfo() {
			return this.info;
		}

		public void setInfo(Participante info) {
			this.info = info;
		}

		public NodoParticipante getProx() {
			return this.prox;
		}

		public void setProx(NodoParticipante prox) {
			this.prox = prox;
		}
	}

}
