package test;

import datos.*;
import domain.PersonaDTO;
import java.sql.*;
import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            IPersonaDao personaDao = new PersonaDAO();

            List<PersonaDTO> personas = personaDao.select();
            for(PersonaDTO persona:personas){
                System.out.println("PersonaDTO = " + persona);
            }

            conexion.commit();
            System.out.println("Commit Exitoso");

        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
            System.out.println("    Entramos al ROLLBACK");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }

}
