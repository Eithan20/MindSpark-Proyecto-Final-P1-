
package com.vistas; // Paquete de la capa de Vistas

import com.dao.UsuarioDAO; // Importa el DAO para operaciones de Usuario en base de datos
import java.awt.BorderLayout; // Importa el gestor de diseño BorderLayout
import java.awt.Color; // Importa para definir colores RGB/RGBA
import java.awt.Component; // Importa la clase base de componentes GUI
import java.awt.Dimension; // Importa para definir dimensiones de componentes
import java.awt.FlowLayout; // Importa el gestor de diseño FlowLayout
import java.awt.Font; // Importa para configurar fuentes de texto
import java.awt.GridBagConstraints; // Importa para restricciones de GridBagLayout
import java.awt.GridBagLayout; // Importa el gestor de diseño GridBagLayout
import java.awt.Insets; // Importa para definir márgenes internos
import javax.swing.BorderFactory; // Importa para crear bordes decorativos
import javax.swing.Box; // Importa para componentes de espaciado
import javax.swing.BoxLayout; // Importa el gestor de diseño BoxLayout
import javax.swing.JOptionPane; // Importa para diálogos de mensaje
import javax.swing.JPanel; // Importa el contenedor de componentes

/**
 * Panel de inicio de sesión del sistema MindSpark
 * Permite a los usuarios autenticarse para acceder al dashboard principal
 * 
 * @author eitha
 */
public class Login extends javax.swing.JPanel {
   
    // Referencia al frame principal para cambiar paneles
    private VentanaPrincipal parentFrame, mainFrame; 
    
    // DAO para gestionar operaciones con usuarios en la base de datos
    private UsuarioDAO usuarioDAO;
   
   // Constructor vacío (usado por el diseñador visual)
    public Login() {
        initComponents();
        this.parentFrame = null;
    }
    
    // Constructor principal que recibe el frame padre
    public Login(VentanaPrincipal frame) {
    initComponents();
    this.parentFrame = frame;
    
    // Limpia el campo de contraseña por seguridad
     txtClave.setText("");
     
    usuarioDAO = new UsuarioDAO(); // Inicializa el DAO
    configurarDiseño(); // Aplica el diseño personalizado
}
    
   // Retorna la referencia al frame padre
   public VentanaPrincipal getParentFrame() {
        return this.parentFrame; 
    }
   
   
   /**
     * Método generado automáticamente por NetBeans.
     * NO modificar manualmente.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnRegis = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();

        setPreferredSize(new java.awt.Dimension(755, 395));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(422, 126));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/User_48x48.png"))); // NOI18N
        jLabel1.setText("Login");

        btnAtras.setBackground(new java.awt.Color(102, 153, 255));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (17).png"))); // NOI18N
        btnAtras.setBorderPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Ingrese su informacion");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnAtras)
                .addGap(205, 205, 205)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(342, 342, 342))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtras)
                    .addComponent(jLabel1))
                .addGap(96, 96, 96)
                .addComponent(jLabel2))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Usuario");

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Clave");

        jLabel5.setFont(new java.awt.Font("Arial", 2, 15)); // NOI18N
        jLabel5.setText("Aun no tienes una cuenta?");

        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/iniciar-sesion (1).png"))); // NOI18N
        btnIniciar.setText("Iniciar Sesion");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnRegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (27).png"))); // NOI18N
        btnRegis.setText("Registrate");
        btnRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisActionPerformed(evt);
            }
        });

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnRegis)
                        .addGap(77, 77, 77)
                        .addComponent(btnIniciar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(btnRegis))
                .addGap(0, 68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Botón "Iniciar Sesión"
    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
  String usuario = txtUsuario.getText().trim();
    String clave = new String(txtClave.getPassword()).trim();

    // Validación de campos vacíos
    if (usuario.isEmpty() || clave.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor complete todos los campos");
        return;
    }

    try {
        // Valida las credenciales con el DAO
        if (usuarioDAO.validarUsuario(usuario, clave)) {
            // Obtiene el ID del usuario para cargar sus datos
            int idUsuario = usuarioDAO.obtenerIdUsuario(usuario, clave);
            
            if (idUsuario == 0) {
                JOptionPane.showMessageDialog(this, 
                    "Error: No se pudo obtener el ID del usuario",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
            
            // Navega al Dashboard pasándole el ID
            if (parentFrame != null) {
                parentFrame.mostrarDashboard(idUsuario);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }

    } catch (java.sql.SQLException e) {
        JOptionPane.showMessageDialog(this, 
            "Error SQL:\n" + e.getMessage(), 
            "Error SQL", 
            JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Ocurrió un error inesperado:\n" + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_btnIniciarActionPerformed
    
    // Muestra el panel de Registro ocupando toda la pantalla
    private void mostrarRegistroo() {
    Registro panelRegistro = new Registro(this); // Pasa referencia de Login para volver

    this.removeAll(); 
    this.setLayout(new java.awt.BorderLayout()); 
    this.add(panelRegistro, java.awt.BorderLayout.CENTER);

    this.revalidate();
    this.repaint();
}   
    // Vuelve a la pantalla de Bienvenida
    private void mostrarWelcome() {
    if (parentFrame != null) {
        parentFrame.mostrarBienvenida();
    } else {
        JOptionPane.showMessageDialog(this, "Error: no se encontró el JFrame padre", "Error", JOptionPane.ERROR_MESSAGE);
    
}

}
    // Botón "Registrate" - Cambia al panel de registro
    private void btnRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisActionPerformed
        mostrarRegistroo();
    }//GEN-LAST:event_btnRegisActionPerformed

    // Botón "Atrás" - Vuelve a la pantalla de bienvenida
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
    mostrarWelcome();
    }//GEN-LAST:event_btnAtrasActionPerformed

    // Campo Usuario
    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    // Campo Clave
    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed
    
    
   // Restaura la vista del Login (se llama desde Registro al cancelar/terminar)
    public void volverALogin() {
    this.removeAll(); 
    initComponents(); 
    this.revalidate();
    this.repaint();
}
    
    private void configurarDiseño() {
      this.setLayout(new BorderLayout());
        
        
        // Encabezado
        jPanel2.setLayout(new BorderLayout());
        jPanel2.setPreferredSize(new Dimension(0, 120));
        jPanel2.setBackground(new Color(102, 153, 255));

        // Panel Izquierdo (Botón Atrás)
        JPanel panelAtras = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 35));
        panelAtras.setOpaque(false);
        panelAtras.setPreferredSize(new Dimension(150, 100)); // Ancho fijo
        btnAtras.setContentAreaFilled(false);
        btnAtras.setBorderPainted(false);
        panelAtras.add(btnAtras);

        // Panel Derecho (Fantasma para equilibrar el centro)
        JPanel panelFantasma = new JPanel();
        panelFantasma.setOpaque(false);
        panelFantasma.setPreferredSize(new Dimension(150, 100)); // Mismo ancho que izquierda

        // Panel Central (Título "Login")
        JPanel panelTitulo = new JPanel(new GridBagLayout());
        panelTitulo.setOpaque(false);
        jLabel1.setFont(new Font("Arial", Font.BOLD, 48));
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelTitulo.add(jLabel1);

        jPanel2.removeAll();
        jPanel2.add(panelAtras, BorderLayout.WEST);
        jPanel2.add(panelTitulo, BorderLayout.CENTER);
        jPanel2.add(panelFantasma, BorderLayout.EAST);

        // Formulario (Cuerpo)
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        panelFormulario.setBackground(new Color(153, 204, 255));
        
        // Centrado vertical
        panelFormulario.add(Box.createVerticalGlue());
        
        // Subtítulo
        jLabel2.setFont(new Font("Arial", Font.BOLD, 24));
        jLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelFormulario.add(jLabel2);
        
        panelFormulario.add(Box.createVerticalStrut(30)); 
        
        // Bloque de Campos (GridBagLayout para alineación precisa)
        JPanel panelCampos = new JPanel(new GridBagLayout());
        panelCampos.setOpaque(false);
        panelCampos.setMaximumSize(new Dimension(500, 120)); // Limita el ancho máximo
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Solo 5px de separación entre elementos
        
        // Estilos
        Font fontLabels = new Font("Segoe UI", Font.BOLD, 20);
        Font fontFields = new Font("Segoe UI", Font.PLAIN, 18);
        Dimension dimCampos = new Dimension(250, 40);

        // Campo Usuario
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST; // Etiqueta a la derecha
        jLabel3.setFont(fontLabels);
        panelCampos.add(jLabel3, gbc);

        gbc.gridx = 1; 
        gbc.anchor = GridBagConstraints.WEST; // Campo a la izquierda
        txtUsuario.setPreferredSize(dimCampos);
        txtUsuario.setFont(fontFields);
        panelCampos.add(txtUsuario, gbc);

        // Campo Clave
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        jLabel4.setFont(fontLabels);
        panelCampos.add(jLabel4, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtClave.setPreferredSize(dimCampos);
        txtClave.setFont(fontFields);
        panelCampos.add(txtClave, gbc);

      
        panelFormulario.add(panelCampos);
        
      

        panelFormulario.add(Box.createVerticalStrut(30)); 

        // Texto "¿Aún no tienes cuenta?"
        jLabel5.setFont(new Font("Arial", Font.ITALIC, 16));
        jLabel5.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelFormulario.add(jLabel5);

        panelFormulario.add(Box.createVerticalStrut(15)); 

        // Botones
        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
        pnlBotones.setOpaque(false);
        
        Dimension btnDim = new Dimension(160, 45);
        btnRegis.setPreferredSize(btnDim);
        btnRegis.setFont(new Font("Arial", Font.BOLD, 16));
        
        btnIniciar.setPreferredSize(btnDim);
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 16));
        
        pnlBotones.add(btnRegis);
        pnlBotones.add(btnIniciar);
        panelFormulario.add(pnlBotones);
        
        panelFormulario.add(Box.createVerticalGlue());
        
        this.removeAll();
        this.add(jPanel2, BorderLayout.NORTH);
        this.add(panelFormulario, BorderLayout.CENTER);
        
        this.revalidate();
        this.repaint();
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnRegis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
