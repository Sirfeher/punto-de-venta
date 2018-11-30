/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Feher
 */
public class SQLusuarios extends conexion {
    
    public boolean registrar(usuarios usr) throws ClassNotFoundException{
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        
        String sql = "INSERT INTO usuarios (usuario, password, nombre, id_tipo) VALUES(?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,usr.getUsuario());
            ps.setString(2,usr.getPassword());
            ps.setString(3,usr.getNombre());
            ps.setInt(4,usr.getId_tipo());
            ps.execute();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
    }
    
    public boolean login (usuarios usr) throws ClassNotFoundException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        
        String sql = "SELECT id_user, usuario, password, nombre, id_tipo FROM usuarios WHERE usuario = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();
             
            
            if (rs.next()){
                
                if (usr.getPassword().equals(rs.getString(3))){
                    
                    usr.setId(rs.getInt(1));
                    usr.setNombre(rs.getString(4));
                    usr.setId_tipo(rs.getInt(5));
                    return true;
                                         
                }else {
                    return false;
                }
                
            }
            
            return false;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
    }
    
    
     public int existeUsuario(String usuario) throws ClassNotFoundException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        
        String sql = "SELECT count(id_user) FROM usuarios WHERE usuario = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
             
            
            if (rs.next()){
                
                return rs.getInt(1);
            }
            
            return 1;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
            
            return 1;
        }
        
    }
            
            
    
}
