package lab7.springmvcwithbootstrap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    //You need to modify the column with this SQL line:ALTER TABLE employee MODIFY COLUMN employee_id BIGINT AUTO_INCREMENT;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "SALARY")
    private Double salary;
}