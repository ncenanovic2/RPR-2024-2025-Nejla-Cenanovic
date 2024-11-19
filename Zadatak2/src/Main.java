import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        //voce
        Map<String, Integer> nutritivneVrijednostiVoca = new HashMap<>();
        nutritivneVrijednostiVoca.put("Masti", 0);
        nutritivneVrijednostiVoca.put("Ugljikohidrati", 5);
        nutritivneVrijednostiVoca.put("Proteini", 5);
        nutritivneVrijednostiVoca.put("Vlakna", 10);
        nutritivneVrijednostiVoca.put("Vitamini", 20);
        Voce v = new Voce("Bosna i Hercegovina", nutritivneVrijednostiVoca, 0.2, "Malus");
        System.out.println("Broj kalorija voca: " + v.DajBrojKalorija());
        System.out.println("Zdravlje: " + v.Zdravlje());
//povrce
        Map<String, Integer> nutritivneVrijednostiPovrca = new HashMap<>();
        nutritivneVrijednostiPovrca.put("Masti", 0);
        nutritivneVrijednostiPovrca.put("Ugljikohidrati", 15);
        nutritivneVrijednostiPovrca.put("Proteini", 10);
        nutritivneVrijednostiPovrca.put("Vlakna", 10);
        nutritivneVrijednostiPovrca.put("Vitamini", 5);
        Povrce p = new Povrce("Bosna i Hercegovina", nutritivneVrijednostiPovrca, 0.6, "Solanum tuberosum");
        System.out.println("Broj kalorija povrca: " + p.DajBrojKalorija());
        System.out.println("Zdravlje: " + p.Zdravlje());
        //meso
        Map<String, Integer> nutritivneVrijednostiMesa = new HashMap<>();
        nutritivneVrijednostiMesa.put("Masti", 15);
        nutritivneVrijednostiMesa.put("Ugljikohidrati", 10);
        nutritivneVrijednostiMesa.put("Proteini", 20);
        nutritivneVrijednostiMesa.put("Vlakna", 10);
        nutritivneVrijednostiMesa.put("Vitamini", 10);
        Meso m = new Meso("Bosna i Hercegovina", nutritivneVrijednostiMesa, 0.6, "piletina");
        System.out.println("Broj kalorija mesa: " + m.DajBrojKalorija());
        System.out.println("Zdravlje: " + m.Zdravlje());
        //prodavac
        Prodavac p1 = new Prodavac("Mujo", "Mujic", 12, "12301");
        System.out.println("Zdravlje prodavaca: " + p1.Zdravlje());
    }
}

