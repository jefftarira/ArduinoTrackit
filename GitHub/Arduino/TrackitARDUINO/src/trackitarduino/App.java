package trackitarduino;

import gnu.io.CommPortIdentifier;
import java.awt.Color;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

public class App extends javax.swing.JFrame {

    public App() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbPuerto1 = new javax.swing.JComboBox<>();
        cbPuerto3 = new javax.swing.JComboBox<>();
        cbPuerto2 = new javax.swing.JComboBox<>();
        btIni1 = new javax.swing.JButton();
        btIni2 = new javax.swing.JButton();
        btIni3 = new javax.swing.JButton();
        lbMensaje1 = new javax.swing.JLabel();
        lbMensaje2 = new javax.swing.JLabel();
        lbMensaje3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de Arduino");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Casa");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Expreso");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Escuela");

        btIni1.setText("Iniciar");
        btIni1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIni1ActionPerformed(evt);
            }
        });

        btIni2.setText("Iniciar");
        btIni2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIni2ActionPerformed(evt);
            }
        });

        btIni3.setText("Iniciar");
        btIni3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIni3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbPuerto1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btIni1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPuerto2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btIni2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbMensaje2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btIni3)
                            .addComponent(cbPuerto3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(lbMensaje3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPuerto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPuerto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPuerto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btIni1)
                    .addComponent(btIni2)
                    .addComponent(btIni3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMensaje3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMensaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIni1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIni1ActionPerformed
        String puerto = cbPuerto1.getSelectedItem().toString().trim();

        if (!puerto.isEmpty()) {
            ArduinoThread ard = new ArduinoThread(puerto, "Casa");
            ard.start();
            lbMensaje1.setText("Iniciado");
            lbMensaje1.setForeground(Color.BLUE);
        } else {
            lbMensaje1.setText("Seleccione un puerto");
            lbMensaje1.setForeground(Color.RED);
        }
    }//GEN-LAST:event_btIni1ActionPerformed

    private void btIni2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIni2ActionPerformed
        String puerto = cbPuerto2.getSelectedItem().toString().trim();

        if (!puerto.isEmpty()) {
            Expreso exp = new Expreso();
            exp.setVisible(true);
            try {
                exp.mostrarAlumnos(puerto);
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            lbMensaje2.setText("Iniciado");
            lbMensaje2.setForeground(Color.BLUE);
        } else {
            lbMensaje2.setText("Seleccione un puerto");
            lbMensaje2.setForeground(Color.RED);
        }


    }//GEN-LAST:event_btIni2ActionPerformed

    private void btIni3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIni3ActionPerformed
        String puerto = cbPuerto3.getSelectedItem().toString().trim();

        if (!puerto.isEmpty()) {
            ArduinoThread ard = new ArduinoThread(puerto, "Escuela");
            ard.start();
            lbMensaje3.setText("Iniciado");
            lbMensaje3.setForeground(Color.BLUE);
        } else {
            lbMensaje3.setText("Seleccione un puerto");
            lbMensaje3.setForeground(Color.RED);
        }
    }//GEN-LAST:event_btIni3ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                 new App().setVisible(true);
                App ap = new App();
                ap.setVisible(true);
                ap.setPuertos();
            }
        });
    }

    public void setPuertos() {
        cbPuerto1.removeAllItems();
        cbPuerto2.removeAllItems();
        cbPuerto3.removeAllItems();
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            if (currPortId.getPortType() == 1) {
                cbPuerto1.addItem(currPortId.getName());
                cbPuerto2.addItem(currPortId.getName());
                cbPuerto3.addItem(currPortId.getName());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIni1;
    private javax.swing.JButton btIni2;
    private javax.swing.JButton btIni3;
    private javax.swing.JComboBox<String> cbPuerto1;
    private javax.swing.JComboBox<String> cbPuerto2;
    private javax.swing.JComboBox<String> cbPuerto3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbMensaje1;
    private javax.swing.JLabel lbMensaje2;
    private javax.swing.JLabel lbMensaje3;
    // End of variables declaration//GEN-END:variables
}
