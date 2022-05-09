/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chavez.cesar.agendav2;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author depresionatom
 */
public class Metodos {
    static final Logger login = Logger.getLogger(Metodos.class.getName());
    
    public Connection obtenerConexion(){
        
        Connection conexion = null;
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String miBase = "jdbc:ucanaccess://"+ System.getProperty("user.dir") + "//agendav2.accdb";
            conexion  = DriverManager.getConnection(miBase, "yo", "chocomilk");
        } catch (ClassNotFoundException fex) {
            login.log(Level.SEVERE, null, fex);
            JOptionPane.showMessageDialog(null,"ERROR. DRIVER. \n"+fex);
        } catch(SQLException ex){
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error. conexion. \n"+ex);
        }
        return conexion;
    }
    
public String[] Buscar(String nomabus){
       
        String[] resultado = new String[9];
        Connection conexion = obtenerConexion();
        try{
            String query = "select * from personas where Nombre=?";
            PreparedStatement instruccion = conexion.prepareStatement(query);
                instruccion.setString(1, nomabus);
                try{
                    ResultSet rs = instruccion.executeQuery();
                    // El next es para la ultima fila
                    while(rs.next()){
                        resultado[0]=rs.getString("id");
                        resultado[1]=rs.getString("Nombre");
                        resultado[2]=rs.getString("Apellido");
                        resultado[3]=rs.getString("Domicilio");
                        resultado[4]=rs.getString("Telefono");
                        resultado[5]=rs.getString("Email");
                        resultado[6]=rs.getString("FechaNacimiento");
                        resultado[7]=rs.getString("Sexo");
                        resultado[8]=rs.getString("Edad");
                    }

                    rs.close();

                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Exception: " + ex);
                }
                
        }catch(SQLException ex){
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);   
            
        }finally{
            try{
                conexion.close();
            }catch(SQLException ex){
                login.log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
        

    }
       
    public int vecesRepetidas(String nombre){
        int n=0;
        Connection conexion = obtenerConexion();
        try {
            String query = "select * from personas where Nombre=?";
            PreparedStatement instruccion = conexion.prepareStatement(query);
            instruccion.setString(1, nombre);
            try {
                ResultSet rs = instruccion.executeQuery();
                // El next es para la ultima fila
                while (rs.next()) {
                    n++;
                }
                rs.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Exception: " + ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                login.log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }
    
    public String[] existenciaUsuario(String nombre){
        String[] nombreExistencia = new String[1];
        Connection conexion = obtenerConexion();
        try {
            String query = "select * from personas where Nombre=?";
            PreparedStatement instruccion = conexion.prepareStatement(query);
            instruccion.setString(1, nombre);
            try {
                ResultSet rs = instruccion.executeQuery();
                // El next es para la ultima fila
                while (rs.next()) {
                    nombreExistencia[0] = rs.getString("Nombre");
                }

                rs.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Exception: " + ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                login.log(Level.SEVERE, null, ex);
            }
        }
        return nombreExistencia;
    }
    public void Agregar(String Nombre, String Apellido, String Domicilio, String Telefono, String Email, String FechaNac, String Sexo, int Edad, FileInputStream fis, int Longitud){
        
        Connection conexion = obtenerConexion();
        try {
            String query = "insert into Personas("
                    + "nombre, apellido, domicilio, telefono, email, fechanacimiento, sexo, edad, foto)"
                    + "values(?,?,?,?,?,?,?,?,?)";
            
            try (PreparedStatement instruccion = conexion.prepareStatement(query)) {
                instruccion.setString(1, Nombre);
                instruccion.setString(2, Apellido);
                instruccion.setString(3, Domicilio);
                instruccion.setString(4, Telefono);
                instruccion.setString(5, Email);
                instruccion.setString(6, FechaNac);
                instruccion.setString(7, Sexo);
                instruccion.setInt(8, Edad);
                instruccion.setBinaryStream(9,fis, Longitud);
                instruccion.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                login.log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    public void Modificar(String Nombre, String Apellido, String Domicilio, String Telefono, String Email, String FechaNac, String Sexo, int Edad, FileInputStream fis, int Longitud, int ID) throws SQLException{
        // Obtenemos la conexion de la base de datos
        Connection conexion = obtenerConexion();
        
        try {
            //Se tiene que
            if(Longitud != 0){
                String query = "UPDATE Personas set nombre=?, apellido=?, domicilio=?, telefono=?, email=?, fechanacimiento=?, sexo=?, edad=?, foto=? where id=?";
                try(PreparedStatement instruccion = conexion.prepareStatement(query)) {
                    // Colocamos los datos
                    // Ingresamos el id para actualizar las cosas
                    instruccion.setString(1, Nombre);
                    instruccion.setString(2, Apellido);
                    instruccion.setString(3, Domicilio);
                    instruccion.setString(4, Telefono);
                    instruccion.setString(5, Email);
                    instruccion.setString(6, FechaNac);
                    instruccion.setString(7, Sexo);
                    instruccion.setInt(8, Edad);
                    // El problema es la foto
                    instruccion.setBinaryStream(9, fis, Longitud);
                    // Aqui va 10
                    instruccion.setInt(10, ID);
                    System.out.println("Con foto");
                    int n = instruccion.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Datos actualizados");
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
            } else {
                String query = "UPDATE Personas set nombre=?, apellido=?, domicilio=?, telefono=?, email=?, fechanacimiento=?, sexo=?, edad=? where id=?";
                try ( PreparedStatement instruccion = conexion.prepareStatement(query)) {
                    
                    // Colocamos los datos
                    // Ingresamos el id para actualizar las cosas
                    instruccion.setString(1, Nombre);
                    instruccion.setString(2, Apellido);
                    instruccion.setString(3, Domicilio);
                    instruccion.setString(4, Telefono);
                    instruccion.setString(5, Email);
                    instruccion.setString(6, FechaNac);
                    instruccion.setString(7, Sexo);
                    instruccion.setInt(8, Edad);
                    instruccion.setInt(9, ID);
                    System.out.println("Sin foto");
                    int n = instruccion.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Datos actualizados");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                login.log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void Eliminar(int ID){
        Connection conexion = obtenerConexion();
        System.out.println(ID);
        try {
            String query = "delete from Personas where Id=?";
            try(PreparedStatement instruccion = conexion.prepareStatement(query)) {
                instruccion.setInt(1, ID);
                int n = instruccion.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario eliminado");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                login.log(Level.SEVERE, null, ex);
            }
        }
    }
    

    public byte[] obtenerFoto(int ID) {

        byte[] resultado = new byte[127];
        Connection conexion = obtenerConexion();
        try {
            String query = "select Foto from personas where ID=?";
            PreparedStatement instruccion = conexion.prepareStatement(query);

            instruccion.setInt(1, ID);
            try {
                ResultSet rs = instruccion.executeQuery();
                while (rs.next()) {
                    resultado = rs.getBytes("Foto");
                }
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Exception: " + ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                login.log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
    
    
    public ResultSet UpdateTable(){
        Connection conexion = obtenerConexion();
        try {
            String query = "select * from Personas";
            PreparedStatement instruccion = conexion.prepareStatement(query);
            ResultSet rs = instruccion.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    // Funcion para checar la validacion a la hora de agregar en el boton
    public void checkValidation(){
        
    }
}   
