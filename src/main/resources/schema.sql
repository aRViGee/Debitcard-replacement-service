--create table book(
--id int auto_increment,
--title varchar(255) NOT NULL,
--pages int NOT NULL,
--author varchar(255) NOT NULL
--);

--TODO - Table Card - Link card_arrangement_id to corresponding card_arrangement
--TODO - Table Card_Arrangement - Link card_id to corresponding Card
--TODO - Table Customer - allowed_actions - get an enum array working, with the allowed actions
CREATE TABLE IF NOT EXISTS Card(
id SERIAL PRIMARY KEY,
card_arrangement_id INTEGER UNIQUE NOT NULL,
start_date DATE NOT NULL,
end_date DATE NOT NULL,
status ENUM('active', 'inactive', 'blocked', 'expired') NOT NULL
);

CREATE TABLE IF NOT EXISTS Customer(
id SERIAL PRIMARY KEY,
card_arrangement_id INTEGER UNIQUE NOT NULL,
allowed_actions ENUM('replace', 'changeLimit', 'issue', 'block', 'unblock') ARRAY,
authorization_level ENUM('level1','level2','level3','level4','level5')
);

CREATE TABLE IF NOT EXISTS CardArrangement(
id SERIAL PRIMARY KEY,
card_id INTEGER UNIQUE NOT NULL,
customer_id INTEGER UNIQUE NOT NULL
);

ALTER TABLE Card
ADD CONSTRAINT FK_Card_CardArrangement FOREIGN KEY (card_arrangement_id)
REFERENCES CardArrangement(id);

ALTER TABLE CardArrangement
ADD CONSTRAINT FK_CardArrangement_Card FOREIGN KEY (card_id)
REFERENCES Card(id);

ALTER TABLE CardArrangement
ADD CONSTRAINT FK_CardArrangement_Customer FOREIGN KEY (customer_id)
REFERENCES Customer(id);

ALTER TABLE Customer
ADD CONSTRAINT FK_Customer_CardArrangement FOREIGN KEY (card_arrangement_id)
REFERENCES CardArrangement(id);

