create database mercadopoo
use mercadopoo

create table funcionario(
	cpf char(11) not null,
	nome varchar(50) not null,
	senha varchar(50) not null,
	rua varchar(50),
	numero int,
	bairro varchar(50),
	cidade varchar(50),
	estado varchar(50),
	cep char(8),
	telefone varchar(11),
	privilegio int default(0),
	primary key (cpf)
)

insert into funcionario(cpf, nome, senha, rua, numero, bairro, cidade, estado, cep, telefone, privilegio)
	values('12312312312', 'Matheus F. Nascimento', '827ccb0eea8a706c4c34a16891f84e7b', 'Rua1', 123, 'Itaquera', 'S�o Paulo',
						'SP', 08240660, '11981116773', 2)

insert into funcionario(cpf, nome, senha, rua, numero, bairro, cidade, estado, cep, telefone, privilegio)
	values('32132132132', 'Evandson S. Cruz', '01cfcd4f6b8770febfb40cb906715822', 'Rua2', 321, 'Itaqua', 'S�o Paulo',
						'SP', 32132132, '11321321321', 0)

create table produto(
	codigo_barras varchar(50) not null,
	nome varchar(50) not null,
	categoria int not null default(0),
	preco decimal(7,2) not null check(preco > 0),
	qtde_estoque int not null check(qtde_estoque >= 0),
	descricao varchar(max),
	primary key (codigo_barras)
)

insert into produto(codigo_barras, nome, categoria, preco, qtde_estoque, descricao) 
values('0001', 'Arroz Prato Fino 10kg', 5, 15.99, 50, 'Soltinho igual o Veigar do Scalibacon')

insert into produto(codigo_barras, nome, categoria, preco, qtde_estoque, descricao) 
values('0002', 'Papel Alum�nio 10m', 8, 7.50, 50, 'Platinado e resistente')

insert into produto(codigo_barras, nome, categoria, preco, qtde_estoque, descricao) 
values('0003', 'Max Steel Boexeador', 12, 24.99, 34, 'Criado pra dar muitos socos nos Elementors')

insert into produto(codigo_barras, nome, categoria, preco, qtde_estoque, descricao) 
values('0004', 'Queijo Mussarela', 5, 26.95, 50, 'Gostoso e bem amarelinho')

insert into produto(codigo_barras, nome, categoria, preco, qtde_estoque, descricao) 
values('0005', 'Papel Higi�nico Neve 12', 4, 13.99, 38, 'Bem macio, perfeito pra dar aquela garibada nos gl�teos')

create table venda(
	id int identity(1,1) not null,
	data datetime not null,
	situacao int not null default(1),
	total decimal(7,2) not null check(total > 0),
	funcionario_cpf char(11) not null,
	primary key (id),
	foreign key (funcionario_cpf) references funcionario(cpf)
)

create table itemvenda(
	venda_id int not null,
	produto_codigo_barras varchar(50) not null,
	qtde_produto int not null default(1) check(qtde_produto > 0),
	subtotal decimal(7,2) not null,
	primary key (venda_id, produto_codigo_barras),
	foreign key (venda_id) references venda(id),
	foreign key (produto_codigo_barras) references produto(codigo_barras)
)

create table alteracaoestoque(
	id int identity(1,1) not null,
	data datetime not null, 
	tipo int not null default(1),
	quantidade int not null check(quantidade > 0),
	funcionario_cpf char(11) not null,
	produto_codigo_barras varchar(50) not null,
	primary key (id),
	foreign key (funcionario_cpf) references funcionario(cpf),
	foreign key (produto_codigo_barras) references produto(codigo_barras)
)


