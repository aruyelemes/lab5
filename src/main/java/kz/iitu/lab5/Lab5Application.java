package kz.iitu.lab5;

import kz.iitu.lab5.event.UserCreateEvent;
import kz.iitu.lab5.model.Employee;
import kz.iitu.lab5.model.EmployeeType;
import kz.iitu.lab5.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab5Application  implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher eventPublisher;

	private static final Logger log = LoggerFactory.getLogger(Lab5Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Lab5Application.class, args);
	}

	@Bean
	public CommandLineRunner bootstrap(EmployeeRepository employeeRepository){
		return (args) -> {

			Employee employee = new Employee(1L, "Mark", 120000, 120000, 8, EmployeeType.SALARIED);
			employeeRepository.save(employee);

			Employee employee2 = new Employee(2L, "Noa", 200000, 45.6, EmployeeType.HOURLY);
			if(employee2.getHourRate()>40){
				employee2.setSalary(employee2.getSalary() + employee2.getSalary() * 1.5);
			}
			employeeRepository.save(employee2);

			Employee employee3 = new Employee(3L, "Sam", 230000, 13F, EmployeeType.COMMISION);
			employeeRepository.save(employee3);

			Employee employee4 = new Employee(4L, "Bob", 270000, 200000, 13F, EmployeeType.SALARIED_COMMISION);
			employeeRepository.save(employee4);


			log.info("Employees found with findAll():");
			log.info("-------------------------------");
			for (Employee e : employeeRepository.findAll()) {

				log.info(e.toString());
			}
			log.info("");



			log.info("Persentage to salaries");
			log.info("-------------------------------");
			for (Employee em : employeeRepository.findAll()) {
				if(em.getEmplType().equals(EmployeeType.SALARIED_COMMISION)){
					this.eventPublisher.publishEvent(new UserCreateEvent(this, em));
					em.setSalary(em.getSalary() + em.getSalary() * 0.1);
					employeeRepository.save(em);
					log.info(em.toString());

				}
			}
			log.info("");
		};
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
	}
}


