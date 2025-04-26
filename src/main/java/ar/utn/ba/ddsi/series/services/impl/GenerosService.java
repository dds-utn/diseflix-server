package ar.utn.ba.ddsi.series.services.impl;

import ar.utn.ba.ddsi.series.models.dtos.output.GeneroOutputDTO;
import ar.utn.ba.ddsi.series.models.entities.Genero;
import ar.utn.ba.ddsi.series.models.repositories.IGenerosRepository;
import ar.utn.ba.ddsi.series.services.IGenerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerosService implements IGenerosService {
    @Autowired
    private IGenerosRepository generosRepository;


    @Override
    public List<GeneroOutputDTO> buscarTodos() {
        var generos = this.generosRepository.findAll();
        return generos.stream().map(this::generoToDTO).toList();
    }

    private GeneroOutputDTO generoToDTO(Genero genero) {
        var generoDTO = new GeneroOutputDTO();
        generoDTO.setId(genero.getId());
        generoDTO.setNombre(genero.getNombre());
        return generoDTO;
    }
}
