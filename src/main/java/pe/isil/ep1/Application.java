package pe.isil.ep1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception{
            SpringApplication.run(Application.class, args);

            //1. Cargar driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2. Crear conexión
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/EP1",
                    "root",
                    "root"
            );
            //3. Crear statement
            // Statement Actualizar registro
            Statement stmt = con.createStatement();
            int resultUpdate = stmt.executeUpdate("insert into JUGADORES values (6, 'Carlos', 'Flores','Sport Boys', 'Peru', 21)");
            System.out.println("Filas afectadas: " + resultUpdate);

            // PreparedStatement ACTUALIZAR
            String consulta = "DELETE FROM JUGADORES WHERE team = ? ";
            PreparedStatement pstm = con.prepareStatement(consulta);
            pstm.setString(1, "Sport Boys");

            //CallableStatement listar
            CallableStatement cs = con.prepareCall("{CALL listarAllJugadores()}");
            cs.executeQuery();


            //4. Ejecutamos
            ResultSet result1 = stmt.executeQuery("Select * FROM JUGADORES where id = 6");
            int result2 = pstm.executeUpdate();
            ResultSet result3 = cs.executeQuery();

            //5. Mostramos resultados
        System.out.println("---------Statement, CREAR REGISTRO---------");
        while(result1.next()) {
            System.out.println("Id: " + result1.getString("id") + "\n" +
                    "Nombre: " + result1.getString("name") + "\n" +
                    "Apellido: " + result1.getString("lastname") + "\n" +
                    "Equipo: " + result1.getString("team") + "\n" +
                    "Nacionalidad: " + result1.getString("nacionalidad") + "\n" +
                    "Nro. dorsal: " + result1.getString("dorsal"));
        }

            System.out.println("---------PreparedStatement, ACTUALIZACION REGISTRO---------");

            System.out.println("Actualizaciones: "+ result2);

            System.out.println("---------CallableStatement, LISTRAR REGISTRO ---------");

            while(result3.next()) {
                    System.out.println("Id: " + result3.getString("id") + "\n" +
                            "Nombre: " + result3.getString("name") + "\n" +
                            "Apellido: " + result3.getString("lastname") + "\n" +
                            "Equipo: " + result3.getString("team") + "\n" +
                            "Nacionalidad: " + result3.getString("nacionalidad") + "\n" +
                            "Nro. dorsal: " + result3.getString("dorsal"));
        }


        //6. Cerramos.
            con.close();
    }
}
