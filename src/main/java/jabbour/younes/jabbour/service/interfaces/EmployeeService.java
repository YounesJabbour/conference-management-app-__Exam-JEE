package jabbour.younes.jabbour.service.interfaces;

import jabbour.younes.jabbour.DTOs.Employe.CreatedEmployeDTO;
import jabbour.younes.jabbour.DTOs.Employe.EmployeDTO;
import jabbour.younes.jabbour.DTOs.Employe.UpdatedEmployeDTO;
import jabbour.younes.jabbour.entity.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    EmployeDTO create(CreatedEmployeDTO employeDTO);

    EmployeDTO update(UpdatedEmployeDTO employe);

    void delete(Long id);

    EmployeDTO findById(Long id);

    EmployeDTO findByEmail(String email);

    Page<EmployeDTO> getAll(int page, int size);


}
