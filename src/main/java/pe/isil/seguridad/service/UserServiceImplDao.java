package pe.isil.seguridad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.seguridad.dao.UserDao;
import pe.isil.seguridad.model.User;

import java.util.List;

@Service("userServiceDao")
public class UserServiceImplDao implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getUsers() {
        try{
            return userDao.getUsers();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
