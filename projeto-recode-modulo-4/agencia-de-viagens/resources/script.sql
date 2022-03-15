CREATE DATABASE agencia_de_viagens
CREATE table cliente(
	id_cliente int not null auto_increment primary key,
	nome_cliente varchar(50),
	cpf_cliente varchar(11),
	login varchar(16),
	senha varchar(12),
	contato varchar(14)
)
create table destino(
	id_destino int not null auto_increment primary key,
	contato_destino varchar(14),
	adress varchar(70),
	tipo varchar(20),
	descricao varchar(300),
	val_diaria decimal(10,2)
)
create table reserva(
	id_reserva int not null auto_increment primary key,
	id_cliente int not null,
	id_destino int not null,
	data_inicio date,
	tempo_reserva int,
	val_reserva decimal(10,2)
)