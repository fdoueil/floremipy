package edd.floremipy.service;

import java.util.ArrayList;
import java.util.Date;

import edd.floremipy.dto.CommandListDTO;

public class ConsulterCommandeImplementation implements ConsulterCommandeInterface {

	private  ArrayList<CommandListDTO> listeInit = new  ArrayList<CommandListDTO>();

	public ConsulterCommandeImplementation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<CommandListDTO> initListeCommandeDuJour() {
		CommandListDTO commandListDTO = new CommandListDTO();
		this.fillWithMockedValue(commandListDTO);
		this.listeInit.add(commandListDTO);
		return this.listeInit;
	}


	protected void fillWithMockedValue(CommandListDTO item){
		item.setId(-9999);
		item.setClientName("Mon cLient 1");
		item.setAdress("11 rue Berger Levrault - 31000 Toulouse");
		item.setCommandReference("9999 - 99 -9999");
		item.setTotalCommand(125.34d);
		item.setDeliveryDate(new Date());
	}

}
