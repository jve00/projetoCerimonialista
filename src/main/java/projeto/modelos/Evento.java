package projeto.modelos;

import java.time.LocalDateTime;

import projeto.modelos.enuns.StatusEvento;

public class Evento {
	private String nome;
	private long id;
	private LocalDateTime dataHora;
	private String local;
	private Cliente clienteAssociado;
	private boolean foiContratado;
	private StatusEvento status;

	public Evento() {
		this.id = System.currentTimeMillis();
		this.foiContratado = false;
		this.status = StatusEvento.A_SER_REALIZADO;
	}

	public Evento(String nome, LocalDateTime dataHora, String local, Cliente clienteAssociado, boolean foiContratado) {
		this.nome = nome;
		this.dataHora = dataHora;
		this.local = local;
		this.clienteAssociado = clienteAssociado;
		this.foiContratado = foiContratado;
	}

	public boolean jaOcorreu() {
		LocalDateTime var = LocalDateTime.now();
		if (getDataHora().isBefore(var)) {
			return true;
		}
		return false;
	}
	public String toString() {
		return "nome" + "<" + clienteAssociado.getNome() + ">" + "convida você para o seu" + "<" + nome + ">" + ","
				+ status + "<" + dataHora + ">" + "," + "<" + local + ">" + ".";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
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

}
