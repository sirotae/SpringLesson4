package lesson4.dao;

import lesson4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class UserJPADao implements UserDao {

    @PersistenceContext
    EntityManager em;

    public UserJPADao() {
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return em.createQuery("select u from User u").getResultList();
    }

    @Transactional(readOnly = true)
    public User findUserById(int id) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.id=:id", User.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public User createUser(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void remove(User user) {
        em.remove(em.merge(user));
    }

    @Override
    public void remove(int id) {
        User user = findUserById(id);
        em.remove(user);

    }


}