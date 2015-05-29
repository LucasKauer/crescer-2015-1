package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Avaliacao;
import filmator.model.Filme;
import filmator.model.Genero;

@Component
public class FilmeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Inject
	private AvaliacaoDao avaliacaoDao;

	public void inserirFilme(Filme filme) {
		jdbcTemplate
				.update("INSERT INTO FILME (NOME, GENERO, ANO_LANCAMENTO, DIRETOR, SINOPSE, IMAGEM) VALUES (?, ?, ?, ?, ?, ?)",
						filme.getNome(), filme.getGenero().name(),
						filme.getAnoLancamento(), filme.getDiretor(),
						filme.getSinopse(), filme.getImagem());
	}

	public List<Filme> consultarFilme() {
		List<Filme> filmes = jdbcTemplate.query(
				"SELECT f.*,"
				+ " (SELECT AVG(nota) FROM Avaliacao a WHERE a.id = f.id) as MEDIA"
				+ " FROM FILME f ", (ResultSet results,
				int rowNum) -> {
			
			Filme filme = new Filme(
					
						// 1
						// 2
						// ...
						// 64
					);
			filme.setIdFilme(results.getInt("ID"));
			filme.setNome(results.getString("NOME"));
			filme.setGenero(Genero.valueOf(results.getString("GENERO")));
			filme.setAnoLancamento(results.getInt("ANO_LANCAMENTO"));
			filme.setDiretor(results.getString("DIRETOR"));
			filme.setSinopse(results.getString("SINOPSE"));
			filme.setImagem(results.getString("IMAGEM"));
			filme.setNota(results.getDouble("MEDIA"));
			return filme;
		});		
		
		/* List<Avaliacao> avaliacoes = avaliacaoDao.buscaTodasMediasFilmes();
		
		for(Filme filme : filmes){
			for(Avaliacao avaliacao : avaliacoes){
				if (avaliacao.getIdFilme().equals(filme.getIdFilme()) {
					filme.setNota(avaliacao.getNota());
				}
			}
		}*/
		
		return filmes;

	}

}
