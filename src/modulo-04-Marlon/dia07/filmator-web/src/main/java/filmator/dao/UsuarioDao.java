package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

	public boolean autenticaUsuario(String autenticaLogin, String autenticaPassword) {
		List<Usuario> usuario = this.jdbcTemplate.query(
				"SELECT * FROM USUARIO WHERE LOGIN = ? AND PASSWORD = ?",
				new RowMapper<Usuario>() {
					public Usuario mapRow(ResultSet results, int rowNum)
							throws SQLException {
						Usuario usuario = new Usuario();
						usuario.setLogin(results.getString("login")); // --> results.getString("nome_da_coluna_no_banco")
						usuario.setPassword(results.getString("password"));
						return usuario;
					}
				}, autenticaLogin, autenticaPassword);

		if (!usuario.isEmpty() /*Se a lista de usuários não estiver vazia*/) {
			return true;
		}
		return false;
	}
	
	public boolean verificaSeEhAdministrador(String login, String password) {
		if(autenticaUsuario(login, password)) {
			if(login.equals("Administrador")) {
				return true;
			}
		}
		return false;
	}
}
