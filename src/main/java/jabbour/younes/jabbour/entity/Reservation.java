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
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private int duration;
    private String description;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Salle salle;
    @ManyToMany(mappedBy = "reservations", fetch = FetchType.LAZY)
    private List<Equipement> equipements;
}
