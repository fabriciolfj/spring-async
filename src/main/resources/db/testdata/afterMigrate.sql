delete from customer;
delete from address;
delete from order_item;
delete from orders;
delete from product;

insert into customer(id, name, status_register, cnpj, cpf, type) values (1, 'Fabricio', 'ATIVE', '32351345000186', '', 1);
insert into customer(id, name, status_register, cnpj, cpf, type) values (2, 'Joao', 'INATIVE', '', '33965986830', 2);

insert into address(id, street, neighborhood, customer_id, number, city) values (1, 'Rua Pernambuco', 'Centro',1,'988', 'São Paulo');
insert into address(id, street, neighborhood, customer_id, number, city)  values (2, 'Rua Pernambuco', 'Centro',2, '10022', 'São Paulo');

insert into product(id, describe, price) values (1, 'Feijao', 8.90);
insert into product(id, describe, price) values (2, 'Arroz', 14.89);
insert into product(id, describe, price) values (3, 'Farinha', 25.76);
insert into product(id, describe, price) values (4, 'Queijo', 0.88);

insert into orders (id, describe, customer_id, total, status_order, amount_items) values (1, 'Venda varejo', 1, 23.79, 'PENDING', 2);
insert into orders (id, describe, customer_id, total, status_order, amount_items) values (2, 'Venda varejo', 2, 0.88, 'PENDING', 1);

insert into order_item(id, product_id, quantity, price, total, order_id) values (1, 1, 1, 8.90,  8.90,  1);
insert into order_item(id, product_id, quantity, price, total, order_id) values (2, 2, 1, 14.89, 14.89, 1);
insert into order_item(id, product_id, quantity, price, total, order_id) values (3, 2, 1, 0.88,  0.88,  2);
