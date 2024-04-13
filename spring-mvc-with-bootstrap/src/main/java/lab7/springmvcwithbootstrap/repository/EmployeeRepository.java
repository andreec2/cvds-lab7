package lab7.springmvcwithbootstrap.repository;

import lab7.springmvcwithbootstrap.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

