
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Profesor;


public class ModelTabeleProfesor extends AbstractTableModel{
    
    private List<Profesor> listaProfesora;
    
    private String[] kolone = {"Ime","Prezime","Zvanje"};
    
    public ModelTabeleProfesor(List<Profesor> listaProfesora){
        this.listaProfesora = listaProfesora;
    }

    @Override
    public int getRowCount() {
        return listaProfesora.size();
    }

    @Override
    public int getColumnCount() {
        
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Profesor p = listaProfesora.get(rowIndex);
        return switch (columnIndex) {
        case 0 -> p.getIme();
        case 1 -> p.getPrezime();
        case 2 -> p.getZvanje();
        default -> "NA";
        };
    }

    public List<Profesor> getListaProfesora() {
        return listaProfesora;
    }
    
    
    
}
