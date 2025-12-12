
package com.controlador; // Define el paquete donde se encuentra la clase (Capa de Controlador).

/**
 * Clase estática que actúa como un contenedor global para los datos del usuario logueado.
 * Implementa el patrón Singleton/Estatica para gestionar el estado de la sesión actual de la aplicación.
 *
 * @author eitha
 */
public class SesionActual {

     // Atributo estático que guarda el ID único del usuario que ha iniciado sesión.
    private static int idUsuario;
    
    // Atributo estático que guarda el nombre de usuario (o correo) del usuario activo.
    private static String nombreUsuario;

/**
     * Inicializa los datos de la sesión actual al momento del login.
     * @param id El ID del usuario.
     * @param nombre El nombre de usuario.
     */
    public static void iniciarSesion(int id, String nombre) {
        // Asigna el ID recibido al atributo estático idUsuario.
        idUsuario = id;
        // Asigna el nombre de usuario recibido al atributo estático nombreUsuario.
        nombreUsuario = nombre;
    }

    /**
     * Obtiene el ID del usuario actualmente logueado.
     * @return El ID del usuario (o 0 si no hay sesión activa).
     */
    public static int getIdUsuario() {
        // Retorna el valor actual del ID del usuario.
        return idUsuario;
    }

    /**
     * Obtiene el nombre del usuario actualmente logueado.
     * @return El nombre de usuario (o null si no hay sesión activa).
     */
    public static String getNombreUsuario() {
        // Retorna el nombre de usuario actual.
        return nombreUsuario;
    }

    /**
     * Restablece los datos de la sesión, cerrando la sesión del usuario actual.
     */
    public static void cerrarSesion() {
        // Establece el ID a 0 (indicando que no hay usuario válido).
        idUsuario = 0;
        // Establece el nombre de usuario a null (limpiando los datos).
        nombreUsuario = null;
    }

    /**
     * Verifica rápidamente si existe un usuario logueado.
     * @return true si nombreUsuario no es nulo (hay sesión activa), false en caso contrario.
     */
    public static boolean haySesionActiva() {
        // Retorna verdadero si el nombre de usuario tiene un valor (no es nulo).
        return nombreUsuario != null;
    }
}