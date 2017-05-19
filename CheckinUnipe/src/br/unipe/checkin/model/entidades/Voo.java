package br.unipe.checkin.model.entidades;

public class Voo {
	
	private int idVoo;
	private Usuario usuario;
	private int fileira ;
	private String poltrona;
	
	public Voo(Usuario usuario, int fileira, String poltrona) {
		super();
		this.usuario = usuario;
		this.fileira = fileira;
		this.poltrona = poltrona;
	}
	
	public int getIdVoo() {
		return idVoo;
	}
	public void setIdVoo(int idVoo) {
		this.idVoo = idVoo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getFileira() {
		return fileira;
	}
	public void setFileira(int fileira) {
		this.fileira = fileira;
	}
	public String getPoltrona() {
		return poltrona;
	}
	public void setPoltrona(String poltrona) {
		this.poltrona = poltrona;
	}
	
	
	
}
