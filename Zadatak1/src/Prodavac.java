public class Prodavac implements I_Zdravlje{
    String ime, prezime;
    Integer brojStanda;
    String ID;
    public Prodavac(String ime, String prezime, int brojStanda, String ID) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojStanda = brojStanda;
        this.ID = ID;
    }
    public boolean Zdravlje() {
        return ID.endsWith("01");
    }
}
