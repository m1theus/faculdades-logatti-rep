INSERT INTO TB_EMPRESA(nome, endereco, telefone, website) VALUES ('Viação Paraty', 'Avenida Otto Ernani Muller, 10 Jd Tamoio – Araraquara – SP', '(16) 3334 7800', 'vparaty.com.br');
INSERT INTO TB_EMPRESA(nome, endereco, telefone, website) VALUES ('Empresa Cruz', 'Rua Domingos Zanin, 264 Jardim Ártico - CEP 14800-250 Araraquara/SP', '0800 881 5234', 'www.empresacruz.com.br');


INSERT INTO TB_LINHA(codigo, nome) VALUES (1, 'Águas do Paiol');

INSERT INTO TB_EMPRESA_LINHA(nome_empresa, codigo_linha) VALUES ('Viação Paraty', 1);

INSERT INTO TB_LOGRADOURO(codigo, nome) VALUES (1, 'Av. Augusto Bernardi (Ponto de Controle)');
INSERT INTO TB_LOGRADOURO(codigo, nome) VALUES (2, 'Rua Lino Morgante');
INSERT INTO TB_LOGRADOURO(codigo, nome) VALUES (3, 'Av. Miguel Pocce');
INSERT INTO TB_LOGRADOURO(codigo, nome) VALUES (4, 'Av. José Barbanti Neto');
INSERT INTO TB_LOGRADOURO(codigo, nome) VALUES (5, 'Av. Antônio Honório Real');
INSERT INTO TB_LOGRADOURO(codigo, nome) VALUES (6, 'Av. Prof° Gustavo Fleury Charmillot');
INSERT INTO TB_LOGRADOURO(codigo, nome) VALUES (7, 'Rua Bento Machado Ramalho');
INSERT INTO TB_LOGRADOURO(codigo, nome) VALUES (8, 'Rua Prof. Virgilio Abranches Quintão');
INSERT INTO TB_LOGRADOURO(codigo, nome) VALUES (9, 'Rua Carlos Gomes');
INSERT INTO TB_LOGRADOURO(codigo, nome) VALUES (10, 'Av. Padre Francisco Sales Culturato');
INSERT INTO TB_LOGRADOURO(codigo, nome) VALUES (11, 'Rua São Bento');
INSERT INTO TB_LOGRADOURO(codigo, nome) VALUES (12, 'Av. Portugal, Terminal');

INSERT INTO TB_ITINERARIO(nome, codigo_linha, codigo_logradouro, ordem) VALUES ('Águas do Paiol / Terminal (TCI)', 1, 1, 1);
INSERT INTO TB_ITINERARIO(nome, codigo_linha, codigo_logradouro, ordem) VALUES ('Águas do Paiol / Terminal (TCI)', 1, 2, 2);
INSERT INTO TB_ITINERARIO(nome, codigo_linha, codigo_logradouro, ordem) VALUES ('Águas do Paiol / Terminal (TCI)', 1, 3, 3);
INSERT INTO TB_ITINERARIO(nome, codigo_linha, codigo_logradouro, ordem) VALUES ('Águas do Paiol / Terminal (TCI)', 1, 4, 4);
INSERT INTO TB_ITINERARIO(nome, codigo_linha, codigo_logradouro, ordem) VALUES ('Águas do Paiol / Terminal (TCI)', 1, 5, 5);
INSERT INTO TB_ITINERARIO(nome, codigo_linha, codigo_logradouro, ordem) VALUES ('Águas do Paiol / Terminal (TCI)', 1, 6, 6);
INSERT INTO TB_ITINERARIO(nome, codigo_linha, codigo_logradouro, ordem) VALUES ('Águas do Paiol / Terminal (TCI)', 1, 7, 7);
INSERT INTO TB_ITINERARIO(nome, codigo_linha, codigo_logradouro, ordem) VALUES ('Águas do Paiol / Terminal (TCI)', 1, 8, 8);
INSERT INTO TB_ITINERARIO(nome, codigo_linha, codigo_logradouro, ordem) VALUES ('Águas do Paiol / Terminal (TCI)', 1, 9, 9);
INSERT INTO TB_ITINERARIO(nome, codigo_linha, codigo_logradouro, ordem) VALUES ('Águas do Paiol / Terminal (TCI)', 1, 10, 10);
INSERT INTO TB_ITINERARIO(nome, codigo_linha, codigo_logradouro, ordem) VALUES ('Águas do Paiol / Terminal (TCI)', 1, 11, 11);
INSERT INTO TB_ITINERARIO(nome, codigo_linha, codigo_logradouro, ordem) VALUES ('Águas do Paiol / Terminal (TCI)', 1, 12, 12);

INSERT INTO TB_QUADRO_HORARIO(dia, horario_partida, codigo_linha) VALUES ('SEGUNDA', DATE_FORMAT('0001-01-01 05:00:00', '%H:%i'), 1);
INSERT INTO TB_QUADRO_HORARIO(dia, horario_partida, codigo_linha) VALUES ('TERÇA', DATE_FORMAT('0001-01-01 05:00:00', '%H:%i'), 1);
INSERT INTO TB_QUADRO_HORARIO(dia, horario_partida, codigo_linha) VALUES ('QUARTA', DATE_FORMAT('0001-01-01 05:00:00', '%H:%i'), 1);
INSERT INTO TB_QUADRO_HORARIO(dia, horario_partida, codigo_linha) VALUES ('QUINTA', DATE_FORMAT('0001-01-01 05:00:00', '%H:%i'), 1);
INSERT INTO TB_QUADRO_HORARIO(dia, horario_partida, codigo_linha) VALUES ('SEXTA', DATE_FORMAT('0001-01-01 05:00:00', '%H:%i'), 1);
INSERT INTO TB_QUADRO_HORARIO(dia, horario_partida, codigo_linha) VALUES ('SÁBADO', DATE_FORMAT('0001-01-01 05:00:00', '%H:%i'), 1);
INSERT INTO TB_QUADRO_HORARIO(dia, horario_partida, codigo_linha) VALUES ('DOMINGO', DATE_FORMAT('0001-01-01 05:05:00', '%H:%i'), 1);