package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Genero;

@Controller
public class MenuController {

	@Inject
	private FilmeDao filmeDao;

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu() {
		return "menu";
	}

	@RequestMapping(value = "/cadastroFilme", method = RequestMethod.GET)
	public String cadastraFilme(Model model) {
		model.addAttribute("listaGeneros", Genero.values()); 
		return "cadastro";
	}

	@RequestMapping(value = "/consulta", method = RequestMethod.GET)
	public String consultaFilme(Model model) {
		model.addAttribute("Filmes", filmeDao.consultarFilme());
		return "consulta";
	}

}
