package edd.floremipy.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edd.floremipy.dto.UserDTO;
import edd.floremipy.service.UserServiceImpl;

@Controller
@SessionAttributes( value="UserConnecte", types={UserDTO.class} )
public class LoginController {
	private final static Logger logger = Logger.getLogger(LoginController.class.getName());

	@RequestMapping(value = "/login", method = RequestMethod.GET)

	public String getLogin(Model model) {
		logger.info("getLogin");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public String postLogin(@RequestParam(value = "login") String login, @RequestParam("pwd") String pwd, Model model) {
		logger.info("postLogin");

		System.out.println("login = " + login);
		System.out.println("pwd = " + pwd);
		String messageLogin = null;
		String messagePwd = null;

		// on teste le login et pwd saisis
		String retour = UserServiceImpl.getInstance().authenticate(login, pwd);
		System.out.println("retour = " + retour);

		if (retour == "PB:LoginController:Erreur 001:Utilisateur inconnu") {
			messageLogin = "login utilisateur inconnu";
		} else if (retour == "PB:Pwd:Erreur 001:Mot de passe incorrect pour cet utilisateur") {
			messagePwd = "Mot de passe incorrect pour cet utilisateur";
		}

		// user trouvé
		if (retour == login) {
			UserDTO UserConnecte = UserServiceImpl.getInstance().getUser(login);
			model.addAttribute("UserConnecte", UserConnecte);
			return "index";
		} else // user non trouvé
		{
			model.addAttribute("errorLogin", messageLogin);
			model.addAttribute("errorMotDePasse", messagePwd);

			return "login";
		}
	}
}
