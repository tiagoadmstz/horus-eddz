CREATE TABLE Cad_Usuario_Permissao (
    PK_ID           SERIAL PRIMARY KEY,
    FK_ID_USUARIO   INT,
    PERMISSAO       VARCHAR(50),
    CONSTRAINT FK_Cad_Usuario_Permissao FOREIGN KEY (FK_ID_USUARIO) REFERENCES Cad_Usuario(PK_ID) ON DELETE CASCADE
);

INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'MenuRelatorio');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'Validacao');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'AlteracaoDados');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'EntradaDadosEX');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'EntradaDadosAC');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'EntradaDadosSuperV');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'CadastroFichaAC');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'CadastroFichaEX');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'PainelAlteracaoAC');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'PainelAlteracaoEX');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'PainelAlteracaoQU');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'PainelAlteracaoAT');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'MenuUsuario');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'AcompanhamentoDDZ');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'EntradaDadosInsp');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'CadastroFichaInsp');
INSERT INTO Cad_Usuario_Permissao (FK_ID_USUARIO, PERMISSAO) VALUES (1, 'PainelAlteracaoInsp');
