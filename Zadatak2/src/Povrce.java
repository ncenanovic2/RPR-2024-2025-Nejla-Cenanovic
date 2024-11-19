import java.util.Map;

public class Povrce extends Proizvod implements I_Zdravlje{
    String latinskiNaziv;
    public Povrce(String zemljaPorijekla, Map<String,Integer>nutritivneVrijednosti, Double koeficijentZdravlja,String latinskiNaziv) {
        super(zemljaPorijekla, nutritivneVrijednosti, koeficijentZdravlja);
        this.latinskiNaziv=latinskiNaziv;
    }
    public boolean Zdravlje(Double koeficijentZdravlja) {
        return DajBrojKalorija()<100&&(koeficijentZdravlja>0.5 && koeficijentZdravlja<0.7);
    }
}