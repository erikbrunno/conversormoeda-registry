create table rastreamento_problema (
	id bigint not null auto_increment,
	stacktrace text not null,
	
	primary key(id)
);


create table problema (
	id bigint not null auto_increment,
	codigo_http bigint(3) not null,
	tipo varchar(256) not null,
	titulo varchar(256) not null,
	detalhe varchar(256) not null,
	rastreamento_id bigint not null,
    data_hora timestamp not null,
    data_hora_cadastro timestamp not null default current_timestamp,

	primary key(id),
	constraint fk_rastreamento_problema_problema foreign key (rastreamento_id) references rastreamento_problema (id)
);

