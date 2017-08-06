SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema peoplerepu
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `peoplerepu` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `peoplerepu` ;

-- -----------------------------------------------------
-- Table `peoplerepu`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peoplerepu`.`User` (
  `id` VARCHAR(100) NOT NULL,
  `fName` VARCHAR(45) NOT NULL,
  `lName` VARCHAR(45) NOT NULL,
  `dob` DATE NOT NULL,
  `joined_date` DATE NOT NULL,
  `points` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`Connection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peoplerepu`.`Connection` (
  `user1` VARCHAR(100) NOT NULL,
  `user2` VARCHAR(100) NOT NULL,
  `recomended_people` VARCHAR(100) NULL DEFAULT 'self',
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
CREATE TABLE IF NOT EXISTS `peoplerepu`.`Post` (
  `id` VARCHAR(100) NOT NULL,
  `owner` VARCHAR(100) NOT NULL,
  `decription` VARCHAR(45) NOT NULL,
  `posted_date` DATE NOT NULL,
  `posted_time` TIME NOT NULL,
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
CREATE TABLE IF NOT EXISTS `peoplerepu`.`Comment` (
  `id` VARCHAR(100) NOT NULL,
  `comment` VARCHAR(60) NOT NULL,
  `commented_date` DATE NOT NULL,
  `commented_time` TIME NOT NULL,
  `Post_id` VARCHAR(100) NOT NULL,
  `commentor` VARCHAR(100) NOT NULL,
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
CREATE TABLE IF NOT EXISTS `peoplerepu`.`Profession` (
  `id` VARCHAR(30) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`Task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peoplerepu`.`Task` (
  `id` VARCHAR(100) NOT NULL,
  `giver` VARCHAR(100) NOT NULL,
  `taker` VARCHAR(100) NOT NULL,
  `date` DATE NOT NULL,
  INDEX `fk_People_has_People_People3_idx` (`taker` ASC),
  INDEX `fk_People_has_People_People2_idx` (`giver` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_People_has_People_People2`
    FOREIGN KEY (`giver`)
    REFERENCES `peoplerepu`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_People_has_People_People3`
    FOREIGN KEY (`taker`)
    REFERENCES `peoplerepu`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`Update`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peoplerepu`.`Update` (
  `id` VARCHAR(100) NOT NULL,
  `updated_date` DATE NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `Task_id` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Update_Task1_idx` (`Task_id` ASC),
  CONSTRAINT `fk_Update_Task1`
    FOREIGN KEY (`Task_id`)
    REFERENCES `peoplerepu`.`Task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`Reputation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peoplerepu`.`Reputation` (
  `id` VARCHAR(100) NOT NULL,
  `Task_id` VARCHAR(100) NOT NULL,
  `points` INT NOT NULL,
  PRIMARY KEY (`id`, `Task_id`),
  INDEX `fk_Reputation_Task1_idx` (`Task_id` ASC),
  CONSTRAINT `fk_Reputation_Task1`
    FOREIGN KEY (`Task_id`)
    REFERENCES `peoplerepu`.`Task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`Skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peoplerepu`.`Skill` (
  `id` INT NOT NULL,
  `desc` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peoplerepu`.`User_has_Skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peoplerepu`.`User_has_Skill` (
  `People_id` VARCHAR(100) NOT NULL,
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
CREATE TABLE IF NOT EXISTS `peoplerepu`.`User_has_Profession` (
  `User_id` VARCHAR(100) NOT NULL,
  `Profession_id` VARCHAR(30) NOT NULL,
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
