
package database;

import model.Profesor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Angazovanje;
import model.Predmet;
import model.Zvanje;

public class DBBroker {

    public boolean unesiProfesora(Profesor p, Predmet predmet) {
        
        String upit = "insert into profesori(ime,prezime,zvanje,emailRadnika) values (?,?,?,?)";
        try{
            
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getIme());
            ps.setString(2,p.getPrezime());
            ps.setString(3, String.valueOf(p.getZvanje()));
            ps.setString(4, p.getEmailRadnika());
            
            System.out.println(upit);
            
            int ar = ps.executeUpdate();
            ResultSet gkey = ps.getGeneratedKeys();
            int profesorid = 0;
            if(gkey.next()){
                profesorid = gkey.getInt(1);
            }else{
                }
            
            String upit2 ="insert into angazovanje(profesorId,predmetId) values (?,?)";
            try{
            
                PreparedStatement ps2 = Konekcija.getInstance().getConnection().prepareStatement(upit2);
                ps2.setInt(1, profesorid);
                ps2.setInt(2, predmet.getId());
                ps2.executeUpdate();
     
               
                Konekcija.getInstance().getConnection().commit();

                

            }catch(Exception e){
                e.printStackTrace();
            }
            
            Konekcija.getInstance().getConnection().commit();
            return ar > 0;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }

    public List<Predmet> ucitajPredmete() {
        
        List<Predmet> listaPredmeta = new ArrayList<>();
        
        String upit = "select * from predmeti";
        try{
            
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String naziv = rs.getString("naziv");
                String kod = rs.getString("kod");
                int esp = rs.getInt("esp");
                
                Predmet p = new Predmet(naziv,kod,esp);
                p.setId(id);
                
                listaPredmeta.add(p);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaPredmeta;
        
    }

    public boolean unesiAngazovanje(Profesor p, Predmet predmet) {
        
        String upit ="insert into angazovanje(profesorId,predmetId) values (?,?)";
        try{
            
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, p.getId());
            ps.setInt(2, predmet.getId());
            
            System.out.println();
            int ar = ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            
            return ar > 0;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }

    public List<Profesor> ucitajProfesore() {
        
        List<Profesor> listaProfesora = new ArrayList<>();
        
        String upit = "select * from profesori";
        try(Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit)){
            
            while(rs.next()){

                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                Zvanje zvanje = Zvanje.valueOf(rs.getString("zvanje"));
                
                
                Profesor p = new Profesor(ime,prezime,zvanje,null);
                p.setId(rs.getInt("id"));
                listaProfesora.add(p);
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaProfesora;
    }

    public boolean obrisiProfesora(int red) {
        
        String upit ="delete from profesori where id = "+red;
        String upit2 = "delete from angazovanje where profesorId = "+red;
        try{
            try(Statement st2 = Konekcija.getInstance().getConnection().createStatement()){
                System.out.println(upit2);
                st2.executeUpdate(upit2);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            try(Statement st = Konekcija.getInstance().getConnection().createStatement()){
                System.out.println(upit);
                st.executeUpdate(upit);
                return true;
            }
            catch(Exception e){
                e.printStackTrace();
            }
            Konekcija.getInstance().getConnection().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
 
    }

    public List<Angazovanje> ucitajAngazovanja() {
        
        List<Angazovanje> listaAngazovanja = new ArrayList<>();
        String upit = "select * from angazovanje";
        try(Statement st = Konekcija.getInstance().getConnection().createStatement()){
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
                int id = rs.getInt("id");
                int profesorId = rs.getInt("profesorId");
                int predmetId = rs.getInt("predmetId");
                
                Angazovanje a = new Angazovanje(id,profesorId,predmetId);
                listaAngazovanja.add(a);
                Konekcija.getInstance().getConnection().commit();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaAngazovanja;
    }

    public boolean proveriAngazovanje(Profesor p, Predmet pre) {

        
        String upit = "select count(*) from angazovanje where profesorId = "+p.getId();
        String upit2 = "select * from angazovanje";
        
        try(Statement st2 = Konekcija.getInstance().getConnection().createStatement()){
            
            ResultSet rs2 = st2.executeQuery(upit2);
            while(rs2.next()){
                if(rs2.getInt("profesorId") == p.getId() && rs2.getInt("predmetId") == pre.getId()){
                    return false;
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try(Statement st = Konekcija.getInstance().getConnection().createStatement()){
            
            ResultSet rs = st.executeQuery(upit);
            if(rs.next()){
                if(rs.getInt(1) < 3){
                    return true;
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    
}
