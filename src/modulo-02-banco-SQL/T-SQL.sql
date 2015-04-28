-- 1 --

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

-- 3 --
