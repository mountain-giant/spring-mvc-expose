package com.leaf.mybatis.mapper;

import com.leaf.mybatis.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User selectByUserId(int id);

    int insertUser(User user);
}
