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
@SessionAttributes( value="userConnecte", types={UserDTO.class} )
public class LoginController {
	private final static Logger logger = Logger.getLogger(LoginController.class.getName());

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model) {
		logger.info("getLogin");
		return "login";
	}

}
