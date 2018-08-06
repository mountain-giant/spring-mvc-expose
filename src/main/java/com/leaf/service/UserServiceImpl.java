package com.leaf.service;

import com.leaf.mybatis.mapper.UserMapper;
import com.leaf.mybatis.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public User selectByUserId(int id) {
        return userMapper.selectByUserId(id);
    }

    /**
     * 声明式事务是无效的
     *
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        return doAddUser(user);
    }

    @Override
    @Transactional
    public int doAddUser(User user) {
        int i = userMapper.insertUser(user);
        throw new RuntimeException("插入失败");
    }
}
