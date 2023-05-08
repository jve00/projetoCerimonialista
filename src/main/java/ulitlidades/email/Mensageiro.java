package ulitlidades.email;

import java.util.Random;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.MultiPartEmail;

import ulitilidades.persistencia.Persistencia;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class Mensageiro {

	public static int enviarCodigo(String emailCodigo) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		String remetente = "projetop2.2023@gmail.com";
		String senha = "jhpfqczusnvpjxdp";
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
			System.out.println(codigo);
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