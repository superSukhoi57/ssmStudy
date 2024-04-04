import com.example.mapper.EmployeeMapper;
import com.example.pojo.Employee;
import com.example.pojo.ikun;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class test1 {
    @Test
    public void test_Mybatis() throws IOException {
        //TODO:Mybatis实现步骤：
        //1.读取外部配置文件(mybatis-config.xml)
        InputStream ips= Resources.getResourceAsStream("config.xml");

        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //3.根据sqlSessionFactory创建sqlSession(每次业务创建一个，用完就释放)
        SqlSession sqlSession =sqlSessionFactory.openSession();

        //4.获取接口的代理对象(代理技术)调用代理对象的方法，就会查找mapper接口的方法
        EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
            //调用接口的方法（在xml实现了！）来进行数据库操作！
            Employee employee=mapper.queryByPrice(315);
            System.out.println("employee is "+employee);
        //5.提交事务(非DQL)和释放资源
        sqlSession.commit();//在修改数据的情况下要进行数据提交!
        sqlSession.close();//释放资源。

    }


    @Test
    public void test_ibatis() throws IOException {
        //TODO:ibatis实现步骤：
        //1.读取外部配置文件(mybatis-config.xml)
        InputStream ips= Resources.getResourceAsStream("config.xml");

        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //3.根据sqlSessionFactory创建sqlSession(每次业务创建一个，用完就释放)
        SqlSession sqlSession =sqlSessionFactory.openSession();

        /*//4.获取接口的代理对象(代理技术)调用代理对象的方法，就会查找mapper接口的方法
        EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
        //调用方法来进行数据库操作！
        Employee employee=mapper.queryByPrice(315);
        System.out.println("employee is "+employee);*/


        //4.1(和Mybatis不同的地方：)
        //直接使用sqlSession提供的方法进行数据库查询即可。
        //用sqlSession的函数：sqlqctOne、selectList   /insert /delete /update没什么特殊含义，是去xml找sql语句！！
        //参数1：字符串（xml里sql标签对应的标识即id|namespace.id）  参数2：Object  执行sql语句要传入的参数！！
        ikun black= sqlSession.selectOne("man",22);
        //缺点：1.以字符串做参数，容易出错；2.一次只能传一个参数；3.返回值问题。
        System.out.println("ikun is:"+black);

        //5.提交事务(非DQL)和释放资源
        sqlSession.commit();//在修改数据的情况下要进行数据提交!像insert、update……这些！或者再前面第三步那里openSession（true）来开启自动提交！
        sqlSession.close();//释放资源。

    }
}
