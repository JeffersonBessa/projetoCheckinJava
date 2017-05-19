package br.unipe.checkin.apresentacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unipe.checkin.controller.UsuarioController;
import br.unipe.checkin.model.entidades.Usuario;

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		RequestDispatcher dispatcher = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Usuario usuario = new Usuario(username, password);
        UsuarioController controller = new UsuarioController(usuario);
        
        Usuario usuarioLogado = controller.verificarLogin();
        
        if(usuarioLogado != null){
        	
        	HttpSession sessao = request.getSession();
        	sessao.setAttribute("usuarioLogado", usuarioLogado);
        	dispatcher=request.getRequestDispatcher("principal.jsp");
        	dispatcher.forward(request,response);
        	
        }else {
        	
        	request.setAttribute("msg", "Username e/ou password inválidos");
        	dispatcher = request.getRequestDispatcher("login.jsp");
        	dispatcher.forward(request,response);
        	
        }// if-else
    }// doGet()

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }// doPost()

}
