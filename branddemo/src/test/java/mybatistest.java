import com.czh.javaweb.mapper.UserMapper;
import com.czh.javaweb.pojo.User;
import com.czh.javaweb.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class mybatistest {
    public static void main(String[] args) {
        DOMConfigurator.configure("log4j.xml");

        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warn message");
        logger.error("Error message");
        logger.fatal("Fatal message");
    }

    private static final Logger logger = Logger.getLogger(mybatistest.class);

    @Test
    public void MybatisTest() throws IOException {
        String username="zhangsan";
        String password="123";
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUsername(username);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void MybatisUserTest(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.select("zhangsan","123");
        System.out.println(user);
    }
}
