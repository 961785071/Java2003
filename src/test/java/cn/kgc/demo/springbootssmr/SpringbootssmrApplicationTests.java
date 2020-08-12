package cn.kgc.demo.springbootssmr;

import cn.kgc.demo.springboot.mybatis.entity.User;
import cn.kgc.demo.springboot.mybatis.mapper.UserMapper;
import cn.kgc.demo.springboot.userservice.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootssmrApplication.class)
class SpringbootssmrApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        User user = userMapper.selectByPrimaryKey(3);
        Assert.assertTrue(user!=null);


        int i = 1;
        User user1 =new User();
        user1.setId(1);
        user1.setPassword("123456");
        user1.setType("admin");
        user1.setUsername("wangtao");
        int i1 = userMapper.insert(user1);
        Assert.assertTrue(i==i1);
    }

    @Test
    void UserLogintest(){
        User user1 =new User();
        user1.setId(1);
        user1.setPassword("123456");
        user1.setType("admin");
        user1.setUsername("wangtao");
        User user = null;
        try {
            user = userService.login(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(user!=null);
    }
    @Test
    void UserRegistrationTest(){
        User user1 =new User();
        user1.setPassword("123456");
        user1.setType("admin");
        user1.setUsername("wangtao1");
        boolean bool = userService.Registration(user1);
        Assert.assertTrue(bool);
    }

    @Test
    void UserFindAll(){
        List<User> list = userService.fandall();
        int i = 5;
        Assert.assertTrue(i==list.size());
    }

}
