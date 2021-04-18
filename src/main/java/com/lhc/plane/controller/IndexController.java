package com.lhc.plane.controller;

import com.lhc.plane.dao.UsersRepository;
import com.lhc.plane.dto.BuyTicketDto;
import com.lhc.plane.entity.Users;
import com.lhc.plane.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private IUsersService iUsersService;
    @GetMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("userList", usersRepository.findAll());
        return modelAndView;
    }

    @PostMapping("addUser")
    public String addUser(Users users){
        usersRepository.save(users);
        return "success";
    }
    @PostMapping("updateUser")
    public String updateUser(Users users){
        Users usersUpdate = usersRepository.findById(users.getId()).get();
        usersUpdate.setUserName(users.getUserName());

        usersRepository.save(usersUpdate);
        return "success";
    }

    @GetMapping("addUser")
    public String addUser(){
        return "addUser";
    }
    @PostMapping("buy")
    public String buy(BuyTicketDto dto){

        iUsersService.buyTicket(dto);
        return null;
    }
    @PostMapping("login")
    public String login(@RequestParam String userName, @RequestParam String password, HttpServletRequest request){
        Users users = usersRepository.findByUserNameAndPassword(userName,password);
        if(users != null){
            request.getSession().setAttribute("users",users);
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("login")
    public String login(){
        return "login";
    }
}
