package com.mmdxiaoxin.service;


import com.mmdxiaoxin.dao.UserDao;
import com.mmdxiaoxin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsersService {
    private final UserDao userDAO;

    @Autowired
    public UsersService(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    public boolean validateUser(String username, String password) {
        //确保用户名和密码不为空
        if (username == null || username.isEmpty()) {
            return false;
        }
        User user = userDAO.selectByUsername(username);
        return Objects.equals(user.getPassword(), password);
    }
}
