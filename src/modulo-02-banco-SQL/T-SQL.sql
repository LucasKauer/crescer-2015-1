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
