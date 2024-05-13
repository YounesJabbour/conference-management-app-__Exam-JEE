package jabbour.younes.jabbour.service.impl;

import jabbour.younes.jabbour.DTOs.CreatedSalle.CreatedSalle;
import jabbour.younes.jabbour.entity.Salle;
import jabbour.younes.jabbour.exception.NotFoundException;
import jabbour.younes.jabbour.mappers.SalleMapper;
import jabbour.younes.jabbour.repos.interfaces.SalleRepository;
import jabbour.younes.jabbour.service.interfaces.SalleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class SalleImpl implements SalleService {
    private SalleRepository salleRepository;
    private SalleMapper salleMapper;

    @Override
    public Salle createSalle(CreatedSalle salle) {
        return salleRepository.save(salleMapper.toEntity(salle) );
    }

    @Override
    public Salle updateSalle(Salle salle) {
    return salleRepository.save(salle);
    }

    @Override
    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }

    @Override
    public Salle findSalleById(Long id) {
        return salleRepository.findById(id).orElseThrow(() -> new NotFoundException("Salle not found"));
    }


    @Override
    public Page<Salle> getAllSalles(int page, int size) {
        return salleRepository.findAll(PageRequest.of(page, size));
    }
}
