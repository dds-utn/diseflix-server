package ar.utn.ba.ddsi.series.models.repositories;

import ar.utn.ba.ddsi.series.models.entities.Serie;

import java.util.List;

public interface ISeriesRepository {
    public Serie findById(Long id);
    public void save(Serie serie);
    public void delete(Serie serie);
    public List<Serie> findAll();
}
