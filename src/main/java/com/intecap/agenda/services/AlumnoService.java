package com.intecap.agenda.services;

import com.intecap.agenda.models.Alumno;
import com.intecap.agenda.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AlumnoService {
    @Autowired // inyección de dependencias (se crea una instancia de AlumnoRepository)
    AlumnoRepository alumnoRepository;

   public ArrayList<Alumno> obtenerAlumnos(){
        return (ArrayList<Alumno>) alumnoRepository.findAll();
    }

    public Alumno guardarAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public Alumno buscarAlumno(Long id){
        return alumnoRepository.findById(id).orElse(null);
    }

    public Alumno actualizarAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public boolean eliminarAlumno(Long id){
        try{
            alumnoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }





}
