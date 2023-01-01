/**
 * Eine Klasse, die die Posten in einer Auktion modelliert.
 * Ein Posten kann ein einzelner Gegenstand oder eine 
 * Zusammenstellung von Gegenst�nden sein.
 * @author David J. Barnes und Michael K�lling.
 * @version 2008.03.30
 */
public class Posten
{
    // eine eindeutige Nummer zur Identifikation dieses Postens
    private final int nummer;
    // eine Beschreibung dieses Postens
    private String beschreibung;
    // das aktuell h�chste Gebot f�r diesen Posten
    private Gebot hoechstesGebot;

    /**
     * Erzeuge einen Posten, mit Nummer und Beschreibung.
     * @param nummer die Postennummer.
     * @param beschreibung eine Beschreibung dieses Postens.
     */
    public Posten(int nummer, String beschreibung)
    {
        this.nummer = nummer;
        this.beschreibung = beschreibung;
    }

    /**
     * Ein Versuch, f�r diesen Posten zu bieten. Ein erfolgreiches
     * Gebot muss h�her sein als alle bisherigen Gebote.
     * @param gebot ein neues Gebot.
     * @return true falls erfolgreich, false sonst.
     */
    public boolean hoeheresGebot(Gebot gebot)
    {
        if((hoechstesGebot == null) ||
               (gebot.gibHoehe() > hoechstesGebot.gibHoehe())) {
            // dies ist das h�chste Gebot bis jetzt
            hoechstesGebot = gebot;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return Eine String-Darstellung der Details dieses Postens.
     */
    public String toString()
    {
        String details = nummer + ": " + beschreibung;
        if(hoechstesGebot != null) {
            details += "    Gebot: " + 
                       hoechstesGebot.gibHoehe();
        }
        else {
            details += "    (Kein Gebot)";
        }
        return details;
    }

    /**
     * @return die Nummer dieses Postens.
     */
    public int gibNummer()
    {
        return nummer;
    }

    /**
     * @return die Beschreibung dieses Postens.
     */
    public String gibBeschreibung()
    {
        return beschreibung;
    }

    /**
     * Liefere das h�chste Gebot f�r diesen Posten.
     * Das Ergebnis kann 'null' sein, wenn noch kein
     * Gebot abgegeben wurde.
     * @return das h�chste Gebot
     */
    public Gebot gibHoechstesGebot()
    {
        return hoechstesGebot;
    }
}
