-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema train_info
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema train_info
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `train_info` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `train_info` ;

-- -----------------------------------------------------
-- Table `train_info`.`journey`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `train_info`.`journey` (
  `journey_id` INT NOT NULL AUTO_INCREMENT,
  `start_station` VARCHAR(45) NULL DEFAULT NULL,
  `end_station` VARCHAR(45) NULL DEFAULT NULL,
  `mileage` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`journey_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `train_info`.`journey_stops`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `train_info`.`journey_stops` (
  `journey_stop_id` INT NOT NULL AUTO_INCREMENT,
  `stop_order` INT NULL DEFAULT '0',
  `crs_code` VARCHAR(45) NULL DEFAULT NULL,
  `via_station` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`journey_stop_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 60
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `train_info`.`journey_stop_join_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `train_info`.`journey_stop_join_table` (
  `journey_id` INT NOT NULL,
  `journey_stop_id` INT NOT NULL,
  PRIMARY KEY (`journey_id`, `journey_stop_id`),
  INDEX `journey_stop_id` (`journey_stop_id` ASC) VISIBLE,
  CONSTRAINT `journey_id`
    FOREIGN KEY (`journey_id`)
    REFERENCES `train_info`.`journey` (`journey_id`),
  CONSTRAINT `journey_stop_id`
    FOREIGN KEY (`journey_stop_id`)
    REFERENCES `train_info`.`journey_stops` (`journey_stop_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `train_info`.`train_station_locations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `train_info`.`train_station_locations` (
  `crs_code` VARCHAR(3) NOT NULL,
  `station_name` TEXT NULL DEFAULT NULL,
  `latitude` DOUBLE NULL DEFAULT NULL,
  `longitude` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`crs_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
