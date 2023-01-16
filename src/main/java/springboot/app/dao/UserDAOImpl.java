package springboot.app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.app.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("from User");
        List<User> users = query.getResultList();
        return users;
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(long id) {
        Query query = entityManager.createQuery("from User where id = :userid");
        query.setParameter("userid", id);
        if (!query.getResultList().isEmpty()) {
            return (User) query.getSingleResult();
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public boolean deleteUser(long id) {
        Query query = entityManager.createQuery("from User where id = :userid");
        query.setParameter("userid", id);
        if (!query.getResultList().isEmpty()) {
            User user = (User) query.getSingleResult();
            entityManager.remove(user);
            return true;
        } else return false;
    }

    @Transactional
    @Override
    public boolean updateUser(User updatedUser) {
        Query query = entityManager.createQuery("from User where id = :userid");
        query.setParameter("userid", updatedUser.getId());
        if (!query.getResultList().isEmpty()) {
            User user = (User) query.getSingleResult();
            user.setName(updatedUser.getName());
            user.setSurname(updatedUser.getSurname());
            user.setAge(updatedUser.getAge());
            entityManager.persist(user);
            return true;
        } else {
            return false;
        }
    }
}
