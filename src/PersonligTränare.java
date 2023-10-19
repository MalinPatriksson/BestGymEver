import java.io.*;

public class PersonligTränare {

    private String träningsFilnamn;

    // Konstruktor som tar emot filnamnet
    public PersonligTränare(String filnamn) {
        this.träningsFilnamn = filnamn;
    }

    // Metod för att spara träningsbesök i PT-filen, append för att spara besöken i filen
    public void sparaTräningsBesök(String personnummer, String namn, String träningsdatum) {
        try (FileWriter writer = new FileWriter(träningsFilnamn, true);
             PrintWriter print = new PrintWriter(new BufferedWriter(writer))) {
            print.println("\n" + namn + ", " + personnummer + "\nTräningsdatum: " + träningsdatum);

        } catch (IOException e) {
            System.err.println("Fel: Misslyckades med att spara träningsbesöket i filen");

        }
    }
}
