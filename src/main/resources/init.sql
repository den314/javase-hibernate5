insert into finances_user (first_name, last_name) values ('denis', 'szcz');
insert into finances_user (first_name, last_name) values ('dan', 'trias');

insert into credential (user_id, username, password) values (1, 'login111', 'pass12');
insert into credential (user_id, username, password) values (2, 'traisss', 'hib5');

insert into ACCOUNT (USER_ID, CURRENT_BALANCE) values (1, 100.5);
insert into ACCOUNT (USER_ID, CURRENT_BALANCE) values (2, 20.5);

insert into TRANSACTION(ACCOUNT_ID, AMOUNT, NOTES) values (1, 10, 'allegro shopping');
insert into TRANSACTION(ACCOUNT_ID, AMOUNT, NOTES) values (1, 10, 'zalando');
insert into TRANSACTION(ACCOUNT_ID, AMOUNT, NOTES) values (2, 30, 'fishes');