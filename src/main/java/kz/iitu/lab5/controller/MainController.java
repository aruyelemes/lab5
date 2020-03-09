package kz.iitu.lab5.controller;

import kz.iitu.lab5.event.UserCreateEvent;
import kz.iitu.lab5.model.Users;
import kz.iitu.lab5.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@Component
@AllArgsConstructor
public class MainController implements ApplicationEventPublisherAware {

    private UsersService usersService;
    private ApplicationEventPublisher eventPublisher;

    @GetMapping("/")
    public String index(){
        return "home";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping(value = "/listusers")
    public String listUsers(Model model){
        model.addAttribute("users", usersService.findAll());
        return "listuser";
    }



    @PostMapping(value = "/register")
    public String postRegister(
                           @RequestParam(name = "id")Long id,
                           @RequestParam(name = "name") String name,
                           @RequestParam(name = "surname") String surname,
                           @RequestParam(name = "position") String position,
                           @RequestParam(name = "salary") int salary){
        String message = "?error";
        if(usersService.register(new Users(id, name, surname, position, salary))!=null){
            this.eventPublisher.publishEvent(new UserCreateEvent(this, usersService.getById(id)));
            message = "?success";
        }
        return "redirect:/register";

    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
