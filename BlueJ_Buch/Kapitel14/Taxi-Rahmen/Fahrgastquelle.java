
/**
 * Simulation von Fahrg?sten, die Fahrten bei einem
 * Taxi-Unternehmen anfragen.
 * Fahrg?ste sollten in zuf?lligen Intervallen erzeugt werden.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2003.04.16
 */
public class Fahrgastquelle
{
    private Taxiunternehmen unternehmen;

    /**
     * Konstruktor f?r Objekte der Klasse FahrgastQuelle.
     * @param unternehmen das gew?hlte Unternehmen. Darf nicht null sein.
     * @throws NullPointerException wenn unternehmen null ist.
     */
    public Fahrgastquelle(Taxiunternehmen unternehmen)
    {
        if(unternehmen == null) {
            throw new NullPointerException("unternehmen");
        }
        this.unternehmen = unternehmen;
    }

    /**
     * Lasse diese Quelle einen neuen Fahrgast erzeugen
     * erbitte seine Abholung beim Unternehmen.
     * @return true wenn die Anfrage erfolgreich ist, false sonst.
     */
    public boolean erbitteAbholung()
    {
        Fahrgast fahrgast = erzeugeFahrgast();
        return unternehmen.taxirufFuer(fahrgast);
    }

    /**
     * Erzeuge einen neuen Fahrgast.
     * @return den erzeugten Fahrgast.
     */
    private Fahrgast erzeugeFahrgast()
    {
        return new Fahrgast(new Position(), new Position());
    }
}
