package ar.utn.ba.ddsi.series.controllers;

import ar.utn.ba.ddsi.series.models.dtos.output.GeneroOutputDTO;
import ar.utn.ba.ddsi.series.services.IGenerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
@CrossOrigin(origins = "http://localhost:3000")
public class GenerosController {
    @Autowired
    private IGenerosService generosService;

    @GetMapping
    public List<GeneroOutputDTO> buscarTodos() {
        return this.generosService.buscarTodos();
    }
}
