--Populate the database

--Customer #1, with 1 Card and 1 CardArrangement
INSERT INTO Customer(authorization_level)
VALUES(1);

INSERT INTO Card_Arrangement(customer_id)
VALUES(1);

INSERT INTO Card(card_arrangement_id, start_date, end_date, status)
VALUES(1, '2023-04-01', '2028-04-01', 'ACTIVE');

INSERT INTO Customer_Card_ArrangementS(customer_id, Card_ArrangementS_Id)
VALUES(1,1);

INSERT INTO CARD_ARRANGEMENT_CARDS(card_arrangement_id, cards_id)
VALUES(1,1);

--Customer #2, with 2 Cards and 1 CardArrangement
INSERT INTO Customer(authorization_level)
VALUES(3);

INSERT INTO Card_Arrangement(customer_id)
VALUES(2);

INSERT INTO Card(card_arrangement_id, start_date, end_date, status)
VALUES(2, '2023-05-01', '2028-05-01', 'BLOCKED');

INSERT INTO Card(card_arrangement_id, start_date, end_date, status)
VALUES(2, '2023-07-01', '2028-07-01', 'ACTIVE');

INSERT INTO Customer_Card_ArrangementS(customer_id, Card_ArrangementS_Id)
VALUES(2,2);

INSERT INTO CARD_ARRANGEMENT_CARDS(card_arrangement_id, cards_id)
VALUES(2,2);

--Customer #3, with 1 Card and 1 CardArrangement
INSERT INTO Customer(authorization_level)
VALUES(2);

INSERT INTO Card_Arrangement(customer_id)
VALUES(3);

INSERT INTO Card(card_arrangement_id, start_date, end_date, status)
VALUES(3, '2023-07-01', '2028-07-01', 'INACTIVE');

INSERT INTO Customer_Card_ArrangementS(customer_id, Card_ArrangementS_Id)
VALUES(3,3);

INSERT INTO CARD_ARRANGEMENT_CARDS(card_arrangement_id, cards_id)
VALUES(3,3);
