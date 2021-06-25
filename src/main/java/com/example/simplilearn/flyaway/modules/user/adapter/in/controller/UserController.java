package com.example.simplilearn.flyaway.modules.user.adapter.in.controller;

import com.example.simplilearn.flyaway.modules.user.adapter.in.command.ChangePasswordCommand;
import com.example.simplilearn.flyaway.modules.user.adapter.in.command.UserCommand;
import com.example.simplilearn.flyaway.util.MessageStatus;
import com.example.simplilearn.flyaway.modules.user.dto.UserDto;
import com.example.simplilearn.flyaway.modules.user.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    CreateUserService createUserService;
    ReadAllUsersService readAllUsersService;
    DeleteUserService deleteUserService;
    ReadUserService readUserService;
    UpdateUserService updateUserService;
    ValidateUserService validateUserService;
    FindUserByEmailService findUserByEmailService;
    ChangePasswordService changePasswordService;

    public UserController(CreateUserService createUserService,
                          ReadAllUsersService readAllUsersService,
                          DeleteUserService deleteUserService,
                          ReadUserService readUserService,
                          UpdateUserService updateUserService,
                          ValidateUserService validateUserService,
                          FindUserByEmailService findUserByEmailService,
                          ChangePasswordService changePasswordService) {
        this.createUserService = createUserService;
        this.readAllUsersService = readAllUsersService;
        this.deleteUserService = deleteUserService;
        this.readUserService = readUserService;
        this.updateUserService = updateUserService;
        this.validateUserService = validateUserService;
        this.findUserByEmailService = findUserByEmailService;
        this.changePasswordService = changePasswordService;
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

    @RequestMapping("login")
    public String showLogin(@ModelAttribute("userCommand") UserCommand userCommand, HttpServletRequest request) {
        System.out.println("Show Login requested");

        return "login";
    }


    @RequestMapping("validate-login")
    public String validateLogin(@ModelAttribute("userCommand") UserCommand userCommand, Model map, HttpServletRequest request) {
        System.out.println("Show validateLogin");

        userCommand = validateUserService.execute(userCommand);
        if(userCommand != null) {

            HttpSession session = request.getSession();
            userCommand.setPassword("");
            session.setAttribute("user", userCommand);

            return "redirect:/home";
        }

        map.addAttribute("login_error",  "Login Failed.. Try Again..!!");
        return "login";

    }

    @RequestMapping("create-user")
    public String createUser(@ModelAttribute("userCommand") UserCommand userCommand, Model map) {
        System.out.println("Show Login requested");
        UserDto userDto = createUserService.execute(userCommand);

        if(userDto == null) {
            map.addAttribute("login_error",  "Email already used.. Try Again..!!");
            return "login";
        }

        return "redirect:/login";
    }


    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if(session != null) {
            session.removeAttribute("user");
            session.invalidate();
         }

        return "redirect:/home";
    }


    @RequestMapping("profile")
    public String showProfile(@ModelAttribute("changePasswordCommand") ChangePasswordCommand changePasswordCommand, HttpServletRequest request, Model map) {

        HttpSession session = request.getSession(false);
        UserCommand user= (UserCommand) session.getAttribute("user");

        map.addAttribute("user", user);

        System.out.println("showProfile");
        return "profile";
    }



    @RequestMapping("change-password")
    public String changePassword(@ModelAttribute("changePasswordCommand") ChangePasswordCommand changePasswordCommand, HttpServletRequest request, Model map) {

        HttpSession session = request.getSession(false);
        UserCommand user= (UserCommand) session.getAttribute("user");
        changePasswordCommand.setUserId(user.getUserId());

        MessageStatus message = changePasswordService.execute(changePasswordCommand);

        if(message.series().equals( MessageStatus.Series.CLIENT_ERROR) ) {
            map.addAttribute("login_error",  message.getReasonPhrase());
            return "profile";
        }

        user = readUserService.execute(user.getUserId());
        session.setAttribute("user", user);

        return "redirect:/home";
    }


}
