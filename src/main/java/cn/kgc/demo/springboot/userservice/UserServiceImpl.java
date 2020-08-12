package cn.kgc.demo.springboot.userservice;

import cn.kgc.demo.springboot.mybatis.entity.User;
import cn.kgc.demo.springboot.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) throws Exception {
        User user1= null;
        user1 = userMapper.userLogin(user);
        if(user1 == null){
            throw new Exception("用户未找到！");
        }
        return user1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean Registration(User user) {
        return userMapper.userRegistration(user)>0;
    }

    @Override
    public List<User> fandall() {
        return userMapper.fandAll();
    }
}
