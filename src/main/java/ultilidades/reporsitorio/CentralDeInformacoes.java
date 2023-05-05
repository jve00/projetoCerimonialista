package ultilidades.reporsitorio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import projeto.exceptions.DataInvalidaException;
import projeto.modelos.Administrador;
import projeto.modelos.Cliente;
import projeto.modelos.Evento;
import projeto.telas.ADM.TelaCadastroUsuario;
import projeto.telas.ADM.ouvintes.OuvinteBotaoCadastrarTelaADM;
import ulitlidades.data.ServicoData;
import ultilidades.fabricas.FabricaJOptionPane;

public class CentralDeInformacoes {

	private ArrayList<Cliente> todosOsCliente = new ArrayList<Cliente>();
	private ArrayList<Evento> todosOsEventos = new ArrayList<Evento>();
	private Administrador Administrador;

	public CentralDeInformacoes() {

	}

	public boolean adicionarEvento(Evento evento) {
		for (Evento e : todosOsEventos) {
			if (e.equals(evento)) {
				return false;
			}
		}
		todosOsEventos.add(evento);
		return true;
	}

//	public boolean checarSeTemAdmnistrador() {
//	
//	}

	public LocalDateTime retornardataEHora(String data, String hora) {
		LocalDate date = LocalDate.parse(data);
		LocalTime time = LocalTime.parse(hora);

		return LocalDateTime.of(date, time);
	}

	public ArrayList<Evento> recuperarEventosCliente(String email) {
		ArrayList<Evento> eventoDoCliente = new ArrayList<Evento>();
		for (Cliente c : todosOsCliente) {
			if (c.getEmail().equals(email)) {
				for (Evento e : todosOsEventos) {
					if (e.getClienteAssociado().equals(c)) {
						eventoDoCliente.add(e);
					}
				}
				return eventoDoCliente;
			}
		}
		return null;
	}

	public Evento recuperarEventoPeloId(long id) {
		for (Evento e : todosOsEventos) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

	public boolean adicionarCliente(Cliente cliente) {
		for (Cliente c : todosOsCliente) {
			if (c.equals(cliente))
				return false;
		}
		todosOsCliente.add(cliente);
		return true;
	}

	public Cliente recuperarClientePorEmail(String email) {
		for (Cliente c : todosOsCliente) {
			if (c.getEmail().equals(email)) {
				return c;
			}
		}
		return null;
	}

	public ArrayList<Cliente> getTodosOsCliente() {
		return todosOsCliente;
	}

	public void setTodosOsCliente(ArrayList<Cliente> todosOsCliente) {
		this.todosOsCliente = todosOsCliente;
	}

	public ArrayList<Evento> getTodosOsEventos() {
		return todosOsEventos;
	}

	public void setTodosOsEventos(ArrayList<Evento> todosOsEventos) {
		this.todosOsEventos = todosOsEventos;
	}

	public Administrador getAdministrador() {
		return Administrador;
	}

	public void setAdministrador(Administrador administrador) {
		Administrador = administrador;
	}

}
