package jabbour.younes.jabbour.repos.interfaces;

import jabbour.younes.jabbour.entity.Equipement;
import jabbour.younes.jabbour.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipementRepository extends JpaRepository<Equipement,Long> {
}
