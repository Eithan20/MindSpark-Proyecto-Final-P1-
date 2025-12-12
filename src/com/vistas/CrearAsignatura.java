
package com.vistas; // Paquete de la capa de Vistas

import com.dao.AsignaturaDAO; // Importa el DAO para operaciones de Asignatura
import com.modelo.Asignatura; // Importa el modelo Asignatura
import java.util.List;  // Importa la interfaz List
import javax.swing.JOptionPane; // Importa para diálogos de mensaje
import javax.swing.table.DefaultTableModel; //Importa para el modelo de la tabla

/**
 * Panel para gestionar asignaturas (crear, listar, modificar, eliminar)
 * @author eitha
 * 
 */
public class CrearAsignatura extends javax.swing.JPanel {
    // Referencia al Dashboard padre para navegación
    private Dashboard dashboardPadre;

    // Objeto DAO para interactuar con la base de datos
    private AsignaturaDAO asignaturaDAO;
     
    // ID del usuario logueado actualmente
    private int idUsuarioActual;
     
    // Modelo de datos para manejar la tabla visualmente
    private DefaultTableModel modeloTabla;
    
    // Constructor que inicializa el panel
    public CrearAsignatura(Dashboard dashboard) {
        // Inicializa los componentes visuales
        initComponents();
        // Guarda la referencia al dashboard
        this.dashboardPadre = dashboard;
        // Crea el objeto para acceder a la BD
        this.asignaturaDAO = new AsignaturaDAO();
        // Configura la tabla con sus columnas
        inicializarTabla();
        // Aplica correcciones visuales personalizadas
        configurarDiseño();
    }
    
    // Establece el ID del usuario actual
    public void setIdUsuarioActual(int id) {
        this.idUsuarioActual = id;
    }
    
    // Método para regresar al dashboard principal
    public void volverADashboard() {
        if (dashboardPadre != null) {
            dashboardPadre.volverATabla();
        }
    }

    // Configura el modelo de la tabla (columnas y restricciones)
    private void inicializarTabla() {
        
        // Crea un modelo con 2 columnas: ID (oculto) y Nombre
        modeloTabla = new DefaultTableModel(
            new Object[]{"ID", "Asignaturas"}, 0  
        ) {
            // Deshabilita la edición directa de celdas
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        RegistroAsig.setModel(modeloTabla);
        
        // Oculta la columna del ID (columna 0)
        RegistroAsig.getColumnModel().getColumn(0).setMinWidth(0);
        RegistroAsig.getColumnModel().getColumn(0).setMaxWidth(0);
        RegistroAsig.getColumnModel().getColumn(0).setWidth(0);
        RegistroAsig.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    // Carga todas las asignaturas del usuario desde la base de datos
    private void cargarAsignaturas() {
        
        // Verifica que haya un usuario logueado    
        if (idUsuarioActual == 0) {
            JOptionPane.showMessageDialog(this,
                "Error: ID de usuario no configurado",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Limpia la tabla antes de cargar
        modeloTabla.setRowCount(0);
        
        // Obtiene las asignaturas del usuario desde la BD
        List<Asignatura> asignaturas = asignaturaDAO.listarAsignaturas(idUsuarioActual);
        
        // Agrega cada asignatura a la tabla
        for (Asignatura a : asignaturas) {
            modeloTabla.addRow(new Object[]{
                a.getIdAsignatura(),
                a.getNombre()
            });
        }
            
        // Si no hay asignaturas, muestra un mensaje informativo
        if (asignaturas.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "No hay asignaturas registradas",
                "Sin registros",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Busca asignaturas por nombre (filtro)    
    private void buscarAsignatura() {
        
        // Verifica que haya un usuario logueado
        if (idUsuarioActual == 0) {
            JOptionPane.showMessageDialog(this,
                "Error: ID de usuario no configurado",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Pide al usuario que ingrese el nombre a buscar
        String nombreBuscado = JOptionPane.showInputDialog(this,
            "Ingrese el nombre de la asignatura a buscar:",
            "Buscar Asignatura",
            JOptionPane.QUESTION_MESSAGE);
        
        // Si el usuario canceló o no ingresó nada, sale
        if (nombreBuscado == null || nombreBuscado.trim().isEmpty()) {
            return;
        }
        
        // Limpia la tabla antes de mostrar resultados
        modeloTabla.setRowCount(0);
        
        // Obtiene todas las asignaturas del usuario
        List<Asignatura> todasAsignaturas = asignaturaDAO.listarAsignaturas(idUsuarioActual);
        
        // Variable para contar cuántas coincidencias encuentra
        int coincidencias = 0;
        
        // Convierte el texto de búsqueda a minúsculas para búsqueda insensible a mayúsculas
        String busquedaLower = nombreBuscado.toLowerCase();
        
        // Filtra las asignaturas que contengan el texto buscado
        for (Asignatura a : todasAsignaturas) {
            // Compara ignorando mayúsculas/minúsculas
            if (a.getNombre().toLowerCase().contains(busquedaLower)) {
                // Agrega la asignatura encontrada a la tabla
                modeloTabla.addRow(new Object[]{
                    a.getIdAsignatura(),
                    a.getNombre()
                });
                coincidencias++;
            }
        }
        
        // Reporte de resultados
        if (coincidencias == 0) {
            JOptionPane.showMessageDialog(this,
                "No se encontraron asignaturas que coincidan con: \"" + nombreBuscado + "\"",
                "Sin resultados",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                "Se encontraron " + coincidencias + " asignatura(s) que coinciden con la búsqueda",
                "Resultados de búsqueda",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // Crea una nueva asignatura con el nombre ingresado en el campo de texto
    private void crearAsignatura() {
        String nombre = txtAsignatura.getText().trim();
        
        // Valida que no esté vacío
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor ingrese el nombre de la asignatura",
                "Campo vacío",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Intenta agregar la asignatura a la BD
        boolean exito = asignaturaDAO.agregarAsignatura(idUsuarioActual, nombre);
        
        if (exito) {
            JOptionPane.showMessageDialog(this,
                "Asignatura creada exitosamente",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
            // Limpia el campo de texto
            txtAsignatura.setText("");
            
        } else {
            JOptionPane.showMessageDialog(this,
                "Error al crear la asignatura",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Modifica el nombre de la asignatura seleccionada en la tabla
    private void modificarAsignatura() {
        // Obtiene la fila que está seleccionada
        int filaSeleccionada = RegistroAsig.getSelectedRow();
        
        // Verifica que se haya seleccionado una fila
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione una asignatura de la tabla",
                "Sin selección",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Obtiene el ID y nombre actual de la asignatura seleccionada
        int idAsignatura = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
        String nombreActual = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
        
        // Muestra un diálogo para que el usuario ingrese el nuevo nombre
        String nuevoNombre = JOptionPane.showInputDialog(this,
            "Ingrese el nuevo nombre:",
            nombreActual);
        
        // Actualiza si el usuario modificó y no canceló
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                
            // Intenta actualizar en la BD
            boolean exito = asignaturaDAO.actualizarAsignatura(idAsignatura, nuevoNombre.trim());
            
            if (exito) {
                JOptionPane.showMessageDialog(this,
                    "Asignatura actualizada exitosamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
                // Refresca la tabla para mostrar el cambio
                cargarAsignaturas();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Error al actualizar la asignatura",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Elimina la asignatura seleccionada de la tabla
    private void eliminarAsignatura() {
        
        // Obtiene la fila seleccionada
        int filaSeleccionada = RegistroAsig.getSelectedRow();
        
        // Verifica que se haya seleccionado una fila
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione una asignatura de la tabla",
                "Sin selección",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Obtiene el ID y nombre de la asignatura a eliminar
        int idAsignatura = (int) modeloTabla.getValueAt(filaSeleccionada, 0); 
        String nombre = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
        
        // Pide confirmación antes de eliminar
        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar la asignatura '" + nombre + "'?\n" +
            "Esta acción eliminará también todos los temas y flashcards asociados.",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        // Si el usuario confirma la eliminación
        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean exito = asignaturaDAO.eliminarAsignatura(idAsignatura);
            
            if (exito) {
                JOptionPane.showMessageDialog(this,
                    "Asignatura eliminada exitosamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
                // Refresca la tabla
                cargarAsignaturas();
                
            } else {
                JOptionPane.showMessageDialog(this,
                    "Error al eliminar la asignatura",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Método que corrige y mejora el diseño generado por NetBeans
    private void configurarDiseño() {
        // Limpia el panel
        PanelPrincipal.removeAll();
        PanelPrincipal.setLayout(new java.awt.BorderLayout());

        // Encabezado (Norte)
        PanelTitulo.removeAll();
        PanelTitulo.setPreferredSize(new java.awt.Dimension(0, 90));
        PanelTitulo.setLayout(new java.awt.BorderLayout());

        // Panel Izquierdo (Botón Volver)
        javax.swing.JPanel pnlIzquierda = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 25));
        pnlIzquierda.setOpaque(false);
        btnVolverAtras.setContentAreaFilled(false);
        btnVolverAtras.setBorderPainted(false);
        pnlIzquierda.add(btnVolverAtras);
        PanelTitulo.add(pnlIzquierda, java.awt.BorderLayout.WEST);

        // Panel Central (Título)
        jLabel1.setForeground(java.awt.Color.WHITE);
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 30));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTitulo.add(jLabel1, java.awt.BorderLayout.CENTER);

        // Panel Derecho (Botón Buscar)
        javax.swing.JPanel pnlDerecha = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 20, 25));
        pnlDerecha.setOpaque(false);
        btnbuscar.setContentAreaFilled(false);
        btnbuscar.setBorderPainted(false);
        pnlDerecha.add(btnbuscar);
        PanelTitulo.add(pnlDerecha, java.awt.BorderLayout.EAST);

        PanelPrincipal.add(PanelTitulo, java.awt.BorderLayout.NORTH);

        // Menú lateral
        PanelMenu.removeAll();
        PanelMenu.setPreferredSize(new java.awt.Dimension(320, 0));
        PanelMenu.setLayout(new java.awt.GridBagLayout());

        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(2, 20, 2, 20);

        // Componentes del formulario
        jLabel2.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        PanelMenu.add(jLabel2, gbc);

        txtAsignatura.setPreferredSize(new java.awt.Dimension(0, 40));
        PanelMenu.add(txtAsignatura, gbc);

        PanelMenu.add(javax.swing.Box.createVerticalStrut(5), gbc);

        // Botón Crear
        btnCrearAsig.setBackground(new java.awt.Color(204, 255, 204));
        btnCrearAsig.setPreferredSize(new java.awt.Dimension(0, 50));
        btnCrearAsig.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        PanelMenu.add(btnCrearAsig, gbc);

        PanelMenu.add(javax.swing.Box.createVerticalStrut(40), gbc);

        // Botones Modificar / Listar
        btnModificarAsig.setPreferredSize(new java.awt.Dimension(0, 50));
        btnModificarAsig.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
        PanelMenu.add(btnModificarAsig, gbc);

        PanelMenu.add(javax.swing.Box.createVerticalStrut(10), gbc);

        btnListarAsig.setPreferredSize(new java.awt.Dimension(0, 50));
        btnListarAsig.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
        PanelMenu.add(btnListarAsig, gbc);

        PanelMenu.add(javax.swing.Box.createVerticalStrut(40), gbc);

        // Botón Eliminar
        btnEliminarAsig.setBackground(new java.awt.Color(255, 204, 204));
        btnEliminarAsig.setPreferredSize(new java.awt.Dimension(0, 50));
        btnEliminarAsig.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        PanelMenu.add(btnEliminarAsig, gbc);

        // Empujador para llenar espacio vacío
        gbc.weighty = 1.0;
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        javax.swing.JPanel empujador = new javax.swing.JPanel();
        empujador.setOpaque(false);
        PanelMenu.add(empujador, gbc);

        PanelPrincipal.add(PanelMenu, java.awt.BorderLayout.WEST);
        
        // Tabla (Centro)
        PanelContenido.removeAll();
        PanelContenido.setLayout(new java.awt.BorderLayout());
        PanelContenido.setBackground(new java.awt.Color(153, 204, 255));
        PanelContenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));

        Scrollpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 180, 180)));
        Scrollpanel.getViewport().setBackground(java.awt.Color.WHITE); 

        // Renderizador para estilos de tabla (colores alternos)
        RegistroAsig.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? java.awt.Color.WHITE : new java.awt.Color(235, 235, 235));
                    c.setForeground(java.awt.Color.BLACK); 
                } else {
                    c.setBackground(table.getSelectionBackground());
                    c.setForeground(table.getSelectionForeground()); 
                }
                return c;
            }
        });

        RegistroAsig.setRowHeight(25);
        RegistroAsig.setFillsViewportHeight(true);
        RegistroAsig.getTableHeader().setBackground(new java.awt.Color(220, 220, 220));
        RegistroAsig.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));

        PanelContenido.add(Scrollpanel, java.awt.BorderLayout.CENTER);
        PanelPrincipal.add(PanelContenido, java.awt.BorderLayout.CENTER);

        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }
    
/**
     * Método generado por NetBeans para inicializar componentes visuales
     * NO MODIFICAR - El editor visual regenera este código
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        PanelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btnVolverAtras = new javax.swing.JButton();
        PanelMenu = new javax.swing.JPanel();
        btnModificarAsig = new javax.swing.JButton();
        btnEliminarAsig = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtAsignatura = new javax.swing.JTextField();
        btnCrearAsig = new javax.swing.JButton();
        btnListarAsig = new javax.swing.JButton();
        PanelContenido = new javax.swing.JPanel();
        Scrollpanel = new javax.swing.JScrollPane();
        RegistroAsig = new javax.swing.JTable();

        PanelPrincipal.setBackground(new java.awt.Color(153, 204, 255));
        PanelPrincipal.setLayout(new java.awt.BorderLayout());

        PanelTitulo.setBackground(new java.awt.Color(102, 153, 255));
        PanelTitulo.setPreferredSize(new java.awt.Dimension(662, 90));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (25).png"))); // NOI18N
        jLabel1.setText("Crear Asignatura");

        btnbuscar.setBackground(new java.awt.Color(102, 153, 255));
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (28).png"))); // NOI18N
        btnbuscar.setBorderPainted(false);
        btnbuscar.setContentAreaFilled(false);
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnVolverAtras.setBackground(new java.awt.Color(102, 153, 255));
        btnVolverAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (29).png"))); // NOI18N
        btnVolverAtras.setBorderPainted(false);
        btnVolverAtras.setContentAreaFilled(false);
        btnVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTituloLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnVolverAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(134, 134, 134)
                .addComponent(btnbuscar)
                .addGap(37, 37, 37))
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnVolverAtras)
                        .addGroup(PanelTituloLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(btnbuscar))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        PanelPrincipal.add(PanelTitulo, java.awt.BorderLayout.PAGE_START);

        PanelMenu.setBackground(new java.awt.Color(153, 204, 255));
        PanelMenu.setPreferredSize(new java.awt.Dimension(425, 232));

        btnModificarAsig.setBackground(new java.awt.Color(153, 153, 255));
        btnModificarAsig.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnModificarAsig.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarAsig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (14)_1.png"))); // NOI18N
        btnModificarAsig.setText("Modificar");
        btnModificarAsig.setBorderPainted(false);
        btnModificarAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAsigActionPerformed(evt);
            }
        });

        btnEliminarAsig.setBackground(new java.awt.Color(153, 153, 255));
        btnEliminarAsig.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminarAsig.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarAsig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (8).png"))); // NOI18N
        btnEliminarAsig.setText("Eliminar");
        btnEliminarAsig.setBorderPainted(false);
        btnEliminarAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAsigActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nombre Asignatura:");

        txtAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAsignaturaActionPerformed(evt);
            }
        });

        btnCrearAsig.setText("Crear");
        btnCrearAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAsigActionPerformed(evt);
            }
        });

        btnListarAsig.setBackground(new java.awt.Color(153, 153, 255));
        btnListarAsig.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnListarAsig.setForeground(new java.awt.Color(255, 255, 255));
        btnListarAsig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (27).png"))); // NOI18N
        btnListarAsig.setText("Listar");
        btnListarAsig.setBorderPainted(false);
        btnListarAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAsigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificarAsig, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(btnListarAsig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAsignatura)
                            .addComponent(jLabel2))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                        .addComponent(btnEliminarAsig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrearAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnListarAsig))
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnModificarAsig)))
                .addGap(32, 32, 32)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearAsig)
                    .addComponent(btnEliminarAsig))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        PanelPrincipal.add(PanelMenu, java.awt.BorderLayout.LINE_START);

        RegistroAsig.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Asignaturas"
            }
        ));
        Scrollpanel.setViewportView(RegistroAsig);

        javax.swing.GroupLayout PanelContenidoLayout = new javax.swing.GroupLayout(PanelContenido);
        PanelContenido.setLayout(PanelContenidoLayout);
        PanelContenidoLayout.setHorizontalGroup(
            PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Scrollpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );
        PanelContenidoLayout.setVerticalGroup(
            PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Scrollpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );

        PanelPrincipal.add(PanelContenido, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Evento del botón "Volver Atrás"
    private void btnVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAtrasActionPerformed
       
   // Pide confirmación antes de volver
    int respuesta = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "¿Estás seguro de que deseas volver al Dashboard?",
        "Confirmar acción",
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.QUESTION_MESSAGE
    );

    // Si el usuario confirma que quiere volver, regresa al dashboard
  if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
    if (dashboardPadre != null) {
        dashboardPadre.volverATabla(); 
    }
}
    }//GEN-LAST:event_btnVolverAtrasActionPerformed

    // Evento del botón "Crear", crea una nueva asignatura
    private void btnCrearAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAsigActionPerformed
            crearAsignatura();                                       
    }//GEN-LAST:event_btnCrearAsigActionPerformed

    // Evento del botón "Listar", carga las asignaturas en la tabla
    private void btnListarAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAsigActionPerformed
            cargarAsignaturas();    }//GEN-LAST:event_btnListarAsigActionPerformed

    // Evento del botón "Modificar", actualiza una asignatura existente
    private void btnModificarAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAsigActionPerformed
            modificarAsignatura();
    }//GEN-LAST:event_btnModificarAsigActionPerformed

    // Evento del botón "Eliminar", borra una asignatura
    private void btnEliminarAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAsigActionPerformed
         eliminarAsignatura();
    }//GEN-LAST:event_btnEliminarAsigActionPerformed

    private void txtAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAsignaturaActionPerformed

    }//GEN-LAST:event_txtAsignaturaActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
     buscarAsignatura();
    }//GEN-LAST:event_btnbuscarActionPerformed
    
    
    // Declaración de variables de componentes visuales (generado por NetBeans)
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContenido;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JTable RegistroAsig;
    private javax.swing.JScrollPane Scrollpanel;
    private javax.swing.JButton btnCrearAsig;
    private javax.swing.JButton btnEliminarAsig;
    private javax.swing.JButton btnListarAsig;
    private javax.swing.JButton btnModificarAsig;
    private javax.swing.JButton btnVolverAtras;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtAsignatura;
    // End of variables declaration//GEN-END:variables
}
