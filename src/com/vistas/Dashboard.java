
package com.vistas; // Paquete de la capa de Vistas

import java.util.List; // Importa la interfaz List
import java.util.Set; // Importa la interfaz Set para colecciones sin duplicados
import javax.swing.JOptionPane;  // Importa para diálogos de mensaje
import javax.swing.table.DefaultTableModel; // Importa para el modelo de la tabla

/**
 * Ventana principal del sistema (Dashboard)
 * Gestiona el menú lateral, la navegación entre paneles y la visualización de la tabla de asignaturas
 * @author eitha
 */
public class Dashboard extends javax.swing.JFrame {
    
    // Logger para registrar eventos del sistema
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard.class.getName());
    
    // Panel donde se carga el contenido dinámico
    private javax.swing.JPanel panelContenido;
    
    // Referencia al frame principal para poder navegar entre ventanas
    private VentanaPrincipal mainFramePadre; 
     
    // ID del usuario que está usando actualmente el dashboard
    private int idUsuarioActual; 

    // Constructor que inicializa el dashboard
    public Dashboard() {
        // Inicializa los componentes visuales generados
        initComponents();

        // Configuración inicial del layout
        PanelPrincipal.removeAll();
        PanelPrincipal.setLayout(new java.awt.BorderLayout());

        // Configuración del Título Superior
        PanelTitulo.removeAll();
        PanelTitulo.setPreferredSize(new java.awt.Dimension(0, 90));
        PanelTitulo.setLayout(new java.awt.GridBagLayout());
        
        jLabel1.setForeground(java.awt.Color.WHITE);
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 48));
        jLabel1.setText("Dashboard");
        PanelTitulo.add(jLabel1); 
        PanelPrincipal.add(PanelTitulo, java.awt.BorderLayout.NORTH);
        
        // Configuración del Menú Lateral (Izquierda)
        // Se usa GridBagLayout para distribuir los botones de forma responsiva
        PanelMenu.removeAll();
        PanelMenu.setPreferredSize(new java.awt.Dimension(320, 0)); 
        PanelMenu.setLayout(new java.awt.GridBagLayout());

        // Configuración de restricciones para GridBagLayout
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; 
        gbc.weighty = 0;

        // Configuración de tamaño, fuente y color de botones
        java.awt.Dimension btnSize = new java.awt.Dimension(0, 55);
        java.awt.Font btnFont = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14);
        java.awt.Color btnColor = new java.awt.Color(153, 153, 255); 

        // Etiqueta "MENU"
        gbc.insets = new java.awt.Insets(30, 20, 20, 20); 
        jLabel2.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 24));
        jLabel2.setForeground(java.awt.Color.WHITE);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelMenu.add(jLabel2, gbc);

        // Ajusta los márgenes para los botones
        gbc.insets = new java.awt.Insets(10, 15, 10, 15); 
        
        // Botón 1: Agregar Asignatura
        txtcrearasignatura.setPreferredSize(btnSize);
        txtcrearasignatura.setFont(btnFont);
        txtcrearasignatura.setBackground(btnColor);
        txtcrearasignatura.setForeground(java.awt.Color.WHITE);
        txtcrearasignatura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcrearasignatura.setIconTextGap(10);
        PanelMenu.add(txtcrearasignatura, gbc);

        // Botón 2: Ir a Flashcards
        btniraFlashcards.setPreferredSize(btnSize);
        btniraFlashcards.setFont(btnFont);
        btniraFlashcards.setBackground(btnColor);
        btniraFlashcards.setForeground(java.awt.Color.WHITE);
        btniraFlashcards.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btniraFlashcards.setIconTextGap(10);
        PanelMenu.add(btniraFlashcards, gbc);

        // Botón 3: Configuración
        btnConfiguracion.setPreferredSize(btnSize);
        btnConfiguracion.setFont(btnFont);
        btnConfiguracion.setBackground(btnColor);
        btnConfiguracion.setForeground(java.awt.Color.WHITE);
        btnConfiguracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConfiguracion.setIconTextGap(10);
        PanelMenu.add(btnConfiguracion, gbc);

        // Espaciador (Empujador)
        // Este panel invisible ocupa todo el espacio sobrante vertical para empujar "Acerca de" al fondo
        gbc.weighty = 1.0; 
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        javax.swing.JPanel empujador = new javax.swing.JPanel();
        empujador.setOpaque(false);
        PanelMenu.add(empujador, gbc);

        // Botón 4: Acerca de (Al final)
        gbc.weighty = 0;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 15, 30, 15);

        btnAcercade.setText("Acerca de");
        btnAcercade.setPreferredSize(btnSize);
        btnAcercade.setFont(btnFont);
        btnAcercade.setBackground(btnColor); 
        btnAcercade.setForeground(java.awt.Color.WHITE);
        btnAcercade.setBorderPainted(false);
        btnAcercade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAcercade.setIconTextGap(10);
        
        PanelMenu.add(btnAcercade, gbc);

        PanelPrincipal.add(PanelMenu, java.awt.BorderLayout.WEST);

        // Configuración del contenido central (tabla)
        PanelContenido.removeAll();
        PanelContenido.setLayout(new java.awt.BorderLayout());
        PanelContenido.setBackground(new java.awt.Color(220, 220, 220));
        PanelContenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Configuración visual de la tabla
        jTable1.setRowHeight(30);
        jTable1.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        jTable1.getTableHeader().setBackground(new java.awt.Color(200, 200, 200));
        
        PanelContenido.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        PanelPrincipal.add(PanelContenido, java.awt.BorderLayout.CENTER);

        // Configuración del modelo de datos de la tabla
        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {}, 
            new String[]{"ID_Asignatura", "ID_Tema", "Asignatura", "Tema", "Cant. Flashcards"} 
        ) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        jTable1.setModel(model);
        
        // Oculta las columnas de IDs
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(1).setMinWidth(0);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        // Listener para detectar doble click en la tabla
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) { 
                    int fila = jTable1.getSelectedRow();
                    if (fila != -1) { abrirFlashcards(fila); }
                }
            }
        });
        
        // Refresca el panel
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }
    
    // Establece la referencia al MainFrame padre
    public void setMainFrame(VentanaPrincipal mainFrame) {
        this.mainFramePadre = mainFrame;
    }

    // Establece el ID del usuario actual y carga sus datos
    public void setIdUsuario(int idUsuario) {
        this.idUsuarioActual = idUsuario;
        
        // Si hay un ID válido, carga automáticamente la tabla
        if (idUsuario != 0) {
            cargarDatosTabla();
        }
    }

    // Retorna el ID del usuario actual
    public int getIdUsuario() {
        return this.idUsuarioActual;
    }

    // Abre el panel de flashcards cuando se hace doble click en una fila
    private void abrirFlashcards(int fila) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        // Obtiene los datos de la fila seleccionada
        int idAsignatura = (int) model.getValueAt(fila, 0);
        int idTema = (int) model.getValueAt(fila, 1);
        String nombreAsignatura = (String) model.getValueAt(fila, 2);
        String nombreTema = (String) model.getValueAt(fila, 3);
        
        // Crea el panel de flashcards con los IDs correspondientes
        Flashcard panelFlashcards = new Flashcard(this, idAsignatura, idTema);
        panelFlashcards.setTopic(nombreAsignatura + " - " + nombreTema);
        
        // Limpia el panel principal y muestra solo las flashcards
        PanelPrincipal.removeAll();
        PanelPrincipal.setLayout(new java.awt.BorderLayout());
        PanelPrincipal.add(panelFlashcards, java.awt.BorderLayout.CENTER);
        
        // Refresca la vista
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }
    
    // Muestra un selector de asignatura y tema para ir a flashcards específicas
    private void mostrarSelectorAsignaturaTema() {
        
        // Verifica que haya un usuario logueado
        if (idUsuarioActual == 0) {
            JOptionPane.showMessageDialog(this,
                "Error: ID de usuario no configurado",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Obtiene las asignaturas del usuario
        com.dao.AsignaturaDAO asigDAO = new com.dao.AsignaturaDAO();
        List<com.modelo.Asignatura> asignaturas = asigDAO.listarAsignaturas(idUsuarioActual);
        
        // Si no hay asignaturas, muestra un mensaje
        if (asignaturas.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "No hay asignaturas registradas.\nPor favor, crea una asignatura primero.",
                "Sin asignaturas",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Convierte la lista de asignaturas en un array de nombres
        String[] nombresAsignaturas = asignaturas.stream()
            .map(com.modelo.Asignatura::getNombre)
            .toArray(String[]::new);
        
        // Muestra un diálogo para seleccionar asignatura
        String asignaturaSeleccionada = (String) JOptionPane.showInputDialog(
            this,
            "Seleccione una asignatura:",
            "Seleccionar Asignatura",
            JOptionPane.QUESTION_MESSAGE,
            null,
            nombresAsignaturas,
            nombresAsignaturas[0]
        );
        
        if (asignaturaSeleccionada == null) return;
        
        // Busca el ID de la asignatura seleccionada
        int idAsignaturaSeleccionada = 0;
        for (com.modelo.Asignatura a : asignaturas) {
            if (a.getNombre().equals(asignaturaSeleccionada)) {
                idAsignaturaSeleccionada = a.getIdAsignatura();
                break;
            }
        }
        
        // Obtiene los temas de esa asignatura
        com.dao.TemaDAO temaDAO = new com.dao.TemaDAO();
        List<com.modelo.Tema> temas = temaDAO.listarTemasPorAsignatura(idAsignaturaSeleccionada);
        
        // Si no hay temas, muestra un mensaje
        if (temas.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "No hay temas en esta asignatura.\nPor favor, crea un tema primero.",
                "Sin temas",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Convierte la lista de temas en un array de nombres
        String[] nombresTemas = temas.stream()
            .map(com.modelo.Tema::getNombre)
            .toArray(String[]::new);
        
        // Muestra un diálogo para seleccionar tema
        String temaSeleccionado = (String) JOptionPane.showInputDialog(
            this,
            "Seleccione un tema:",
            "Seleccionar Tema",
            JOptionPane.QUESTION_MESSAGE,
            null,
            nombresTemas,
            nombresTemas[0]
        );
        
        if (temaSeleccionado == null) return;
        
        // Busca el ID del tema seleccionado
        int idTemaSeleccionado = 0;
        for (com.modelo.Tema t : temas) {
            if (t.getNombre().equals(temaSeleccionado)) {
                idTemaSeleccionado = t.getIdTema();
                break;
            }
        }
        
        // Crea y muestra el panel de flashcards
        Flashcard panelFlashcards = new Flashcard(this, idAsignaturaSeleccionada, idTemaSeleccionado);
        panelFlashcards.setTopic(asignaturaSeleccionada + " - " + temaSeleccionado);
        
        PanelPrincipal.removeAll();
        PanelPrincipal.setLayout(new java.awt.BorderLayout());
        PanelPrincipal.add(panelFlashcards, java.awt.BorderLayout.CENTER);
        
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }

    // Override del método setVisible para cargar datos al mostrar la ventana
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        
        // Si se está mostrando y hay usuario logueado, carga la tabla
        if (visible && idUsuarioActual != 0) {
            cargarDatosTabla();
        }
    }

    // Carga todos los temas con sus asignaturas y cantidad de flashcards en la tabla
    public void cargarDatosTabla() {
        // Si no hay usuario, no hace nada
        if (idUsuarioActual == 0) return;
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // Limpia la tabla
        model.setRowCount(0);
        
        // Crea instancias de los DAOs necesarios
        com.dao.AsignaturaDAO asigDAO = new com.dao.AsignaturaDAO();
        com.dao.TemaDAO temaDAO = new com.dao.TemaDAO();
        com.dao.FlashcardDAO flashDAO = new com.dao.FlashcardDAO();
        
        // Obtiene todas las asignaturas del usuario
        List<com.modelo.Asignatura> asignaturas = asigDAO.listarAsignaturas(idUsuarioActual);
        
        // Recorre cada asignatura
        for (com.modelo.Asignatura asig : asignaturas) {
            List<com.modelo.Tema> temas = temaDAO.listarTemasPorAsignatura(asig.getIdAsignatura());
            
            // Recorre cada tema de la asignatura
            for (com.modelo.Tema tema : temas) {
                
                // Verifica cuántas flashcards tiene
                int cantFlashcards = flashDAO.listarFlashcards(tema.getIdTema()).size();
                
                // Muestra todos los temas, tengan o no flashcards creadas
                model.addRow(new Object[]{
                    asig.getIdAsignatura(),
                    tema.getIdTema(),
                    asig.getNombre(),
                    tema.getNombre(),
                    cantFlashcards  
                });
            }
        }
    }
    /**
     * Método generado por NetBeans para inicializar los componentes visuales
     * NO MODIFICAR, Netbeans protege este código
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PanelPrincipal = new javax.swing.JPanel();
        PanelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        txtcrearasignatura = new javax.swing.JButton();
        btnConfiguracion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btniraFlashcards = new javax.swing.JButton();
        btnAcercade = new javax.swing.JButton();
        PanelContenido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setLayout(new java.awt.BorderLayout());

        PanelTitulo.setBackground(new java.awt.Color(0, 102, 204));
        PanelTitulo.setPreferredSize(new java.awt.Dimension(1006, 90));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dashboard");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel1)
                .addContainerGap(301, Short.MAX_VALUE))
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelPrincipal.add(PanelTitulo, java.awt.BorderLayout.PAGE_START);

        PanelMenu.setBackground(new java.awt.Color(102, 204, 255));
        PanelMenu.setLayout(new java.awt.GridBagLayout());

        txtcrearasignatura.setBackground(new java.awt.Color(153, 153, 255));
        txtcrearasignatura.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        txtcrearasignatura.setForeground(new java.awt.Color(255, 255, 255));
        txtcrearasignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (9).png"))); // NOI18N
        txtcrearasignatura.setText("Agregar Asignatura");
        txtcrearasignatura.setBorderPainted(false);
        txtcrearasignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcrearasignaturaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 22, 0, 44);
        PanelMenu.add(txtcrearasignatura, gridBagConstraints);

        btnConfiguracion.setBackground(new java.awt.Color(153, 153, 255));
        btnConfiguracion.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        btnConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (10).png"))); // NOI18N
        btnConfiguracion.setText("Configuracion/Perfil");
        btnConfiguracion.setBorderPainted(false);
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 22, 122, 44);
        PanelMenu.add(btnConfiguracion, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (12).png"))); // NOI18N
        jLabel2.setText("Menu");
        PanelMenu.add(jLabel2, new java.awt.GridBagConstraints());

        btniraFlashcards.setBackground(new java.awt.Color(153, 153, 255));
        btniraFlashcards.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btniraFlashcards.setForeground(new java.awt.Color(255, 255, 255));
        btniraFlashcards.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (14).png"))); // NOI18N
        btniraFlashcards.setText("Ir a Flashcard");
        btniraFlashcards.setBorderPainted(false);
        btniraFlashcards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniraFlashcardsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 22, 0, 44);
        PanelMenu.add(btniraFlashcards, gridBagConstraints);

        btnAcercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/Information_32x32.png"))); // NOI18N
        btnAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercadeActionPerformed(evt);
            }
        });
        PanelMenu.add(btnAcercade, new java.awt.GridBagConstraints());

        PanelPrincipal.add(PanelMenu, java.awt.BorderLayout.LINE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout PanelContenidoLayout = new javax.swing.GroupLayout(PanelContenido);
        PanelContenido.setLayout(PanelContenidoLayout);
        PanelContenidoLayout.setHorizontalGroup(
            PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );
        PanelContenidoLayout.setVerticalGroup(
            PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContenidoLayout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelPrincipal.add(PanelContenido, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Evento del botón "Agregar Asignatura"
    private void txtcrearasignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcrearasignaturaActionPerformed
                              
     // Verifica que haya un usuario logueado    
    if (idUsuarioActual == 0) {
        JOptionPane.showMessageDialog(this,
            "Error: ID de usuario no configurado",
            "Error",
            JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Crea el panel para gestionar asignaturas
    CrearAsignatura panelCrear = new CrearAsignatura(this);
    panelCrear.setIdUsuarioActual(idUsuarioActual);
    
    
    // Reemplaza el contenido actual con el panel de asignaturas
    PanelPrincipal.removeAll();
    PanelPrincipal.setLayout(new java.awt.BorderLayout());
    PanelPrincipal.add(panelCrear, java.awt.BorderLayout.CENTER);
    
    PanelPrincipal.revalidate();
    PanelPrincipal.repaint();
    }//GEN-LAST:event_txtcrearasignaturaActionPerformed

    // Evento del botón "Configuracion/Perfil"
    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
        // Abre el panel de configuración
        mostrarConfiguracion();
    }//GEN-LAST:event_btnConfiguracionActionPerformed

     // Evento del botón "Ir a Flashcard"
    private void btniraFlashcardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniraFlashcardsActionPerformed
        // Crea y muestra el panel de temas/asignaturas
        TemasAsignaturas panelTemas = new TemasAsignaturas(this, idUsuarioActual);
    
    PanelPrincipal.removeAll();
    PanelPrincipal.add(panelTemas, java.awt.BorderLayout.CENTER);
    PanelPrincipal.revalidate();
    PanelPrincipal.repaint();

    }//GEN-LAST:event_btniraFlashcardsActionPerformed

    private void btnAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercadeActionPerformed
           // Muestra un popup HTML con información del proyecto
    String mensaje = "<html><body style='width: 450px; font-family: Arial;'>"
            + "<h2 style='color: #000099; text-align: center;'>MindSpark</h2>"
            + "<p style='text-align: center;'><b>Versión 1.0.0</b></p>"
            + "<hr>"
            + "<h3>Descripción:</h3>"
            + "<p>MindSpark es una aplicación orientada a estudiantes para ayudarles"
            + " a gestionar sus apuntes y a estudiar de manera mas efectiva para sus examenes.</p>"
            + "<h3>Manual de Usuario:</h3>"
            + "<ul>"
            + "<li><b>Registro:</b> Crea tu cuenta con usuario, correo y contraseña</li>"
            + "<li><b>Inicio de Sesión:</b> Accede con tus credenciales</li>"
            + "<li><b>Dashboard:</b> Visualiza y gestiona toda la información</li>"
            + "<li><b>Configuración:</b> Cambia tu contraseña cuando lo necesites</li>"
            + "<li><b>Cerrar Sesión:</b> Sal de forma segura del sistema</li>"
            + "</ul>"
            + "<h3>Equipo de Desarrollo:</h3>"
            + "<table style='width: 100%;'>"
            + "<tr><td><b>👑 Sabrina Vargas</b></td><td>Líder de Equipo</td></tr>"
            + "<tr><td><b>💻 Eithan Pérez</b></td><td>Programador</td></tr>"
            + "<tr><td><b>🔍 Wilmer Hernández</b></td><td>QA (Control de Calidad)</td></tr>"
            + "<tr><td><b>🎨 Fausto Junior</b></td><td>Diseñador</td></tr>"
            + "<tr><td><b>🗄️ Leonardo De Jesús</b></td><td>DBA (Administrador de BD)</td></tr>"
            + "</table>"
            + "<hr>"
            + "<p style='text-align: center; font-size: 10px;'>"
            + "© 2025 MindSpark. Todos los derechos reservados.</p>"
            + "</body></html>";
    
    // Mostrar el diálogo con la información
    JOptionPane.showMessageDialog(
            this,
            mensaje,
            "Acerca de MindSpark",
            JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_btnAcercadeActionPerformed
    
   // Restaura la vista completa del dashboard
    private void mostrarDashboardCompleto() {
        
    // Limpia el panel principal
    PanelPrincipal.removeAll();
    
    // Vuelve a agregar todos los componentes originales
    PanelPrincipal.setLayout(new java.awt.BorderLayout());
    PanelPrincipal.add(PanelTitulo, java.awt.BorderLayout.PAGE_START);
    PanelPrincipal.add(PanelMenu, java.awt.BorderLayout.LINE_START);
    PanelPrincipal.add(PanelContenido, java.awt.BorderLayout.CENTER);
    
    // Asegura que la tabla esté en el panel de contenido
    PanelContenido.removeAll();
    PanelContenido.setLayout(new java.awt.BorderLayout());
    PanelContenido.add(jScrollPane1, java.awt.BorderLayout.CENTER);
    
    PanelPrincipal.revalidate();
    PanelPrincipal.repaint();
}
    
    // Muestra la pantalla de bienvenida (cuando se cierra sesión)
    public void mostrarWelcome() {
        
    // Limpia todo el contenido del JFrame
    getContentPane().removeAll();

    // Crea y agrega el panel de bienvenida
    Bienvenida welcomePanel = new Bienvenida(this);
    getContentPane().add(welcomePanel);

    // Refresca la ventana
    revalidate();
    repaint();
}
    
    // Muestra el panel de configuración/perfil
    private void mostrarConfiguracion() {
    // Limpia todo el Dashboard (quita menú, título y tabla)
        PanelPrincipal.removeAll();
        
        // Crea la instancia de la clase NUEVA
        ConfiguracionPerfilPanel panelConfig = new ConfiguracionPerfilPanel(this);
        
        // Pasamos la referencia del MainFrame para poder cerrar sesión o navegar
        panelConfig.setMainFrame(mainFramePadre); 
        
        // Agregamos el panel de configuración ocupando todo el espacio
        PanelPrincipal.setLayout(new java.awt.BorderLayout());
        PanelPrincipal.add(panelConfig, java.awt.BorderLayout.CENTER);
        
        // Refrescamos la pantalla
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    
}
    // Muestra el panel de flashcards (sin asignatura/tema específico)
    private void mostrarFlashcards() {
            
    // Crea el panel de flashcards
    Flashcard panelFlashcards = new Flashcard(this);
   
    // Limpia el panel principal y muestra solo las flashcards
    PanelPrincipal.removeAll();
    PanelPrincipal.setLayout(new java.awt.BorderLayout());
    PanelPrincipal.add(panelFlashcards, java.awt.BorderLayout.CENTER);
    
    // Refrescar la vista
    PanelPrincipal.revalidate();
    PanelPrincipal.repaint();
}

    // Método público para volver al dashboard desde otros paneles
    public void volverATabla() {
    mostrarDashboardCompleto();
    cargarDatosTabla(); // // Recarga la tabla en caso de que haya cambios
}

    // Método público para recargar solo la tabla sin cambiar la vista
    public void recargarTabla() {
    cargarDatosTabla();
}
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContenido;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btnAcercade;
    private javax.swing.JButton btnConfiguracion;
    private javax.swing.JButton btniraFlashcards;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton txtcrearasignatura;
    // End of variables declaration//GEN-END:variables

    // Retorna el panel principal 
    public javax.swing.JPanel getPanelPrincipal() {
        return PanelPrincipal;
        }

    }

