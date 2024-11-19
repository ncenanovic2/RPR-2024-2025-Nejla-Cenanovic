import java.util.Map;

public class Meso extends Proizvod implements I_Zdravlje{
    String vrsta;
    public Meso(String zemljaPorijekla, Map<String,Integer> nutritivneVrijednosti, Double koeficijentZdravlja, String vrsta) {
        super(zemljaPorijekla, nutritivneVrijednosti, koeficijentZdravlja);
        this.vrsta=vrsta;
    }
    @Override
    public Double DajBrojKalorija() {
        Double brojKalorija=0.0;
        for(Integer vrijednosti: nutritivneVrijednosti.values()) {
            brojKalorija+= vrijednosti;
        }
        return brojKalorija*1.2;
    }
    public boolean Zdravlje() {
        return koeficijentZdravlja>0.95;
    }
}
