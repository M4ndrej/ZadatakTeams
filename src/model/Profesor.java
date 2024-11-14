
package model;

import java.util.Objects;


public class Profesor {
    
    private int id;
    private String ime;
    private String prezime;
    private Zvanje zvanje;
    private String emailRadnika;

    public Profesor() {
    }

    public Profesor( String ime, String prezime, Zvanje zvanje, String emailRadnika) {
        
        this.ime = ime;
        this.prezime = prezime;
        this.zvanje = zvanje;
        this.emailRadnika = emailRadnika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(Zvanje zvanje) {
        this.zvanje = zvanje;
    }

    public String getEmailRadnika() {
        return emailRadnika;
    }

    public void setEmailRadnika(String emailRadnika) {
        this.emailRadnika = emailRadnika;
    }

    @Override
    public String toString() {
        return "Profesor{" + "ime=" + ime + ", prezime=" + prezime + ", zvanje=" + zvanje + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Profesor other = (Profesor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.emailRadnika, other.emailRadnika)) {
            return false;
        }
        return this.zvanje == other.zvanje;
    }
    
    
    
}
