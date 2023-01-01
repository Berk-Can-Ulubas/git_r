
/**
 * Repr�sentationen f�r alle g�ltigen Befehlsw�rter des Spiels,
 * zusammen mit einer Zeichenkette in einer bestimmten Sprachen.
 * 
 * @author  Michael K�lling und David J. Barnes
 * @version 2008.03.30
 */
public enum Befehlswort
{
    // Ein Wert f�r jedes Befehlswort, plus eines f�r nicht
    // erkannte Befehle
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?");
    
    // Das Befehlswort als Zeichenkette.
    private String befehlswort;
    
    /**
     * Initialisieren mit dem entsprechenden Befehlswort.
     * @param befehlswort Das Befehlswort als Zeichenkette.
     */
    Befehlswort(String befehlswort)
    {
        this.befehlswort = befehlswort;
    }
    
    /**
     * @return Das Befehlswort als Zeichenkette.
     */
    public String toString()
    {
        return befehlswort;
    }
}
