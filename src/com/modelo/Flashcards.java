
package com.modelo; // Define el paquete que contiene los modelos de datos.

/**
 * Clase que representa una tarjeta de estudio (Flashcard) individual.
 *
 * @author eitha
 */
public class Flashcards {
    
    private int idFlashcard; 
    private int idTema;        
    private String contenido; // Antes era pregunta/respuesta, ahora es solo contenido
    
    public Flashcards() {
    }
    
    public Flashcards(int idFlashcard, int idTema, String contenido) {
        this.idFlashcard = idFlashcard;
        this.idTema = idTema;
        this.contenido = contenido;
    }
    
    public Flashcards(int idTema, String contenido) {
        this.idTema = idTema;
        this.contenido = contenido;
    }
    
    // Getters y Setters
    public int getIdFlashcard() { return idFlashcard; }
    public void setIdFlashcard(int idFlashcard) { this.idFlashcard = idFlashcard; }
    
    public int getIdTema() { return idTema; }
    public void setIdTema(int idTema) { this.idTema = idTema; }
    
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    
    // Alias para compatibilidad si alguna parte del código viejo llama a getPregunta
    public String getPregunta() { return contenido; }
}
    
    


