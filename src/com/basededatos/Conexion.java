
package com.basededatos; // Define el paquete donde se encuentra la clase

/**
 * Clase que gestiona y conecta la base de datos
 * @author eitha
 */

import java.sql.Connection; // Importa la clase para gestionar la conexión
import java.sql.DriverManager; // Importa la clase para establecer la conexión (el driver)
import java.sql.SQLException; // Importa la clase para manejar errores de SQL


public class Conexion {
    
    // URL de conexión: Ruta completa al servidor, puerto y nombre de la base de datos (proyecto_final)
   private static final String URL = "jdbc:mysql://localhost:3306/proyecto_final";
   
    // Usuario de la base de datos 
    private static final String USER = "root";
    
    // Contraseña del usuario
   private static final String PASSWORD = "";
    
    /**
     * Método estático público que abre y retorna una conexión activa a la base de datos
     * @throws SQLException Si falla la conexión por credenciales o servidor
     */
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
    
    
    
    
    

