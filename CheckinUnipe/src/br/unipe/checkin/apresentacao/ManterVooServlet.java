package br.unipe.checkin.apresentacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipe.checkin.controller.VooController;
import br.unipe.checkin.model.entidades.Usuario;
import br.unipe.checkin.model.entidades.Voo;

@SuppressWarnings("serial")
@WebServlet("/ManterVooServlet")
public class ManterVooServlet extends HttpServlet{
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		VooController vooController = null;
		RequestDispatcher dispatcher = null;
		
        Integer fileira = Integer.valueOf(request.getParameter("fileira"));
        String poltrona = request.getParameter("poltrona");
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        
        Voo voo = new Voo(usuario, fileira.intValue(), poltrona);
        
        vooController = new VooController(voo);
        
        if(vooController.verificaOverbooking()){
        	request.setAttribute("msg", "Ocorreu Overbooking. O Vôo está lotado!");

        	dispatcher=request.getRequestDispatcher("principal.jsp");
        	dispatcher.forward(request,response);
        	
        	return;
        }
        
        if(vooController.verificaAssento()){
        	
        	vooController.cadastrarVoo();
        	
        	request.setAttribute("msg", "Assento " + voo.getFileira() + voo.getPoltrona() + " reservado com sucesso");
        	
        	dispatcher=request.getRequestDispatcher("principal.jsp");
        	dispatcher.forward(request,response);
        	
        } else {
        	request.setAttribute("msg", "Não foi possível reservar o assento " + voo.getFileira() + voo.getPoltrona() + ". Ele já está ocupado. Selecione outro, por favor");
        	
        	dispatcher=request.getRequestDispatcher("principal.jsp");
        	dispatcher.forward(request,response);
        }
		
    }// doGet()
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }// doPost()

}
