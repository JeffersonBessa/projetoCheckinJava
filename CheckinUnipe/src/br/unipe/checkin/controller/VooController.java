package br.unipe.checkin.controller;

import br.unipe.checkin.model.entidades.Voo;
import br.unipe.checkin.model.persistencia.VooDAO;

public class VooController {
	
	private Voo voo;
	private VooDAO vooDAO;
	
	public VooController(Voo voo){
		this.voo = voo;
		this.vooDAO = new VooDAO();
	}// VooController()
	
	public boolean cadastrarVoo(){
		
		return vooDAO.cadastrarVoo(voo);
		
	}// cadastrarVoo()
	
	public boolean verificaOverbooking(){

		return vooDAO.verificaOverbooking();

	}// verificaOverbooking()
	
	public boolean verificaAssento(){

		return vooDAO.verificaAssento(voo.getFileira(), voo.getPoltrona());

	}// cadastrarVoo()
}
