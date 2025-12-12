
package com.vistas;

import com.dao.AsignaturaDAO;  // Importa el DAO para operaciones de Asignatura
import com.dao.FlashcardDAO; // Importa el DAO para operaciones de Flashcard
import com.dao.TemaDAO;  // Importa el DAO para operaciones de Tema
import com.modelo.Tema; // Importa el modelo Tema
import com.modelo.Asignatura; // Importa el modelo Asignatura
import java.awt.*;      // Importa herramientas de diseño gráfico
import java.awt.event.*; // Importa manejo de eventos (clics, teclado, etc.)   
import java.util.List; // Importa la interfaz List para colecciones ordenadas
import java.util.Map;  // Importa la interfaz Map para pares clave-valor
import javax.swing.*; // Importa componentes visuales de Swing
import javax.swing.border.EmptyBorder; // Importa para crear márgenes vacíos



// Panel que muestra asignaturas y sus temas asociados
public class TemasAsignaturas extends javax.swing.JPanel {
    
    // Asignatura seleccionada actualmente
    private com.modelo.Asignatura asignaturaActual;
    // ID del usuario en sesión
    private int idUsuarioActual;
    // DAOs para acceso a datos
    private AsignaturaDAO asignaturaDAO;
    private TemaDAO temaDAO;
    private FlashcardDAO flashcardDAO;
    // Referencia al Dashboard padre para navegación
    private Dashboard dashboardPadre;

    // Constructor que inicializa el panel con datos del usuario
    public TemasAsignaturas(Dashboard dashboard, int idUsuario) {
        // Inicializa componentes visuales generados
        initComponents();
        // Guarda referencia al dashboard padre
        this.dashboardPadre = dashboard;
        // Guarda ID del usuario actual
        this.idUsuarioActual = idUsuario;
        // Inicializa los DAOs para acceso a base de datos
        this.asignaturaDAO = new AsignaturaDAO();
        this.temaDAO = new TemaDAO();
        this.flashcardDAO = new FlashcardDAO();
        // Configura el diseño responsivo del panel
        configurarDiseño();
        // Carga los botones de asignaturas del usuario
        cargarBotonesAsignaturas();
        
        // Establece colores de fondo de los paneles
        if (insideAsignatura != null) insideAsignatura.setBackground(new Color(102, 153, 255)); 
        if (panelTemas != null) panelTemas.setBackground(new Color(153, 204, 255));
        
        // Carga nuevamente los botones
        cargarBotonesAsignaturas();
    }

    
    /**
     * Método generado por NetBeans para inicializar los componentes visuales
     * NO MODIFICAR, Netbeans protege este código
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAsignaturas = new javax.swing.JScrollPane();
        insideAsignatura = new javax.swing.JPanel();
        Asignaturas = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20));
        jPanel1 = new javax.swing.JPanel();
        lblTituloAsignatura = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelTemas = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 204, 255));
        setLayout(new java.awt.BorderLayout());

        panelAsignaturas.setBackground(new java.awt.Color(153, 204, 255));
        panelAsignaturas.setBorder(null);
        panelAsignaturas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelAsignaturas.setPreferredSize(new java.awt.Dimension(200, 0));

        insideAsignatura.setBackground(new java.awt.Color(102, 153, 255));
        insideAsignatura.setLayout(new javax.swing.BoxLayout(insideAsignatura, javax.swing.BoxLayout.Y_AXIS));

        Asignaturas.setBackground(new java.awt.Color(0, 51, 102));
        Asignaturas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Asignaturas.setForeground(new java.awt.Color(255, 255, 255));
        Asignaturas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Asignaturas.setText("ASIGNATURAS");
        Asignaturas.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        Asignaturas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        Asignaturas.setMaximumSize(new java.awt.Dimension(200, 45));
        Asignaturas.setMinimumSize(new java.awt.Dimension(200, 45));
        Asignaturas.setOpaque(true);
        Asignaturas.setPreferredSize(new java.awt.Dimension(200, 40));
        insideAsignatura.add(Asignaturas);
        insideAsignatura.add(filler1);

        panelAsignaturas.setViewportView(insideAsignatura);

        add(panelAsignaturas, java.awt.BorderLayout.LINE_START);

        jPanel1.setOpaque(false);

        lblTituloAsignatura.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTituloAsignatura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloAsignatura.setText("Seleccione una asignatura");

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        panelTemas.setBackground(new java.awt.Color(153, 204, 255));
        panelTemas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jScrollPane1.setViewportView(panelTemas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloAsignatura, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloAsignatura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Asignaturas;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel insideAsignatura;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTituloAsignatura;
    private javax.swing.JScrollPane panelAsignaturas;
    private javax.swing.JPanel panelTemas;
    // End of variables declaration//GEN-END:variables

    
    

   // Carga dinámicamente los botones de asignaturas del usuario
    private void cargarBotonesAsignaturas() {
        // Limpia el panel de asignaturas
        insideAsignatura.removeAll();

        // Crea el encabezado de la barra lateral
        javax.swing.JPanel headerPanel = new javax.swing.JPanel(new java.awt.BorderLayout());
        headerPanel.setBackground(new java.awt.Color(0, 40, 90));
        headerPanel.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 80));
        headerPanel.setPreferredSize(new java.awt.Dimension(320, 80));
        
        // Etiqueta del encabezado
        javax.swing.JLabel lblHeader = new javax.swing.JLabel("ASIGNATURAS");
        lblHeader.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 24)); 
        lblHeader.setForeground(java.awt.Color.WHITE);
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        // Borde inferior blanco semitransparente como separador
        headerPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255, 100)));
        
        headerPanel.add(lblHeader, java.awt.BorderLayout.CENTER);
        
        insideAsignatura.add(headerPanel);
        // Espacio debajo del título
        insideAsignatura.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 20))); 

        // Obtiene y crea botones para cada asignatura
        java.util.List<Asignatura> asignaturas = asignaturaDAO.listarAsignaturas(idUsuarioActual);
        
        for (Asignatura asig : asignaturas) {
            // Crea botón moderno para cada asignatura
            ModernButton btn = new ModernButton(asig.getNombre());
            btn.addActionListener(e -> mostrarTemasDe(asig));
            
            // Panel contenedor para centrar el botón
            javax.swing.JPanel btnWrapper = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
            btnWrapper.setOpaque(false);
            btnWrapper.add(btn);
            btnWrapper.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 70));
            
            insideAsignatura.add(btnWrapper);
        }
        
        // Empuja el botón de volver hacia abajo
        insideAsignatura.add(javax.swing.Box.createVerticalGlue());

        // Crea botón "Volver" en la parte inferior
        javax.swing.JButton btnVolver = new javax.swing.JButton("← Volver");
        btnVolver.setPreferredSize(new java.awt.Dimension(200, 50));
        btnVolver.setBackground(new java.awt.Color(220, 53, 69));
        btnVolver.setForeground(java.awt.Color.WHITE);
        btnVolver.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        btnVolver.setFocusPainted(false);
        
        // Al hacer clic, regresa a la tabla principal del dashboard
        btnVolver.addActionListener(e -> {
            if (dashboardPadre != null) dashboardPadre.volverATabla();
        });

        // Contenedor para centrar el botón volver
        javax.swing.JPanel volverWrapper = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        volverWrapper.setOpaque(false);
        volverWrapper.add(btnVolver);
        volverWrapper.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 100));
        
        insideAsignatura.add(volverWrapper);
        
        // Refresca el panel
        insideAsignatura.revalidate();
        insideAsignatura.repaint();
    }
 // Muestra los temas de una asignatura seleccionada
    private void mostrarTemasDe(Asignatura asignatura) {
        // Guarda la asignatura actual
        this.asignaturaActual = asignatura;
        // Actualiza el título con el nombre de la asignatura
        if(lblTituloAsignatura != null) lblTituloAsignatura.setText(asignatura.getNombre());
        
        // Limpia el panel de temas
        panelTemas.removeAll();

        // Obtiene la lista de temas de la asignatura
        java.util.List<Tema> temas = temaDAO.listarTemasPorAsignatura(asignatura.getIdAsignatura());
        
        // Crea una tarjeta para cada tema
        for (Tema tema : temas) {
            // Cuenta cuántas flashcards tiene el tema
            int cantidad = flashcardDAO.listarFlashcards(tema.getIdTema()).size();
            panelTemas.add(crearBotonTemaInteligente(tema, cantidad));
        }

        // Botón para crear nuevo tema
        javax.swing.JButton btnAdd = new javax.swing.JButton("<html><center><font size='7'>+</font><br>Nuevo Tema</center></html>");
        btnAdd.setPreferredSize(new java.awt.Dimension(240, 160));
        btnAdd.setBackground(new java.awt.Color(220, 255, 220)); 
        btnAdd.setForeground(new java.awt.Color(0, 100, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20));
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setBorder(javax.swing.BorderFactory.createDashedBorder(new java.awt.Color(0, 150, 0), 3, 5, 5, true));
        btnAdd.setFocusPainted(false);
        
        btnAdd.addActionListener(e -> crearNuevoTema());
        
        panelTemas.add(btnAdd);

        // Refresca el panel
        panelTemas.revalidate();
        panelTemas.repaint();
    }


       // Crea un botón estilizado para representar un tema
    private javax.swing.JButton crearBotonTemaInteligente(Tema tema, int cantidadCards) {
        // Crea HTML para mostrar nombre del tema y cantidad de tarjetas
        String htmlText = "<html><center>"
                + "<font size='6' color='#003366'><b>" + tema.getNombre() + "</b></font><br><br>"
                + "<font size='5' color='#666666'>" + cantidadCards + " tarjetas</font>"
                + "</center></html>";

        javax.swing.JButton btn = new javax.swing.JButton(htmlText);
        // Establece tamaño grande para las tarjetas
        btn.setPreferredSize(new java.awt.Dimension(240, 160));
        btn.setBackground(java.awt.Color.WHITE);
        btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn.setFocusPainted(false);
        btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        // Borde con padding interno
        btn.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 180, 180), 2),
            javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        // Al hacer clic, abre las flashcards del tema
        btn.addActionListener(e -> abrirFlashcards(tema));

        // Menú contextual (click derecho) para editar/eliminar
        javax.swing.JPopupMenu menu = new javax.swing.JPopupMenu();
        javax.swing.JMenuItem itemEditar = new javax.swing.JMenuItem("Editar");
        itemEditar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16));
        itemEditar.addActionListener(e -> logicaEditarTema(tema));
        
        javax.swing.JMenuItem itemEliminar = new javax.swing.JMenuItem("Eliminar");
        itemEliminar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16));
        itemEliminar.addActionListener(e -> logicaEliminarTema(tema));
        
        menu.add(itemEditar);
        menu.add(itemEliminar);
        btn.setComponentPopupMenu(menu);

        // Efecto visual al pasar el mouse
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) { 
                btn.setBackground(new java.awt.Color(240, 248, 255));
                btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 3));
            }
            public void mouseExited(java.awt.event.MouseEvent e) { 
                btn.setBackground(java.awt.Color.WHITE);
                btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 180, 180), 2));
            }
        });

        return btn;
    }

   // Abre el panel de flashcards para un tema específico
    private void abrirFlashcards(Tema tema) {
        // Crea el panel de flashcards
        Flashcard panel = new Flashcard(dashboardPadre, asignaturaActual.getIdAsignatura(), tema.getIdTema());
        // Establece el título del topic
        panel.setTopic(asignaturaActual.getNombre() + " - " + tema.getNombre()); 
        
        // Reemplaza el contenido del panel principal del dashboard
        JPanel panelPrincipal = dashboardPadre.getPanelPrincipal();
        panelPrincipal.removeAll();
        panelPrincipal.add(panel, BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

  
    // Permite editar el nombre de un tema
    private void logicaEditarTema(Tema tema) {
        // Muestra diálogo para ingresar nuevo nombre
        String nuevo = JOptionPane.showInputDialog(this, "Renombrar:", tema.getNombre());
        if (nuevo != null && !nuevo.isEmpty()) {
            // Actualiza el tema en base de datos
            temaDAO.actualizarTema(tema.getIdTema(), nuevo);
            // Refresca la vista de temas
            mostrarTemasDe(asignaturaActual);
        }
    
}
    // Crea un nuevo tema para la asignatura actual
    private void crearNuevoTema() {
        // Solicita nombre del nuevo tema
        String nombre = JOptionPane.showInputDialog(this, "Nombre del nuevo tema:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            // Intenta agregar el tema a la base de datos
            boolean exito = temaDAO.agregarTema(asignaturaActual.getIdAsignatura(), nombre.trim());
            if (exito) {
                JOptionPane.showMessageDialog(this, "Tema creado exitosamente");
                // Refresca la vista de temas
                mostrarTemasDe(asignaturaActual);
                // Recarga la tabla del dashboard
                if (dashboardPadre != null) {
                    dashboardPadre.recargarTabla();
                }
            }
        }
    }
    
    
     // Elimina un tema después de confirmar con el usuario
    private void logicaEliminarTema(Tema tema) {
        // Solicita confirmación al usuario
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar '" + tema.getNombre() + "'?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Elimina el tema de la base de datos
            temaDAO.eliminarTema(tema.getIdTema());
            // Refresca la vista de temas
            mostrarTemasDe(asignaturaActual);
            // Recarga la tabla del dashboard
            if (dashboardPadre != null) {
                dashboardPadre.recargarTabla();
            }
        }
    }
    
    // Clase interna que representa un botón moderno estilizado
    class ModernButton extends javax.swing.JButton {
        // Constructor que crea un botón con estilo moderno
        public ModernButton(String text) {
            super(text);
            // Configura la fuente grande
            setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
            setOpaque(true);
            setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            
            // Colores del botón
            setBackground(new java.awt.Color(240, 240, 240)); 
            setForeground(new java.awt.Color(50, 50, 50));
            
            // Tamaño del botón
            setPreferredSize(new java.awt.Dimension(280, 55)); 
            
            // Borde con padding
            setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200), 1),
                javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15)
            ));
            
            // Efecto hover (cambio visual al pasar el mouse)
            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent e) { 
                    setBackground(new java.awt.Color(255, 255, 255));
                    setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 2));
                }
                public void mouseExited(java.awt.event.MouseEvent e) { 
                    setBackground(new java.awt.Color(240, 240, 240));
                    setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200), 1));
                }
            });
        }
    }
    
    // Configura el diseño responsivo del panel completo
    private void configurarDiseño() {
        // Limpieza total del panel
        this.removeAll();
        this.setLayout(new java.awt.BorderLayout());
        this.setBackground(new java.awt.Color(153, 204, 255));

        // Panel izquierdo (asignaturas) - ancho 320px
        panelAsignaturas = new javax.swing.JScrollPane();
        insideAsignatura = new javax.swing.JPanel();

        // Configuración del scroll izquierdo
        panelAsignaturas.setBorder(null);
        panelAsignaturas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelAsignaturas.setPreferredSize(new java.awt.Dimension(320, 0));

        // Panel interno con lista vertical de botones
        insideAsignatura.setBackground(new java.awt.Color(102, 153, 255));
        insideAsignatura.setLayout(new javax.swing.BoxLayout(insideAsignatura, javax.swing.BoxLayout.Y_AXIS));
        
        panelAsignaturas.setViewportView(insideAsignatura);
        
        // Agrega a la izquierda
        this.add(panelAsignaturas, java.awt.BorderLayout.LINE_START);

        // Panel derecho (temas)
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        // Título superior
        lblTituloAsignatura = new javax.swing.JLabel();
        lblTituloAsignatura.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));
        lblTituloAsignatura.setForeground(java.awt.Color.WHITE);
        lblTituloAsignatura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloAsignatura.setText("Seleccione una asignatura");
        // Margen superior e inferior
        lblTituloAsignatura.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        jPanel1.add(lblTituloAsignatura, java.awt.BorderLayout.NORTH);

        // Área de tarjetas de temas
        jScrollPane1 = new javax.swing.JScrollPane();
        panelTemas = new javax.swing.JPanel();

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        panelTemas.setBackground(new java.awt.Color(153, 204, 255));
        // Layout fluido con separación de 30px
        panelTemas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 30)); 
        panelTemas.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        jScrollPane1.setViewportView(panelTemas);
        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        // Agrega al centro
        this.add(jPanel1, java.awt.BorderLayout.CENTER);

        // Refresca el panel
        this.revalidate();
        this.repaint();
    }
}