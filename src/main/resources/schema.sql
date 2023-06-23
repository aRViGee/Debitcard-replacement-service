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
--card_id INTEGER auto_increment,
card_id SERIAL PRIMARY KEY,
card_arrangement_id INTEGER auto_increment,
start_date DATE NOT NULL,
end_date DATE NOT NULL,
status ENUM('active', 'inactive', 'blocked', 'expired') NOT NULL
);

CREATE TABLE IF NOT EXISTS Customer(
--customer_id INTEGER auto_increment,
customer_id SERIAL PRIMARY KEY,
allowed_actions ENUM('replace', 'changeLimit', 'issue', 'block', 'unblock') ARRAY,
authorization_level ENUM('level1','level2','level3','level4','level5')
);

CREATE TABLE IF NOT EXISTS CardArrangement(
--card_arrangement_id INTEGER auto_increment,
card_arrangement_id SERIAL PRIMARY KEY,
card_id INTEGER NOT NULL,
customer_id INTEGER NOT NULL
);