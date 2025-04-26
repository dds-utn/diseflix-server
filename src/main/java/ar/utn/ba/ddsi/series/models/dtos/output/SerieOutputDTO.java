package ar.utn.ba.ddsi.series.models.dtos.output;

import lombok.Data;

@Data
public class SerieOutputDTO {
    private Long id;
    private String nombre;
    private Long idGenero;
    private String resenia;
    private Double horasVisualizacion;
    private String cartelera;
}
