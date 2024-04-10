package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.ConfigurationRepository;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private EmployeeRepository mockEmployeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @DisplayName("Given I have a configuration property called 'premio' in the database"+
            "When I search for all configuration properties at service level"+
            "Then the result is a configuration array of size 1 and a property called 'premio' with value 800000")
    @Test
    void getAllEmployees() {
        // Arrange / Given - precondition or setup
        Employee employee = new Employee("112","mauricio","javier","sm", 0.0);
        when(mockEmployeeRepository.findAll()).thenReturn(Arrays.asList(employee));
        // Act / When - action or the behaviour that we are going test
        List<Employee> allEmployees = employeeService.getAllEmployees();
        // Assert / Then - verify the output
        assertEquals(1, allEmployees.size());
        assertEquals("112", allEmployees.get(0).getemployee_id());
    }

    @DisplayName("""
    Given I have a configuration property called 'premio' with value '1000' in the database
    When I search for the 'premio' value at service level
    Then the result is the value '1000'
    """)
    @Test
    void getPremio() {
        // Arrange / Given - precondition or setup
        String property = "112";
        String expectedValue = "mauricio";
        Employee employee = new Employee("112","mauricio","javier","sm", 0.0);
        when(mockEmployeeRepository.findByEmployeeId("112")).thenReturn(Arrays.asList(employee));
        // Act / When - action or the behaviour that we are going test
        String value = employeeService.getEmployeeId();
        // Assert / Then - verify the output
        assertEquals(expectedValue, value);
    }
}