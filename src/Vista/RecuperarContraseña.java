/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author jheremyPonte
 */
public class RecuperarContraseña extends javax.swing.JFrame {

    /**
     * Creates new form RecuperarContraseña
     */
    public RecuperarContraseña() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxtCorreoElectronico = new javax.swing.JTextField();
        jbtnVolverAtras = new javax.swing.JButton();
        jbtnEnviarCodigo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("INGRESA TU CORREO ELECTRONICO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));
        jPanel1.add(jtxtCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 200, -1));

        jbtnVolverAtras.setText("VOLVER ATRAS");
        jPanel1.add(jbtnVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jbtnEnviarCodigo.setText("ENVIAR CODIGO");
        jPanel1.add(jbtnEnviarCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        jLabel2.setText("RECUPARAR CONTRASEÑA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton jbtnEnviarCodigo;
    public javax.swing.JButton jbtnVolverAtras;
    private javax.swing.JTextField jtxtCorreoElectronico;
    // End of variables declaration//GEN-END:variables
}
