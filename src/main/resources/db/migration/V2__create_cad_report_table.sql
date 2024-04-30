CREATE TABLE Report_Group (
    GRUPO BIGINT NOT NULL PRIMARY KEY,
    NOME  VARCHAR(150) NULL
);

CREATE SEQUENCE seq_report_group
    START 12
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE Report_Filter (
    FILTRO 	BIGINT 			NOT NULL PRIMARY KEY,
    NOME 	VARCHAR(80) 	NULL,
    ORDEM 	INT 			NULL,
    TIPO 	VARCHAR(50) 	NULL,
    VALOR 	VARCHAR(100) 	NULL
);

CREATE SEQUENCE seq_report_filter
    START 13
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE Cad_Report (
    RELATORIO 	BIGINT 			NOT NULL PRIMARY KEY,
    ATIVO 		BOOLEAN 		NULL,
    NOME 		VARCHAR(255) 	NULL,
    ORDEM 		INT				NULL,
    PASTA 		VARCHAR(2000)	NULL,
    SIGLA 		VARCHAR(7) 		NULL,
    TIPO 		VARCHAR(5) 		NULL,
    ID_GRUPO 	BIGINT			NULL,
    CONSTRAINT FK_Cad_Report_ID_GRUPO FOREIGN KEY (ID_GRUPO) REFERENCES Report_Group (GRUPO)
);

CREATE SEQUENCE seq_report
    START 24
    INCREMENT 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE Cad_Report_Report_Filter (
    Report_RELATORIO    BIGINT NOT NULL,
    filtros_FILTRO      BIGINT NOT NULL
);

CREATE TABLE Cad_Relatorios_Permissoes (
    Relatorio   BIGINT NOT NULL,
    Usuario     BIGINT NOT NULL
);

-- CADASTRO DE GRUPOS
INSERT INTO Report_Group (GRUPO, NOME) VALUES (1, '(Ext) Fluxo de Processo');
INSERT INTO Report_Group (GRUPO, NOME) VALUES (2, '(Ext) DDZ');
INSERT INTO Report_Group (GRUPO, NOME) VALUES (3, '(Ext) Velocidades');
INSERT INTO Report_Group (GRUPO, NOME) VALUES (4, '(Ext) Comprimentos');
INSERT INTO Report_Group (GRUPO, NOME) VALUES (5, '(Ext) Equipamento/Perfil');
INSERT INTO Report_Group (GRUPO, NOME) VALUES (6, '(Ext) Ficha de controle');
INSERT INTO Report_Group (GRUPO, NOME) VALUES (7, '(Ext) Plano de controle');
INSERT INTO Report_Group (GRUPO, NOME) VALUES (8, '(Insp) Ficha de controle');
INSERT INTO Report_Group (GRUPO, NOME) VALUES (9, '(Insp) Teste reprovados');
INSERT INTO Report_Group (GRUPO, NOME) VALUES (10, '(Insp) Busca por resultados');
INSERT INTO Report_Group (GRUPO, NOME) VALUES (11, '(Insp) Capabilidade');

-- CADASTRO DE RELATORIOS
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (1, TRUE, 'Fluxograma de processo', 'fluxograma.jasper', 'RDC0001', 'SQL', 1, 1);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (2, TRUE, 'DDZ rodada', 'ddzrodada.jasper', 'RDC0002', 'SQL', 2, 1);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (3, TRUE, 'Velocidade por linha', 'VelocidadePerfil.jasper', 'RDC0003', 'SQL', 3, 1);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (4, TRUE, 'Comprimento por linha', 'informativocomprimento.jasper', 'RDC0004', 'SQL', 4, 1);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (5, TRUE, 'Perfil por equipamento', 'perfilequipamento.jasper', 'RDC0005', 'SQL', 5, 1);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (6, TRUE, 'Equipamento por perfil', 'equipamentoperfil.jasper', 'RDC0006', 'SQL', 5, 2);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (7, TRUE, 'Extrusão', 'fichacontrole.jasper', 'RDC0007', 'SQL', 6, 1);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (8, TRUE, 'Extrusão', 'fichacontrole.jasper', 'RDC0008', 'SQL', 7, 1);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (9, TRUE, 'Top 5 R$', 'ddzTop_reais.jasper', 'RDC0009', 'SQL', 2, 2);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (10, TRUE, 'Teste registrado / perfil', 'insp_BTestePerfil.jasper', 'RDC0010', 'SQL', 10, 1);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (11, TRUE, 'Testes registrados / perfil', 'insp_BPerfil.jasper', 'RDC0011', 'SQL', 10, 2);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (12, TRUE, 'Relação dos testes por perfil', 'insp_BFicha.jasper', 'RDC0012', 'SQL', 8, 1);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (13, TRUE, 'Testes reprovados', 'insp_BTesteReprovado.jasper', 'RDC0013', 'SQL', 9, 1);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (14, TRUE, 'Testes reprovados por período', 'insp_BQTDReprovado.jasper', 'RDC0014', 'SQL', 9, 2);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (15, TRUE, 'Qtd. testes por turno', 'insp_QtdTesteTurno.jasper', 'RDC0015', 'SQL', 10, 3);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (16, TRUE, 'Testes reprovados por data', 'insp_BTesteReprovadoData.jasper', 'RDC0016', 'SQL', 9, 3);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (17, TRUE, 'Testes por hora', 'insp_BTesteHora.jasper', 'RDC0017', 'SQL', 10, 4);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (18, TRUE, 'Re-Teste', 'insp_BReTeste.jasper', 'RDC0018', 'SQL', 10, 5);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (19, TRUE, 'Peso por metro por perfil', 'insp_BPesoMetro.jasper', 'RDC0019', 'SQL', 10, 6);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (20, TRUE, 'Carta CEP', 'insp_GraficoCep.jasper', 'RDC0020', 'SQL', 11, 1);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (21, TRUE, 'Perfis produzidos por período', 'insp_BPerfilProduzido.jasper', 'RDC0021', 'SQL', 10, 7);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (22, TRUE, 'DDZ rodada (evidência)', 'ddzevidencia.jasper', 'RDC0022', 'SQL', 2, 3);
INSERT INTO Cad_Report (RELATORIO, ATIVO, NOME, PASTA, SIGLA, TIPO, ID_GRUPO, ORDEM) VALUES (23, TRUE, 'Listagem de Lançamentos', 'ddzlancamento.jasper', 'RDC0023', 'SQL', 2, 4);

-- CADASTRO DE FILTROS
INSERT INTO Report_Filter (FILTRO, NOME, TIPO, ORDEM) VALUES (1, 'Datas', 'datas', 1);
INSERT INTO Report_Filter (FILTRO, NOME, TIPO, ORDEM) VALUES (2, 'Ordenação', 'combobox', 2);
INSERT INTO Report_Filter (FILTRO, NOME, TIPO, ORDEM) VALUES (3, 'Linha', 'combobox', 3);
INSERT INTO Report_Filter (FILTRO, NOME, TIPO, ORDEM) VALUES (4, 'Perfil', 'combobox', 4);
INSERT INTO Report_Filter (FILTRO, NOME, TIPO, ORDEM) VALUES (5, 'Lançamentos', 'combobox', 5);
INSERT INTO Report_Filter (FILTRO, NOME, TIPO, ORDEM) VALUES (6, 'Formato', 'combobox', 6);
INSERT INTO Report_Filter (FILTRO, NOME, TIPO, ORDEM) VALUES (7, 'Equipamento', 'combobox', 7);
INSERT INTO Report_Filter (FILTRO, NOME, TIPO, ORDEM) VALUES (8, 'Tipo de teste', 'combobox', 8);
INSERT INTO Report_Filter (FILTRO, NOME, TIPO, ORDEM) VALUES (9, 'Teste', 'combobox', 9);
INSERT INTO Report_Filter (FILTRO, NOME, TIPO, ORDEM) VALUES (10, 'Horas', 'horas', 10);
INSERT INTO Report_Filter (FILTRO, NOME, TIPO, ORDEM) VALUES (11, 'texto', 'texto', 11);
INSERT INTO Report_Filter (FILTRO, NOME, TIPO, ORDEM) VALUES (12, 'Entrada/Parada', 'combobox', 12);

-- RELACIONAMENTOSxR
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (1, 3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (1, 4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (2, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (2, 3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (2, 4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (2, 5);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (2, 6);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (3, 3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (4, 3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (5, 3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (5, 4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (6, 7);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (7, 3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (7, 4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (9, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (9, 3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (10, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (10, 2);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (10, 4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (10, 8);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (10, 9);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (11, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (11, 2);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (11, 4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (11, 8);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (12, 2);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (12, 4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (13, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (13, 10);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (14, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (15, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (16, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (17, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (17, 10);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (18, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (18, 2);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (18, 4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (18, 2);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (19, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (20, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (20, 2);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (20, 4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (20, 9);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (21, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (22, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (22, 3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (22, 4);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (22, 5);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (22, 6);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (22, 11);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (23, 1);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (23, 3);
INSERT INTO Cad_Report_Report_Filter (Report_RELATORIO, filtros_FILTRO) VALUES (23, 12);

-- PERMISSÃO DE USUÁRIO
INSERT INTO Cad_Relatorios_Permissoes (Relatorio, Usuario) VALUES(1, 1);
