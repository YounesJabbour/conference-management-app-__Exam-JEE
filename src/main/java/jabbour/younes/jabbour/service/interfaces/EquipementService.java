package jabbour.younes.jabbour.service.interfaces;

import jabbour.younes.jabbour.DTOs.Equipement.CreatedEquipementDTO;
import jabbour.younes.jabbour.entity.Equipement;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface EquipementService {

        Equipement createEquipement(CreatedEquipementDTO equipementDTO);

        Equipement getEquipementById(Long id);

        void deleteEquipement(Long id);

        Equipement updateEquipement(Long id, CreatedEquipementDTO equipementDTO);

        Page<Equipement> getEquipements(int page, int size);
}
