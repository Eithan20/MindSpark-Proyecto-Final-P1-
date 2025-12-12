
package com.modelo; // Define el paquete que contiene los modelos de datos

/**
 * Clase que gestiona los Temas
 * @author eitha
 */

 import java.util.ArrayList; // Importa la clase para listas dinámicas
import java.util.List; // Importa la interfaz List


public class Tema {

    // Identificador único del tema en la base de datos (Clave Primaria)
     private int idTema;
     
    // Identificador de la asignatura a la que pertenece este tema (Clave Foránea)
    private int idAsignatura;
    
    // Nombre descriptivo del tema
    private String nombre;
    
    // Lista en memoria que contiene las flashcards asociadas a este tema
    private List<Flashcards> flashcards;
    
    // --- Constructores ---
    
    // Constructor completo: Se usa al recuperar datos existentes de la base de datos (ya tienen IDs)
    public Tema(int idTema, int idAsignatura, String nombre) {
        this.idTema = idTema;
        this.idAsignatura = idAsignatura;
        this.nombre = nombre;
        this.flashcards = new ArrayList<>(); // Inicializa la lista vacía para evitar errores
    }
   
   // Constructor secundario: Inicializa con nombre y una lista de flashcards existente
    public Tema(String nombre, List<Flashcards> flashcards) {
        this.nombre = nombre;
        // Si la lista pasada es nula, crea una nueva vacía para evitar errores (NullPointerException)
        this.flashcards = flashcards != null ? flashcards : new ArrayList<>();
    }
    
    // Constructor simple: Se usa para crear un tema nuevo antes de guardarlo en la BD (sin ID aún)
    public Tema(String nombre) {
        this.nombre = nombre;
        this.flashcards = new ArrayList<>();
    }
    
    // Constructor vacío: Útil para instanciar el objeto y setear valores después
    public Tema() {
        this.flashcards = new ArrayList<>();
    }
    
    // --- Métodos Getters y Setters ---
    
   // Retorna el ID del tema
    public int getIdTema() {
        return idTema;
    }
    // Asigna el ID del tema
    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }
    // Retorna el ID de la asignatura padre
    public int getIdAsignatura() {
        return idAsignatura;
    }
    // Asigna el ID de la asignatura padre
    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
    // Retorna el nombre del tema
    public String getNombre() {
        return nombre;
    }
    // Modifica el nombre del tema
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // Retorna la lista completa de flashcards
    public List<Flashcards> getFlashcards() {
        return flashcards;
    }
    // Reemplaza la lista de flashcards completa
    public void setFlashcards(List<Flashcards> flashcards) {
        this.flashcards = flashcards;
    }
    // Agrega una sola tarjeta a la lista local
    public void agregarFlashcards(Flashcards card) {
        flashcards.add(card);
    }
    // Elimina una tarjeta de la lista local
    public void eliminarFlashcards(Flashcards card) {
        flashcards.remove(card);
    }
}