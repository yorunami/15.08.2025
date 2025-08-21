import java.util.Scanner;

// OOP Parkhaus-Simulation - Einfache Version
public class ParkhausSimulation {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parkhaus parkhaus = new Parkhaus();
        Ticket ticket = null;
        
        System.out.println("=== Parkhaus ===");
        
        while (true) {
            parkhaus.zeigeStatus();
            parkhaus.zeigeTicketStatus(ticket);
            System.out.println("1-Einfahren  2-Bezahlen  3-Ausfahren  0-Ende");
            System.out.print("Wahl: ");
            int wahl = scanner.nextInt();
            
            if (wahl == 1) {
                if (ticket != null) {
                    System.out.println("Sie haben bereits ein Ticket! Bitte erst ausfahren.");
                } else {
                    ticket = parkhaus.einfahren();
                }
            } else if (wahl == 2 && ticket != null) {
                parkhaus.bezahlen(ticket);
            } else if (wahl == 3 && ticket != null) {
                if (parkhaus.ausfahren(ticket)) {
                    ticket = null; // Nur bei erfolgreicher Ausfahrt
                }
            } else if (wahl == 0) {
                break;
            } else {
                System.out.println("Ungueltig oder kein Ticket!");
            }
        }
        scanner.close();
    }
}

// OOP-Klasse: Parkhaus mit Eigenschaften und Methoden
class Parkhaus {
    private int freePlaetze = 10;
    
    public void zeigeStatus() {
        System.out.println("Freie Plaetze: " + freePlaetze);
    }
    
    public void zeigeTicketStatus(Ticket ticket) {
        if (ticket == null) {
            System.out.println("Ticket: Keins vorhanden");
        } else if (ticket.isBezahlt()) {
            System.out.println("Ticket: Bezahlt - bereit zur Ausfahrt");
        } else {
            System.out.println("Ticket: Unbezahlt - bitte bezahlen");
        }
    }
    
    public Ticket einfahren() {
        if (freePlaetze > 0) {
            freePlaetze--;
            System.out.println("Einfahrt - Ticket ausgegeben");
            return new Ticket();
        } else {
            System.out.println("Parkhaus voll!");
            return null;
        }
    }
    
    public void bezahlen(Ticket ticket) {
        if (ticket.isBezahlt()) {
            System.out.println("Ticket bereits bezahlt!");
        } else {
            ticket.bezahlen();
            System.out.println("Bezahlt - CHF 2");
        }
    }
    
    public boolean ausfahren(Ticket ticket) {
        if (ticket.isBezahlt()) {
            freePlaetze++;
            System.out.println("Ausfahrt erfolgreich");
            return true; // Ausfahrt erfolgreich
        } else {
            System.out.println("Bitte zuerst bezahlen!");
            return false; // Ausfahrt fehlgeschlagen
        }
    }
}

// OOP-Klasse: Ticket mit Kapselung (private + public)
class Ticket {
    private boolean bezahlt = false;
    
    public void bezahlen() {
        bezahlt = true;
    }
    
    public boolean isBezahlt() {
        return bezahlt;
    }
}
