package lab7.springmvcwithbootstrap.service;


import lab7.springmvcwithbootstrap.dto.EmployeeDto;

import java.util.List;

public interface EmployeeServiceInterface {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);

    void deleteEmployee(Long employeeId);
}
