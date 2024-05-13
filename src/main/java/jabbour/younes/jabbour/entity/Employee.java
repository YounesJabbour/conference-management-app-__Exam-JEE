package jabbour.younes.jabbour.entity;

import jabbour.younes.jabbour.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String photo;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Reservation> reservationList;
}
