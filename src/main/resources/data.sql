insert into usuario(nome,cpf,data_nascimento,email,senha) values('Alberto Augusto','12365478978','1984-05-15','albertoa@hotmail.com','$2a$12$pdlJY7IGuULz44gDcwzOKeW0YhIGRwPG3aHUw5TxMxgUV60KEwp6y'); 
insert into usuario(nome,cpf,data_nascimento,email,senha) values('Alberto Roberto','87455447747','1988-04-20','albertor@hotmail.com','$2a$12$pdlJY7IGuULz44gDcwzOKeW0YhIGRwPG3aHUw5TxMxgUV60KEwp6y'); 
insert into usuario(nome,cpf,data_nascimento,email,senha) values('Maria Clara','74587425856','2000-09-01','maria@hotmail.com','$2a$12$pdlJY7IGuULz44gDcwzOKeW0YhIGRwPG3aHUw5TxMxgUV60KEwp6y'); 
insert into usuario(nome,cpf,data_nascimento,email,senha) values('Juliana Santos','32589674125','1999-02-25','juliana@hotmail.com','$2a$12$pdlJY7IGuULz44gDcwzOKeW0YhIGRwPG3aHUw5TxMxgUV60KEwp6y');

INSERT INTO perfil VALUES(null,'ROLE_USUARIO');
INSERT INTO perfil VALUES(null,'ROLE_ADM');

INSERT INTO usuario_perfis VALUES (1,1);
INSERT INTO usuario_perfis VALUES (2,2);

insert into categoria values (null, 'videogames');
insert into produto (id, categoria_id, nome, preco) values (null, 1, 'Playstation 4', 2500.0);
insert into produto (id, categoria_id, nome, preco) values (null, 1, 'X-box', 2000.0);
insert into categoria values (null, 'celulares');
insert into produto (id, categoria_id, nome, preco) values (null, 2, 'Samsung S21', 5000.0);
insert into produto (id, categoria_id, nome, preco) values (null, 2, 'Iphone X', 4000.0);
insert into produto (id, categoria_id, nome, preco) values (null, 2, 'Motorola Edge', 3800.0);
insert into produto (id, categoria_id, nome, preco) values (null, 2, 'Xiaomi M9', 3500.0);
insert into categoria values (null, 'roupas');
insert into produto (id, categoria_id, nome, preco) values (null, 3, 'Jaqueta de Couro', 500.0);
insert into produto (id, categoria_id, nome, preco) values (null, 3, 'Blusca de frio North Face', 400.0);
insert into produto (id, categoria_id, nome, preco) values (null, 3, 'Calça Jeans Khelf', 200.0);
insert into categoria values (null, 'eletrodomésticos');
insert into produto (id, categoria_id, nome, preco) values (null, 4, 'Tv Philips 32 p', 2000.0);
insert into produto (id, categoria_id, nome, preco) values (null, 4, 'Lava e seca Brastemp', 3450.0);
insert into produto (id, categoria_id, nome, preco) values (null, 4, 'Microondas Philco', 850.0);

insert into pedido VALUES (null,'2020-05-10',2500.0,1);
insert into item_pedido VALUES (null,1,2500.0,1,1);

insert into pedido VALUES (null,'2020-05-20',700.0,1);
insert into item_pedido VALUES (null,1,200.0,2,9);
insert into item_pedido VALUES (null,1,500.0,2,7);

insert into pedido VALUES (null,'2020-05-08',1100.0,2);
insert into item_pedido VALUES (null,1,200.0,3,9);
insert into item_pedido VALUES (null,1,400.0,3,8);
insert into item_pedido VALUES (null,1,500.0,3,7);

insert into pedido VALUES (null,'2020-05-20',3450.0,3);
insert into item_pedido VALUES (null,1,3450.0,4,11);

insert into pedido VALUES (null,'2020-08-12',2000.0,4);
insert into item_pedido VALUES (null,1,2000.0,5,10);

insert into pedido VALUES (null,'2020-02-10',2000.0,2);
insert into item_pedido VALUES (null,1,2000.0,6,10);
