package model;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OsobaTest {

    @Test
    void testOsobaIspravnoKreirana() throws ParseException {
        Date datumRodjenja = Osoba.dateFormat.parse("2000-02-05");
        Osoba osoba = new Osoba(1, "Neko", "Nekić", "Adresa 123", datumRodjenja, "0502000123456", Uloga.STUDENT);
        assertEquals("Neko", osoba.getIme());
        assertEquals("Nekić", osoba.getPrezime());
        assertEquals("Adresa 123", osoba.getAdresa());
        assertEquals(datumRodjenja, osoba.getDatumRodjenja());
        assertEquals("0502000123456", osoba.getMaticniBroj());
        assertEquals(Uloga.STUDENT, osoba.getUloga());
    }

    @Test
    void testNeispravnoIme() {
        Date datumRodjenja = new Date();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Osoba(2, "A", "Nekić", "Adresa 123", datumRodjenja, "0101000500011", Uloga.STUDENT));
        assertEquals("Ime mora imati izmedju 2 i 50 znakova.", exception.getMessage());
    }

    @Test
    void testMaticniBrojNemaIspravnuDuzinu() {
        Date datumRodjenja = new Date();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Osoba(3, "Ivan", "Ivanović", "Adresa 456", datumRodjenja, "12345", Uloga.STUDENT));
        assertEquals("Matični broj mora imati 13 cifara!", exception.getMessage());
    }

    @Test
    void testMaticniBrojNepodudaranSaDatumomRodjenja() {
        Date datumRodjenja = new Date(100, 0, 1); // 2000-01-01
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Osoba(4, "Neko", "Nekić", "Adresa 789", datumRodjenja, "0201000500011", Uloga.STUDENT));
        assertEquals("Maticni broj se ne poklapa sa datumom rodjenja!", exception.getMessage());
    }

    @Test
    void testNeispravnaPutanjaDoTxtDatoteke() {
        IOException exception = assertThrows(IOException.class, () ->
                Osoba.ucitajOsobeIzTxtDatoteke("neispravna/putanja.txt"));
        assertTrue(exception.getMessage().contains("neispravna/putanja.txt"));
    }
}