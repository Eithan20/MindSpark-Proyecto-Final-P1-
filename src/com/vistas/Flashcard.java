package com.vistas; // Paquete de la capa de Vistas

import com.controlador.FormateadorTexto; // Importa el formateador de texto
import com.dao.FlashcardDAO; // Importa el DAO para operaciones de Flashcard
import com.modelo.Flashcards; // Importa el modelo Flashcards
import java.awt.BorderLayout; // Importa el gestor de diseño BorderLayout
import java.awt.Color; // Importa para definir colores RGB/RGBA
import java.util.List; // Importa la interfaz List para colecciones ordenadas
import javax.swing.JOptionPane; // Importa para diálogos de mensaje
import javax.swing.JScrollPane; // Importa para contenedores con barras de desplazamiento

/**
 * Ventana principal del dashboard que muestra la tabla de asignaturas/temas
 * y permite navegar a diferentes secciones de la aplicación
 * @author eitha
 */

public class Flashcard extends javax.swing.JPanel {
    
    private javax.swing.JTextPane textoHTML;
    
    // Referencia al dashboard padre para poder volver
    private Dashboard dashboardPadre;
    
    // Lista con los IDs de las flashcards cargadas desde la BD
    private List<Integer> flashcardIds; // IDs de las flashcards en BD
    
     // IDs del tema y asignatura actuales
    private int idAsignatura;
    private int idTema;
    
    // DAO para acceder a las flashcards en la base de datos
    private FlashcardDAO flashcardDAO;
   
    
    
    // Constructor sin parámetros (para pruebas)
    public Flashcard(Dashboard aThis) {
    this.dashboardPadre = null;
    initComponents();
    
    configurarDiseño(); 
    iniciarLogica(); 
}

    // Constructor principal con IDs (para uso real conectado a BD)
public Flashcard(Dashboard aThis, int idAsignatura, int idTema) {
    initComponents();
    this.dashboardPadre = aThis;
    this.idAsignatura = idAsignatura;
    this.idTema = idTema;
    this.flashcardDAO = new com.dao.FlashcardDAO();
    configurarDiseño();
    cargarFlashcardsDesdeDB();  // Carga desde la base de datos
   
}
    
    // Lista con el contenido de texto de cada flashcard
    private List<String> paragraphs;
    
    // Índice de la flashcard actual que se está mostrando
    private int currentIndex = 0;
    
    // Nombre del tema que se muestra en el encabezado
    private String currentTopic = "Tema de Estudio";
    
    // Carga las flashcards de un tema desde la base de datos
    private void cargarFlashcardsDesdeDB() {
    this.paragraphs = new java.util.ArrayList<>();
    this.flashcardIds = new java.util.ArrayList<>();
    
    // Cargar flashcards usando tu DAO
    List<Flashcards> flashcards = flashcardDAO.listarFlashcards(idTema);
    
    // Si no hay flashcards, pregunta si quiere crear uno
    if (flashcards.isEmpty()) {
        
  
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(this,
            "No hay flashcards para este tema.\n¿Desea crear flashcards automáticamente desde un texto?",
            "Sin Flashcards",
            javax.swing.JOptionPane.YES_NO_OPTION);
        
        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            
            // Se Ejecuta cuando el usuario quiere crear flashcards
            boolean creado = crearFlashcardsDesdeTexto();
            if (!creado) {
                
               // Si el usuario cancela la creacion del flashcard, vuelve al panel anterior
                javax.swing.SwingUtilities.invokeLater(() -> {
                    if (dashboardPadre != null) {
                        volverATemasAsignaturas();
                    }
                });
            }
            return; // 
        } else {
             // si el usuario no quiere crear flashcards, vuelve al menú anterior
            javax.swing.SwingUtilities.invokeLater(() -> {
                if (dashboardPadre != null) {
                    volverATemasAsignaturas();
                }
            });
            return; // Salir del método sin configurar nada más
        }
    }
    
    // Si hay flashcards, las carga en las listas
    for (Flashcards f : flashcards) {
        paragraphs.add(f.getContenido());  // Agrega el texto
        flashcardIds.add(f.getIdFlashcard());  // Agrega el ID
    }
    
    // Configura la apariencia del panel
    lblTema.setText(currentTopic);
    whiteBoard.setLineWrap(true);
    whiteBoard.setWrapStyleWord(true);
    
    actualizarTarjeta();
}

    // Recarga la tabla del dashboard (cuando se crean/eliminan flashcards)
   public void recargarTabla() {
     dashboardPadre.cargarDatosTabla();
}   
   
    // Crea flashcards automáticamente a partir de un texto largo
    private boolean crearFlashcardsDesdeTexto() {
        
    // Crea un área de texto grande para que el usuario ingrese el contenido
    javax.swing.JTextArea textArea = new javax.swing.JTextArea(10, 40);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);
    
    // Muestra un diálogo con el área de texto
    int result = javax.swing.JOptionPane.showConfirmDialog(this,
        scrollPane,
        "Ingrese el texto completo del tema (se dividirá automáticamente):",
        javax.swing.JOptionPane.OK_CANCEL_OPTION,
        javax.swing.JOptionPane.PLAIN_MESSAGE);
    
     // Se ejecuta si el usuario presiona OK
    if (result == javax.swing.JOptionPane.OK_OPTION) {
        String texto = textArea.getText();
        
         // Verifica que se haya ingresado algo
        if (texto != null && !texto.trim().isEmpty()) {
            
             // Mediante FlashcardDAO, crea las flashcards
            boolean exito = flashcardDAO.crearFlashcardsDesdeTexto(idTema, texto);
            
            if (exito) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Flashcards creadas exitosamente",
                    "Éxito",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
                
               // Recarga las flashcards para mostrar las nuevas
                cargarFlashcardsDesdeDB();
                
                // Actualiza la tabla del dashboard
                if (dashboardPadre != null) {
                    dashboardPadre.recargarTabla();
                }
                
                return true;
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al crear las flashcards",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            // Usuario dejó el texto vacío
            return false;
        }
    }
    
    // Usuario canceló (CANCEL o cerró el diálogo)
    return false;
}

// Método auxiliar para volver a TemasAsignaturas
private void volverATemasAsignaturas() {
    TemasAsignaturas temasPanel = new TemasAsignaturas(dashboardPadre, dashboardPadre.getIdUsuario());
    
    javax.swing.JPanel panelPrincipal = dashboardPadre.getPanelPrincipal();
    panelPrincipal.removeAll();
    panelPrincipal.setLayout(new java.awt.BorderLayout());
    panelPrincipal.add(temasPanel, java.awt.BorderLayout.CENTER);
    
    panelPrincipal.revalidate();
    panelPrincipal.repaint();
}
    /**
     * Método generado por NetBeans para inicializar los componentes visuales
     * NO MODIFICAR, Netbeans protege este código
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        encabezado = new javax.swing.JPanel();
        lblTema = new javax.swing.JLabel();
        piePagina = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        lblNumerador = new javax.swing.JLabel();
        Central = new javax.swing.JPanel();
        panelCambios = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        whiteBoard = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(153, 204, 255));
        setLayout(new java.awt.BorderLayout());

        encabezado.setOpaque(false);
        encabezado.setLayout(new java.awt.BorderLayout());

        lblTema.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTema.setForeground(new java.awt.Color(0, 51, 102));
        lblTema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTema.setText("Tema De Estudio");
        encabezado.add(lblTema, java.awt.BorderLayout.CENTER);

        add(encabezado, java.awt.BorderLayout.PAGE_START);

        piePagina.setOpaque(false);
        piePagina.setPreferredSize(new java.awt.Dimension(755, 50));

        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnAnterior.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/Previous_24x24.png"))); // NOI18N
        btnAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/Next_24x24.png"))); // NOI18N
        btnSiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        lblNumerador.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblNumerador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumerador.setText("1/5");
        lblNumerador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout piePaginaLayout = new javax.swing.GroupLayout(piePagina);
        piePagina.setLayout(piePaginaLayout);
        piePaginaLayout.setHorizontalGroup(
            piePaginaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(piePaginaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnVolver)
                .addGap(123, 123, 123)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumerador, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
        );
        piePaginaLayout.setVerticalGroup(
            piePaginaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(piePaginaLayout.createSequentialGroup()
                .addGroup(piePaginaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(piePaginaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNumerador)
                        .addComponent(btnVolver))
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        add(piePagina, java.awt.BorderLayout.PAGE_END);

        Central.setBackground(new java.awt.Color(255, 255, 255));
        Central.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 10, 40));
        Central.setOpaque(false);
        Central.setLayout(new java.awt.BorderLayout());

        panelCambios.setBackground(new java.awt.Color(255, 255, 255));
        panelCambios.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelCambios.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnEditar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/Edit_24x24.png"))); // NOI18N
        btnEditar.setBorder(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panelCambios.add(btnEditar);

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/Delete_24x24.png"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelCambios.add(btnEliminar);

        Central.add(panelCambios, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setEnabled(false);
        jScrollPane1.setWheelScrollingEnabled(false);

        whiteBoard.setEditable(false);
        whiteBoard.setBackground(new java.awt.Color(255, 255, 255));
        whiteBoard.setColumns(20);
        whiteBoard.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        whiteBoard.setLineWrap(true);
        whiteBoard.setRows(9);
        whiteBoard.setWrapStyleWord(true);
        whiteBoard.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 50, 20, 50));
        jScrollPane1.setViewportView(whiteBoard);

        Central.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(Central, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
if (paragraphs == null || paragraphs.isEmpty() || currentIndex >= paragraphs.size()) {
        return; 
    }

    int confirm = javax.swing.JOptionPane.showConfirmDialog(this, 
            "¿Estás seguro de eliminar esta tarjeta?", 
            "Confirmar Eliminación", 
            javax.swing.JOptionPane.YES_NO_OPTION);

    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        // Eliminar de BD si existe DAO
        if (flashcardDAO != null && flashcardIds != null && currentIndex < flashcardIds.size()) {
            int idFlashcard = flashcardIds.get(currentIndex);
            if (flashcardDAO.eliminarFlashcard(idFlashcard)) {
                flashcardIds.remove(currentIndex);
                paragraphs.remove(currentIndex);
                
                if (currentIndex >= paragraphs.size() && currentIndex > 0) {
                    currentIndex--;
                }
                
                javax.swing.JOptionPane.showMessageDialog(this, "Tarjeta eliminada exitosamente");
                
                // Si no quedan flashcards, volver
                if (paragraphs.isEmpty()) {
                    javax.swing.JOptionPane.showMessageDialog(this, "No quedan más flashcards");
                    if (dashboardPadre != null) {
                        dashboardPadre.volverATabla();
                    }
                    return;
                }
                
                actualizarTarjeta();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Modo simulación
            paragraphs.remove(currentIndex);
            if (currentIndex >= paragraphs.size() && currentIndex > 0) {
                currentIndex--;
            }
            javax.swing.JOptionPane.showMessageDialog(this, "Tarjeta eliminada (Simulación)");
            actualizarTarjeta();
        }
    }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
 if (paragraphs == null || paragraphs.isEmpty() || currentIndex >= paragraphs.size()) {
        return;
    }

    String textoActual = paragraphs.get(currentIndex);
    String nuevoTexto = (String) javax.swing.JOptionPane.showInputDialog(
            this, 
            "Edita el contenido de la tarjeta:", 
            "Editar Tarjeta", 
            javax.swing.JOptionPane.PLAIN_MESSAGE, 
            null, 
            null, 
            textoActual);

    if (nuevoTexto != null && !nuevoTexto.trim().isEmpty()) {
        // Actualizar en BD si existe DAO
        if (flashcardDAO != null && flashcardIds != null && currentIndex < flashcardIds.size()) {
            int idFlashcard = flashcardIds.get(currentIndex);
            // Crear método actualizarContenido en FlashcardDAO
            if (flashcardDAO.actualizarFlashcard(idFlashcard, nuevoTexto, "")) {
                paragraphs.set(currentIndex, nuevoTexto);
                javax.swing.JOptionPane.showMessageDialog(this, "Tarjeta actualizada exitosamente");
                actualizarTarjeta();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Modo simulación
            paragraphs.set(currentIndex, nuevoTexto);
            actualizarTarjeta();
        }
    }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
   if (dashboardPadre != null) {
        // Crear el panel de TemasAsignaturas y mostrarlo
        TemasAsignaturas panelTemas = new TemasAsignaturas(dashboardPadre, dashboardPadre.getIdUsuario());
        
        // Obtener el panel principal del Dashboard
        javax.swing.JPanel panelPrincipal = dashboardPadre.getPanelPrincipal();
        
        // Limpiar y agregar el panel de TemasAsignaturas
        panelPrincipal.removeAll();
        panelPrincipal.setLayout(new java.awt.BorderLayout());
        panelPrincipal.add(panelTemas, java.awt.BorderLayout.CENTER);
        
        // Refrescar la vista
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    } else {
        // Si se ejecutó de forma independiente, cerrar ventana
        java.awt.Window win = javax.swing.SwingUtilities.getWindowAncestor(this);
        if (win != null) {
            win.dispose();
        } else {
            System.exit(0);
        }
    }


    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        navigate(-1);
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        navigate(1);
    }//GEN-LAST:event_btnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Central;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel encabezado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumerador;
    private javax.swing.JLabel lblTema;
    private javax.swing.JPanel panelCambios;
    private javax.swing.JPanel piePagina;
    private javax.swing.JTextArea whiteBoard;
    // End of variables declaration//GEN-END:variables


/**
     * Configura el texto y prepara la primera tarjeta.
     */
    private void iniciarLogica() {
        // 1. Texto de prueba (OJO: Aquí NetBeans usará tu clase TextFormatter que creamos antes)
        String fullText = "El aprendizaje cognitivo se basa en cómo el cerebro procesa la información. " +
                "La teoría de la carga cognitiva sugiere que nuestra memoria de trabajo es limitada. " +
                "Por lo tanto, presentar demasiada información a la vez puede abrumar al estudiante. " +
                "Esto es crucial para el diseño instruccional moderno. " +
                "Por ejemplo, el Dr. Smith sugiere dividir el contenido. " + 
                "Los párrafos cortos ayudan a la retención visual. " +
                "El ojo humano se cansa si no encuentra espacios en blanco. " +
                "Una longitud ideal de línea es de 50 a 75 caracteres. " +
                "Esto permite que el ojo salte de una línea a otra sin perderse.";
        
        // 2. Llamamos al TextFormatter (Asegúrate de haber creado la clase TextFormatter.java)
        this.paragraphs = FormateadorTexto.crearParrafosInteligentes(fullText);
        
        // 3. Configuramos la estética inicial en TUS componentes visuales
        lblTema.setText(currentTopic);
        whiteBoard.setLineWrap(true);
        whiteBoard.setWrapStyleWord(true);
        
        // 4. Mostramos la primera tarjeta
        actualizarTarjeta();
    }

   
    private void actualizarTarjeta() {
        int total = paragraphs.size();
        boolean isEnd = (currentIndex >= total);

        if (isEnd) {
            // Pantalla final (Esta la dejamos centrada porque es un título)
            String htmlFin = "<html><body style='font-family:Segoe UI; color:#003366; background-color:#FFFFFF;'>"
                    + "<div style='text-align: center; margin-top: 80px;'>"
                    + "<h1 style='font-size: 40px;'>¡Felicidades!</h1>"
                    + "<h2 style='font-size: 28px; color:#555;'>Fin del tema.</h2>"
                    + "</div></body></html>";
            textoHTML.setText(htmlFin);
            lblNumerador.setText("Fin");
        } else {
            if (!paragraphs.isEmpty()) {
                String rawText = paragraphs.get(currentIndex);
                
                // --- CAMBIO AQUI: text-align: justify ---
                String htmlText = "<html><head><style>"
                        + "body { font-family: 'Segoe UI', sans-serif; font-size: 28px; color: #333333; background-color: #FFFFFF; }"
                        // 'text-align: justify' alinea el texto a izquierda y derecha
                        + "p { text-align: justify; line-height: 1.5; margin-top: 40px; margin-left: 40px; margin-right: 40px; }"
                        + "</style></head><body>"
                        + "<p>" + rawText + "</p>"
                        + "</body></html>";
                
                textoHTML.setText(htmlText);
                textoHTML.setCaretPosition(0);
                lblNumerador.setText((currentIndex + 1) + " / " + total);
            } else {
                textoHTML.setText("");
            }
        }
        
        btnAnterior.setEnabled(currentIndex > 0); 
        btnSiguiente.setEnabled(!isEnd);
    }
    
    // Calcula hacia dónde mover el índice
    private void navigate(int direction) {
        int maxIndex = paragraphs.size();
        int newIndex = currentIndex + direction;

        if (newIndex >= 0 && newIndex <= maxIndex) {
            currentIndex = newIndex;
            actualizarTarjeta();
        }
    }

    public void setTopic(String nombreDelTema) {
    this.currentTopic = nombreDelTema;
    if (lblTema != null) {
        lblTema.setText(nombreDelTema);
    }
}

    private void configurarDiseño() {
        this.removeAll(); // Borramos lo que puso NetBeans
        this.setLayout(new java.awt.BorderLayout());
        this.setBackground(new java.awt.Color(153, 204, 255)); 

        // Encabezado
        if (encabezado == null) encabezado = new javax.swing.JPanel();
        encabezado.removeAll();
        encabezado.setOpaque(false);
        encabezado.setPreferredSize(new java.awt.Dimension(0, 80));
        encabezado.setLayout(new java.awt.GridBagLayout());

        if (lblTema == null) lblTema = new javax.swing.JLabel();
        lblTema.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 32));
        lblTema.setForeground(new java.awt.Color(0, 51, 102));
        lblTema.setText(currentTopic);
        encabezado.add(lblTema);
        this.add(encabezado, java.awt.BorderLayout.NORTH);

        // Centro (tarjeta)
        if (Central == null) Central = new javax.swing.JPanel();
        Central.removeAll();
        Central.setOpaque(false);
        Central.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 80, 20, 80));
        Central.setLayout(new java.awt.BorderLayout());

        // Barra de botones (Editar/Eliminar)
        if (panelCambios == null) panelCambios = new javax.swing.JPanel();
        panelCambios.setBackground(java.awt.Color.WHITE);
        panelCambios.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        
        // Estilo de botones
        btnEditar.setContentAreaFilled(false); btnEditar.setBorder(null);
        btnEliminar.setContentAreaFilled(false); btnEliminar.setBorder(null);
        panelCambios.add(btnEditar);
        panelCambios.add(btnEliminar);
        Central.add(panelCambios, java.awt.BorderLayout.NORTH);

        if (jScrollPane1 == null) jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBorder(null);
        
        textoHTML = new javax.swing.JTextPane();
        textoHTML.setEditable(false);
        textoHTML.setContentType("text/html"); // Activa el motor HTML
        textoHTML.putClientProperty(javax.swing.JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        
        jScrollPane1.setViewportView(textoHTML);
        Central.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        this.add(Central, java.awt.BorderLayout.CENTER);

        // Pie de página
        if (piePagina == null) piePagina = new javax.swing.JPanel();
        piePagina.removeAll();
        piePagina.setOpaque(false);
        piePagina.setPreferredSize(new java.awt.Dimension(0, 80));
        piePagina.setLayout(new java.awt.BorderLayout());
        piePagina.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 50, 0, 50));

        // Botón izquierdo
        btnVolver.setPreferredSize(new java.awt.Dimension(120, 50));
        javax.swing.JPanel pnlIzq = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pnlIzq.setOpaque(false); pnlIzq.add(btnVolver);
        piePagina.add(pnlIzq, java.awt.BorderLayout.WEST);

        // Controles centrales (Navegación)
        javax.swing.JPanel pnlCentro = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 15));
        pnlCentro.setOpaque(false);
        btnAnterior.setPreferredSize(new java.awt.Dimension(60, 50));
        btnSiguiente.setPreferredSize(new java.awt.Dimension(60, 50));
        lblNumerador.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20));
        
        pnlCentro.add(btnAnterior); pnlCentro.add(lblNumerador); pnlCentro.add(btnSiguiente);
        piePagina.add(pnlCentro, java.awt.BorderLayout.CENTER);
        this.add(piePagina, java.awt.BorderLayout.SOUTH);

        // Refresca los cambios visuales
        this.revalidate(); this.repaint();
    }
    
}
