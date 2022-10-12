package pe.isil.seguridad.service;

import org.springframework.stereotype.Service;
import pe.isil.seguridad.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("userServiceLocal")
public class UserServiceImpl implements UserService{
    public List<User> getUsers(){

        List<User> users = new ArrayList<>();
        User user1 = new User(
                1,
                "Andrea",
                "Zuñiga",
                "andre@isil.pe",
                "123456",
                LocalDate.of(1990,05,04)
        );      //Forma de crear un LocalDate
        User user2 = new User(
                2,
                "Jose",
                "Garcia",
                "jose@isil.pe",
                "123456",
                LocalDate.of(1978,12,18)
        );
        User user3 = new User(
                3,
                "Mariana",
                "Guardiola",
                "mariana@isil.pe",
                "123456",
                LocalDate.of(1992,9,05)
        );
        User user4 = new User(
                4,
                "Joey",
                "Soto",
                "joey@isil.pe",
                "123456",
                LocalDate.of(1992,9,05)
        );

        users.add(user1);
        users.add(user2);
        users.add(user3);

        return List.of(user1,user2,user3);
    }
}
