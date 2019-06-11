create table Customer(
customer_number int(50) NOT NULL,
fullname varchar(30) NOT NULL,
address varchar(50) NOT NULL,
email varchar(50) NOT NULL unique,
phone integer(10) NOT NULL unique,
primary key(customer_number)
);
create table Account(
account_number int(50) NOT NULL,
account_type varchar(10) NOT NULL,
date_open_account date NOT NULL,
amounts int(50) NOT NULL,
primary key(account_number)
);
create table Tracsaction(
tran_number int(50) NOT NULL,
account_number varchar(10) NOT NULL,
date_tran date NOT NULL,
amounts int(50) NOT NULL,
descriptions varchar(30),
primary key(tran_number),
foreign key(account_number) references Account(account_number)
);
