import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class KundRegister {

    // En lista som håller kunderna
    private List<Kund> kunder;

    public KundRegister() {
        kunder = new ArrayList<>();
    }

    // Metod för att läsa in kunder från en fil (try-with-resources)
    public void läsKunderFrånFil() {
       Path path = Paths.get("src/gymmetsKunder.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            // Läs filen rad för rad
            while ((line = reader.readLine()) != null) {
                String[] delar = line.split(", ");
                // Kontrollera om det finns två delar
                if (delar.length == 2) {
                    // Läser in personnumret och namn från delarna
                    String personnummer = delar[0];
                    String namn = delar[1];

                    // Läser in nästa rad (datumet)
                    line = reader.readLine();
                    if (line != null) {
                        // Konverterar datumsträngen till en LocalDate-objekt
                        LocalDate senasteBetalningen = LocalDate.parse(line, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        kunder.add(new Kund(personnummer, namn, senasteBetalningen));
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Fel: Kunde inte öppna eller läsa filen 'gymmetsKunder.txt'");
        } catch (DateTimeParseException e) {
            System.err.println("Fel: Ogiltigt datumformat i filen 'gymmetsKunder.txt'. Förväntat format är 'yyyy-MM-dd'.");
        }
    }

    // Metod för att hitta en kund baserat på sökning (personnummer eller namn)
    public Kund hittaKund(String sökning) {
        for (Kund kund : kunder) {
            if (kund.getNamn().equalsIgnoreCase(sökning) || kund.getPersonnummer().equals(sökning)) {
                return kund;
            }
        }

        return null;
    }
}