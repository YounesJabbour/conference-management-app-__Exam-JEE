package jabbour.younes.jabbour.entity;

import jabbour.younes.jabbour.enums.ReservationStatus;
import jabbour.younes.jabbour.enums.SalleType;
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
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String name;
    private int capacity;
    private SalleType type;

    @OneToMany(mappedBy = "salle", fetch = FetchType.LAZY)
    private List<Reservation> reservations;
}
