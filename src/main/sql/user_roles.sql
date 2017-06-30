CREATE TABLE `floremipy_tu`.`user_role` (
  `ID` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL)
COMMENT = 'user with roles';

insert into user_role values (1,'le_directeur', 'Dir#01', 'ROLE_DIRECTEUR');
insert into user_role values (2,'le_jardinier', 'Jar#01', 'ROLE_JARDINIER');
insert into user_role values (3,'admin', 'admin', 'ROLE_DIRECTEUR');
insert into user_role values (4,'adm', 'adm', 'ROLE_ADMIN');
insert into user_role values (5,'le_client', 'Cli#01', 'ROLE_CLIENT');