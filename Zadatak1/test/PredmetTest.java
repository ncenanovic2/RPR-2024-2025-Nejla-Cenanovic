import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PredmetTest {
    private static Profesor prof;


    @Test
    void provjeriMaticniBroj() {
        assertTrue(prof.ProvjeriMaticniBroj("0101999123456"));
        assertFalse(prof.ProvjeriMaticniBroj("3112991123456"));

    }

    @BeforeAll
    static void beforeAll() {
        prof = new Profesor("Profesor", "1", "", new Date(99, 0, 1), 150, 2000, "3-00", "red. prof. dr.", 50);

    }

    @org.junit.jupiter.api.Test
    void dajInformacije() {
        Profesor prof = new Profesor("Profesor", "1", "", new Date(99, 0, 1), 150, 2000, "3-00", "red. prof. dr.", 50);
        Predmet p = new Predmet("RPR", prof, null, 5.0);
        String ocekivaniRezultat = "Predmet: RPR, odgovorni profesor: Profesor: red. prof. dr. Profesor 1";
        assertEquals(p.DajInformacije(), ocekivaniRezultat);

    }
}