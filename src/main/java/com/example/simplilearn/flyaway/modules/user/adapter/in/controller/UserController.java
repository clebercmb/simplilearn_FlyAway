package com.example.simplilearn.flyaway.modules.user.adapter.in.controller;

import com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand;
import com.example.simplilearn.flyaway.modules.user.dto.UserDto;
import com.example.simplilearn.flyaway.modules.user.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    CreateUserService createUserService;
    ReadAllUsersService readAllUsersService;
    DeleteUserService deleteUserService;
    ReadUserService readUserService;
    UpdateUserService updateUserService;

    public UserController(CreateUserService createUserService,
                          ReadAllUsersService readAllUsersService,
                          DeleteUserService deleteUserService,
                          ReadUserService readUserService,
                          UpdateUserService updateUserService) {
        this.createUserService = createUserService;
        this.readAllUsersService = readAllUsersService;
        this.deleteUserService = deleteUserService;
        this.readUserService = readUserService;
        this.updateUserService = updateUserService;
    }

    @RequestMapping("user")
    public String show(@ModelAttribute("userCommand") UserCommand user) {
        return "user";
    }


    @RequestMapping("updateUser")
    public String showUpdateUser(@ModelAttribute("userCommand") UserCommand user, @RequestParam String id, Model map) {
        user = readUserService.execute(Integer.parseInt(id));
        map.addAttribute("user", user);

        return "userUpdate";
    }


    @RequestMapping(value = "createUser", method = RequestMethod.POST)
    public String post(@ModelAttribute("userCommand") UserCommand user, Model map) {
        UserDto userDto = createUserService.execute(user);
        map.addAttribute("user", userDto);

        return "redirect:/user-dashboard";
    }


    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public String put(@ModelAttribute("userCommand") UserCommand user, Model map) {
        UserDto userDto = updateUserService.execute(user);

        map.addAttribute("user", userDto);

        return "redirect:/user-dashboard";
    }


    @RequestMapping("user-dashboard")
    public String showDashBoard(Model model) {
        List<UserCommand> userList = readAllUsersService.execute();
        model.addAttribute("users", userList);

        return "userDashboard";
    }


    @RequestMapping("deleteUser")  // default GET
    public String delete(@RequestParam String id) {

        deleteUserService.execute(Integer.parseInt(id));

        return "redirect:/user-dashboard";
    }


}
