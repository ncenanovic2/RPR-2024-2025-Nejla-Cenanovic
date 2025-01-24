package com.example.lv08.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Predmet {
    private StringProperty ID;
    private StringProperty naziv;
    private StringProperty ECTS;

    public Predmet(String id, String naziv, String ECTS) {
        this.ID=new SimpleStringProperty(id);
        this.naziv=new SimpleStringProperty(naziv);
        this.ECTS=new SimpleStringProperty();
        setECTS(ECTS);
    }

    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getNaziv() {
        return naziv.get();
    }

    public StringProperty nazivProperty() {
        return naziv;
    }


    public void setNaziv(String naziv) {
        if (naziv == null || naziv.length() < 5 || naziv.length() > 100) {
            throw new IllegalArgumentException("Naziv predmeta mora imati između 5 i 100 karaktera.");
        }
        this.naziv.set(naziv);
    }

    public String getECTS() {
        return ECTS.get();
    }

    public StringProperty ECTSProperty() {
        return ECTS;
    }



    public void setECTS(String bodovi) {
        Double ECTS=Double.parseDouble(bodovi);
        if (ECTS < 5.0 || ECTS > 20.0) {
            throw new IllegalArgumentException("ECTS mora biti između 5.0 i 20.0.");
        }
        double fractionalPart=ECTS%1.0;
        if (fractionalPart != 0.0 && fractionalPart != 0.5) {
            throw new IllegalArgumentException("Prva decimalna cifra ECTS mora biti 0 ili 5.");
        }

        this.ECTS.set(bodovi);
    }
    @Override
    public String toString(){
        return "ID: "+getID()+" Naziv: "+getNaziv()+" ECTS: "+getECTS();
    }


}
