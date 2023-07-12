--Populate the database

--Customer #1, with 1 CardArrangement and 1 Card

INSERT INTO Customer(customer_number, id, authorization_level)
VALUES ('12345678', 1, 3);

INSERT INTO Card_Arrangement( id, customer_id, card_arrangement_type)
VALUES(1, 1, 'Debit cards');

INSERT INTO Card( card_arrangement_id, card_number, start_date, end_date, status)
VALUES( 1,'0A1B2C3D', '2023-04-01', '2028-04-01', 'ACTIVE');

--Customer #2, with 1 CardArrangement and 2 Cards

INSERT INTO Customer(customer_number, id, authorization_level)
VALUES ('23456789', 2, 2);

INSERT INTO Card_Arrangement( id, customer_id, card_arrangement_type)
VALUES(2, 2, 'Debit cards');

INSERT INTO Card(card_arrangement_id, card_number, start_date, end_date, status)
VALUES(2,'4E5F6G7H', '2023-05-01', '2028-05-01', 'ACTIVE');

INSERT INTO Card(card_arrangement_id, card_number, start_date, end_date, status)
VALUES( 2,'8I9J0K1L', '2023-08-01', '2028-08-01', 'INACTIVE');

