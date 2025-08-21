import java.util.Scanner;

// MathTool - Berechnet ggT und kgV von zwei Zahlen
public class mathtool {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String weiter = "j";
        
        System.out.println("=== MathTool ===");
        
        // Schleife bis Benutzer "n" eingibt
        while (weiter.equals("j")) {
            // Zahlen eingeben
            System.out.print("Erste Zahl: ");
            int a = scanner.nextInt();
            System.out.print("Zweite Zahl: ");
            int b = scanner.nextInt();
            
            // Berechnen und ausgeben
            int ggt = berechneGGT(a, b);
            int kgv = berechneKGV(a, b, ggt);
            
            System.out.println("ggT: " + ggt);
            System.out.println("kgV: " + kgv);
            
            // Weiter fragen
            System.out.print("Weiter? [j/n]: ");
            weiter = scanner.next();
            System.out.println();
        }
        
        scanner.close();
    }
    
    // Berechnet ggT
    public static int berechneGGT(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // Berechnet kgV mit der Formel: kgV = |a*b| / ggT
    public static int berechneKGV(int a, int b, int ggt) {
        return Math.abs(a * b) / ggt;
    }
}
