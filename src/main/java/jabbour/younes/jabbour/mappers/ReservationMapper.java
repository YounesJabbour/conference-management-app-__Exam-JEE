package jabbour.younes.jabbour.mappers;

import jabbour.younes.jabbour.DTOs.Reservation.CreatedReservation;
import jabbour.younes.jabbour.DTOs.Reservation.ReservationDTO;
import jabbour.younes.jabbour.entity.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    Reservation toEntity(CreatedReservation reservation);
    Reservation toEntity(ReservationDTO reservation);
}
