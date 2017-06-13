package edd.floremipy.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	private final static Logger logger = Logger.getLogger(LoginController.class.getName());

	@RequestMapping(value = "/login", method = RequestMethod.GET)

	public String getLogin(Model model) {
		logger.info("getLogin");
		// model.addAttribute("form", new User());
		model.addAttribute("statusOK", false);
		model.addAttribute("statusMessage", "");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public String postLogin(@RequestParam(value = "email") String login, @RequestParam("pwd") String Password,
			Model model) {
		logger.info("postLogin");
		
		System.out.println("login = "+ login);
		model.addAttribute("statusOK", false);
		model.addAttribute("statusMessage", "");

		String message = "connexion ok";
		model.addAttribute("message", message);
		return "welcome";
	}
}
