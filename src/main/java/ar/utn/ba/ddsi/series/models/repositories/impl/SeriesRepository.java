package ar.utn.ba.ddsi.series.models.repositories.impl;

import ar.utn.ba.ddsi.series.models.entities.Serie;
import ar.utn.ba.ddsi.series.models.repositories.ISeriesRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeriesRepository implements ISeriesRepository {
    private List<Serie> series;

    public SeriesRepository() {
        this.series = new ArrayList<>();
    }

    @Override
    public Serie findById(Long id) {
        return this.series.stream().filter(serie -> serie.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(Serie serie) {
        serie.setId((long) this.series.size());
        this.series.add(serie);
    }

    @Override
    public void delete(Serie serie) {
        this.series.remove(serie);
    }

    @Override
    public List<Serie> findAll() {
        return this.series;
    }
}
