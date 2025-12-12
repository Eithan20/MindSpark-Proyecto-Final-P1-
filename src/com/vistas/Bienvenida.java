
package com.vistas; // Paquete de la capa de Vistas 

import com.vistas.Login; // Importa la vista Login para la navegación
import java.awt.BorderLayout; // Importa el gestor de diseño BorderLayout
import java.awt.Color; // Importa para definir colores RGB/RGBA
import java.awt.Component; // Importa la clase base de componentes GUI
import java.awt.Dimension; // Importa para definir dimensiones de componentes
import java.awt.FlowLayout; // Importa el gestor de diseño FlowLayout
import java.awt.Graphics; // Importa para operaciones de dibujo
import java.awt.Image; // Importa para manejo de imágenes
import javax.swing.BorderFactory; // Importa para crear bordes decorativos
import javax.swing.Box; // Importa para componentes de espaciado
import javax.swing.BoxLayout; // Importa el gestor de diseño BoxLayout
import javax.swing.ImageIcon; // Importa para mostrar imágenes en componentes
import javax.swing.JFrame; // Importa la ventana principal de Swing
import javax.swing.JOptionPane; // Importa para diálogos de confirmación
import javax.swing.JPanel; // Importa el contenedor de componentes

/**
 * Panel de Bienvenida
 * @author eitha
 */
public class Bienvenida extends javax.swing.JPanel {
    // Referencia al MainFrame padre para navegación
    private VentanaPrincipal parentFrame;
    // Logger para registrar eventos del sistema
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Bienvenida.class.getName());    
    // Referencia al Dashboard padre
    private Dashboard dashboardPadre;
    // Imagen de fondo del panel
    private java.awt.Image imagenFondo;
    
    // Constructor que recibe el MainFrame
    public Bienvenida(VentanaPrincipal frame) {
        // Inicializa los componentes visuales
        initComponents();
        // Guarda la referencia al frame padre
        this.parentFrame = frame;
        // Configura el diseño responsivo
        configurarDiseño();
    } 

    // Constructor que recibe el Dashboard
    public Bienvenida(JFrame dashboard) {
        // Inicializa los componentes visuales
        initComponents();
        // Guarda la referencia al dashboard padre
        this.dashboardPadre = (Dashboard) dashboard; 
        // Configura el diseño responsivo
        configurarDiseño();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnSalirPrograma = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (2) (1).png"))); // NOI18N

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1494, Short.MAX_VALUE)
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(755, 395));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(755, 395));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/Logo - MindSpark_pixian_ai (2).png"))); // NOI18N
        jLayeredPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 320, -1));

        btnContinuar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 120, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("BIENVENIDO A MINDSPARK");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLayeredPane1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 520, -1));

        btnSalirPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/Log Out_32x32.png"))); // NOI18N
        btnSalirPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirProgramaActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnSalirPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 40, 40));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/trabajofinal/images/ImagenesTrabajoFinal/download-resizehood.com (2) (1).png"))); // NOI18N
        jLayeredPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 0, 870, 395));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

     // Botón "Continuar" - ir a Login
    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
       
    if (parentFrame != null) {
        Login loginPanel = new Login(parentFrame);
        parentFrame.getContentPane().removeAll();
        parentFrame.getContentPane().add(loginPanel);
        parentFrame.revalidate();
        parentFrame.repaint();
    } else {
        // Si no hay parentFrame, crear uno nuevo
        javax.swing.JFrame frame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            Login loginPanel = new Login(parentFrame);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(loginPanel);
            frame.revalidate();
            frame.repaint();
        }
    }

    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnSalirProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirProgramaActionPerformed
        // Botón de la puerta - Cerrar programa con confirmación
      int respuesta = JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de que quieres cerrar el programa?",
            "Confirmar salida",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        // Si confirma, cierra el programa
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirProgramaActionPerformed
    
    
    // Método para mostrar la vista completa del Dashboard (menú + tabla)
    private void mostrarWelcomeCompleto() {
        // Limpia el panel principal
        jPanel2.removeAll();
        
        // Vuelve a agregar todos los componentes originales
        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jPanel1, java.awt.BorderLayout.PAGE_START);
        jPanel2.add(jPanel2, java.awt.BorderLayout.LINE_START);
        jPanel2.add(jPanel2, java.awt.BorderLayout.CENTER);
        
        // Refresca el panel
        jPanel2.revalidate();
        jPanel2.repaint();
    }
    
    // Configura el diseño para que sea responsivo y carga la imagen de fondo
    private void configurarDiseño() {
        this.setLayout(new BorderLayout());
        
        // Panel con imagen de fondo
        JPanel panelConFondo = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibuja la imagen de fondo escalada al tamaño del panel
                if (jLabel5.getIcon() != null) {
                    ImageIcon icon = (ImageIcon) jLabel5.getIcon();
                    Image img = icon.getImage();
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panelConFondo.setOpaque(true);
        
        // Panel superior - Título
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTitulo.setBackground(new Color(255, 255, 255, 200)); // Semi-transparente
        panelTitulo.add(jPanel1);
        
        // Panel central - Logo y botón
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setOpaque(false); // Transparente para ver el fondo
        
        // Centra los componentes
        jLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnContinuar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnContinuar.setMaximumSize(new Dimension(150, 40));
        
        // Agrega componentes con espaciado
        panelCentral.add(Box.createVerticalGlue());
        panelCentral.add(jLabel2);
        panelCentral.add(Box.createVerticalStrut(40));
        panelCentral.add(btnContinuar);
        panelCentral.add(Box.createVerticalGlue());
        
        // Panel inferior - Botones
        JPanel panelBotones = new JPanel(new BorderLayout());
        panelBotones.setOpaque(false); // Transparente
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        panelBotones.add(btnSalirPrograma, BorderLayout.WEST);
        
        // Ensambla todos los paneles en el panel con fondo
        panelConFondo.add(panelTitulo, BorderLayout.NORTH);
        panelConFondo.add(panelCentral, BorderLayout.CENTER);
        panelConFondo.add(panelBotones, BorderLayout.SOUTH);
        
        // Agrega al panel principal
        this.removeAll();
        this.add(panelConFondo, BorderLayout.CENTER);
        
        // Refresca el panel
        this.revalidate();
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnSalirPrograma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
