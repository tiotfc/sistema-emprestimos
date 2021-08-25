insert into cliente(cpf, data_contratacao, nome, patrimonio, salario) values ('111.111.111-12','2021-01-01','Cliente 1',250000.00, 2500.00);
insert into cliente(cpf, data_contratacao, nome, patrimonio, salario) values ('222.222.222-12','2020-01-01','Cliente 2',250000.00, 2500.00);
insert into cliente(cpf, data_contratacao, nome, patrimonio, salario) values ('333.333.333-12','2019-01-01','Cliente 3',250000.00, 2500.00);
insert into cliente(cpf, data_contratacao, nome, patrimonio, salario) values ('444.444.444-12','2018-01-01','Cliente 4',250000.00, 2500.00);

insert into conta(agencia, numero, saldo, cliente_id) values ('0001','00000001111', 11050.00 , 1);
insert into conta(agencia, numero, saldo, cliente_id) values ('0002','00000002222', 11050.00 , 2);
insert into conta(agencia, numero, saldo, cliente_id) values ('0003','00000003333', 11050.00 , 3);
insert into conta(agencia, numero, saldo, cliente_id) values ('0004','00000004444', 11050.00 , 4);


insert into proposta(data_contratacao, qtd_parcelas, status, taxa_juros, valor, cliente_id) values('2021-05-01', 2, 'aberta', 0.15, 2000.00, 1);
insert into proposta(data_contratacao, qtd_parcelas, status, taxa_juros, valor, cliente_id) values('2021-05-01', 2, 'aberta', 0.15, 2000.00, 2);
insert into proposta(data_contratacao, qtd_parcelas, status, taxa_juros, valor, cliente_id) values('2021-05-01', 2, 'aberta', 0.15, 2000.00, 3);
insert into proposta(data_contratacao, qtd_parcelas, status, taxa_juros, valor, cliente_id) values('2021-05-01', 2, 'aberta', 0.15, 2000.00, 4);

insert into parcela(data_parcela, numero, status, valor, proposta_id) values ('2021-05-01', 1, 'PAGA', 1000.00, 1);
insert into parcela(data_parcela, numero, status, valor, proposta_id) values ('2021-06-01', 1, 'ABERTA', 1000.00, 1);
insert into parcela(data_parcela, numero, status, valor, proposta_id) values ('2021-05-01', 1, 'PAGA', 1000.00, 2);
insert into parcela(data_parcela, numero, status, valor, proposta_id) values ('2021-06-01', 1, 'ABERTA', 1000.00, 2);
insert into parcela(data_parcela, numero, status, valor, proposta_id) values ('2021-05-01', 1, 'PAGA', 1000.00, 3);
insert into parcela(data_parcela, numero, status, valor, proposta_id) values ('2021-05-01', 1, 'PAGA', 1000.00, 4);


INSERT INTO usuario VALUES (null,'joao@hotmail.com','$2a$12$pdlJY7IGuULz44gDcwzOKeW0YhIGRwPG3aHUw5TxMxgUV60KEwp6y');

INSERT INTO perfil VALUES(null,'USUARIO');
INSERT INTO perfil VALUES(null,'ADM');

INSERT INTO usuario_perfis VALUES (1,1);
