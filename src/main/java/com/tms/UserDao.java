package com.tms;

import com.tms.entity.User;

public interface UserDao {

    void save(User user);

    boolean existsUser(String username, String password);

    boolean existsUsername(String username);

    User getByUsername(String username);

    void updateUsername(String newUsername, long id);

    void updatePassword(String newPassword, long id);

    void removeAccount(long id);
}
