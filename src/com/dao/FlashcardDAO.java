
package com.dao; // Paquete DAO para acceso a datos de Flashcards

import com.modelo.Flashcards; // Importa la clase modelo Flashcards (POJO).
import com.basededatos.Conexion; // Importa la clase de conexión a la base de datos.
import java.sql.*; // Importa todas las clases relacionadas con JDBC (SQL).
import java.util.ArrayList; // Importa ArrayList para listas dinámicas
import java.util.List; // Importa la interfaz List

/**
 * DAO (Data Access Object) para gestionar operaciones CRUD (Crear, Leer, Actualizar, Borrar) 
 * de la entidad Tema en la base de datos.
 * * @author eitha
 */

public class FlashcardDAO {

    // --- AGREGAR (CREATE) ---
    public boolean agregarFlashcard(int idTema, String contenido) {
        // SQL actualizado: Solo insertamos id_tema y el contenido
        String sql = "INSERT INTO Flashcards (id_tema, contenido) VALUES (?, ?)";
        
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idTema);
            ps.setString(2, contenido);
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // --- LISTAR (READ) ---
    public List<Flashcards> listarFlashcards(int idTema) {
        List<Flashcards> lista = new ArrayList<>();
        // SQL actualizado: Seleccionamos 'contenido' en lugar de 'pregunta'
        String sql = "SELECT id_flashcard, id_tema, contenido FROM Flashcards WHERE id_tema = ? ORDER BY id_flashcard";
        
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idTema);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Flashcards f = new Flashcards(
                    rs.getInt("id_flashcard"),
                    rs.getInt("id_tema"),
                    rs.getString("contenido") // Obtenemos la columna nueva
                );
                lista.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    // --- ACTUALIZAR (UPDATE) ---
    public boolean actualizarFlashcard(int idFlashcard, String nuevoContenido, String ignorar) {
        // SQL actualizado: Modificamos la columna 'contenido'
        String sql = "UPDATE Flashcards SET contenido = ? WHERE id_flashcard = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nuevoContenido);
            ps.setInt(2, idFlashcard);
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // --- ELIMINAR (DELETE) ---
    public boolean eliminarFlashcard(int idFlashcard) {
        String sql = "DELETE FROM Flashcards WHERE id_flashcard = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idFlashcard);
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // --- CREACIÓN MASIVA DESDE TEXTO (Aquí estaba el error) ---
    public boolean crearFlashcardsDesdeTexto(int idTema, String textoCompleto) {
        
        // Dividimos el texto en párrafos
        List<String> paragraphs = com.controlador.FormateadorTexto.crearParrafosInteligentes(textoCompleto);
        
        // Borramos las anteriores para limpiar el tema
        eliminarFlashcardsPorTema(idTema);
        
        // SQL CORREGIDO: Ajustado a la nueva tabla (sin respuesta, ni aprendida, ni NOW())
        String sql = "INSERT INTO Flashcards (id_tema, contenido) VALUES (?, ?)";
        
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            for (String parrafo : paragraphs) {
                ps.setInt(1, idTema);
                ps.setString(2, parrafo);
                ps.addBatch(); // Agrega al lote
            }
            
            // Ejecuta el lote completo
            int[] results = ps.executeBatch();
            
            return results.length == paragraphs.size();
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Método auxiliar para limpiar tema
    private boolean eliminarFlashcardsPorTema(int idTema) {
        String sql = "DELETE FROM Flashcards WHERE id_tema = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idTema);
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
