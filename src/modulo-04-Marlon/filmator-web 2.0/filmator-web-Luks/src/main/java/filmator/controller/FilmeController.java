package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class FilmeController {
	@Inject
	FilmeDao filmeDao;

	@RequestMapping(value = "/salvar-filme", method = RequestMethod.POST)
	public String salvar(Model model, Filme filme) {
		filmeDao.inserirFilme(filme);
		model.addAttribute("listaGeneros", Genero.values());
		return "redirect:/menu";
	}
}