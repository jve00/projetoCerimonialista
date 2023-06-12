package projeto.modelos;

import java.time.LocalTime;
import java.util.Date;

public class Reuniao {

	private Date data;
	private LocalTime hora;
	private String assunto;

	public Reuniao(Date data, LocalTime hora, String assunto) {
		this.data = data;
		this.hora = hora;
		this.assunto = assunto;
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
