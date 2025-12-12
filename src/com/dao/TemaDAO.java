
package com.dao; // Paquete DAO para gestión de datos de Temas

import com.modelo.Tema;  // Importa la clase modelo Tema (POJO).
import com.basededatos.Conexion; // Importa la clase de conexión a la base de datos
import java.sql.*;  // Importa todas las clases relacionadas con JDBC (SQL).
import java.util.ArrayList; // Importa ArrayList para listas dinámicas
import java.util.List; // Importa la interfaz List

/**
 * DAO (Data Access Object) para gestionar operaciones CRUD (Crear, Leer, Actualizar, Borrar) 
 * de la entidad Tema en la base de datos.
 * * @author eitha
 */

public class TemaDAO {
    
    // Añade un tema nuevo dentro de una asignatura
    public boolean agregarTema(int idAsignatura, String nombre) {
        String sql = "INSERT INTO Temas (id_asignatura, nombre) VALUES (?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Asigna los parámetros
            ps.setInt(1, idAsignatura);
            ps.setString(2, nombre);
            
           // Ejecuta y verifica si se afectó alguna fila
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Obtiene una lista de todos los temas que pertenecen a una asignatura específica.
    public List<Tema> listarTemasPorAsignatura(int idAsignatura) {
        List<Tema> lista = new ArrayList<>();
        
        // Selecciona ID y nombre filtrando por asignatura
        String sql = "SELECT id_tema, nombre FROM Temas WHERE id_asignatura = ?";
        
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            
            ps.setInt(1, idAsignatura);
            ResultSet rs = ps.executeQuery();
            
            // Itera sobre los resultados y crea objetos Tema
            while (rs.next()) {
                Tema tema = new Tema(rs.getString("nombre"));
                tema.setIdTema(rs.getInt("id_tema")); 
                lista.add(tema);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
     // Busca y retorna un objeto Tema específico basado en su ID único.
    public Tema obtenerTemaPorId(int idTema) {
        String sql = "SELECT * FROM Temas WHERE id_tema = ?";
        
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idTema);
            ResultSet rs = ps.executeQuery();
            
            // Si hay un resultado, crea y retorna el objeto Tema
            if (rs.next()) {
                Tema tema = new Tema(rs.getString("nombre"));
                tema.setIdTema(rs.getInt("id_tema"));
                return tema;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Si no encuentra nada retorna null
    }
    
    //Modifica el nombre de un tema existente.
    public boolean actualizarTema(int idTema, String nuevoNombre) {
        String sql = "UPDATE Temas SET nombre = ? WHERE id_tema = ?";
        
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nuevoNombre);
            ps.setInt(2, idTema);
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Elimina un tema de la base de datos.
    // Esto borrará en cascada todas las flashcards asociadas
    public boolean eliminarTema(int idTema) {
        String sql = "DELETE FROM Temas WHERE id_tema = ?";
        
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idTema);
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
   
     // Cuenta la cantidad total de temas que tiene una asignatura.
    // Útil para mostrar estadísticas en el dashboard.
    public int contarTemasPorAsignatura(int idAsignatura) {
        String sql = "SELECT COUNT(*) as total FROM Temas WHERE id_asignatura = ?";
        
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idAsignatura);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("total");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}