package com.choi.spring.persistence;

import com.choi.spring.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by choi on 2017. 6. 2..
 */
@Repository
public interface UserMapper {

    @Insert("INSERT INTO users(name, pw, level, login, recommend) VALUES(#{name}, #{pw}, 'BRONZE', 0, 0)")
    @SelectKey(statement = "SELECT id FROM users", keyProperty = "id", resultType = int.class, before = true)
    int insertUser(@Param("name") String name, @Param("pw") String pw);

    @Select("SELECT * FROM users")
    ArrayList<User> getUsers();

    @Select("SELECT * FROM users WHERE name=#{name}")
    User getUser(@Param("name") String name);

    @Delete("DELETE FROM users WHERE name=#{name}")
    void deleteUser(@Param("name") String name) throws Exception;

}
