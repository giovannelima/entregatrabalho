package br.com.park.object;

public class funcionarios {
	private int codigo;
	private String nome;
	private String login;
	private String senha;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public funcionarios( String login, String senha) {
		// TODO Auto-generated constructor stub

		super();
		this.login = login;
		this.senha = senha;

	}

	@Override
	public String toString() {
		return "[" + login + "] (" + senha + ")";
	}

}
