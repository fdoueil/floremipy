package edd.floremipy.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import edd.floremipy.model.TypeModeLivraison;
import edd.floremipy.service.CreerCommandeImplementation;




@Controller
public class ChoixModeLivraison{
	private static final long serialVersionUID = 1L;

	private final static Logger logger =
			Logger.getLogger(ChoixModeLivraison.class.getName());

	private final String URL_NAME = "http://localhost:8080/choixModeLivraison";
	private final String URL_NAME_BASIC = "choixModeLivraison";

	private int idTypeModeLivraison;
	private int idCustomer;

	CreerCommandeImplementation creerCommandeImplementation = new CreerCommandeImplementation();

	public static final String CHAMP_IDUSERCONNECTED = "idUserConnected";
	public static final String CHAMP_IDTYPEMODELIVRAISON = "idTypeModeLivraison";

	@RequestMapping(value = "/choixModeLivraison", method = RequestMethod.GET)
	public String getChoixModeLivraison(Model model, Integer idCustomer) {
		/* Init du log */
		logger.info("getChoixModeLivraison");		

		if (idCustomer != null){
			this.idCustomer = idCustomer;
		}
		else {
			this.idCustomer = 0;
		}
		this.idTypeModeLivraison = 0;
		model.addAttribute(CHAMP_IDUSERCONNECTED,this.idCustomer);
		model.addAttribute(CHAMP_IDTYPEMODELIVRAISON,this.idTypeModeLivraison);

		return this.URL_NAME_BASIC;
	}

	@RequestMapping(value = "/choixModeLivraison/validate/{idTypeModeLivraison}", method = RequestMethod.GET)
	public RedirectView  validate(@PathVariable Integer idTypeModeLivraison, Model model) {
		/* Init du log */
		logger.info("validate");		

		if (idTypeModeLivraison != null){
			this.idTypeModeLivraison = idTypeModeLivraison;
			this.creerCommandeImplementation.selectModeLivraison(TypeModeLivraison.getTypeModeLivraison(this.idTypeModeLivraison));			
		}

		model.addAttribute(CHAMP_IDTYPEMODELIVRAISON,this.idTypeModeLivraison);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(this.URL_NAME);
		return redirectView;

	}

}
