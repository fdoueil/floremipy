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
public class LogoutController {
	private final static Logger logger = Logger.getLogger(LogoutController.class.getName());

	@RequestMapping(value = "/logout", method = RequestMethod.GET)

	public String disconnect(Model model) {
		logger.info("deconnexion");
		
		
		model.addAttribute("UserConnecte", new UserDTO());		
		
		return "index";
		}
}

