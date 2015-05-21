### Dia 6

### Mestre Cuca - Persistindo em Arquivo
O objetivo deste exercício é de salvar (persistir) as receitas cadastradas em um arquivo `.json`. 
De forma geral, nosso objetivo será converter um objeto do Java (a lista de receitas) para um JSON. 
Para isto, os seguintes passos deverão ser realizados;

1. Criar uma nova classe, `LivroReceitasJson` que também deverá implementar a interface `LivroReceitas`.
2. No construtor desta nova classe, devemos receber um parâmetro - o caminho do arquivo aonde as receitas deverão ser salvas.
3. Durante a instanciação de um LivroReceitasJson, caso o arquivo passado por parâmetro exista, devemos carregar as receitas contidas nele (e atualizar
a nossa lista de receitas que armazenamos na memória).
4. Para converter um objeto para JSON utilizaremos uma biblioteca chamada Jackson (procurem os arquivos `jackson-databind`, `jackson-core` e `jackson-annotations` na interwebs).
5. Após o download da biblioteca, ela deve ser importada no nosso projeto.
6. O desafio do exercício será o de descobrir como utilizar a biblioteca e converter um objeto para JSON (e um JSON para objeto). Google it!
7. Para deixar claro: toda vez que inserirmos, excluirmos ou atualizarmos uma receita, o arquivo json (ex.: `c:\tmp\receitas.json` ou `/Users/eu/receitas.json`) deverá ser atualizado.

### Solução

**Carregando as receitas a partir de um arquivo:**
```java
public LivroReceitaJson(String caminho) throws IOException {
	this.caminho = caminho;
	carregaReceitasDeArquivoJson(caminho);
}

private void carregaReceitasDeArquivoJson(String caminho) throws IOException{
	File arquivo = new File(caminho);
	if(arquivo.exists()){
		receitas =  mapper.readValue(arquivo, List.class);
	}
}

//-> LivroReceitaJson livro = new LivroReceitaJson("/Users/marlon/Desktop/receitas.json");
```

**Salvando as receitas em arquivo:**
```java
@Override
public void inserir(Receita receita) {
	receitas.add(receita);
	salvaReceitasEmArquivoJson();
}

// chamar este método em inserir, atualizar e excluir	
private void salvaReceitasEmArquivoJson() {
	try {
		mapper.writeValue(new File(caminho), receitas);
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
}

```

### JDBC 
JDBC é a tecnologia utilizada para conectar em um banco de dados usando Java. É uma solução de baixo nível, um pouco burocrática e trabalhosa - mas relativamente simples de entender. Não é a melhor solução, mas é a que usaremos inicialmente nas nossas atividades de persistência. Nem tudo na vida é mamatinha™. 

Os exemplos abaixo são apenas didáticos! Há uma série de problemas no tratamento de exceções e controle transacional que não estão implementados de forma correta nos trechos de código abaixo. 

**Executando uma query:**
```java
Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/mestrecuca", "sa", "");
PreparedStatement preparedStatement = connection.prepareStatement("SELECT nome FROM Receita WHERE nome like ?");
preparedStatement.setString(1, "bolo de %");
ResultSet result = preparedStatement.executeQuery();
		
while(result.next()){
	System.out.println(result.getString("nome"));
}
connection.close();
```

**Inserindo um registro:**
```java
Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/mestrecuca", "sa", "");
PreparedStatement preparedStatement = connection.preparedStatement("INSERT INTO Receita (nome, preco) VALUES (?, ?)");
preparedStatement.setString(1, "bolo de fubá");
preparedStatement.setDouble(2, 40.20);
preparedStatement.executeUpdate();
connection.close();
```
