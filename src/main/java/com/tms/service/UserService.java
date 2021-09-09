package com.tms.service;

import com.tms.UserDao;
import com.tms.dao.HibernateUserDao;
import com.tms.entity.User;

import org.springframework.stereotype.Component;

@Component
public class UserService implements UserDao {

    private final HibernateUserDao hibernateUserDao;

    public UserService(HibernateUserDao hibernateUserDao) {
        this.hibernateUserDao = hibernateUserDao;
    }

    @Override
    public void save(User user) {
        hibernateUserDao.save(user);
    }

    @Override
    public boolean existsUser(String username, String password) {
        return hibernateUserDao.existsUser(username, password);
    }

    @Override
    public boolean existsUsername(String username) {
        return hibernateUserDao.existsUsername(username);
    }

    @Override
    public User getByUsername(String username) {
        return hibernateUserDao.getByUsername(username);
    }

    @Override
    public void updateUsername(String newUsername, long id) {
        hibernateUserDao.updateUsername(newUsername, id);
    }

    @Override
    public void updatePassword(String newPassword, long id) {
        hibernateUserDao.updatePassword(newPassword, id);
    }

    @Override
    public void removeAccount(long id) {
        hibernateUserDao.removeAccount(id);
    }
}
