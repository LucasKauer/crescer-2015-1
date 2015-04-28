/*
#6 - Toda chave estrangeira (FK) deve ter índice!
*/

-- 1 --
SELECT	Situacao
FROM	Produto
GROUP BY Situacao
ORDER BY Situacao;

-- 1.2
SELECT	COUNT(DISTINCT Situacao) AS Total_Valores
FROM	Produto;

-- 2 --
SELECT	Nome
FROM	Cliente
WHERE	Nome LIKE '%LTDA%'
		OR RazaoSocial LIKE '%LTDA%';

-- 3 --
INSERT INTO	Produto (Nome,
			PrecoCusto,
			PrecoVenda,
			Situacao)
VALUES	('Galocha Maragato',
		35.67,
		77.95,
		'A');

-- 4 --
SELECT	Produto.IDProduto,
		Produto.Nome
FROM Produto
	LEFT JOIN PedidoItem ON Produto.IDProduto = PedidoItem.IDProduto
WHERE PedidoItem.IDPedido IS NULL;

-- 4.1 --
SELECT	Produto.IDProduto,
		Produto.Nome
FROM Produto
WHERE NOT EXISTS	(SELECT 1
					FROM PedidoItem
					WHERE PedidoItem.IDProduto = Produto.IDProduto);

CREATE	 INDEX IX_PedidoItem_Produto ON PedidoItem(IDProduto);

-- 5 --
SELECT TOP 1 Cidade.UF AS Maior_Clientes,
			(SELECT TOP 1 Cidade.UF
			FROM Cidade
				INNER JOIN Cliente ON Cliente.IDCidade = Cidade.IDCidade
			GROUP BY Cidade.UF
			ORDER BY COUNT(1) DESC) AS Menor_Clientes
FROM Cidade
	INNER JOIN Cliente ON Cliente.IDCidade = Cidade.IDCidade
GROUP BY Cidade.UF
ORDER BY COUNT(1);

-- 5.1 --
-- criando view para reutilização de código
Create view vwEstados as
	Select cid.UF, Count(1) AS TotalClientes
	From   Cidade cid
	 inner join Cliente cli on cli.IDCidade = cid.IDCidade
	Group by cid.UF

-- utilizando a view para projetar o menor e maior
select * from vwEstados
where TotalClientes = (select min(TotalClientes) from vwEstados)
   or TotalClientes = (select max(TotalClientes) from vwEstados);

-- 6 --
SELECT	COUNT(DISTINCT Nome)
FROM	Cidade
WHERE EXISTS	(SELECT 1
				FROM Cliente
					INNER JOIN Pedido ON Pedido.IDCliente = Cliente.IDCidade
				WHERE Cliente.IDCidade = CIdade.IDCidade);

-- 6.1 --
SELECT	COUNT(DISTINCT Cidade.Nome) AS TotalCidades
FROM	Cidade
	INNER JOIN Cliente ON Cliente.IDCidade = Cidade.IDCidade
	INNER JOIN Pedido ON Pedido.IDCliente = Cliente.IDCidade;

-- 7 --
SELECT	Produto.IDProduto,
		Produto.Nome
FROM Produto
WHERE NOT EXISTS (SELECT 1
			  FROM ProdutoMaterial
			  WHERE ProdutoMaterial.IDProduto = Produto.IDProduto);

-- 8 --
SELECT	IDProduto,
		Nome,
		PrecoCusto,
		dbo.busca_PrecoCusto_Material(IDProduto) AS valor_de_custo
FROM	Produto
-- WHERE IDProduto = 123; --

CREATE FUNCTION busca_precoCusto_Material(@IDProduto INT)
	RETURNS DECIMAL (9, 2) AS
BEGIN
	DECLARE @preco_custo DECIMAL(9, 2)

	SELECT	@preco_custo = SUM (Material.PrecoCusto * ISNULL (ProdutoMaterial.Quantidade, 1))
	FROM	ProdutoMaterial
		INNER JOIN Material ON Material.IDMaterial = ProdutoMaterial.IDMaterial
	WHERE	ProdutoMaterial.IDProduto = @IDProduto

	RETURN @preco_custo
END;

-- 9 --