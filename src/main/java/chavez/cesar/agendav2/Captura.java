/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package chavez.cesar.agendav2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.Statement;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
// Regex
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.event.TableModelEvent;
/**
 *
 * @author depresionatom
 */

// Tal vez quitar el final
public final class Captura extends javax.swing.JInternalFrame {

    /**
     * Creates new form Captura
     * 
     */
    
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("awa/a.jpg"));
        return retValue;
    }

    Metodos enlace = new Metodos();
    Connection conexion = enlace.obtenerConexion();
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idc;
    
    
    public Captura() throws SQLException {
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
        JB_Modificar.setVisible(false);
        JB_Eliminar.setVisible(false);
        jLabel5.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel6.setVisible(false);
        jLabel4.setVisible(false);
        jTable1.setEnabled(false);
        consultar();


    }
    FileInputStream fis;
    int longitud;
    Image imgFoto;
    String nomabus;


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JFCFoto = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jP_Inputs = new javax.swing.JPanel();
        JL_ID = new javax.swing.JLabel();
        JL_Nombre = new javax.swing.JLabel();
        JT_Nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JL_Apellido = new javax.swing.JLabel();
        JT_Apellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JL_Domicilio = new javax.swing.JLabel();
        JT_Domicilio = new javax.swing.JTextField();
        JL_Telefono = new javax.swing.JLabel();
        JT_Telefono = new javax.swing.JTextField();
        JL_Email = new javax.swing.JLabel();
        JT_Email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JL_FechaNacimiento = new javax.swing.JLabel();
        JD_DateChooser = new com.toedter.calendar.JDateChooser();
        JL_Sexo = new javax.swing.JLabel();
        JR_Femenino = new javax.swing.JRadioButton();
        JR_Masculino = new javax.swing.JRadioButton();
        JL_Edad = new javax.swing.JLabel();
        JT_Edad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JL_ID2 = new javax.swing.JLabel();
        jP_Foto = new javax.swing.JPanel();
        JL_Foto = new javax.swing.JLabel();
        JB_Foto = new javax.swing.JButton();
        jP_Botones = new javax.swing.JPanel();
        JB_Agregar = new javax.swing.JButton();
        JB_Modificar = new javax.swing.JButton();
        JB_Buscar = new javax.swing.JButton();
        JB_Eliminar = new javax.swing.JButton();
        JB_Salir = new javax.swing.JButton();
        JB_Limpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        jP_Inputs.setOpaque(false);

        JL_ID.setText("ID");

        JL_Nombre.setText("Nombre");

        JT_Nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JT_NombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_NombreFocusLost(evt);
            }
        });

        jLabel2.setText("jLabel2");

        JL_Apellido.setText("Apellido");

        JT_Apellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_ApellidoFocusLost(evt);
            }
        });

        jLabel3.setText("jLabel3");

        JL_Domicilio.setText("Domicilio");

        JL_Telefono.setText("Telefono");

        JT_Telefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_TelefonoFocusLost(evt);
            }
        });

        JL_Email.setText("Email");

        JT_Email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_EmailFocusLost(evt);
            }
        });
        JT_Email.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                JT_EmailInputMethodTextChanged(evt);
            }
        });

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        JL_FechaNacimiento.setText("Fecha de nacimiento");

        JL_Sexo.setText("Sexo");

        JR_Femenino.setText("Femenino");

        JR_Masculino.setText("Masculino");

        JL_Edad.setText("Edad");

        JT_Edad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JT_EdadFocusLost(evt);
            }
        });
        JT_Edad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT_EdadActionPerformed(evt);
            }
        });

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jP_InputsLayout = new javax.swing.GroupLayout(jP_Inputs);
        jP_Inputs.setLayout(jP_InputsLayout);
        jP_InputsLayout.setHorizontalGroup(
            jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_InputsLayout.createSequentialGroup()
                .addContainerGap(312, Short.MAX_VALUE)
                .addComponent(JL_ID2)
                .addContainerGap())
            .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jP_InputsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jP_InputsLayout.createSequentialGroup()
                            .addComponent(JL_Sexo)
                            .addGap(18, 18, 18)
                            .addComponent(JR_Femenino)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JR_Masculino))
                        .addGroup(jP_InputsLayout.createSequentialGroup()
                            .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jP_InputsLayout.createSequentialGroup()
                                    .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JL_Telefono)
                                        .addComponent(JL_Email))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JT_Telefono)
                                        .addComponent(JT_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jP_InputsLayout.createSequentialGroup()
                                    .addComponent(JL_FechaNacimiento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(JD_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jP_InputsLayout.createSequentialGroup()
                                        .addComponent(JL_Domicilio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JT_Domicilio))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jP_InputsLayout.createSequentialGroup()
                                        .addComponent(JL_Apellido)
                                        .addGap(18, 18, 18)
                                        .addComponent(JT_Apellido))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jP_InputsLayout.createSequentialGroup()
                                        .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JL_Nombre)
                                            .addComponent(JL_ID))
                                        .addGap(18, 18, 18)
                                        .addComponent(JT_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jP_InputsLayout.createSequentialGroup()
                                    .addComponent(JL_Edad)
                                    .addGap(18, 18, 18)
                                    .addComponent(JT_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(24, 24, 24)
                            .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel3)))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jP_InputsLayout.setVerticalGroup(
            jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_InputsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_ID2)
                .addContainerGap(256, Short.MAX_VALUE))
            .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jP_InputsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(JL_ID)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JL_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JT_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JL_Apellido)
                        .addComponent(JT_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGap(9, 9, 9)
                    .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JL_Domicilio)
                        .addComponent(JT_Domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JL_Telefono)
                        .addComponent(JT_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JL_Email)
                        .addComponent(JT_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGap(12, 12, 12)
                    .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JL_FechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jP_InputsLayout.createSequentialGroup()
                            .addComponent(JD_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JR_Femenino)
                                .addComponent(JR_Masculino)
                                .addComponent(JL_Sexo))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jP_InputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JT_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JL_Edad)
                                .addComponent(jLabel6))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jP_Foto.setOpaque(false);

        JL_Foto.setBackground(new java.awt.Color(255, 255, 255));
        JL_Foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        JB_Foto.setIcon(new javax.swing.ImageIcon("/home/depresionatom/Escritorio/NotasClase}/agendaV2/src/main/java/Imagenes/camera.png")); // NOI18N
        JB_Foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_FotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_FotoLayout = new javax.swing.GroupLayout(jP_Foto);
        jP_Foto.setLayout(jP_FotoLayout);
        jP_FotoLayout.setHorizontalGroup(
            jP_FotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_FotoLayout.createSequentialGroup()
                .addGroup(jP_FotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_FotoLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(JL_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jP_FotoLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(JB_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jP_FotoLayout.setVerticalGroup(
            jP_FotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_FotoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(JL_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JB_Foto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jP_Botones.setOpaque(false);

        JB_Agregar.setIcon(new javax.swing.ImageIcon("/home/depresionatom/Escritorio/NotasClase}/agendaV2/src/main/java/Imagenes/plus.png")); // NOI18N
        JB_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AgregarActionPerformed(evt);
            }
        });

        JB_Modificar.setIcon(new javax.swing.ImageIcon("/home/depresionatom/Escritorio/NotasClase}/agendaV2/src/main/java/Imagenes/edit.png")); // NOI18N
        JB_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ModificarActionPerformed(evt);
            }
        });

        JB_Buscar.setIcon(new javax.swing.ImageIcon("/home/depresionatom/Escritorio/NotasClase}/agendaV2/src/main/java/Imagenes/search.png")); // NOI18N
        JB_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_BuscarActionPerformed(evt);
            }
        });

        JB_Eliminar.setIcon(new javax.swing.ImageIcon("/home/depresionatom/Escritorio/NotasClase}/agendaV2/src/main/java/Imagenes/delete.png")); // NOI18N
        JB_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_EliminarActionPerformed(evt);
            }
        });

        JB_Salir.setIcon(new javax.swing.ImageIcon("/home/depresionatom/Escritorio/NotasClase}/agendaV2/src/main/java/Imagenes/logout.png")); // NOI18N
        JB_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_SalirActionPerformed(evt);
            }
        });

        JB_Limpiar.setText("Limpiar");
        JB_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_LimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_BotonesLayout = new javax.swing.GroupLayout(jP_Botones);
        jP_Botones.setLayout(jP_BotonesLayout);
        jP_BotonesLayout.setHorizontalGroup(
            jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_BotonesLayout.createSequentialGroup()
                .addGroup(jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JB_Modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(JB_Agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JB_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(JB_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_BotonesLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JB_Limpiar)
                    .addComponent(JB_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jP_BotonesLayout.setVerticalGroup(
            jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_BotonesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JB_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JB_Agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Modificar)
                    .addComponent(JB_Eliminar))
                .addGap(18, 18, 18)
                .addComponent(JB_Salir)
                .addGap(24, 24, 24)
                .addComponent(JB_Limpiar))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Domicilio", "Telefono", "Email", "FechaNacimiento", "Sexo", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setIcon(new javax.swing.ImageIcon("/home/depresionatom/Escritorio/NotasClase}/agendaV2/src/main/java/chavez/cesar/agendav2/awa/a.jpg")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jP_Inputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jP_Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jP_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_Inputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jP_Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jP_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void consultar() throws SQLException{
        String query = "select * from personas";
        PreparedStatement instruccion = conexion.prepareStatement(query);
        rs = instruccion.executeQuery();
        Object[] persona = new Object[9];
        modelo =(DefaultTableModel) jTable1.getModel();
        modelo.getDataVector().removeAllElements();
        while (rs.next()){
            persona[0] = rs.getInt("Id");
            persona[1] = rs.getString("nombre");
            persona[2] = rs.getString("apellido");
            persona[3] = rs.getString("domicilio");
            persona[4] = rs.getString("telefono");
            persona[5] = rs.getString("email");
            persona[6] = rs.getString("fechanacimiento");
            persona[7] = rs.getString("sexo");
            persona[8] = rs.getInt("edad");
            
            modelo.addRow(persona);
        }
    }
    
    
    public void busquedaConsultar(String nombre) throws SQLException{
        String query = "select * from Personas where Nombre=?";
        PreparedStatement instruccion = conexion.prepareStatement(query);
        instruccion.setString(1, nombre);
        rs = instruccion.executeQuery();
        Object[] persona = new Object[9];
        modelo = (DefaultTableModel) jTable1.getModel();
        modelo.getDataVector().removeAllElements();
        while(rs.next()){
            persona[0] = rs.getInt("Id");
            persona[1] = rs.getString("nombre");
            persona[2] = rs.getString("apellido");
            persona[3] = rs.getString("domicilio");
            persona[4] = rs.getString("telefono");
            persona[5] = rs.getString("email");
            persona[6] = rs.getString("fechanacimiento");
            persona[7] = rs.getString("sexo");
            persona[8] = rs.getInt("edad");
            modelo.addRow(persona);
        }

    }
    public void limpiar(){
        try {
            JL_ID2.setText("");
            JT_Nombre.setText("");
            JT_Apellido.setText("");
            JT_Domicilio.setText("");
            JT_Edad.setText("");
            JT_Email.setText("");
            JR_Masculino.setSelected(false);
            JR_Femenino.setSelected(false);
            JL_Foto.setIcon(null);
            JD_DateChooser.setDate(null);
            JT_Telefono.setText("");
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            if (JB_Modificar.isVisible() && JB_Eliminar.isVisible()) {
                JB_Modificar.setVisible(false);
                JB_Eliminar.setVisible(false);
            }
        }
        // Cambiar lo del sexo y agregar grupo
        // Desactivar los botones
    }
        
    
    
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
    void mostrarBotones(){
        JB_Modificar.setVisible(true);
        JB_Eliminar.setVisible(true);
    }
    
    void ocultarBotones(){
        JB_Modificar.setVisible(false);
        JB_Eliminar.setVisible(false);
    }
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

    private void JB_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_LimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
        JB_Agregar.setEnabled(true);
    }//GEN-LAST:event_JB_LimpiarActionPerformed

    private void JB_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_SalirActionPerformed
        // TODO add your handling code here:

        System.exit(0);
        System.out.println("ADIÓS");
    }//GEN-LAST:event_JB_SalirActionPerformed

    private void JB_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_EliminarActionPerformed
        // TODO add your handling code here:
        Metodos enlace = new Metodos();
        int ID = Integer.parseInt(JL_ID2.getText());
        int nomabusPa = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quiere eliminar?");
        if (nomabusPa == 0) {
            try {
                enlace.Eliminar(ID);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "NO SE ENCONTRÓ A: " + ID);

            }
        }
    }//GEN-LAST:event_JB_EliminarActionPerformed

    private void JB_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_BuscarActionPerformed
        Metodos enlace = new Metodos();
        nomabus = JOptionPane.showInternalInputDialog(rootPane, "Nombre a Buscar?", "Buscando...", JOptionPane.QUESTION_MESSAGE);
        if (nomabus != null) {

            String[] resultado = null;
            int nVeces = enlace.vecesRepetidas(nomabus);
            // Hacer un metodo para checar si existe el usuario y si no mostrar wea
            String[] nombreExistencia = enlace.existenciaUsuario(nomabus);
            resultado = enlace.Buscar(nomabus);
            
            if(nVeces>1){
                try {
                    jTable1.setEnabled(true);
                    JOptionPane.showMessageDialog(rootPane, "Existen "+nVeces+" usuarios con el nombre igual \n Seleccione el que quiera en la tabla");
                    busquedaConsultar(nomabus);
                    MouseListener mouseListener = new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent me) {
                            int fila = jTable1.getSelectedRow();
                            System.out.println(fila);
                        }

                        @Override
                        public void mousePressed(MouseEvent me) {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }

                        @Override
                        public void mouseReleased(MouseEvent me) {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }

                        @Override
                        public void mouseEntered(MouseEvent me) {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }

                        @Override
                        public void mouseExited(MouseEvent me) {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }
                    };
                    MouseListener[] mouseListeners = jTable1.getMouseListeners();
                    System.out.println(Arrays.toString(mouseListeners)); 
                } catch (SQLException ex) {
                    Logger.getLogger(Captura.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if(nombreExistencia[0]==null){
                    JOptionPane.showMessageDialog(rootPane, "No se encontro a "+nomabus);
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
                    } finally {
                        // Si se encuentra entonces podemos mostrar el boton para modificar con los datos que se tienen y el ID
                        JB_Modificar.setVisible(true);
                        JB_Eliminar.setVisible(true);
                    }

                    JT_Edad.setText(resultado[8]);

                    if (resultado[7].equals("Masculino")) {
                        JR_Masculino.setSelected(true);
                    } else {
                        JR_Femenino.setSelected(true);
                    }
                    mostrarFoto(Integer.parseInt(resultado[0]));
                    // Error aqui
                    // mostrarFoto(Integer.parseInt(JL_ID.getText()));

                    // Si en la parte del ID no esta vacio, entonces se va a deshabilitar el boton
                    if (!JL_ID2.getText().isEmpty()) {
                        JB_Agregar.setEnabled(false);
                    }
                    try {
                        consultar();
                    } catch (SQLException ex) {
                        Logger.getLogger(Captura.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_JB_BuscarActionPerformed

    private void JB_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ModificarActionPerformed
        // TODO add your handling code here:
        Metodos enlace = new Metodos();
        String campo = "Campos:";

        // ID de la persona buscada a modificar
        int ID = Integer.parseInt(JL_ID2.getText());
        System.out.println(ID);
        String nombre = JT_Nombre.getText().toUpperCase();
        String apellido = JT_Apellido.getText().toUpperCase();
        String domicilio = JT_Domicilio.getText().toUpperCase();
        String telefono = JT_Telefono.getText().toUpperCase();
        String email = JT_Email.getText().toUpperCase();
        int edad = Integer.parseInt(JT_Edad.getText());
        String edadCampo = JT_Edad.getText();
        Date fecha = JD_DateChooser.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        String fechaNacimiento = sdf.format(fecha);
        String sexo;
        if (JR_Masculino.isSelected()) {
            sexo = "Masculino";
        } else {

            sexo = "Femenino";
        }

        // ---- Hacer una funcion para validar que si haya algo en el input -----

        // Todos estos ifs se pueden solucionar si se crea un objeto algo asi
        // {nombre: valorNombre,
            //  apellido: apellido,
            //  etc,
            //          }
        // Y con este hubieramos podido iterar, y si alguno de estos no estaba vacio
        // Entonces pudieramos agregar o concatenar el campo que esta vacio para que se muestre una alerta
        // Nombre
        if (nombre.isEmpty()) {
            System.out.println("Nombre vacio");
            campo = campo.concat("+Nombre");
        }
        // Apellido
        if (apellido.isEmpty()) {
            System.out.println("Apellido vacio");
            campo = campo.concat("+Apellido");
        }
        // Domicilio
        if (domicilio.isEmpty()) {
            System.out.println("Domicilio vacio");
            campo = campo.concat("+Domicilio");
        }
        // Telefono
        if (telefono.isEmpty()) {
            System.out.println("Telefono vacio");
            campo = campo.concat("+Telefono");
        }
        // Email
        if (email.isEmpty()) {
            System.out.println("Email vacio");
            campo = campo.concat("+Email");
        }
        // Faltaria la fecha la cual se puede sacar con la edad
        // Edad
        if (edadCampo.isEmpty()) {
            System.out.println("Edad vacio");
            campo = campo.concat("+Edad");
        }

        if ("Campos:".equals(campo)) {
            System.out.println(campo);
            // Si no hay ningun campo vacio
            // -- Entonces vamos a mandar una alerta la cual pregunte si realmente quiere agregar los datos.
            //       -- Si es asi entonces vamos a mandar a llamar al metood agregar, si no podemos hacer otra cosa
            // nomabus = JOptionPane.showInternalInputDialog(rootPane, "¿Seguro que quiere agregar?", "Buscando...", JOptionPane.QUESTION_MESSAGE);
            int nomabusPa = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres modificar al usuario?");
            // Saber que retorna si presiona
            // Si se presiona si, entonces retona un cero, si este no, devuelve un 1 o 2 de los botones
            System.out.println(nomabusPa);
            if (0 == nomabusPa) {
                // Metodos error
                try {
                    enlace.Modificar(nombre, apellido, domicilio, telefono, email, fechaNacimiento, sexo, edad, fis, longitud, ID);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(rootPane, "Operacion con error: " + e);
                } finally {
                    JOptionPane.showMessageDialog(rootPane, "Operacion con exito");
                }

                System.exit(0);
            } else {
                System.out.println("Nos cancela");
                System.exit(0);
                System.out.println("ADIÓS");
            }
        } else {
            // Split y luego popr
            JOptionPane.showMessageDialog(rootPane, "Faltan los siguientes campos a completar" + campo);
        }

        // Comprobacion de los input
        // --Primero se tiene que comprobar que todos tengan algo, entonces
        // ¿Como podemos comprobar que todods tengan algo?
        // ¿Podemos hacer un objeto y de ahi iterar para checar sus valores, y si los que son string no tienen nada en su posicion [0]
        // Entonces podemos devolver una alerta que diga que falta
        // __ Entonces podemos usar el metodo isEmpty para checar si no hay nada
    }//GEN-LAST:event_JB_ModificarActionPerformed

    private void JB_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AgregarActionPerformed
        // TODO add your handling code here:

        //
        String campo = "Campos:";
        String nombre = JT_Nombre.getText().toUpperCase();
        String apellido = JT_Apellido.getText().toUpperCase();
        String domicilio = JT_Domicilio.getText().toUpperCase();
        String telefono = JT_Telefono.getText().toUpperCase();
        String email = JT_Email.getText().toUpperCase();
        int edad = Integer.parseInt(JT_Edad.getText());
        String edadCampo = JT_Edad.getText();
        Date fecha = JD_DateChooser.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        String fechaNacimiento = sdf.format(fecha);
        String sexo;

        if(JR_Masculino.isSelected()){
            sexo = "Masculino";
        } else {

            sexo = "Femenino";
        }

        // Todos estos ifs se pueden solucionar si se crea un objeto algo asi
        // {nombre: valorNombre,
            //  apellido: apellido,
            //  etc,
            //          }
        // Y con este hubieramos podido iterar, y si alguno de estos no estaba vacio
        // Entonces pudieramos agregar o concatenar el campo que esta vacio para que se muestre una alerta
        // Nombre
        if(nombre.isEmpty()){
            System.out.println("Nombre vacio");
            campo = campo.concat("+Nombre");
        }
        // Apellido
        if (apellido.isEmpty()) {
            System.out.println("Apellido vacio");
            campo = campo.concat("+Apellido");
        }
        // Domicilio
        if (domicilio.isEmpty()) {
            System.out.println("Domicilio vacio");
            campo = campo.concat("+Domicilio");
        }
        // Telefono
        if (telefono.isEmpty()) {
            System.out.println("Telefono vacio");
            campo = campo.concat("+Telefono");
        }
        // Email
        if (email.isEmpty()) {
            System.out.println("Email vacio");
            campo = campo.concat("+Email");
        }
        // Faltaria la fecha la cual se puede sacar con la edad
        // Edad
        if(edadCampo.isEmpty()){
            System.out.println("Edad vacio");
            campo = campo.concat("+Edad");
        }

        if("Campos:".equals(campo)){
            System.out.println(campo);
            // Si no hay ningun campo vacio
            // -- Entonces vamos a mandar una alerta la cual pregunte si realmente quiere agregar los datos.
            //       -- Si es asi entonces vamos a mandar a llamar al metood agregar, si no podemos hacer otra cosa
            // nomabus = JOptionPane.showInternalInputDialog(rootPane, "¿Seguro que quiere agregar?", "Buscando...", JOptionPane.QUESTION_MESSAGE);

            // Luego podemos mandar a llamar las validaciones, si este estan bien, entonces podemos ya psaar al pregunta
            // de que si queremos agregar
            // Por el momento asi esta bien, luego hacemos una funcion para checar si las validaciones de los campos estan bien

            //@todo
            int nomabusPa = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quiere agregar?");
            // Saber que retorna si presiona
            // Si se presiona si, entonces retona un cero, si este no, devuelve un 1 o 2 de los botones
            System.out.println(nomabusPa);
            if(0 == nomabusPa){
                // Metodos error
                try {
                    Metodos enlace = new Metodos();
                    enlace.Agregar(nombre, apellido, domicilio, telefono, email, fechaNacimiento, sexo, edad, fis, longitud);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Operacion con error: "+e);
                } finally {
                    JOptionPane.showMessageDialog(rootPane, "Operacion con exito");
                }

                System.exit(0);
            } else {
                System.out.println("Nos cancela");
                System.exit(0);
                System.out.println("ADIÓS");
            }
        } else {
            // Split y luego pop
            JOptionPane.showMessageDialog(rootPane, "Faltan los siguientes campos a completar" + campo);
        }

        // Comprobacion de los input
        // --Primero se tiene que comprobar que todos tengan algo, entonces
        // ¿Como podemos comprobar que todods tengan algo?
        // ¿Podemos hacer un objeto y de ahi iterar para checar sus valores, y si los que son string no tienen nada en su posicion [0]
        // Entonces podemos devolver una alerta que diga que falta
        // __ Entonces podemos usar el metodo isEmpty para checar si no hay nada

    }//GEN-LAST:event_JB_AgregarActionPerformed

    private void JT_NombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_NombreFocusLost
        // TODO add your handling code here:
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("[0-9]");
        if (!JT_Nombre.getText().isEmpty()) {
            Matcher matcher = pattern.matcher(JT_Nombre.getText());
            boolean matchFound = matcher.find();
            System.out.println(matchFound);
            if (matchFound) {
                // En esta parte podemos poner un icono con una palomita
                jLabel2.setVisible(true);
                jLabel2.setText("No es un nombre");
                jLabel2.updateUI();
            } else {
                // Hacer algo con el ID que si detecta en la parte de agregar un ID, entonces no se va a agregar nada, solo se va a poder modificar e eliminar
                jLabel2.setVisible(true);
                jLabel2.setText("Correcto");
                jLabel2.updateUI();
            }
        }
    }//GEN-LAST:event_JT_NombreFocusLost

    private void JT_NombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_NombreFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_NombreFocusGained

    private void JT_EdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT_EdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT_EdadActionPerformed

    private void JT_EdadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_EdadFocusLost
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("[A-Za-z]");
        if (!JT_Edad.getText().isEmpty()) {
            Matcher matcher = pattern.matcher(JT_Edad.getText());
            boolean matchFound = matcher.find();
            System.out.println(matchFound);
            if (matchFound) {
                // En esta parte podemos poner un icono con una palomita
                jLabel6.setVisible(true);
                jLabel6.setText("No es una edad");
                jLabel6.updateUI();
            } else {
                // Hacer algo con el ID que si detecta en la parte de agregar un ID, entonces no se va a agregar nada, solo se va a poder modificar e eliminar
                jLabel6.setVisible(true);
                jLabel6.setText("Correcto");
                jLabel6.updateUI();
            }
        } else {
            jLabel6.setText("No hay una edad");
        }
    }//GEN-LAST:event_JT_EdadFocusLost

    private void JT_EmailInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_JT_EmailInputMethodTextChanged
        // TODO add your handling code here:
        if(!JT_Email.getText().isEmpty()){
            // Poner que coincida con el regex, si no coincide, entoncs modificaremos el label segun correspondiente
            System.out.println("aa");

        } else {
        }
    }//GEN-LAST:event_JT_EmailInputMethodTextChanged

    private void JT_EmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_EmailFocusLost
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        if(!JT_Email.getText().isEmpty()){
            Matcher matcher = pattern.matcher(JT_Email.getText());
            boolean matchFound = matcher.find();
            if (matchFound) {
                // En esta parte podemos poner un icono con una palomita
                jLabel5.setVisible(true);
                jLabel5.setText("Correcto");
            } else {
                // Hacer algo con el ID que si detecta en la parte de agregar un ID, entonces no se va a agregar nada, solo se va a poder modificar e eliminar
                jLabel5.setVisible(true);
                jLabel5.setText("No es correcto");
                jLabel5.updateUI();
            }
        }
    }//GEN-LAST:event_JT_EmailFocusLost

    private void JT_TelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_TelefonoFocusLost
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("[A-Za-z]");
        if (!JT_Telefono.getText().isEmpty()) {
            Matcher matcher = pattern.matcher(JT_Telefono.getText());
            boolean matchFound = matcher.find();
            System.out.println(matchFound);
            if (matchFound) {
                // En esta parte podemos poner un icono con una palomita
                jLabel4.setVisible(true);
                jLabel4.setText("No es un nombre");
                jLabel4.updateUI();
            } else {
                // Hacer algo con el ID que si detecta en la parte de agregar un ID, entonces no se va a agregar nada, solo se va a poder modificar e eliminar
                jLabel4.setVisible(true);
                jLabel4.setText("Correcto");
                jLabel4.updateUI();
            }
        }
    }//GEN-LAST:event_JT_TelefonoFocusLost

    // Validacion de apellido
    private void JT_ApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JT_ApellidoFocusLost
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("[0-9]");
        // Podemos ver si se tiene numeros, si este es asi entonces mostrar
        if (!JT_Apellido.getText().isEmpty()) {
            Matcher matcher = pattern.matcher(JT_Apellido.getText());
            boolean matchFound = matcher.find();
            System.out.println(matchFound);
            if (!matchFound) {
                // En esta parte podemos poner un icono con una palomita
                jLabel3.setVisible(true);
                jLabel3.setText("Correcto");
                jLabel3.updateUI();
            } else {
                // Hacer algo con el ID que si detecta en la parte de agregar un ID, entonces no se va a agregar nada, solo se va a poder modificar e eliminar
                jLabel3.setVisible(true);
                jLabel3.setText("No es un apellido");
                jLabel3.updateUI();
            }
        }
    }//GEN-LAST:event_JT_ApellidoFocusLost

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {

        } else {

            // Obtenemos los valores de la fila
            idc = Integer.parseInt((String) jTable1.getValueAt(fila, 0).toString());
            String id = (String) jTable1.getValueAt(fila, 0).toString();
            String Nombre = (String) jTable1.getValueAt(fila, 1);
            String apellido = (String) jTable1.getValueAt(fila, 2);
            String domicilio = (String) jTable1.getValueAt(fila, 3);
            String telefono = (String) jTable1.getValueAt(fila, 4);
            String email = (String) jTable1.getValueAt(fila, 5);
            //Fecha
            String fechaNacimiento = (String) jTable1.getValueAt(fila, 6);
            String date = fechaNacimiento;
            try {
                java.util.Date date2 = new SimpleDateFormat("dd/MMM/yyyy").parse(date);
                JD_DateChooser.setDate(date2);
            } catch (ParseException ex) {
                Logger.getLogger(Captura.class.getName()).log(Level.SEVERE, null, ex);
            }

            // -- Fin de fecha
            String sexo = (String) jTable1.getValueAt(fila, 7);
            String edad = (String) jTable1.getValueAt(fila, 8).toString();
            //Blob foto = (Blob) jTable1.getValueAt(fila, 9);
            JL_ID2.setText(id);
            JT_Nombre.setText(Nombre);
            JT_Apellido.setText(apellido);
            JT_Domicilio.setText(domicilio);
            JT_Telefono.setText(telefono);
            JT_Email.setText(email);
            JT_Edad.setText(edad);
            //JD_DateChooser.setDate(d1);
            if ("Masculino".equals(sexo)) {
                JR_Femenino.setSelected(false);
                JR_Masculino.setSelected(true);
            } else {
                JR_Femenino.setSelected(true);
                JR_Masculino.setSelected(false);

            }
            // Fotografia
            mostrarFoto(idc);
            JB_Agregar.setEnabled(false);
            mostrarBotones();
            //System.out.println(foto);
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
    private javax.swing.JButton JB_Limpiar;
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
    private javax.swing.JRadioButton JR_Femenino;
    private javax.swing.JRadioButton JR_Masculino;
    private javax.swing.JTextField JT_Apellido;
    private javax.swing.JTextField JT_Domicilio;
    private javax.swing.JTextField JT_Edad;
    private javax.swing.JTextField JT_Email;
    private javax.swing.JTextField JT_Nombre;
    private javax.swing.JTextField JT_Telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jP_Botones;
    private javax.swing.JPanel jP_Foto;
    private javax.swing.JPanel jP_Inputs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

