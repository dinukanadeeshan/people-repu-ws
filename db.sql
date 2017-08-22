SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema peoplerepu
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `peoplerepu` ;
CREATE SCHEMA IF NOT EXISTS `peoplerepu` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `peoplerepu` ;

-- -----------------------------------------------------
-- Table `peoplerepu`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peoplerepu`.`User` ;

CREATE TABLE IF NOT EXISTS `peoplerepu`.`User` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `fName` VARCHAR(45) NOT NULL,
  `lName` VARCHAR(45) NOT NULL,
  `dob` DATE NOT NULL,
  `joined_date` DATE NOT NULL,
  `points` INT NOT NULL DEFAULT 0,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`Connection`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peoplerepu`.`Connection` ;

CREATE TABLE IF NOT EXISTS `peoplerepu`.`Connection` (
  `user1` BIGINT NOT NULL,
  `user2` BIGINT NOT NULL,
  `recomended_people` BIGINT NULL DEFAULT -1,
  `started_date` DATE NOT NULL,
  PRIMARY KEY (`user1`, `user2`),
  INDEX `fk_People_has_People_People1_idx` (`user2` ASC),
  INDEX `fk_People_has_People_People_idx` (`user1` ASC),
  INDEX `fk_Connection_People1_idx` (`recomended_people` ASC),
  CONSTRAINT `fk_People_has_People_People`
    FOREIGN KEY (`user1`)
    REFERENCES `peoplerepu`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_People_has_People_People1`
    FOREIGN KEY (`user2`)
    REFERENCES `peoplerepu`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Connection_People1`
    FOREIGN KEY (`recomended_people`)
    REFERENCES `peoplerepu`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`Post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peoplerepu`.`Post` ;

CREATE TABLE IF NOT EXISTS `peoplerepu`.`Post` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `owner` BIGINT NOT NULL,
  `decription` VARCHAR(1000) NOT NULL,
  `posted_date` DATE NOT NULL,
  `posted_time` TIME NOT NULL,
  `is_task` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Post_People1_idx` (`owner` ASC),
  CONSTRAINT `fk_Post_People1`
    FOREIGN KEY (`owner`)
    REFERENCES `peoplerepu`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`Comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peoplerepu`.`Comment` ;

CREATE TABLE IF NOT EXISTS `peoplerepu`.`Comment` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(1000) NOT NULL,
  `commented_date` DATE NOT NULL,
  `commented_time` TIME NOT NULL,
  `Post_id` BIGINT NOT NULL,
  `commentor` BIGINT NOT NULL,
  PRIMARY KEY (`id`, `Post_id`),
  INDEX `fk_Comment_Post1_idx` (`Post_id` ASC),
  INDEX `fk_Comment_People1_idx` (`commentor` ASC),
  CONSTRAINT `fk_Comment_Post1`
    FOREIGN KEY (`Post_id`)
    REFERENCES `peoplerepu`.`Post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comment_People1`
    FOREIGN KEY (`commentor`)
    REFERENCES `peoplerepu`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`Profession`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peoplerepu`.`Profession` ;

CREATE TABLE IF NOT EXISTS `peoplerepu`.`Profession` (
  `id` BIGINT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`Task`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peoplerepu`.`Task` ;

CREATE TABLE IF NOT EXISTS `peoplerepu`.`Task` (
  `Task_id` BIGINT NOT NULL,
  `giver` BIGINT NOT NULL,
  `taker` BIGINT NOT NULL,
  `date` DATE NOT NULL,
  INDEX `fk_People_has_People_People3_idx` (`taker` ASC),
  INDEX `fk_People_has_People_People2_idx` (`giver` ASC),
  PRIMARY KEY (`Task_id`),
  INDEX `fk_Task_Post1_idx` (`Task_id` ASC),
  CONSTRAINT `fk_People_has_People_People2`
    FOREIGN KEY (`giver`)
    REFERENCES `peoplerepu`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_People_has_People_People3`
    FOREIGN KEY (`taker`)
    REFERENCES `peoplerepu`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Task_Post1`
    FOREIGN KEY (`Task_id`)
    REFERENCES `peoplerepu`.`Post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`Update`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peoplerepu`.`Update` ;

CREATE TABLE IF NOT EXISTS `peoplerepu`.`Update` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `updated_date` DATE NOT NULL,
  `description` VARCHAR(1000) NOT NULL,
  `Task_id` BIGINT NOT NULL,
  `User_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Update_User1_idx` (`User_id` ASC),
  CONSTRAINT `fk_Update_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `peoplerepu`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`Reputation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peoplerepu`.`Reputation` ;

CREATE TABLE IF NOT EXISTS `peoplerepu`.`Reputation` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `points` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `id`
    FOREIGN KEY (`id`)
    REFERENCES `peoplerepu`.`Task` (`Task_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`Skill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peoplerepu`.`Skill` ;

CREATE TABLE IF NOT EXISTS `peoplerepu`.`Skill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `desc` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`User_has_Skill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peoplerepu`.`User_has_Skill` ;

CREATE TABLE IF NOT EXISTS `peoplerepu`.`User_has_Skill` (
  `People_id` BIGINT NOT NULL,
  `Skill_id` INT NOT NULL,
  PRIMARY KEY (`People_id`, `Skill_id`),
  INDEX `fk_People_has_Skill_Skill1_idx` (`Skill_id` ASC),
  INDEX `fk_People_has_Skill_People1_idx` (`People_id` ASC),
  CONSTRAINT `fk_People_has_Skill_People1`
    FOREIGN KEY (`People_id`)
    REFERENCES `peoplerepu`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_People_has_Skill_Skill1`
    FOREIGN KEY (`Skill_id`)
    REFERENCES `peoplerepu`.`Skill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`User_has_Profession`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peoplerepu`.`User_has_Profession` ;

CREATE TABLE IF NOT EXISTS `peoplerepu`.`User_has_Profession` (
  `User_id` BIGINT NOT NULL,
  `Profession_id` BIGINT NOT NULL,
  PRIMARY KEY (`User_id`, `Profession_id`),
  INDEX `fk_User_has_Profession_Profession1_idx` (`Profession_id` ASC),
  INDEX `fk_User_has_Profession_User1_idx` (`User_id` ASC),
  CONSTRAINT `fk_User_has_Profession_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `peoplerepu`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Profession_Profession1`
    FOREIGN KEY (`Profession_id`)
    REFERENCES `peoplerepu`.`Profession` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
