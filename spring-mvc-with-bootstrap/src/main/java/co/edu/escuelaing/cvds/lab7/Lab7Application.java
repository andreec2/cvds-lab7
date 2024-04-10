package co.edu.escuelaing.cvds.lab7;

import co.edu.escuelaing.cvds.lab7.model.*;
import co.edu.escuelaing.cvds.lab7.repository.*;
import co.edu.escuelaing.cvds.lab7.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class Lab7Application {
	private final EmployeeService employeeService;

	private final UserRepository userRepository;

	@Autowired
	public Lab7Application(
			EmployeeService employeeService,
			UserRepository userRepository
	) {
		this.employeeService = employeeService;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab7Application.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return (args) -> {
			log.info("Adding employee....");
			employeeService.addEmployee(new Employee("112","mauricio","javier","sm", 0.0));

			log.info("\nGetting all employee....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));

			log.info("\nAdding admin@site.org user with Password: admin");
			userRepository.save(new User("admin@site.org", "admin", Arrays.asList(UserRole.ADMINISTRADOR, UserRole.CLIENTE)));
		};
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
