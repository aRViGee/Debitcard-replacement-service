--Populate the database

--Customer #1, with 2 CardArrangements and 1 Card

INSERT INTO Customer(customer_number, authorization_level)
VALUES ('12345678', 3);

INSERT INTO Card_Arrangement( customer_id, card_arrangement_type)
VALUES(1, 'Debit cards');

INSERT INTO Card_Arrangement( customer_id, card_arrangement_type)
VALUES(1, 'Credit cards');

INSERT INTO Card( card_arrangement_id, card_number, start_date, end_date, status)
VALUES(1,'0A1B2C3D', '2023-04-01', '2028-04-01', 'ACTIVE');

--Customer #2, with 2 CardArrangements and 2 Cards

INSERT INTO Customer(customer_number, authorization_level)
VALUES ('23456789', 2);

INSERT INTO Card_Arrangement( customer_id, card_arrangement_type)
VALUES(2, 'Debit cards');

INSERT INTO Card_Arrangement( customer_id, card_arrangement_type)
VALUES(2, 'Credit cards');

INSERT INTO Card(card_arrangement_id, card_number, start_date, end_date, status)
VALUES(3,'4E5F6G7H', '2023-05-01', '2028-05-01', 'ACTIVE');

INSERT INTO Card(card_arrangement_id, card_number, start_date, end_date, status)
VALUES(3,'8I9J0K1L', '2023-08-01', '2028-08-01', 'INACTIVE');

--Customer #3, with 2 CardArrangements and 2 Cards
INSERT INTO Customer(customer_number, authorization_level)
VALUES ('34567890', 1);

INSERT INTO Card_Arrangement( customer_id, card_arrangement_type)
VALUES(3, 'Debit cards');

INSERT INTO Card_Arrangement( customer_id, card_arrangement_type)
VALUES(3, 'Credit cards');

INSERT INTO Card( card_arrangement_id, card_number, start_date, end_date, status)
VALUES(5,'2M3N4O5P', '2023-04-01', '2028-04-01', 'BLOCKED');

INSERT INTO Card( card_arrangement_id, card_number, start_date, end_date, status)
VALUES(5,'6Q7R8S9T', '2018-07-01', '2023-07-01', 'EXPIRED');