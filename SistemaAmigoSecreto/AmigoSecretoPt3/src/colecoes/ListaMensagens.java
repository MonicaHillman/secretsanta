package colecoes;

import nucleo.Mensagem;
import java.util.Random;

public class ListaMensagens implements ListaDeMensagem {

	private int maxLength = 10;
	private Mensagem[] mensagens = new Mensagem[maxLength];
	private int proximaMensagem = 0;

	public void novaMensagem(Mensagem mensagem) {
		mensagens[proximaMensagem] = mensagem;
		proximaMensagem++;
	}

	public String[] getCaixaEntrada(String destinatario) {
		String[] mensagens2 = new String[maxLength];
		int j = 0;
		for (int i = (proximaMensagem - 1); i >= 0; i--) { // O laço reverso garante que eu pegue as mensagens mais
															// recentes primeiro
			if (mensagens[i].getDestinatario().equals(destinatario)) {
				mensagens2[j] = "Msg. Nº " + (j + 1) + " de " + mensagens[i].getRemetente() + ": "
						+ mensagens[i].getMensagem();
				j++;
				if (j == 10) {
					break;
				}
			}
		}
		return mensagens2;
	}

	public int getLength() {
		return mensagens.length;
	}

	public String randomString(int length) {
		String SALTCHARS = "ABCDEFGHIJLMNOPQRSTUVXZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < length) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

}
