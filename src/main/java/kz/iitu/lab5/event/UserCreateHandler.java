package kz.iitu.lab5.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreateHandler implements ApplicationListener<UserCreateEvent> {
    @Override
    public void onApplicationEvent(UserCreateEvent userCreateEvent) {
        System.out.println("User INFO: " + userCreateEvent.getUser());
    }
}
