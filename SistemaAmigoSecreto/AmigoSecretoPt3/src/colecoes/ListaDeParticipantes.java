package colecoes;

import java.io.Serializable;

import nucleo.Participante;

public interface ListaDeParticipantes extends Serializable {

	public void adicionarUmParticipante(Participante participante);

	public void adicionarUmParticipanteNoInicio(Participante participante);

	public Participante getParticipante(int indice);

	public Participante getParticipante(String cpf);

	public int tamanho();

}
