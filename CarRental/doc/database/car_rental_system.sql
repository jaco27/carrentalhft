SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `carrental` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;

-- -----------------------------------------------------
-- Table `carrental`.`CUSTOMER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `carrental`.`CUSTOMER` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `LOGIN_NAME` VARCHAR(45) NOT NULL ,
  `REGISTER_DATE` DATE NOT NULL ,
  `EMAIL` VARCHAR(45) NOT NULL ,
  `CUSTOMER_TYPE` VARCHAR(10) NOT NULL ,
  `FIRST_NAME` VARCHAR(45) NULL ,
  `SURNAME` VARCHAR(45) NULL ,
  `DATE_OF_BIRTH` DATE NULL ,
  `PASSWORD` VARCHAR(45) NOT NULL ,
  `COMPANY_NAME` VARCHAR(45) NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carrental`.`AGENCY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `carrental`.`AGENCY` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carrental`.`CAR_TYPE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `carrental`.`CAR_TYPE` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(45) NOT NULL ,
  `PRODUCER` VARCHAR(45) NOT NULL ,
  `TYPE` VARCHAR(45) NOT NULL ,
  `AUTOMATIC` TINYINT(1)  NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carrental`.`BRANCH`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `carrental`.`BRANCH` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `AGENCY_ID` INT NOT NULL ,
  `NAME` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_Branch_Agency1` (`AGENCY_ID` ASC) ,
  CONSTRAINT `fk_Branch_Agency1`
    FOREIGN KEY (`AGENCY_ID` )
    REFERENCES `carrental`.`AGENCY` (`ID` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carrental`.`CAR`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `carrental`.`CAR` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `CAR_TYPE_ID` INT NOT NULL ,
  `BRANCH_ID` INT NOT NULL ,
  `REGISTRATION_NUMBER` VARCHAR(30) NOT NULL ,
  `COLOR` VARCHAR(30) NOT NULL ,
  `DATE_OF_MANUFACTURING` YEAR NOT NULL ,
  `BASE_PRICE_PER_DAY` FLOAT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_Car_CarDetail1` (`CAR_TYPE_ID` ASC) ,
  INDEX `fk_Car_Branch1` (`BRANCH_ID` ASC) ,
  CONSTRAINT `fk_Car_CarDetail1`
    FOREIGN KEY (`CAR_TYPE_ID` )
    REFERENCES `carrental`.`CAR_TYPE` (`ID` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Car_Branch1`
    FOREIGN KEY (`BRANCH_ID` )
    REFERENCES `carrental`.`BRANCH` (`ID` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carrental`.`BOOKING`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `carrental`.`BOOKING` (
  `BOOKING_NUMBER` INT NOT NULL AUTO_INCREMENT ,
  `CUSTOMER_ID` INT NOT NULL ,
  `AGENCY_ID` INT NOT NULL ,
  `CAR_ID` INT NOT NULL ,
  `BOOKING_DATE` DATE NOT NULL ,
  `RETURN_DATE` DATE NOT NULL ,
  INDEX `fk_Order_Customer1` (`CUSTOMER_ID` ASC) ,
  INDEX `fk_Order_Agency1` (`AGENCY_ID` ASC) ,
  INDEX `fk_Order_Car1` (`CAR_ID` ASC) ,
  PRIMARY KEY (`BOOKING_NUMBER`) ,
  CONSTRAINT `fk_Order_Customer1`
    FOREIGN KEY (`CUSTOMER_ID` )
    REFERENCES `carrental`.`CUSTOMER` (`ID` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Order_Agency1`
    FOREIGN KEY (`AGENCY_ID` )
    REFERENCES `carrental`.`AGENCY` (`ID` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Order_Car1`
    FOREIGN KEY (`CAR_ID` )
    REFERENCES `carrental`.`CAR` (`ID` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carrental`.`BRANCH_ADDRESS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `carrental`.`BRANCH_ADDRESS` (
  `BRANCH_ID` INT NOT NULL ,
  `STREET_NAME` VARCHAR(45) NOT NULL ,
  `CITY_NAME` VARCHAR(45) NOT NULL ,
  `STREET_NUMBER` VARCHAR(5) NOT NULL ,
  `POSTAL_CODE` VARCHAR(10) NOT NULL ,
  `COUNTRY` VARCHAR(45) NOT NULL ,
  `PHONE_NUMBER` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`BRANCH_ID`) ,
  INDEX `fk_BRANCH_ADDRESS_BRANCH1` (`BRANCH_ID` ASC) ,
  CONSTRAINT `fk_BRANCH_ADDRESS_BRANCH1`
    FOREIGN KEY (`BRANCH_ID` )
    REFERENCES `carrental`.`BRANCH` (`ID` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carrental`.`CUSTOMER_ADDRESS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `carrental`.`CUSTOMER_ADDRESS` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `STREET_NAME` VARCHAR(45) NOT NULL ,
  `CITY_NAME` VARCHAR(45) NOT NULL ,
  `STREET_NUMBER` VARCHAR(5) NOT NULL ,
  `POSTAL_CODE` VARCHAR(10) NOT NULL ,
  `COUNTRY` VARCHAR(45) NOT NULL ,
  `PHONE_NUMBER` VARCHAR(45) NOT NULL ,
  `CUSTOMER_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_CUSTOMER_ADDRESS_CUSTOMER1` (`CUSTOMER_ID` ASC) ,
  CONSTRAINT `fk_CUSTOMER_ADDRESS_CUSTOMER1`
    FOREIGN KEY (`CUSTOMER_ID` )
    REFERENCES `carrental`.`CUSTOMER` (`ID` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
