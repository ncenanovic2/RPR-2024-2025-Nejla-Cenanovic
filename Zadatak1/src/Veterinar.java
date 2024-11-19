import java.util.ArrayList;
import java.util.List;

public class Veterinar implements Objekat {
    private String ime;
    private Specijalizacija specijalizacija;
    private List<Ljubimac> pregledi = new ArrayList<>();

    public Veterinar(String ime, Specijalizacija specijalizacija) {
        this.ime = ime;
        this.specijalizacija = specijalizacija;
    }

    public List<Ljubimac> getPregledi() {
        return pregledi;
    }

    public void PregledajLjubimca(Ljubimac ljubimac) throws ValidacijaVrsteException {
            if ((specijalizacija == Specijalizacija.Psi && ljubimac instanceof Pas) ||
                    (specijalizacija == Specijalizacija.Macke && ljubimac instanceof Macka)) {
                pregledi.add(ljubimac);
            } else {
                throw new ValidacijaVrsteException("Veterinar nije specijalizovan za ovu vrstu ljubimca.");
            }
    }

    @Override
    public String PrikaziInformacije() {
        return "Veterinar: " + ime;
    }
}
