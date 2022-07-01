-- TABLE
CREATE TABLE aluno (id  integer, email varchar(255), nascimento date, nomeCompleto varchar(255), id_curso bigint, primary key (id));
CREATE TABLE curso (id  integer, nome varchar(255), sigla varchar(255), id_material bigint, id_professor bigint, primary key (id));
CREATE TABLE endereco (id  integer, bairro varchar(255), cep integer, cidade varchar(255), endereco varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), id_aluno bigint, primary key (id));
CREATE TABLE materialCurso (id  integer, url varchar(255), primary key (id));
CREATE TABLE professor (id  integer, email varchar(255), matricula varchar(255), nomeCompleto varchar(255), primary key (id));
CREATE TABLE telefone (id  integer, DDD varchar(255), numero varchar(255), id_aluno bigint, primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
