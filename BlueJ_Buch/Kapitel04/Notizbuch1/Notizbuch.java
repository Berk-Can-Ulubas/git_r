import java.util.ArrayList;

/**
 * Eine Klasse zur Verwaltung von beliebig langen Notizlisten.
 * Notizen sind nummeriert, um durch einen Benutzer referenziert
 * werden zu können.
 * In dieser Version starten die Notiznummern bei 0.
 * 
 * @author David J. Barnes und Michael Kölling.
 * @version 2008.03.30
 */
public class Notizbuch
{
    // Speicher für eine beliebige Anzahl an Notizen.
    private ArrayList<String> notizen;

    /**
     * Führe die Initialisierungen durch, die für ein Notizbuch
     * notwendig sind.
     */
    public Notizbuch()
    {
        notizen = new ArrayList<String>();
    }

    /**
     * Speichere eine neue Notiz in diesem Notizbuch.
     * @param notiz die zu speichernde Notiz.
     */
    public void speichereNotiz(String notiz)
    {
        notizen.add(notiz);
    }

    /**
     * @return die Anzahl der Notizen in diesem Notizbuch.
     */
    public int anzahlNotizen()
    {
        return notizen.size();
    }

    /**
     * Zeige eine Notiz.
     * @param notiznummer die Nummer der Notiz, die gezeigt werden soll.
     */
    public void zeigeNotiz(int notiznummer)
    {
        if(notiznummer < 0) {
            // Keine gültige Nummer, nichts zu tun.
        }
        else if(notiznummer < anzahlNotizen()) {
            // Die Nummer ist gültig, wir können die Notiz ausgeben.
            System.out.println(notizen.get(notiznummer));
        }
        else {
            // Keine gültige Nummer, nichts zu tun.
        }
    }
}
