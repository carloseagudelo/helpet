-- MySQL Script generated by MySQL Workbench
-- 10/20/16 02:03:33
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Country` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`City`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`City` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `country` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `citycountry_idx` (`country` ASC)  COMMENT '',
  CONSTRAINT `citycountry`
    FOREIGN KEY (`country`)
    REFERENCES `mydb`.`Country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `lastname` VARCHAR(45) NOT NULL COMMENT '',
  `city` INT NOT NULL COMMENT '',
  `address` VARCHAR(45) NOT NULL COMMENT '',
  `email` VARCHAR(45) NOT NULL COMMENT '',
  `password` VARCHAR(45) NOT NULL COMMENT '',
  `image` VARCHAR(45) NULL COMMENT '',
  `document` VARCHAR(45) NOT NULL COMMENT '',
  `date` DATETIME NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `usercity_idx` (`city` ASC)  COMMENT '',
  CONSTRAINT `usercity`
    FOREIGN KEY (`city`)
    REFERENCES `mydb`.`City` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Breed`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Breed` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `observations` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pet` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `age` VARCHAR(45) NOT NULL COMMENT '',
  `breed` INT NOT NULL COMMENT '',
  `state` INT NOT NULL COMMENT '',
  `observations` VARCHAR(45) NOT NULL COMMENT '',
  `user` INT NOT NULL COMMENT '',
  `image` VARCHAR(45) NOT NULL COMMENT '',
  `date` DATETIME NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `peetbredd_idx` (`breed` ASC)  COMMENT '',
  INDEX `petuser_idx` (`user` ASC)  COMMENT '',
  CONSTRAINT `peetbredd`
    FOREIGN KEY (`breed`)
    REFERENCES `mydb`.`Breed` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `petuser`
    FOREIGN KEY (`user`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Locaion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Locaion` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `user` INT NOT NULL COMMENT '',
  `pet` INT NOT NULL COMMENT '',
  `latitude` FLOAT NOT NULL COMMENT '',
  `longitude` INT NOT NULL COMMENT '',
  `address` VARCHAR(45) NOT NULL COMMENT '',
  `image` VARCHAR(45) NULL COMMENT '',
  `observations` VARCHAR(45) NULL COMMENT '',
  `date` DATETIME NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `locatiosnpet_idx` (`pet` ASC)  COMMENT '',
  INDEX `locationuser_idx` (`user` ASC)  COMMENT '',
  CONSTRAINT `locatiosnpet`
    FOREIGN KEY (`pet`)
    REFERENCES `mydb`.`Pet` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `locationuser`
    FOREIGN KEY (`user`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
