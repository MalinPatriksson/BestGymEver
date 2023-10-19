import java.util.Scanner;

public class Huvudprogram {

    Huvudprogram() {
        // Skapar instanser av klasserna
        GymHantering gymHantering = new GymHantering();
        KundRegister kundRegister = new KundRegister();
        PersonligTränare PT = new PersonligTränare("PT.txt");

        //Läser in kund från fil
        kundRegister.läsKunderFrånFil();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ange namn eller personnummer (0 för att avsluta): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("0")) {
                break;
            }

            // Hitta kunden i filen baserat på användarens inmatning
            Kund kund = kundRegister.hittaKund(input);

            if (kund != null) { //Nuvarande
                gymHantering.kontrolleraMedlemskap(kund);

                if (kund.ärNuvarandeMedlem()) { //Nuvarande kund som sparas i PT_fil.
                    kund.loggaTräningsBesök(PT); // Logga träningsbesök för kunden och sparar i PT-filen

                } else {
                    // Om personen är en före detta kund
                }

            } else { //Obehörig
                System.out.println("Ingen matchning hittades, personen är obehörig");

            }
        }
        scanner.close();
    }




    public static void main(String[] args) {
        Huvudprogram h = new Huvudprogram();


    }
}
