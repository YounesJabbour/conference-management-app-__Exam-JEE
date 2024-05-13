package jabbour.younes.jabbour.DTOs.Reservation;

import jabbour.younes.jabbour.enums.ReservationStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreatedReservation {
    private Date date;
    private int duration;
    private String description;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
}
