package ulitlidades.validacao;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;

import projeto.exceptions.ValidacaoException;
import projeto.exceptions.ValidacaoExceptionEmail;
import ultilidades.fabricas.FabricaJOptionPane;
import ultilidades.fabricas.FabricaJPanel;

public abstract class Validador {

	public static boolean validarCadastro(String email, String senha, LocalDate data)
			throws ValidacaoException, ValidacaoExceptionEmail {
		boolean emailValido = validarEmail(email);
		boolean senhaValida = validarSenha(senha);
		boolean dataValida = idadeValida(data);

		if (emailValido && senhaValida && dataValida)
			return true;
		return false;
	}

//	public static boolean validarCadastro(String nomeCompleto, String email, String senha, LocalDate data,
//			JCheckBox cbFeminino, JCheckBox cbMasculino) throws ValidacaoException {
//		boolean nomeValido = validarNome(nomeCompleto);
//		boolean emailValido = validarEmail(email);
//		boolean senhaValida = validarSenha(senha);
//		boolean dataValida = idadeValida(data);
//
//		if (nomeValido && emailValido && senhaValida && dataValida)
//			return true;
//		return false;
//	}

//	public static boolean validarSexo(JCheckBox cbFeminino, JCheckBox cbMasculino) throws SexoInvalidoException {
//		boolean selecionouFeminino = cbFeminino.isSelected();
//		boolean selecionouMasculino = cbMasculino.isSelected();
//		if (selecionouFeminino && selecionouMasculino) {
//			throw new SexoInvalidoException();
//		}
//		if (!selecionouFeminino && !selecionouMasculino) {
//			throw new SexoInvalidoException("Selecione um tipo de sexo");
//		}
//		return true;
//	}

	public static boolean validarNome(String nome) throws ValidacaoExceptionEmail {
		if (nome.isEmpty()) {
			throw new ValidacaoExceptionEmail("");
		}
		return true;
	}

//	Lembrar de adicionar outros tipos de endereço para ele n só aceitar @gmail

	public static boolean validarEmail(String email) throws ValidacaoExceptionEmail {
		if (email.isEmpty()) {
			throw new ValidacaoExceptionEmail("O Email está vazio");
		}
		Pattern pattern = Pattern.compile("^[a-z0-9.@!#$%&'*+/=?^_`{|}~-]+$");
		Matcher matcher = pattern.matcher(email);

		if (!matcher.matches()) {
			throw new ValidacaoExceptionEmail("E-mail invalido");
		}
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

	public static boolean idadeValida(LocalDate dataNascimento) throws ValidacaoException {
		LocalDate dataNasc = dataNascimento;
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNasc, dataAtual);
		if (periodo.getYears() >= 18)
			return true;
		throw new ValidacaoException("Data de nascimento invalida");
	}

}
