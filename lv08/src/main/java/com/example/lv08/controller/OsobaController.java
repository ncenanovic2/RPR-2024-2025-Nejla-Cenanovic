package com.example.lv08.controller;

import com.example.lv08.model.Osoba;
import com.example.lv08.model.OsobaModel;
import com.example.lv08.model.Uloga;
import com.example.lv08.view.OsobaView;

import java.util.Date;
import java.util.List;

public class OsobaController {
    private OsobaModel model;
    private OsobaView view;


    public OsobaController(OsobaModel model, OsobaView view)
    {
        this.model = model;
        this.view = view;
    }
    public Osoba dajOsobuPoId(Integer id) {
        Osoba osoba = model.dajOsobuPoId(id);
        if (osoba == null) {
            view.setPoruka("Osoba nije pronadjena!");
        } else {
            view.setPoruka("Osoba pronađena: " + osoba);
        }
        return osoba;
    }



    public void azurirajIme(Integer id){
        try {
            model.azurirajOsobu(id, view.getUlazniTekst(), null, null, null, null, null);
            view.setPoruka("Ime je uspjesno azurirano!");
        }
        catch(Exception e){
            view.setPoruka("Greska: " + e.getMessage());
        }
    }
    public void dajOsobeIzTxtDatoteke(String filePath)
    {
        try
        {
            List<Osoba> osobe = Osoba.napuniOsobeIzTxtDatoteke(filePath);
            String poruka = "Osobe ucitane iz txt datoteke su:\n";
            for (Osoba osoba : osobe)
            {
                poruka += osoba.toString() + "\n";
            }
            view.setPoruka(poruka);
        }
        catch(Exception e)
        {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }
    public void dajOsobeIzXmlDatoteke(String filePath)
    {
        try
        {
            List<Osoba> osobe = Osoba.ucitajOsobeIzXmlDatoteke(filePath);
            String poruka = "Osobe ucitane iz xml datoteke su:\n";
            for (Osoba osoba : osobe)
            {
                poruka += osoba.toString() + "\n";
            }
            view.setPoruka(poruka);
        }
        catch(Exception e)
        {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }
}
