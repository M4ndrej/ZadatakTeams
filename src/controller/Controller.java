
package controller;

import database.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.Angazovanje;
import model.Predmet;
import model.Profesor;
import model.Radnik;

public class Controller {
    
    private DBBroker dbb;
    

    public Radnik login(String email, String lozinka) {
        for(Radnik r: listaRadnika){
            if(r.getEmail().equals(email) && r.getLozinka().equals(lozinka)){
                return r;
            }
        }
        
        return null;
    }
    
    private List<Radnik> listaRadnika = new ArrayList<>();
    
    public Controller(){
        
        dbb = new DBBroker();
        
        Radnik r1 = new Radnik(1,"Andrej","Maksimovic","mandrej","mandrej");
        Radnik r2= new Radnik(2,"Kristina","Petrovic","kika","kika");
        Radnik r3 = new Radnik(3,"Milan","Miletic","miki","miki");
        
        listaRadnika.add(r1);
        listaRadnika.add(r2);
        listaRadnika.add(r3);
        
    }
    
    private static Controller instance;
    
    public static Controller getInstance(){
        if(instance ==  null)
            instance = new Controller();
        return instance;
    }

    public List<Radnik> getListaRadnika() {
        return listaRadnika;
    }

    public void setListaRadnika(List<Radnik> listaRadnika) {
        this.listaRadnika = listaRadnika;
    }

    public boolean unesiProfesora(Profesor p, Predmet predmet) {
        return dbb.unesiProfesora(p, predmet);
    }

    
    public List<Predmet> ucitajPredmete() {
        return dbb.ucitajPredmete();
    }

   

    public List<Profesor> ucitajProfesore() {
        return dbb.ucitajProfesore();
    }

    public boolean obrisiProfesora(int red) {
        
        return dbb.obrisiProfesora(red);
    }

    public List<Angazovanje> ucitajAngazovanja() {
        return dbb.ucitajAngazovanja();
    }

    public boolean unesiAngazovanje(Profesor p, Predmet pre) {
        return dbb.unesiAngazovanje(p, pre);
    }

    public boolean proveriAngazovanje(Profesor p,Predmet pre) {
        return dbb.proveriAngazovanje(p,pre);
    }

   

   

   
   


   
    
    
}
