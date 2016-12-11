package trackitarduino;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.json.JSONException;
import org.json.JSONObject;

public class Expreso extends javax.swing.JFrame implements SerialPortEventListener {

    private String puerto;
    private String lugar;
    SerialPort serialPort;
    private BufferedReader input;
    private OutputStream output;
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;

    public Expreso() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbEstado = new javax.swing.JLabel();
        lbMensaje = new javax.swing.JLabel();
        lbMensaje1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expreso");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Lista de Alumnos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
      try {
          input.close();
      } catch (IOException ex) {
          Logger.getLogger(Expreso.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
          output.close();
      } catch (IOException ex) {
          Logger.getLogger(Expreso.class.getName()).log(Level.SEVERE, null, ex);
      }
      serialPort.removeEventListener();
      serialPort.close();
  }//GEN-LAST:event_formWindowClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            this.mostrarAlumnos(getPuerto());
        } catch (IOException ex) {
            Logger.getLogger(Expreso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Expreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Expreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Expreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Expreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Expreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Expreso().setVisible(true);
            }
        });
    }

    public void mostrarAlumnos(String puerto) throws MalformedURLException, IOException, JSONException {
        String respuesta = "";
        JSONObject jsonD = new JSONObject();
        jsonD.put("expreso", 60);
//        alumno a1 = new alumno();
//        jPanel2.add(a1);
//        a1.setVisible(rootPaneCheckingEnabled);
        String userAgent = "Mozilla/5.0 (X11; Linux x86_64; rv:26.0) Gecko/20100101 Firefox/26.0";
        String address = "http://localhost:8084/trackit/service_jsp/listaAlumnosExpreso.jsp";
        URL URL = new URL(address);
        URLConnection connection = URL.openConnection();
        connection.addRequestProperty("User-Agent", userAgent);
        connection.setDoOutput(true);
        OutputStreamWriter out = new OutputStreamWriter(
                connection.getOutputStream());
        out.write(jsonD.toString());
        out.close();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String response;
        while ((response = in.readLine()) != null) {
            respuesta += response;
        }
        in.close();

//        DefaultTableModel modelo = new DefaultTableModel();
//        jTable1.setModel(modelo);
//        modelo.addColumn("Codigo");
//        modelo.addColumn("Nombre");
//        modelo.addColumn("Direccion");
//        modelo.addColumn("Estado");

        jPanel2.removeAll();
        int panel2y = 5;
        int panel2Alto = 57;

        JSONObject jObj = new JSONObject(respuesta);
        org.json.JSONArray array = jObj.getJSONArray("alumnos");
        for (int i = 0; i < array.length(); i++) {
            JSONObject alu = array.getJSONObject(i);
            alumno a1 = new alumno();
            a1.setName("alumno" + (i + 1));
            a1.cambiarNombre(alu.getString("nombres") + " " + alu.getString("apellidos"));
            a1.cambiarDireccion(alu.getString("direccion"));
            a1.cambiarDispositivo(alu.getString("dispositivo"));
            a1.cambiarEstado("Libre");
            a1.setSize(439, panel2Alto);
            a1.setLocation(30, panel2y);
            panel2y += panel2Alto + 4;
            jPanel2.add(a1, BorderLayout.CENTER);
            jPanel2.revalidate();
            jPanel2.repaint();

            Object[] obj = new Object[4];
            obj[0] = alu.getString("dispositivo");
            obj[1] = alu.getString("nombres") + " " + alu.getString("apellidos");
            obj[2] = alu.getString("direccion");
            obj[3] = "Libre";
//            modelo.addRow(obj);
        }
//        int[] anchos = {50, 150, 200, 50};
//        for (int i = 0; i < jTable1.getColumnCount(); i++) {
//            jTable1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
//        }

        this.setPuerto(puerto);
        this.setLugar("Expreso");
        initialize();
    }

    public void initialize() {

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

            if (currPortId.getName().equals(getPuerto())) {
                portId = currPortId;
                break;
            }
        }

        if (portId == null) {
            lbEstado.setText("No se encontro Arduino en el puerto " + getPuerto() + " de " + getLugar());
            return;
        }

        try {
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            serialPort.notifyOnBreakInterrupt(true);
            lbEstado.setText("Se inicio el Arduino " + getLugar() + " en el puerto " + getPuerto());
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public synchronized void close() throws IOException {
        if (serialPort != null) {
            input.close();
            output.close();
            serialPort.removeEventListener();
            serialPort.close();
            lbEstado.setText("Se desconecto arduino");

        }
    }

    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {

        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = input.readLine();

                StringTokenizer st = new StringTokenizer(inputLine.trim());
                String dispositivo = "";
                String disCom = "";
                String estado = "";
                while (st.hasMoreTokens()) {
                    dispositivo += st.nextToken().trim();
                }

                lbMensaje.setText("Enviando información: " + dispositivo + " de " + getLugar());

                Component[] componentes = jPanel2.getComponents();
                for (int x = 0; x < componentes.length; x++) {
                    if (componentes[x] instanceof JPanel) {
                        System.out.println("Panel" + x);

                        Component[] cmpPanel = ((JPanel) componentes[x]).getComponents();
                        for (int y = 0; y < cmpPanel.length; y++) {
                            if (cmpPanel[y] instanceof JLabel) {
                                System.out.println("Label " + ((JLabel) cmpPanel[y]).getText());
                                if (((JLabel) cmpPanel[y]).getText().trim().equals(dispositivo)) {
                                    disCom = ((JLabel) cmpPanel[y]).getText().trim();
                                    estado = ((JLabel) cmpPanel[2]).getText();
                                    if (estado.trim().equals("Libre") || estado.trim().equals("Bajó")) {
                                        ((JLabel) cmpPanel[2]).setText("Subió");
                                        ((JLabel) cmpPanel[2]).setForeground(Color.WHITE);
                                        ((JLabel) cmpPanel[2]).setBackground(Color.GREEN);
                                    }
                                    if (estado.trim().equals("Subió")) {
                                        ((JLabel) cmpPanel[2]).setText("Bajó");
                                        ((JLabel) cmpPanel[2]).setForeground(Color.WHITE);
                                        ((JLabel) cmpPanel[2]).setBackground(Color.RED);
                                    }
                                }

                            }
                        }

                    } else {
                        System.out.println("Otro" + x);
                    }
                }

//                TableModel tableModel = jTable1.getModel();
//                for (int i = 0; i < tableModel.getRowCount(); i++) {
//                    if (dispositivo.equals(tableModel.getValueAt(i, 0).toString().trim())) {
//                        disCom = tableModel.getValueAt(i, 0).toString().trim();
//                    }
//                }
                if (!disCom.isEmpty()) {
                    RegistrarUbicacion ru = new RegistrarUbicacion();
                    String respuesta = ru.enviarUbicacion(getLugar(), disCom);

                    JSONObject jObj = new JSONObject(respuesta);
                    boolean error = jObj.getBoolean("err");
                    if (!error) {
                        cambiarEstadoAlumno(disCom);
                    }

                    String mensaje = jObj.getString("mensaje").trim();
                    lbMensaje1.setText(mensaje);
                } else {
                    lbMensaje1.setText("No se encontro alumno con el dispositivo " + dispositivo);
                }

            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

    public void cambiarEstadoAlumno(String disCom) {
//        System.out.println("Entro a cambiar estado");
//        TableModel tableModel = jTable1.getModel();
//        for (int i = 0; i < tableModel.getRowCount(); i++) {
//            if (disCom.equals(tableModel.getValueAt(i, 0).toString().trim())) {
//                String estado = tableModel.getValueAt(i, 3).toString().trim();
//                if (estado.equals("Libre")) {
//                    jTable1.setValueAt("Subió", i, 3);
//                }
//                if (estado.equals("Subió")) {
//                    jTable1.setValueAt("Bajó", i, 3);
//                }
//                if (estado.equals("Bajó")) {
//                    jTable1.setValueAt("Subió", i, 3);
//                }
//                jTable1.setDefaultRenderer(Object.class, new tableStyle());
//
//            }
//        }
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbMensaje;
    private javax.swing.JLabel lbMensaje1;
    // End of variables declaration//GEN-END:variables
}
