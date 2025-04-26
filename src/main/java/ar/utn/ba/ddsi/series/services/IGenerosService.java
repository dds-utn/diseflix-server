package ar.utn.ba.ddsi.series.services;

import ar.utn.ba.ddsi.series.models.dtos.output.GeneroOutputDTO;

import java.util.List;

public interface IGenerosService {
    List<GeneroOutputDTO> buscarTodos();
}
