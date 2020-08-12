package cn.kgc.demo.springboot.usercontroller;

import cn.kgc.demo.springboot.mybatis.entity.User;
import cn.kgc.demo.springboot.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/tologin")
    public String toLogin(){
        return "login";
    }
    @PostMapping("/login")
    public String login(User user, Model model) {
        String ret = "userlist";
        String msg= null;
        User user1  = null;
        try {
              user1 =  userService.login(user);
              model.addAttribute("user",user1);
        }catch(Exception e){
            msg = e.getMessage();
            ret = "login";
        }
        return ret;
    }



}
