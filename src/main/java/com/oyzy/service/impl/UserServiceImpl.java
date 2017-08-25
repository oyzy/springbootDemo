package com.oyzy.service.impl;

import com.oyzy.dao.UserMapper;
import com.oyzy.entity.User;
import com.oyzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer add(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public Integer deleteById(Long id) {
        return userMapper.delete(id);
    }

    @Override
    public Integer edit(User user) {
        return userMapper.update(user);
    }

}
