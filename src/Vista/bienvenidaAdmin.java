package Vista;

import Conexion.CConexion;
import Controlador.CtrlProducto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

public class bienvenidaAdmin extends javax.swing.JFrame {

    CConexion con = new CConexion();
    Connection cn = con.conectar();
    private String fechaIn = "2024-01-01", fechaFin = "2024-01-31";

    public bienvenidaAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
        redimensionarImagen();
        mostrarGrafica(fechaIn, fechaFin);
    }

    private void redimensionarImagen() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/iconoRestaurante.jpeg"));
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/img/logotipo-restaurante-icono-o-simbolo-menu-diseno-cantina-o-cafe-letras-ilustracion-vectorial_110338-870-Photoroom.png-Photoroom.png"));
        // Obtener la imagen original y redimensionarla al tamaño del JLabel
        Image img = icon.getImage();
        Image img2 = icon2.getImage();
        Image imgRedimensionada = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        Image imgRedimensionada2 = img2.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        // Crear un nuevo ImageIcon con la imagen redimensionada
        ImageIcon iconoRedimensionado = new ImageIcon(imgRedimensionada);
        ImageIcon iconoRedimensionado2 = new ImageIcon(imgRedimensionada2);
        jLabel1.setIcon(iconoRedimensionado);
        jLabel2.setIcon(iconoRedimensionado2);
    }

    public void establecerUsuario(String u) {
        lblMostrarUsuario.setText("Usuario: " + u);
    }

    public void mostrarGrafica(String Fi, String FF) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        CtrlProducto ctp = new CtrlProducto();
        dataset = ctp.consultarProductos(dataset, Fi, FF);

        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Cantidad total vendida de cada producto durante el mes de " + cboSelectMes.getSelectedItem() + " de 2024.",
                "Producto",
                "Total",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(1000, 200));

        jPGrafica.removeAll();

        jPGrafica.setLayout(new BorderLayout());
        jPGrafica.add(chartPanel, BorderLayout.NORTH);

        pack();
        repaint();
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
        jLabel2 = new javax.swing.JLabel();
        jPGrafica = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cboSelectMes = new javax.swing.JComboBox<>();
        lblMostrarUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 164, 96));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoRestaurante.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logotipo-restaurante-icono-o-simbolo-menu-diseno-cantina-o-cafe-letras-ilustracion-vectorial_110338-870-Photoroom.png-Photoroom.png"))); // NOI18N

        jPGrafica.setBackground(new java.awt.Color(251, 235, 165));
        jPGrafica.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPGraficaLayout = new javax.swing.GroupLayout(jPGrafica);
        jPGrafica.setLayout(jPGraficaLayout);
        jPGraficaLayout.setHorizontalGroup(
            jPGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1029, Short.MAX_VALUE)
        );
        jPGraficaLayout.setVerticalGroup(
            jPGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(210, 105, 30));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Usuarios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(210, 105, 30));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Productos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(210, 105, 30));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Órdenes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(210, 105, 30));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Cerrar sesión");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(251, 235, 165));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Seleccionar mes");

        cboSelectMes.setBackground(new java.awt.Color(210, 105, 30));
        cboSelectMes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cboSelectMes.setForeground(new java.awt.Color(0, 0, 0));
        cboSelectMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cboSelectMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSelectMesActionPerformed(evt);
            }
        });

        lblMostrarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMostrarUsuario.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(150, 150, 150)
                .addComponent(jButton4)
                .addGap(113, 113, 113))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMostrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel3)
                        .addGap(41, 41, 41)
                        .addComponent(cboSelectMes, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMostrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cboSelectMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(24, 24, 24))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        Usuarios u = new Usuarios();
        u.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        Productos p = new Productos();
        p.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        Ordenes o = new Ordenes();
        o.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int a = JOptionPane.YES_NO_OPTION;
        int resultado = JOptionPane.showConfirmDialog(this, "¿Desea cerrar sesión?", "Salir", a);
        if (resultado == 0) {
            this.setVisible(false);
            login l = new login();
            l.setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cboSelectMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSelectMesActionPerformed
        switch (cboSelectMes.getSelectedIndex()) {
            case 0 -> {
                fechaIn = "2024-01-01";
                fechaFin = "2024-01-31";
            }
            case 1 -> {
                fechaIn = "2024-02-01";
                fechaFin = "2024-02-29";
            }
            case 2 -> {
                fechaIn = "2024-03-01";
                fechaFin = "2024-03-31";
            }
            case 3 -> {
                fechaIn = "2024-04-01";
                fechaFin = "2024-04-30";
            }
            case 4 -> {
                fechaIn = "2024-05-01";
                fechaFin = "2024-05-31";
            }
            case 5 -> {
                fechaIn = "2024-06-01";
                fechaFin = "2024-06-30";
            }
            case 6 -> {
                fechaIn = "2024-07-01";
                fechaFin = "2024-07-31";
            }
            case 7 -> {
                fechaIn = "2024-08-01";
                fechaFin = "2024-08-31";
            }
            case 8 -> {
                fechaIn = "2024-09-01";
                fechaFin = "2024-09-30";
            }
            case 9 -> {
                fechaIn = "2024-10-01";
                fechaFin = "2024-10-31";
            }
            case 10 -> {
                fechaIn = "2024-11-01";
                fechaFin = "2024-11-30";
            }
            case 11 -> {
                fechaIn = "2024-12-01";
                fechaFin = "2024-12-31";
            }
        }

        mostrarGrafica(fechaIn, fechaFin);

    }//GEN-LAST:event_cboSelectMesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bienvenidaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bienvenidaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bienvenidaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bienvenidaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bienvenidaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboSelectMes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPGrafica;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMostrarUsuario;
    // End of variables declaration//GEN-END:variables
}