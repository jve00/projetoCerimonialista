package projeto.programa;

import projeto.telas.ADM.TelaDeCadastroADM;
import projeto.telas.ADM.TelaLogin;
import ulitilidades.persistencia.Persistencia;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class Main {
	public static void main(String[] args) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		if (central.getAdministrador() == null) {
			new TelaDeCadastroADM("Tela De Cadastro");
		} else {
			new TelaLogin("Tela Login");
		}
	}

}
