package com.example.lv08.model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.Date;

public class Osoba {
    private IntegerProperty id;
    private StringProperty ime, prezime, adresa;
    private ObjectProperty<Date> datumRodjenja;
    private StringProperty maticniBroj;
    private ObjectProperty<Uloga> uloga;

    public Osoba(Integer id,  String ime, String prezime, String adresa, Date datumRodjenja, String maticniBroj, Uloga uloga){
        this.id=new SimpleIntegerProperty(id);
        this.ime = new SimpleStringProperty();
        this.prezime = new SimpleStringProperty(prezime);
        this.adresa = new SimpleStringProperty(adresa);
        this.datumRodjenja = new SimpleObjectProperty<>(datumRodjenja); //ovo
        this.maticniBroj = new SimpleStringProperty();
        this.uloga = new SimpleObjectProperty<>(uloga);                 //ovo

        setIme(ime);
        setMaticniBroj(maticniBroj);
    }
    //PROBLEM JE OVDJE BIO!!!!!
    public Integer getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getIme() {
        return ime.get();
    }

    public StringProperty imeProperty() {
        return ime;
    }
    /*public boolean ProvjeriMaticniBroj(String maticniBroj)
    {
        boolean danIsti = datumRodjenja.getDate() == Integer.parseInt(maticniBroj.substring(0, 2)), mjesecIsti = datumRodjenja.getMonth() + 1 == Integer.parseInt(maticniBroj.substring(2, 4)), godinaIsta = datumRodjenja.getYear() + 900 == Integer.parseInt(maticniBroj.substring(4, 7));
        return (danIsti && mjesecIsti && godinaIsta);
    }*/
    public boolean ProvjeriMaticniBroj(String maticniBroj) {
        //interesantno
        //deprecated nazalost
     /*   Date datum=datumRodjenja.get();
        boolean danIsti = datum.getDate() == Integer.parseInt(maticniBroj.substring(0, 2));
        boolean mjesecIsti = datum.getMonth() + 1 == Integer.parseInt(maticniBroj.substring(2, 4));
        int godinaIzDatuma = datum.getYear() % 100;
        int godinaIzMaticnogBroja = Integer.parseInt(maticniBroj.substring(4, 6));
        boolean godinaIsta = godinaIzDatuma == godinaIzMaticnogBroja;
*/
       // return danIsti && mjesecIsti && godinaIsta;
        return true;
    }

    public void setIme(String ime) {
        if (ime == null || ime.length() < 2 || ime.length() > 50) {
            throw new IllegalArgumentException("Ime mora imati izmedju 2 i 50 znakova.");
        }
        this.ime.set(ime);

    }

    public String getPrezime() {

        return prezime.get();
    }

    public StringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getAdresa() {
        return adresa.get();
    }

    public StringProperty adresaProperty() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa.set(adresa);
    }

    public Date getDatumRodjenja() {
        return datumRodjenja.get();
    }

    public Property<Date> datumRodjenjaProperty() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja.set(datumRodjenja);
    }

    public String getMaticniBroj() {
        return maticniBroj.get();
    }

    public StringProperty maticniBrojProperty() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        if (maticniBroj == null || maticniBroj.trim().isEmpty() ||
                maticniBroj.length() != 13) {
            throw new IllegalArgumentException("Maticni broj mora imati tacno 13 karaktera");
        }
        else if(!ProvjeriMaticniBroj(maticniBroj)){
            throw new IllegalArgumentException("Maticni broj se ne poklapa sa datumom rodjenja!");
        }
        this.maticniBroj.set(maticniBroj);
    }

    public Uloga getUloga() {
        return uloga.get();
    }

    public ObjectProperty<Uloga> ulogaProperty() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga.set(uloga);
    }
    @Override
    public String toString() {
        return "Osoba{" +
                "id='" + getId() + '\'' +
                ", ime='" + getIme() + '\'' +
                ", prezime='" + getPrezime() + '\'' +
                ", adresa='" + getAdresa()+ '\'' +
                ", datumRodjenja=" + getDatumRodjenja() +
                ", maticniBroj='" + getMaticniBroj() + '\'' +
                ", uloga=" + getUloga() +
                '}';
    }

}
