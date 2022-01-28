package com.zijie.Message.dao;

import com.zijie.Message.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {
    @Insert("insert into user (`username`, `nickname`, `password`, `phone_number`, `gender`, `register_time`) values (#{username}, #{nickname}, #{password}, #{phoneNumber}, #{gender}, #{registerTime})")
    int insert(User user);

}
