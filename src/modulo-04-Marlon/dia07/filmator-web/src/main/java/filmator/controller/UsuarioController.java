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
		return "redirect:/";
	}
	
	@RequestMapping(value = "/autenticarUsuario", method = RequestMethod.POST)
	public String autenticar(Usuario usuario) {
		usuarioDao.inserirUsuario(usuario);
		return "redirect:/menu";
	}

}