public class GymHantering {


    // Metod för att kontrollera medlemskapet för en kund
    public void kontrolleraMedlemskap(Kund kund) {
        if (kund != null) { // Kontrollera om kunden existerar
            if (kund.ärNuvarandeMedlem()) { // Nuvarande medlem
                System.out.println(kund.getNamn() + " är en nuvarande medlem.");
            } else { // Före detta medlem
                System.out.println(kund.getNamn() + " är en före detta medlem.");

            }
        }
    }
}



