package colecoes;

import excecoes.ExcecaoDeListaCheia;
import excecoes.ExcecaoDeParticipanteJaExistente;
import nucleo.Mensagem;

public class ListaComArray<T> implements ILista<T> {

	private T[] elementosDaLista = (T[]) new Object[300];
	private int tamanho = 0;
	private int capacidade = 300;

	public ListaComArray() {

	}

	public ListaComArray(int capacidade) {
		this.elementosDaLista = (T[]) new Object[capacidade];
		this.capacidade = capacidade;
	}

	@Override
	public void adicionar(T obj) throws ExcecaoDeListaCheia, ExcecaoDeParticipanteJaExistente {
		// TODO Auto-generated method stub
		if (tamanho < capacidade) {
			for (int i = 0; i < tamanho; i++) {
				if (obj.toString().equals(elementosDaLista[i].toString())) {
					throw new ExcecaoDeParticipanteJaExistente();
				}
			}
			elementosDaLista[tamanho] = obj;
			tamanho++;
		} else {
			throw new ExcecaoDeListaCheia();
		}
	}

	@Override
	public void adicionarNoInicio(T obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public T remover(String obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(int indice) {
		// TODO Auto-generated method stub
		if (indice >= 0 && indice < tamanho) {
			return elementosDaLista[indice];
		}
		return null;
	}

	@Override
	public T get(String obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int tamanho() {
		// TODO Auto-generated method stub
		return tamanho;
	}

}
