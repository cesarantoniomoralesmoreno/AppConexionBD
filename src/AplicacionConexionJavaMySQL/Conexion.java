/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AplicacionConexionJavaMySQL;


import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexion extends javax.swing.JFrame {
    
 
    public static final String URL = "jdbc:mysql://localhost:3306/escuela?autoReconnet=true&useSSL=false";
    public static final String usuario = "root";
    public static final String contraseña = "20626065Snoops";
    
    
    public Conexion() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonConectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonConectar.setText("Conectar");
        botonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addComponent(botonConectar)
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addComponent(botonConectar)
                .addGap(146, 146, 146))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConectarActionPerformed
        
        Connection conexion = getConnection();
        PreparedStatement ps;//Se crea para almacenar las diferentes consultas que hagamos
        ResultSet rs;
        
        try{
            //Hacemos la consulta como si estuvieramos en la base de datos
            ps = conexion.prepareStatement("select * from persona");
            
            rs= ps.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Nombre: "+rs.getString("nombre")+
                        "\nDomicilio: "+rs.getString("domicilio")+"\nCelular: "+rs.getString("celular")+
                        "\nCorreo Electronico"+"correo_electronico"+"\nFecha de nacimiento: "+
                        String.valueOf(rs.getDate("fecha_nacimiento"))+"\nGenero: "+rs.getString("genero"));
            }else{
                JOptionPane.showMessageDialog(null,"No existen registros");
            }
            conexion.close();//Con esto cerramos la conexion 
        }catch(Exception ex){
            System.err.println("ERROR "+ex);
        }
    }//GEN-LAST:event_botonConectarActionPerformed
    
    public Connection getConnection(){
        
        Connection conexion=null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection)DriverManager.getConnection(URL,usuario,contraseña);
            JOptionPane.showMessageDialog(null,"Conexion Exitosa");
            
        }catch(Exception ex){
            System.err.println("Error"+ex);
        }

        return conexion;
        
    }
    
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
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConectar;
    // End of variables declaration//GEN-END:variables
}
