
package com.dao;

import com.modelo.Asignatura; // Importa la clase modelo Asignatura (POJO).
import com.basededatos.Conexion; // Importa la clase de conexión a la base de datos.
import java.sql.*; // Importa todas las clases relacionadas con JDBC (SQL).
import java.util.ArrayList; // Importa ArrayList para listas dinámicas
import java.util.List;  // Importa la interfaz List.


/**
 * DAO (Data Access Object) para gestionar operaciones CRUD (Crear, Leer, Actualizar, Borrar) 
 * de la entidad Asignatura en la base de datos.
 * * @author eitha
 */

public class AsignaturaDAO {
    
   // Crea una nueva asignatura para un usuario
    public boolean agregarAsignatura(int idUsuario, String nombre) {
        // Consulta SQL parametrizada para insertar una nueva asignatura con el ID de usuario.
        String sql = "INSERT INTO Asignaturas (id_usuario, nombre) VALUES (?, ?)";
        
        // El bloque try-with-resources asegura que la conexión (conn) y el PreparedStatement (ps) se cierren automáticamente.
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            //Asigna el ID de usuario al primer parámetro de la consulta (?)
            ps.setInt(1, idUsuario);
            //Asigna el nombre de la asignatura al segundo parámetro (?).
            ps.setString(2, nombre);
            
            // Ejecuta la actualización (INSERT) y retorna true si se insertó al menos una fila.
            return ps.executeUpdate() > 0;
            
            // Se ejecuta en caso de error (ej. problema de conexión o SQL). 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Trae todas las asignaturas de un usuario específico
    public List<Asignatura> listarAsignaturas(int idUsuario) { 
        // Inicializa la lista que contendrá los objetos Asignatura
    List<Asignatura> lista = new ArrayList<>();
    // Consulta SQL para seleccionar todos los campos de las asignaturas que coincidan con el ID de usuario
    String sql = "SELECT * FROM Asignaturas WHERE id_usuario = ?";
    
    // El bloque try-with-resources asegura el cierre de recursos.
    try (Connection conn = Conexion.conectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        //Asigna el ID de usuario al parámetro de la consulta
        ps.setInt(1, idUsuario);
        //Ejecuta la consulta (SELECT) y guarda los resultados en el ResultSet
        ResultSet rs = ps.executeQuery();
        
        // Recorre cada fila que trajo la consulta
        while (rs.next()) {
            
            // Mapea los resultados de la fila actual a un nuevo objeto Asignatura.
            Asignatura a = new Asignatura(
                rs.getInt("id_asignatura"),// Obtiene el ID de la asignatura
                rs.getInt("id_usuario"), // Obtiene el ID del usuario asociado
                rs.getString("nombre")   // Obtiene el nombre de la asignatura
            );
            // Agrega el objeto Asignatura a la lista
            lista.add(a);
        }
    } catch (Exception e) {
        // En caso de error, La lista se retorna vacía.
        e.printStackTrace();
    }
    return lista;
}
    
     // Borra una asignatura (y todo lo que contenga dentro)
    public boolean actualizarAsignatura(int idAsignatura, String nuevoNombre) {
        // Consulta SQL para actualizar el campo 'nombre' donde el ID de la asignatura coincida.
        String sql = "UPDATE Asignaturas SET nombre = ? WHERE id_asignatura = ?";
        
        // El bloque try-with-resources asegura el cierre de recursos.
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Asigna el nuevo nombre.
            ps.setString(1, nuevoNombre);
            
            // Asigna el ID de la asignatura para la condición WHERE.
            ps.setInt(2, idAsignatura);
            
            // Ejecuta la actualización y retorna true si se modificó al menos una fila.
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // ✅ Eliminar una asignatura
    public boolean eliminarAsignatura(int idAsignatura) {
        // Consulta SQL para eliminar la fila donde el ID de la asignatura coincida.
        String sql = "DELETE FROM Asignaturas WHERE id_asignatura = ?";
        
        // El bloque try-with-resources asegura el cierre de recursos.  
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Asigna el ID de la asignatura a eliminar.
            ps.setInt(1, idAsignatura);
            
            // Ejecuta la eliminación y retorna true si se eliminó al menos una fila.
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }   
    
}