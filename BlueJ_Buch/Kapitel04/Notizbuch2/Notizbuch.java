import java.util.ArrayList;

/**
 * Eine Klasse zur Verwaltung von beliebig langen Notizlisten.
 * Notizen sind nummeriert, um durch einen Benutzer referenziert
 * werden zu k�nnen.
 * In dieser Version starten die Notiznummern bei 0.
 * 
 * @author David J. Barnes und Michael K�lling.
 * @version 2008.03.30
 */
public class Notizbuch
{
    // Speicher f�r eine beliebige Anzahl an Notizen.
    private ArrayList<String> notizen;

    /**
     * F�hre die Initialisierungen durch, die f�r ein Notizbuch
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
     * Entferne die Notiz mit der angegebenen Nummer aus
     * diesem Notizbuch, wenn sie existiert.
     * @param notiznummer die Nummer der zu entfernenden Notiz.
     */
    public void entferneNotiz(int notiznummer)
    {
        if(notiznummer < 0) {
            // Keine g�ltige Nummer, nichts zu tun.
        }
        else if(notiznummer < anzahlNotizen()) {
            // Die Notiznummer ist g�ltig.
            notizen.remove(notiznummer);
        }
        else {
            // Keine g�ltige Nummer, nichts zu tun.
        }
    }

    /**
     * Gib alle Notizen dieses Notizbuchs auf die Konsole aus.
     */
    public void notizenAusgeben()
    {
        for (String notiz : notizen) {
            System.out.println(notiz);
        }
    }
}
