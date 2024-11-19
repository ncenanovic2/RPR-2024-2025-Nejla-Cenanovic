import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ProizvodTest {

    private static Proizvod p;

    @BeforeAll
    static void beforeAll() {
        Map<String, Integer> nutritivneVrijednosti = new HashMap<>();
        nutritivneVrijednosti.put("kalorije", 100);
        p = new Proizvod("BiH", nutritivneVrijednosti, 0.5);
    }

    @org.junit.jupiter.api.Test
    void getNutritivneVrijednosti() {
        assertEquals(1, p.nutritivneVrijednosti.size());
        assertTrue(p.nutritivneVrijednosti.values().contains(100));
        assertTrue(p.nutritivneVrijednosti.containsKey("kalorije"));
    }

    @org.junit.jupiter.api.Test
    void setNutritivneVrijednosti() {
        Map<String, Integer> novaMapa = new HashMap<>();
        novaMapa.put("kalorije", 200);
        novaMapa.put("masti", 10);
        p.setNutritivneVrijednosti(novaMapa);
        Map<String, Integer> nutritivne = p.getNutritivneVrijednosti();
        assertEquals(2, nutritivne.size());
        assertEquals(200, nutritivne.get("kalorije"));
        assertEquals(10, nutritivne.get("masti"));
    }

    @org.junit.jupiter.api.Test
    void getZemljaPorijekla() {
        assertEquals("BiH", p.getZemljaPorijekla());
    }

    @org.junit.jupiter.api.Test
    void setZemljaPorijekla() {
        p.setZemljaPorijekla("Njemačka");
        assertEquals("Njemačka", p.getZemljaPorijekla());
    }

    @org.junit.jupiter.api.Test
    void dajBrojKalorija() {
        Double brojKalorija = p.DajBrojKalorija();
        assertEquals(100.0, brojKalorija, 0.0001);
    }

    @org.junit.jupiter.api.Test
    void Zdravlje() {
        p = new Proizvod("BiH", new HashMap<>(), -1.0);
        assertTrue(p.Zdravlje());

        p = new Proizvod("BiH", new HashMap<>(), 1.5);
        assertFalse(p.Zdravlje());
    }
}
