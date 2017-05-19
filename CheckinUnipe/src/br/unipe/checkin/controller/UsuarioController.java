package br.unipe.checkin.controller;

import br.unipe.checkin.model.entidades.Usuario;
import br.unipe.checkin.model.persistencia.UsuarioDAO;

public class UsuarioController {
	
	private Usuario usuario;
	private UsuarioDAO usuarioDAO;
	
	public UsuarioController(Usuario usuario){
		this.usuario = usuario;
		this.usuarioDAO = new UsuarioDAO();
	}// LoginController()
	
	public Usuario verificarLogin(){
		
		return usuarioDAO.verificarLogin(usuario);
		
	}// verificarLogin()
	
	public boolean cadastrarUsuario(){
		
		return usuarioDAO.cadastrarUsuario(usuario);
		
	}// verificarLogin()
}
