/**
 * Die Rahmeneigenschaften eines Fahrzeugs.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2003.05.07
 */
public abstract class Fahrzeug
{
    private Taxiunternehmen unternehmen;
    // Wo befindet sich dieses Fahrzeug.
    private Position position;
    // Wohin f?hrt dieses Fahrzeug.
    private Position ziel;
    
    /**
     * Konstruktor f?r Objekte der Klasse Fahrzeug.
     * @param unternehmen das Taxi-Unternehmen. Darf nicht null sein.
     * @param position die Startposition dieses Fahrzeugs.
     *                 Darf nicht null sein.
     * @throws NullPointerException Wenn unternehmen oder position
     *                              null ist.
     */
    public Fahrzeug(Taxiunternehmen unternehmen, Position position)
    {
        if(unternehmen == null) {
            throw new NullPointerException("unternehmen");
        }
        if(position == null) {
            throw new NullPointerException("position");
        }
        this.unternehmen = unternehmen;
        this.position = position;
        ziel = null;
    }
    
    /**
     * Informiere die Zentrale ?ber unsere Ankunft am Abholpunkt.
     */
    public void signalisiereAnkunftAbholung()
    {
        unternehmen.ankunftBeiAbholung(this);
    }
    
    /**
     * Informiere die Zentrale ?ber unsere Ankunft am Ziel
     * des Fahrgastes.
     * @param fahrgast der Fahrgast, der sein Ziel erreicht hat.
     */
    public void signalisiereFahrgastAmZiel(Fahrgast fahrgast)
    {
        unternehmen.ankunftAmZiel(this, fahrgast);
    }
    
    /**
     * Setze einen Abholpunkt.
     * Wie dies behandelt wird, h?ngt vom Fahrzeugtyp ab.
     * @param position der Abholpunkt.
     */
    public abstract void setzeAbholpunkt(Position position);
    
    /**
     * Nimm einen Fahrgast auf.
     * Wie dies behandelt wird, h?ngt vom Fahrzeugtyp ab.
     * @param fahrgast der Fahrgast, der aufgenommen wird.
     */
    public abstract void aufnehmen(Fahrgast fahrgast);
    
    /**
     * @return ob dieses Fahrzeug frei ist.
     */
    public abstract boolean istFrei();
    
    /**
     * Setze einen Fahrgast ab, dessen Ziel die aktuelle
     * Position ist.
     */
    public abstract void fahrgastAbsetzen();
    
    /**
     * @return die aktuelle Position dieses Fahrzeugs.
     */
    public Position gibPosition()
    {
        return position;
    }
    
    /**
     * Setze die aktuelle Position.
     * @param position die aktuelle Position dieses Fahrzeugs.
     *                 Darf nicht null sein.
     * @throws NullPointerException Wenn position null ist.
     */
    public void setzePosition(Position position)
    {
        if(position != null) {
            this.position = position;
        }
        else {
            throw new NullPointerException();
        }
    }
    
    /**
     * @return Wohin das Fahrzeug gerade f?hrt bzw. null,
     *         wenn es gerade frei ist.
     */
    public Position gibZiel()
    {
        return ziel;
    }
    
    /**
     * Setze das gew?nschte Ziel.
     * @param position die Zielposition. Darf nicht null sein.
     * @throws NullPointerException Wenn position null ist.
     */
    public void setzeZiel(Position position)
    {
        if(position != null) {
            ziel = position;
        }
        else {
            throw new NullPointerException();
        }
    }
    
    /**
     * L?sche das aktuelle Ziel.
     */
    public void loescheZiel()
    {
        ziel = null;
    }
}
