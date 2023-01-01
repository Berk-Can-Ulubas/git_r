import java.util.ArrayList;

/**
 * Die Klasse Datenbank bieten Möglichkeiten zum Speichern
 * von Unterhaltungsmedien. Eine Liste aller Medien
 * kann auf der Konsole ausgegeben werden.
 * 
 * Diese Version speichert die Daten nicht im Dateisystem und
 * bietet keine Suchfunktion.
 * 
 * @author Michael Kölling und David J. Barnes
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
}
