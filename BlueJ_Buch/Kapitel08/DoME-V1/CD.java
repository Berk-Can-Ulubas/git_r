/**
 * Objekte dieser Klasse repr?sentieren CDs. 
 * Sie speichern Informationen ?ber eine CD, die
 * wieder abgefragt werden k?nnen.
 * 
 * @author Michael K?lling und David J. Barnes
 * @version 2008.03.30
 */
public class CD
{
    private String titel;
    private String kuenstler;
    private int titelanzahl;
    private int spielzeit;
    private boolean habIch;
    private String kommentar;

    /**
     * Initialisierung einer CD.
     * @param derTitel der Titel der CD.
     * @param derKuenstler der Kuenstler dieser CD.
     * @param stuecke die Anzahl der Stuecke auf der CD.
     * @param laenge die Spielzeit der CD.
     */
    public CD(String derTitel, String derKuenstler, int stuecke, int laenge)
    {
        titel = derTitel;
        kuenstler = derKuenstler;
        titelanzahl = stuecke;
        spielzeit = laenge;
        habIch = false;
        kommentar = "<kein Kommentar>";
    }

    /**
     * Setze einen Kommentar f?r diese CD.
     * @param kommentar der einzutragende Kommentar.
     */
    public void setzeKommentar(String kommentar)
    {
        this.kommentar = kommentar;
    }

    /**
     * @return den Kommentar f?r diese CD.
     */
    public String gibKommentar()
    {
        return kommentar;
    }

    /**
     * Setze, ob wir diese CD in unserer Sammlung haben.
     * @param vorhanden true, wenn wir die CD haben, false sonst.
     */
    public void setzeVorhanden(boolean vorhanden)
    {
        habIch = vorhanden;
    }
    
    /**
     * @return true, wenn wir diese CD in
     * unserer Sammlung haben.
     */
    public boolean gibVorhanden()
    {
        return habIch;
    }

    /**
     * Gib Details ?ber diese CD auf der Konsole aus.
     */
    public void ausgeben()
    {
        System.out.print("CD: " + titel + " (" + spielzeit + " Min)");
        if(habIch) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("    " + kuenstler);
        System.out.println("    Titelanzahl: " + titelanzahl);
        System.out.println("    " + kommentar);
    }
}
