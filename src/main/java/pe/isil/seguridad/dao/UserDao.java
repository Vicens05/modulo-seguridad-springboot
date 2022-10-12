package pe.isil.seguridad.dao;

import org.springframework.stereotype.Repository;
import pe.isil.seguridad.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {


    public List<User> getUsers() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = null;
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/moduloseg","root","root");

        Statement st = connection.createStatement();

        ResultSet rs = st.executeQuery("select name,lastname,email from users");
        List<User> users = new ArrayList<>();

        int count= 1;
        while(rs.next()){
            User user = new User(
                    count,
                    rs.getString("name"),
                    rs.getString("lastname"),
                    rs.getString("email"),
                    "",
                    LocalDate.now()
            );
            count++;
            users.add(user);
        }
        return users;
    }

}
