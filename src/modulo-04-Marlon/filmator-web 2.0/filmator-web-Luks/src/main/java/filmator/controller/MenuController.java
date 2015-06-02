package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.AvaliacaoDao;
import filmator.dao.FilmeDao;
import filmator.model.Genero;

@Controller
public class MenuController {
	
	@Inject
	private FilmeDao filmeDao;
	
	@Inject
	private AvaliacaoDao avaliacaoDao;
	
	// Controla a tela do home quando estiver logado.
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(HttpSession session, Model model) {
		boolean isUserLogged = AutenticaUsuario.isUserLogged(session, model);
		if(isUserLogged) {
			model.addAttribute("Filmes", filmeDao.consultarFilme());
			return "menu";
		} else {
			return "acessonegado";
		}
	}
	
	// Controla a tela de cadastro de filme
	@RequestMapping(value = "/cadastro-filme", method = RequestMethod.GET)
	public String cadastraFilme(HttpSession session, Model model) {
		boolean isUserLogged = AutenticaUsuario.isUserLogged(session, model);
		boolean isAdministrator = AutenticaUsuario.isAdministrator(session, model);
		if(isUserLogged && isAdministrator) {
			model.addAttribute("listaGeneros", Genero.values()); 
			return "cadastroFilme";
		} else {
			return "acessonegado";
		}
	}
	
	// EM CONSTRUCAO!!!
	@RequestMapping(value = "/avaliacao", method = RequestMethod.GET)
	public String avaliacaoFilme(HttpSession session, Model model) {
		boolean isUserLogged = AutenticaUsuario.isUserLogged(session, model);
		if(isUserLogged) {
			model.addAttribute("listaFilmes", filmeDao.consultarFilme());
			return "avaliacao";
		} else {
			return "acessonegado";
		}
	}

}
