CREATE TABLE Cad_Usuario (
    PK_ID       BIGINT PRIMARY KEY,
    NOME        VARCHAR(100) NOT NULL,
    LOGIN       VARCHAR(50) NOT NULL,
    SENHA       VARCHAR(255) NOT NULL,
    SETOR       VARCHAR(50),
    SOBRE_NOME  VARCHAR(80),
    PLANTA      VARCHAR(50),
    EMAIL       VARCHAR(255),
    UNIQUE (LOGIN)
);

CREATE SEQUENCE users_seq
    START 2
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE Cad_Usuario_Permissao (
    PK_ID           BIGINT PRIMARY KEY,
    FK_ID_USUARIO   INT,
    PERMISSAO       VARCHAR(50),
    CONSTRAINT FK_Cad_Usuario_Permissao FOREIGN KEY (FK_ID_USUARIO) REFERENCES Cad_Usuario(PK_ID) ON DELETE CASCADE
);

CREATE SEQUENCE permissions_seq
    START 18
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

INSERT INTO Cad_Usuario (PK_ID, NOME, LOGIN, SENHA, PLANTA) VALUES (1, 'DDZL7', 'admin', '$2a$10$xDjekR3Ts0vGaq02eu3DR.xAllgW2bl4IibHLnIVEcGJ9Wo7nWS/2', 'Varginha');

INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (1, 1, 'MenuRelatorio');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (2, 1, 'Validacao');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (3, 1, 'AlteracaoDados');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (4, 1, 'EntradaDadosEX');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (5, 1, 'EntradaDadosAC');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (6, 1, 'EntradaDadosSuperV');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (7, 1, 'CadastroFichaAC');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (8, 1, 'CadastroFichaEX');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (9, 1, 'PainelAlteracaoAC');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (10, 1, 'PainelAlteracaoEX');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (11, 1, 'PainelAlteracaoQU');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (12, 1, 'PainelAlteracaoAT');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (13, 1, 'MenuUsuario');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (14, 1, 'AcompanhamentoDDZ');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (15, 1, 'EntradaDadosInsp');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (16, 1, 'CadastroFichaInsp');
INSERT INTO Cad_Usuario_Permissao (PK_ID, FK_ID_USUARIO, PERMISSAO) VALUES (17, 1, 'PainelAlteracaoInsp');
