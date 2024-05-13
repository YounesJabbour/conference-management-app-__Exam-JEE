package jabbour.younes.jabbour.DTOs.Reservation;

import jabbour.younes.jabbour.enums.ReservationStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

public class ReservationDTO {

    private Long id;
    private Date date;
    private int duration;
    private String description;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
}
