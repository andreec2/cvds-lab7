package lab7.springmvcwithbootstrap.mapper;

import lab7.springmvcwithbootstrap.dto.EmployeeDto;
import lab7.springmvcwithbootstrap.model.Employee;


public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto (Employee employee) {
        return new EmployeeDto(
                employee.getemployee_id(),
                employee.getfirst_name(),
                employee.getLastName(),
                employee.getrole(),
                employee.getSalary()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getEmployeeId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getRole(),
                employeeDto.getSalary()
        );
    }
}
