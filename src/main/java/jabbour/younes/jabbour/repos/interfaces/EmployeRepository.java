package jabbour.younes.jabbour.repos.interfaces;

import jabbour.younes.jabbour.entity.Employee;
import jabbour.younes.jabbour.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employee,Long> {

    public Employee findByEmail(String email);
}
