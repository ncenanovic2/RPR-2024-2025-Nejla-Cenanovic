import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class OsobaTest {
private static Osoba o;

    @BeforeAll
    static void beforeAll() {
        o=new Osoba("Mujo", "Mujic", "Adresa1", new Date(98,2,1));
    }

    @Test
    void dajInformacije() {
        Osoba o=new Osoba("Mujo", "Mujic", "Adresa1", new Date(98,2,1));
        String ocekivano= "Ime i prezime: Mujo Mujic";
        assertEquals(o.DajInformacije(),ocekivano);
    }

    @Test
    void ProvjeriMaticniBroj() {
        assertTrue(o.ProvjeriMaticniBroj("0103998123456"));
        assertFalse(o.ProvjeriMaticniBroj("0102998123456"));
        assertFalse(o.ProvjeriMaticniBroj("0203998123456"));
        assertFalse(o.ProvjeriMaticniBroj("0103997123456"));
    }
}