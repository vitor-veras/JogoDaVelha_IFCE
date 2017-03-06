

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `jogodavelha` DEFAULT CHARACTER SET utf8 ;
USE `jogodavelha` ;


CREATE TABLE IF NOT EXISTS `jogodavelha`.`jogador` (
  `id_jogador` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `num_vitorias` DECIMAL(4,0) NOT NULL,
  `num_derrotas` DECIMAL(4,0) NULL,
 nick VARCHAR(45) UNIQUE, senha VARCHAR(45) NOT NULL, PRIMARY KEY (`id_jogador`))
ENGINE = InnoDB;




CREATE TABLE IF NOT EXISTS `jogodavelha`.`historico` (
  `id_partida` INT NOT NULL AUTO_INCREMENT,  `id_jogador1` INT NOT NULL,
  `id_jogador2` INT NOT NULL,
 `vencedor` CHAR(1), `data`

 DATETIME,  PRIMARY KEY (`id_partida`, `id_jogador1`, `id_jogador2`),
    FOREIGN KEY (`id_jogador1`)
    REFERENCES `jogodavelha`.`jogador` (`id_jogador`), 
    FOREIGN KEY (`id_jogador2`)
    REFERENCES `jogodavelha`.`jogador` (`id_jogador`))
ENGINE = InnoDB;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


