
/**
 * Ein Taxi kann einen einzelnen Fahrgast transportieren.
 * 
 * @author David J. Barnes und Michael Kölling
 * @version 2008.03.30
 */
public class Taxi extends Fahrzeug
{
    /**
     * Konstruktor für Objekte der Klasse Taxi.
     * @param unternehmen das Taxi-Unternehmen. Darf nicht null sein.
     * @param position die Startposition des Fahrzeugs.
     *                 Darf nicht null sein.
     * @throws NullPointerException Wenn unternehmen oder 
     *                              position null sind.
     */
    public Taxi(Taxiunternehmen unternehmen, Position position)
    {
        super(unternehmen, position);
    }

    /**
     * @return ob dieses Taxi frei ist.
     */
    public boolean istFrei()
    {
        return gibZiel() == null;
    }
    
    /**
     * Setze einen Abholpunkt. Dieser wird zur
     * Zielposition.
     * @param position der Abholpunkt.
     */
    public void setzeAbholpunkt(Position position)
    {
        setzeZiel(position);
    }
    
    /**
     * Nimm einen Fahrgast auf.
     * Setze sein Ziel als die Zielposition.
     * @param fahrgast der Fahrgast.
     */
    public void aufnehmen(Fahrgast fahrgast)
    {
        setzeZiel(fahrgast.gibZiel());
    }

    /**
     * Setze den Fahrgast ab.
     */
    public void fahrgastAbsetzen()
    {
        loescheZiel();
    }
}
