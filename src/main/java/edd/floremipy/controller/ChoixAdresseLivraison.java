package edd.floremipy.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import edd.floremipy.dto.AdresseDTO;
import edd.floremipy.service.CreerAdresseImplementation;




@Controller
public class ChoixAdresseLivraison{
	private static final long serialVersionUID = 1L;

	private final static Logger logger =
			Logger.getLogger(ChoixAdresseLivraison.class.getName());

	private final String URL_NAME = "http://localhost:8080/choixAdresseLivraison";
	private final String URL_NAME_BASIC = "choixAdresseLivraison";

	private int idAdresseLivraison;
	private int idCustomer;
	private AdresseDTO adresseLivraison = new AdresseDTO();

	CreerAdresseImplementation creerAdresseImplementation = new CreerAdresseImplementation();

	public static final String CHAMP_IDUSERCONNECTED = "idUserConnected";
	public static final String CHAMP_IDADRESSELIVRAISON = "idAdresseLivraison";
	public static final String CHAMP_LOCATIONADRESSELIVRAISON = "locationAdresseLivraison";
	public static final String CHAMP_ZIPCODEADRESSELIVRAISON = "zipCodeAdresseLivraison";
	public static final String CHAMP_CITYADRESSELIVRAISON = "cityAdresseLivraison";

	@RequestMapping(value = "/choixAdresseLivraison", method = RequestMethod.GET)
	public String getChoixAdresseLivraison(Model model, Integer idCustomer) {
		/* Init du log */
		logger.info("getChoixAdresseLivraison");

		if (idCustomer != null){
			this.idCustomer = idCustomer;
		}
		else {
			this.idCustomer = 0;
		}

		this.adresseLivraison = this.creerAdresseImplementation.getAdresseByUser(this.idCustomer);
		this.idAdresseLivraison = this.adresseLivraison.getId();

		model.addAttribute(CHAMP_IDUSERCONNECTED,this.idCustomer);
		model.addAttribute(CHAMP_IDADRESSELIVRAISON, this.adresseLivraison.getId());
		model.addAttribute(CHAMP_LOCATIONADRESSELIVRAISON,this.adresseLivraison.getLocation());
		model.addAttribute(CHAMP_ZIPCODEADRESSELIVRAISON,this.adresseLivraison.getZipCode());
		model.addAttribute(CHAMP_CITYADRESSELIVRAISON,this.adresseLivraison.getCity());

		return this.URL_NAME_BASIC;
	}

	@RequestMapping(value = "/choixAdresseLivraison/validate/{idAdresseLivraison}/{locationAdresseLivraison}/{zipCodeAdresseLivraison}/{cityAdresseLivraison}", method = RequestMethod.GET)
	public RedirectView  validate(@PathVariable Integer idAdresseLivraison,@PathVariable String locationAdresseLivraison, @PathVariable String zipCodeAdresseLivraison, @PathVariable String cityAdresseLivraison, Model model) {
		/* Init du log */
		logger.info("validate");

		this.adresseLivraison.setLocation(locationAdresseLivraison);
		this.adresseLivraison.setZipCode(zipCodeAdresseLivraison);
		this.adresseLivraison.setCity(cityAdresseLivraison);

		if (idAdresseLivraison != null){
			this.idAdresseLivraison = idAdresseLivraison;
			this.creerAdresseImplementation.majAdresse(this.idAdresseLivraison,this.adresseLivraison.getLocation(),this.adresseLivraison.getZipCode(), this.adresseLivraison.getCity());
		} else
		{
			this.adresseLivraison = this.creerAdresseImplementation.creerAdresse(this.adresseLivraison.getLocation(),this.adresseLivraison.getZipCode(), this.adresseLivraison.getCity());
		}

		model.addAttribute(CHAMP_IDUSERCONNECTED,this.idCustomer);
		model.addAttribute(CHAMP_IDADRESSELIVRAISON,this.idAdresseLivraison);
		model.addAttribute(CHAMP_LOCATIONADRESSELIVRAISON,this.adresseLivraison.getLocation());
		model.addAttribute(CHAMP_ZIPCODEADRESSELIVRAISON,this.adresseLivraison.getZipCode());
		model.addAttribute(CHAMP_CITYADRESSELIVRAISON,this.adresseLivraison.getCity());

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(this.URL_NAME);
		return redirectView;

	}

}
