package jabbour.younes.jabbour.repos.interfaces;

import jabbour.younes.jabbour.entity.Reservation;
import jabbour.younes.jabbour.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
