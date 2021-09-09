package com.tms.dao;

import com.tms.Constants;
import lombok.extern.slf4j.Slf4j;
import com.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Repository
public class HibernateUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    public boolean existsUser(String username, String password) {
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            boolean existsUsername = currentSession.createQuery(Constants.USER_GET_BY_USERNAME)
                    .setParameter("username", username)
                    .setMaxResults(1).uniqueResult() != null;
            boolean existsPass = currentSession.createQuery(Constants.USER_GET_BY_PASS)
                    .setParameter("password", password)
                    .setMaxResults(1).uniqueResult() != null;
            if (!existsPass || !existsUsername) return false;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return true;
    }

    public boolean existsUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        if (username.trim().isEmpty()) return false;
        boolean existsUsername = currentSession.createQuery(Constants.USER_GET_BY_USERNAME)
                .setParameter("username", username)
                .setMaxResults(1).uniqueResult() != null;
        if (!existsUsername) return false;

        return true;
    }

    public User getByUsername(String username) {
        User user = null;
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> userQuery = currentSession.createQuery(Constants.USER_GET_BY_USERNAME, User.class)
                .setParameter("username", username);
        user = userQuery.getSingleResult();
        return user;
    }

    public void updateUsername(String newUsername, long id) {
        Session currentSession = sessionFactory.getCurrentSession();

        User user = currentSession.load(User.class, id);
        user.setUsername(newUsername);
        currentSession.update(user);
    }

    public void updatePassword(String newPassword, long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.load(User.class, id);
        user.setPassword(newPassword);
        currentSession.update(user);
    }

    public void removeAccount(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = new User();
        user.setId(id);
        currentSession.remove(user);
    }
}

