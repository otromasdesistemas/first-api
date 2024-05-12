package com.bootcamp.estudiante;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EstudianteRepository {
    private final List<Estudiante> estudiantes;

    public EstudianteRepository() {
        this.estudiantes = new ArrayList<>();
//                estudiantes.add(new Estudiante(1L,"Miguel"));
//                estudiantes.add(new Estudiante(2L,"Raul"));
//                estudiantes.add(new Estudiante(3L,"Juan"));
//                estudiantes.add(new Estudiante(4L,"Maria"));
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public Estudiante getEstudiante(Long id) {
        for(Estudiante estudiante: estudiantes) {
            if(estudiante.getId().equals(id)) {
                return estudiante;
            }
        }
        System.out.println("WARNING: No existe tal estudiante con ese id");
        throw new IllegalStateException("No se encontro el estudiante con ese ID");
    }

    public void createEstudiante(Estudiante estudiante) {
        System.out.println("repository create estudiante entered");
        estudiantes.add(estudiante);
        System.out.println("repository create estudiante exited");

    }

    public void deleteEstudiante(Long id) {
        for(int i = 0; i < estudiantes.size(); i++) {
            Estudiante estudiante = estudiantes.get(i);
           if(estudiante.getId().equals(id)) {
               estudiantes.remove(i);
               break;
           }
        }
    }

    public void putEstudiante(Long id, Estudiante estudianteAActualizar) {
        for (Estudiante estudiante: estudiantes) {
            if(estudiante.getId().equals(id)) {
                estudiante.setPrimerNombre(estudianteAActualizar.getPrimerNombre());
                estudiante.setId(estudianteAActualizar.getId());
                break;
            }
        }
    }
}
