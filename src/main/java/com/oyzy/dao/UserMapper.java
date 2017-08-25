package com.oyzy.dao;


import com.oyzy.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into t_user(name,age) values(#{name},#{age})")
    Integer insert(User user);

    @Select("select id,name,age from t_user")
    List<User> findAll();

    @Select("select id,name,age from t_user where id = #{id}")
    User findById(Long id);

    @Delete("delete from t_user where id = #{id}")
    Integer delete(Long id);

    @Update("update t_user set name = #{name}, age = #{age} where id = #{id}")
    Integer update(User user);

}
