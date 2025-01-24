package com.example.lv08.model;


import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class PredmetModel {
    private static ObservableList<Predmet> predmeti;
    private static PredmetModel instance = null;

    public static PredmetModel getInstance() {
        if (instance == null) {
            instance = new PredmetModel();
        }
        return instance;
    }
    public static void removeInstance() {
        instance = null;
    }
    private static final String DATABASE_URL = "jdbc:sqlite:predmeti.db";
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    private PredmetModel(){
        predmeti=FXCollections.observableArrayList();
    }
    public static ObservableList<Predmet> dajSvePredmete(){
        return predmeti;
    }

    public static void kreirajTabeluAkoNePostoji() {
        String kreirajPredmetTabeluSql = """
            CREATE TABLE IF NOT EXISTS Predmet (
            id TEXT,
            naziv TEXT,
            ects TEXT,
            );
            """;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(kreirajPredmetTabeluSql);
            System.out.println("Tabela je kreirana ili vec postoji!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void napuniInicijalnimPodacima() {
        String insertSQL = """
            INSERT INTO Predmet (id, naziv, ects)
            VALUES (?, ?, ?);
            """;
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL))
        {
            pstmt.setString(1, "101");
            pstmt.setString(2, "Osnove elektrotehnike");
            pstmt.setString(3, "6.0");
            pstmt.executeUpdate();

            pstmt.setString(1, "212");
            pstmt.setString(2, "Diskretna matematika");
            pstmt.setString(3, "5.0");
            pstmt.executeUpdate();
            System.out.println("Ubaceni pocetni podaci!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void isprazniTabeluPredmet() {
        String upit = "DELETE FROM Predmet";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            int brojObrisanihRedova = stmt.executeUpdate(upit);
            System.out.println("Obrisani redovi tabele. Broj obrisanih redova: " + brojObrisanihRedova);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Predmet> dajSvePredmeteIzB() throws SQLException {
        List<Predmet> predmeti=new ArrayList<>();
        String upit="SELECT * FROM Predmeti";
        try(Connection connect=connect();
            Statement stat=connect.createStatement();
            ResultSet rs=stat.executeQuery(upit);){

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return predmeti;
    }

    public String azurirajPredmet(String id, String naziv, String bodovi){
        for(Predmet x: predmeti){
            if(id!=null && x.getID().equals(id)){
                if(naziv!=null){
                    x.setNaziv(naziv);
                }
                if(bodovi!=null){
                    x.setECTS(bodovi);
                }
                return "Predmet uspjesno azuriran.";
            }
        }
        return "Predmeta sa id: "+id+" ne postoji.";
    }

    /*public Double dajBodovePoNazivu(String naziv){
        for(Predmet x: predmeti){
            if(x.getNaziv().equals(naziv)){
                return x.getECTS();
            }
        }
        return null;
    }



    public String azurirajBodovePredmeta(String id, Double bodovi){
        for(Predmet x: predmeti){
            if(x.getID().equals(id) && bodovi!=null){ //ne znam koliko je potrebno ovo bodovi!=null
                x.setECTS(bodovi);
                return "Bodovi uspjesno azurirani.";
            }
        }
        return "Predmet sa id: "+id+" se ne nalazi u spisku predmeta.";
    }
    public String azurirajImePredmeta(String naziv, String noviNaziv){
        for(Predmet x: predmeti){
            if(x.getNaziv().equals(noviNaziv)){
                return "Postoji vec predmet sa takvim nazivom.";
            }
        }
        for(Predmet x: predmeti){
            if(x.getNaziv().equals(naziv)){
                x.setNaziv(noviNaziv);
                return "Ime uspjesno azurirano.";
            }
        }
        return "Ne postoji predmet.";
    }
    public String dodajPredmet(Predmet predmet){
        try {
            predmeti.add(predmet);
            return "Predmet uspjesno dodan.";
        } catch (Exception e) {
            return "Predmet nije dodan."; //myb ako se popuni lista
        }
    }
    public String dodajPredmet(String naziv, Double ects){
        try{
            Predmet predmet=new Predmet(naziv,ects);
            predmeti.add(predmet);
            return "Predmet uspjesno dodan.";
        } catch (Exception e) {
            return "Predmet nije dodan. Razlog: "+e.getMessage();
        }
    }
    public String obrisiPredmet(String naziv){
        Boolean obrisan=predmeti.removeIf(predmeti-> predmeti.getNaziv().equals(naziv));
        if(!obrisan){return "Predmet se ne nalazi u listi.";}
        return "Predmet " + naziv + " uspjesno izbrisan.";
    }
    */
    public void napuni(){
        predmeti.add(new Predmet("112","Osnove elektrotehnike", "6.0"));
        predmeti.add(new Predmet("125","Operativni sistemi", "5.0"));
        predmeti.add(new Predmet("213","Diskretna matematika", "5.0"));
    }
    public static final SimpleDateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy");

    public void  ucitajPredmeteIzTxtDokumenta(String putanja) throws IOException{
        predmeti=FXCollections.observableArrayList();
        BufferedReader reader=new BufferedReader(new FileReader(putanja));
        String linija;
        while((linija=reader.readLine())!=null){
            String[] predmetic=linija.split(",");
            if(predmetic.length==3){
                String id=predmetic[0];
                String ime=predmetic[1];
                String broj=predmetic[2];

                predmeti.add(new Predmet(id,ime,broj));
            }
        }
        reader.close();
    }
}

