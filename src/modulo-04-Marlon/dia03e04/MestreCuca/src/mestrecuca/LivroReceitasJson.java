/**
 * Livro Receitas Json
 * @author CWI Software
 * 
 * Created by Lucas Kauer on 21/05/2015.
 * Last updated on: 21/05/2015
 */

package mestrecuca;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LivroReceitasJson implements LivroReceitas {
	private List<Receita> livroDeReceita= new ArrayList<Receita>();
	private String url;
	private ObjectMapper mapper = new ObjectMapper();
	
	public LivroReceitasJson(String url) throws IOException {
	    this.url = url;
	    carregaReceitasDeArquivoJson(url);
	}
	
	/**
	 * Carrega as receitas de arquivo .JSON
	 * @param url Caminho do arquivo
	 * @throws IOException
	 * 
	 * Created by Lucas Kauer on 21/05/2015.
	 */
	private void carregaReceitasDeArquivoJson(String url) throws IOException{
	    File arquivo = new File(url);
	    if(arquivo.exists()){
	    	livroDeReceita =  mapper.readValue(arquivo, List.class);
	    	
	    }
	}

	//-> LivroReceitaJson livro = new LivroReceitaJson("C:\\Users\\pc\\Desktop\\Filho\\GZoom\\receitas.json");
	
	/**
	 * Adiciona receitas a lista de receitas
	 * @param receita Receita passada
	 * 
	 * Created by Lucas Kauer on 21/05/2015.
	 */
	@Override
	public void inserir(Receita receita) {
		validaReceita(receita);
		livroDeReceita.add(receita);
	    salvaReceitasEmArquivoJson();
	}

	/**
	 * Atualiza a receita informa SE ela passar pelo validador.
	 * @param nome Nome da receita a ser atualizada
	 * @param receitaAtualizada Receita atualizada
	 * 
	 * Created by Lucas Kauer on 21/05/2015.
	 */
	@Override
	public void atualizar(String nome, Receita receitaAtualizada) {
		validaReceita(receitaAtualizada);
		Receita receita = buscaReceitaPeloNome(nome);
		int indice = livroDeReceita.indexOf(receita);
		livroDeReceita.set(indice, receitaAtualizada);
		salvaReceitasEmArquivoJson();
	}

	/**
	 * Exclui a receita SE ela for encontrada
	 * @param nome Nome da receita
	 * 
	 * Created by Lucas Kauer on 21/05/2015.
	 */
	@Override
	public void excluir(String nome) {
		Receita receita = buscaReceitaPeloNome(nome);
		int indice = livroDeReceita.indexOf(receita);
		livroDeReceita.remove(indice);
		salvaReceitasEmArquivoJson();
	}

	@Override
	public List<Receita> getTodasReceitas() {
		return livroDeReceita;
	}
	
	/**
	 * Busca a receita pelo nome SE não encontrar lanca uma exception
	 * @param nome Nome da receita
	 * 
	 * Created by Lucas Kauer on 21/05/2015.
	 */
	// chamar esse método em atualizar e excluir
	@Override
	public Receita buscaReceitaPeloNome(String nome) {
		for(Receita receita : livroDeReceita){
			if(receita.getNome().equals(nome)){
				return receita;
			}
		}
		throw new ReceitaNaoEncontradaException();
	}
	
	/**
	 * Valida as receitas
	 * @param receita Receita que será validada
	 * 
	 * Created by Lucas Kauer on 21/05/2015.
	 */
	// chamar esse método em inserir e atualizar
	private void validaReceita(Receita receita){
		String nome = receita.getNome();
		if(nome == null ||nome.trim().equals("")){
			throw new IllegalArgumentException("Nome de receita nulo ou inválido");
		}
	}
	
	/**
	 * Salva as receitas em um arquivo .JSON
	 * 
	 * Created by Lucas Kauer on 21/05/2015.
	 */
	// chamar este método em inserir, atualizar e excluir  
	private void salvaReceitasEmArquivoJson() {
	    try {
	        mapper.writeValue(new File(url), livroDeReceita);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}	
}