package ar.utn.ba.ddsi.series.models.entities;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Serie {
    private Long id;
    private String nombre;
    private Genero genero;
    private String resenia;
    private Integer duracionTotalEnMins;
    private Integer cantReproducciones = 0;
    private String cartelera;

    public void aumentarReproducciones(Integer reproducciones) {
        this.cantReproducciones += reproducciones;
    }

    public Double horasVisualizaciones() {
        return (this.duracionTotalEnMins / 60.0) * this.cantReproducciones;
    }
}
