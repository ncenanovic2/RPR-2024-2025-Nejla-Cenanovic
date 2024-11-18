import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
public static Student s;

    @BeforeAll
    static void beforeAll() {
        s=new Student("Suljo", "Suljic", "Adresa", new Date(99,2,3), "12345", 2, 10.0);
    }

    @Test
    void DajInformacije() {
        String ocekivano="Student: Suljo Suljic, broj indeksa: 12345";
        assertEquals(ocekivano, s.DajInformacije());
    }
}