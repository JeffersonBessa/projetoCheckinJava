package br.unipe.checkin.model.entidades;

public class Usuario {
	
	private int idUsuario;
	private String nome;
	private String username;
	private String password;
	
	public Usuario(){
		
	}
	
	public Usuario(String nome, String login, String senha){
		this.nome = nome;
		this.username = login;
		this.password = senha;
	}
	
	public Usuario(String username, String password){
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return idUsuario;
	}

	public void setId(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
