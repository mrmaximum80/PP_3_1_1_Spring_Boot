package springboot.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.app.dao.UserDAO;
import springboot.app.model.User;

import java.util.List;

@Component
public class UseServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UseServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        List users = userDAO.getAllUsers();
        System.out.println(users);
        return users;
    }

    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public boolean deleteUser(long id) {
        return userDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }
}
