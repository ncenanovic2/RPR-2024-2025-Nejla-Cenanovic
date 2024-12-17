package model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OsobaTest {
    @Test
    public void testNapuni() {
        OsobaModel model = new OsobaModel();
        model.napuni();

        assertEquals(2, model.dajSveOsobe().size());
        Osoba osoba1 = model.dajSveOsobe().get(0);
        assertEquals(1, osoba1.getId());
        assertEquals("Neko", osoba1.getIme());
        assertEquals("Nekic", osoba1.getPrezime());
        assertEquals("Neka adresa", osoba1.getAdresa());
        assertEquals("2509997123456", osoba1.getMaticniBroj());
        assertEquals(Uloga.STUDENT, osoba1.getUloga());

        Osoba osoba2 = model.dajSveOsobe().get(1);
        assertEquals(2, osoba2.getId());
        assertEquals("Neko 2", osoba2.getIme());
        assertEquals("Nekic 2", osoba2.getPrezime());
        assertEquals("Neka adresa 2", osoba2.getAdresa());
        assertEquals("2509997123456", osoba2.getMaticniBroj());
        assertEquals(Uloga.NASTAVNO_OSOBLJE, osoba2.getUloga());
    }@Test
    public void testAzurirajOsobuPostojecaOsoba() {
        OsobaModel model = new OsobaModel();
        model.napuni();

        Date noviDatumRodjenja = new Date(95, 11, 15);
        String poruka = model.azurirajOsobu(1, "NovoIme", null, "Nova adresa", noviDatumRodjenja, null, Uloga.NASTAVNO_OSOBLJE);

        assertEquals("Osoba je uspjesno azurirana!", poruka);

        Osoba osoba = model.dajOsobuPoId(1);
        assertEquals("NovoIme", osoba.getIme());
        assertEquals("Nekic", osoba.getPrezime()); // prezime nije promijenjeno
        assertEquals("Nova adresa", osoba.getAdresa());
        assertEquals(noviDatumRodjenja, osoba.getDatumRodjenja());
        assertEquals(Uloga.STUDENT, osoba.getUloga());
    }
    @Test
    public void testAzurirajOsobuNePostoji() {
        OsobaModel model = new OsobaModel();
        model.napuni();

        String poruka = model.azurirajOsobu(999, "NovoIme", null, null, null, null, null);

        assertEquals("Osoba nije pronadjena!", poruka);

        assertEquals(2, model.dajSveOsobe().size());
    }
    @Test
    public void testAzurirajOsobuSamoNekaPolja() {
        OsobaModel model = new OsobaModel();
        model.napuni();

        String poruka = model.azurirajOsobu(1, null, "NovoPrezime", null, null, "1111111111111", null);

        assertEquals("Osoba je uspjesno azurirana!", poruka);


        Osoba osoba = model.dajOsobuPoId(1);
        assertEquals("Neko", osoba.getIme()); // ime nije mijenjano
        assertEquals("NovoPrezime", osoba.getPrezime());
        assertEquals("Neka adresa", osoba.getAdresa()); // adresa nije mijenjana
        assertEquals("1111111111111", osoba.getMaticniBroj());
    }

}