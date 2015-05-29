package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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

	@RequestMapping(value = "/salvar-usuario", method = RequestMethod.POST)
	public String salvar(Usuario usuario) {
		usuarioDao.inserirUsuario(usuario);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/autenticar-usuario", method = RequestMethod.POST)
	public String autenticar(String login, String password, Model model, HttpSession session) {
		if(usuarioDao.autenticaUsuario(login, password)) {
			session.setAttribute("userLogged", login);
			if(usuarioDao.verificaSeEhAdministrador(login, password)) {
				session.setAttribute("isAdministrator", true);
				return "redirect:/menu";
			} else {
				session.setAttribute("isAdministrator", false);
				return "redirect:/menu";
			}
		}
		
		model.addAttribute("mensagemerro", "Credenciais Inválidas!");
		return "login"; // --> Futuramente retornará para uma página de erro.
	}

}