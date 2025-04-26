package ar.utn.ba.ddsi.series.services;

import ar.utn.ba.ddsi.series.models.dtos.input.SerieInputDTO;
import ar.utn.ba.ddsi.series.models.dtos.output.SerieOutputDTO;

import java.util.List;

public interface ISeriesService {
    List<SerieOutputDTO> buscarTodas();
    SerieOutputDTO buscarPorId(Long id);
    SerieOutputDTO crear(SerieInputDTO serieInputDTO);
    void eliminar(Long id);
}
