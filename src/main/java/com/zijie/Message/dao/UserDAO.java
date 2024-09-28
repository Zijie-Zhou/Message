package com.zijie.Message.dao;

import com.zijie.Message.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {
    @Insert("insert into user (`username`, `nickname`, `password`, `phone_number`, `gender`, `register_time`) values (#{username}, #{nickname}, #{password}, #{phoneNumber}, #{gender}, #{registerTime})")
    int insert(User user);

    @Select("SELECT * FROM user WHERE username = #{name}")
    User checkUsername(@Param("name") String name);

    @Select("SELECT * FROM user WHERE nickname = #{name}")
    User checkNickname(@Param("name") String name);

    @Select("SELECT * FROM user WHERE phone_number = #{number}")
    User checkPhone_number(@Param("number") String number);

    @Select("SELECT password FROM user WHERE username = #{name}")
    String checkPassword(@Param("password") String password);
}
