package springboot.app.dao;



import springboot.app.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUser(long id);

    void addUser(User user);

    boolean deleteUser(long id);

    boolean updateUser(User user);


}
