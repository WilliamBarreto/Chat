SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `chat` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;

USE `chat`;

CREATE  TABLE IF NOT EXISTS `chat`.`Atendente` (
  `id` INT(11) NOT NULL ,
  `nome` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE  TABLE IF NOT EXISTS `chat`.`Usuario` (
  `id` INT(11) NOT NULL ,
  `nome` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE  TABLE IF NOT EXISTS `chat`.`Atendimento` (
  `id` INT(11) NOT NULL ,
  `data` DATETIME NULL DEFAULT NULL ,
  `text` VARCHAR(200) NULL DEFAULT NULL ,
  `idUsuario` INT(11) NOT NULL ,
  `idAtendente` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Atendimento_Usuario` (`idUsuario` ASC) ,
  INDEX `fk_Atendimento_Atendente` (`idAtendente` ASC) ,
  CONSTRAINT `fk_Atendimento_Usuario`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `chat`.`Usuario` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Atendimento_Atendente`
    FOREIGN KEY (`idAtendente` )
    REFERENCES `chat`.`Atendente` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
