/*Creamos la tabla*/
create table JUGADORES (
	id int,
	name varchar(255),
	lastname varchar(255),
	team varchar(75),
	nacionalidad varchar(100),
	dorsal int
)

/*Añadimos id como primary*/
alter table jugadores add primary key (id);

/*Insertamos jugadores*/
insert into JUGADORES
values (1, 'Leonel', 'Messi','Paris Saint-Germain', 'Argentina', 30);
insert into JUGADORES
values (2, 'Cristiano', 'Ronaldo','Manchester United', 'Portugal', 7);
insert into JUGADORES
values (3, 'Ronald', 'Araujo','Barcelona', 'Uruguay', 4);
insert into JUGADORES
values (4, 'Robert', 'Lewandowski','Barcelona', 'Polonia', 9);
insert into JUGADORES
values (5, 'Karim', 'Benzema','Real Madrid', 'Francia', 9);

/*Vemos la tabla*/
select * from JUGADORES

/*Creamos un método para enlistar*/
create procedure listarAllJugadores()
begin
	select * from JUGADORES;
END

call listarAllJugadores() ;
/*Método eliminar*/
CREATE PROCEDURE eliminarJugador (IN p_name VARCHAR(255),
								  in p_lastname VARCHAR(255))
       begin

	    delete from Jugadores
	    where name = p_name and lastname = p_lastname;

       end

