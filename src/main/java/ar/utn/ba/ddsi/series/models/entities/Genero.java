package ar.utn.ba.ddsi.series.models.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Genero {
    private Long id;
    private String nombre;

    public Genero(String nombre) {
        this.nombre = nombre;
    }
}
