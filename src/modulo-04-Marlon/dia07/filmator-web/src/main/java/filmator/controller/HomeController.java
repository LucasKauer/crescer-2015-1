package filmator.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.mockito.InjectMocks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;

@Controller
public class HomeController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		// DAO === data access object, convencao para nomes de classe que conectam no banco
		FilmeDao dao = new FilmeDao();
		model.addAttribute("mensagem", "fulano de tal");
		model.addAttribute("millisegundos", System.currentTimeMillis());
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		return "nomeDoArquivo";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Filme filme, Model model) {
		System.out.println(filme.getNome());
		return "nomeDoArquivo";
	}
}

