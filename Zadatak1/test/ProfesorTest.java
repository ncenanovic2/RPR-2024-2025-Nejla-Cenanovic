import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ProfesorTest {
    @BeforeAll
    static void beforeAll() {
        profesor = new Profesor("Mujo", "Mujic", "Adresa1", new Date(85, 2, 3), 150, 2000, "0-07", "prof.dr", 100);
    }

    private static Profesor profesor;

    @Test
    void dajInformacije() {
        String ocekivano = "Profesor: prof.dr Mujo Mujic";
        assertEquals(ocekivano, profesor.DajInformacije());
    }
}