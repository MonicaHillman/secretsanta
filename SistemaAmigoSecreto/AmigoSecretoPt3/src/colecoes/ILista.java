package colecoes;

import java.io.Serializable;

import excecoes.ExcecaoDeListaCheia;
import excecoes.ExcecaoDeParticipanteJaExistente;

public interface ILista<T> extends Serializable {

	public void adicionar(T obj) throws ExcecaoDeListaCheia, ExcecaoDeParticipanteJaExistente;

	public void adicionarNoInicio(T obj);

	public T remover(String obj);

	public T get(int indice);

	public T get(String obj);

	public int tamanho();

}
