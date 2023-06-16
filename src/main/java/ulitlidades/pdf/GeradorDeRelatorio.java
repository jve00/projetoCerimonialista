package ulitlidades.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import projeto.modelos.Orcamento;
import projeto.telas.Orcamentos.TelaListarOrcamentos;
import ulitilidades.persistencia.Persistencia;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class GeradorDeRelatorio {

	private static PdfPTable tabela;
	public static void obterProgramacaoDoMes(CentralDeInformacoes central) {
		Document doc = new Document(PageSize.A4, 72, 72, 100, 90);
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral("central");
		try {
		  tabela = new PdfPTable(5);

			OutputStream os = new FileOutputStream("relatorio.pdf");
			PdfWriter.getInstance(doc, os);
			doc.open();

			Paragraph titulo = new Paragraph("Relatorio do Evento.");
			titulo.setAlignment(Element.ALIGN_CENTER);
			Paragraph linhaEmBranco = new Paragraph(" ");
			String emailSelecionado = (String) TelaListarOrcamentos.getTabelaDeOrcamentos()
					.getValueAt(TelaListarOrcamentos.getLinhaselecionada(), 0);
			Orcamento orcamentoDoCliente = central.recuperarOrcamento(emailSelecionado);

			tabela.addCell("Nome Cliente");
			tabela.addCell("Nome e tamanho do Evento");
			tabela.addCell("Data e hora do Evento");
			tabela.addCell("Pacote/Individual");
			tabela.addCell("Orcamento");

			tabela.addCell(orcamentoDoCliente.getEmailDoCliente());
			tabela.addCell(
					"O evento: " + orcamentoDoCliente.getEvento() + "suporta " + orcamentoDoCliente.getTamanho());
			tabela.addCell(" Comeca as :" + orcamentoDoCliente.getHora() + " Na data do evento: "
					+ orcamentoDoCliente.getData());
			tabela.addCell(String.valueOf(orcamentoDoCliente.getFornecedoresDoOrcamento()));
			tabela.addCell(String.valueOf(orcamentoDoCliente.getPrecoTotal()));

			doc.add(titulo);
			doc.add(linhaEmBranco);
			doc.add(tabela);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		doc.close();

	}

	public static void main(String[] args) {

		CentralDeInformacoes central = new CentralDeInformacoes();

		obterProgramacaoDoMes(central);

	}

	public static PdfPTable getTabela() {
		return tabela;
	}

}
