/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  mvkr
 * Created: 14 Aug, 2017
 */

/* tabel create statement */
CREATE TABLE `employee_info` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NULL,
  `AGE` INT NULL,
  `ADDRESS` VARCHAR(45) NULL,
  `PHONENUMBER` INT NOT NULL,
  `EMAIL` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`));


/* Insert satement */
personINSERT INTO `employee_info`
(`ID`,
`NAME`,
`AGE`,
`ADDRESS`,
`PHONENUMBER`,
`EMAIL`)
VALUES
(<{ID: }>,
<{NAME: }>,
<{AGE: }>,
<{ADDRESS: }>,
<{PHONENUMBER: }>,
<{EMAIL: }>);

/* Update Statement */
UPDATE `employee_info`
SET
`ID` = <{ID: }>,
`NAME` = <{NAME: }>,
`AGE` = <{AGE: }>,
`ADDRESS` = <{ADDRESS: }>,
`PHONENUMBER` = <{PHONENUMBER: }>,
`EMAIL` = <{EMAIL: }>
WHERE `ID` = <{expr}>;

/* Delete Statement */

DELETE FROM `employee_info`
WHERE `ID` = <{expr}>;

/* select statement */
SELECT `employee_info`.`ID`,
    `employee_info`.`NAME`,
    `employee_info`.`AGE`,
    `employee_info`.`ADDRESS`,
    `employee_info`.`PHONENUMBER`,
    `employee_info`.`EMAIL`
FROM `employee_info`;

SELECT `employee_info`.`ID`,
    `employee_info`.`NAME`,
    `employee_info`.`AGE`,
    `employee_info`.`ADDRESS`,
    `employee_info`.`PHONENUMBER`,
    `employee_info`.`EMAIL`
FROM `employee_info` 
WHERE `ID` = <{expr}>;
