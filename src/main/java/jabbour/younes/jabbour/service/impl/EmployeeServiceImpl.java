package jabbour.younes.jabbour.service.impl;


import jabbour.younes.jabbour.DTOs.Employe.CreatedEmployeDTO;
import jabbour.younes.jabbour.DTOs.Employe.EmployeDTO;
import jabbour.younes.jabbour.DTOs.Employe.UpdatedEmployeDTO;
import jabbour.younes.jabbour.entity.Employee;
import jabbour.younes.jabbour.exception.EmployeeNotFoundException;
import jabbour.younes.jabbour.mappers.EmployeeMapper;
import jabbour.younes.jabbour.repos.interfaces.EmployeRepository;
import jabbour.younes.jabbour.service.interfaces.EmployeeService;
import jabbour.younes.jabbour.service.interfaces.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeRepository employeeRepository;
    private EmployeeMapper employeeMapper;
    private FileService fileService;

    @Override
    public EmployeDTO create(CreatedEmployeDTO employeDTO) {
        String path =fileService .uploadFile(employeDTO.getPhoto());
        Employee employee = employeeMapper.toEntity(employeDTO);
        employee.setPhoto(path);
//        Employee employee1 = employeeRepository.save(employeeMapper.toEntity(employeDTO));

        return employeeMapper.toDto(employeeRepository.save(employee)) ;
    }

    @Override
    public EmployeDTO update(UpdatedEmployeDTO employe) {
        Employee employee = employeeRepository.save(employeeMapper.toEntity(employe));
        return employeeMapper.toDto(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        return employeeMapper.toDto(employee);
    }

    @Override
    public EmployeDTO findByEmail(String email) {
        try {
            Employee employee = employeeRepository.findByEmail(email);
            return employeeMapper.toDto(employee);
        } catch (Exception e) {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Page<EmployeDTO> getAll(int page, int size) {
        return employeeRepository.findAll(PageRequest.of(page, size)).map(employeeMapper::toDto);
    }
}
