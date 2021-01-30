CREATE TABLE missa (
	id INT(2) PRIMARY KEY,
	dia VARCHAR(20) NOT NULL,
	horarios VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO missa (id, dia, horarios) values ('1', 'Domingo', '8h, 10h, 19h');
INSERT INTO missa (id, dia, horarios) values ('2', 'Segunda-feira', '19h30');
INSERT INTO missa (id, dia, horarios) values ('3', 'Terça-Feira', '19h30');
INSERT INTO missa (id, dia, horarios) values ('4', 'Quarta-feira', '19h30');
INSERT INTO missa (id, dia, horarios) values ('5', 'Quinta-feira', '19h30');
INSERT INTO missa (id, dia, horarios) values ('6', 'Sexta-feira', '19h30');
INSERT INTO missa (id, dia, horarios) values ('7', 'Sábado', '17h30');
