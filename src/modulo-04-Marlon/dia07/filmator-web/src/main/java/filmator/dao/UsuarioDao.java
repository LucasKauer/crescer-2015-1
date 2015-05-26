package filmator.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Usuario;

@Component
public class UsuarioDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public void inserirUsuario(Usuario usuario) {
		jdbcTemplate.update(
				"INSERT INTO USUARIO (LOGIN, PASSWORD) VALUES (?, ?)",
				usuario.getLogin(), usuario.getPassword());
	}

}
