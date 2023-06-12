package projeto.modelos;

import java.time.LocalTime;

import projeto.modelos.enuns.StatusEvento;

public class Evento {
	private String nome;
	private LocalTime hora;
	private String data;
	private String local;
	private Cliente clienteAssociado;
	private boolean foiContratado;
	private StatusEvento status;

	
	public Evento(String nome, LocalTime hora, String data, String local, Cliente clienteAssociado) {
		this.nome = nome;
		this.hora = hora;
		this.data = data;
		this.local = local;
		this.clienteAssociado = clienteAssociado;
	
	}

	public boolean jaOcorreu() {
		LocalTime var = LocalTime.now();
		if (getHora().isBefore(var)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "nome" + "<" + clienteAssociado.getNome() + ">" + "convida você para o seu" + "<" + nome + ">" +  "<" + hora + ">" + "," + "<" + local + ">" + ".";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Cliente getClienteAssociado() {
		return clienteAssociado;
	}

	public void setClienteAssociado(Cliente clienteAssociado) {
		this.clienteAssociado = clienteAssociado;
	}

	public boolean isFoiContratado() {
		return foiContratado;
	}

	public void setFoiContratado(boolean foiContratado) {
		this.foiContratado = foiContratado;
	}

	public StatusEvento getStatus() {
		return status;
	}

	public void setStatus(StatusEvento status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
