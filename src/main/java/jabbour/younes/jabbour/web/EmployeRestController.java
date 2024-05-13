package jabbour.younes.jabbour.web;


import jabbour.younes.jabbour.DTOs.Employe.CreatedEmployeDTO;
import jabbour.younes.jabbour.DTOs.Employe.EmployeDTO;
import jabbour.younes.jabbour.DTOs.Employe.UpdatedEmployeDTO;
import jabbour.younes.jabbour.mappers.EmployeeMapper;
import jabbour.younes.jabbour.service.interfaces.EmployeeService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
//@PreAuthorize("permitAll()")
public class EmployeRestController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping("")
    public ResponseEntity<List<EmployeDTO>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(employeeService.getAll(page, size).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeDTO> getOne(@RequestParam Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path="", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<EmployeDTO> create(@ModelAttribute CreatedEmployeDTO employeDTO) {
        return ResponseEntity.ok(employeeService.create(employeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeDTO> update(@PathVariable Long id, @ModelAttribute UpdatedEmployeDTO employeDTO) {
        employeDTO.setId(id);
        return ResponseEntity.ok(employeeService.update(employeDTO));
    }
}
