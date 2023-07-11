--Populate the database

--Customer #1, with 1 Card and 1 CardArrangement

INSERT INTO Customer(customer_number, id, authorization_level)
VALUES ('12345678', 1, 3);

INSERT INTO Card_Arrangement( id, customer_id, card_arrangement_type)
VALUES(1, 1, 'debitCardArrangement');

INSERT INTO Card(id, card_arrangement_id, card_number, start_date, end_date, status)
VALUES(1, 1,'0A1B2C3D', '2023-04-01', '2028-04-01', 'ACTIVE');
--INSERT INTO Card_Arrangement(card_arrangement_type,customer_id)
--VALUES('debitCardArrangement',1);


----Customer #2, with 2 Cards and 1 CardArrangement
--INSERT INTO Customer(authorization_level)
--VALUES(3);
--
--INSERT INTO Card_Arrangement(customer_id)
--VALUES(2);
--
--INSERT INTO Card(card_arrangement_id, start_date, end_date, status)
--VALUES(2, '2023-05-01', '2028-05-01', 'BLOCKED');
--
--INSERT INTO Card(card_arrangement_id, start_date, end_date, status)
--VALUES(2, '2023-07-01', '2028-07-01', 'ACTIVE');
--
--INSERT INTO Customer_Card_Arrangements(customer_id, Card_ArrangementS_Id)
--VALUES(2,2);
--
--INSERT INTO CARD_ARRANGEMENT_CARDS(card_arrangement_id, cards_id)
--VALUES(2,2);
--
----Customer #3, with 1 Card and 1 CardArrangement
--INSERT INTO Customer(authorization_level)
--VALUES(2);
--
--INSERT INTO Card_Arrangement(customer_id)
--VALUES(3);
--
--INSERT INTO Card(card_arrangement_id, start_date, end_date, status)
--VALUES(3, '2023-07-01', '2028-07-01', 'INACTIVE');
--
--INSERT INTO Customer_Card_ArrangementS(customer_id, Card_ArrangementS_Id)
--VALUES(3,3);
--
--INSERT INTO CARD_ARRANGEMENT_CARDS(card_arrangement_id, cards_id)
--VALUES(3,3);
