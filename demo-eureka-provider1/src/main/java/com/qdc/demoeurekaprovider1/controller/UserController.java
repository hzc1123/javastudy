package com.qdc.demoeurekaprovider1.controller;

import com.qdc.demoeurekaprovider1.pojo.User;
import com.qdc.demoeurekaprovider1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.StyledEditorKit;
import java.util.List;

@RequestMapping(value = "/user") //第一层请求路径
@RestController //控制层+返回数据都是 返回json格式
//@Controller     //自己用的时候用，返回到具体的页面
public class UserController {
    @Autowired
    UserService userService;
    @Value("${spring.cloud.client.ip-address}")
    String ipaddr;
    @Value("${server.port}")
    int port;
    //调用Userservice中的service
    //接受前端传过来的数据也是json格式，需要把json格式转换成user对象，使用@RequestBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public boolean delUser(@RequestParam(value = "username", required = true) String name) {
        return userService.deleteUser(name);
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public User selectUserById(@RequestParam(value = "userid", required = true) String id) {
        return userService.selectUserById(id);
    }

    @RequestMapping(value = "/userall", method = RequestMethod.GET)
    public List<User> selectUserById() {
        return userService.selectAllUsers();
    }
    @RequestMapping(value = "/sayHi",method = RequestMethod.GET)
    public String hello(@RequestParam(value = "sleep_seconds",required = true)int sleep_seconds)
        throws InterruptedException{
        System.out.println("休眠时间"+sleep_seconds);
        Thread.sleep(sleep_seconds*1000);
        return "Hello,我在"+ipaddr+":"+port;
    }
}
