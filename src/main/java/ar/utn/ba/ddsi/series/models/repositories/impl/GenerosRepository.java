package ar.utn.ba.ddsi.series.models.repositories.impl;

import ar.utn.ba.ddsi.series.models.entities.Genero;
import ar.utn.ba.ddsi.series.models.repositories.IGenerosRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GenerosRepository implements IGenerosRepository {
    private List<Genero> generos;

    public GenerosRepository() {
        this.generos = new ArrayList<>();
    }

    @Override
    public List<Genero> findAll() {
        return this.generos;
    }

    @Override
    public Genero findById(long id) {
        return this.generos.stream().filter(genero -> genero.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Genero genero) {
        genero.setId((long) this.generos.size());
        this.generos.add(genero);
    }

    @Override
    public void delete(Genero genero) {
        this.generos.remove(genero);
    }
}
