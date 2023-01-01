/**
 * Objekte dieser Klasse repräsentieren DVDs. Es werden
 * Informationen über eine DVD verwaltet, die wieder
 * abgefragt werden können.
 * 
 * @author Michael Kölling und David J. Barnes
 * @version 2008.03.30
 */
/**
 * The DVD class represents a DVD object. Information about the 
 * DVD is stored and can be retrieved. We assume that we only deal 
 * with movie DVDs at this stage.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class DVD extends Medium 
{
    private String regisseur;

    /**
     * Konstruktor für Objekte der Klasse DVD
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
     * Gib grundlegende Informationen ueber dieses Medium zurueck - insbesondere
     * den Regisseur und den Kuenstler
     * @return grundlegende Informationen.
     */
    public String grundlegendeInformationen()
    {
        return super.grundlegendeInformationen() +
               " von " + regisseur;
    }

    /**
     * Gib Informationen ueber diese DVD auf die Konsole aus
     */
    public void ausgeben()
    {
        System.out.println("    Regisseur: " + regisseur);
    }    
}

