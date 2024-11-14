
package view;

import controller.Controller;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Angazovanje;
import model.Predmet;
import model.Profesor;


public class ModelTabeleAngazovanja extends AbstractTableModel{
    
    List<Angazovanje> listaAngazovanja;
    private String[] kolone = {"Profesor","Predmet"};
    
    public ModelTabeleAngazovanja(List<Angazovanje> lista){
        this.listaAngazovanja = lista;
    }
    

    @Override
    public int getRowCount() {
        return listaAngazovanja.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Angazovanje a = listaAngazovanja.get(rowIndex);
        List<Profesor> listaProfesora = Controller.getInstance().ucitajProfesore();
        String imePrezime = null, predmet = null;
        for(Profesor p: listaProfesora){
            if(p.getId() == a.getProfesorId()){
                imePrezime = p.getIme() + " " + p.getPrezime();
                break;
            } 
        }
        List<Predmet> listaPredmeta = Controller.getInstance().ucitajPredmete();
        
        for(Predmet p: listaPredmeta){
            if(p.getId() == a.getPredmetId()){
                predmet = p.getNaziv();
                break;
            }
        }
        return switch(columnIndex){
        case 0 -> imePrezime;
        case 1 -> predmet;
        default -> "NA";
        };
    }
    
    public  void dodajAngazovanje(Angazovanje a){
        listaAngazovanja.add(a);
        fireTableDataChanged();
    }
    
}
