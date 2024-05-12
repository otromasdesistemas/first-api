package com.bootcamp.estudiante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudianteService {
    private EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> getEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.getEstudiantes();

        return estudiantes;
    }

    public Estudiante getEstudiante(Long id) {
        Estudiante estudiante = estudianteRepository.getEstudiante(id);
        return estudiante;
    }

    public void createEstudiante(Estudiante estudiante) {
        System.out.println("service create estudiante entered");
        estudianteRepository.createEstudiante(estudiante);
        System.out.println("service create estudiante exeited");

    }

    public void deleteEstudiante(Long id) {
        // check si id existe, si no imprimimos warning
        boolean existe = false;

        for(Estudiante e: getEstudiantes()) {
            if(e.getId().equals(id)) {
                existe = true;
                break;
            }
        }
        if(!existe) {
            System.out.println("WARNING: el estudiante con ese id, no existe");
            return;
        }

        estudianteRepository.deleteEstudiante(id);
    }

    public void putEstudiante(Long id, Estudiante estudianteAActualizar) {
        boolean existe = false;

        for(Estudiante e: getEstudiantes()) {
            if(e.getId().equals(id)) {
                existe = true;
                break;
            }
        }
        if(!existe) {
            System.out.println("WARNING: el estudiante con ese id, no existe");
            return;
        }

        estudianteRepository.putEstudiante(id, estudianteAActualizar);
    }
}
