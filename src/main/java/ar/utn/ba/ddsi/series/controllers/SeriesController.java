package ar.utn.ba.ddsi.series.controllers;

import ar.utn.ba.ddsi.series.models.dtos.output.SerieOutputDTO;
import ar.utn.ba.ddsi.series.services.ISeederService;
import ar.utn.ba.ddsi.series.services.ISeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/series")
@CrossOrigin(origins = "http://localhost:3000")
public class SeriesController {
    @Autowired
    private ISeriesService seriesService;

    @Autowired
    private ISeederService seederService;

    @GetMapping
    public List<SerieOutputDTO> buscarTodas() {
        return this.seriesService.buscarTodas();
    }

    @GetMapping("/inicializar")
    public boolean inicializarDatos() {
        this.seederService.init();
        return true;
    }
}
