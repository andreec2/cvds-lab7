package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    private EmployeeRepository mockEmployeeRepository;

    @Mock
    private Model model;

    @InjectMocks
    private EmployeeService employeeService;

    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        // To be implemented, remove if not needed
        System.setOut(new PrintStream(outputStreamCaptor));
        employeeController = new EmployeeController(employeeService);
    }

    @AfterEach
    void tearDown() {
        // To be implemented, remove if not needed
        System.setOut(standardOut);
    }

}
