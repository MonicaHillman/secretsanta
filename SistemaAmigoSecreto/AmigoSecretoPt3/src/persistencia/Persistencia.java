package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import colecoes.ListaParticipantesEncadeada;
import colecoes.ListaComArray;
import colecoes.ListaDeMensagem;
import colecoes.ListaDeParticipantes;
import colecoes.ListaMensagens;
import nucleo.Participante;



//TROCAR O ENDEREÇO PARA SALVAR E RECUPERAR, POIS USEI O ENDEREÇO MAIS CONVENIENTE PRA MIM

public class Persistencia {

	public void armazenaListaDeParticipantes(ListaComArray<Participante> lista) {
		try {
			ObjectOutputStream gravadorDeObjetos = new ObjectOutputStream(new FileOutputStream(
					"C:\\Users\\mhillman\\Downloads\\Sistema de Amigo Secreto - Adrian, Evila, Monica\\AmigoSecretoPt3\\arquivoDeParticipante.txt"));

			gravadorDeObjetos.writeObject(lista);

			gravadorDeObjetos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("erro de saída");
			e.printStackTrace();
		}
	}

	public void armazenaListaDeMensagens(ListaDeMensagem mensagens) {
		try {
			ObjectOutputStream gravadorDeObjetos = new ObjectOutputStream(new FileOutputStream(
					"C:\\Users\\mhillman\\Downloads\\Sistema de Amigo Secreto - Adrian, Evila, Monica\\AmigoSecretoPt3\\arquivoDeMensagem.txt"));

			gravadorDeObjetos.writeObject(mensagens);

			gravadorDeObjetos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("erro de saída");
			e.printStackTrace();
		}
	}

	public ListaComArray<Participante> recuperaListaDeParticipantes() {
		try {
			ObjectInputStream leitorDeObjetos = new ObjectInputStream(new FileInputStream(
					"C:\\Users\\mhillman\\Downloads\\Sistema de Amigo Secreto - Adrian, Evila, Monica\\AmigoSecretoPt3\\arquivoDeParticipante.txt"));
			ListaComArray<Participante> lista = (ListaComArray<Participante>) leitorDeObjetos.readObject();
			leitorDeObjetos.close();
			return lista;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ListaComArray<Participante>();
	}

	public ListaDeMensagem recuperaListaDeMensagens() {
		try {
			ObjectInputStream leitorDeObjetos = new ObjectInputStream(new FileInputStream(
					"C:\\Users\\mhillman\\Downloads\\Sistema de Amigo Secreto - Adrian, Evila, Monica\\AmigoSecretoPt3\\arquivoDeMensagem.txt"));

			ListaDeMensagem lista2 = (ListaDeMensagem) leitorDeObjetos.readObject();

			leitorDeObjetos.close();
			return lista2;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ListaMensagens();
	}

}
