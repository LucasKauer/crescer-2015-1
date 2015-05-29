package filmator.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.AvaliacaoDao;
import filmator.model.Avaliacao;

@Controller
public class AvaliacaoController {

	@Inject
	private AvaliacaoDao avaliacaoDao;
	
	@RequestMapping(value = "/salvar-avaliacao", method = RequestMethod.POST)
	public String salvarAvaliacao(Model model, HttpSession session, Avaliacao avaliacao) {
		String loginUsuario = (String) session.getAttribute("userLogged");
		int idFilme = avaliacao.getIdFilme();
		int nota = avaliacao.getNota();
		
		boolean oFilmeNaoFoiAvaliado = (avaliacaoDao.getNotaInformandoFilmeEUsuario(avaliacao.getIdFilme(), loginUsuario).isEmpty());
		if(oFilmeNaoFoiAvaliado) {
			avaliacaoDao.avaliaFilme(idFilme, loginUsuario, nota);
		} else {
			avaliacaoDao.alteraAvaliacaoFilme(idFilme, loginUsuario, nota);
		}

		return "redirect:/avaliacao"; // --> Futuramente retornará para uma página de erro.
	}
	
}
