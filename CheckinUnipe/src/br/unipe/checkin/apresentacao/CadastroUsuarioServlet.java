package br.unipe.checkin.apresentacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.checkin.controller.UsuarioController;
import br.unipe.checkin.model.entidades.Usuario;

@SuppressWarnings("serial")
@WebServlet("/CadastroUsuarioServlet")
public class CadastroUsuarioServlet extends HttpServlet{
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		RequestDispatcher dispatcher = null;
		
		String nome =  request.getParameter("nome");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Usuario usuario = new Usuario(nome, username, password);
        UsuarioController controller = new UsuarioController(usuario);
        
        if(controller.cadastrarUsuario()){
     
        	request.setAttribute("msg", "Usuário cadastrado com sucesso");
        	
        }else {
        	
        	request.setAttribute("msg", "Não foi possível cadastrar o usuário");
        	
        }// if-else
        dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request,response);
    }// doGet()

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }// doPost()

}
