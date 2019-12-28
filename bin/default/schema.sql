
-- MySQL Script for resume.lk
-- Thu Aug 22 12:10:10 2019


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema resumelk
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `resumelk` ;

-- -----------------------------------------------------
-- Schema resumelk
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `resumelk` DEFAULT CHARACTER SET utf8 ;
USE `resumelk` ;

-- -----------------------------------------------------
-- Table `resumelk`.`user_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resumelk`.`user_type` ;

CREATE TABLE IF NOT EXISTS `resumelk`.`user_type` (
  `user_type_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_type_text` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_type_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `resumelk`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resumelk`.`user` ;

CREATE TABLE IF NOT EXISTS `resumelk`.`user` (
  `user_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `image_url` VARCHAR(255),
  `email` VARCHAR(255) NOT NULL UNIQUE,
  `password` VARCHAR(255),
  `provider` VARCHAR(255),
  `provider_id` VARCHAR(255),
  `is_active` TINYINT(1) NULL DEFAULT 0,
  `email_verified` TINYINT(1) NULL DEFAULT 0,
  `user_type_id` INT UNSIGNED NOT NULL,
  `created_date_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  FOREIGN KEY(user_type_id) REFERENCES `resumelk`.`user_type` (`user_type_id`),
  INDEX (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `resumelk`.`resume`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resumelk`.`resume_master` ;

CREATE TABLE IF NOT EXISTS `resumelk`.`resume_master` (
  `resume_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED NOT NULL,
  `resume_name` VARCHAR(255) NULL,
  `template_id` SMALLINT DEFAULT 1,
  `data` JSON,
  `created_on_time` DATETIME NULL,
  `last_accessed_time` TIMESTAMP NULL,
  PRIMARY KEY (`resume_id`),
  INDEX `resume_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_resume_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `resumelk`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


alter table `resumelk`.`user` add column `password` VARCHAR(255);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
