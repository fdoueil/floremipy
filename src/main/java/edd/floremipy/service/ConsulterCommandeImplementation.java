package edd.floremipy.service;

import java.util.ArrayList;

import edd.floremipy.dto.CommandListDTO;

public class ConsulterCommandeImplementation implements ConsulterCommandeInterface {

	private  ArrayList<CommandListDTO> listeInit = new  ArrayList<CommandListDTO>();

	public ConsulterCommandeImplementation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<CommandListDTO> initListeCommandeDuJour() {
		CommandListDTO commandListDTO = new CommandListDTO();
		this.listeInit.add(commandListDTO);
		return this.listeInit;
	}

}
