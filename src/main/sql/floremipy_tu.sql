/* IL FAUT UTILISER LE NOM DE SCHEMA QUI EST PROJET_JAVA */
use floremipy_tu;

/*DROP TABLE*/
DROP TABLE IF EXISTS DeliveryDetail;
DROP TABLE IF EXISTS Delivery;
DROP TABLE IF EXISTS CustomerOrderLine;
DROP TABLE IF EXISTS CustomerOrder;
DROP TABLE IF EXISTS ArticleInProgress;
DROP TABLE IF EXISTS Price;
DROP TABLE IF EXISTS News;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Article;
DROP TABLE IF EXISTS Adress;
DROP TABLE IF EXISTS Resultat;
DROP TABLE IF EXISTS Result;
DROP TABLE IF EXISTS Indicateur;
DROP TABLE IF EXISTS Indicator;
DROP TABLE IF EXISTS sequence;
/*DROP TABLE*/

/*CREATE TABLE*/
CREATE TABLE Adress
(Id INTEGER NOT NULL AUTO_INCREMENT,
Location VARCHAR(200),
ZipCode VARCHAR(200),
City VARCHAR(200),
PRIMARY KEY (Id)
);

CREATE TABLE Customer
(Id INTEGER AUTO_INCREMENT NOT NULL,
Name VARCHAR(200) NOT NULL,
FirstName VARCHAR(200) NOT NULL,
Phone VARCHAR(15) NOT NULL,
Email VARCHAR(200) NOT NULL,
IdAdress INTEGER,
PRIMARY KEY (Id),
FOREIGN KEY (IdAdress) REFERENCES Adress(Id)
);

CREATE TABLE News
(Id INTEGER AUTO_INCREMENT NOT NULL,
Nom VARCHAR(20),
Contenu VARCHAR(200), 
Modifiable BOOL,
Auteur INTEGER NOT NULL,
DernierAuteur INTEGER NOT NULL,
DateCreation DATE,
DateModification DATE,
PRIMARY KEY (Id),
FOREIGN KEY (Auteur) REFERENCES Customer(Id),
FOREIGN KEY (DernierAuteur) REFERENCES Customer(Id)
);

CREATE TABLE Article
(Id INTEGER NOT NULL AUTO_INCREMENT,
Name VARCHAR(200),
Description VARCHAR(200),
Category VARCHAR(200),
Imgsrc VARCHAR(300),
QuantityInStock INTEGER DEFAULT 0 NOT NULL
CHECK (QuantityInStock >= 0),
PRIMARY KEY (Id));

CREATE TABLE Price
(Id INTEGER NOT NULL AUTO_INCREMENT,
IdArticle INTEGER NOT NULL,
Value DECIMAL(10,2) NOT NULL,
Date DATE NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (IdArticle) REFERENCES Article(Id)
);

CREATE TABLE ArticleInProgress
(Id INTEGER NOT NULL AUTO_INCREMENT,
Quantity INTEGER DEFAULT 0 NOT NULL,
StartDate DATE NOT NULL,
ReleaseDate DATE NOT NULL,
IdArticle INTEGER NOT NULL,
CHECK (Quantity >= 0),
PRIMARY KEY (Id),
FOREIGN KEY (IdArticle) REFERENCES Article(Id)
);

CREATE TABLE CustomerOrder
(Id INTEGER NOT NULL AUTO_INCREMENT,
CustomerOrderDate DATE NOT NULL,
IdCustomer INTEGER NOT NULL,
IdAdress INTEGER,
PRIMARY KEY (Id),
FOREIGN KEY (IdCustomer) REFERENCES Customer(Id),
FOREIGN KEY (IdAdress) REFERENCES Adress(Id)
);

CREATE TABLE CustomerOrderLine
(IdCustomerOrder INTEGER NOT NULL,
IdArticle INTEGER NOT NULL,
Quantity INTEGER NOT NULL,
DelivredQuantity INTEGER NOT NULL
CHECK (Quantity > 0),
PRIMARY KEY (IdCustomerOrder,IdArticle),
FOREIGN KEY (IdCustomerOrder) REFERENCES CustomerOrder(Id),
FOREIGN KEY (IdArticle) REFERENCES Article(Id)
);

CREATE TABLE Delivery
(Id INTEGER NOT NULL AUTO_INCREMENT,
DeliveryDate DATE NOT NULL,
PRIMARY KEY (Id)
);

CREATE TABLE DeliveryDetail
(IdDelivery INTEGER NOT NULL,
IdCustomerOrder INTEGER NOT NULL,
IdArticle INTEGER NOT NULL,
QuantityDelivred INTEGER NOT NULL
CHECK (QuantityDelivred > 0),
PRIMARY KEY (IdDelivery, IdCustomerOrder, IdArticle),
FOREIGN KEY (IdDelivery) REFERENCES Delivery(Id),
FOREIGN KEY (IdCustomerOrder, IdArticle) REFERENCES CustomerOrderLine(IdCustomerOrder,IdArticle)
);

CREATE TABLE Indicator
(Id INTEGER NOT NULL AUTO_INCREMENT,
Name VARCHAR(200),
sqlText VARCHAR(400),
periodicity VARCHAR(200),
targets VARCHAR(200),
PRIMARY KEY (Id)
);

CREATE TABLE Result
(Id INTEGER NOT NULL AUTO_INCREMENT,
Date DATE,
Value DOUBLE,
IdIndicator INTEGER,
PRIMARY KEY (Id),
FOREIGN KEY (IdIndicator) REFERENCES Indicator (Id)
ON DELETE cascade
);
/*CREATE TABLE*/

/*DEBUT DES INSERTIONS*/
INSERT INTO Adress VALUES(NULL,'2,Place de la canebière','13000','Marseille');
INSERT INTO Adress VALUES(NULL,'4,Rue de la broussaille','69000','Lyon');
INSERT INTO Adress VALUES(NULL,'8,Chemin de Rasteau','75456','Paris');
INSERT INTO Adress VALUES(NULL,'10,Place de la Gondolle','31000','Toulouse');
INSERT INTO Adress VALUES(NULL,'84,Impasse de la cheminee','34000','Montpellier');
INSERT INTO Adress VALUES(NULL,'123,Allee du general Leclerc','31400','Toulouse');
INSERT INTO Adress VALUES(NULL,'35,Rue des 36 ponts','31400','Toulouse');
INSERT INTO Adress VALUES(NULL,'1,Rue louis Merlino','13014','Marseille');

INSERT INTO Customer
VALUES(NULL,'Sansom','Luc','(999)999-9999','',1);
INSERT INTO Customer
VALUES(NULL,'Tremblay','Dollard','(888)888-8888','Tremblay.Dollard@mail.com',2);
INSERT INTO Customer
VALUES(NULL,'Bô','Lin','(777)777-7777','',3);
INSERT INTO Customer
VALUES(NULL,'Leconte','Jean','(666)666-6666','',4);
INSERT INTO Customer
VALUES(NULL,'Alaoui','Hafed','(555)555-5555','',5);
INSERT INTO Customer
VALUES(NULL,'Leconte','Marie','(666)666-6666','',6);
INSERT INTO Customer
VALUES(NULL,'Lecoq','Simon','(444)444-4419','',7);
INSERT INTO Customer
VALUES(NULL,'Tremblay','Dollard','(333)333-3333','Tremblay.Dollard@mail.com',8);

INSERT INTO Article
VALUES(NULL,'Cédre en boule','','Arbres','',10);
INSERT INTO Article
VALUES(NULL,'Sapin','','','',10);
INSERT INTO Article
VALUES(NULL,'Epinette bleue','','','',10);
INSERT INTO Article
VALUES(NULL,'Chêne','','','',10);
INSERT INTO Article
VALUES(NULL,'Erable argenté','','','',10);
INSERT INTO Article
VALUES(NULL,'Herbe à puce','','','',10);
INSERT INTO Article
VALUES(NULL,'Poirier','','','',10);
INSERT INTO Article
VALUES(NULL,'Catalpa','','','',10);
INSERT INTO Article
VALUES(NULL,'Pommier','','','',10);
INSERT INTO Article
VALUES(NULL,'Génévrier','','','',10);
INSERT INTO Article
VALUES(NULL,'Abricotier rustique','','Fruit','',10);

INSERT INTO Price
VALUES(NULL,1,10.99,'2013-11-01');
INSERT INTO Price
VALUES(NULL,2,12.99,'2013-11-01');
INSERT INTO Price
VALUES(NULL,3,25.99,'2013-11-01');
INSERT INTO Price
VALUES(NULL,4,22.99,'2013-11-01');
INSERT INTO Price
VALUES(NULL,5,15.99,'2013-11-01');
INSERT INTO Price
VALUES(NULL,6,10.99,'2013-11-01');
INSERT INTO Price
VALUES(NULL,7,26.99,'2013-11-01');
INSERT INTO Price
VALUES(NULL,8,25.99,'2013-11-01');
INSERT INTO Price
VALUES(NULL,9,25.99,'2013-11-01');
INSERT INTO Price
VALUES(NULL,10,15.99,'2013-11-01');
INSERT INTO Price
VALUES(NULL,11,21.90,'2013-11-01');

INSERT INTO CustomerOrder
VALUES(NULL,'2013-11-01',1,4);
INSERT INTO CustomerOrder
VALUES(NULL,'2013-11-02',2,3);
INSERT INTO CustomerOrder
VALUES(NULL,'2013-11-02',1,2);
INSERT INTO CustomerOrder
VALUES(NULL,'2013-11-05',1,1);
INSERT INTO CustomerOrder
VALUES(NULL,'2013-11-09',3,1);
INSERT INTO CustomerOrder
VALUES(NULL,'2013-11-09',2,6);
INSERT INTO CustomerOrder
VALUES(NULL,'2013-11-15',4,4);
INSERT INTO CustomerOrder
VALUES(NULL,'2013-11-15',4,2);

INSERT INTO CustomerOrderLine
VALUES(1,1,10,10);
INSERT INTO CustomerOrderLine
VALUES(1,7,5,5);
INSERT INTO CustomerOrderLine
VALUES(1,9,1,1);
INSERT INTO CustomerOrderLine
VALUES(2,4,2,2);
INSERT INTO CustomerOrderLine
VALUES(2,9,3,3);
INSERT INTO CustomerOrderLine
VALUES(3,2,1,1);
INSERT INTO CustomerOrderLine
VALUES(4,4,1,1);
INSERT INTO CustomerOrderLine
VALUES(4,5,1,1);
INSERT INTO CustomerOrderLine
VALUES(5,7,3,3);
INSERT INTO CustomerOrderLine
VALUES(5,1,5,5);
INSERT INTO CustomerOrderLine
VALUES(5,2,5,5);
INSERT INTO CustomerOrderLine
VALUES(6,1,5,5);
INSERT INTO CustomerOrderLine
VALUES(6,4,1,1);
INSERT INTO CustomerOrderLine
VALUES(7,5,1,1);
INSERT INTO CustomerOrderLine
VALUES(8,2,3,3);

INSERT INTO Delivery
VALUES(NULL,'2013-11-03');
INSERT INTO Delivery
VALUES(NULL,'2013-11-04');
INSERT INTO Delivery
VALUES(NULL,'2013-11-04');
INSERT INTO Delivery
VALUES(NULL,'2013-11-05');
INSERT INTO Delivery
VALUES(NULL,'2013-11-07');
INSERT INTO Delivery
VALUES(NULL,'2013-11-08');

INSERT INTO DeliveryDetail
VALUES(1,1,1,7);
INSERT INTO DeliveryDetail
VALUES(1,1,7,5);
INSERT INTO DeliveryDetail
VALUES(2,1,1,3);
INSERT INTO DeliveryDetail
VALUES(3,2,4,2);
INSERT INTO DeliveryDetail
VALUES(3,2,9,1);
INSERT INTO DeliveryDetail
VALUES(1,3,2,1);
INSERT INTO DeliveryDetail
VALUES(4,1,9,1);
INSERT INTO DeliveryDetail
VALUES(5,4,4,1);
INSERT INTO DeliveryDetail
VALUES(6,5,7,2);
/*FIN DES INSERTIONS*/