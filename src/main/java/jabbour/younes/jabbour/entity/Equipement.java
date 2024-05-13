package jabbour.younes.jabbour.entity;

import jabbour.younes.jabbour.enums.EquipementType;
import jabbour.younes.jabbour.enums.SalleType;
import jabbour.younes.jabbour.repos.interfaces.ReservationRepository;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double weight;
    @Enumerated(EnumType.STRING)
    private EquipementType type;
    private String catalog;

    @ManyToMany()
    private List<Reservation> reservations;
}
