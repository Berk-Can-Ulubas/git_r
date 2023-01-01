/**
 * Objekte dieser Klasse repräsentieren CDs. 
 * Sie speichern Informationen über eine CD, die
 * wieder abgefragt werden können.
 * 
 * @author Michael Kölling und David J. Barnes
 * @version 2008.03.30
 */
public class CD extends Medium
{
    private String kuenstler;
    private int titelanzahl;

    /**
     * Initialisiere die CD.
     * @param derTitel der Titel der CD.
     * @param derKuenstler der Kuenstler dieser CD.
     * @param stuecke die Anzahl der Stuecke auf der CD.
     * @param laenge die Spielzeit der CD
     */
    public CD(String derTitel, String derKuenstler, int stuecke, int laenge)
    {
        super(derTitel, laenge);
        kuenstler = derKuenstler;
        titelanzahl = stuecke;
    }

    /**
     * @return den Künstler dieser CD.
     */
    public String gibKuenstler()
    {
        return kuenstler;
    }

    /**
     * @return die Anzahl der Titel auf dieser CD.
     */
    public int gibTitelanzahl()
    {
        return titelanzahl;
    }
}
