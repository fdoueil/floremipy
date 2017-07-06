package edd.floremipy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import edd.floremipy.dto.ArticlePrixListDTO;
import edd.floremipy.dto.UserRoleDTO;
import edd.floremipy.service.ArticlePrixListDTOServiceImplementation;
import edd.floremipy.service.CreerCommandeImplementation;

@Controller
@SessionAttributes( value="userConnecte", types={UserRoleDTO.class} )
public class ArticleList{

	private static final Logger logger =
			Logger.getLogger(ArticleList.class.getName());

	private static final String URL_NAME = "http://localhost:8080/articleList";
	private static final String URL_NAME_BASIC = "articleList";

	

	Map<String, String> errors = new HashMap<>();
	ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut;
	ArrayList<ArticlePrixListDTO> articlePrixDTOListeBas;
	
	@Autowired
	ArticlePrixListDTOServiceImplementation articlePrixListDTOService;
	
	@Autowired
	CreerCommandeImplementation creerCommandeImplementation;

	public static final String CHAMP_IDUSERCONNECTED = "idUserConnected";
	public static final String LISTE_ARTICLE_HAUT = "articlePrixDTOListeHaut";
	public static final String LISTE_ARTICLE_BAS = "articlePrixDTOListeBas";

	@Secured({"ROLE_ADMIN", "ROLE_CLIENT"})
	@RequestMapping(value = "/articleList", method = RequestMethod.GET)
	public String getArticleList(Model model, Integer idCustomer) {
		/* Init du log */
		logger.info("getArticleList");

		/* Init donn�es et r�cup�ration des champs du formulaire. */
		if (this.articlePrixDTOListeHaut == null){
			this.articlePrixDTOListeHaut = new ArrayList<>();
			this.articlePrixDTOListeHaut = this.articlePrixListDTOService.initListeArticleHaut();
		}
		if (this.articlePrixDTOListeBas == null){
			this.articlePrixDTOListeBas = new ArrayList<>();
			this.articlePrixDTOListeBas = this.articlePrixListDTOService.initListeArticleBas();
		}

		Integer idCustomerNonNull = idCustomer;
		if (idCustomerNonNull == null){			
			idCustomerNonNull = 0;
		}

		model.addAttribute(CHAMP_IDUSERCONNECTED,idCustomerNonNull);
		model.addAttribute(LISTE_ARTICLE_HAUT,this.articlePrixDTOListeHaut);
		model.addAttribute(LISTE_ARTICLE_BAS,this.articlePrixDTOListeBas);


		return ArticleList.URL_NAME_BASIC;
	}

	@RequestMapping(value = "/articleList/add/{idArticlePrixToAdd}", method = RequestMethod.GET)
	public RedirectView  add(@PathVariable Integer idArticlePrixToAdd, Model model) {
		/* Init du log */
		logger.info("add");

		if (idArticlePrixToAdd != null){
			this.articlePrixListDTOService.deplaceDuHautVersLeBas(this.articlePrixDTOListeHaut, this.articlePrixDTOListeBas, idArticlePrixToAdd);		
			if (logger.isLoggable(Level.INFO)) {
				logger.info("post idArticle � ajouter en bas par addition : "+  idArticlePrixToAdd);
			}
		}

		model.addAttribute(LISTE_ARTICLE_HAUT,this.articlePrixDTOListeHaut);
		model.addAttribute(LISTE_ARTICLE_BAS,this.articlePrixDTOListeBas);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(ArticleList.URL_NAME);
		return redirectView;

	}

	@RequestMapping(value = "/articleList/del/{idArticlePrixToDel}", method = RequestMethod.GET)
	public RedirectView  del(Model model,  @PathVariable Integer idArticlePrixToDel) {
		/* Init du log */
		logger.info("del");

		if (idArticlePrixToDel != null){
			this.articlePrixListDTOService.deplaceDuBasVersLeHaut(this.articlePrixDTOListeHaut, this.articlePrixDTOListeBas, idArticlePrixToDel);
			if (logger.isLoggable(Level.INFO)) {
				logger.info("post idArticle � ajouter en haut par suppression :" + idArticlePrixToDel);
			}
		}

		model.addAttribute(LISTE_ARTICLE_HAUT,this.articlePrixDTOListeHaut);
		model.addAttribute(LISTE_ARTICLE_BAS,this.articlePrixDTOListeBas);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(ArticleList.URL_NAME);
		return redirectView;
	}

	@RequestMapping(value = "/articleList/addCommande", method = RequestMethod.GET)
	public RedirectView  addCommande(@ModelAttribute("userConnecte") UserRoleDTO userLogge, Model model) {

	
		/* Init du log */
		logger.info("addCommande");

		if (this.articlePrixDTOListeBas != null){
			long idCustomerLogge=userLogge.getId();
			String msg = "customer courant = " + idCustomerLogge;
			logger.info(msg);
			this.creerCommandeImplementation.creeCommande(idCustomerLogge , this.articlePrixDTOListeBas);
			logger.info("appel - articlePrixListDTOService AddCommand");
		}
		this.articlePrixDTOListeBas = this.articlePrixListDTOService.initListeArticleBas();
		this.articlePrixDTOListeHaut = this.articlePrixListDTOService.initListeArticleHaut();
		model.addAttribute(LISTE_ARTICLE_HAUT,this.articlePrixDTOListeHaut);
		model.addAttribute(LISTE_ARTICLE_BAS,this.articlePrixDTOListeBas);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(ArticleList.URL_NAME);
		return redirectView;
	}

}
