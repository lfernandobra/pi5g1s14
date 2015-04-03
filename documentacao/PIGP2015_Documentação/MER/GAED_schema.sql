-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gaedbdoficial
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gaedbdoficial
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gaedbdoficial` DEFAULT CHARACTER SET latin1 ;
USE `gaedbdoficial` ;

-- -----------------------------------------------------
-- Table `gaedbdoficial`.`foto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`foto` (
  `id_foto` INT(11) NOT NULL,
  `imagem` TINYBLOB NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_foto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`uf`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`uf` (
  `id_UF` INT(11) NOT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `sigla` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_UF`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`municipio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`municipio` (
  `id_municipio` INT(11) NOT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `id_UF` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_municipio`),
  INDEX `fk_UF` (`id_UF` ASC),
  CONSTRAINT `fk_UF`
    FOREIGN KEY (`id_UF`)
    REFERENCES `gaedbdoficial`.`uf` (`id_UF`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`bairro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`bairro` (
  `id_bairro` INT(11) NOT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `id_municipio` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_bairro`),
  INDEX `fk_municipio` (`id_municipio` ASC),
  CONSTRAINT `fk_municipio`
    FOREIGN KEY (`id_municipio`)
    REFERENCES `gaedbdoficial`.`municipio` (`id_municipio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`logradouro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`logradouro` (
  `id_logradouro` INT(11) NOT NULL,
  `CEP` VARCHAR(255) NOT NULL,
  `nome_logradouro` VARCHAR(255) NOT NULL,
  `id_bairro` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_logradouro`),
  INDEX `fk_bairro` (`id_bairro` ASC),
  CONSTRAINT `fk_bairro`
    FOREIGN KEY (`id_bairro`)
    REFERENCES `gaedbdoficial`.`bairro` (`id_bairro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`perfil` (
  `id_value` INT(11) NOT NULL,
  PRIMARY KEY (`id_value`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `CPF` VARCHAR(255) NULL DEFAULT NULL,
  `RG` VARCHAR(255) NULL DEFAULT NULL,
  `complemento` VARCHAR(255) NULL DEFAULT NULL,
  `dataingresso` DATETIME NULL DEFAULT NULL,
  `datasaida` DATETIME NULL DEFAULT NULL,
  `datanasc` DATETIME NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `login` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `numero` VARCHAR(255) NULL DEFAULT NULL,
  `senha` VARCHAR(255) NULL DEFAULT NULL,
  `sexo` VARCHAR(255) NULL DEFAULT NULL,
  `sobrenome` VARCHAR(255) NULL DEFAULT NULL,
  `status` BIT(1) NULL DEFAULT NULL,
  `telefone` VARCHAR(255) NULL DEFAULT NULL,
  `id_foto` INT(11) NULL DEFAULT NULL,
  `id_logradouro` INT(11) NULL DEFAULT NULL,
  `id_perfil` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  INDEX `fk_foto` (`id_foto` ASC),
  INDEX `fk_logradouro` (`id_logradouro` ASC),
  INDEX `fk_perfil` (`id_perfil` ASC),
  CONSTRAINT `fk_foto`
    FOREIGN KEY (`id_foto`)
    REFERENCES `gaedbdoficial`.`foto` (`id_foto`),
  CONSTRAINT `fk_logradouro`
    FOREIGN KEY (`id_logradouro`)
    REFERENCES `gaedbdoficial`.`logradouro` (`id_logradouro`),
  CONSTRAINT `fk_perfil`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `gaedbdoficial`.`perfil` (`id_value`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`aluno` (
  `escolaAnterior` VARCHAR(255) NULL DEFAULT NULL,
  `escolaAtual` VARCHAR(255) NULL DEFAULT NULL,
  `serieAnterior` VARCHAR(255) NULL DEFAULT NULL,
  `serieAtual` VARCHAR(255) NULL DEFAULT NULL,
  `id_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `FK_du6j4chl8eg8rdq95prv9dyvt`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `gaedbdoficial`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`bimestre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`bimestre` (
  `id_bimestre` INT(11) NOT NULL AUTO_INCREMENT,
  `datafinal` DATETIME NOT NULL,
  `datainicial` DATETIME NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_bimestre`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`boletim`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`boletim` (
  `id_boletim` INT(11) NOT NULL AUTO_INCREMENT,
  `id_bimestre` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_boletim`),
  INDEX `fk_bimestre` (`id_bimestre` ASC),
  CONSTRAINT `fk_bimestre`
    FOREIGN KEY (`id_bimestre`)
    REFERENCES `gaedbdoficial`.`bimestre` (`id_bimestre`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`disciplina` (
  `id_disciplina` INT(11) NOT NULL AUTO_INCREMENT,
  `conteudo` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_disciplina`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`boletim_aluno_disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`boletim_aluno_disciplina` (
  `falta` INT(11) NOT NULL,
  `nota` FLOAT NOT NULL,
  `boletim_id` INT(11) NOT NULL DEFAULT '0',
  `aluno_id` INT(11) NOT NULL DEFAULT '0',
  `disciplina_id` INT(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`aluno_id`, `boletim_id`, `disciplina_id`),
  INDEX `fk_boletim` (`boletim_id` ASC),
  INDEX `fk_discip` (`disciplina_id` ASC),
  CONSTRAINT `fk_alu`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `gaedbdoficial`.`aluno` (`id_usuario`),
  CONSTRAINT `fk_boletim`
    FOREIGN KEY (`boletim_id`)
    REFERENCES `gaedbdoficial`.`boletim` (`id_boletim`),
  CONSTRAINT `fk_discip`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `gaedbdoficial`.`disciplina` (`id_disciplina`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`gestor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`gestor` (
  `anoConcl` DATETIME NOT NULL,
  `formacAcad` VARCHAR(255) NOT NULL,
  `instAcad` VARCHAR(255) NOT NULL,
  `id_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `FK_2ifm7rnuxkop3tdyc9souny50`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `gaedbdoficial`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`ocorrencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`ocorrencia` (
  `id_ocorrencia` INT(11) NOT NULL,
  `assunto` VARCHAR(255) NULL DEFAULT NULL,
  `data` DATETIME NULL DEFAULT NULL,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  `id_usuario` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_ocorrencia`),
  INDEX `fk_usuario` (`id_usuario` ASC),
  CONSTRAINT `fk_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `gaedbdoficial`.`aluno` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`periodo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`periodo` (
  `id_periodo` INT(11) NOT NULL,
  `periodo` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_periodo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`professor` (
  `anoConcl` DATETIME NOT NULL,
  `escolaAnt` VARCHAR(255) NOT NULL,
  `formacAcad` VARCHAR(255) NOT NULL,
  `instAcad` VARCHAR(255) NOT NULL,
  `id_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `FK_slmphl18it8oo2cxbd94svnk5`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `gaedbdoficial`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`professor_disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`professor_disciplina` (
  `Professor_id_usuario` INT(11) NOT NULL,
  `disciplina_id_disciplina` INT(11) NOT NULL,
  PRIMARY KEY (`Professor_id_usuario`, `disciplina_id_disciplina`),
  UNIQUE INDEX `UK_q3qdr8wreuoxi9fxux4xmeje2` (`disciplina_id_disciplina` ASC),
  CONSTRAINT `FK_pedwgnm84mno94o6e9s0jx2up`
    FOREIGN KEY (`Professor_id_usuario`)
    REFERENCES `gaedbdoficial`.`professor` (`id_usuario`),
  CONSTRAINT `FK_q3qdr8wreuoxi9fxux4xmeje2`
    FOREIGN KEY (`disciplina_id_disciplina`)
    REFERENCES `gaedbdoficial`.`disciplina` (`id_disciplina`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`serie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`serie` (
  `id_serie` INT(11) NOT NULL,
  `serie` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_serie`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`turma` (
  `id_turma` INT(11) NOT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `inseridos` INT(11) NULL DEFAULT NULL,
  `limite` INT(11) NULL DEFAULT NULL,
  `id_periodo` INT(11) NULL DEFAULT NULL,
  `id_serie` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_turma`),
  INDEX `fk_periodo` (`id_periodo` ASC),
  INDEX `fk_serie` (`id_serie` ASC),
  CONSTRAINT `fk_periodo`
    FOREIGN KEY (`id_periodo`)
    REFERENCES `gaedbdoficial`.`periodo` (`id_periodo`),
  CONSTRAINT `fk_serie`
    FOREIGN KEY (`id_serie`)
    REFERENCES `gaedbdoficial`.`serie` (`id_serie`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`professor_disciplina_turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`professor_disciplina_turma` (
  `turma_id` INT(11) NOT NULL DEFAULT '0',
  `disciplina_id` INT(11) NOT NULL DEFAULT '0',
  `professor_id` INT(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`disciplina_id`, `professor_id`, `turma_id`),
  INDEX `fk_tur` (`turma_id` ASC),
  INDEX `fk_prof` (`professor_id` ASC),
  CONSTRAINT `fk_dis`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `gaedbdoficial`.`disciplina` (`id_disciplina`),
  CONSTRAINT `fk_prof`
    FOREIGN KEY (`professor_id`)
    REFERENCES `gaedbdoficial`.`professor` (`id_usuario`),
  CONSTRAINT `fk_tur`
    FOREIGN KEY (`turma_id`)
    REFERENCES `gaedbdoficial`.`turma` (`id_turma`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`responsavel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`responsavel` (
  `adimplente` BIT(1) NOT NULL,
  `id_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `FK_jreh25tq9kb58s3rbtwfy4wkq`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `gaedbdoficial`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`responsavel_aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`responsavel_aluno` (
  `Responsavel_id_usuario` INT(11) NOT NULL,
  `aluno_id_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`Responsavel_id_usuario`, `aluno_id_usuario`),
  UNIQUE INDEX `UK_cwdqvm7ryjdeqt446vjyh1rt0` (`aluno_id_usuario` ASC),
  CONSTRAINT `FK_17cqodsifrdys8l1d4pxto7yo`
    FOREIGN KEY (`Responsavel_id_usuario`)
    REFERENCES `gaedbdoficial`.`responsavel` (`id_usuario`),
  CONSTRAINT `FK_cwdqvm7ryjdeqt446vjyh1rt0`
    FOREIGN KEY (`aluno_id_usuario`)
    REFERENCES `gaedbdoficial`.`aluno` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`secretaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`secretaria` (
  `anoConcl` DATETIME NOT NULL,
  `experiAnt` VARCHAR(255) NOT NULL,
  `formacAcad` VARCHAR(255) NOT NULL,
  `instAcad` VARCHAR(255) NOT NULL,
  `instituicaoAnt` VARCHAR(255) NOT NULL,
  `id_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `FK_t9n3oscl5jlbtfwlmcnx68ugi`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `gaedbdoficial`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`Anexo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`Anexo` (
  `id_anexo` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `anexo` TINYBLOB NULL,
  PRIMARY KEY (`id_anexo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`tarefa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`tarefa` (
  `id_tarefa` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  `fim` DATETIME NULL DEFAULT NULL,
  `inicio` DATETIME NULL DEFAULT NULL,
  `id_disciplina` INT(11) NULL DEFAULT NULL,
  `id_turma` INT(11) NULL DEFAULT NULL,
  `id_anexo` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tarefa`),
  INDEX `fk_disciplina` (`id_disciplina` ASC),
  INDEX `fk_turma` (`id_turma` ASC),
  INDEX `fk_tarefa_Anexo1_idx` (`id_anexo` ASC),
  CONSTRAINT `fk_disciplina`
    FOREIGN KEY (`id_disciplina`)
    REFERENCES `gaedbdoficial`.`disciplina` (`id_disciplina`),
  CONSTRAINT `fk_turma`
    FOREIGN KEY (`id_turma`)
    REFERENCES `gaedbdoficial`.`turma` (`id_turma`),
  CONSTRAINT `fk_tarefa_Anexo1`
    FOREIGN KEY (`id_anexo`)
    REFERENCES `gaedbdoficial`.`Anexo` (`id_anexo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`turma_aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`turma_aluno` (
  `turma_id_turma` INT(11) NOT NULL,
  `aluno_id_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`turma_id_turma`, `aluno_id_usuario`),
  UNIQUE INDEX `UK_iht60n1fwuqe0bq7lc276xsix` (`aluno_id_usuario` ASC),
  CONSTRAINT `FK_iht60n1fwuqe0bq7lc276xsix`
    FOREIGN KEY (`aluno_id_usuario`)
    REFERENCES `gaedbdoficial`.`aluno` (`id_usuario`),
  CONSTRAINT `FK_lkid2nrmurgl8lnr9s18gajbd`
    FOREIGN KEY (`turma_id_turma`)
    REFERENCES `gaedbdoficial`.`turma` (`id_turma`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`anexo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`anexo` (
  `id_anexo` INT(11) NOT NULL,
  `anexo` TINYBLOB NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_anexo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gaedbdoficial`.`turma_professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaedbdoficial`.`turma_professor` (
  `turma_id_turma` INT(11) NOT NULL,
  `professor_id_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`turma_id_turma`, `professor_id_usuario`),
  UNIQUE INDEX `UK_b5opxuxv2cevegvsa44qdh2vp` (`professor_id_usuario` ASC),
  CONSTRAINT `FK_b5opxuxv2cevegvsa44qdh2vp`
    FOREIGN KEY (`professor_id_usuario`)
    REFERENCES `gaedbdoficial`.`professor` (`id_usuario`),
  CONSTRAINT `FK_lh6hob4ruddak9u9vb8vlefrv`
    FOREIGN KEY (`turma_id_turma`)
    REFERENCES `gaedbdoficial`.`turma` (`id_turma`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
