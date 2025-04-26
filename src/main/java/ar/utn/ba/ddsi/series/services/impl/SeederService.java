package ar.utn.ba.ddsi.series.services.impl;

import ar.utn.ba.ddsi.series.models.entities.Genero;
import ar.utn.ba.ddsi.series.models.entities.Serie;
import ar.utn.ba.ddsi.series.models.repositories.IGenerosRepository;
import ar.utn.ba.ddsi.series.models.repositories.ISeriesRepository;
import ar.utn.ba.ddsi.series.services.ISeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeederService implements ISeederService {
    @Autowired
    private IGenerosRepository generosRepository;

    @Autowired
    private ISeriesRepository seriesRepository;

    @Value("${app.base-url}")
    private String baseUrl;


    @Override
    public void init() {
        Genero terror = new Genero("Terror");
        Genero drama = new Genero("Drama");
        Genero cienciaFiccion = new Genero("Ciencia ficción");
        Genero crimen = new Genero("Crimen");
        Genero comedia = new Genero("Comedia");

        var series = List.of(
                Serie.builder()
                        .nombre("Stranger Things")
                        .resenia("Misterio ochentoso y monstruos")
                        .genero(terror)
                        .duracionTotalEnMins(2028)
                        .cantReproducciones(5000000)
                        .cartelera(baseUrl + "/images/series/stranger-things.jpg")
                        .build(),
                Serie.builder()
                        .nombre("The Crown")
                        .resenia("Drama real británico impecable")
                        .genero(drama)
                        .duracionTotalEnMins(3180)
                        .cantReproducciones(3000000)
                        .cartelera(baseUrl + "/images/series/the-crown.jpg")
                        .build(),
                Serie.builder()
                        .nombre("Black Mirror")
                        .resenia("Tecnología y distopía en cada capítulo")
                        .genero(cienciaFiccion)
                        .duracionTotalEnMins(1901)
                        .cantReproducciones(4000000)
                        .cartelera(baseUrl + "/images/series/black-mirror.jpg")
                        .build(),
                Serie.builder()
                        .nombre("Narcos")
                        .resenia("La historia de Pablo Escobar")
                        .genero(crimen)
                        .duracionTotalEnMins(1888)
                        .cantReproducciones(8000000)
                        .cartelera(baseUrl + "/images/series/narcos.jpg")
                        .build(),
                Serie.builder()
                        .nombre("Sex Education")
                        .resenia("Adolescentes, humor y autodescubrimiento")
                        .genero(comedia)
                        .duracionTotalEnMins(1860)
                        .cantReproducciones(3500000)
                        .cartelera(baseUrl + "/images/series/sex-education.jpg")
                        .build()
        );

        this.generosRepository.save(terror);
        this.generosRepository.save(drama);
        this.generosRepository.save(cienciaFiccion);
        this.generosRepository.save(crimen);
        this.generosRepository.save(comedia);

        series.forEach(serie -> {
            this.seriesRepository.save(serie);
        });
    }
}
