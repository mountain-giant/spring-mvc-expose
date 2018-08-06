package com.leaf.service;

import com.leaf.mybatis.user.User;

public interface UserService {

    User selectByUserId(int id);

    int addUser(User user);

    int doAddUser(User user);
}
