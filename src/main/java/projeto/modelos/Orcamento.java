package projeto.modelos;

import java.time.LocalTime;

public class Orcamento {

	private String EmailDoCliente;
	private String Evento;
	private String locacao;
	private String tamanho;
	private String data;
	private LocalTime hora;
	private String tipoDePagamento;
	private boolean orcamentoConcluido;
	private float precoTotal;
	


	public Orcamento(String EmailDoCliente, String evento, String locacao, String tamanho, String data,
			LocalTime hora, String tipoDePagamento) {
		this.EmailDoCliente = EmailDoCliente;
		Evento = evento;
		this.locacao = locacao;
		this.tamanho = tamanho;
		this.data = data;
		this.hora = hora;
		this.tipoDePagamento = tipoDePagamento;
	}

	public String getEmailDoCliente() {
		return EmailDoCliente;
	}

	public  void setEmailDoCliente(String nomeDoCliente) {
		this.EmailDoCliente = nomeDoCliente;
	}

	public String getEvento() {
		return Evento;
	}

	public void setEvento(String evento) {
		Evento = evento;
	}

	public String getLocacao() {
		return locacao;
	}

	public float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
	}

	public void setLocacao(String locacao) {
		this.locacao = locacao;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipoDePagamento() {
		return tipoDePagamento;
	}

	public void setTipoDePagamento(String tipoDePagamento) {
		this.tipoDePagamento = tipoDePagamento;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isOrcamentoConcluido() {
		return orcamentoConcluido;
	}

	public void setOrcamentoConcluido(boolean orcamentoConcluido) {
		this.orcamentoConcluido = orcamentoConcluido;
	}

}
