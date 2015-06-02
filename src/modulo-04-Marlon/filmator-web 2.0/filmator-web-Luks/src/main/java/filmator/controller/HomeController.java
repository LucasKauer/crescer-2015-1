package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;

@Controller
public class HomeController {

	@Inject
	private FilmeDao filmeDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String menu(Model model, HttpSession session) {
		// verifica se é administrador. Se for, libera o acesso a página de cadastro de filme.
		AutenticaUsuario.isAdministrator(session, model);
		// responsavel por buscar todos os filmes e "seta-los" no slider review. 
		model.addAttribute("Filmes", filmeDao.consultarFilme());
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