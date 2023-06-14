package projeto.modelos;

import java.time.LocalTime;
import java.util.Date;

public class Reuniao {

	private Date data;
	private LocalTime hora;
	private String assunto;
	private String emailDoCliente;

	public Reuniao(Date data, LocalTime hora, String assunto, String emailDoCliente) {
		this.data = data;
		this.hora = hora;
		this.assunto = assunto;
		this.emailDoCliente = emailDoCliente;
	}

	public String getEmailDoCliente() {
		return emailDoCliente;
	}

	public void setEmailDoCliente(String emailDoCliente) {
		this.emailDoCliente = emailDoCliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
}
