import com.czh.javaweb.mapper.UserMapper;
import com.czh.javaweb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class testmybatis {
@Test
    public void testmybatis () throws IOException {
    String username="zhangsan";
    String password="123";
    InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
    SqlSession sqlSession = build.openSession(true);
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    User user = mapper.selectUser(username, password);
    System.out.println(user);
    sqlSession.close();
    }
}
