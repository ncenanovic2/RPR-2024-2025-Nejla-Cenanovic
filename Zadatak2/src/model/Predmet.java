package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Predmet {
    private String naziv;
    private Double ECTS;
    public Predmet(String naziv, Double ECTS) {
        setNaziv(naziv);
        setECTS(ECTS);
    }

    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        if (naziv == null || naziv.length() < 5 || naziv.length() > 100) {
            throw new IllegalArgumentException("Naziv mora imati između 5 i 100 znakova.");
        }
        this.naziv = naziv;
    }

    public Double getECTS() {
        return ECTS;
    }
    public void setECTS(Double ECTS) {
        if (ECTS == null || ECTS < 5.0 || ECTS > 20.0) {
            throw new IllegalArgumentException("ECTS mora biti između 5.0 i 20.0.");
        }
        double prva_dec = ECTS * 10 % 10;
        if (prva_dec != 0 && prva_dec != 5) {
            throw new IllegalArgumentException("ECTS može imati samo 0 ili 5 kao prvu decimalu (npr. 7.0, 7.5).");
        }
        this.ECTS = ECTS;
    }
    @Override
    public String toString() {
        return "Predmet{" +
                "naziv='" + naziv + '\'' +
                ", ECTS=" + ECTS +
                '}';
    }
    public static List<Predmet> ucitajPredmeteIzXmlDatoteke(String putanjaDoDatoteke) throws Exception {
        List<Predmet> predmeti = new ArrayList<>();
        File xmlDatoteka = new File(putanjaDoDatoteke);

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(xmlDatoteka);

        doc.getDocumentElement().normalize();
        NodeList listaCvorova = doc.getElementsByTagName("predmet");

        for (int i = 0; i < listaCvorova.getLength(); i++) {
            Node cvor = listaCvorova.item(i);

            if (cvor.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) cvor;

                String naziv = element.getElementsByTagName("naziv").item(0).getTextContent();
                Double ECTS = Double.parseDouble(element.getElementsByTagName("ECTS").item(0).getTextContent());

                Predmet predmet = new Predmet(naziv, ECTS);
                predmeti.add(predmet);
            }
        }
        return predmeti;
    }
}
