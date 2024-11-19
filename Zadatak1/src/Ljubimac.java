import java.util.Date;

public abstract class Ljubimac implements Objekat {
    private String ime;
    private Date datumRodjenja;
    private String zdravstvenoStanje;

    public Ljubimac(String ime, Date datumRodjenja, String zdravstvenoStanje) {
        this.ime = ime;
        this.datumRodjenja = datumRodjenja;
        this.zdravstvenoStanje = zdravstvenoStanje;
    }

    public abstract String prikaziVrstu();

    public String PrikaziInformacije() {
        return ime + ": " + prikaziVrstu();
    }

    public String getIme() {
        return ime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public String getZdravstvenoStanje() {
        return zdravstvenoStanje;
    }
}
