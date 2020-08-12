package cn.kgc.demo.springboot.userservice;

import cn.kgc.demo.springboot.mybatis.entity.User;

import java.util.List;

public interface UserService {
    /*登录*/
    User login(User user) throws Exception;

    /*注册*/
    boolean Registration(User user);

    /*查询*/
    List<User> fandall();
}
