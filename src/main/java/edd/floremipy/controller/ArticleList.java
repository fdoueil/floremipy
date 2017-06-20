package edd.floremipy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import edd.floremipy.dto.ArticlePrixListDTO;
import edd.floremipy.service.ArticlePrixListDTOServiceImplementation;
import edd.floremipy.service.CreerCommandeImplementation;




@Controller
public class ArticleList{
	private static final long serialVersionUID = 1L;

	private final static Logger logger =
			Logger.getLogger(ArticleList.class.getName());

	private final String URL_NAME = "http://localhost:8080/articleList";
	private final String URL_NAME_BASIC = "articleList";

	private int idArticlePrixToAdd;
	private int idArticlePrixToDel;
	private int idCustomer;

	Map<String, String> errors = new HashMap<String, String>();
	ArrayList<ArticlePrixListDTO> articlePrixDTOListeHaut;
	ArrayList<ArticlePrixListDTO> articlePrixDTOListeBas;
	
	@Autowired
	ArticlePrixListDTOServiceImplementation articlePrixListDTOService;
	CreerCommandeImplementation creerCommandeImplementation = new CreerCommandeImplementation();

	public static final String CHAMP_IDUSERCONNECTED = "idUserConnected";
	public static final String LISTE_ARTICLE_HAUT = "articlePrixDTOListeHaut";
	public static final String LISTE_ARTICLE_BAS = "articlePrixDTOListeBas";

	@RequestMapping(value = "/articleList", method = RequestMethod.GET)
	public String getArticleList(Model model, Integer idCustomer) {
		/* Init du log */
		logger.info("getArticleList");
		System.out.println("getArticleList");

		/* Init donn�es et r�cup�ration des champs du formulaire. */
		if (this.articlePrixDTOListeHaut == null){
			this.articlePrixDTOListeHaut = new ArrayList<ArticlePrixListDTO>();
			this.articlePrixDTOListeHaut = this.articlePrixListDTOService.initListeArticleHaut();
		}
		if (this.articlePrixDTOListeBas == null){
			this.articlePrixDTOListeBas = new ArrayList<ArticlePrixListDTO>();
			this.articlePrixDTOListeBas = this.articlePrixListDTOService.initListeArticleBas();
		}

		if (idCustomer != null){
			this.idCustomer = idCustomer;
		}
		else {
			this.idCustomer = 0;
		}

		model.addAttribute(CHAMP_IDUSERCONNECTED,this.idCustomer);
		model.addAttribute(LISTE_ARTICLE_HAUT,this.articlePrixDTOListeHaut);
		model.addAttribute(LISTE_ARTICLE_BAS,this.articlePrixDTOListeBas);


		return this.URL_NAME_BASIC;
	}

	@RequestMapping(value = "/articleList/add/{idArticlePrixToAdd}", method = RequestMethod.GET)
	public RedirectView  add(@PathVariable Integer idArticlePrixToAdd, Model model) {
		/* Init du log */
		logger.info("add");
		System.out.println("add");

		if (idArticlePrixToAdd != null){
			this.idArticlePrixToAdd = idArticlePrixToAdd;
			this.articlePrixListDTOService.deplaceDuHautVersLeBas(this.articlePrixDTOListeHaut, this.articlePrixDTOListeBas, this.idArticlePrixToAdd);
			System.out.println("post idArticle � ajouter en bas par addition :" + this.idArticlePrixToAdd);
		}

		model.addAttribute(LISTE_ARTICLE_HAUT,this.articlePrixDTOListeHaut);
		model.addAttribute(LISTE_ARTICLE_BAS,this.articlePrixDTOListeBas);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(this.URL_NAME);
		return redirectView;

	}

	@RequestMapping(value = "/articleList/del/{idArticlePrixToDel}", method = RequestMethod.GET)
	public RedirectView  del(Model model,  @PathVariable Integer idArticlePrixToDel) {
		/* Init du log */
		logger.info("del");
		System.out.println("del");

		if (idArticlePrixToDel != null){
			this.idArticlePrixToDel = idArticlePrixToDel;
			this.articlePrixListDTOService.deplaceDuBasVersLeHaut(this.articlePrixDTOListeHaut, this.articlePrixDTOListeBas, this.idArticlePrixToDel);
			System.out.println("post idArticle � ajouter en haut par suppression :" + this.idArticlePrixToDel);
		}

		model.addAttribute(LISTE_ARTICLE_HAUT,this.articlePrixDTOListeHaut);
		model.addAttribute(LISTE_ARTICLE_BAS,this.articlePrixDTOListeBas);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(this.URL_NAME);
		return redirectView;
	}

	@RequestMapping(value = "/articleList/addCommande", method = RequestMethod.GET)
	public RedirectView  addCommande(Model model) {
		/* Init du log */
		logger.info("addCommande");
		System.out.println("addCommande");

		if (this.articlePrixDTOListeBas != null){
			long idCustomerLogge=0;  // A recuperer dans UserDTO chargé au login
			this.creerCommandeImplementation.creeCommande(idCustomerLogge , this.articlePrixDTOListeBas);
			System.out.println("appel - articlePrixListDTOService AddCommand");
		}
		this.articlePrixDTOListeBas = this.articlePrixListDTOService.initListeArticleBas();
		this.articlePrixDTOListeHaut = this.articlePrixListDTOService.initListeArticleHaut();
		model.addAttribute(LISTE_ARTICLE_HAUT,this.articlePrixDTOListeHaut);
		model.addAttribute(LISTE_ARTICLE_BAS,this.articlePrixDTOListeBas);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(this.URL_NAME);
		return redirectView;
	}

}
