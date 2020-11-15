INSERT INTO carro(placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponivel) VALUES ('ABC123', 'ACME', 'M1', FALSE, FALSE, FALSE, TRUE);
INSERT INTO carro(placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponivel) VALUES ('ABC124', 'ACME', 'M2', TRUE, FALSE, FALSE, TRUE);
INSERT INTO carro(placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponivel) VALUES ('ABC125', 'ACME', 'M1', TRUE, TRUE, FALSE, TRUE);
INSERT INTO carro(placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponivel) VALUES ('ABC126', 'ACME', 'M2', TRUE, TRUE, TRUE, TRUE);
INSERT INTO carro(placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponivel) VALUES ('ABC127', 'ACME', 'M3', FALSE, FALSE, TRUE, TRUE);
INSERT INTO carro(placa, marca, modelo, arcondicionado, direcao, cambioautomatico, disponivel) VALUES ('ABC128', 'ACME', 'M4', TRUE, TRUE, TRUE, TRUE);

INSERT INTO locacao(id, inicio_locacao, fim_locacao, placa, marca, modelo, arcondicionado, direcao, cambioautomatico) VALUES (1, '2020-01-02 00:00:00', '2020-01-04 00:00:00', 'ABC128', 'ACME', 'M4', TRUE, TRUE, TRUE);
