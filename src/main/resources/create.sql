drop table if exists finances_user;
create table if not exists finances_user (
  user_id int primary key auto_increment,
  first_name varchar(50) not null,
  last_name varchar(50) not null
--   birth_date date not null,
--   email_address varchar(100) not null,
--   last_updated_by varchar(50),
--   last_updated_date datetime,
--   created_by varchar(50),
--   created_date datetime
);

drop table if exists credential;
create table if not exists credential (
  credential_id int primary key auto_increment,
  user_id int not null unique,
  username varchar(40) not null,
  password varchar(40) not null,
  foreign key (user_id) references finances_user(user_id)
);

drop table if exists account;
create table if not exists account (
  account_id int primary key auto_increment,
  user_id int not null unique,
  current_balance decimal not null,
  foreign key (user_id) references finances_user(user_id)
);

drop table if exists transaction;
create table if not exists transaction (
  transaction_id int primary key auto_increment,
  account_id int not null,
  amount decimal not null,
  notes varchar not null,
  foreign key (account_id) references account(account_id)
)