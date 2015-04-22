SELECT Associado.Nome AS NomeAssociado,
		Cidade.Nome AS NomeCidade
FROM Associado
	INNER JOIN Cidade ON  Cidade.IDCidade = Associado.IDCidade

SELECT * FROM Associado

----
SELECT	e.IDEmpregado,
		e.NomeEmpregado,
		d.NomeDepartamento
FROM	Empregado e
	LEFT JOIN Departamento d on d.IDDepartamento = e.IDDepartamento

----
SELECT	e.IDEmpregado,
		e.NomeEmpregado AS NomeEmpregado,
		e.IDGerente,
		g.NomeEmpregado AS NomeGerente
FROM Empregado e
	INNER JOIN Empregado g ON e.IDGerente = g.IDEmpregado;