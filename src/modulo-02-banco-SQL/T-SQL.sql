-- 1 --
SELECT	TOP 1 WITH TIES PedidoItem.IDProduto,
		Produto.Nome,
		SUM(quantidade) AS Total_Itens
FROM PedidoItem
	INNER JOIN Produto ON Produto.IDProduto = PedidoItem.IDProduto
GROUP BY PedidoItem.IDProduto,
		 Produto.Nome
ORDER BY Total_Itens DESC;

-- 1.1 --
BEGIN
	DECLARE @idproduto int,
	@nome varchar(100),
	@total_itens int
	SELECT	TOP 1 -- retorna considerando empate
			@idproduto = PedidoItem.IDProduto,
			@nome = Produto.Nome,
			@total_itens = SUM(quantidade)
	FROM PedidoItem
		INNER JOIN Produto ON Produto.IDProduto = PedidoItem.IDProduto
	GROUP BY PedidoItem.IDProduto,
			 Produto.Nome
	ORDER BY SUM(quantidade) DESC

	PRINT 'Produto: ' + @nome + ' Total vendido: ' + CAST(@total_itens AS VARCHAR (10))
END

-- 2 --
BEGIN
	DECLARE ListaCidade CURSOR
	LOCAL
	FAST_FORWARD
	FOR SELECT	Cidade.Nome,
				Cidade.UF
		FROM	Cidade
			INNER JOIN Cliente ON Cliente.IDCidade = Cidade.IDCidade
		GROUP BY Cidade.Nome,
				 Cidade.UF
		HAVING COUNT(1) > 1;
	DECLARE @vNome	VARCHAR(50),
			@vUF	VARCHAR(2)

	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF

	WHILE (@@FETCH_STATUS = 0) BEGIN
		PRINT @vNome + '/' + @vUF;
		FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
	END

	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END

-- 2.1 --
BEGIN
	DECLARE ListaCidade CURSOR
	LOCAL
	FAST_FORWARD
	FOR SELECT	Cidade.Nome,
				Cidade.UF
		FROM	Cidade
		GROUP BY Cidade.Nome,
				 Cidade.UF
		HAVING COUNT(1) > 1;

	DECLARE @vNome	VARCHAR(50),
			@vUF	VARCHAR(2),
			@total integer;

	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF

	WHILE (@@FETCH_STATUS = 0) BEGIN
		SELECT @total = COUNT(1)
		FROM Cliente
		WHERE EXISTS (SELECT 1
						FROM Cidade
						WHERE  Cidade.IDCidade = Cliente.IDCidade
						AND Cidade.Nome = @vNome
						AND Cidade.UF = @vUF);
		
		if @total > 0
			PRINT @vNome + '/' + @vUF + ' total de clientes: ' + CAST(@total AS VARCHAR(10));

		FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
	END

	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END

-- 3 --
SELECT	COUNT(DISTINCT Pedido.IDPedido) AS Total_Pedido,
		COUNT(1) AS  Total_Itens
FROM Pedido
	INNER JOIN PedidoItem ON PedidoItem.IDPedido = Pedido.IDPedido
WHERE EXISTS	(SELECT 1
				FROM ProdutoMaterial
				WHERE ProdutoMaterial.IDProduto = PedidoItem.IDProduto
				AND ProdutoMaterial.IDMaterial IN (SELECT IDMaterial FROM vwMateriais_Mais_Utilizados)
				);

CREATE VIEW vwMateriais_Mais_Utilizados AS
SELECT	TOP 1 WITH TIES
		Material.IDMaterial,
		Material.Descricao,
		COUNT(DISTINCT ProdutoMaterial.IDProduto) AS Total
FROM Material
	INNER JOIN ProdutoMaterial ON ProdutoMaterial.IDMaterial = Material.IDMaterial
	INNER JOIN Produto		   ON Produto.IDProduto = ProdutoMaterial.IDProduto
GROUP BY Material.IDMaterial,
		 Material.Descricao
ORDER BY total DESC

sp_help 'ProdutoMaterial'
SELECT Pedido.IDPedido,
	   PedidoItem.IDPedidoItem,
	   Produto.IDProduto,
	   Produto.Nome,
	   PedidoItem.Quantidade
FROM Pedido
	INNER JOIN PedidoItem		ON PedidoItem.IDPedido	= Pedido.IDPedido
	INNER JOIN Produto			ON Produto.IDProduto	= PedidoItem.IDProduto
	INNER JOIN ProdutoMaterial	ON ProdutoMaterial.IDProduto = Produto.IDProduto
	-- INNER JOIN PordutoMaterial ON ProdutoMaterial.IDProduto = Produto.IDProduto
WHERE Pedido.DataPedido BETWEEN DATEADD(DAY, 60, GETDATE()) AND GETDATE();