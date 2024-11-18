import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class NastavnoOsobljeTest {
    public static NastavnoOsoblje o;

    @BeforeAll
    static void beforeAll() {
        o=new NastavnoOsoblje("Mujo", "Mujic", "Adresa1", new Date(98,3,2), 150, 2002, "3-33");
    }

    @Test
    void Konstruktor() {
     assertEquals("Mujo", o.ime);
     assertEquals("Mujic", o.prezime);
     assertEquals("Adresa1", o.adresa);
     assertEquals(98, o.datumRodjenja.getYear());
     assertEquals(3, o.datumRodjenja.getMonth());
     assertEquals(2, o.datumRodjenja.getDate());
     assertEquals(150, o.norma);
     assertEquals(2002, o.godinaZaposlenja);
     assertEquals("3-33", o.kancelarija);
    }

}