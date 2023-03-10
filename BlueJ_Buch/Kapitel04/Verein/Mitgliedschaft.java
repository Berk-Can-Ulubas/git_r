/**
 * Speichert Informationen ?ber die Mitgliedschaft
 * eines Vereinsmitglieds.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Mitgliedschaft
{
    // Name des Mitglieds.
    private String name;
    // Der Monat seines Beitritts.
    private int monat;
    // Das Jahr seines Beitritts.
    private int jahr;

    /**
     * Konstruktor f?r Objekte der Klasse Mitgliedschaft.
     * @param name Der Name des Mitglieds.
     * @param monat Der Monat des Beitritts. (1 ... 12)
     * @param jahr Das Jahr des Beitritts.
     */
    public Mitgliedschaft(String name, int monat, int jahr)
        throws IllegalArgumentException
    {
        if(monat < 1 || monat > 12) {
            throw new IllegalArgumentException(
                "Monat " + monat + " ung?ltig. Muss im Bereich 1 ... 12 liegen.");
        }
        this.name = name;
        this.monat = monat;
        this.jahr = jahr;
    }
    
    /**
     * @return den Namen des Mitglieds.
     */
    public String gibName()
    {
        return name;
    }
    
    /**
     * @return den Monat des Beitritts.
     *         Ein Wert aus dem Bereich 1 ... 12
     */
    public int gibMonat()
    {
        return monat;
    }

    /**
     * @return Das Jahr des Beitritts.
     */
    public int gibJahr()
    {
        return jahr;
    }

    /**
     * @return Eine String-Darstellung dieser Mitgliedschaft.
     */
    public String toString()
    {
        return "Name: " + name +
               " beigetreten in Monat " +
               monat + " / " + jahr;
    }
}
