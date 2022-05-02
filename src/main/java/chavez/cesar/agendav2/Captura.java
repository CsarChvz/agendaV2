/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package chavez.cesar.agendav2;

import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author depresionatom
 */
public class Captura extends javax.swing.JInternalFrame {

    /**
     * Creates new form Captura
     */
    public Captura() {
        initComponents();
        JD_DateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                if(JD_DateChooser.getDate() != null){
                    Date fecha = JD_DateChooser.getDate();
                    Date fechaSistema = new Date();
                    int anio = (int)(((fechaSistema.getTime()- fecha.getTime())/86400000)/365);
                    JT_Edad.setText(String.valueOf(anio));
                }
            }
        });
    }

    FileInputStream fis;
    int longitud;
    Image imgFoto;
    String nomabus;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JFCFoto = new javax.swing.JFileChooser();
        JP_Panel1 = new javax.swing.JPanel();
        JL_Nombre = new javax.swing.JLabel();
        JT_Nombre = new javax.swing.JTextField();
        JL_Apellido = new javax.swing.JLabel();
        JT_Apellido = new javax.swing.JTextField();
        JL_Domicilio = new javax.swing.JLabel();
        JT_Domicilio = new javax.swing.JTextField();
        JL_Telefono = new javax.swing.JLabel();
        JT_Telefono = new javax.swing.JTextField();
        JL_Email = new javax.swing.JLabel();
        JT_Email = new javax.swing.JTextField();
        JL_FechaNacimiento = new javax.swing.JLabel();
        JL_Sexo = new javax.swing.JLabel();
        JR_Femenino = new javax.swing.JRadioButton();
        JR_Masculino = new javax.swing.JRadioButton();
        JL_ID = new javax.swing.JLabel();
        JD_DateChooser = new com.toedter.calendar.JDateChooser();
        JL_ID2 = new javax.swing.JLabel();
        JP_Panel2 = new javax.swing.JPanel();
        JL_Foto = new javax.swing.JLabel();
        JB_Foto = new javax.swing.JButton();
        JP_Panel3 = new javax.swing.JPanel();
        JB_Agregar = new javax.swing.JButton();
        JB_Modificar = new javax.swing.JButton();
        JB_Buscar = new javax.swing.JButton();
        JB_Eliminar = new javax.swing.JButton();
        JB_Salir = new javax.swing.JButton();
        JL_Edad = new javax.swing.JLabel();
        JT_Edad = new javax.swing.JTextField();

        JL_Nombre.setText("Nombre");

        JL_Apellido.setText("Apellido");

        JL_Domicilio.setText("Domicilio");

        JL_Telefono.setText("Telefono");

        JL_Email.setText("Email");

        JL_FechaNacimiento.setText("Fecha de nacimiento");

        JL_Sexo.setText("Sexo");

        JR_Femenino.setText("Femenino");

        JR_Masculino.setText("Masculino");

        JL_ID.setText("ID");

        javax.swing.GroupLayout JP_Panel1Layout = new javax.swing.GroupLayout(JP_Panel1);
        JP_Panel1.setLayout(JP_Panel1Layout);
        JP_Panel1Layout.setHorizontalGroup(
            JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Panel1Layout.createSequentialGroup()
                        .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JP_Panel1Layout.createSequentialGroup()
                                .addComponent(JL_Sexo)
                                .addGap(173, 173, 173)
                                .addComponent(JR_Masculino))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JP_Panel1Layout.createSequentialGroup()
                                    .addComponent(JL_Apellido)
                                    .addGap(18, 18, 18)
                                    .addComponent(JT_Apellido))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JP_Panel1Layout.createSequentialGroup()
                                    .addComponent(JL_FechaNacimiento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(JD_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JP_Panel1Layout.createSequentialGroup()
                                    .addComponent(JL_Domicilio)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(JT_Domicilio))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JP_Panel1Layout.createSequentialGroup()
                                    .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JL_Telefono)
                                        .addComponent(JL_Email))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JT_Telefono)
                                        .addComponent(JT_Email)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JP_Panel1Layout.createSequentialGroup()
                                    .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JL_Nombre)
                                        .addComponent(JL_ID))
                                    .addGap(18, 18, 18)
                                    .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JL_ID2)
                                        .addComponent(JT_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 98, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_Panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JR_Femenino)
                        .addGap(194, 194, 194))))
        );
        JP_Panel1Layout.setVerticalGroup(
            JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Panel1Layout.createSequentialGroup()
                .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_ID)
                    .addGroup(JP_Panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JL_ID2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JT_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Apellido)
                    .addComponent(JT_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Domicilio)
                    .addComponent(JT_Domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Telefono)
                    .addComponent(JT_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Email)
                    .addComponent(JT_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Panel1Layout.createSequentialGroup()
                        .addComponent(JL_FechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JL_Sexo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_Panel1Layout.createSequentialGroup()
                        .addComponent(JD_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(JP_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JR_Femenino)
                            .addComponent(JR_Masculino))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );

        JL_Foto.setBackground(new java.awt.Color(255, 255, 255));
        JL_Foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JB_Foto.setText("Foto");
        JB_Foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_FotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Panel2Layout = new javax.swing.GroupLayout(JP_Panel2);
        JP_Panel2.setLayout(JP_Panel2Layout);
        JP_Panel2Layout.setHorizontalGroup(
            JP_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Panel2Layout.createSequentialGroup()
                .addGroup(JP_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Panel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(JL_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_Panel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(JB_Foto)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        JP_Panel2Layout.setVerticalGroup(
            JP_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Panel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(JL_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JB_Foto)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        JB_Agregar.setText("Agregar");
        JB_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AgregarActionPerformed(evt);
            }
        });

        JB_Modificar.setText("Modificar");

        JB_Buscar.setText("Buscar");
        JB_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_BuscarActionPerformed(evt);
            }
        });

        JB_Eliminar.setText("Eliminar");

        JB_Salir.setText("Salir");
        JB_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Panel3Layout = new javax.swing.GroupLayout(JP_Panel3);
        JP_Panel3.setLayout(JP_Panel3Layout);
        JP_Panel3Layout.setHorizontalGroup(
            JP_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Panel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(JB_Salir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JP_Panel3Layout.createSequentialGroup()
                .addComponent(JB_Modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(JB_Eliminar))
            .addGroup(JP_Panel3Layout.createSequentialGroup()
                .addComponent(JB_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JB_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_Panel3Layout.setVerticalGroup(
            JP_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Panel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(JP_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Agregar)
                    .addComponent(JB_Buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(JP_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Modificar)
                    .addComponent(JB_Eliminar))
                .addGap(39, 39, 39)
                .addComponent(JB_Salir)
                .addContainerGap())
        );

        JL_Edad.setText("Edad");

        JT_Edad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_EdadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JP_Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JP_Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(JP_Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(JL_Edad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JT_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JP_Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JP_Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JL_Edad)
                            .addComponent(JT_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JP_Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JT_EdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_EdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_EdadActionPerformed

    private void JB_FotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_FotoActionPerformed
        // TODO add your handling code here:
        
        // Hacemos la variable sea una instancia de la clase FileChooser
        JFCFoto = new JFileChooser();
        JFCFoto.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG", "jpg");
        JFCFoto.setFileFilter(filtro);
        int estado = JFCFoto.showOpenDialog(null);
        if(estado == JFileChooser.APPROVE_OPTION){
            
            try {
                fis = new FileInputStream(JFCFoto.getSelectedFile());
                longitud = (int)JFCFoto.getSelectedFile().length();
                
                try {   
                    Image icono = ImageIO.read(JFCFoto.getSelectedFile()).getScaledInstance(JL_Foto.getWidth(), JL_Foto.getHeight(), Image.SCALE_DEFAULT);
                    JL_Foto.setIcon(new ImageIcon(icono));
                    JL_Foto.updateUI();
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(rootPane, "Imagen"+ioe);
                }
            } catch(FileNotFoundException fnfe) {
                JOptionPane.showMessageDialog(rootPane, "Imagen"+fnfe);
            }
        }
    }//GEN-LAST:event_JB_FotoActionPerformed

    private void JB_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AgregarActionPerformed
        // TODO add your handling code here:
        
        String nombre = JT_Nombre.getText().toUpperCase();
        String apellido = JT_Apellido.getText().toUpperCase();
        String domicilio = JT_Domicilio.getText().toUpperCase();
        String telefono = JT_Telefono.getText().toUpperCase();
        String email = JT_Email.getText().toUpperCase();
        int edad = Integer.parseInt(JT_Edad.getText());
        
        Date fecha = JD_DateChooser.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        String fechaNacimiento = sdf.format(fecha);
        String sexo;
        if(JR_Masculino.isSelected()){
            sexo = "Masculino";
        } else {
        
            sexo = "Femenino";
        }
        Metodos enlace = new Metodos();
        
        // Falta los valores de las imagenes
        enlace.Agregar(nombre, apellido, domicilio, telefono, email, fechaNacimiento, sexo, edad, fis, longitud);
    }//GEN-LAST:event_JB_AgregarActionPerformed

    
    private void mostrarFoto(int ID) {
        Metodos enlace = new Metodos();
        byte[] resultado = enlace.obtenerFoto(ID);
        if (resultado == null) {
            JOptionPane.showMessageDialog(rootPane, "La persona no tiene foto");
        } else {
            try {
                imgFoto = convertirImagen(resultado);
                Icon icono = new ImageIcon(imgFoto.getScaledInstance(JL_Foto.getWidth(), JL_Foto.getHeight(), Image.SCALE_DEFAULT));
                JL_Foto.setIcon(icono);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error al abrir la foto. \n" + ex);
            }
        }
    }
    private void JB_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_BuscarActionPerformed
        Metodos enlace = new Metodos();
        nomabus = JOptionPane.showInternalInputDialog(rootPane, "Nombre a Buscar?", "Buscando...", JOptionPane.QUESTION_MESSAGE);
        if (nomabus != null) {
            String[] resultado = enlace.Buscar(nomabus);

            if (resultado[0] == null) {
                JOptionPane.showMessageDialog(rootPane, "NO SE ENCONTRÓ A: " + nomabus.toUpperCase());
            } else {
                JL_ID2.setText(resultado[0]);
                JT_Nombre.setText(resultado[1]);
                JT_Apellido.setText(resultado[2]);
                JT_Domicilio.setText(resultado[3]);
                JT_Telefono.setText(resultado[4]);
                JT_Email.setText(resultado[5]);

                try {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MMM/yyyy");
                    Date fechanac = formato.parse(resultado[6]);
                    JD_DateChooser.setDate(fechanac);
                } catch (ParseException pex) {
                    Logger.getLogger(Captura.class.getName()).log(Level.SEVERE, null, pex);
                }

                JT_Edad.setText(resultado[8]);

                if (resultado[7].equals("Masculino")) {
                    JR_Masculino.setSelected(true);
                } else {
                    JR_Femenino.setSelected(true);
                }
            }
            
            // Error aqui
            mostrarFoto(Integer.parseInt(JL_ID2.getText()));
            // mostrarFoto(Integer.parseInt(JL_ID.getText()));
        }
    }//GEN-LAST:event_JB_BuscarActionPerformed

    private void JB_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_SalirActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
        System.out.println("ADIÓS");
    }//GEN-LAST:event_JB_SalirActionPerformed

    private Image convertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Iterator lector = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader ir = (ImageReader) lector.next();
        Object source = bais;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        ir.setInput(iis, true);
        ImageReadParam irp = ir.getDefaultReadParam();
        return ir.read(0, irp);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Agregar;
    private javax.swing.JButton JB_Buscar;
    private javax.swing.JButton JB_Eliminar;
    private javax.swing.JButton JB_Foto;
    private javax.swing.JButton JB_Modificar;
    private javax.swing.JButton JB_Salir;
    private com.toedter.calendar.JDateChooser JD_DateChooser;
    private javax.swing.JFileChooser JFCFoto;
    private javax.swing.JLabel JL_Apellido;
    private javax.swing.JLabel JL_Domicilio;
    private javax.swing.JLabel JL_Edad;
    private javax.swing.JLabel JL_Email;
    private javax.swing.JLabel JL_FechaNacimiento;
    private javax.swing.JLabel JL_Foto;
    private javax.swing.JLabel JL_ID;
    private javax.swing.JLabel JL_ID2;
    private javax.swing.JLabel JL_Nombre;
    private javax.swing.JLabel JL_Sexo;
    private javax.swing.JLabel JL_Telefono;
    private javax.swing.JPanel JP_Panel1;
    private javax.swing.JPanel JP_Panel2;
    private javax.swing.JPanel JP_Panel3;
    private javax.swing.JRadioButton JR_Femenino;
    private javax.swing.JRadioButton JR_Masculino;
    private javax.swing.JTextField JT_Apellido;
    private javax.swing.JTextField JT_Domicilio;
    private javax.swing.JTextField JT_Edad;
    private javax.swing.JTextField JT_Email;
    private javax.swing.JTextField JT_Nombre;
    private javax.swing.JTextField JT_Telefono;
    // End of variables declaration//GEN-END:variables
}
