package springboot.app.service;

import springboot.app.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(long id);

    void saveUser(User user);

    void deleteUser(long id);

    default void defaultUsers() {
        saveUser(new User("Иван", "Иванов", 20));
        saveUser(new User("Петр", "Петров", 30));
        saveUser(new User("Семен", "Семенов", 40));
        saveUser(new User("Василий", "Васильев", 50));
        saveUser(new User("Сергей", "Сергеев", 60));
    }
}
