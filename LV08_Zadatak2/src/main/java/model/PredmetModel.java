package model;

public class PredmetModel {
    private String naziv;
    private Double ECTS;

    public PredmetModel(String naziv, Double ECTS) {
        if (!isValidNaziv(naziv)) {
            throw new IllegalArgumentException("Naziv mora imati između 5 i 100 znakova.");
        }
        if (!isValidECTS(ECTS)) {
            throw new IllegalArgumentException("ECTS mora biti između 5.0 i 20.0 i prva decimala može biti samo 0 ili 5.");
        }
        this.naziv = naziv;
        this.ECTS = ECTS;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if (!isValidNaziv(naziv)) {
            throw new IllegalArgumentException("Naziv mora imati između 5 i 100 znakova.");
        }
        this.naziv = naziv;
    }

    public Double getECTS() {
        return ECTS;
    }

    public void setECTS(Double ECTS) {
        if (!isValidECTS(ECTS)) {
            throw new IllegalArgumentException("ECTS mora biti između 5.0 i 20.0 i prva decimala može biti samo 0 ili 5.");
        }
        this.ECTS = ECTS;
    }

    private boolean isValidNaziv(String naziv) {
        return naziv != null && naziv.length() >= 5 && naziv.length() <= 100;
    }

    private boolean isValidECTS(Double ECTS) {
        if (ECTS == null || ECTS < 5.0 || ECTS > 20.0) {
            return false;
        }
        double decimalPart = ECTS * 10 % 10;
        return decimalPart == 0 || decimalPart == 5;
    }
}