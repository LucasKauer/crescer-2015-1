package listator;

import java.io.File;

import javax.swing.JOptionPane;

public class Teste {
	
	public static void main(String[] args) {
	    // Verifica se um diretório foi passado como parâmetro
	    validaParametros(args);
	    String dir = args[0];

	    // Busca todos os arquivos de um diretório
	    String[] files = buscaArquivosDiretorio(dir);

	    // Imprime os arquivos encontrados
	    imprimeArquivos(files);
	}

	private static void validaParametros(String[] args) {
	    if(args.length == 0){
	        throw new IllegalStateException("Nenhum diretório informado");
	    }
	}

	private static void imprimeArquivos(String[] files) {
	    for(String file : files){
	        System.out.println(file);
	    }
	}

	public static String[] buscaArquivosDiretorio(String dir) {
	    return new File(dir).list();
	}
}