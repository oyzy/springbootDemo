package com.oyzy.service;


import com.oyzy.entity.User;

import java.util.List;

public interface UserService extends BaseService{
    Integer add(User user);

    List<User> findAll();

    User findById(Long id);

    Integer deleteById(Long id);

    Integer edit(User user);
}
