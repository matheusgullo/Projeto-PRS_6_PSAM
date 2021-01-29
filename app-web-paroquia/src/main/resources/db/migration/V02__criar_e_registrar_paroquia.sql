CREATE TABLE paroquia (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	sobre VARCHAR(255) NOT NULL,
	telefone varchar(15) ,
	email varchar(50) not null,
	logradouro VARCHAR(30),
	numero VARCHAR(30),
	bairro VARCHAR(30),
	cidade VARCHAR(30),
	cep varchar(30)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO paroquia (sobre, telefone,email,logradouro, numero,bairro,cidade, cep) 
values ('Paróquia Santa Angela de Merici', '(16) 98121-5731','paroq.santangela@gmail.com','Rua Manoel Rodrigues Jacob', '526', 'Santa Angelina', 'Araraquara - SP', '14802-195');

