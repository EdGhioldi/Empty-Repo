package test;

import datos.PersonaDAO;
import domain.Persona;

import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
/*
        //INSERTAR UN NUEVO OBJETO DE TIPO PERSONA
        Persona personaNueva = new Persona("Carlos","Esparza","cesparza@mail.com","341328753");
        personaDao.insertar(personaNueva);


        Persona personaModificada = new Persona(4, "Juani","Garcia","juani@mail.com","351563532");
        personaDao.update(personaModificada);
 */
        Persona personaEliminada = new Persona(4);
        personaDao.delete(personaEliminada);


        Persona personaNueva = new Persona("Carlos","Esparza","cesparza@mail.com","341328753");
        personaDao.insertar(personaNueva);

        List<Persona> personas = personaDao.seleccionar();
        for(Persona persona:personas){
            System.out.println("persona = " + persona);
        };


    }

}
