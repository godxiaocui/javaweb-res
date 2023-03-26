import com.czh.javaweb.mapper.BrandMapper;
import com.czh.javaweb.mapper.UserMapper;
import com.czh.javaweb.pojo.Brand;
import com.czh.javaweb.pojo.User;
import com.czh.javaweb.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;


import java.util.List;

public class mybatistest {
    @Test
    public void MybatisTest(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);
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
