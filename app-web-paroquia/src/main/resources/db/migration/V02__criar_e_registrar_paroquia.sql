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

INSERT INTO paroquia (sobre, telefone, email, logradouro, numero, bairro, cidade, cep) values ('Como disse nossa Padroeira: "Agi, mexei-vos, crede, esforçai-vos, esperai, clamai a Deus do fundo do coração, porque sem dúvida alguma vereis maravilhas". Seja bem-vindo(a) ao nosso site paroquial de Santa Ângela de Mérici!', '(16) 98121-5731','paroq.santangela@gmail.com','Rua Manoel Rodrigues Jacob', '526', 'Santa Angelina', 'Araraquara - SP', '14802-195');

