package lab7.springmvcwithbootstrap.service.impl;


import lab7.springmvcwithbootstrap.Exception.ResourceNotFoundException;
import lab7.springmvcwithbootstrap.dto.EmployeeDto;
import lab7.springmvcwithbootstrap.mapper.EmployeeMapper;
import lab7.springmvcwithbootstrap.model.Employee;
import lab7.springmvcwithbootstrap.repository.EmployeeRepository;
import lab7.springmvcwithbootstrap.service.EmployeeServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService implements EmployeeServiceInterface {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));

        employee.setfirst_name(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setrole(updateEmployee.getRole());
        employee.setSalary(updateEmployee.getSalary());

        Employee updateEmployeeOBJ = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updateEmployeeOBJ);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));
            employeeRepository.deleteById(employeeId);
    }
    /*
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
    }*/
}