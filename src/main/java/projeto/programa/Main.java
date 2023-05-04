package projeto.programa;

import projeto.telas.usuario.TelaDeCadastroADM;
import projeto.telas.usuario.TelaLogin;
import ulitilidades.persistencia.Persistencia;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class Main {
	public static void main(String[] args) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
	
		if (!central.checarSeTemAdmnistrador()) {
			new TelaDeCadastroADM("Tela De Cadastro");
		} else {
			new TelaLogin("Tela Login");
		}
	}

}
