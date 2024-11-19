import java.util.HashMap;
import java.util.Map;

public class Proizvod {
    protected String zemljaPorijekla;
    protected Map<String, Integer> nutritivneVrijednosti=new HashMap<>();
    Double koeficijentZdravlja;
    public Proizvod(String zemljaPorijekla, Map<String,Integer> nutritivneVrijednosti, Double koeficijentZdravlja) {
        this.zemljaPorijekla=zemljaPorijekla;
        this.nutritivneVrijednosti.putAll(nutritivneVrijednosti);
        this.koeficijentZdravlja=koeficijentZdravlja;
    }

    public Map<String,Integer> getNutritivneVrijednosti() {
        return nutritivneVrijednosti;
    }

    public void setNutritivneVrijednosti(Map<String,Integer> nutritivneVrijednosti) {
        this.nutritivneVrijednosti = nutritivneVrijednosti;
    }

    public String getZemljaPorijekla() {
        return zemljaPorijekla;
    }

    public void setZemljaPorijekla(String zemljaPorijekla) {
        this.zemljaPorijekla = zemljaPorijekla;
    }
    public Double DajBrojKalorija() {
        Double brojKalorija=0.0;
        for(Integer vrijednosti: nutritivneVrijednosti.values()) {
            brojKalorija+= vrijednosti;
        }
        return brojKalorija;
    }
    public boolean Zdravlje() {
        return koeficijentZdravlja<0;
    };
}
