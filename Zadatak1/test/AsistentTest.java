import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AsistentTest {

    private static Asistent asistent;

    @BeforeAll
    static void beforeAll() {
        asistent = new Asistent(
                "Mujo",
                "Mujic",
                "Adresa1",
                new Date(98, 2, 1),
                40,
                2015,
                "Kancelarija1",
                "Laboratorija A",
                "Ponedjeljak 10-12"
        );
    }

    @Test
    void testKonstruktor() {
        // Provjeri da su naslijeđena polja ispravno inicijalizirana
        assertEquals("Mujo", asistent.ime);
        assertEquals("Mujic", asistent.prezime);
        assertEquals("Adresa1", asistent.adresa);
        assertEquals(1, asistent.datumRodjenja.getDate());  // Provjeri da je dan 1.
        assertEquals(2, asistent.datumRodjenja.getMonth());  // Provjeri da je mjesec mart (2).
        assertEquals(98, asistent.datumRodjenja.getYear());  // Provjeri godinu 1998.
        assertEquals(40, asistent.norma);
        assertEquals(2015, asistent.godinaZaposlenja);
        assertEquals("Kancelarija1", asistent.kancelarija);
        assertEquals("Laboratorija A", asistent.getLaboratorija());
        assertEquals("Ponedjeljak 10-12", asistent.getTermin());
    }

    @Test
    void getLaboratorija() {
        String ocekivano="Laboratorija A";
        assertEquals(ocekivano, asistent.getLaboratorija());
    }
    @Test
    void getTermin() {
        String ocekivano="Ponedjeljak 10-12";
        assertEquals(ocekivano, asistent.getTermin());
    }


}
