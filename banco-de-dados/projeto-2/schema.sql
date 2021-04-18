CREATE TABLE TB_EMPRESA (
    nome VARCHAR(255) PRIMARY KEY,
    endereco VARCHAR(255),
    telefone VARCHAR(255),
    website VARCHAR(255)
);

CREATE TABLE TB_LINHA (
    codigo int PRIMARY KEY,
    nome VARCHAR(255)
);

CREATE TABLE TB_QUADRO_HORARIO (
    dia VARCHAR(12),
    horario_partida TIME,
    codigo_linha int,
    PRIMARY KEY (dia, horario_partida, codigo_linha)
);

CREATE TABLE TB_LOGRADOURO (
    codigo int PRIMARY KEY,
    nome VARCHAR(255)
);

CREATE TABLE TB_EMPRESA_LINHA (
    nome_empresa VARCHAR(255),
    codigo_linha int,
    PRIMARY KEY (nome_empresa, codigo_linha)
);

CREATE TABLE TB_ITINERARIO (
    codigo_linha int,
    codigo_logradouro int,
    ordem int,
    nome VARCHAR(255),
    PRIMARY KEY (ordem, nome, codigo_linha, codigo_logradouro)
);
 
ALTER TABLE TB_QUADRO_HORARIO ADD CONSTRAINT FK_TB_QUADRO_HORARIO_2
    FOREIGN KEY (codigo_linha)
    REFERENCES TB_LINHA (codigo)
    ON DELETE CASCADE;
 
ALTER TABLE TB_EMPRESA_LINHA ADD CONSTRAINT FK_TB_EMPRESA_LINHA_1
    FOREIGN KEY (nome_empresa)
    REFERENCES TB_EMPRESA (nome)
    ON DELETE CASCADE;
 
ALTER TABLE TB_EMPRESA_LINHA ADD CONSTRAINT FK_TB_EMPRESA_LINHA_2
    FOREIGN KEY (codigo_linha)
    REFERENCES TB_LINHA (codigo)
    ON DELETE CASCADE;
 
ALTER TABLE TB_ITINERARIO ADD CONSTRAINT FK_Itinerario_2
    FOREIGN KEY (codigo_linha)
    REFERENCES TB_LINHA (codigo)
    ON DELETE CASCADE;
 
ALTER TABLE TB_ITINERARIO ADD CONSTRAINT FK_Itinerario_3
    FOREIGN KEY (codigo_logradouro)
    REFERENCES TB_LOGRADOURO (codigo)
    ON DELETE CASCADE;