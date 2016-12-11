package trackitarduino;

import javax.swing.ImageIcon;

public class alumno extends javax.swing.JPanel {
    public alumno() {
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDireccion = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbEstado = new javax.swing.JLabel();
        lbDispositivo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(510, 57));
        setName("PanelAlumno"); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbDireccion.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lbDireccion.setForeground(new java.awt.Color(50, 50, 50));
        lbDireccion.setText("<html><body> La joya etapa corona d    fjdfsdfadfasdfla     djsfjas    dlfja  l<br> Mz 15 villa 14 </body></html>");
        lbDireccion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lbDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 290, 30));

        lbNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(50, 50, 50));
        lbNombre.setText("Andrea Elizabeth Cevallos Villacis");
        add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 337, -1));

        lbEstado.setBackground(new java.awt.Color(255, 255, 255));
        lbEstado.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lbEstado.setForeground(new java.awt.Color(30, 30, 30));
        lbEstado.setLabelFor(lbEstado);
        lbEstado.setText("Libre");
        lbEstado.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbEstado.setOpaque(true);
        add(lbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 70, 20));

        lbDispositivo.setForeground(new java.awt.Color(255, 255, 255));
        lbDispositivo.setLabelFor(lbDispositivo);
        lbDispositivo.setToolTipText("");
        add(lbDispositivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 80, 20));
    }// </editor-fold>//GEN-END:initComponents
    
    public void cambiarNombre(String nombre){
        lbNombre.setText(nombre);
    }
    
    public void cambiarDireccion(String direccion){
        if(direccion.length()>62)
            lbDireccion.setText("<html><body>"+direccion.substring(0,61).toLowerCase()+"<br>"+direccion.substring(62).toLowerCase()+ "</body></html>");
        else
            lbDireccion.setText(direccion.toLowerCase());
    }
    
    public void cambiarEstado(String estado){
        lbEstado.setText(estado);
    }
    
    public void cambiarDispositivo(String dispostivo){
        lbDispositivo.setText(dispostivo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbDispositivo;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbNombre;
    // End of variables declaration//GEN-END:variables
}
