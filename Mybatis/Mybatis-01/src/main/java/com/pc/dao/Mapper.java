package com.pc.dao;

import com.pc.pojo.User;

import java.util.List;
import java.util.Map;

public interface Mapper {
    //查询全部用户
    List<User> getUserList();
    //根据id查询用户
    User getUserById(int id);
    //插入一个用户
    int addUser(User user);
    //修改用户
    int updateUser(User user);
    //删除一个用户
    int deleteUser(int id);

    int addUser2(Map<String,Object> map);

    List<User> getUserLike(String value);
}
