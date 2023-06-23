package model;

public class UsuarioBean {
	private String idUser;
	private String nome;
	private String endereco;
	private String telefone;
	private String senha;
	
	public UsuarioBean() {
		super();
	}

	public UsuarioBean(String idUser, String nome, String endereco, String telefone, String senha) {
		this.idUser = idUser;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.senha = senha;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioBean [idUser=" + idUser + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", senha=" + senha + "]";
	}
}
