package com.controlador;
/**
 * Clase que ajusta el texto de los flashcards
 * @author eitha
 */
import java.text.BreakIterator; // Importa para análisis de límites de texto
import java.util.ArrayList; // Importa ArrayList para listas dinámicas
import java.util.List; // Importa la interfaz List 
import java.util.Locale; // Importa para configuración regional e idioma

public class FormateadorTexto {
    // Constante que define el límite máximo de caracteres por tarjeta
    private static final int MAX_CHARS_PER_CARD = 380; 
    
    // Método que divide un texto largo en múltiples tarjetas respetando oraciones completas
    public static List<String> crearParrafosInteligentes(String text) {
        // Lista que almacenará las tarjetas generadas
        List<String> cards = new ArrayList<>();
        
        // Valida si el texto está vacío o es nulo
        if (text == null || text.isEmpty()) {
            return cards;
        }
        
        // Crea un iterador que identifica los límites de las oraciones en español
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.forLanguageTag("es-ES"));
        iterator.setText(text);
        
        // Obtiene la posición inicial del texto
        int start = iterator.first();
        // StringBuilder para construir cada tarjeta
        StringBuilder currentCard = new StringBuilder();
        
        // Itera sobre cada oración del texto
        for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
            // Extrae la oración actual y elimina espacios en blanco
            String sentence = text.substring(start, end).trim();
            if (sentence.isEmpty()) continue;
            
            // Verifica si la oración cabe en la tarjeta actual
            if (currentCard.length() + sentence.length() <= MAX_CHARS_PER_CARD) {
                currentCard.append(sentence).append(" ");
            } else {
                // Si no cabe, guarda la tarjeta actual y crea una nueva
                if (currentCard.length() > 0) {
                    cards.add(currentCard.toString().trim());
                    currentCard.setLength(0);
                }
                currentCard.append(sentence).append(" ");
            }
        }
        
        // Agrega la última tarjeta si tiene contenido
        if (currentCard.length() > 0) {
            cards.add(currentCard.toString().trim());
        }
        
        // Retorna la lista de tarjetas generadas
        return cards;
    }
    
    
    
}