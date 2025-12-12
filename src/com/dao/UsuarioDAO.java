
package com.dao; // Paquete DAO para acceso a datos de Usuarios

import com.basededatos.Conexion; // Importa la clase para conectar a la BD
import java.sql.Connection; // Importa la interfaz de conexión SQL
import java.sql.PreparedStatement; // Importa la clase para consultas preparadas (seguridad)
import java.sql.ResultSet; // Importa la clase para guardar resultados de consultas
import java.sql.SQLException; // Importa la clase de errores SQL


/**
 * DAO (Data Access Object) para gestionar operaciones CRUD (Crear, Leer, Actualizar, Borrar) 
 * de la entidad Tema en la base de datos.
 * * @author eitha
 */

public class UsuarioDAO {

   //Comprueba si las credenciales ingresadas coinciden con un usuario existente.
   public boolean validarUsuario(String nombreUsuario, String contrasena) throws SQLException {
       
      // Consulta SQL para buscar un usuario que coincida exactamente en nombre y clave.
    String sql = "SELECT * FROM Usuarios WHERE nombre_usuario = ? AND contrasena = ?";
    
    // Bloque try-with-resources para manejar la conexión y cerrarla automáticamente.
    try (Connection conn = Conexion.conectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        // Asigna los valores a los parámetros de la consulta (?).
        ps.setString(1, nombreUsuario);
        ps.setString(2, contrasena);
        
        // Ejecuta la consulta y obtiene los resultados.
        ResultSet rs = ps.executeQuery();
        
        // Retorna true si encontró al menos un registro (usuario válido).
        return rs.next();
    }
}

    //  Inserta un nuevo usuario en la base de datos.
    public boolean registrarUsuario(String nombreUsuario, String contrasena) throws SQLException {
        
        // Consulta SQL para insertar una nueva fila en la tabla Usuarios.
        String sql = "INSERT INTO Usuarios (nombre_usuario, contrasena) VALUES (?, ?)";
        
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Asigna los valores para el INSERT.
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasena);

            // Ejecuta la actualización y retorna true si se creó una fila nueva.
            return ps.executeUpdate() > 0;

            // Lanza una excepción personalizada si falla (ej: usuario duplicado).
        } catch (SQLException e) {
            throw new SQLException("Error al registrar usuario: " + e.getMessage(), e);
        }
    }

        // Verifica la contraseña actual antes de permitir un cambio.
        public boolean verificarContrasenaActual(String nombreUsuario, String contrasenaActual) throws SQLException {
         String sql = "SELECT * FROM Usuarios WHERE nombre_usuario = ? AND contrasena = ?";

    try (Connection conn = Conexion.conectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, nombreUsuario);
        ps.setString(2, contrasenaActual);
        ResultSet rs = ps.executeQuery();

        return rs.next(); // Retorna true si la contraseña es correcta

    } catch (SQLException e) {
        throw new SQLException("Error al verificar la contraseña actual: " + e.getMessage(), e);
    }
      
}
      // Actualiza la contraseña de un usuario en la base de datos.
    public boolean actualizarContrasena(String nombreUsuario, String nuevaContrasena) throws SQLException {
         String sql = "UPDATE Usuarios SET contrasena = ? WHERE nombre_usuario = ?";

    try (Connection conn = Conexion.conectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        // Asigna la NUEVA contraseña al primer parámetro.
        ps.setString(1, nuevaContrasena);
        
        // Usa el nombre de usuario para filtrar a quién se actualiza.
        ps.setString(2, nombreUsuario);

        // Ejecuta el update y verifica si afectó filas.
        int filas = ps.executeUpdate();
        return filas > 0; // True si se modificó alguna fila en la base de datos

    } catch (SQLException e) {
        throw new SQLException("Error al actualizar la contraseña: " + e.getMessage(), e);
    }
}
    
    // Recupera el ID único (Primary Key) del usuario basado en sus credenciales.
    public int obtenerIdUsuario(String nombreUsuario, String contrasena) throws SQLException {
    String sql = "SELECT id_usuario FROM Usuarios WHERE nombre_usuario = ? AND contrasena = ?";
    try (Connection conn = Conexion.conectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, nombreUsuario);
        ps.setString(2, contrasena);
        ResultSet rs = ps.executeQuery();
        
        // Si encuentra el usuario, devuelve el valor de la columna 'id_usuario'.
        if (rs.next()) {
            return rs.getInt("id_usuario"); 
        }
    }
    return 0; // Retorna 0 si las credenciales no coinciden o el usuario no existe.
}

  }
    
