package kz.iitu.lab5.event;

import kz.iitu.lab5.model.Employee;
import org.springframework.context.ApplicationEvent;

public class UserCreateEvent extends ApplicationEvent {

    private Employee employee;

    public UserCreateEvent(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

    public Employee getEmployee(){
        return employee;
    }
}
