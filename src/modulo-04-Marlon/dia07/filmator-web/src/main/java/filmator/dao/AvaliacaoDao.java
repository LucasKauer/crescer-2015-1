package filmator.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoDao {
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void avaliaFilme(int idFilme, String loginUsuario, int nota){
		jdbcTemplate.update("INSERT INTO Avaliacao(id, login, nota) values (?, ?, ?)", idFilme, loginUsuario, nota);	
	}
	
	/* public List<Integer> getNotaFilmeUsuario(int idFilme, String loginUsuario){
		 return jdbcTemplate.query("SELECT nota FROM Avaliacao WHERE id = ? AND login = ?", (ResultSet rs, int rowNum) -> {	
			return rs.getInt("nota");
		}, idFilme, loginUsuario);
	} */
	
	/* public int getMediaFilme(int idFilme){
		jdbcTemplate.query("SELECT AVG(nota) as media FROM Avaliacao WHERE id = ?", (ResultSet rs, int rowNum) -> {
			return rs.getString(1);
	}, idFilme);
		return 0;
	}*/
}