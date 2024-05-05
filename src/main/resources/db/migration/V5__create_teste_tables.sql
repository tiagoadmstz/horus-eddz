CREATE TABLE Cad_Metodo_Avaliacao (
    ID          BIGINT PRIMARY KEY,
    DESC_METODO VARCHAR(50) NOT NULL,
    SETOR       VARCHAR(50),
    UNIQUE (DESC_METODO)
);

CREATE SEQUENCE evaluation_method_seq
    START 1
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE Cad_Controle_Processo (
    ID                  BIGINT PRIMARY KEY,
    DESC_CONTROLE       VARCHAR(255) NOT NULL,
    METODO_AVALIACAO    VARCHAR(50)  NULL,
    PREVENT_DETECT      VARCHAR(10)  NULL,
    SETOR               VARCHAR(50)  NULL,
    UNIQUE (DESC_CONTROLE),
    FOREIGN KEY (METODO_AVALIACAO) REFERENCES Cad_Metodo_Avaliacao (DESC_METODO)
);

CREATE SEQUENCE process_control_seq
    START 1
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE Cad_Operacao (
    ID_OPERACAO          BIGINT PRIMARY KEY,
    OPERACAO             VARCHAR(255) NOT NULL,
    ORDEM                INT          NULL,
    OPE_SETOR            VARCHAR(50)  NULL,
    COD_OP               INT          NULL,
    CLIENTE              VARCHAR(50)  NULL,
    COD_SIMBOL_OP        VARCHAR(50)  NULL,
    FORNECEDOR           VARCHAR(50)  NULL,
    PREPARADO_POR        VARCHAR(50)  NULL,
    TELEFONE             VARCHAR(50)  NULL,
    RESPONSAVEL_PROCESSO VARCHAR(50)  NULL,
    EQUIPE               VARCHAR(300) NULL,
    DATA_CRIACAO         VARCHAR(10)  NULL,
    UNIQUE (OPERACAO)
);

CREATE SEQUENCE operation_seq
    START 1
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE Cad_Equipamento (
    ID_EQUIPAMENTO  BIGINT PRIMARY KEY,
    EQUIPAMENTO     VARCHAR(255) NOT NULL,
    EQU_OPERACAO    VARCHAR(255) NULL,
    ORDEM           INT          NULL,
    UNIQUE (EQUIPAMENTO),
    FOREIGN KEY (EQU_OPERACAO) REFERENCES Cad_Operacao (OPERACAO)
);

CREATE SEQUENCE equipment_seq
    START 1
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE Cad_Teste (
    ID_TESTE          BIGINT PRIMARY KEY,
    COD_TESTE         VARCHAR(50)  NOT NULL,
    DESC_TESTE        VARCHAR(255) NULL,
    ORDEM             INT          NULL,
    TES_EQUIPAMENTO   VARCHAR(255) NULL,
    CONTROL_PRCESS    VARCHAR(255) NULL,
    CLASSIFICACAO     VARCHAR(50)  NULL,
    FOREIGN KEY (CONTROL_PRCESS) REFERENCES Cad_Controle_Processo (DESC_CONTROLE),
    FOREIGN KEY (TES_EQUIPAMENTO) REFERENCES Cad_Equipamento (EQUIPAMENTO)
);

CREATE SEQUENCE test_seq
    START 1
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
