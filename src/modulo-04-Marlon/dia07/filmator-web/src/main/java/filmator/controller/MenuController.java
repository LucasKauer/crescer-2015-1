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

	@Inject
	private FilmeDao filmeDao;

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(HttpSession session, Model model) {
		Boolean isAdministrador = (Boolean) session.getAttribute("isAdministrador");
		Boolean usuarioLogado = (Boolean) session.getAttribute("usuarioLogado");
		// verifica se é usuário. Se for, exibe menu.
		if(usuarioLogado != null && usuarioLogado) {
			model.addAttribute("exibeMenu", true);
			
			// verifica se é administrador. Se for, exibe menu para administrador.
			if(isAdministrador != null && isAdministrador){
				model.addAttribute("exibeMenuAdministrador", true);
			}else{
				model.addAttribute("exibeMenuAdministrador", false);
			}
			
		} else {
			model.addAttribute("exibeMenu", false);
		}
		return "menu";
	}

	@RequestMapping(value = "/cadastro-filme", method = RequestMethod.GET)
	public String cadastraFilme(Model model) {
		model.addAttribute("listaGeneros", Genero.values()); 
		return "cadastroFilme";
	}

	@RequestMapping(value = "/consulta", method = RequestMethod.GET)
	public String consultaFilme(Model model) {
		model.addAttribute("Filmes", filmeDao.consultarFilme());
		return "consulta";
	}

}
