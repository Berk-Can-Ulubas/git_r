import java.util.ArrayList;
import java.io.*;

/**
 * Die Klasse Datenbank bieten Möglichkeiten zum Speichern
 * von Unterhaltungsmedien. Eine Liste aller Medien
 * kann auf der Konsole ausgegeben werden.
 * 
 * Diese Version speichert die Daten in einem einfachen Format auf die Festplatte.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Datenbank
{
    private ArrayList<Medium> medien;

    /**
     * Erzeuge eine leere Datenbank.
     */
    public Datenbank()
    {
        medien = new ArrayList<Medium>();
    }

    /**
     * Erfasse das gegebene Medium in dieser Datenbank.
     * @param dasMedium das zu erfassende Medium.
     */
    public void erfasseMedium(Medium dasMedium)
    {
        medien.add(dasMedium);
    }

    /**
     * Gib eine Liste aller aktuell gespeicherten Medien
     * auf der Konsole aus.
     */
    public void auflisten()
    {
        for(Medium medium : medien)
        {
            medium.ausgeben();
        }
    }
    
    /**
     * Schreibe die grundlegenden Informationen aller Medien in die gegebene Datei.
     * @param Name der Datei, in der die Daten gespeichert werden.
     */
    public void schreibeGrundlegendeInformationen(String dateiname)
    {
        try {
            FileWriter writer = new FileWriter(dateiname);
            for(Medium medium : medien) {
                writer.write(medium.grundlegendeInformationen());
                writer.write('\n');
            }
            writer.close();
        }
        catch(IOException e) {
            System.err.println("Speichern in " + dateiname + "fehlgeschlagen.");
        }
    }
}
