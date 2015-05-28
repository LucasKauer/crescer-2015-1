package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Filme;
import filmator.model.Genero;

@Component
public class FilmeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public void inserirFilme(Filme filme) {
		jdbcTemplate
				.update("INSERT INTO FILME (NOME, GENERO, ANO_LANCAMENTO, DIRETOR, SINOPSE, IMAGEM) VALUES (?, ?, ?, ?, ?, ?)",
						filme.getNome(), filme.getGenero().name(),
						filme.getAnoLancamento(), filme.getDiretor(),
						filme.getSinopse(), filme.getImagem());
	}

	public List<Filme> consultarFilme() {
		return jdbcTemplate.query("SELECT * FROM FILME", (ResultSet results,
				int rowNum) -> {
			Filme filme = new Filme();
			filme.setNome(results.getString("NOME"));
			filme.setGenero(Genero.valueOf(results.getString("GENERO")));
			filme.setAnoLancamento(results.getInt("ANO_LANCAMENTO"));
			filme.setDiretor(results.getString("DIRETOR"));
			filme.setSinopse(results.getString("SINOPSE"));
			filme.setImagem(results.getString("IMAGEM"));
			return filme;
		});

	}

}
