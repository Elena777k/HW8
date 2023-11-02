ALTER TABLE `osbb_jdbc1`.`buildings`
ADD COLUMN `house` VARCHAR(15) NOT NULL AFTER `street`,
CHANGE COLUMN `adress` `street` VARCHAR(45) NOT NULL ;

