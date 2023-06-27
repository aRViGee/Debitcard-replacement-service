CREATE TABLE IF NOT EXISTS Customer(
id SERIAL NOT NULL PRIMARY KEY,
authorization_level ENUM('1','2','3')
);

CREATE TABLE IF NOT EXISTS CardArrangement(
id SERIAL NOT NULL PRIMARY KEY,
customer_id INTEGER NOT NULL,
CONSTRAINT FK_CardArrangement_Customer FOREIGN KEY (customer_id) REFERENCES Customer(id)
);


CREATE TABLE IF NOT EXISTS Card(
id SERIAL NOT NULL PRIMARY KEY,
card_arrangement_id INTEGER UNIQUE NOT NULL,
start_date DATE NOT NULL,
end_date DATE NOT NULL,
status ENUM('ACTIVE', 'INACTIVE', 'BLOCKED', 'EXPIRED') NOT NULL,
CONSTRAINT FK_Card_CardArrangement FOREIGN KEY (card_arrangement_id) REFERENCES CardArrangement(id)
);

--ALTER TABLE Card
--ADD CONSTRAINT FK_Card_CardArrangement FOREIGN KEY (card_arrangement_id)
--REFERENCES CardArrangement(id);



--Fill the tables
--INSERT INTO Customer(authorization_level)
--VALUES(ARRAY['BLOCK','UNBLOCK'],'1');
--
--INSERT INTO CardArrangement(customer_id)
--VALUES(1);
--
--INSERT INTO Card(card_arrangement_id, start_date, end_date, status)
--VALUES(1, '2023-04-01', '2028-04-01', 'ACTIVE');
--
--INSERT INTO Customer(authorization_level)
--VALUES(ARRAY['REPLACE', 'CHANGE_LIMIT', 'BLOCK', 'UNBLOCK'],'2');
--
--INSERT INTO CardArrangement(customer_id)
--VALUES(2);
--
--INSERT INTO Card(card_arrangement_id, start_date, end_date, status)
--VALUES(2, '2023-05-01', '2028-05-01', 'BLOCKED');
--
--INSERT INTO Customer(authorization_level)
--VALUES(ARRAY['REPLACE', 'CHANGE_LIMIT', 'ISSUE', 'BLOCK', 'UNBLOCK'],'3');
--
--INSERT INTO CardArrangement(customer_id)
--VALUES(3);
--
--INSERT INTO Card(card_arrangement_id, start_date, end_date, status)
--VALUES(3, '2023-08-01', '2028-08-01', 'INACTIVE');
