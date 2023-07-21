package datos;

import domain.*;
import java.sql.*;
import java.util.*;

import static datos.Conexion.close;

public class UsuarioJDBC {
    private Connection conexionTransaccion;
    private static final String SQL_SELECCION = "SELECT id_usuario, nombre, apellido FROM usuario";
    private final static String SQL_INSERCION = "INSERT INTO usuario (nombre, apellido) VALUES (?,?)";
    private static final String SQL_MODIFICACION = "UPDATE usuario SET nombre = ?, apellido = ? WHERE id_usuario = ?";
    private static final String SQL_ELIMINACION = "DELETE FROM usuario WHERE id_usuario = ?";

    public UsuarioJDBC(){};
    public UsuarioJDBC(Connection conexionTransaccion){
        this.conexionTransaccion  = conexionTransaccion;
    }
    public List<Usuario> seleccion() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs  = null;
        Usuario usuario = null;
        List<Usuario>usuarios = new ArrayList<>();

        try {
            conn = this.conexionTransaccion != null ? this.conexionTransaccion : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECCION);
            rs  = stmt.executeQuery();
            while(rs.next()){
                int id_usuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");

                usuario = new Usuario(id_usuario,nombre,apellido);
                usuarios.add(usuario);

            }
        }finally{
            try {
                close(rs);
                close(stmt);
                if(this.conexionTransaccion == null){
                    close(conn);}
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return usuarios;
    }

    public int insercion(Usuario usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int regs = 0;
        try{
            conn = this.conexionTransaccion != null ? this.conexionTransaccion : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERCION);
            stmt.setString(1,usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            regs = stmt.executeUpdate();
        }finally{
            try {
                close(stmt);
                if(this.conexionTransaccion == null){
                    Conexion.close(conn);}
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

    return regs;
    }

    public int modificacion(Usuario usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int regs = 0;

        try{
            conn = this.conexionTransaccion != null ? this.conexionTransaccion : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_MODIFICACION);
            stmt.setString(1,usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setInt(3,usuario.getId_usuario());
            regs = stmt.executeUpdate();
        }finally{
            try {
                close(stmt);
                if(this.conexionTransaccion == null){
                    Conexion.close(conn);}
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }return regs;
    }

    public int eliminacion(Usuario usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int regs = 0;
        try{
            conn = this.conexionTransaccion != null ? this.conexionTransaccion : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_ELIMINACION);
            stmt.setInt(1,usuario.getId_usuario());
            regs = stmt.executeUpdate();
        }finally{
            try {
                close(stmt);
                if(this.conexionTransaccion == null){
                    Conexion.close(conn);}
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }return regs;
    }
}
