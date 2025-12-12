
package com.vistas; // Paquete de la capa de Vistas

/**
 * Panel de configuración de perfil. Permite cambiar la contraseña y cerrar sesión.
 * @author eitha
 */
public class ConfiguracionPerfilPanel extends javax.swing.JPanel {
    
    // --- Referencias para navegación ---
    
   // Referencia al Dashboard
    private Dashboard dashboardPadre;
    
    // Referencia al MainFrame (ventana principal) para cambiar paneles
    private VentanaPrincipal mainFramePadre;
    
   // --- Constructores ---

   // Constructor 1: Llamado desde el Dashboard
    public ConfiguracionPerfilPanel(Dashboard dashboard) {
    initComponents();
    
    // Limpia los campos de texto por seguridad
    Txtclaveactual.setText("");
    Txtnuevaclave.setText("");
    txtconfirmarclave.setText("");
    
    this.dashboardPadre = dashboard; // Guarda la referencia al dashboard
    configurarDiseño();
}
   // Constructor 2: Llamado desde el MainFrame directamente
    public ConfiguracionPerfilPanel(VentanaPrincipal mainFrame) {
    initComponents();
    Txtclaveactual.setText("");
    Txtnuevaclave.setText("");
    txtconfirmarclave.setText("");
    
    this.mainFramePadre = mainFrame;
    configurarDiseño();
}
    // Constructor vacío para que NetBeans pueda diseñar el formulario visualmente
    public ConfiguracionPerfilPanel() {
    initComponents(); 
    Txtclaveactual.setText("");
    Txtnuevaclave.setText("");
    txtconfirmarclave.setText("");
    configurarDiseño();
    }

   // Método setter para asignar el MainFrame después de crear el objeto
    public void setMainFrame(VentanaPrincipal mainFrame) {
    this.mainFramePadre = mainFrame;
}

/**
     * Método generado automáticamente por NetBeans para crear los componentes visuales
     * NO modificar manualmente - el editor visual regenera este código
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Txtusuario = new javax.swing.JTextField();
        btncerrarsesion = new javax.swing.JButton();
        btnvolveratras = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Txtclaveactual = new javax.swing.JPasswordField();
        Txtnuevaclave = new javax.swing.JPasswordField();
        txtconfirmarclave = new javax.swing.JPasswordField();

        setPreferredSize(new java.awt.Dimension(755, 399));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (18).png"))); // NOI18N
        lbl1.setText("Configuración ");
        jPanel2.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Clave Actual");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Nueva Clave");

        Txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtusuarioActionPerformed(evt);
            }
        });

        btncerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/Log Out_24x24.png"))); // NOI18N
        btncerrarsesion.setText("Cerrar Sesion");
        btncerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarsesionActionPerformed(evt);
            }
        });

        btnvolveratras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/Previous_24x24.png"))); // NOI18N
        btnvolveratras.setText("Volver Atras");
        btnvolveratras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolveratrasActionPerformed(evt);
            }
        });

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (10).png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Confirmar Clave");

        Txtclaveactual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtclaveactualActionPerformed(evt);
            }
        });

        txtconfirmarclave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconfirmarclaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnvolveratras, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncerrarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txtclaveactual, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txtnuevaclave, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtconfirmarclave, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Txtclaveactual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(Txtnuevaclave, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtconfirmarclave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnvolveratras, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncerrarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // --- Eventos de Botones ---
    
    // Maneja el clic en el botón "Volver Atrás"
    private void btnvolveratrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolveratrasActionPerformed
   
       // Pregunta al usuario si está seguro de salir sin guardar
    int respuesta = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "¿Estás seguro de que deseas volver al Dashboard?",
        "Confirmar acción",
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.QUESTION_MESSAGE
    );

    // Si el usuario confirma que sí quiere volver, regresa al dashboard
    if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
        if (dashboardPadre != null) {
            dashboardPadre.volverATabla();      
}        
      }

    }//GEN-LAST:event_btnvolveratrasActionPerformed

    // Maneja el clic en el botón "Guardar" para cambiar la contraseña
    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
    // Obtiene los datos de los campos
    String usuario = Txtusuario.getText().trim();
    String claveActual = String.valueOf(Txtclaveactual.getPassword()).trim();
    String nuevaClave = String.valueOf(Txtnuevaclave.getPassword()).trim();
    
    // Valida que todos los campos tengan contenido
    if (usuario.isEmpty() || claveActual.isEmpty() || nuevaClave.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "⚠️ Por favor, complete todos los campos antes de guardar.");
        return;
    }
    
    
    try {
        com.dao.UsuarioDAO dao = new com.dao.UsuarioDAO();

        // Verifica si la contraseña actual es correcta en la BD
        if (!dao.verificarContrasenaActual(usuario, claveActual)) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "❌ La contraseña actual no es correcta.");
            return;
        }

        // Si la contraseña actual es correcta, actualiza a la nueva
        boolean actualizado = dao.actualizarContrasena(usuario, nuevaClave);

        if (actualizado) {
            // Si se actualizó correctamente, muestra mensaje de éxito
            javax.swing.JOptionPane.showMessageDialog(this,
                "✅ Contraseña actualizada correctamente.\nPor favor, inicie sesión nuevamente.");

            // Cierra la sesión actual
            com.controlador.SesionActual.cerrarSesion();

            // Redirige al login para que entre con la nueva contraseña
            if (mainFramePadre != null) {
                mainFramePadre.mostrarLogin();
                
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "⚠️ No se pudo redirigir al inicio de sesión.",
                    "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // Si no se actualizó, el usuario probablemente no existe
            javax.swing.JOptionPane.showMessageDialog(this,
                "❌ No se pudo actualizar la contraseña (usuario no encontrado).");
        }

    } catch (java.sql.SQLException e) {
            // Captura errores relacionados con la base de datos
        javax.swing.JOptionPane.showMessageDialog(this,
            "⚠️ Error SQL:\n" + e.getMessage(),
            "Error de Base de Datos", javax.swing.JOptionPane.ERROR_MESSAGE);

        
    } catch (Exception e) {
            // Captura cualquier otro error inesperado
        javax.swing.JOptionPane.showMessageDialog(this,
            "❌ Ocurrió un error inesperado:\n" + e.getMessage(),
            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnguardarActionPerformed

     // Maneja el clic en el botón "Cerrar Sesión"
    private void btncerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarsesionActionPerformed
        
        // Muestra un diálogo de confirmación antes de cerrar sesión
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "¿Seguro que deseas cerrar sesión?",
        "Confirmar cierre de sesión",
        javax.swing.JOptionPane.YES_NO_OPTION
    );
        
    // Si confirma que quiere cerrar sesión   
    if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
    javax.swing.JOptionPane.showMessageDialog(this, "✅ Sesión cerrada correctamente.");
    
    // Redirige a la pantalla de bienvenida
    if (mainFramePadre != null) {
        mainFramePadre.mostrarBienvenida(); // Vuelve al menú principal    
   
            }
        }
  }
    

    // Método que sobrescribe el diseño por defecto de NetBeans para hacerlo más bonito y centrado
    private void configurarDiseño() {
        // Limpia el panel
        this.removeAll();
        this.setLayout(new java.awt.BorderLayout());
        
        
// --- ENCABEZADO (Norte) ---
        jPanel2.removeAll(); 
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 120)); 
        jPanel2.setLayout(new java.awt.BorderLayout()); // Usamos BorderLayout para centrar fácil
        
       // Configura el título y el icono
        lbl1.setText("Configuración");
        lbl1.setForeground(java.awt.Color.WHITE);
        lbl1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 48)); // Letra Gigante
        
        
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        // Carga segura de la imagen (icono)
        try {
            java.net.URL imgUrl = getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (18).png");
            if (imgUrl != null) {
                lbl1.setIcon(new javax.swing.ImageIcon(imgUrl));
                // Separación entre icono y texto
                lbl1.setIconTextGap(20); 
            }
        } catch (Exception e) {
            // Si falla la imagen, no pasa nada, solo muestra texto
        }
        
        // Agregamos la etiqueta al CENTRO del panel azul
        jPanel2.add(lbl1, java.awt.BorderLayout.CENTER); 
        
        this.add(jPanel2, java.awt.BorderLayout.NORTH);

        // --- FORMULARIO (Centro) ---
        javax.swing.JPanel panelFondo = new javax.swing.JPanel();
        panelFondo.setBackground(new java.awt.Color(153, 204, 255)); 
        panelFondo.setLayout(new java.awt.GridBagLayout()); // GridBag para centrar el bloque completo

        javax.swing.JPanel panelFormulario = new javax.swing.JPanel();
        panelFormulario.setOpaque(false); 
        panelFormulario.setLayout(new java.awt.GridBagLayout()); // GridBag interno para alinear campos

        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(15, 20, 15, 20); 
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; 
        gbc.anchor = java.awt.GridBagConstraints.WEST; 

        // --- FUENTES Y TAMAÑOS ---
        java.awt.Font fuenteLabel = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 24);
        java.awt.Font fuenteCampo = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18);
        java.awt.Dimension dimCampo = new java.awt.Dimension(350, 45); // Campos grandes

       // Agregar campos al formulario (Etiqueta + Campo)
        // Fila 1: Usuario
        gbc.gridx = 0; gbc.gridy = 0;
        jLabel1.setFont(fuenteLabel); 
        panelFormulario.add(jLabel1, gbc);
        
        gbc.gridx = 1;
        Txtusuario.setPreferredSize(dimCampo);
        Txtusuario.setFont(fuenteCampo);
        panelFormulario.add(Txtusuario, gbc);

        // Fila 2: Clave Actual
        gbc.gridx = 0; gbc.gridy = 1;
        jLabel2.setFont(fuenteLabel); 
        panelFormulario.add(jLabel2, gbc);
        
        gbc.gridx = 1;
        Txtclaveactual.setPreferredSize(dimCampo);
        Txtclaveactual.setFont(fuenteCampo);
        panelFormulario.add(Txtclaveactual, gbc);

        // Fila 3: Nueva Clave
        gbc.gridx = 0; gbc.gridy = 2;
        jLabel3.setFont(fuenteLabel); 
        panelFormulario.add(jLabel3, gbc);
        
        gbc.gridx = 1;
        Txtnuevaclave.setPreferredSize(dimCampo);
        Txtnuevaclave.setFont(fuenteCampo);
        panelFormulario.add(Txtnuevaclave, gbc);

        // Fila 4: Confirmar Clave
        gbc.gridx = 0; gbc.gridy = 3;
        jLabel4.setFont(fuenteLabel); 
        panelFormulario.add(jLabel4, gbc);
        
        gbc.gridx = 1;
        txtconfirmarclave.setPreferredSize(dimCampo);
        txtconfirmarclave.setFont(fuenteCampo);
        panelFormulario.add(txtconfirmarclave, gbc);

         // --- BOTONES ---
        javax.swing.JPanel panelBotones = new javax.swing.JPanel();
        panelBotones.setOpaque(false);
        
        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 0)); 
        
        java.awt.Dimension dimBoton = new java.awt.Dimension(180, 50); // Botones anchos
        java.awt.Font fuenteBoton = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16);
        
        // Estilo de botones
        btnvolveratras.setPreferredSize(dimBoton);
        btnvolveratras.setFont(fuenteBoton);
        
        btnguardar.setPreferredSize(dimBoton);
        btnguardar.setFont(fuenteBoton);
        
        btncerrarsesion.setPreferredSize(dimBoton);
        btncerrarsesion.setFont(fuenteBoton);
        
        panelBotones.add(btnvolveratras);
        panelBotones.add(btnguardar);
        panelBotones.add(btncerrarsesion);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2; // Ocupar todo el ancho
        gbc.insets = new java.awt.Insets(50, 10, 10, 10); // Mucho espacio arriba de los botones
        gbc.anchor = java.awt.GridBagConstraints.CENTER;
        
        panelFormulario.add(panelBotones, gbc);

        // Agregar todo al fondo
        panelFondo.add(panelFormulario);
        this.add(panelFondo, java.awt.BorderLayout.CENTER);

        // Refrescar
        this.revalidate();
        this.repaint();
    
    
    }//GEN-LAST:event_btncerrarsesionActionPerformed

    private void TxtclaveactualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtclaveactualActionPerformed
     
    }//GEN-LAST:event_TxtclaveactualActionPerformed

    private void txtconfirmarclaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconfirmarclaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconfirmarclaveActionPerformed

    private void TxtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtusuarioActionPerformed

    
    
    
    
    // Declaración de variables de los componentes visuales (generado por NetBeans)
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Txtclaveactual;
    private javax.swing.JPasswordField Txtnuevaclave;
    private javax.swing.JTextField Txtusuario;
    private javax.swing.JButton btncerrarsesion;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnvolveratras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JPasswordField txtconfirmarclave;
    // End of variables declaration//GEN-END:variables
}
