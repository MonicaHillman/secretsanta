package interacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import colecoes.ListaComArray;
import colecoes.ListaDeMensagem;
import colecoes.ListaDeParticipantes;
import colecoes.ListaMensagens;
import colecoes.ListaParticipantesEncadeada;
import excecoes.ExcecaoDeListaCheia;
import excecoes.ExcecaoDeParticipanteJaExistente;
import nucleo.Mensagem;
import nucleo.Participante;
import persistencia.Persistencia;

public class Interface {
	private ListaComArray<Participante> participantes;
	private ListaDeMensagem mensagens = new ListaMensagens();
	private Persistencia persiste = new Persistencia();
	private Persistencia persiste2 = new Persistencia();

	public Interface() {
		participantes = persiste.recuperaListaDeParticipantes();
		mensagens = persiste2.recuperaListaDeMensagens();
	}
	
	void menuPrincipal() {
		intro();
		Scanner entrada = new Scanner(System.in);
		String[] caixaEntrada;
		this.menu();
		String nome, codinome, apelidoDestinatario, textoMensagem;
		Participante participante;
		Mensagem mensagem1;
		int opcao = entrada.nextInt();
		while (opcao != 0) {
			switch (opcao) {
			case 1:
				try {
					entrada.nextLine();
					System.out.println("Nome: ");
					nome = entrada.nextLine();
					System.out.println("Codinome: ");
					codinome = entrada.nextLine();
					participante = new Participante(nome, codinome);
					this.participantes.adicionar(participante);
				} catch (ExcecaoDeParticipanteJaExistente e) {
					System.out.println("Participante já está na lista");
					;
				} catch (ExcecaoDeListaCheia e) {
					System.out.println("Sem espaço na lista");
					;
				}
				break;
			case 2:
				System.out.println();
				escreverDestaque("LISTA DE NOMES E CODINOMES DOS PARTICIPANTES");
				for (int i = 0; i < this.participantes.tamanho(); i++) {
					System.out.println("Nome: " + this.participantes.get(i).getNome());
					System.out.println("Codinome: " + this.participantes.get(i).getCodinome());
				}
				break;
			case 3:
				List<Integer> numbers = new ArrayList<Integer>();
				int partLength = this.participantes.tamanho();
				Random random = new Random();

				int j = 0;
				do {
					int next = random.nextInt(partLength);

					if (!numbers.contains(next) && next != j) {
						numbers.add(next);
						this.participantes.get(j).setIndexRecebedor(next);
						j++;
					}
				} while (numbers.size() < partLength);

				escreverDestaque("SORTEIO REALIZADO COM SUCESSO!");
				break;
			case 4:
				int idxRecebe = 0;
				for (int i = 0; i < this.participantes.tamanho(); i++) {
					idxRecebe = this.participantes.get(i).getIndexRecebedor();
					System.out.println("O amigo secreto de " + this.participantes.get(i).getNome() + " é "
							+ this.participantes.get(idxRecebe).getNome());
				}
				break;
			case 5:
				System.out.println();
				escreverDestaque("NOVA MENSAGEM");
				entrada.nextLine();
				boolean emissorCadastrado = false;
				boolean destinatarioCadastrado = false;

				System.out.println("Insira o seu codinome: ");
				String apelidoEmissor = entrada.nextLine();

				for (int i = 0; i < this.participantes.tamanho(); i++) {
					if (apelidoEmissor.equals(participantes.get(i).getCodinome())) {
						emissorCadastrado = true;

						System.out.println("Insira o nome do destinatário: ");
						apelidoDestinatario = entrada.nextLine();

						for (int a = 0; a < this.participantes.tamanho(); a++) {
							if (apelidoDestinatario.equals(participantes.get(a).getNome())) {
								destinatarioCadastrado = true;
								System.out.println("Por fim, a mensagem: ");
								textoMensagem = entrada.nextLine();
								mensagem1 = new Mensagem(apelidoEmissor, apelidoDestinatario, textoMensagem);
								mensagens.novaMensagem(mensagem1);
							}
						}
					}
				}
				if (emissorCadastrado == false || destinatarioCadastrado == false) {
					System.out.println("Participante não cadastrado.");
				}
				break;

			case 6:
				System.out.println();
				escreverDestaque("CAIXA DE ENTRADA");
				entrada.nextLine();

				System.out.println("Insira o seu nome para ver as mensagens recebidas");
				System.out.println("Seu codinome para ver as respostas recebidas");
				apelidoDestinatario = entrada.nextLine();

				caixaEntrada = mensagens.getCaixaEntrada(apelidoDestinatario);

				for (int i = 0; i < caixaEntrada.length; i++) {
					if (caixaEntrada[i] != null) {
						System.out.println(caixaEntrada[i]);
					} else {
						break;
					}
				}
				System.out.println("Digite 7 para responder uma mensagem.");
				break;

			case 7:
				System.out.println();
				escreverDestaque("RESPONDER MENSAGEM");
				entrada.nextLine();
				emissorCadastrado = false;
				destinatarioCadastrado = false;

				System.out.println("Insira o seu nome: ");
				apelidoEmissor = entrada.nextLine();

				for (int c = 0; c < this.participantes.tamanho(); c++) {
					if (apelidoEmissor.contentEquals(participantes.get(c).getNome())) {
						emissorCadastrado = true;

						System.out.println("Insira o codinome do destinatário: ");
						apelidoDestinatario = entrada.nextLine();

						for (int b = 0; b < this.participantes.tamanho(); b++) {
							if (apelidoDestinatario.equals(participantes.get(b).getCodinome())) {
								destinatarioCadastrado = true;
								System.out.println("Por fim, a mensagem: ");
								textoMensagem = entrada.nextLine();

								mensagem1 = new Mensagem(apelidoEmissor, apelidoDestinatario, textoMensagem);

								mensagens.novaMensagem(mensagem1);
							}
						}
					}
				}
				if (emissorCadastrado == false || destinatarioCadastrado == false) {
					System.out.println("Participante não cadastrado.");
				}
				break;

			}
			this.menu();
			opcao = entrada.nextInt();
		}
		entrada.close();
		persiste.armazenaListaDeParticipantes(participantes);
		persiste2.armazenaListaDeMensagens(mensagens);
	}

	private void menu() {
		System.out.println("0 - Sair");
		System.out.println("1 - Inserir participantes");
		System.out.println("2 - Verificar participantes inseridos");
		System.out.println("3 - Sortear");
		System.out.println("4 - Verificar resultado do sorteio");
		System.out.println("5 - Mandar mensagem");
		System.out.println("6 - Verificar mensagens");
		System.out.println("7 - Responder mensagens");
		System.out.print("Sua opção : ");
	}

	public static void escreverDestaque(String texto) {
		System.out.println("*** " + texto + " ***");
	}

	public static void intro() {
		escreverDestaque("AMIGO SECRETO");
		escreverDestaque("ADICIONE OS PARTICIPANTES, SORTEIE E MANDE MENSAGENS");
		escreverDestaque("UM TRABALHO DE: ADRIAN VISONA, EVILA VICENTE, MONICA HILLMAN");
	}
}
