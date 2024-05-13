package jabbour.younes.jabbour.DTOs.Equipement;

import jabbour.younes.jabbour.enums.EquipementType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatedEquipementDTO {
    private String name;
    private double weight;
    @Enumerated(EnumType.STRING)
    private EquipementType type;
    private MultipartFile catalog;
}
