/**
 * Modell eines Fahrgastes, der von einem Punkt zum
 * anderen gebracht werden m?chte.
 * 
 * @author David J. Barnes und Michael K?lling
 * @version 2008.03.30
 */
public class Fahrgast
{
    private Position abholpunkt;
    private Position ziel;

    /**
     * Konstruktor f?r Objekte der Klasse Fahrgast.
     * @param abholpunkt der Abholpunkt, darf nicht null sein.
     * @param ziel die Zielposition, darf nicht null sein.
     * @throws NullPointerException Wenn eine der Positionen null ist.
     */
    public Fahrgast(Position abholpunkt, Position ziel)
    {
        if(abholpunkt == null) {
            throw new NullPointerException("abholpunkt");
        }
        if(ziel == null) {
            throw new NullPointerException("ziel");
        }
        this.abholpunkt = abholpunkt;
        this.ziel = ziel;
    }

    /**
     * @return den Abholpunkt.
     */
    public Position gibAbholpunkt()
    {
        return abholpunkt;
    }
    
    /**
     * @return das Ziel.
     */
    public Position gibZiel()
    {
        return ziel;
    }
}
