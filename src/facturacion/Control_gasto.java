/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Feher
 */
public class Control_gasto extends conexion {

    
    
    public boolean gasto(Concepto concep) throws ClassNotFoundException{
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        
        String sql = "INSERT INTO gastos (id, concepto, cantidad) VALUES(?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sql);
            ps.setString(2,concep.getConcepto());
            ps.setString(3,concep.getCantidad());
           
            ps.executeUpdate();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
    }

    
    
}
