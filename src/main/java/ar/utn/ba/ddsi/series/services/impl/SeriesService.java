package ar.utn.ba.ddsi.series.services.impl;

import ar.utn.ba.ddsi.series.models.dtos.input.SerieInputDTO;
import ar.utn.ba.ddsi.series.models.dtos.output.SerieOutputDTO;
import ar.utn.ba.ddsi.series.models.entities.Serie;
import ar.utn.ba.ddsi.series.models.repositories.IGenerosRepository;
import ar.utn.ba.ddsi.series.models.repositories.ISeriesRepository;
import ar.utn.ba.ddsi.series.services.ISeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService implements ISeriesService {
    @Autowired
    private ISeriesRepository seriesRepository;

    @Autowired
    private IGenerosRepository generosRepository;

    @Override
    public List<SerieOutputDTO> buscarTodas() {
        return this.seriesRepository
                .findAll()
                .stream()
                .map(this::serieOutputDTO)
                .toList();
    }

    @Override
    public SerieOutputDTO buscarPorId(Long id) {
        var serie = this.seriesRepository.findById(id);
        if (serie == null) {
            return null;
        }
        return this.serieOutputDTO(serie);
    }

    @Override
    public SerieOutputDTO crear(SerieInputDTO serieInputDTO) {
        var serie = new Serie();
        serie.setNombre(serieInputDTO.getNombre());
        serie.setResenia(serieInputDTO.getResenia());

        var genero = this.generosRepository.findById(serieInputDTO.getIdGenero());
        serie.setGenero(genero);
        this.seriesRepository.save(serie);

        return this.serieOutputDTO(serie);
    }

    @Override
    public void eliminar(Long id) {
        var serie = this.seriesRepository.findById(id);
        if (serie != null) {
            this.seriesRepository.delete(serie);
        }
    }

    private SerieOutputDTO serieOutputDTO(Serie serie) {
        SerieOutputDTO serieOutputDTO = new SerieOutputDTO();
        serieOutputDTO.setId(serie.getId());
        serieOutputDTO.setNombre(serie.getNombre());
        serieOutputDTO.setIdGenero(serie.getGenero().getId());
        serieOutputDTO.setResenia(serie.getResenia());
        serieOutputDTO.setHorasVisualizacion(serie.horasVisualizaciones());
        serieOutputDTO.setCartelera(serie.getCartelera());
        return serieOutputDTO;
    }
}
