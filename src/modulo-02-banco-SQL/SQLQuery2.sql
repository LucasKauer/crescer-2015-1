CREATE TABLE Cliente
(
IDCliente INT IDENTITY NOT NULL,
Nome VARCHAR(30) NOT NULL,
Endereco VARCHAR(35),
Bairro VARCHAR(35),
IDCidade INT
);

INSERT INTO Cliente
	(Nome,
	 Endereco,
	 Bairro)
VALUES
	('Maria',
	 'Rua Bento Gonçalves, 123',
	 'Centro');
SELECT * FROM Cliente;

INSERT INTO Cliente VALUES (1, 'Novo Hamburgo', 'RS');