import java.util.Map;

public class Voce extends Proizvod implements I_Zdravlje{
    private String latinskiNaziv;
    public Voce(String zemljaPorijekla, Map<String,Integer> nutritivneVrijendosti,Double koeficijentZdravlja, String latinskiNaziv){
        super(zemljaPorijekla,nutritivneVrijendosti, koeficijentZdravlja);
        this.latinskiNaziv=latinskiNaziv;
    }
    public boolean Zdravlje(){
        return DajBrojKalorija()<50 && koeficijentZdravlja>0.75;
    }
}
