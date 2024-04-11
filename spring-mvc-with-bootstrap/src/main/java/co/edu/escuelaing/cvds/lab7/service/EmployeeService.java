package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(String employeeId) {
        return employeeRepository.findByEmployeeId(employeeId).get(1);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        if (employeeRepository.findByEmployeeId(employee.getemployee_id()).size() == 0) {
            return employeeRepository.save(employee);
        }

        return null;
    }

    public void deleteEmployee(String employee_id) {
        employeeRepository.deleteById(employee_id);
    }

    public String getEmployeeId() {
        return employeeRepository.findByEmployeeId("112").get(0).getfirst_name();
    }
}