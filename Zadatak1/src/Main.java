import java.util.Scanner;
public class Main {
    public static boolean DaLiJeProst(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        int n;
        do {
            System.out.println("Unesite broj n: ");
            Scanner ulaz = new Scanner(System.in);
            n = ulaz.nextInt();
            if (n > 500) {
                System.out.println("Uneseni broj je prevelik!");
            }
            else if(n<=500) {
                System.out.println("Prosti brojevi: ");
                for (int i = 2; i <= 2 * n; i++) {
                    if (DaLiJeProst(i)) System.out.print(i+" ");
                }
                break;
            }
        } while (n>2);
        if(n<2) System.out.println("Nije moguće izvršiti izračunavanje prostih brojeva.");
    }
}
