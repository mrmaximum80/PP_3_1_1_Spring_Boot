package springboot.app.service;


import springboot.app.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(long id);

    void addUser(User user);

    boolean deleteUser(long id);

    boolean updateUser(User user);

    default void defaultUsers() {
        addUser(new User("Иван", "Иванов", 20));
        addUser(new User("Петр", "Петров", 30));
        addUser(new User("Семен", "Семенов", 40));
        addUser(new User("Василий", "Васильев", 50));
        addUser(new User("Сергей", "Сергеев", 60));
    }
}
