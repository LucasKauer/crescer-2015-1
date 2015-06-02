package filmator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public class AutenticaUsuario {

	// verifica se o usuario eh do tipo administrador. Se for, retorna true; caso não, false.
	protected static boolean isAdministrator(HttpSession session, Model model) {
		Boolean isAdministrator = (Boolean) session.getAttribute("isAdministrator");
		if (isAdministrator != null && isAdministrator) {
			// Permite que o usuário acesse a área de cadastro de filme
			model.addAttribute("exibeMenuAdministrador", true);
			return true;
		} else {
			// Não permite que o usuário acesse a área de cadastro de filme
			model.addAttribute("exibeMenuAdministrador", false);
			return false;
		}
	}

	// verifica se o usuario está logado. Se estiver, retorna true; caso não, false.
	protected static boolean isUserLogged(HttpSession session, Model model) {
		String usuarioLogado = (String) session.getAttribute("userLogged");
		if (usuarioLogado != null) {
			// Permite que o usuário acesse a área de consulta (menu)
			model.addAttribute("exibeMenu", true);
			// verifica se é administrador. Se for, exibe menu para administrador.
			isAdministrator(session, model);
			return true;
		} else {
			// Não permite que o usuário acesse a área de consulta (menu)
			model.addAttribute("exibeMenu", false);
			return false;
		}
	}
}