/**
 * Details einer Verabredung f�r einen Terminkalender.
 * 
 * @author David J. Barnes und Michael K�lling
 * @version 2008.03.30
 */
public class Verabredung
{
    // der Anlass der Verabredung
    private String beschreibung;
    // die L�nge der Verabredung (in Stunden).
    private int dauer;

    /**
     * Konstruktor f�r einen Verabredung mit einer Dauer.
     * @param beschreibung die Beschreibung der Verabredung.
     * @param dauer die L�nge der Verabredung in Stunden.
     */
    public Verabredung(String beschreibung, int dauer)
    {
        this.beschreibung = beschreibung;
        this.dauer = dauer;
    }

    /**
     * Liefere die Beschreibung dieser Verabredung.
     * @return die Beschreibung dieser Verabredung.
     */
    public String gibBeschreibung()
    {
        return beschreibung;
    }
    
    /**
     * Liefere die Dauer dieser Verabredung (in Stunden).
     * @return die Dauer dieser Verabredung (in Stunden).
     */
    public int gibDauer()
    {
        return dauer;
    }
}
