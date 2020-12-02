create table Filme (
	id int not null auto_increment primary key,
	titulo varchar(200),
	sinopse varchar(8000),
	duracao int,
	dataestreia date,
	idpais int not null,
	idgenero int not null
	) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
	
	alter table Filme add constraint fk_filme_pais foreign key(idpais) references Pais(id);
	alter table Filme add constraint fk_filme_genero foreign key(idgenero) references Genero(id);
	
	insert into Filme(titulo, sinopse, duracao, dataestreia, idpais, idgenero) values
	('O Poderoso Chefão', 'A série de filmes The Godfather consiste em três filmes de drama e suspense policial dirigidos por Francis Ford Coppola com base no romance homônimo do ítalo-americano Mario Puzo. A trilogia narra as tramas envolvendo a Família Corleone, umas das mais poderosas famílias da Máfia italiana nos Estados Unidos.',
	 '180', '1972-07-07', 2, 1),
	    
	('Tropa de Elite', 
	'O capitão da força especial da Polícia Militar do Rio de Janeiro treina dois recrutas novatos para que possam sucedê-lo.', 
	'90','2007-10-05', 1, 2);
	    
	    