package com.oyzy.controller;

import com.oyzy.entity.User;
import com.oyzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "userList";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "addUser";
    }

    @RequestMapping("/add")
    @ResponseBody
    public int add(String name, Integer age){
        User user = new User(name,age);
        return userService.add(user);
    }

    @RequestMapping(value = "/toEdit", method = {RequestMethod.GET, RequestMethod.POST})
    public String toEdit(@RequestParam("id") Long id, Model model){
        User user1 = userService.findById(id);
        model.addAttribute("user",user1);
        return "editUser";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public int edit(String name, Integer age, Long id){
        User user = new User(name, age);
        user.setId(id);
        return userService.edit(user);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delete(Long id){
        return userService.deleteById(id);
    }
}
