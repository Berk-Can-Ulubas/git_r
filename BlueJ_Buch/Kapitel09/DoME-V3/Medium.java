/**
 * Objekte dieser Klasse repräsentieren Medien in einer
 * Multimedia-Datenbank. Sie speichern Informationen über ein
 * Medium, die wieder abgefragt werden können.
 * Diese Klasse dient als Oberklasse für speziellere Medientypen.
 * 
 * @author Michael Kölling und David J. Barnes
 * @version 2008.03.30
 */
public class Medium
{
    private String titel;
    private int spielzeit;
    private boolean habIch;
    private String kommentar;

    /**
     * Initialisiere die Datenfelder dieses Mediums.
     * @param derTitel der Titel dieses Mediums.
     * @param laenge die Spielzeit dieses Mediums.
     */
    public Medium(String derTitel, int laenge)
    {
        titel = derTitel;
        spielzeit = laenge;
        habIch = false;
        kommentar = "";
    }

    /**
     * Trage einen Kommentar für dieses Medium ein.
     * @param kommentar der einzutragende Kommentar.
     */
    public void setzeKommentar(String kommentar)
    {
        this.kommentar = kommentar;
    }

    /**
     * @return den Kommentar für dieses Medium.
     */
    public String gibKommentar()
    {
        return kommentar;
    }

    /**
     * Setze, ob wir dieses Medium in unserer Sammlung haben.
     * @param vorhanden true, wenn wir das Medium haben, false sonst.
     */
    public void setzeVorhanden(boolean vorhanden)
    {
        habIch = vorhanden;
    }

    /**
     * @return true, wenn wir dieses Medium in unserer Sammlung haben.
     */
    public boolean gibVorhanden()
    {
        return habIch;
    }

    /**
     * Gib Details über dieses Medium auf der Konsole aus.
     */
    public void ausgeben()
    {
        System.out.print("Titel: " + titel + " (" + spielzeit + " Min)");
        if(habIch) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("    " + kommentar);
    }
}
