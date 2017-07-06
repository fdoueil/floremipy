CREATE TABLE `floremipy_tu`.`user_role` (
  `ID` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL)
COMMENT = 'user with roles';

insert into user_role values (1,'le_directeur', '$2a$10$gxa/tVRGaDovB8cJVbTMF.UtUCcb9r.iwscQYrJ42kRc16PgeZkIi', 'ROLE_DIRECTEUR');
insert into user_role values (2,'le_jardinier', '$2a$10$XFQnJtFRw.NI7fYDXtTTUOAJCkWHDj77fwLWCisC1lbSohgP6wBAq', 'ROLE_JARDINIER');
insert into user_role values (3,'admin', '$2a$10$AihO5UY.XsL5/Dnhdy.TiuOoeR5wsdKKq9YqPjPDAlibk/QoMMWM6', 'ROLE_DIRECTEUR');
insert into user_role values (4,'adm', '$2a$10$C9VKScI/geqTvEMqPLFWbeIcZczntJTE6umI2QJqHBS.JaVYD1mz2', 'ROLE_ADMIN');
insert into user_role values (5,'le_client', '$2a$10$krfMoesQLShR8TVetLCaz.6lVFYcbbG4lXU6kaqxjL8w7NR04I4n.', 'ROLE_CLIENT');