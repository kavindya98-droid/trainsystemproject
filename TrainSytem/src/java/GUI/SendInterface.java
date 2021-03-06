/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Send;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jms.JMSException;
import javax.naming.NamingException;
import lk.orm.Sensors;

/**
 *
 * @author Kavindya Nirmani
 */
public class SendInterface extends javax.swing.JFrame {

    /**
     * Creates new form SendInterface
     */
    public SendInterface() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        loc = new javax.swing.JTextField();
        speed = new javax.swing.JTextField();
        temp = new javax.swing.JTextField();
        humiditycombo = new javax.swing.JComboBox<>();
        sendbtn = new javax.swing.JButton();
        traincombo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("TRAIN DETAILS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 47));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("TRAIN CODE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("LOCATION");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("SPEED");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("TEMPERATURE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("HUMIDITY");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        jPanel1.add(loc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 193, -1));
        jPanel1.add(speed, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 193, -1));
        jPanel1.add(temp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 193, -1));

        humiditycombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COLD", "HOT" }));
        jPanel1.add(humiditycombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 193, -1));

        sendbtn.setBackground(new java.awt.Color(255, 255, 255));
        sendbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sendbtn.setText("SAVE");
        sendbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendbtnActionPerformed(evt);
            }
        });
        jPanel1.add(sendbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        traincombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T0001 - UDARATA MANIKE", "T0002 - YAL DEWI", "T0003 - RUHUNU KUMARI" }));
        jPanel1.add(traincombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 193, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pexels-photo-2790396.jpeg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendbtnActionPerformed
        // SEND DETAILS:
        try {
            String traincode = traincombo.getSelectedItem().toString();
            String location = loc.getText();
            double speedfiled = Double.parseDouble(speed.getText());
            double temperature = Double.parseDouble(temp.getText());
            String humidity = humiditycombo.getSelectedItem().toString();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss aa");
            String traindate = dateFormat.format(new Date());
            String traintime = timeFormat.format(new Date());

            Sensors sensor = new Sensors();
            sensor.setTraincode(traincode);
            sensor.setSpeed(speedfiled);
            sensor.setLocation(location);
            sensor.setTemperature(temperature);
            sensor.setHumidity(humidity);
            sensor.setTraindate(traindate);
            sensor.setTraintime(traintime);

            Gson gson = new Gson();
            String iot = gson.toJson(sensor);
            Send send = new Send();
            String c = send.sendJMSMessageToEJB(iot);
            System.out.println("output:" + c);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_sendbtnActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SendInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> humiditycombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField loc;
    private javax.swing.JButton sendbtn;
    private javax.swing.JTextField speed;
    private javax.swing.JTextField temp;
    private javax.swing.JComboBox<String> traincombo;
    // End of variables declaration//GEN-END:variables
}
