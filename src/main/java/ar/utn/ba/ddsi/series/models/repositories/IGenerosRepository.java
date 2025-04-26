package ar.utn.ba.ddsi.series.models.repositories;

import ar.utn.ba.ddsi.series.models.entities.Genero;

import java.util.List;

public interface IGenerosRepository {
    public List<Genero> findAll();
    public Genero findById(long id);
    public void save(Genero genero);
    public void delete(Genero genero);
}
