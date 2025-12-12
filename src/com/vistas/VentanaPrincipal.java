
package com.vistas;  // Paquete de la capa de Vistas

/**
 * Ventana principal (Contenedor raíz) de la aplicación.
 * Se encarga de gestionar la navegación y mostrar los diferentes paneles (Login, Dashboard, etc.).
 * @author eitha
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    // Logger para registrar errores en la consola (útil para depuración)
     private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());
     
    // Referencias a los paneles principales
    private Login login;
    private Dashboard dashboard;
    
   // Constructor
   public VentanaPrincipal() {
        //Configuración de Pantalla Completa
        // Quita los bordes, título y botones de cerrar/minimizar
        this.setUndecorated(true);
       
       
        initComponents(); // Carga componentes base de NetBeans
        
        
        this.setTitle("MindSpark - Sistema de Flashcards");
        
        
       // Maximiza la ventana para ocupar toda la pantalla
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
        // Define que al cerrar la ventana, el programa termine
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Define el layout principal como BorderLayout para que los paneles ocupen todo el centro
        this.getContentPane().setLayout(new java.awt.BorderLayout());

        // Carga el panel inicial (Bienvenida)
        Bienvenida welcomePanel = new Bienvenida(this);
        this.getContentPane().add(welcomePanel, java.awt.BorderLayout.CENTER);

        // Refresca la ventana para asegurar que se dibuje bien
        this.revalidate();
        this.repaint();
    }
    
   

   // Muestra la pantalla de bienvenida (usado al iniciar o cerrar sesión)
    public void mostrarBienvenida() {
        getContentPane().removeAll(); // Limpia la ventana
        Bienvenida welcome = new Bienvenida(this);
        getContentPane().add(welcome, java.awt.BorderLayout.CENTER);
        
        // Refresca la interfaz
        revalidate();
        repaint();
    }
    
    // Muestra el Dashboard principal después del Login
    public void mostrarDashboard(int idUsuario) {
        getContentPane().removeAll();
        
        Dashboard dashboard = new Dashboard();
        dashboard.setIdUsuario(idUsuario); // Pasa el ID del usuario logueado
        dashboard.setMainFrame(this);
        
        // Carga los datos iniciales en la tabla del dashboard
        dashboard.cargarDatosTabla();
        
       // Agrega el panel del dashboard (obtenido mediante su getter) al centro
        getContentPane().add(dashboard.getPanelPrincipal(), java.awt.BorderLayout.CENTER);
        
        
        revalidate();
        repaint();
    }
    
    // Muestra el panel de configuración de perfil
    public void mostrarConfiguracion() {
        getContentPane().removeAll();
        ConfiguracionPerfilPanel configPanel = new ConfiguracionPerfilPanel(this);
        getContentPane().add(configPanel, java.awt.BorderLayout.CENTER);
        
        // Sin setSize
        revalidate();
        repaint();
    }

    // Muestra el panel de Login
    public void mostrarLogin() {
        this.getContentPane().removeAll();
        com.vistas.Login loginPanel = new com.vistas.Login(this);
        this.add(loginPanel, java.awt.BorderLayout.CENTER); 
       
        this.revalidate();
        this.repaint();
    }
    /**
     * Método generado por NetBeans para inicializar los componentes visuales
     * NO MODIFICAR, Netbeans protege este código
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Punto de entrada de la aplicación (Main).
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

