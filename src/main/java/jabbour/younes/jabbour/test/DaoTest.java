package jabbour.younes.jabbour.test;

import jabbour.younes.jabbour.DTOs.Employe.CreatedEmployeDTO;
import jabbour.younes.jabbour.DTOs.Employe.EmployeDTO;
import jabbour.younes.jabbour.YounesJabbourApplication;
import jabbour.younes.jabbour.entity.Employee;
import jabbour.younes.jabbour.entity.Reservation;
import jabbour.younes.jabbour.entity.Salle;
import jabbour.younes.jabbour.enums.SalleType;
import jabbour.younes.jabbour.repos.interfaces.EmployeRepository;
import jabbour.younes.jabbour.repos.interfaces.ReservationRepository;
import jabbour.younes.jabbour.repos.interfaces.SalleRepository;
import jabbour.younes.jabbour.service.interfaces.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;


@SpringBootApplication
public class DaoTest {
    public static void main(String[] args) {
        SpringApplication.run(YounesJabbourApplication.class, args);
    }

    @Bean
    CommandLineRunner start(EmployeRepository employeRepository, ReservationRepository reservationRepository,
                            EmployeeService employeeService, SalleRepository salleRepository) {
        return args -> {
            /**
             * create employees
             */
//            Stream.of("Hassan", "Mohamed", "Ali", "Omar", "abdlillah").forEach(name -> {
//                Employee employee = Employee.builder().email(name + "@gmail.com").name(name).build();
//                employeRepository.save(employee);
//            });

            Stream.of("salle1", "salle2", "salle3", "salle4", "salle5").forEach(name -> {
                Salle salle = Salle.builder()
                        .number("number_" + name)
                        .name(name)
                        .capacity(100)
                        .type(SalleType.COURS)
                        .build();
                salleRepository.save(salle);
            });

            employeRepository.findAll().forEach(c -> {
                System.out.println(c.getName());
            });

            /**
             * create a reservation
             */
            Employee employee = employeRepository.findById(1L).get();

            /**
             * create a reservation
             */
            Reservation reservation = Reservation.builder().description("description").employee(employee).build();

            reservationRepository.save(reservation);

//            CreatedEmployeDTO employeDTO = CreatedEmployeDTO.builder().email("test").name("Younes").build();
//            EmployeDTO employeDTO1 =  employeeService.create(employeDTO);
//            System.out.println(employeDTO1.toString());
        };
    }
}