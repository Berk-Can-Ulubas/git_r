/**
 * Eine Repräsentation der Tage einer Woche.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2003.03.10
 */
public class Woche
{
    // Eine Woche besteht hier aus den Tagen Montag bis Freitag.
    public static final int BELEGBARE_TAGE_PRO_WOCHE = 5;
    
    // Die Wochennummer innerhalb des Jahres (0-52).
    private final int wochennummer;
    private final Tag[] tage;

    /**
     * Konstruktor für Objekte der Klasse Woche.
     * @param weekNumber The week number (0-52).
     */
    public Woche(int wochennummer)
    {
        this.wochennummer = wochennummer;
        tage = new Tag[BELEGBARE_TAGE_PRO_WOCHE];
        int tagImJahr = wochennummer * 7 + 1;
        for(int day = 0; day < BELEGBARE_TAGE_PRO_WOCHE; day++) {
            tage[day] = new Tag(tagImJahr);
            tagImJahr++;
        }
    }

    /**
     * Gib eine Liste der Termine dieser Woche auf der Konsole aus.
     */
    public void termineAusgeben()
    {
        System.out.println("*** Woche " + wochennummer + " ***");
        for(int i = 0; i < BELEGBARE_TAGE_PRO_WOCHE; i++) {
            tage[i].termineAusgeben();
        }
    }

    /**
     * Liefere den angebenen Tag der Woche.
     * @param tagInWoche Nummer des Tages in der Woche
     *                    (1..BELEGBARE_TAGE_PRO_WOCHE).
     * @return den Tag zur gegebenen Nummer, oder null, wenn
     *         tagInWoche nicht im gültigen Bereich liegt.
     */
    public Tag gibTag(int tagInWoche)
    {
        if(tagInWoche >= 1 && tagInWoche <= BELEGBARE_TAGE_PRO_WOCHE) {
            return tage[tagInWoche - 1];
        }
        else {
            return null;
        }
    }

    /**
     * Liefere die Wochennummer dieser Woche.
     * @return die Wochennummer (0-52) dieser Woche.
     */
    public int gibWochennummer()
    {
        return wochennummer;
    }
}
