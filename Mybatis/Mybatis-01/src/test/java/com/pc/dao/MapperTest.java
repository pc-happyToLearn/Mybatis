package com.pc.dao;

import com.pc.pojo.User;
import com.pc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapperTest {
    @Test
    public void getUserLike(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        Mapper mapper=sqlSession.getMapper(Mapper.class);
        List<User> userList=mapper.getUserLike("李");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //执行sql,这里的mapper是Mapper接口的实现类
            //方式一：
            Mapper mapper=sqlSession.getMapper(Mapper.class);
            List<User> userList = mapper.getUserList();

            //方式二：
            //List<User> userList1 = sqlSession.selectList("com.pc.dao.Mapper.getUserList");
            for (User user:userList){
                System.out.println(user);
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }

    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        Mapper mapper = sqlSession.getMapper(Mapper.class);

        User user=mapper.getUserById(1);
        sqlSession.close();
        System.out.println(user);

    }
    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        Mapper mapper=sqlSession.getMapper(Mapper.class);
        int res=mapper.addUser(new User(3,"潘雅婷","123123"));
        if (res>0){
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Mapper mapper=sqlSession.getMapper(Mapper.class);
        int res=mapper.updateUser(new User(2,"沈忱","131477"));
        if(res>0){
            System.out.println("修改成功!");
        }
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        Mapper mapper=sqlSession.getMapper(Mapper.class);
        mapper.deleteUser(3);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId",4);
        map.put("userName","lyf");
        map.put("password","123123");
        mapper.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }
}
