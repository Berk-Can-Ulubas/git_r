
/**
 * Repräsentationen für alle gültigen Befehlswörter des Spiels,
 * zusammen mit einer Zeichenkette in einer bestimmten Sprachen.
 * 
 * @author  Michael Kölling und David J. Barnes
 * @version 2008.03.30
 */
public enum Befehlswort
{
    // Ein Wert für jedes Befehlswort, plus eines für nicht
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
