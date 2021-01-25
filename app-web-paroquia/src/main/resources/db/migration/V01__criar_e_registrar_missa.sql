CREATE TABLE missa (
	dia VARCHAR(10) PRIMARY KEY,
	horarios VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO missa (dia, horarios) values ('DOMINGO', '8h, 10h, 19h');
INSERT INTO missa (dia, horarios) values ('SEGUNDA', '19h30');
INSERT INTO missa (dia, horarios) values ('TERCA', '19h30');
INSERT INTO missa (dia, horarios) values ('QUARTA', '19h30');
INSERT INTO missa (dia, horarios) values ('QUINTA', '19h30');
INSERT INTO missa (dia, horarios) values ('SEXTA', '19h30');
INSERT INTO missa (dia, horarios) values ('SABADO', '17:30h');
