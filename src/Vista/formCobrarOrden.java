package Vista;

import Modelo.rellenarCombo;
import Conexion.CConexion;
import com.itextpdf.text.Image;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import java.awt.Desktop;
import java.io.IOException;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

public class formCobrarOrden extends javax.swing.JFrame {

    rellenarCombo rC = new rellenarCombo();

    CConexion con = new CConexion();
    Connection cn = con.conectar();

    private int idUsuarioCamarero;

    public formCobrarOrden() {
        initComponents();
        redimensionarImagen();
        this.setLocationRelativeTo(null);
        rC.rellenarComboBox("orden", "id_orden", cboIDOrden);
    }

    private void redimensionarImagen() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/iconoRestaurante.jpeg"));
        // Obtener la imagen original y redimensionarla al tamaño del JLabel
        java.awt.Image img = icon.getImage();
        java.awt.Image imgRedimensionada = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), java.awt.Image.SCALE_SMOOTH);
        // Crear un nuevo ImageIcon con la imagen redimensionada
        ImageIcon iconoRedimensionado = new ImageIcon(imgRedimensionada);
        jLabel1.setIcon(iconoRedimensionado);
    }

    public void setNombreCamarero(String nombreCamarero) {
        lblMostrarUsuario.setText("Usuario: " + nombreCamarero);
        ResultSet rs = null;
        try {
            PreparedStatement pss = cn.prepareStatement("select id_usuario from usuarios where nombre = ?;");
            pss.setString(1, nombreCamarero);
            String dat[] = new String[1];
            rs = pss.executeQuery();
            while (rs.next()) {
                dat[0] = rs.getString(1);
            }
            idUsuarioCamarero = Integer.parseInt(dat[0]);
        } catch (SQLException e) {
            System.out.println("Error al traer datos de la BD");
        }
    }

    public void actualizarOrden() {
        int id_orde = Integer.parseInt(cboIDOrden.getSelectedItem().toString());
        try {
            PreparedStatement pps = cn.prepareStatement("update orden set id_usuario = ? where id_orden = ?;");
            pps.setInt(1, idUsuarioCamarero);
            pps.setInt(2, id_orde);
            pps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario de la orden en la BD " + e);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de número: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboIDOrden = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblMostrarUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCobro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblImporteTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 164, 96));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoRestaurante.jpeg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("COBRAR ORDEN");

        jLabel3.setFont(new java.awt.Font("Eras Demi ITC", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seleccione ID de orden");

        cboIDOrden.setBackground(new java.awt.Color(210, 105, 30));
        cboIDOrden.setFont(new java.awt.Font("Eras Demi ITC", 0, 13)); // NOI18N
        cboIDOrden.setForeground(new java.awt.Color(0, 0, 0));
        cboIDOrden.setBorder(null);
        cboIDOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboIDOrdenActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(210, 105, 30));
        jButton1.setFont(new java.awt.Font("Eras Demi ITC", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Imprimir ticket");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(210, 105, 30));
        jButton2.setFont(new java.awt.Font("Eras Demi ITC", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cerrar sesión");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblMostrarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMostrarUsuario.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Eras Demi ITC", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cobro                          $");

        txtCobro.setBackground(new java.awt.Color(244, 164, 96));
        txtCobro.setFont(new java.awt.Font("Eras Demi ITC", 0, 13)); // NOI18N
        txtCobro.setForeground(new java.awt.Color(0, 0, 0));
        txtCobro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel5.setFont(new java.awt.Font("Eras Demi ITC", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Importe total            $");

        lblImporteTotal.setBackground(new java.awt.Color(210, 105, 30));
        lblImporteTotal.setFont(new java.awt.Font("Eras Demi ITC", 0, 13)); // NOI18N
        lblImporteTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblImporteTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMostrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboIDOrden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblImporteTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCobro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(37, 37, 37)))
                .addGap(36, 36, 36))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboIDOrden, jLabel3, jLabel4, jLabel5, lblImporteTotal, txtCobro});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(lblMostrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboIDOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboIDOrden, jLabel3, jLabel4, jLabel5, lblImporteTotal, txtCobro});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a = JOptionPane.YES_NO_OPTION;
        int resultado = JOptionPane.showConfirmDialog(this, "¿Desea cerrar sesión?", "Salir", a);
        if (resultado == 0) {
            this.setVisible(false);
            login bu = new login();
            bu.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            double cobrar = Double.parseDouble(lblImporteTotal.getText());
            double pago = Double.parseDouble(txtCobro.getText());
            String destino = "", nombreArchivo = "";
            if (pago >= cobrar) {
                actualizarOrden();

                double cambio = pago - cobrar;

                Document documento = new Document(new Rectangle(350, 325)); // Tamaño de ticket personalizado
                int id_orden = Integer.parseInt(cboIDOrden.getSelectedItem().toString());

                try {
                    String consult = "select fecha, no_mesa, total, usuarios.nombre from orden inner join usuarios on (orden.id_usuario = usuarios.id_usuario) where id_orden = ?;";
                    PreparedStatement pss = cn.prepareStatement(consult);
                    pss.setInt(1, id_orden);
                    String datos[] = new String[4];
                    ResultSet rss = pss.executeQuery();
                    while (rss.next()) {
                        datos[0] = rss.getString(1);
                        datos[1] = rss.getString(2);
                        datos[2] = rss.getString(3);
                        datos[3] = rss.getString(4);
                    }

                    try {
                        String ruta = System.getProperty("user.home");
                        destino = ruta + "/Desktop/Ticket" + id_orden + ".pdf";
                        nombreArchivo = "Ticket" + id_orden + ".pdf";
                        File archivo = new File(destino);

                        // Crear directorios si no existen
                        archivo.getParentFile().mkdirs();

                        PdfWriter.getInstance(documento, new FileOutputStream(archivo));
                        System.out.println("Ruta del archivo PDF: " + destino);
                        documento.open();

                        // Fuentes personalizadas
                        Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
                        Font fontNormal = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
                        Font fontBold = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);

                        //Logo
                        try {
                            String rutaImagen = "src/img/iconoRestaurante.jpeg";
                            Image imagen = Image.getInstance(rutaImagen);
                            imagen.scaleToFit(50, 50);
                            imagen.setAlignment(Element.ALIGN_LEFT);
                            documento.add(imagen);
                        } catch (DocumentException | IOException e) {
                            e.printStackTrace();
                        }

                        // Encabezado del ticket
                        Paragraph titulo = new Paragraph("Restaurante\n\n", fontTitulo);
                        titulo.setAlignment(Element.ALIGN_CENTER);
                        documento.add(titulo);

                        Paragraph infoOrden = new Paragraph("Orden No: " + id_orden + "\nFecha: " + datos[0] + "\nMesa: " + datos[1] + "\nCamarero: " + datos[3] + "\n\n", fontNormal);
                        infoOrden.setAlignment(Element.ALIGN_CENTER);
                        documento.add(infoOrden);

                        // Tabla con los detalles
                        PdfPTable tabla = new PdfPTable(3);
                        tabla.setWidthPercentage(100); // Ancho de la tabla
                        tabla.setWidths(new float[]{3, 2, 2}); // Ancho relativo de las columnas

                        tabla.addCell(new PdfPCell(new Phrase("Producto", fontBold)));
                        tabla.addCell(new PdfPCell(new Phrase("Cantidad", fontBold)));
                        tabla.addCell(new PdfPCell(new Phrase("Subtotal", fontBold)));

                        try {
                            String consulta = "SELECT productos.nombre, cantidad, subtotal "
                                    + "FROM detalle_orden "
                                    + "INNER JOIN productos ON (detalle_orden.id_prod = productos.id_prod) "
                                    + "WHERE detalle_orden.id_orden = ?";
                            PreparedStatement ps = cn.prepareStatement(consulta);
                            ps.setInt(1, id_orden);
                            ResultSet rs = ps.executeQuery();
                            while (rs.next()) {
                                tabla.addCell(new PdfPCell(new Phrase(rs.getString(1), fontNormal)));
                                tabla.addCell(new PdfPCell(new Phrase(rs.getString(2), fontNormal)));
                                tabla.addCell(new PdfPCell(new Phrase(rs.getString(3), fontNormal)));
                            }
                            documento.add(tabla);
                        } catch (SQLException e) {
                            System.out.println("Error en la consulta SQL: " + e.getMessage());
                        }

                        // Pie del ticket
                        Paragraph footer = new Paragraph("\nTotal: $" + datos[2] + "\nPago: $" + pago + "\nCambio: $" + String.format("%.2f", cambio) + "\n\n¡Gracias por su compra!\n\n", fontNormal);
                        footer.setAlignment(Element.ALIGN_CENTER);
                        documento.add(footer);

                        txtCobro.setText("");
                        JOptionPane.showMessageDialog(null, "Pago realizado con éxito. Ticket impreso\nEl cambio es: $ " + String.format("%.2f", cambio), "Confirmación de pago", JOptionPane.INFORMATION_MESSAGE);

                        if (JOptionPane.showConfirmDialog(null, "¿Desea enviar el ticket por email?", "Enviar Ticket", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            this.setVisible(false);
                            try {
                            File path = new File(destino);
                            Desktop.getDesktop().open(path);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            EnvioCorreos ec = new EnvioCorreos(archivo, nombreArchivo);
                            ec.setVisible(true);
                        }
                    } catch (DocumentException e) {
                        System.out.println("Error al crear el documento PDF: " + e.getMessage());
                    } catch (FileNotFoundException e) {
                        System.out.println("Error, archivo no encontrado: " + e.getMessage());
                    } catch (HeadlessException e) {
                        System.out.println("Error de entorno gráfico: " + e.getMessage());
                    } finally {
                        if (documento.isOpen()) {
                            documento.close();
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("Error al traer los datos de la BD");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: El pago es menor que el monto a cobrar.", "Error de pago", JOptionPane.ERROR_MESSAGE);
                txtCobro.setText("");
                txtCobro.requestFocusInWindow();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboIDOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboIDOrdenActionPerformed
        int id_orden = Integer.parseInt(cboIDOrden.getSelectedItem().toString());
        try {
            String consult = "select total from orden where id_orden = ?;";
            PreparedStatement pss = cn.prepareStatement(consult);
            pss.setInt(1, id_orden);
            String datos[] = new String[1];
            ResultSet rss = pss.executeQuery();
            while (rss.next()) {
                datos[0] = rss.getString(1);
            }
            lblImporteTotal.setText(datos[0]);
        } catch (SQLException e) {
            System.out.println("Error al traer datos de la BD");
        }
    }//GEN-LAST:event_cboIDOrdenActionPerformed

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
            java.util.logging.Logger.getLogger(formCobrarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formCobrarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formCobrarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formCobrarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formCobrarOrden().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboIDOrden;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImporteTotal;
    private javax.swing.JLabel lblMostrarUsuario;
    private javax.swing.JTextField txtCobro;
    // End of variables declaration//GEN-END:variables
}
