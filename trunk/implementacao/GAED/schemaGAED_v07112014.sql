-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.20 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             8.1.0.4545
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for bd_gaed
DROP DATABASE IF EXISTS `bd_gaed`;
CREATE DATABASE IF NOT EXISTS `bd_gaed` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bd_gaed`;


-- Dumping structure for table bd_gaed.aluno
CREATE TABLE IF NOT EXISTS `aluno` (
  `ID_Aluno` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Usuario` int(11) DEFAULT NULL,
  `ID_Responsavel` int(11) DEFAULT NULL,
  `Data_Ingresso` date DEFAULT NULL,
  PRIMARY KEY (`ID_Aluno`),
  KEY `ID_Responsavel` (`ID_Responsavel`),
  KEY `ID_Usuario` (`ID_Usuario`),
  CONSTRAINT `aluno_ibfk_1` FOREIGN KEY (`ID_Responsavel`) REFERENCES `responsavel` (`ID_Responsavel`),
  CONSTRAINT `aluno_ibfk_2` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuario` (`ID_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.aluno: ~5 rows (approximately)
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` (`ID_Aluno`, `ID_Usuario`, `ID_Responsavel`, `Data_Ingresso`) VALUES
	(1, 4, 2, '2014-10-22'),
	(2, 5, 2, '2014-10-22'),
	(3, 6, 3, '2014-10-22'),
	(4, 7, 3, '2014-10-22'),
	(5, 8, 3, '2014-10-22');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.boletim
CREATE TABLE IF NOT EXISTS `boletim` (
  `ID_Boletim` int(11) NOT NULL AUTO_INCREMENT,
  `Bimestre` int(11) DEFAULT NULL,
  `Data_Boletim` date DEFAULT NULL,
  PRIMARY KEY (`ID_Boletim`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.boletim: ~2 rows (approximately)
/*!40000 ALTER TABLE `boletim` DISABLE KEYS */;
INSERT INTO `boletim` (`ID_Boletim`, `Bimestre`, `Data_Boletim`) VALUES
	(1, 1, '2014-10-22'),
	(2, 1, '2014-10-22'),
	(3, 1, '2014-10-30');
/*!40000 ALTER TABLE `boletim` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.compoe
CREATE TABLE IF NOT EXISTS `compoe` (
  `ID_Boletim` int(11) DEFAULT NULL,
  `ID_Disciplina` int(11) DEFAULT NULL,
  `Nota` float DEFAULT NULL,
  `Faltas` int(11) DEFAULT NULL,
  KEY `ID_Boletim` (`ID_Boletim`),
  KEY `ID_Disciplina` (`ID_Disciplina`),
  CONSTRAINT `compoe_ibfk_1` FOREIGN KEY (`ID_Boletim`) REFERENCES `boletim` (`ID_Boletim`),
  CONSTRAINT `compoe_ibfk_2` FOREIGN KEY (`ID_Disciplina`) REFERENCES `disciplina` (`ID_Disciplina`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.compoe: ~8 rows (approximately)
/*!40000 ALTER TABLE `compoe` DISABLE KEYS */;
INSERT INTO `compoe` (`ID_Boletim`, `ID_Disciplina`, `Nota`, `Faltas`) VALUES
	(1, 1, 10, 4),
	(1, 2, 9, 1),
	(1, 3, 8, 2),
	(1, 4, 4.7, 2),
	(2, 1, 5, 0),
	(2, 2, 6, 4),
	(2, 3, 9, 5),
	(2, 4, 10, 10),
	(3, 1, 4, 2);
/*!40000 ALTER TABLE `compoe` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.disciplina
CREATE TABLE IF NOT EXISTS `disciplina` (
  `ID_Disciplina` int(11) NOT NULL AUTO_INCREMENT,
  `Nome_Disciplina` varchar(20) DEFAULT NULL,
  `Conteudo_Disciplina` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID_Disciplina`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.disciplina: ~4 rows (approximately)
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` (`ID_Disciplina`, `Nome_Disciplina`, `Conteudo_Disciplina`) VALUES
	(1, 'Portugues', 'Gramatica'),
	(2, 'Matematica', 'Algebra'),
	(3, 'Quimica', 'Organica'),
	(4, 'Fisica', 'Mecanica');
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.estuda
CREATE TABLE IF NOT EXISTS `estuda` (
  `ID_Aluno` int(11) DEFAULT NULL,
  `ID_Turma` int(11) DEFAULT NULL,
  KEY `ID_Aluno` (`ID_Aluno`),
  KEY `ID_Turma` (`ID_Turma`),
  CONSTRAINT `estuda_ibfk_1` FOREIGN KEY (`ID_Aluno`) REFERENCES `aluno` (`ID_Aluno`),
  CONSTRAINT `estuda_ibfk_2` FOREIGN KEY (`ID_Turma`) REFERENCES `turma` (`ID_Turma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.estuda: ~5 rows (approximately)
/*!40000 ALTER TABLE `estuda` DISABLE KEYS */;
INSERT INTO `estuda` (`ID_Aluno`, `ID_Turma`) VALUES
	(1, 1),
	(2, 2),
	(3, 2),
	(4, 2),
	(5, 2);
/*!40000 ALTER TABLE `estuda` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.faz
CREATE TABLE IF NOT EXISTS `faz` (
  `ID_Turma` int(11) DEFAULT NULL,
  `ID_Tarefa` int(11) DEFAULT NULL,
  KEY `ID_Turma` (`ID_Turma`),
  KEY `ID_Tarefa` (`ID_Tarefa`),
  CONSTRAINT `faz_ibfk_1` FOREIGN KEY (`ID_Turma`) REFERENCES `turma` (`ID_Turma`),
  CONSTRAINT `faz_ibfk_2` FOREIGN KEY (`ID_Tarefa`) REFERENCES `tarefa` (`ID_Tarefa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.faz: ~4 rows (approximately)
/*!40000 ALTER TABLE `faz` DISABLE KEYS */;
INSERT INTO `faz` (`ID_Turma`, `ID_Tarefa`) VALUES
	(1, 1),
	(1, 2),
	(2, 3),
	(2, 4);
/*!40000 ALTER TABLE `faz` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.gestor
CREATE TABLE IF NOT EXISTS `gestor` (
  `ID_Gestor` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Usuario` int(11) DEFAULT NULL,
  `Data_Admissao` date DEFAULT NULL,
  PRIMARY KEY (`ID_Gestor`),
  KEY `ID_Usuario` (`ID_Usuario`),
  CONSTRAINT `gestor_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuario` (`ID_Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.gestor: ~0 rows (approximately)
/*!40000 ALTER TABLE `gestor` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestor` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.inserido
CREATE TABLE IF NOT EXISTS `inserido` (
  `ID_Boletim` int(11) DEFAULT NULL,
  `ID_Aluno` int(11) DEFAULT NULL,
  KEY `ID_Boletim` (`ID_Boletim`),
  KEY `ID_Aluno` (`ID_Aluno`),
  CONSTRAINT `inserido_ibfk_1` FOREIGN KEY (`ID_Boletim`) REFERENCES `boletim` (`ID_Boletim`),
  CONSTRAINT `inserido_ibfk_2` FOREIGN KEY (`ID_Aluno`) REFERENCES `aluno` (`ID_Aluno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.inserido: ~2 rows (approximately)
/*!40000 ALTER TABLE `inserido` DISABLE KEYS */;
INSERT INTO `inserido` (`ID_Boletim`, `ID_Aluno`) VALUES
	(1, 1),
	(2, 2);
/*!40000 ALTER TABLE `inserido` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.ministra
CREATE TABLE IF NOT EXISTS `ministra` (
  `ID_Professor` int(11) DEFAULT NULL,
  `ID_Disciplina` int(11) DEFAULT NULL,
  KEY `ID_Professor` (`ID_Professor`),
  KEY `ID_Disciplina` (`ID_Disciplina`),
  CONSTRAINT `ministra_ibfk_1` FOREIGN KEY (`ID_Professor`) REFERENCES `professor` (`ID_Professor`),
  CONSTRAINT `ministra_ibfk_2` FOREIGN KEY (`ID_Disciplina`) REFERENCES `disciplina` (`ID_Disciplina`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.ministra: ~4 rows (approximately)
/*!40000 ALTER TABLE `ministra` DISABLE KEYS */;
INSERT INTO `ministra` (`ID_Professor`, `ID_Disciplina`) VALUES
	(1, 1),
	(2, 2),
	(3, 3),
	(4, 4);
/*!40000 ALTER TABLE `ministra` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.ocorrencia
CREATE TABLE IF NOT EXISTS `ocorrencia` (
  `ID_Ocorrencia` int(11) NOT NULL AUTO_INCREMENT,
  `Data_Ocorrencia` date DEFAULT NULL,
  `Descricao_Ocorrencia` varchar(1000) DEFAULT NULL,
  `Assunto_Ocorrencia` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID_Ocorrencia`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.ocorrencia: ~3 rows (approximately)
/*!40000 ALTER TABLE `ocorrencia` DISABLE KEYS */;
INSERT INTO `ocorrencia` (`ID_Ocorrencia`, `Data_Ocorrencia`, `Descricao_Ocorrencia`, `Assunto_Ocorrencia`) VALUES
	(1, '2014-10-22', 'Pulou o muro', 'Muro'),
	(2, '2014-10-22', 'Matou aula', 'Ausencia'),
	(3, '2014-10-22', 'Saida de todos alunos depois do intervalo', 'Falta coletiva');
/*!40000 ALTER TABLE `ocorrencia` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.possui
CREATE TABLE IF NOT EXISTS `possui` (
  `ID_Disciplina` int(11) DEFAULT NULL,
  `ID_Turma` int(11) DEFAULT NULL,
  KEY `ID_Disciplina` (`ID_Disciplina`),
  KEY `ID_Turma` (`ID_Turma`),
  CONSTRAINT `possui_ibfk_1` FOREIGN KEY (`ID_Disciplina`) REFERENCES `disciplina` (`ID_Disciplina`),
  CONSTRAINT `possui_ibfk_2` FOREIGN KEY (`ID_Turma`) REFERENCES `turma` (`ID_Turma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.possui: ~2 rows (approximately)
/*!40000 ALTER TABLE `possui` DISABLE KEYS */;
INSERT INTO `possui` (`ID_Disciplina`, `ID_Turma`) VALUES
	(1, 2),
	(1, 1),
	(1, 3);
/*!40000 ALTER TABLE `possui` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.professor
CREATE TABLE IF NOT EXISTS `professor` (
  `ID_Professor` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Usuario` int(11) DEFAULT NULL,
  `Data_Admissao` date DEFAULT NULL,
  PRIMARY KEY (`ID_Professor`),
  KEY `ID_Usuario` (`ID_Usuario`),
  CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuario` (`ID_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.professor: ~4 rows (approximately)
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` (`ID_Professor`, `ID_Usuario`, `Data_Admissao`) VALUES
	(1, 9, '2014-10-22'),
	(2, 10, '2014-10-22'),
	(3, 11, '2014-10-22'),
	(4, 12, '2014-10-22');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.recebe
CREATE TABLE IF NOT EXISTS `recebe` (
  `ID_Aluno` int(11) DEFAULT NULL,
  `ID_Ocorrencia` int(11) DEFAULT NULL,
  KEY `ID_Aluno` (`ID_Aluno`),
  KEY `ID_Ocorrencia` (`ID_Ocorrencia`),
  CONSTRAINT `recebe_ibfk_1` FOREIGN KEY (`ID_Aluno`) REFERENCES `aluno` (`ID_Aluno`),
  CONSTRAINT `recebe_ibfk_2` FOREIGN KEY (`ID_Ocorrencia`) REFERENCES `ocorrencia` (`ID_Ocorrencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.recebe: ~2 rows (approximately)
/*!40000 ALTER TABLE `recebe` DISABLE KEYS */;
INSERT INTO `recebe` (`ID_Aluno`, `ID_Ocorrencia`) VALUES
	(1, 1),
	(2, 2);
/*!40000 ALTER TABLE `recebe` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.registra
CREATE TABLE IF NOT EXISTS `registra` (
  `ID_Turma` int(11) DEFAULT NULL,
  `ID_Ocorrencia` int(11) DEFAULT NULL,
  KEY `ID_Ocorrencia` (`ID_Ocorrencia`),
  KEY `ID_Turma` (`ID_Turma`),
  CONSTRAINT `registra_ibfk_1` FOREIGN KEY (`ID_Ocorrencia`) REFERENCES `ocorrencia` (`ID_Ocorrencia`),
  CONSTRAINT `registra_ibfk_2` FOREIGN KEY (`ID_Turma`) REFERENCES `turma` (`ID_Turma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.registra: ~0 rows (approximately)
/*!40000 ALTER TABLE `registra` DISABLE KEYS */;
INSERT INTO `registra` (`ID_Turma`, `ID_Ocorrencia`) VALUES
	(2, 3);
/*!40000 ALTER TABLE `registra` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.responsavel
CREATE TABLE IF NOT EXISTS `responsavel` (
  `ID_Responsavel` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Usuario` int(11) DEFAULT NULL,
  `CPF` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_Responsavel`),
  KEY `ID_Usuario` (`ID_Usuario`),
  CONSTRAINT `responsavel_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuario` (`ID_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.responsavel: ~2 rows (approximately)
/*!40000 ALTER TABLE `responsavel` DISABLE KEYS */;
INSERT INTO `responsavel` (`ID_Responsavel`, `ID_Usuario`, `CPF`) VALUES
	(2, 2, '00000000'),
	(3, 3, '00000000');
/*!40000 ALTER TABLE `responsavel` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.secretaria
CREATE TABLE IF NOT EXISTS `secretaria` (
  `ID_Secretaria` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Usuario` int(11) DEFAULT NULL,
  `Data_Admissao` date DEFAULT NULL,
  PRIMARY KEY (`ID_Secretaria`),
  KEY `ID_Usuario` (`ID_Usuario`),
  CONSTRAINT `secretaria_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuario` (`ID_Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.secretaria: ~0 rows (approximately)
/*!40000 ALTER TABLE `secretaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `secretaria` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.tarefa
CREATE TABLE IF NOT EXISTS `tarefa` (
  `ID_Tarefa` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Disciplina` int(11) DEFAULT NULL,
  `Descricao_Tarefa` varchar(1000) DEFAULT NULL,
  `Data_Tarefa` date DEFAULT NULL,
  `Prazo_Tarefa` date DEFAULT NULL,
  `Status_Tarefa` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID_Tarefa`),
  KEY `ID_Disciplina` (`ID_Disciplina`),
  CONSTRAINT `tarefa_ibfk_1` FOREIGN KEY (`ID_Disciplina`) REFERENCES `disciplina` (`ID_Disciplina`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.tarefa: ~4 rows (approximately)
/*!40000 ALTER TABLE `tarefa` DISABLE KEYS */;
INSERT INTO `tarefa` (`ID_Tarefa`, `ID_Disciplina`, `Descricao_Tarefa`, `Data_Tarefa`, `Prazo_Tarefa`, `Status_Tarefa`) VALUES
	(1, 1, 'Escrever redação', '2014-10-22', '2014-10-22', 0),
	(2, 2, 'Tabuada do 9', '2014-10-22', '2014-10-22', 0),
	(3, 3, 'Cadeia carbonica', '2014-10-22', '2014-10-22', 0),
	(4, 4, 'Velocidade média', '2014-10-22', '2014-10-22', 0);
/*!40000 ALTER TABLE `tarefa` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.turma
CREATE TABLE IF NOT EXISTS `turma` (
  `ID_Turma` int(11) NOT NULL AUTO_INCREMENT,
  `Nome_Turma` varchar(10) DEFAULT NULL,
  `Periodo` varchar(20) DEFAULT NULL,
  `Serie` int(11) DEFAULT NULL,
  `Ano_Letivo` int(11) DEFAULT NULL,
  `Bimestre` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Turma`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.turma: ~2 rows (approximately)
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` (`ID_Turma`, `Nome_Turma`, `Periodo`, `Serie`, `Ano_Letivo`, `Bimestre`) VALUES
	(1, 'A', 'Diurno', 1, 2014, 1),
	(2, 'B', 'Noturno', 1, 2014, 2),
	(3, 'C', 'Diurno', 2, 2014, 1);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;


-- Dumping structure for table bd_gaed.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `ID_Usuario` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(40) DEFAULT NULL,
  `Senha` varchar(40) DEFAULT NULL,
  `Nome` varchar(50) DEFAULT NULL,
  `Sobrenome` varchar(50) DEFAULT NULL,
  `Sexo` varchar(20) DEFAULT NULL,
  `Data_Nascimento` date DEFAULT NULL,
  `Perfil_Usuario` tinyint(4) DEFAULT NULL,
  `Foto` blob,
  `Rua` varchar(100) DEFAULT NULL,
  `Numero` varchar(10) DEFAULT NULL,
  `Bairro` varchar(100) DEFAULT NULL,
  `Cidade` varchar(100) DEFAULT NULL,
  `Estado` varchar(100) DEFAULT NULL,
  `CEP` varchar(20) DEFAULT NULL,
  `Telefone` varchar(50) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- Dumping data for table bd_gaed.usuario: ~6 rows (approximately)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`ID_Usuario`, `Login`, `Senha`, `Nome`, `Sobrenome`, `Sexo`, `Data_Nascimento`, `Perfil_Usuario`, `Foto`, `Rua`, `Numero`, `Bairro`, `Cidade`, `Estado`, `CEP`, `Telefone`, `Email`) VALUES
	(1, 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, 'usu01', '313222e8942e8c19dfeb9a3afff3eff50413abbe', 'Ana', 'Siqueira', 'Feminino', '2014-10-22', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, 'usu02', NULL, 'Luis', 'Brandão', 'Masculino', '2014-10-22', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(4, 'usu03', 'c0c91243d738cc672bc176f450b1bd73d76cc947', 'Luiza', 'Favaretto', 'Feminino', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(5, 'usu04', '66b175ece05b7dae422c212aa63cda51a3fe666d', 'Waldinei', 'Pereira', 'Masculino', NULL, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(6, 'usu05', NULL, 'Angélica', 'Araujo', 'Feminino', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(7, 'usu06', NULL, 'Michell', 'Jubanski', 'Masculino', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(8, 'usu07', NULL, 'Marcos', 'Silva', 'Masculino', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(9, 'usu08', '4d938424b4f2bc2eb5fcde9ffb0d925eacda437d', 'Daniel', 'Previtali', 'Masculino', NULL, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(10, 'usu09', NULL, 'Maciel', 'Trakinas', 'Masculino', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(11, 'usu10', NULL, 'Odair', 'Silva', 'Masculino', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(12, 'usu11', NULL, 'Maria', 'Silva', 'Feminino', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(13, 'test', 'test', 'test', 'test', 'test', '0000-00-00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(14, 'a', 'b', 'c', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(15, 'test', 'asasas', 'test', 'test', 'test', NULL, NULL, NULL, '1212', '1212', NULL, '1212', '1212', '12.121-212121', '(12) 1212-1121', 'test'),
	(16, 'Laranja', 'Laranja', 'test', 'test', 'test', NULL, NULL, NULL, '1212', '1212', NULL, '1212', '1212', '12.121-212121', '(12) 1212-1121', 'test'),
	(17, 'Banana', 'asas', 'test', 'test', 'test', NULL, NULL, NULL, '1212', '1212', NULL, '1212', '1212', '12.121-212121', '(12) 1212-1121', 'test'),
	(18, 'Kiwi', 'sdad', 'asdas', 'adasd', 'masdasd', NULL, NULL, NULL, 'asdasd', '325', NULL, 'campinas', 'sada', '13058373', '(12) 3123-1231', 'lasdasdas'),
	(19, 'asas', '7ddbb6309d14a74d92e31b26f3ff5454dfa0708b', 'asas', 'asas', 'asas', NULL, NULL, NULL, '61313', '1231212', NULL, 'Campinas', 'asas', '13251512', '(16) 1131-3131', 'asas'),
	(20, 'lfernandobra', '3e034fb917ab7ed79e0cce95bb748b349f348c96', 'Luis Fernando', 'Brandão', 'Masculino', '1983-07-14', NULL, NULL, 'Antiga 7', '343', NULL, 'Campinas', 'São Paulo', '13058373', '(19) 9245-0472', 'lfernandobra@gmail.com'),
	(21, 'camila', 'c5c8066d458ef32d2d9d6c641cd90b1f5259ebed', 'Camila', 'Domingues', 'Feminino', '1973-03-20', NULL, NULL, '9', '32', 'asd', 'asd', 'asd', '13058373', '(19) 9999-9999', 'abc@def'),
	(22, 'test', 'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3', 'asd', 'asd', 'Masculino', '2314-07-12', NULL, NULL, '123', '3', 'qwe', 'campinas', 'asd', '13058373', '(21) 3123-1231', 'sdfasdfasdf');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
