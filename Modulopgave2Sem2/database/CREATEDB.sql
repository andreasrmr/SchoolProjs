DROP DATABASE IF EXISTS M2S2;
CREATE DATABASE M2S2;

USE M2S2;

CREATE TABLE ordliste_uredigeret
(
alle_ord VARCHAR(3)
) CHARACTER SET utf8 COLLATE utf8_danish_ci;

CREATE TABLE ordliste_redigeret
(
alle_ord VARCHAR(3) unique
) CHARACTER SET utf8 COLLATE utf8_danish_ci;

LOAD DATA INFILE 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\3LetterWord_Unicode_uredigeret.txt'
INTO TABLE ordliste_uredigeret
CHARACTER SET 'utf8mb4'
LINES TERMINATED BY '\r\n';

#opret bruger
DROP USER IF EXISTS 'moduluser'@'localhost';
CREATE USER 'moduluser'@'localhost' IDENTIFIED BY 'password';
GRANT ALL ON m2s2.* TO 'moduluser'@'localhost';
FLUSH PRIVILEGES;

SELECT * FROM ordliste_uredigeret;
SELECT * FROM ordliste_redigeret;
select alle_ord from ordliste_uredigeret where alle_ord = 'råt';

use m2s2;
describe ordliste_redigeret;
