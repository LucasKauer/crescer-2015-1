# Java
As convenções abaixo são consideradas padrão na linguagem Java. Fique atento: cada linguagem apresenta suas próprias convenções e estas devem sempre sem respeitadas. 

* Nomes de pacote devem apresentar apenas letras minúsculas. 

```java
  package mestrecuca; // correto
  package mestreCuca; // errado
  package mestre_cuca; // errado
```

* Nomes de classe devem iniciar com letra maiúscula e camel case, quando necessário.

```java
  public class LivroReceitas { // correto
  public class Ingrediente { // correto
  public class livroReceitas { // errado
  public class Livro_Receitas { // errado
```

* Nomes de métodos devem iniciar com letra minúscula.

```java
  public void calcularPreco() { // correto
  public void CalcularPreco() { // errado
  public void calcular_preco() { // errado
  public void calcularpreco() { // errado
```

* Não esqueça de definir os modificadores de acesso nos métodos e atributos. Tente reduzir a visiblidade dos atributos sempre que possível. Em outras palavras: prefira atributos privados à atributos publicos. Reduzir a visiblidade facilita a manutenção, pois não estamos expondo detalhes internos da implementação de nossas classes.

```java
  private String nome; // possivelmente correto
  public String nome; // possivelmente uma má prática
```
