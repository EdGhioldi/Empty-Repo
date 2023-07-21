package test;

import datos.*;
import domain.Usuario;
import java.sql.*;

public class TestManejoUsuario {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }


            UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
            Usuario agregar1 = new Usuario();
            Usuario agregar2 = new Usuario();

            agregar1.setNombre("Igor");
            agregar1.setApellido("Ghioldi");
            agregar2.setNombre("La Vela");
            agregar2.setApellido("Puerca");
            usuarioJDBC.insercion(agregar1);
            usuarioJDBC.insercion(agregar2);

            Usuario modificar1 = new Usuario();
            modificar1.setId_usuario(3);
            modificar1.setNombre("Alberto");
            modificar1.setApellido("Canario");
            usuarioJDBC.modificacion(modificar1);

            Usuario borrar = new Usuario();
            borrar.setId_usuario(4);
            usuarioJDBC.eliminacion(borrar);

            conexion.commit();
            System.out.println("Pedazo de Commit te mandaste maquina!!");


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
