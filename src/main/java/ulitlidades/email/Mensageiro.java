package ulitlidades.email;

import java.util.Random;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.MultiPartEmail;

import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class Mensageiro {

	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central = persistencia.recuperarCentral("central");

	public static int enviarCodigo(String emailCodigo) {
		String remetente = "partyhelper0@gmail.com";
		String senha = "cchtkkrzptehwbph";
		int min = 1239;
		int max = 9999;
		int codigo = 0;
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(remetente, senha));
		email.setSSLOnConnect(true);
		try {
			email.setFrom(remetente);
			email.setSubject("O seu codigo para a mudanca de Senha.");
			codigo = new Random().nextInt((max - min) + 1) + min;
			email.setMsg("Seu Codigo: " + codigo);
			email.addTo(emailCodigo);
			email.send();

		} catch (Exception e) {
			FabricaJOptionPane.criarMsgErro("Erro ao enviar o codigo");
		}
		return codigo;
	}

}