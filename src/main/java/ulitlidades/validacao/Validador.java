package ulitlidades.validacao;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;

import projeto.exceptions.ServicoInvalidoException;
import projeto.exceptions.ValidacaoException;
import projeto.exceptions.ValidacaoExceptionEmail;
import projeto.exceptions.ValidarCheckBoxException;
import projeto.exceptions.ValidarCnpjException;
import projeto.exceptions.ValidarCpfException;
import projeto.exceptions.ValidarNomeException;
import projeto.exceptions.ValidarTelefoneException;
import projeto.telas.MenuAdm.TelaCadastrarFornecedor;

public abstract class Validador {

	public static boolean validarCadastro(String email, String senha, LocalDate data)
			throws ValidacaoException, ValidacaoExceptionEmail {
		boolean emailValido = validarEmail(email);
		boolean senhaValida = validarSenha(senha);
		boolean idadeValida = idadeValida(data);

		if (emailValido && senhaValida && idadeValida)
			return true;
		return false;
	}

	public static boolean validarCadastro(String nomeCompleto, String telefone, String email, JCheckBox cbfisica,
			JCheckBox cbJuridica) throws Exception {
		boolean nomeValido = validarNome(nomeCompleto);
		boolean telefoneValido = validarTelefone(telefone);
		boolean emailValido = validarEmail(email);
		boolean cbValido = validarCheckBox(cbJuridica, cbfisica);

		if (nomeValido && telefoneValido && emailValido && cbValido) {
			return true;
		}
		return false;
	}

	public static boolean idadeValida(LocalDate dataNascimento) throws ValidacaoException {
		LocalDate dataNasc = dataNascimento;
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNasc, dataAtual);
		if (periodo.getYears() >= 18)
			return true;
		throw new ValidacaoException("Data de nascimento invalida");
	}

	public static boolean validarCpf(String CPF) throws ValidarCpfException {
		if (CPF.length() != 11 || CPF.isBlank()) {
			throw new ValidarCpfException();
		}
		return true;
	}

	public static boolean validarCNPJ(String CNPJ) throws ValidarCnpjException {
		if (CNPJ.isBlank() || CNPJ.length() != 14) {
			throw new ValidarCnpjException();
		}
		return true;
	}

	public static boolean validarCheckBox(JCheckBox cbJuridica, JCheckBox cbFisica) throws ValidarCheckBoxException {
		boolean juridica = cbJuridica.isSelected();
		boolean fisica = cbFisica.isSelected();
		if (!juridica && !fisica) {
			throw new ValidarCheckBoxException();
		}
		return true;
	}

	public static boolean validarNome(String nome) throws ValidarNomeException {
		if (nome.isEmpty() || nome.length() < 10) {
			throw new ValidarNomeException();
		}
		return true;
	}

	public static boolean validarTelefone(String telefone) throws ValidarTelefoneException {
		if (telefone.isBlank()) {
			throw new ValidarTelefoneException();
		}
		return true;
	}

	public static boolean validarServico(ArrayList<String> array) throws ServicoInvalidoException {
		TelaCadastrarFornecedor tela = new TelaCadastrarFornecedor("");

		if (tela.getServicosDoFornecedor() == null && tela.getServicosDoFornecedor().size() < 1) {
			throw new ServicoInvalidoException();
		}
		return true;
	}

	public static boolean validarCampos(String campos) {
		if (campos.isBlank()) {
			return false;
		}
		return true;
	}

//	Lembrar de adicionar outros tipos de endereço para ele n só aceitar @gmail
	public static boolean validarEmail(String email) throws ValidacaoExceptionEmail {
		if (email.isEmpty())
			throw new ValidacaoExceptionEmail("E-mail nao pode ser vazio");

		String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		boolean valido = matcher.matches() && email.contains("gmail.com");

		if (!valido)
			throw new ValidacaoExceptionEmail("E-mail invalido");
		return true;
	}

	public static boolean validarSenha(String senha) throws ValidacaoException {
		String regex = ".*[@!#$%^&*()/\\\\]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(senha);
		boolean temCaracterEspecial = matcher.matches();

		if (senha.isEmpty() || senha.length() < 6)
			throw new ValidacaoException("Senha invalida");
		else if (!temCaracterEspecial)
			throw new ValidacaoException("A senha deve conter ao menos um caracter especial");
		return true;
	}
}
