/**
 * Verwaltung der Termine eines Tages in einem Terminkalender.
 * 
 * @author David J. Barnes und Michael Kölling
 * @version 2008.03.30
 */
public class Tag
{
    // Der erste und der letzte planbare Termin eines Tages.
    public static final int TAGESBEGINN = 9;
    public static final int LETZTER_PLANBARER_TERMIN = 17;
    // Die Anzahl der planbaren Stunden eines Tages.
    public static final int MAX_TERMINE_PRO_TAG =
                                LETZTER_PLANBARER_TERMIN -
                                TAGESBEGINN + 1;
    
    // Ein Tag innerhalb eines Jahres. (1-366)
    private int tagesnummer;
    // Die aktuelle Liste der Termine dieses Tages.
    private final Verabredung[] termine;

    /**
     * Konstruktor für Objekte der Klasse Tag.
     * @param tagesnummer die Nummer des Tages innerhalb
     *                     des Jahres (1-366).
     */
    public Tag(int tagesnummer)
    {
        this.tagesnummer = tagesnummer;
        termine = new Verabredung[MAX_TERMINE_PRO_TAG];
    }

    /**
     * Versuche, die gegebene Verabredung in diesem Tag unterzubringen.
     * @param verabredung die Verabredung, die untergebracht werden soll.
     * @return den frühesten Zeitpunkt, an dem diese Verabredung
     *          statfinden kann. Liefere -1, falls für die Verabredung
     *          kein Platz mehr ist.
     */ 
    public int findePlatz(Verabredung verabredung)
    {
        int dauer = verabredung.gibDauer();
        for(int stunde = 0; stunde < MAX_TERMINE_PRO_TAG; stunde++) {
            if(termine[stunde] == null) {
                final int zeitpunkt = TAGESBEGINN + stunde;
                // potenzieller Startzeitpunkt
                if(dauer == 1) {
                    // Es wird nur eine Stunde benötigt.
                    return zeitpunkt;
                }
                else {
                    // Wie viele Stunden werden benötigt?
                    int weitereBenoetigteStunden = dauer - 1;
                    for(int naechsteStunde = stunde + 1;
                                weitereBenoetigteStunden > 0 &&
                                termine[naechsteStunde] == null;
                                    naechsteStunde++) {
                        weitereBenoetigteStunden--;
                    }
                    if(weitereBenoetigteStunden == 0) {
                        // Eine ausreichende Lücke wurde gefunden.
                        return zeitpunkt;
                    }
                }
            }
        }
        // Nicht genügend Platz verfügbar.
        return -1;
    }

    
    
    /**
     * Vereinbare einen Termin.
     * @param zeitpunkt die Stunde, zu der die Verabredung beginnt.
     * @param Verabredung die Verabredung, die eingetragen werden soll.
     * @return true wenn der Termin vereinbart werden konnte,
     *         false sonst.
     */
    public boolean vereinbareTermin(int zeitpunkt,
                                   Verabredung verabredung)
    {
        if(zeitpunkt >= TAGESBEGINN && zeitpunkt <= LETZTER_PLANBARER_TERMIN) {
            int anfangszeit = zeitpunkt-TAGESBEGINN;
            if(termine[anfangszeit] == null) {
                int dauer = verabredung.gibDauer();
                // Reserviere alle Stunden für die Dauer
                // der Verabredung.
                for(int i = 0; i < dauer; i++) {
                    termine[anfangszeit + i] = verabredung;
                }
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    /**
     * @param zeit Zeitpunkt eines Tages. Muss im Bereich von
     *        TAGESBEGINN bis LETZTER_PLANBARER_TERMIN liegen.
     * @return Die Verabredung zum gegebenen Zeitpunkt. Es wird
     *         null geliefert, wenn zeit entweder ungültig
     *         ist oder zu dem Zeitpunkt keine Verabredung
     *         eingetragen ist.
     */
    public Verabredung gibVerabredung(int zeit)
    {
        if(gueltigeZeit(zeit)) {
            return termine[zeit - TAGESBEGINN];
        }
        else {
            return null;
        }
    }


    /**
     * Gib eine Liste aller Termine auf der Konsole aus.
     */
    public void termineAusgeben()
    {
        System.out.println("=== Tag " + tagesnummer + " ===");
        int uhrzeit = TAGESBEGINN;
        for(Verabredung termin : termine) {
            System.out.print(uhrzeit + ": ");
            if(termin != null) {
                System.out.println(termin.gibBeschreibung());
            }
            else {
                System.out.println();
            }
            uhrzeit++;
        }
    }

    /**
     * @return Die Nummer dieses Tages innerhalb des Jahres (1 - 366).
     */
    public int gibTagesnummer()
    {
        return tagesnummer;
    }

    /**
     * @return true, falls zeit im Bereich von TAGESBEGINN bis 
     *         LETZTER_PLANBARER_TERMIN liegt, false sonst.
     */
    public boolean gueltigeZeit(int zeit)
    {
        return zeit >= TAGESBEGINN && zeit <= LETZTER_PLANBARER_TERMIN;
    }
}
