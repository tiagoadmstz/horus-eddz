CREATE TABLE Cad_Linha (
    ID_LINHA            BIGINT          NOT NULL PRIMARY KEY,
    ORDEM               INT             NULL,
    LINHA               VARCHAR(50)     NOT NULL,
    TIPO_LINHA          VARCHAR(50)     NULL,
    SETOR               VARCHAR(50)     NULL,
    N_PLANO             VARCHAR(50)     NULL,
    CONTATO_CHAVE       VARCHAR(100)    NULL,
    EQUIPE_PRINCIPAL    VARCHAR(100)    NULL,
    DATA_INICIAL        VARCHAR(50)     NULL,
    UNIQUE (LINHA)
);

CREATE SEQUENCE line_seq
    START 16
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

INSERT INTO Cad_Linha (ID_LINHA, ORDEM, LINHA, TIPO_LINHA, SETOR, N_PLANO, CONTATO_CHAVE, EQUIPE_PRINCIPAL, DATA_INICIAL)
VALUES
(1, 1, 'L01', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(2, 2, 'L03', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(3, 3, 'L03ATB', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(4, 4, 'L04ATB', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(5, 5, 'L05', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(6, 6, 'L10', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(7, 7, 'L13', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(8, 8, 'L14', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(9, 9, 'L16', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(10, 10, 'Carrossel 37', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(11, 11, 'Carrossel 153', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(12, 12, 'Carrossel 197', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(13, 13, 'L07', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(14, 14, 'L08', NULL, 'Extrusão', NULL, NULL, NULL, NULL),
(15, 15, 'L09', NULL, 'Extrusão', NULL, NULL, NULL, NULL);
