-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.21 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             8.1.0.4545
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for gaed
DROP DATABASE IF EXISTS `gaed`;
CREATE DATABASE IF NOT EXISTS `gaed` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gaed`;


-- Dumping structure for table gaed.aluno
DROP TABLE IF EXISTS `aluno`;
CREATE TABLE IF NOT EXISTS `aluno` (
  `idAluno` int(11) NOT NULL AUTO_INCREMENT,
  `escolaAnterior` varchar(100) DEFAULT NULL,
  `serieAnterior` varchar(100) DEFAULT NULL,
  `escolaAtual` varchar(100) DEFAULT NULL,
  `serieAtual` varchar(100) DEFAULT NULL,
  `Responsavel_idResponsavel` int(11) NOT NULL,
  PRIMARY KEY (`idAluno`),
  KEY `fk_Aluno_Responsavel1_idx` (`Responsavel_idResponsavel`),
  CONSTRAINT `fk_Aluno_Responsavel1` FOREIGN KEY (`Responsavel_idResponsavel`) REFERENCES `responsavel` (`idResponsavel`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.aluno_has_usuario
DROP TABLE IF EXISTS `aluno_has_usuario`;
CREATE TABLE IF NOT EXISTS `aluno_has_usuario` (
  `Aluno_idAluno` int(11) NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  `Usuario_Logradouro_idLogradouro` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_idBairro` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_idMunicipio` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_UF_idUF` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_UF_idUF1` int(11) NOT NULL,
  PRIMARY KEY (`Aluno_idAluno`,`Usuario_idUsuario`,`Usuario_Logradouro_idLogradouro`,`Usuario_Logradouro_Bairro_idBairro`,`Usuario_Logradouro_Bairro_Municipio_idMunicipio`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF1`),
  KEY `fk_Aluno_has_Usuario_Usuario1_idx` (`Usuario_idUsuario`,`Usuario_Logradouro_idLogradouro`,`Usuario_Logradouro_Bairro_idBairro`,`Usuario_Logradouro_Bairro_Municipio_idMunicipio`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF1`),
  KEY `fk_Aluno_has_Usuario_Aluno1_idx` (`Aluno_idAluno`),
  CONSTRAINT `fk_Aluno_has_Usuario_Aluno1` FOREIGN KEY (`Aluno_idAluno`) REFERENCES `aluno` (`idAluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_has_Usuario_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.bairro
DROP TABLE IF EXISTS `bairro`;
CREATE TABLE IF NOT EXISTS `bairro` (
  `idBairro` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) DEFAULT NULL,
  `Municipio_idMunicipio` int(11) NOT NULL,
  PRIMARY KEY (`idBairro`),
  KEY `fk_Bairro_Municipio1_idx` (`Municipio_idMunicipio`),
  CONSTRAINT `fk_Bairro_Municipio1` FOREIGN KEY (`Municipio_idMunicipio`) REFERENCES `municipio` (`idMunicipio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.bimestre
DROP TABLE IF EXISTS `bimestre`;
CREATE TABLE IF NOT EXISTS `bimestre` (
  `idBimestre` int(11) NOT NULL AUTO_INCREMENT,
  `nomeBimestre` varchar(45) DEFAULT NULL,
  `datainicio` date DEFAULT NULL,
  `datafinal` date DEFAULT NULL,
  PRIMARY KEY (`idBimestre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.boletim
DROP TABLE IF EXISTS `boletim`;
CREATE TABLE IF NOT EXISTS `boletim` (
  `idBoletim` int(11) NOT NULL AUTO_INCREMENT,
  `Bimestre_idBimestre` int(11) NOT NULL,
  PRIMARY KEY (`idBoletim`),
  KEY `fk_Boletim_Bimestre1_idx` (`Bimestre_idBimestre`),
  CONSTRAINT `fk_Boletim_Bimestre1` FOREIGN KEY (`Bimestre_idBimestre`) REFERENCES `bimestre` (`idBimestre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.boletim_aluno_turma_disciplina
DROP TABLE IF EXISTS `boletim_aluno_turma_disciplina`;
CREATE TABLE IF NOT EXISTS `boletim_aluno_turma_disciplina` (
  `matricula_Aluno_Turma_Turma_idTurma` int(11) NOT NULL,
  `matricula_Aluno_Turma_Aluno_idAluno` int(11) NOT NULL,
  `Boletim_idBoletim` int(11) NOT NULL,
  `Disciplina_idDisciplina` int(11) NOT NULL,
  `nota` float DEFAULT NULL,
  `faltas` int(11) DEFAULT NULL,
  PRIMARY KEY (`matricula_Aluno_Turma_Turma_idTurma`,`matricula_Aluno_Turma_Aluno_idAluno`,`Boletim_idBoletim`),
  KEY `fk_matricula_Aluno_Turma_has_Boletim_Boletim1_idx` (`Boletim_idBoletim`),
  KEY `fk_matricula_Aluno_Turma_has_Boletim_matricula_Aluno_Turma1_idx` (`matricula_Aluno_Turma_Turma_idTurma`,`matricula_Aluno_Turma_Aluno_idAluno`),
  KEY `fk_boletim_Aluno_Turma_Disciplina_Disciplina1_idx` (`Disciplina_idDisciplina`),
  CONSTRAINT `fk_boletim_Aluno_Turma_Disciplina_Disciplina1` FOREIGN KEY (`Disciplina_idDisciplina`) REFERENCES `disciplina` (`idDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_Aluno_Turma_has_Boletim_Boletim1` FOREIGN KEY (`Boletim_idBoletim`) REFERENCES `boletim` (`idBoletim`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_Aluno_Turma_has_Boletim_matricula_Aluno_Turma1` FOREIGN KEY (`matricula_Aluno_Turma_Turma_idTurma`, `matricula_Aluno_Turma_Aluno_idAluno`) REFERENCES `matricula_aluno_turma` (`Turma_idTurma`, `Aluno_idAluno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.boletim_has_ministra
DROP TABLE IF EXISTS `boletim_has_ministra`;
CREATE TABLE IF NOT EXISTS `boletim_has_ministra` (
  `nota` float DEFAULT NULL,
  `faltas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.disciplina
DROP TABLE IF EXISTS `disciplina`;
CREATE TABLE IF NOT EXISTS `disciplina` (
  `idDisciplina` int(11) NOT NULL AUTO_INCREMENT,
  `nomeDisciplina` varchar(45) DEFAULT NULL,
  `conteudoDisciplina` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idDisciplina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.foto
DROP TABLE IF EXISTS `foto`;
CREATE TABLE IF NOT EXISTS `foto` (
  `idFoto` int(11) NOT NULL AUTO_INCREMENT,
  `foto` blob,
  `nomeFoto` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idFoto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.gera_boletim_turma
DROP TABLE IF EXISTS `gera_boletim_turma`;
CREATE TABLE IF NOT EXISTS `gera_boletim_turma` (
  `Boletim_idBoletim` int(11) NOT NULL,
  `Turma_idTurma` int(11) NOT NULL,
  PRIMARY KEY (`Boletim_idBoletim`,`Turma_idTurma`),
  KEY `fk_Boletim_has_Turma_Turma1_idx` (`Turma_idTurma`),
  KEY `fk_Boletim_has_Turma_Boletim1_idx` (`Boletim_idBoletim`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.gestor
DROP TABLE IF EXISTS `gestor`;
CREATE TABLE IF NOT EXISTS `gestor` (
  `idGestor` int(11) NOT NULL AUTO_INCREMENT,
  `formacaoAcademica` varchar(1000) DEFAULT NULL,
  `instituicaoAcademica` varchar(1000) DEFAULT NULL,
  `anoConclusao` date DEFAULT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idGestor`),
  KEY `fk_Gestor_Usuario1_idx` (`Usuario_idUsuario`),
  CONSTRAINT `fk_Gestor_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.gestor_has_usuario
DROP TABLE IF EXISTS `gestor_has_usuario`;
CREATE TABLE IF NOT EXISTS `gestor_has_usuario` (
  `Gestor_idGestor` int(11) NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  `Usuario_Logradouro_idLogradouro` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_idBairro` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_idMunicipio` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_UF_idUF` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_UF_idUF1` int(11) NOT NULL,
  PRIMARY KEY (`Gestor_idGestor`,`Usuario_idUsuario`,`Usuario_Logradouro_idLogradouro`,`Usuario_Logradouro_Bairro_idBairro`,`Usuario_Logradouro_Bairro_Municipio_idMunicipio`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF1`),
  KEY `fk_Gestor_has_Usuario_Usuario1_idx` (`Usuario_idUsuario`,`Usuario_Logradouro_idLogradouro`,`Usuario_Logradouro_Bairro_idBairro`,`Usuario_Logradouro_Bairro_Municipio_idMunicipio`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF1`),
  KEY `fk_Gestor_has_Usuario_Gestor1_idx` (`Gestor_idGestor`),
  CONSTRAINT `fk_Gestor_has_Usuario_Gestor1` FOREIGN KEY (`Gestor_idGestor`) REFERENCES `gestor` (`idGestor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Gestor_has_Usuario_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.leciona
DROP TABLE IF EXISTS `leciona`;
CREATE TABLE IF NOT EXISTS `leciona` (
  `Turma_idTurma` int(11) NOT NULL,
  `Professor_has_Disciplina_Professor_idProfessor` int(11) NOT NULL,
  `Professor_has_Disciplina_Disciplina_idDisciplina` int(11) NOT NULL,
  PRIMARY KEY (`Turma_idTurma`,`Professor_has_Disciplina_Professor_idProfessor`,`Professor_has_Disciplina_Disciplina_idDisciplina`),
  KEY `fk_Turma_has_Professor_has_Disciplina_Professor_has_Discipl_idx` (`Professor_has_Disciplina_Professor_idProfessor`,`Professor_has_Disciplina_Disciplina_idDisciplina`),
  KEY `fk_Turma_has_Professor_has_Disciplina_Turma1_idx` (`Turma_idTurma`),
  CONSTRAINT `fk_Turma_has_Professor_has_Disciplina_Professor_has_Disciplina1` FOREIGN KEY (`Professor_has_Disciplina_Professor_idProfessor`, `Professor_has_Disciplina_Disciplina_idDisciplina`) REFERENCES `ministra` (`Professor_idProfessor`, `Disciplina_idDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.lecionaturmaprofessordisciplina
DROP TABLE IF EXISTS `lecionaturmaprofessordisciplina`;
CREATE TABLE IF NOT EXISTS `lecionaturmaprofessordisciplina` (
  `Turma_idTurma` int(11) NOT NULL,
  `Turma_Serie_idSerie` int(11) NOT NULL,
  `Turma_Periodo_idPeriodo` int(11) NOT NULL,
  `ministraDisciplinaProfessor_Disciplina_idDisciplina` int(11) NOT NULL,
  `ministraDisciplinaProfessor_Professor_idProfessor` int(11) NOT NULL,
  PRIMARY KEY (`Turma_idTurma`,`Turma_Serie_idSerie`,`Turma_Periodo_idPeriodo`,`ministraDisciplinaProfessor_Disciplina_idDisciplina`,`ministraDisciplinaProfessor_Professor_idProfessor`),
  KEY `fk_Turma_has_ministraDisciplinaProfessor_ministraDisciplina_idx` (`ministraDisciplinaProfessor_Disciplina_idDisciplina`,`ministraDisciplinaProfessor_Professor_idProfessor`),
  KEY `fk_Turma_has_ministraDisciplinaProfessor_Turma1_idx` (`Turma_idTurma`,`Turma_Serie_idSerie`,`Turma_Periodo_idPeriodo`),
  CONSTRAINT `fk_Turma_has_ministraDisciplinaProfessor_Turma1` FOREIGN KEY (`Turma_idTurma`, `Turma_Serie_idSerie`, `Turma_Periodo_idPeriodo`) REFERENCES `turma` (`idTurma`, `Serie_idSerie`, `Periodo_idPeriodo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Turma_has_ministraDisciplinaProfessor_ministraDisciplinaPr1` FOREIGN KEY (`ministraDisciplinaProfessor_Disciplina_idDisciplina`, `ministraDisciplinaProfessor_Professor_idProfessor`) REFERENCES `ministradisciplinaprofessor` (`Disciplina_idDisciplina`, `Professor_idProfessor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.logradouro
DROP TABLE IF EXISTS `logradouro`;
CREATE TABLE IF NOT EXISTS `logradouro` (
  `idLogradouro` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(1000) DEFAULT NULL,
  `CEP` varchar(100) DEFAULT NULL,
  `Bairro_idBairro` int(11) NOT NULL,
  PRIMARY KEY (`idLogradouro`),
  KEY `fk_Logradouro_Bairro1_idx` (`Bairro_idBairro`),
  CONSTRAINT `fk_Logradouro_Bairro1` FOREIGN KEY (`Bairro_idBairro`) REFERENCES `bairro` (`idBairro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.matricula_aluno_turma
DROP TABLE IF EXISTS `matricula_aluno_turma`;
CREATE TABLE IF NOT EXISTS `matricula_aluno_turma` (
  `Turma_idTurma` int(11) NOT NULL,
  `Aluno_idAluno` int(11) NOT NULL,
  PRIMARY KEY (`Turma_idTurma`,`Aluno_idAluno`),
  KEY `fk_Turma_has_Aluno_Aluno1_idx` (`Aluno_idAluno`),
  KEY `fk_Turma_has_Aluno_Turma_idx` (`Turma_idTurma`),
  CONSTRAINT `fk_Turma_has_Aluno_Aluno1` FOREIGN KEY (`Aluno_idAluno`) REFERENCES `aluno` (`idAluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Turma_has_Aluno_Turma` FOREIGN KEY (`Turma_idTurma`) REFERENCES `turma` (`idTurma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.ministra
DROP TABLE IF EXISTS `ministra`;
CREATE TABLE IF NOT EXISTS `ministra` (
  `Professor_idProfessor` int(11) NOT NULL,
  `Disciplina_idDisciplina` int(11) NOT NULL,
  PRIMARY KEY (`Professor_idProfessor`,`Disciplina_idDisciplina`),
  KEY `fk_Professor_has_Disciplina_Disciplina1_idx` (`Disciplina_idDisciplina`),
  KEY `fk_Professor_has_Disciplina_Professor1_idx` (`Professor_idProfessor`),
  CONSTRAINT `fk_Professor_has_Disciplina_Disciplina1` FOREIGN KEY (`Disciplina_idDisciplina`) REFERENCES `disciplina` (`idDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Professor_has_Disciplina_Professor1` FOREIGN KEY (`Professor_idProfessor`) REFERENCES `professor` (`idProfessor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.ministradisciplinaprofessor
DROP TABLE IF EXISTS `ministradisciplinaprofessor`;
CREATE TABLE IF NOT EXISTS `ministradisciplinaprofessor` (
  `Disciplina_idDisciplina` int(11) NOT NULL,
  `Professor_idProfessor` int(11) NOT NULL,
  PRIMARY KEY (`Disciplina_idDisciplina`,`Professor_idProfessor`),
  KEY `fk_Disciplina_has_Professor_Professor1_idx` (`Professor_idProfessor`),
  KEY `fk_Disciplina_has_Professor_Disciplina1_idx` (`Disciplina_idDisciplina`),
  CONSTRAINT `fk_Disciplina_has_Professor_Disciplina1` FOREIGN KEY (`Disciplina_idDisciplina`) REFERENCES `disciplina` (`idDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Disciplina_has_Professor_Professor1` FOREIGN KEY (`Professor_idProfessor`) REFERENCES `professor` (`idProfessor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.municipio
DROP TABLE IF EXISTS `municipio`;
CREATE TABLE IF NOT EXISTS `municipio` (
  `idMunicipio` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `UF_idUF` int(11) NOT NULL,
  PRIMARY KEY (`idMunicipio`),
  KEY `fk_Municipio_UF1_idx` (`UF_idUF`),
  CONSTRAINT `fk_Municipio_UF1` FOREIGN KEY (`UF_idUF`) REFERENCES `uf` (`idUF`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.ocorrencia
DROP TABLE IF EXISTS `ocorrencia`;
CREATE TABLE IF NOT EXISTS `ocorrencia` (
  `idOcorrencia` int(11) NOT NULL AUTO_INCREMENT,
  `assuntoOcorrencia` varchar(200) DEFAULT NULL,
  `dataOcorrencia` date DEFAULT NULL,
  `descricaoOcorrencia` varchar(2000) DEFAULT NULL,
  `Aluno_idAluno` int(11) NOT NULL,
  PRIMARY KEY (`idOcorrencia`),
  KEY `fk_Ocorrencia_Aluno1_idx` (`Aluno_idAluno`),
  CONSTRAINT `fk_Ocorrencia_Aluno1` FOREIGN KEY (`Aluno_idAluno`) REFERENCES `aluno` (`idAluno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.periodo
DROP TABLE IF EXISTS `periodo`;
CREATE TABLE IF NOT EXISTS `periodo` (
  `idPeriodo` int(11) NOT NULL AUTO_INCREMENT,
  `periodo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPeriodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.professor
DROP TABLE IF EXISTS `professor`;
CREATE TABLE IF NOT EXISTS `professor` (
  `idProfessor` int(11) NOT NULL AUTO_INCREMENT,
  `escolaAnterior` varchar(500) DEFAULT NULL,
  `formacaoAcademica` varchar(500) DEFAULT NULL,
  `instituicaoAcademica` varchar(500) DEFAULT NULL,
  `anoConclusao` date DEFAULT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idProfessor`),
  KEY `fk_Professor_Usuario1_idx` (`Usuario_idUsuario`),
  CONSTRAINT `fk_Professor_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.professor_has_usuario
DROP TABLE IF EXISTS `professor_has_usuario`;
CREATE TABLE IF NOT EXISTS `professor_has_usuario` (
  `Professor_idProfessor` int(11) NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  `Usuario_Logradouro_idLogradouro` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_idBairro` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_idMunicipio` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_UF_idUF` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_UF_idUF1` int(11) NOT NULL,
  PRIMARY KEY (`Professor_idProfessor`,`Usuario_idUsuario`,`Usuario_Logradouro_idLogradouro`,`Usuario_Logradouro_Bairro_idBairro`,`Usuario_Logradouro_Bairro_Municipio_idMunicipio`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF1`),
  KEY `fk_Professor_has_Usuario_Usuario1_idx` (`Usuario_idUsuario`,`Usuario_Logradouro_idLogradouro`,`Usuario_Logradouro_Bairro_idBairro`,`Usuario_Logradouro_Bairro_Municipio_idMunicipio`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF1`),
  KEY `fk_Professor_has_Usuario_Professor1_idx` (`Professor_idProfessor`),
  CONSTRAINT `fk_Professor_has_Usuario_Professor1` FOREIGN KEY (`Professor_idProfessor`) REFERENCES `professor` (`idProfessor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Professor_has_Usuario_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.responsavel
DROP TABLE IF EXISTS `responsavel`;
CREATE TABLE IF NOT EXISTS `responsavel` (
  `idResponsavel` int(11) NOT NULL AUTO_INCREMENT,
  `Adimplente` tinyint(1) DEFAULT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idResponsavel`),
  KEY `fk_Responsavel_Usuario1_idx` (`Usuario_idUsuario`),
  CONSTRAINT `fk_Responsavel_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.responsavel_has_usuario
DROP TABLE IF EXISTS `responsavel_has_usuario`;
CREATE TABLE IF NOT EXISTS `responsavel_has_usuario` (
  `Responsavel_idResponsavel` int(11) NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  `Usuario_Logradouro_idLogradouro` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_idBairro` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_idMunicipio` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_UF_idUF` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_UF_idUF1` int(11) NOT NULL,
  PRIMARY KEY (`Responsavel_idResponsavel`,`Usuario_idUsuario`,`Usuario_Logradouro_idLogradouro`,`Usuario_Logradouro_Bairro_idBairro`,`Usuario_Logradouro_Bairro_Municipio_idMunicipio`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF1`),
  KEY `fk_Responsavel_has_Usuario_Usuario1_idx` (`Usuario_idUsuario`,`Usuario_Logradouro_idLogradouro`,`Usuario_Logradouro_Bairro_idBairro`,`Usuario_Logradouro_Bairro_Municipio_idMunicipio`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF1`),
  KEY `fk_Responsavel_has_Usuario_Responsavel1_idx` (`Responsavel_idResponsavel`),
  CONSTRAINT `fk_Responsavel_has_Usuario_Responsavel1` FOREIGN KEY (`Responsavel_idResponsavel`) REFERENCES `responsavel` (`idResponsavel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Responsavel_has_Usuario_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.secretaria
DROP TABLE IF EXISTS `secretaria`;
CREATE TABLE IF NOT EXISTS `secretaria` (
  `idSecretaria` int(11) NOT NULL AUTO_INCREMENT,
  `experienciaAnterior` varchar(1000) DEFAULT NULL,
  `instituicaoAnterior` varchar(1000) DEFAULT NULL,
  `formacaoAcademica` varchar(1000) DEFAULT NULL,
  `instituicaoAcademica` varchar(1000) DEFAULT NULL,
  `anoConclusao` date DEFAULT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idSecretaria`),
  KEY `fk_Secretaria_Usuario1_idx` (`Usuario_idUsuario`),
  CONSTRAINT `fk_Secretaria_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.secretaria_has_usuario
DROP TABLE IF EXISTS `secretaria_has_usuario`;
CREATE TABLE IF NOT EXISTS `secretaria_has_usuario` (
  `Secretaria_idSecretaria` int(11) NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  `Usuario_Logradouro_idLogradouro` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_idBairro` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_idMunicipio` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_UF_idUF` int(11) NOT NULL,
  `Usuario_Logradouro_Bairro_Municipio_UF_idUF1` int(11) NOT NULL,
  PRIMARY KEY (`Secretaria_idSecretaria`,`Usuario_idUsuario`,`Usuario_Logradouro_idLogradouro`,`Usuario_Logradouro_Bairro_idBairro`,`Usuario_Logradouro_Bairro_Municipio_idMunicipio`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF1`),
  KEY `fk_Secretaria_has_Usuario_Usuario1_idx` (`Usuario_idUsuario`,`Usuario_Logradouro_idLogradouro`,`Usuario_Logradouro_Bairro_idBairro`,`Usuario_Logradouro_Bairro_Municipio_idMunicipio`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF`,`Usuario_Logradouro_Bairro_Municipio_UF_idUF1`),
  KEY `fk_Secretaria_has_Usuario_Secretaria1_idx` (`Secretaria_idSecretaria`),
  CONSTRAINT `fk_Secretaria_has_Usuario_Secretaria1` FOREIGN KEY (`Secretaria_idSecretaria`) REFERENCES `secretaria` (`idSecretaria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Secretaria_has_Usuario_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.serie
DROP TABLE IF EXISTS `serie`;
CREATE TABLE IF NOT EXISTS `serie` (
  `idSerie` int(11) NOT NULL AUTO_INCREMENT,
  `periodo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSerie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.tarefa
DROP TABLE IF EXISTS `tarefa`;
CREATE TABLE IF NOT EXISTS `tarefa` (
  `idTarefa` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoTarefa` varchar(1000) DEFAULT NULL,
  `prazoTarefa` date DEFAULT NULL,
  `statusTarefa` tinyint(1) DEFAULT NULL,
  `dataTarefa` date DEFAULT NULL,
  `Turma_idTurma` int(11) NOT NULL,
  `Turma_Serie_idSerie` int(11) NOT NULL,
  `Turma_Periodo_idPeriodo` int(11) NOT NULL,
  `Disciplina_idDisciplina` int(11) NOT NULL,
  PRIMARY KEY (`idTarefa`,`Disciplina_idDisciplina`),
  KEY `fk_Tarefa_Turma1_idx` (`Turma_idTurma`,`Turma_Serie_idSerie`,`Turma_Periodo_idPeriodo`),
  KEY `fk_Tarefa_Disciplina1_idx` (`Disciplina_idDisciplina`),
  CONSTRAINT `fk_Tarefa_Disciplina1` FOREIGN KEY (`Disciplina_idDisciplina`) REFERENCES `disciplina` (`idDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tarefa_Turma1` FOREIGN KEY (`Turma_idTurma`, `Turma_Serie_idSerie`, `Turma_Periodo_idPeriodo`) REFERENCES `turma` (`idTurma`, `Serie_idSerie`, `Periodo_idPeriodo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.turma
DROP TABLE IF EXISTS `turma`;
CREATE TABLE IF NOT EXISTS `turma` (
  `idTurma` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `qtdAlunosLimite` varchar(45) DEFAULT NULL,
  `qtdAlunosInseridos` varchar(45) DEFAULT NULL,
  `ano` year(4) DEFAULT NULL,
  `Serie_idSerie` int(11) NOT NULL,
  `Periodo_idPeriodo` int(11) NOT NULL,
  PRIMARY KEY (`idTurma`,`Serie_idSerie`,`Periodo_idPeriodo`),
  KEY `fk_Turma_Serie1_idx` (`Serie_idSerie`),
  KEY `fk_Turma_Periodo1_idx` (`Periodo_idPeriodo`),
  CONSTRAINT `fk_Turma_Periodo1` FOREIGN KEY (`Periodo_idPeriodo`) REFERENCES `periodo` (`idPeriodo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Turma_Serie1` FOREIGN KEY (`Serie_idSerie`) REFERENCES `serie` (`idSerie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.uf
DROP TABLE IF EXISTS `uf`;
CREATE TABLE IF NOT EXISTS `uf` (
  `idUF` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `sigla` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`idUF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table gaed.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `sobrenome` varchar(100) DEFAULT NULL,
  `perfil` varchar(100) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `CPF` varchar(45) DEFAULT NULL,
  `RG` varchar(45) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `Logradouro_idLogradouro` int(11) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(1000) DEFAULT NULL,
  `dataIngresso` date DEFAULT NULL,
  `dataSaida` date DEFAULT NULL,
  `Foto_idFoto` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_Usuario_Logradouro1_idx` (`Logradouro_idLogradouro`),
  KEY `fk_Usuario_Foto1_idx` (`Foto_idFoto`),
  CONSTRAINT `fk_Usuario_Foto1` FOREIGN KEY (`Foto_idFoto`) REFERENCES `foto` (`idFoto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Logradouro1` FOREIGN KEY (`Logradouro_idLogradouro`) REFERENCES `logradouro` (`idLogradouro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
