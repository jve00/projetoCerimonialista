package ulitilidades.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import ultilidades.reporsitorio.CentralDeInformacoes;

public class Persistencia {

	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));

	public Persistencia() {
		configIniciais();
	}

	public void configIniciais() {
		xstream.addPermission(AnyTypePermission.ANY);
	}

	public void salvarCentral(CentralDeInformacoes central, String nomeDoArquivo) {
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
		
		File arquivo = new File(nomeDoArquivo + ".xml");
		
		try {
			arquivo.createNewFile();

			PrintWriter escreva = new PrintWriter(arquivo);
			xml += xstream.toXML(central);
			escreva.print(xml);
			escreva.flush();
			escreva.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CentralDeInformacoes recuperarCentral(String nomeDoArquivo) {
		File arquivo = new File(nomeDoArquivo + ".xml");
		try {
			if (arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				return (CentralDeInformacoes) xstream.fromXML(fis);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CentralDeInformacoes();
	}
}
