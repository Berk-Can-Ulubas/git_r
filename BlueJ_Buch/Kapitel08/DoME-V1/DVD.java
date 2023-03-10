/**
 * Objekte dieser Klasse repr?sentieren DVDs. Es werden
 * Informationen ?ber eine DVD verwaltet, die wieder
 * abgefragt werden k?nnen.
 * 
 * @author Michael K?lling und David J. Barnes
 * @version 2008.03.30
 */
public class DVD 
{
    private String titel;
    private String regisseur;
    private int spielzeit;
    private boolean habIch;
    private String kommentar;

    /**
     * Konstruktor f?r Objekte der Klasse DVD
     * @param derTitel Der Titel dieser DVD.
     * @param derRegisseur Der Regisseur dieser DVD.
     * @param laenge Die Spielzeit des Hauptfilms.
     */
    public DVD(String derTitel, String dieRegie, int laenge)
    {
        titel = derTitel;
        regisseur = dieRegie;
        spielzeit = laenge;
        habIch = false;
        kommentar = "<kein Kommentar>";
    }

    /**
     * Setze einen Kommentar f?r diese DVD.
     * @param kommentar der einzutragende Kommentar.
     */
    public void setzeKommentar(String kommentar)
    {
        this.kommentar = kommentar;
    }

    /**
     * @return den Kommentar dieser DVD.
     */
    public String gibKommentar()
    {
        return kommentar;
    }

    /**
     * Setze, ob wir diese DVD in unserer Sammlung haben.
     * @param vorhanden true, wenn wir die DVD haben, false sonst.
     */
    public void setzeVorhanden(boolean vorhanden)
    {
        habIch = vorhanden;
    }

    /**
     * Liefere die Information, ob dieses DVD Teil unserer
     * Sammlung ist.
     */
    public boolean gibVorhanden()
    {
        return habIch;
    }

    /**
     * Gib die Details dieser DVD auf der Konsole aus.
     */
    public void ausgeben()
    {
        System.out.print("DVD: " + titel + " (" + spielzeit + " Min)");
        if(habIch) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("    " + regisseur);
        System.out.println("    " + kommentar);
    }
}
