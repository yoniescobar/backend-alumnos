package com.intecap.agenda.controllers;

import com.intecap.agenda.models.Alumno;
import com.intecap.agenda.repositories.AlumnoRepository;
import com.intecap.agenda.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = {"http://localhost:3001", "http://localhost:3000","http://localhost:4200"}) // Indica que este controlador REST puede ser accedido desde cualquier origen (dominio) y desde cualquier puerto (3000, 3001, etc)
@RestController // @RestController es una anotación que indica que la clase es un controlador de Spring
@RequestMapping("/api/v1")
public class AlumnoController {
    @Autowired // inyección de dependencias (se crea una instancia de AlumnoService)
    AlumnoService alumnoService; // se crea una instancia de AlumnoService para poder usar sus métodos

    @GetMapping("/alumnos")
    public ArrayList<Alumno> obtenerAlumnos(){
        return alumnoService.obtenerAlumnos();
    }

    @PostMapping("/alumnos")
    public Alumno guardarAlumno(@RequestBody Alumno alumno){
        // @RequestBody es para que el objeto alumno se cree a partir de los datos que se envian en el body
        return alumnoService.guardarAlumno(alumno);
    }

    @GetMapping("/alumnos/{id}")
    public Alumno buscarAlumno(@PathVariable("id") Long id){
        return alumnoService.buscarAlumno(id);
    }

    @PutMapping("/alumnos/{id}")
    public Alumno actualizarAlumno(@RequestBody Alumno alumno, @PathVariable("id") Long id){
        Alumno alumnoEncontrado = alumnoService.buscarAlumno(id);
        alumnoEncontrado.setNombre(alumno.getNombre());
        alumnoEncontrado.setEdad(alumno.getEdad());
        alumnoEncontrado.setCorreo(alumno.getCorreo());
        alumnoEncontrado.setTelefono(alumno.getTelefono());
        return alumnoService.actualizarAlumno(alumnoEncontrado);
    }

    @DeleteMapping("/alumnos/{id}")
    public String eliminarAlumno(@PathVariable("id") Long id){
        boolean ok = alumnoService.eliminarAlumno(id);
        if(ok){
            return "Se eliminó el alumno con id " + id;
        }else{
            return "No se pudo eliminar el alumno con id " + id;
        }
    }



  
}
