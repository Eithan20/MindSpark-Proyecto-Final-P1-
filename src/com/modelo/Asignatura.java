
package com.modelo; // Define el paquete que contiene los modelos de datos.

import java.util.ArrayList; // Importa la clase para manejar listas dinámicas.
import java.util.List; // Importa la interfaz List.

/**
 * Clase que gestiona las Asignaturas
 * @author eitha
 */

public class Asignatura {

    
    // Atributos principales
    private int idAsignatura; // Identificador único de la asignatura (Clave Primaria).
    private int idUsuario;  // Identificador del usuario al que pertenece esta asignatura (Clave Foránea).
    private String nombre;   // Nombre descriptivo de la asignatura (ej: "Matemáticas", "Historia").
    private List<Tema> temas; // Lista en memoria que almacena los objetos 'Tema' asociados a esta asignatura.
    
     // Atributos para estadísticas
     private int cantidadTemas;  // Contador de cuántos temas tiene la asignatura.
     private int cantidadFlashcards;  // Contador del total de flashcards acumuladas en todos los temas de esta asignatura.

    // Constructor 1: Inicializa con los 3 datos fundamentales (usado al cargar desde la BD).
    public Asignatura(int idAsignatura, int idUsuario, String nombre) {
    this.idAsignatura = idAsignatura;
    this.idUsuario = idUsuario;
    this.nombre = nombre;
    this.temas = new ArrayList<>();
}

    // Constructor 2: Simple, solo con nombre (usado al crear una asignatura nueva antes de guardarla).
    public Asignatura(String nombre) {
        this.nombre = nombre;
        this.temas = new ArrayList<>();
    }

   // Constructor 3: Completo con estadísticas (usado para mostrar datos en la tabla del Dashboard).
    public Asignatura(int idAsignatura, int idUsuario, String nombre, int cantidadTema ,int cantidadFlashcards) {
        this.idAsignatura = idAsignatura;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.cantidadTemas = cantidadTemas;
        this.cantidadFlashcards = cantidadFlashcards;
        this.temas = new ArrayList<>();
    }

    //Métodos Getters y Setters (Acceso a datos
    // Retorna el ID de la asignatura.
    public int getIdAsignatura() {
        return idAsignatura;
    }
    
    // Modifica el ID de la asignatura.
    public void setIdAsignatura(int id) {
        this.idAsignatura = id;
    }
    
    // Retorna el ID del usuario dueño.
    public int getIdUsuario() {
        return idUsuario;
    }

    // Modifica el ID del usuario dueño.
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Retorna el nombre de la asignatura.
    public String getNombre() {
        return nombre;
    }

    // Retorna la lista de temas en memoria.
    public List<Tema> getTemas() {
        return temas;
    }

    // Agrega un objeto Tema a la lista local.
    public void agregarTema(Tema t) {
        temas.add(t);
    }

    // Elimina un objeto Tema de la lista local.
    public void eliminarTema(Tema t) {
        temas.remove(t);
    }
    
    // Asigna la cantidad de temas (para reportes).
    public void setCantidadTemas(int c) { 
        this.cantidadTemas = c; 
    }
    
    // Obtiene la cantidad de temas.
     public int getCantidadTemas() { 
         return cantidadTemas; 
     }
    
     // Asigna la cantidad total de flashcards (para reportes).
    public void setCantidadFlashcards(int c) { 
        this.cantidadFlashcards = c;
    }
    
    // Obtiene la cantidad total de flashcards.
    public int getCantidadFlashcards() { 
        return cantidadFlashcards; 
    }
    
   
}
