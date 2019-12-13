package org.apache.ibatis.autoconstructor.main;

import org.apache.ibatis.autoconstructor.entity.User;
import org.apache.ibatis.autoconstructor.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;

class Main {
    private static SqlSessionFactory sqlSessionFactory;

    static  {
        // create a SqlSessionFactory
        try {
            Resources.setCharset(Charset.forName("UTF-8"));
            try (Reader reader = Resources.getResourceAsReader("org/apache/ibatis/autoconstructor/mybatis-config.xml")) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws SQLException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        Connection connection = sqlSession.getConnection();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u1 = userMapper.getUser(1);
        System.out.println(u1);
        User u2 = userMapper.getUser(1);
        System.out.println(u2);

//        User user = new User();
//        user.setAge(12);
//        user.setCreatTime(new Timestamp(System.currentTimeMillis()));
//        user.setName("码农");
//        userMapper.saveUser(user);
//        sqlSession.commit();
//        sqlSession.close();

    }



    void fullyPopulatedSubject() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final Object subject = mapper.getUser(1);
        }
    }

    void primitiveSubjects() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        }
    }

    void annotatedSubject() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        }
    }

    void badSubject() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        }
    }
}
