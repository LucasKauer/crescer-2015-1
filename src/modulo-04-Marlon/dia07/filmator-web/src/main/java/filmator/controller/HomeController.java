package filmator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String menu() {
		return "home";
	}
	
	@RequestMapping(value = "/cadastro-usuario", method = RequestMethod.GET)
	public String cadastraUsuario() {
		return "cadastroUsuario";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
}