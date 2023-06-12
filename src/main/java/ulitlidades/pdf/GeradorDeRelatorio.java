package ulitlidades.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import projeto.modelos.Evento;
import ulitilidades.persistencia.Persistencia;
import ultilidades.reporsitorio.CentralDeInformacoes;

public class GeradorDeRelatorio {

	public static void obterProgramacaoDoMes(CentralDeInformacoes central) {
		Document doc = new Document(PageSize.A4, 72, 72, 72, 72);
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral("central");

		try {
			PdfPTable tabela = new PdfPTable(5);

			OutputStream os = new FileOutputStream("relatorio.pdf");
			PdfWriter.getInstance(doc, os);
			doc.open();



			Paragraph titulo = new Paragraph("Eventos contratados para o Mês.");
			titulo.setAlignment(Element.ALIGN_CENTER);
			Paragraph linhaEmBranco = new Paragraph(" ");
			ArrayList<Evento> eventos = centralDeInformacoes.getTodosOsEventos();
		
			Image imagem = Image.getInstance("img/logoPj.png");
			imagem.scaleAbsolute(100,100);
		
			
			tabela.addCell("Nome do Evento");
			tabela.addCell("Local do Evento");
			tabela.addCell("Data e hora do Evento");
			tabela.addCell("status do Evento");
			tabela.addCell("Nome do Cliente");
		
			for (Evento evento : eventos) {
				tabela.addCell(evento.getNome());
				tabela.addCell(evento.getLocal());
				tabela.addCell(String.valueOf(evento.getHora()));
				tabela.addCell(String.valueOf(evento.getStatus()));
				tabela.addCell(evento.getClienteAssociado().getNome());
			}
			
			doc.add(imagem);
			doc.add(titulo);
			doc.add(linhaEmBranco);
			doc.add(tabela);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
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

}
