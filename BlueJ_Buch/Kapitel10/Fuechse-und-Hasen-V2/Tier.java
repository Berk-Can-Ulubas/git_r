import java.util.List;

/**
 * Tier ist eine abstrakte Superklasse für Tiere. 
 * Sie verwaltet Eigenschaften, die alle Tiere gemein haben,
 * wie etwas das Alter oder eine Position.
 * 
 * @author David J. Barnes und Michael Kölling
 * @version 2008.03.30
 */
public abstract class Tier
{
    // Ist dieses Tier noch lebendig?
    private boolean lebendig;
    // Das Feld des Tieres
    private Feld feld;
    // Die Position dieses Tieres.
    private Position position;

    /**
     * Erzeuge ein neues Tier an der gegebenen Position im Feld.
     * 
     * @param feld Das aktuelle belegte Feld
     * @param position Die Position im Feld
     */
    public Tier(Feld feld, Position position)
    {
        lebendig = true;
        this.feld = feld;
        setzePosition(position);
    }
    
    /**
     * Lasse dieses Tier agieren - es soll das tun, was
     * es tun muss oder möchte.
     * @param neueTiere Liste, in die neue Tiere einzufügen sind.
     */
    abstract public void agiere(List<Tier> neueTiere);

    /**
     * Prüfe, ob dieses Tier noch lebendig ist.
     * @return true wenn dieses Tier noch lebendig ist.
     */
    public boolean istLebendig()
    {
        return lebendig;
    }

    /**
     * Anzeigen, dass das Tier nicht mehr laenger lebendig ist
     * Es wird aus dem Feld entfernt.
     */
    public void sterben()
    {
        lebendig = false;
        if(position != null) {
            feld.raeumen(position);
            position = null;
            feld = null;
        }
    }

    /**
     * Liefere die Position dieses Tieres.
     * @return die Position dieses Tieres.
     */
    public Position gibPosition()
    {
        return position;
    }
    
    /**
     * Liefere das Feld des Tieres.
     * @return das Feld des Tieres.
     */
    public Feld gibFeld()
    {
        return feld;
    }
 
    /**
     * Setze das Tier auf die gegebene Position im aktuellen Feld.
     * @param neuePosition die neue Position des Tieres.
     */
    public void setzePosition(Position neuePosition)
    {
        if(position != null) {
            feld.raeumen(position);
        }
        position = neuePosition;
        feld.platziere(this, neuePosition);
    }
}
