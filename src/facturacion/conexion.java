/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class conexion {

   
   
   
   private final String url = "jdbc:mysql://localhost/puntodeventa";
    PreparedStatement psPrepararSentencia;
    Connection con = null;
   

    
    public conexion() {
     try{  
         
         Class.forName("com.mysql.jdbc.Driver");
         
         con = (Connection) DriverManager.getConnection(url,"root","");
         if (con!=null){
            System.out.println("Conexión a base de datos facturacion. listo");
         }
      }
         catch(SQLException e)
         {
         System.out.println(e);
         }
         catch(ClassNotFoundException e)
         {
          System.out.println(e);
         }
    }
    
    public Connection getConexion(){
       return con;
        
    }
     
    public Connection conectado(){
      return con;
}

    public void desconectar(){
      con = null;
      System.out.println("conexion terminada");

    } 

    
}

/*
public class conexion {
    
    private final String base = "usuarios";
    private final String user = "test";
    private final String password = "password";
    private final String url = "jdbc:mysql://localhost/puntodeventa";
    private Connection con = null;
    
    
    public conexion() {
     try{  
         
         Class.forName("com.mysql.jdbc.Driver");
         
         con = (Connection) DriverManager.getConnection(url,"root","");
         if (con!=null){
            System.out.println("Conexión a base de datos facturacion. listo");
         }
      }
         catch(SQLException e)
         {
         System.out.println(e);
         }
         catch(ClassNotFoundException e)
         {
          System.out.println(e);
         }
    }
    
    public Connection conectado(){
      return con;
}

    
}
*/
/*
public class conexion {

   
   
   
   private final String url = "jdbc:mysql://localhost/puntodeventa";
    PreparedStatement psPrepararSentencia;
    java.sql.Connection con = null;
    
   

    
    public Connection getConexion() throws ClassNotFoundException {
     try{  
         
         Class.forName("com.mysql.jdbc.Driver");
         
         con = DriverManager.getConnection(url,"root","");
         if (con!=null){
            System.out.println("Conexión a base de datos facturacion. listo");
         }
      }
         catch(SQLException e)
         {
         System.out.println(e);
         }
       return (Connection) con;
     
     
    }
    

    
     
    public java.sql.Connection conectado(){
      return con;
}

    public void desconectar(){
      con = null;
      System.out.println("conexion terminada");

    } 

    
}
*/