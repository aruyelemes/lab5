package kz.iitu.lab5.event;

import kz.iitu.lab5.model.Users;
import org.springframework.context.ApplicationEvent;

public class UserCreateEvent extends ApplicationEvent {

    private Users user;

    public UserCreateEvent(Object source, Users user) {
        super(source);
        this.user = user;
    }

    public Users getUser(){
        return user;
    }
}
