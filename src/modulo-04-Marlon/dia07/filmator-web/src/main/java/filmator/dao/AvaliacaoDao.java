package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Avaliacao;

@Component
public class AvaliacaoDao {
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void avaliaFilme(int idFilme, String loginUsuario, int nota){
		jdbcTemplate.update("INSERT INTO Avaliacao(id, login, nota) values (?, ?, ?)", idFilme, loginUsuario, nota);	
	}
	
	public void alteraAvaliacaoFilme(int idFilme, String loginUsuario, int nota){
		jdbcTemplate.update("UPDATE Avaliacao SET Nota = ? WHERE id = ? AND login = ?", nota, idFilme, loginUsuario);	
	}

	public List<Integer> getNotaInformandoFilmeEUsuario(int idFilme, String loginUsuario) {
		 return jdbcTemplate.query("SELECT nota FROM Avaliacao WHERE id = ? AND login = ?", (ResultSet results, int rowNum) -> {	
			return results.getInt("nota");
		}, idFilme, loginUsuario);
	}
	
	public int getMediaFilme(int idFilme){
		jdbcTemplate.query("SELECT AVG(nota) as media FROM Avaliacao WHERE id = ?", (ResultSet rs, int rowNum) -> {
			return rs.getString(1);
	}, idFilme);
		return 0;
	}
	
}