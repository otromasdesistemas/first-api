package com.bootcamp.estudiante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/estudiantes")
public class EstudianteController {

    private EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Estudiante> getEstudiantes() {
        return estudianteService.getEstudiantes();
    }

    @GetMapping("{id}")
    public Estudiante getEstudiante(@PathVariable Long id) {
        return estudianteService.getEstudiante(id);
    }


    @PostMapping
    public void createEstudiante(@RequestBody Estudiante estudiante) {
        System.out.println("controller create estudiante entered");
        estudianteService.createEstudiante(estudiante);
        System.out.println("controller create estudiante exited");
    }



    @DeleteMapping("{id}")
    public void deleteEstudiante(@PathVariable Long id) {
        estudianteService.deleteEstudiante(id);
    }

    @PutMapping("{id}")
    public void putEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteAActualizar) {
        estudianteService.putEstudiante(id, estudianteAActualizar);
    }
}
