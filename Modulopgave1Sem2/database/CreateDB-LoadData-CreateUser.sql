
DROP DATABASE IF EXISTS modul;
CREATE DATABASE modul
CHARACTER SET utf8mb4;

USE modul;

CREATE TABLE Kommune (
    KommuneID INT(6) PRIMARY KEY,
    KommuneNavn VARCHAR(20) NOT NULL
);

CREATE TABLE Aarstal (
    AarstalID INT(4) PRIMARY KEY
);

CREATE TABLE Koen (
    KoenID CHAR(1) PRIMARY KEY,
    KoenNavn VARCHAR(10) NOT NULL
);

CREATE TABLE Bevaegelsesart (
    BevaegelsesartID INT(3) PRIMARY KEY,
    BevaegelsesartNavn VARCHAR(40) UNIQUE NOT NULL
);

CREATE TABLE Aldersgruppe (
	AldersgruppeID	TINYINT(3)	PRIMARY KEY,
    AldersgruppeNavn	VARCHAR(10)	UNIQUE
);


CREATE TABLE Flytning (
	FlytningID	INT(10)	PRIMARY KEY,
    Kommune_KommuneIDtil	INT(6)	REFERENCES kommune (KommuneID),
    Kommune_KommuneIDfra	INT(6)	REFERENCES kommune (KommuneID),
    Koen_KoenID	CHAR(1)	REFERENCES koen (koenID),
    Aldersgruppe_AldersgruppeID	TINYINT(3)	REFERENCES aldersgruppe (aldersgruppeID),
    Aarstal_AarstalID	INT(4)	REFERENCES Aarstal (AarstalID),
    FlytningAntal	INT(7)
);

CREATE TABLE Bevaegelser (
	BevaegelserID	int(10)	primary key,
    Kommune_KommuneID	int(6)	REFERENCES kommune (kommuneID),
    Koen_KoenID	char(1)	REFERENCES koen (koenID),
    Bevaegelsesart_BevaegelsesartID	int(3)	REFERENCES bevaegelsesart (BevaegelsesartID),
    Aarstal_AarstalID	int(4)	REFERENCES aarstal (aarstalID),
    AntalBevaegelser int(10)
);

insert into koen values
('k', 'kvinder'),
('m', 'maend');

insert into aarstal values
(2006),
(2007),
(2008),
(2009),
(2010),
(2011),
(2012),
(2013),
(2014),
(2015),
(2016),
(2017);

 LOAD DATA INFILE 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\kommune.txt'
 INTO TABLE kommune
CHARACTER SET utf8mb4
LINES TERMINATED BY '\r\n';

load data infile 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\bevaegelsesart.txt'
into table bevaegelsesart
character set utf8mb4
LINES TERMINATED BY '\r\n';

load data infile 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\alder.txt'
into table aldersgruppe
character set utf8mb4
LINES TERMINATED BY '\r\n';

load data infile 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\flytning.txt'
into table flytning
CHARACTER set utf8mb4
LINES TERMINATED BY '\r\n';

load data infile 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\bevaegelser.txt'
into table bevaegelser
CHARACTER set utf8mb4
LINES TERMINATED BY '\r\n';

#opret bruger
DROP USER IF EXISTS 'moduluser'@'localhost';
CREATE USER 'moduluser'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT ON MODUL.* TO 'moduluser'@'localhost';
FLUSH PRIVILEGES;
