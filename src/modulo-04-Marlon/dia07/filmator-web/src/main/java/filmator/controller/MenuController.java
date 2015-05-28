package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Genero;

@Controller
public class MenuController {
	
	// Model model;
	
	@Inject
	private FilmeDao filmeDao;

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(HttpSession session, Model model) {
		// verifica se é usuário. Se for, exibe menu.
		isUsuarioLogado(session, model);
		return "menu";
	}

	@RequestMapping(value = "/cadastro-filme", method = RequestMethod.GET)
	public String cadastraFilme(HttpSession session, Model model) {
		isUsuarioLogado(session, model);
		model.addAttribute("listaGeneros", Genero.values()); 
		return "cadastroFilme";
	}

	@RequestMapping(value = "/consulta", method = RequestMethod.GET)
	public String consultaFilme(Model model) {
		model.addAttribute("Filmes", filmeDao.consultarFilme());
		return "consulta";
	}
	
	// PRECISA SER REVISADO
	@RequestMapping(value = "/avaliacao", method = RequestMethod.GET)
	public String avaliacaoFilme(Model model) {
		model.addAttribute("listaFilmes", filmeDao.consultarFilme());
		return "avaliacao";
	}
	
	private void isAdministrador(HttpSession session, Model model) {
		Boolean isAdministrador = (Boolean) session.getAttribute("isAdministrador");
		if(isAdministrador != null && isAdministrador){
			model.addAttribute("exibeMenuAdministrador", true);
		}else{
			model.addAttribute("exibeMenuAdministrador", false);
		}
	}
	
	private void isUsuarioLogado(HttpSession session, Model model) {
		String usuarioLogado = (String) session.getAttribute("usuarioLogado");
		if(usuarioLogado != null) {
			model.addAttribute("exibeMenu", true);
			// verifica se é administrador. Se for, exibe menu para administrador.
			isAdministrador(session, model);
		} else {
			model.addAttribute("exibeMenu", false);
		}
	}
}
