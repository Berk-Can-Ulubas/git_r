/**
 * Objekte dieser Klasse repr�sentieren DVDs. Es werden
 * Informationen �ber eine DVD verwaltet, die wieder
 * abgefragt werden k�nnen. Wir gehen auf dieser Stufe
 * nur von Film-DVDs aus.
 * 
 * @author Michael K�lling und David J. Barnes
 * @version 2008.03.30
 */
public class DVD extends Medium 
{
    private String regisseur;

    /**
     * Konstruktor f�r Objekte der Klasse DVD
     * @param derTitel Der Titel dieser DVD.
     * @param derRegisseur Der Regisseur dieser DVD.
     * @param laenge Die Spielzeit des Hauptfilms.
     */
    public DVD(String derTitel, String derRegisseur, int laenge)
    {
        super(derTitel, laenge);
        regisseur = derRegisseur;
    }

    /**
     * Liefere den Regisseur dieser DVD.
     */
    public String gibRegisseur()
    {
        return regisseur;
    }

    /**
     * Gib Details �ber diese DVD auf der Konsole aus.
     */
    public void ausgeben()
    {
        System.out.println("    Regisseur: " + regisseur);
    }
}
