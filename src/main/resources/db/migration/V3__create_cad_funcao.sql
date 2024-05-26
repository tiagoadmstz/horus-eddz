CREATE TABLE CAD_FUNCAO (
    ID                  BIGINT          PRIMARY KEY,
    DESCRICAO           VARCHAR(255)    NOT NULL
);

CREATE SEQUENCE function_seq
    START 2
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE CAD_FUNCAO_PARAMETRO (
    ID                  BIGINT          PRIMARY KEY,
    CODIGO              INT             NULL,
    PARAMETRO           VARCHAR(255)    NOT NULL,
    VALOR_PADRAO        VARCHAR(255)    NOT NULL,
    CONTEXTO            VARCHAR(4000)   NOT NULL,
    ID_CAD_FUNCAO       INT             NOT NULL,
    CONSTRAINT FK_CADFUNC_CADFUNCPAR FOREIGN KEY (ID_CAD_FUNCAO) REFERENCES CAD_FUNCAO(ID)
);

CREATE SEQUENCE func_param_seq
    START 2
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE CAD_FUNCAO_PARAM_ESTAB (
    ID                  BIGINT          PRIMARY KEY,
    ESTABELECIMENTO     VARCHAR(255)    NOT NULL,
    VALOR               VARCHAR(255)    NOT NULL,
    ID_CAD_FUNC_PARAM   INT             NOT NULL,
    CONSTRAINT FK_CADFUNCPAR_FNCPAREST FOREIGN KEY (ID_CAD_FUNC_PARAM) REFERENCES CAD_FUNCAO_PARAMETRO(ID)
);

CREATE SEQUENCE func_param_estab_seq
    START 1
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE CAD_FUNCAO_PARAM_PERFIL (
    ID                  BIGINT          PRIMARY KEY,
    PERFIL              VARCHAR(255)    NOT NULL,
    VALOR               VARCHAR(255)    NOT NULL,
    ID_CAD_FUNC_PARAM   INT             NOT NULL,
    CONSTRAINT FK_CADFUNCPAR_FNCPARPER FOREIGN KEY (ID_CAD_FUNC_PARAM) REFERENCES CAD_FUNCAO_PARAMETRO(ID)
);

CREATE SEQUENCE func_profile_param_seq
    START 2
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE CAD_FUNCAO_PARAM_USUARIO (
    ID                  BIGINT          PRIMARY KEY,
    USUARIO             VARCHAR(255)    NOT NULL,
    VALOR               VARCHAR(255)    NOT NULL,
    ID_CAD_FUNC_PARAM   INT             NOT NULL,
    CONSTRAINT FK_CADFUNCPAR_FNCPARUSR FOREIGN KEY (ID_CAD_FUNC_PARAM) REFERENCES CAD_FUNCAO_PARAMETRO(ID)
);

CREATE SEQUENCE func_param_user_seq
    START 1
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE OR REPLACE FUNCTION OBTER_RELATORIOS_SETOR (
    Setor varchar(255)
) RETURNS varchar(255) AS
$$
DECLARE
    ValorPadrao varchar(255);
    ValorPerfil varchar(255);
BEGIN
    SELECT MAX(VALOR_PADRAO) INTO ValorPadrao
    FROM CAD_FUNCAO_PARAMETRO
    WHERE PARAMETRO = Setor;

    SELECT MAX(VALOR) INTO ValorPerfil
    FROM CAD_FUNCAO_PARAM_PERFIL
    WHERE PERFIL = Setor;

    IF (ValorPerfil IS NOT NULL AND ValorPadrao = 'N' AND ValorPerfil <> 'T') THEN
        RETURN ValorPerfil;
    END IF;

    RETURN ValorPadrao;
END;
$$
LANGUAGE plpgsql;

INSERT INTO CAD_FUNCAO (ID, DESCRICAO) VALUES (1, 'Extrusão');

INSERT INTO CAD_FUNCAO_PARAMETRO (ID, CODIGO, PARAMETRO, VALOR_PADRAO, CONTEXTO, ID_CAD_FUNCAO) VALUES (1, 1, 'Extrusão', 'N', '', 1);

INSERT INTO CAD_FUNCAO_PARAM_PERFIL (ID, PERFIL, VALOR, ID_CAD_FUNC_PARAM) VALUES (1, 'Extrusão', '1,2,3,4,5,6,7,12', 1);
