
package model;


public class Angazovanje {
    
    private int id;
    private int profesorId;
    private int predmetId;

    public Angazovanje() {
    }

    public Angazovanje(int id, int profesorId, int predmetId) {
        this.id = id;
        this.profesorId = profesorId;
        this.predmetId = predmetId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public int getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(int predmetId) {
        this.predmetId = predmetId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Angazovanje other = (Angazovanje) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.profesorId != other.profesorId) {
            return false;
        }
        return this.predmetId == other.predmetId;
    }
    
    
    
    
}
