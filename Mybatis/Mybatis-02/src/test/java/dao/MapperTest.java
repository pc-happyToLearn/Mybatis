package dao;

import com.pc.dao.Mapper;
import com.pc.pojo.User;
import com.pc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapperTest {

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

}
