package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuarioDao;
import filmator.model.Usuario;

@Controller
public class UsuarioController {
	@Inject
	UsuarioDao usuarioDao;

	@RequestMapping(value = "/salvarUsuario", method = RequestMethod.POST)
	public String salvar(Usuario usuario) {
		usuarioDao.inserirUsuario(usuario);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/autenticarUsuario", method = RequestMethod.POST)
	public String autenticar(String login, String password, Model model) {
		if(usuarioDao.autenticaUsuario(login, password)) {
			if(usuarioDao.verificaSeEhAdministrador(login, password)) {
				return "redirect:/menu";
			} else {
				return "redirect:/menunormal";
			}
		}
		
		model.addAttribute("mensagemerro", "Credenciais Inválidas!");
		return "login"; // --> Futuramente retornará para uma página de erro.
	}

}