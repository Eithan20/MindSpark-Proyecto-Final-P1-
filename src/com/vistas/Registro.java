
package com.vistas; // Paquete de la capa de Vistas

/**
 * Panel de registro de usuarios. Permite crear una nueva cuenta en el sistema.
 * @author eitha
 */
public class Registro extends javax.swing.JPanel {
    // Referencia al panel de Login para poder regresar si se cancela o completa el registro.
    private Login LoginPadre;

    // Constructor vacío (usado por el editor visual)
    public Registro() {
    initComponents();
    txtClave.setText("");  // Limpia el campo de contraseña por seguridad
    this.LoginPadre = null;
    configurarDiseño();
    
    }
   // Constructor principal que recibe la referencia al Login padre
    public Registro(Login Login) {
    initComponents();
    txtClave.setText("");  // Limpia el campo de contraseña por seguridad
    this.LoginPadre = Login;
    configurarDiseño();
}
    /*
     * Método generado automáticamente por NetBeans.
     * NO modificar manualmente.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnregistrarse = new javax.swing.JButton();
        btnatras = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (18).png"))); // NOI18N
        jLabel1.setText("Registro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel2.setText("Correo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel3.setText("Clave");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel4.setText("Usuario");

        txtUsuario.setPreferredSize(new java.awt.Dimension(71, 24));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        btnregistrarse.setText("Registrarse");
        btnregistrarse.setPreferredSize(new java.awt.Dimension(90, 26));
        btnregistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarseActionPerformed(evt);
            }
        });

        btnatras.setText("Volver Atras");
        btnatras.setPreferredSize(new java.awt.Dimension(90, 26));
        btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrasActionPerformed(evt);
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnatras, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219)
                .addComponent(btnregistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(txtCorreo)
                    .addComponent(txtClave))
                .addGap(239, 239, 239))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnregistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnatras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Botón "Volver Atrás"
    private void btnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrasActionPerformed
        {
        // FORMA CORRECTA: Pedirle al MainFrame que muestre el Login
        // Esto asegura que se cargue limpio y maximizado
        if (LoginPadre != null && LoginPadre.getParentFrame() != null) {
            LoginPadre.getParentFrame().mostrarLogin();
        
            }
        }
    }//GEN-LAST:event_btnatrasActionPerformed
   // Campo "Clave"
    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    // Botón "Registrarse"
    private void btnregistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarseActionPerformed
        // Obtiene los datos de los campos
        String usuario = txtUsuario.getText().trim();
        String clave = txtClave.getText().trim();

        // Valida que no haya campos vacíos
        if (usuario.isEmpty() || clave.isEmpty()) { 
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.");
            return;
        }

        try {
            // Crea una instancia del DAO para conectar con la base de datos
            com.dao.UsuarioDAO dao = new com.dao.UsuarioDAO();
            
            // Intenta registrar el usuario en la BD
            boolean exito = dao.registrarUsuario(usuario, clave);

            // Si se registró el usuario correctamente, vuelve al login para iniciar sesión
            if (exito) {
                javax.swing.JOptionPane.showMessageDialog(this, "✅ Registro exitoso. Ahora puede iniciar sesión.");
                
                // Si se registró el usuario correctamente, vuelve al login para iniciar sesión
                if (LoginPadre != null) {
                    if (LoginPadre.getParentFrame() != null) {
                        LoginPadre.getParentFrame().mostrarLogin(); 
                    } else {
                        LoginPadre.volverALogin(); 
                    }
                }
                
                
            } else {
               //Captura de errores como usuario duplicado o fallo de conexión
                javax.swing.JOptionPane.showMessageDialog(this, "❌ No se pudo registrar el usuario.");
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "⚠️ Error al registrar: " + e.getMessage());
        }
    
    }//GEN-LAST:event_btnregistrarseActionPerformed

    // Campo "Correo"
    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    // Campo "Usuario"
    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed
    
    // Reconstruye la interfaz gráfica para centrar los elementos y mejorar la estética.
    private void configurarDiseño() {
        // 1. Limpiar panel principal
        this.removeAll();
        this.setLayout(new java.awt.BorderLayout());
        
        // Encabezado (Azul superior)    
        jPanel2.removeAll(); 
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 120)); 
        jPanel2.setLayout(new java.awt.GridBagLayout());
        
        jLabel1.setForeground(java.awt.Color.WHITE);
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 48)); 
        
        jPanel2.add(jLabel1); 
        this.add(jPanel2, java.awt.BorderLayout.NORTH);
        
        // Cuerpo del Formulario (Centro)
        javax.swing.JPanel panelFondo = new javax.swing.JPanel();
        panelFondo.setBackground(new java.awt.Color(153, 204, 255));
        panelFondo.setLayout(new java.awt.GridBagLayout());

        javax.swing.JPanel panelFormulario = new javax.swing.JPanel();
        panelFormulario.setOpaque(false);
        panelFormulario.setLayout(new java.awt.GridBagLayout());

        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(15, 20, 15, 20); 
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.anchor = java.awt.GridBagConstraints.WEST;

        // Configuración de fuentes
        java.awt.Font fuenteLabel = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 24);
        java.awt.Font fuenteCampo = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18);
        java.awt.Dimension dimCampo = new java.awt.Dimension(350, 45); 

        // Fila Usuario
        gbc.gridx = 0; gbc.gridy = 0;
        jLabel4.setFont(fuenteLabel);
        panelFormulario.add(jLabel4, gbc);
        
        gbc.gridx = 1;
        txtUsuario.setPreferredSize(dimCampo);
        txtUsuario.setFont(fuenteCampo);
        panelFormulario.add(txtUsuario, gbc);

        // Fila Correo
        gbc.gridx = 0; gbc.gridy = 1;
        jLabel2.setFont(fuenteLabel);
        panelFormulario.add(jLabel2, gbc);
        
        gbc.gridx = 1;
        txtCorreo.setPreferredSize(dimCampo);
        txtCorreo.setFont(fuenteCampo);
        panelFormulario.add(txtCorreo, gbc);

        // Fila Clave
        gbc.gridx = 0; gbc.gridy = 2;
        jLabel3.setFont(fuenteLabel);
        panelFormulario.add(jLabel3, gbc);
        
        gbc.gridx = 1;
        txtClave.setPreferredSize(dimCampo);
        txtClave.setFont(fuenteCampo);
        panelFormulario.add(txtClave, gbc);

        // Botones 
        javax.swing.JPanel panelBotones = new javax.swing.JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 0)); 
        
        // Ajuste visual para moverlos ligeramente a la derecha
        panelBotones.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 100, 0, 0));

        java.awt.Dimension dimBoton = new java.awt.Dimension(180, 50); 
        java.awt.Font fuenteBoton = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16);

        btnatras.setPreferredSize(dimBoton);
        btnatras.setFont(fuenteBoton);
        
        btnregistrarse.setPreferredSize(dimBoton);
        btnregistrarse.setFont(fuenteBoton);
        
        panelBotones.add(btnatras);
        panelBotones.add(btnregistrarse);

        // Fila Panel de Botones
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2; 
        gbc.insets = new java.awt.Insets(50, 10, 10, 10); 
        gbc.anchor = java.awt.GridBagConstraints.CENTER;
        
        // Agrega el formulario al panel de fondo
        panelFormulario.add(panelBotones, gbc);

        panelFondo.add(panelFormulario);
        this.add(panelFondo, java.awt.BorderLayout.CENTER);

        // Refresca la interfaz
        this.revalidate();
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnatras;
    private javax.swing.JButton btnregistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
