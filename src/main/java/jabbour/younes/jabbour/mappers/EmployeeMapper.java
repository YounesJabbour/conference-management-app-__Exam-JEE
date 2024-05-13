package jabbour.younes.jabbour.mappers;

import jabbour.younes.jabbour.DTOs.Employe.CreatedEmployeDTO;
import jabbour.younes.jabbour.DTOs.Employe.EmployeDTO;
import jabbour.younes.jabbour.DTOs.Employe.UpdatedEmployeDTO;
import jabbour.younes.jabbour.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeDTO  toDto(Employee employee );

    @Mapping(target = "photo", ignore = true)
    EmployeDTO toDto(CreatedEmployeDTO employeeDTO );

    Employee toEntity(EmployeDTO employeDTO);

    @Mapping(target = "photo", ignore = true)
    Employee toEntity(CreatedEmployeDTO employeDTO);

    @Mapping(target = "photo", ignore = true)
    Employee toEntity(UpdatedEmployeDTO employeDTO);

}
