package jabbour.younes.jabbour.service.interfaces;

import jabbour.younes.jabbour.DTOs.CreatedSalle.CreatedSalle;
import jabbour.younes.jabbour.entity.Salle;
import org.springframework.data.domain.Page;

public interface SalleService {


    Salle createSalle(CreatedSalle salle);

    Salle updateSalle(Salle salle);

    void deleteSalle(Long id);

    public Salle findSalleById(Long id);

    Page<Salle> getAllSalles(int page, int size);
}
