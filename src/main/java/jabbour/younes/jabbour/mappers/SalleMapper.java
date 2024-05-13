package jabbour.younes.jabbour.mappers;


import jabbour.younes.jabbour.DTOs.CreatedSalle.CreatedSalle;
import jabbour.younes.jabbour.entity.Salle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalleMapper {

    public Salle toEntity(CreatedSalle salle);
}
