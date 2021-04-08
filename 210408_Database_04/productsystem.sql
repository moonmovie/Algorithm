-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema productsystem
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema productsystem
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `productsystem` DEFAULT CHARACTER SET utf8 ;
USE `productsystem` ;

-- -----------------------------------------------------
-- Table `productsystem`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `productsystem`.`users` (
  `usernum` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(16) NOT NULL,
  `username` VARCHAR(10) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `phonenum1` VARCHAR(11) NOT NULL,
  `phonenum2` VARCHAR(11) NULL,
  PRIMARY KEY (`usernum`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `productsystem`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `productsystem`.`product` (
  `productcode` INT NOT NULL AUTO_INCREMENT,
  `productname` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  `ea` INT NOT NULL,
  `color` VARCHAR(10) NULL,
  PRIMARY KEY (`productcode`, `productname`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `productsystem`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `productsystem`.`order` (
  `orderno` INT NOT NULL AUTO_INCREMENT,
  `orderdate` DATETIME NOT NULL DEFAULT now(),
  `usernum` INT NOT NULL,
  `payment` VARCHAR(1) NOT NULL,
  `totalprice` INT NOT NULL,
  `shippingstate` VARCHAR(10) NOT NULL DEFAULT 'notyet',
  PRIMARY KEY (`orderno`),
  INDEX `order_usernum_fk_idx` (`usernum` ASC) VISIBLE,
  CONSTRAINT `order_usernum_fk`
    FOREIGN KEY (`usernum`)
    REFERENCES `productsystem`.`users` (`usernum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `productsystem`.`order_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `productsystem`.`order_detail` (
  `detailno` INT NOT NULL AUTO_INCREMENT,
  `orderno` INT NOT NULL,
  `productcode` INT NOT NULL,
  `shipping` VARCHAR(1) NOT NULL DEFAULT 'F',
  `ea` INT NOT NULL,
  PRIMARY KEY (`detailno`),
  INDEX `order_detail_productcode_fk_idx` (`productcode` ASC) VISIBLE,
  CONSTRAINT `order_detail_orderno_fk`
    FOREIGN KEY (`orderno`)
    REFERENCES `productsystem`.`order` (`orderno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `order_detail_productcode_fk`
    FOREIGN KEY (`productcode`)
    REFERENCES `productsystem`.`product` (`productcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
