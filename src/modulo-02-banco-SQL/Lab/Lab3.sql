-- Table "Emp" ... --
	create table Empregado (
 IDEmpregado    int not null
,NomeEmpregado  varchar(30) not null
,Cargo          varchar(15) not null
,IDGerente      int null
,DataAdmissao   datetime not null
,Salario        decimal(7,2) not null
,Comissao       decimal(7,2)
,IDDepartamento int
);

insert into Empregado values (7369 ,'SMITH', 'Atendente', '7902', convert(datetime, '1980/12/17', 111), 800, null, 20);
insert into Empregado values (7499 ,'ALLEN', 'Vendedor', '7698', convert(datetime, '1981/02/20', 111), 1600, 300, 30);
insert into Empregado values (7521 ,'WARD', 'Vendedor', '7698', convert(datetime, '1981/02/22', 111), 1250, 500, 30);
insert into Empregado values (7566 ,'JONES', 'Gerente', '7839', convert(datetime, '1981/04/02', 111), 2975, null, 20);
insert into Empregado values (7654 ,'MARTIN', 'Vendedor', '7698', convert(datetime, '1981/09/28', 111), 1250, 1400, 30);
insert into Empregado values (7698 ,'BLAKE', 'Gerente', '7839', convert(datetime, '1981/05/01', 111), 2850, null, 30);
insert into Empregado values (7782 ,'CLARK', 'Gerente', '7839', convert(datetime, '1981/06/09', 111), 2450, null, 10);
insert into Empregado values (7788 ,'SCOTT', 'Analista', '7566', convert(datetime, '1982/12/09', 111), 3000, null, 20);
insert into Empregado values (7839 ,'KING', 'Presidente', null, convert(datetime, '1981/11/17', 111), 5000, null, null);
insert into Empregado values (7844 ,'TURNER', 'Vendedor', '7698', convert(datetime, '1981/09/08', 111), 1500, 0, 30);
insert into Empregado values (7876 ,'ADAMS', 'Atendente', '7788', convert(datetime, '1983/01/12', 111), 1100, null, 20);
insert into Empregado values (7900 ,'JAMES', 'Atendente', '7698', convert(datetime, '1981/12/03', 111), 950, null, 30);
insert into Empregado values (7902 ,'FORD', 'Analista', '7566', convert(datetime, '1981/12/03', 111), 3000, null, 20);
insert into Empregado values (7934 ,'MILLER', 'Atendente', '7782', convert(datetime, '1982/01/23', 111), 1300, null, 10);
insert into Empregado values (7940 ,'ANDREW', 'Atendente', '7782', convert(datetime, '1988/01/20', 111), 1150, null, null);

create table Departamento (
 IDDepartamento   int not null
,NomeDepartamento varchar(30)
,Localizacao      varchar(25)
);

insert into Departamento values (10,'Contabilidade', 'SAO PAULO');
insert into Departamento values (20,'Pesquisa', 'SAO LEOPOLDO');
insert into Departamento values (30,'Vendas', 'SAO PAULO');
insert into Departamento values (40,'Opera��es', 'RECIFE');
insert into Departamento values (1, 'Presid�ncia', 'RIBEIRAO PRETO');
insert into Departamento values (60, 'Tecnologia', 'PORTO ALEGRE');

---------
ALTER TABLE Departamento ADD  CONSTRAINT PK_departamento 
  PRIMARY KEY  
  (IDDepartamento);

ALTER TABLE Empregado ADD  CONSTRAINT PK_Empregado
  PRIMARY KEY  
  (IDEmpregado);

ALTER TABLE Empregado ADD CONSTRAINT FK_Empregado_Departamento
  FOREIGN KEY (IDDepartamento) REFERENCES Departamento (IDDepartamento);

CREATE INDEX IX_Empregado_Departamento ON Empregado (IDDepartamento);

-- 1 --
SELECT NomeEmpregado
FROM Empregado
ORDER BY DataAdmissao ASC;

-- 2 --
SELECT NomeEmpregado,
	(Salario*12) as SalarioAnual
FROM Empregado
WHERE Cargo = 'atendente' or (Salario*12) < 18500;

-- 3 --
SELECT IDCidade
FROM Cidade
WHERE Nome = 'Uberl�ndia';

-- 4 --
SELECT IDCidade,
	Nome
FROM Cidade
WHERE UF = 'RS';

-- Exemplos COUNT --
SELECT	COUNT (IDEmpregado) FROM Empregado;
SELECT	COUNT (*)			FROM Empregado;
SELECT	COUNT (1)			FROM Empregado;
SELECT	COUNT (comissao),
		COUNT (IDEmpregado),
		COUNT (1)
FROM Empregado;

SELECT *, 1 FROM Empregado;


-- Exemplo Distinct --
SELECT	COUNT(1) as TotalEmpregados,
		COUNT(DISTINCT Cargo) as TotalCargos
FROM Empregado;

SELECT DISTINCT Cargo FROM Empregado;

SELECT COUNT(DISTINCT Cargo) AS total_cargos
FROM Empregado;

SELECT	SUM(salario)	AS soma,
		MAX(salario)		AS maximo,
		MIN(salario)	AS minimo
FROM Empregado;

SELECT	IDDepartamento,
		SUM(salario)	AS soma,
		MAX(salario)		AS maximo,
		MIN(salario)	AS minimo
FROM Empregado
-- WHERE --
GROUP BY IDDepartamento;
-- ORDER BY --

SELECT NomeEmpregado,
		(Salario + Comissao) as Total_sal_a,
		(Salario + (ISNULL(Comissao, 0))) as Total_sal_b,
		Comissao
FROM Empregado;

SELECT	IDAssociado,
		Nome,
		CASE	WHEN sexo = 'F' THEN 'Feminino'
				WHEN sexo = 'M' THEN 'Masculino'
				ELSE		'Sei l�'
				END	Genero
FROM Associado;

-- or --

SELECT	IDAssociado,
		Nome,
		CASE	Sexo
				WHEN 'F' THEN 'Feminino'
				WHEN 'M' THEN 'Masculino'
				ELSE		'Sei l�'
				END	Genero2
FROM Associado;

-- Exerc�cio SLIDE 17 (20/04) --

-- 1 --
SELECT	SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) -1) AS [Primeiro Nome]
FROM	Associado;

-- 2 --
SELECT	Nome, 
		DATEDIFF(YEAR, DataNascimento, GETDATE()) AS Idade
FROM	Associado;

-- 3 --
SELECT	NomeEmpregado,
		DATEDIFF(MONTH, DataAdmissao, CONVERT(DATETIME, '31/12/2000', 103)) AS [Total de Meses Trabalhados]
FROM	Empregado
WHERE	DataAdmissao	BETWEEN	CONVERT(DATETIME, '01/05/1980', 103)
						AND		CONVERT(DATETIME, '20/01/1982', 103);

-- 4 --
SELECT	TOP 1 WITH TIES
		Cargo,
		COUNT(1) AS [Cargo Que Possui Mais Empregados]
FROM	Empregado
GROUP BY Cargo
ORDER BY [Cargo Que Possui Mais Empregados] DESC;

-- 5 --
SELECT TOP 1	Nome AS [Nome Que Possui Mais Caracteres]
FROM			Associado
ORDER BY		LEN(Nome) DESC;

-- 6 --
SELECT	Nome,
		DATEADD(YEAR, 50, DataNascimento) as [Data dos 50 anos],
		DATEPART(WEEKDAY, DATEADD(YEAR, 50, DataNascimento)) AS [Dia da Semana],
		DATENAME(WEEKDAY, DATEADD(YEAR, 50, DataNascimento)) AS [Dia da Semana (nome)]
FROM Associado;

-- 7 --
SELECT	UF,
		COUNT(UF) AS [Quatidade de Cidades]
FROM Cidade
GROUP BY UF
ORDER BY UF ASC;

-- 8 --
SELECT	Nome,
		UF
FROM Cidade
GROUP BY Nome, UF
HAVING	COUNT(Nome) > 1
	AND COUNT(UF) > 1;

-- 9 --
SELECT ISNULL(MAX(IDAssociado), 0) + 1 AS [Pr�ximo ID]
FROM Associado;

-- 10 --
DELETE FROM CopiaCidade;

INSERT INTO CopiaCidade
			(IDCidade, Nome, UF)
SELECT	MIN(IDCidade) Menor_IDCidade,
		Nome,
		UF
FROM Cidade
GROUP BY Nome, UF;
Select * From CopiaCidade;
SP_HELP 'CopiaCidade'

-- 11 --
BEGIN TRANSACTION
GO

UPDATE Cidade
SET Nome = '* ' + Nome
WHERE Nome IN	(SELECT Nome
				FROM Cidade
				GROUP BY Nome
				HAVING COUNT(1) > 1);

SELECT * From Cidade;

-- 12 --
SELECT	Nome,
		CASE Sexo
			WHEN 'M' THEN 'Masculino'
			WHEN 'F' THEN 'Feminino'
			ELSE 'Outro'
		END Genero
FROM Associado;

-- 13 --
SELECT	NomeEmpregado,
		Salario,
		CASE
			WHEN Salario BETWEEN 1164.01 AND 2326 THEN (Salario*0.15)
			WHEN Salario > 2326 THEN (Salario*0.275)
			ELSE 0
		END Desconto_IR
FROM Empregado

-- 14 --
BEGIN TRANSACTION
GO

DELETE FROM Cidade
WHERE IDCidade in (SELECT MAX(IDCidade)
					FROM Cidade
					GROUP BY Nome, UF
					HAVING COUNT(1) > 1);

SELECT MAX(IDCidade), Nome, UF
FROM Cidade
GROUP BY Nome, UF
HAVING COUNT(1) > 1;

SELECT Nome, UF
FROM Cidade
GROUP BY Nome, UF
HAVING Count(1) > 1;

-- 15 --
ALTER TABLE Cidade
	ADD CONSTRAINT UK_Cidade_NomeUF
	UNIQUE (Nome, UF);

INSERT INTO Cidade
	(IDCidade,
	Nome,
	UF)
VALUES	(100,
		'Bage',
		'RS');

Select * from Cidade;

-- Relacionamentos --
UPDATE Associado
SET IDCidade = 1
WHERE IDAssociado = 1;

UPDATE Associado
SET IDCidade = 32
WHERE IDAssociado = 3;

-- 1 --
SELECT	e.NomeEmpregado,
		d.NomeDepartamento
FROM Empregado e
		LEFT JOIN Departamento d ON d.IDDepartamento = e.IDDepartamento;

-- 2 --
SELECT	a.Nome,
		c.Nome
FROM Associado a
		LEFT JOIN Cidade c ON c.IDCidade = a.IDCidade;

-- Tirar asterisco
BEGIN TRANSACTION
GO

UPDATE Cidade
SET Nome = REPLACE(Nome, '*', '')
WHERE  Nome LIKE '*%';

SELECT IDCidade, Nome, REPLACE(Nome, '*', '') Novo_Nome
FROM Cidade;

-- 3 --
SELECT	c.UF,
		COUNT(1) AS [Total de Cidade S/ Associados]
FROM Cidade c
WHERE NOT EXISTS	(SELECT 1
				FROM Associado a
				WHERE a.IDCidade = c.IDCidade)
GROUP BY c.UF;

-- 4 --
/*	Criando uma view (exibic�o)
	View eh uma forma de salvar um comando sql para reaproveitar ele posteriormente ;D
*/

CREATE VIEW vw_Cidade_Regiao as
SELECT Associado.Nome AS Nome_Associado,
	   Cidade.Nome AS Nome_Cidade,
	   CASE Cidade.UF
		    WHEN 'RS' THEN '***'
			WHEN 'SC' THEN '***'
			WHEN 'PR' THEN '***'
			ELSE null
		END AS Regiao_Sul
FROM Associado
	LEFT JOIN Cidade ON Associado.IDCidade = Cidade.IDCidade;

-- Utilizando a view vw_Cidade_Regiao ;DD
SELECT * FROM vw_Cidade_Regiao;

-- 5 --
SELECT	e.NomeEmpregado AS [Nome do Empregado],
		g.NomeEmpregado AS [Nome do Gerente],
		d.NomeDepartamento AS [Nome do Departamento do Empregado]
FROM Empregado e
	INNER JOIN Empregado g ON g.IDGerente = e.IDGerente
	INNER JOIN Departamento d ON d.IDDepartamento = e.IDDepartamento;

-- 6 --
BEGIN TRANSACTION
GO

SELECT *
INTO CopiaEmpregado
FROM Empregado;

ROLLBACK
-- SEGUNDA PARTE
BEGIN TRANSACTION
GO

UPDATE Empregado 
SET Salario += (Salario*0.145)
WHERE IDDepartamento in (10);

-- 7 --
SELECT SUM(Salario*0145) AS Soma
FROM Empregado
WHERE IDDepartamento IN (10);

-- 8 --
SELECT TOP 1 Empregado.IDDepartamento,
			 Departamento.NomeDepartamento
FROM Empregado
	INNER JOIN departamento ON Departamento.IDDepartamento = Empregado.IDDepartamento
ORDER BY (Salario) DESC;
