package pe.isil.seguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);

        //Load driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Crear conexion
        Connection conexion =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/moduloseg",
                        "root",
                        "root");

        //Crear Statement
        //Statement st = conexion.createStatement();
        //PreparedStatement pt = conexion.prepareStatement("SELECT * FROM USERS WHERE id = ? and username = ?");
        //pt.setInt(1,2); //El primer ? mándale 3
        //pt.setString(2,"DNI46299021");

        CallableStatement callSp = conexion.prepareCall("{call validarLogin(?,?,?)}");
        callSp.setString(1,"DNI73267572");
        callSp.setString(2, "123456");
        callSp.registerOutParameter(3,Types.INTEGER); //Como salida tiene un int en nuestro sp

        //Ejecutar sentencia
        callSp.executeQuery();

        int resultado = callSp.getInt(3);

        if(resultado == 1){
            System.out.println("Login exitoso");
        }else{
            System.out.println("Usuario o clave incorrecto");
        }


        CallableStatement callSp2 = conexion.prepareCall("{call listarAllUsers()}");
        ResultSet resultadoSP2 = callSp2.executeQuery();

        while (resultadoSP2.next()){
            System.out.println(resultadoSP2.getString("username"));
        }


        CallableStatement callSp3 = conexion.prepareCall("{call listarUserPerId(?)}");
        callSp3.setInt(1,2);
        ResultSet resultadoSP3 = callSp3.executeQuery();

        while (resultadoSP3.next()){
            System.out.println(resultadoSP3.getString("name"));
        }

        //Recorrer el resultado
        //while (resultado.next()){
        //    System.out.println(resultado.getString("name"));
        //}



    }

}
