create table customer (
id bigint not null auto_increment,
name varchar(50) not null,
status_register varchar(50) not null,
cpf varchar(11),
cnpj varchar (14),
type int,
primary key (id)
);


create table address (
id bigint not null auto_increment,
street varchar(50) not null,
neighborhood varchar(50) not null,
customer_id bigint not null,
number varchar(50) not null,
city varchar(50) not null,
create_register datetime null,
update_register datetime null,
primary key (id),
constraint fk_address_customer foreign key (customer_id) references customer (id)
);

create table product(
id bigint not null auto_increment,
describe varchar(50) not null,
price decimal(15,2) not null,
primary key (id)
);

create table orders(
id bigint not null auto_increment,
describe varchar(50) not null,
customer_id bigint not null,
total decimal(15,2) not null,
status_order varchar(50) not null,
amount_items bigint not null,
primary key (id),
constraint fk_order_customer foreign key (customer_id) references customer (id));

create table order_item (
id bigint not null auto_increment,
product_id bigint not null,
quantity bigint not null,
price decimal(15,2) not null,
total decimal(15,2) not null,
order_id bigint not null,
primary key (id),
constraint fk_item_product foreign key (product_id) references product (id),
constraint fk_item_order foreign key (order_id) references orders (id));