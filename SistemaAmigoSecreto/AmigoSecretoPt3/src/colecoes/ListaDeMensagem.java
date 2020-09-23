package colecoes;

import java.io.Serializable;
import nucleo.Mensagem;

public interface ListaDeMensagem extends Serializable {

	public void novaMensagem(Mensagem mensagem);

	public String[] getCaixaEntrada(String destinatario);

	public int getLength();

	public String randomString(int length);

}
