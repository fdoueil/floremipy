package edd.floremipy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edd.floremipy.dto.CommandListDTO;
import edd.floremipy.service.ConsulterCommandeImplementation;




@Controller
public class ConsulterListeCommande{
	private static final long serialVersionUID = 1L;

	private final static Logger logger =
			Logger.getLogger(ConsulterListeCommande.class.getName());

	private final String URL_NAME = "http://localhost:8080/commandeList";
	private final String URL_NAME_BASIC = "commandeList";

	private int idCustomer;

	Map<String, String> errors = new HashMap<String, String>();
	ArrayList<CommandListDTO> commandeDTOList;
	ConsulterCommandeImplementation consulterCommandeImplementation = new ConsulterCommandeImplementation();

	public static final String CHAMP_IDUSERCONNECTED = "idUserConnected";
	public static final String CHAMP_COMMANDLISTDTO = "COMMANDLISTDTO";

	@Secured({"ROLE_ADMIN", "ROLE_JARDINIER"})
	@RequestMapping(value = "/commandeList", method = RequestMethod.GET)
	public String getCommandeList(Model model, Integer idCustomer) {
		/* Init du log */
		logger.info("getCommandeList");
		System.out.println("getCommandeList");

		/* Init donn�es et r�cup�ration des champs du formulaire. */
		if (this.commandeDTOList == null){
			this.commandeDTOList = new ArrayList<CommandListDTO>();
			this.commandeDTOList = this.consulterCommandeImplementation.initListeCommandeDuJour();
		}
		if (idCustomer != null){
			this.idCustomer = idCustomer;
		}
		else {
			this.idCustomer = 0;
		}

		model.addAttribute(CHAMP_IDUSERCONNECTED,this.idCustomer);
		model.addAttribute(CHAMP_COMMANDLISTDTO,this.commandeDTOList);

		return this.URL_NAME_BASIC;
	}

}
