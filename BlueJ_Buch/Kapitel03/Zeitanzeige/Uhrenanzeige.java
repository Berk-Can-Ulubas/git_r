
/**
 * Die Klassen Uhrenanzeige implementiert die Anzeige einer Digitaluhr.
 * Die Anzeige zeigt Stunden und Minuten. Der Anzeigebereich reicht von
 * 00:00 (Mitternacht) bis 23:59 (eine Minute vor Mitternacht).
 *
 * Eine Uhrenanzeige sollte min?tlich "Taktsignale" (?ber die Operation
 * "taktsignalGeben") erhalten, damit sie die Anzeige aktualisieren 
 * kann. Dies geschieht, wie man es bei einer Uhr erwartet: Die 
 * Stunden erh?hen sich, wenn das Minutenlimit einer Stunde erreicht
 * ist.
 * 
 * @author Michael K?lling und David J. Barnes
 * @version 2008.03.30
 */
public class Uhrenanzeige
{
    private Nummernanzeige stunden;
    private Nummernanzeige minuten;
    private String zeitanzeige;    // simuliert die tats?chliche Anzeige
    
    /**
     * Konstruktor f?r ein Exemplar von Uhrenanzeige.
     * Mit diesem Konstruktor wird die Anzeige auf 00:00 initialisiert.
     */
    public Uhrenanzeige()
    {
        stunden = new Nummernanzeige(24);
        minuten = new Nummernanzeige(60);
        anzeigeAktualisieren();
    }

    /**
     * Konstruktor f?r ein Exemplar von Uhrenanzeige.
     * Mit diesem Konstruktor wird die Anzeige auf den Wert
     * initialisiert, der durch 'stunde' und 'minute' 
     * definiert ist.
     */
    public Uhrenanzeige(int stunde, int minute)
    {
        stunden = new Nummernanzeige(24);
        minuten = new Nummernanzeige(60);
        setzeUhrzeit(stunde, minute);
    }

    /**
     * Diese Operation sollte einmal pro Minute aufgerufen werden -
     * sie sorgt daf?r, dass diese Uhrenanzeige um eine Minute
     * weiter gestellt wird.
     */
    public void taktsignalGeben()
    {
        minuten.erhoehen();
        if(minuten.gibWert() == 0) {  // Limit wurde erreicht!
            stunden.erhoehen();
        }
        anzeigeAktualisieren();
    }

    /**
     * Setze die Uhrzeit dieser Anzeige auf die gegebene 'stunde' und
     * 'minute'.
     */
    public void setzeUhrzeit(int stunde, int minute)
    {
        stunden.setzeWert(stunde);
        minuten.setzeWert(minute);
        anzeigeAktualisieren();
    }

    /**
     * Liefere die aktuelle Uhrzeit dieser Uhrenanzeige im Format SS:MM.
     */
    public String gibUhrzeit()
    {
        return zeitanzeige;
    }
    
    /**
     * Aktualisiere die interne Zeichenkette, die die Zeitanzeige h?lt.
     */
    private void anzeigeAktualisieren()
    {
        zeitanzeige = stunden.gibAnzeigewert() + ":"
                      + minuten.gibAnzeigewert();
    }
}
