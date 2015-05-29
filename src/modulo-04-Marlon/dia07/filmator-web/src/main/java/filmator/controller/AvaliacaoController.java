package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.AvaliacaoDao;

public class AvaliacaoController {

	@Inject
	private AvaliacaoDao avaliacaoDao;
	
	@RequestMapping(value = "/salvar-avaliacao", method = RequestMethod.POST)
	public String autenticar(Model model, HttpSession session, int idFilme, int nota) {
		String loginUsuario = (String) session.getAttribute("userLogged");
		avaliacaoDao.avaliaFilme(idFilme, loginUsuario, nota);

		return "avaliacao"; // --> Futuramente retornará para uma página de erro.
	}
	
}
