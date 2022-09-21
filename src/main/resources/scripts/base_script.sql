show tables;


/*Crear tabla*/
create table USERS (
	id int,
	name varchar(255),
	lastname varchar(255),
	username varchar(20),
	pass varchar(100),
	tipDoc char(5),
	nroDoc varchar(20),
	enable int
)

/*Añadimos id como primary*/
alter table USERS add primary key (id); /*Creamos el primary key*/

ALTER TABLE moduloseg.users MODIFY COLUMN id int auto_increment NOT NULL; /*Ponemos auto_increment para el id y colocamos que no sea nulo*/



/*Insertar*/
insert into USERS (name, lastname, username, pass, tipDoc, nroDoc, enable)
values ('Jose','Zuniga','DNI73267572','123456','DNI','73267572',1);

insert into USERS (name, lastname, username, pass, tipDoc, nroDoc, enable)
values ('Maria','Santillan','DNI46299021','123456','DNI','46299021',1);


/*Actualizar*/
update USERS set NAME='Mariana' where username ='DNI46299021';


/*Eliminar*/
delete from USERS where USERNAME ='DNI73267572';


/*Consultar*/
select * from Users