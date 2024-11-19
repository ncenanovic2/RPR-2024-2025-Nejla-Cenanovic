import java.util.Date;

public class Pas extends Ljubimac {
    private VrstaPsa vrsta;

    public Pas(String ime, Date datumRodjenja, String zdravstvenoStanje, VrstaPsa vrsta) {
        super(ime, datumRodjenja, zdravstvenoStanje);
        this.vrsta = vrsta;
    }

    @Override
    public String prikaziVrstu() {
        return vrsta.toString();
    }
}