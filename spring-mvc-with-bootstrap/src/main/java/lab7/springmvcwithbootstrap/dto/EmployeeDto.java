package lab7.springmvcwithbootstrap.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    //@Id
    //@Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
     */

    //@Column(name = "FIRST_NAME")
    private String firstName;
    //@Column(name = "LAST_NAME")
    private String lastName;
    //@Column(name = "ROLE")
    private String role;
    //@Column(name = "SALARY")
    private Double salary;

}