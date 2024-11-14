
package database;

import java.sql.*;

public class Konekcija {
    
   private static Konekcija instance;
   private Connection connection;
   
   public static Konekcija getInstance(){
       if(instance == null)
           instance = new Konekcija();
       return instance;
   }
   
   private Konekcija(){
       try{
           String url ="jdbc:mysql://localhost:3306/zadatak_za_vezbanje1";
           connection = DriverManager.getConnection(url,"root","");
           connection.setAutoCommit(false);
       }catch(Exception e){
           e.printStackTrace();
       }
   }

    public Connection getConnection() {
        return connection;
    }
    
}
