package ultilidades.reporsitorio;

import java.util.ArrayList;

import projeto.exceptions.ClienteJaExisteException;
import projeto.exceptions.FornecedorExixtenteException;
import projeto.exceptions.PacoteJaExisteException;
import projeto.exceptions.ServicoJaCadastradoException;
import projeto.exceptions.UsuarioNaoExisteException;
import projeto.modelos.Administrador;
import projeto.modelos.Cliente;
import projeto.modelos.Evento;
import projeto.modelos.Fornecedor;
import projeto.modelos.Pacote;

public class CentralDeInformacoes {

	private ArrayList<Cliente> todosOsCliente = new ArrayList<Cliente>();
	private ArrayList<Fornecedor> todosOsFornecedores = new ArrayList<Fornecedor>();
	private ArrayList<Evento> todosOsEventos = new ArrayList<Evento>();
	private ArrayList<String> servicos = new ArrayList<String>();
	private ArrayList<Pacote> todosOsPacotes = new ArrayList<Pacote>();
	private Administrador administrador;

	public boolean adicionarEvento(Evento evento) {
		if (recuperarEventoPeloId(evento.getId()) == null) {
			todosOsEventos.add(evento);
			return true;
		}
		return false;
	}

	public boolean verificarSenha(String senha) {
		if (getAdministrador().getSenha().equals(senha)) {
			return true;
		}
		return false;
	}

	public boolean verificarEmailAdm(String email) throws UsuarioNaoExisteException {
		if (getAdministrador().getLogin().equals(email)) {
			return true;
		}
		return false;
	}

	public boolean adicionarServico(String servico) throws ServicoJaCadastradoException {
		if (servicos.contains(servico)) {
			throw new ServicoJaCadastradoException();
		} else {
			servicos.add(servico);
		}
		return true;
	}

	public boolean recuperarServicoNome(String NomeServico) {
		if (servicos.contains(NomeServico)) {
			return true;
		}
		return false;
	}

	public ArrayList<Evento> recuperarEventosCliente(String email) {
		ArrayList<Evento> eventoDoCliente = new ArrayList<Evento>();
		Cliente c = recuperarClientePorEmail(email);
		if (c != null) {
			for (Evento e : todosOsEventos) {
				if (e.getClienteAssociado().equals(c)) {
					eventoDoCliente.add(e);
					return eventoDoCliente;
				}
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

	public Fornecedor recuperarFornecedorPorEmail(String email) {
		for (Fornecedor f : todosOsFornecedores) {
			if (f.getEmail().equals(email)) {
				return f;
			}
		}
		return null;
	}

	public boolean adicionarFornecedor(Fornecedor fornecedor) throws FornecedorExixtenteException {
		for (Fornecedor f : todosOsFornecedores) {
			if (f.equals(recuperarFornecedorPorEmail(fornecedor.getEmail()))) {
				throw new FornecedorExixtenteException();
			}
		}
		todosOsFornecedores.add(fornecedor);
		return true;
	}

	public boolean adicionarCliente(Cliente cliente) throws ClienteJaExisteException {
		for (Cliente c : todosOsCliente) {
			if (c.equals(recuperarClientePorEmail(cliente.getEmail()))) {
				throw new ClienteJaExisteException();
			}
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

	public Pacote recuperarPacote(String nome) {
		for (Pacote p : todosOsPacotes) {
			if (p.getNome().equals(nome)) {
				return p;
			}
		}
		return null;
	}

	public boolean adicionarPacote(Pacote pacote) throws PacoteJaExisteException {
		for (Pacote p : todosOsPacotes) {
			if (p.equals(recuperarPacote(pacote.getNome()))) {
				throw new PacoteJaExisteException();
			}
		}
		todosOsPacotes.add(pacote);
		return true;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public ArrayList<Cliente> getTodosOsCliente() {
		return todosOsCliente;
	}

	public ArrayList<Evento> getTodosOsEventos() {
		return todosOsEventos;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public ArrayList<Fornecedor> getTodoOsFornecedores() {
		return todosOsFornecedores;
	}

	public ArrayList<String> getServicos() {
		return servicos;
	}

	public ArrayList<Pacote> getTodosOsPacotes() {
		return todosOsPacotes;
	}

}
