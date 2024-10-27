import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Double Plus(Double broj1, Double broj2) {
        return broj1+broj2;
    }
    public static Double Podijeljeno(Double broj1, Double broj2) throws Exception{
        if(broj2==0) throw new Exception("Nije dozvoljeno dijeljenje s nulom!");
        return (Math.round((broj1/broj2)*100)/100.0);
    }
    public static void main(String[] args) {
  System.out.println("Unesite operaciju ('plus' za sabiranje, 'podijeljeno' za dijeljenje: ");
        Scanner ulaz=new Scanner(System.in);
        String operacija;
        operacija=ulaz.nextLine();
        List<Double> brojevi=new ArrayList<Double>();
        Double broj;
        System.out.println("Unesite brojeve: " );
        while(true) {
            broj=ulaz.nextDouble();
            if(broj==-400) break;
            brojevi.add(broj);
        }
        Double rezultatPlus=0.0;
        Double rezultatPodijeljeno=brojevi.get(0);
        if(operacija.equals("plus")) {
            for(int i=0; i<brojevi.size();i++)
                rezultatPlus=Plus(rezultatPlus, brojevi.get(i));
            System.out.println("Konačni rezultat: "+rezultatPlus);
        }
        if(operacija.equals("podijeljeno")) {
            try {
for(int i=1; i<brojevi.size();i++)
    rezultatPodijeljeno=Podijeljeno(rezultatPodijeljeno, brojevi.get(i));
    System.out.println("Konačni rezultat: "+rezultatPodijeljeno);

            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}