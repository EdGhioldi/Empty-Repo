package datos;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import javax.sql.DataSource;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        //Definimos el tamaño inicial del Pool de Conexiones
        ds.setInitialSize(5);
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    public static void close(Statement stmt) throws SQLException{
        stmt.close();
    }
    public static void close(PreparedStatement stmt) throws SQLException{
        stmt.close();
    }
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }

}
