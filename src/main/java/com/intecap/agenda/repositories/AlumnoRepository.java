package com.intecap.agenda.repositories;

import com.intecap.agenda.models.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
 // CrudRepository<Alumno, Long> es una interfaz que nos permite hacer operaciones CRUD
    //Crud: Create, Read, Update, Delete
    //JPA: Java Persistence API (API de persistencia de Java) es una especificación de Java que define la persistencia de objetos en una base de datos relacional.

}
