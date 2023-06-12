package ulitlidades.email;

import java.util.Random;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.MultiPartEmail;

import projeto.modelos.Cliente;
import projeto.modelos.Reuniao;
import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class Mensageiro {

	public static void enviarMensagemDados(Cliente c) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		String remetente = "testeProjeto";
		String senha = "baelmnbfvbgwhkfc";
		Reuniao reuniao = null;
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(remetente, senha));
		email.setSSLOnConnect(true);
		try {
			email.setFrom(remetente);
			email.setSubject("Informacoes da reuniao: ");
			email.setMsg("Ola Sr(a) " + c.getNome() + ", nossa reuniao esta marcada para" + reuniao.getHora() + " na "
					+ "data " + reuniao.getData());
			email.addTo(c.getEmail());
			email.send();

		} catch (Exception e) {
			FabricaJOptionPane.criarMsgErro("Erro ao enviar os dados");
		}

	}

	public static int enviarCodigo(String emailCodigo) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		String remetente = "testeProjeto";
		String senha = "baelmnbfvbgwhkfc";
		int min = 1239;
		int max = 9999;

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(remetente, senha));
		email.setSSLOnConnect(true);
		try {
			email.setFrom(remetente);
			email.setSubject("Codigo para a mudanca de Senha.");
			int codigo = new Random().nextInt((max - min) + 1) + min;
			email.setMsg("Seu Codigo: " + codigo);
			email.addTo(emailCodigo);
			email.send();

			return codigo;

		} catch (Exception e) {
			FabricaJOptionPane.criarMsgErro("Erro ao enviar o codigo");
		}
		return 0;

	}

}