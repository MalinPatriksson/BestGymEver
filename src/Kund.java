import java.time.LocalDate;


public class Kund {
    private String personnummer;
    private String namn;
    private LocalDate senasteBetalning;

    // Konstruktor för att skapa en kund
    public Kund(String personnummer, String namn, LocalDate senasteBetalning) {
        this.personnummer = personnummer;
        this.namn = namn;
        this.senasteBetalning = senasteBetalning;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public String getNamn() {
        return namn;
    }

    // Metod för att kontrollera om kunden är en nuvarande medlem
    public boolean ärNuvarandeMedlem() {
        LocalDate idag = LocalDate.now();
        LocalDate ettÅrSedan = idag.minusYears(1);
        return senasteBetalning.isAfter(ettÅrSedan);
    }
    // Metod för att logga träningsbesök och spara det till PT
    public void loggaTräningsBesök (PersonligTränare PT) {
        String träningsDatum = LocalDate.now().toString();
        PT.sparaTräningsBesök(personnummer, namn, träningsDatum);
    }
}
