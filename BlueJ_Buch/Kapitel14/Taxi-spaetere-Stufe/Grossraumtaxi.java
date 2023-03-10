import java.util.List;
import java.util.LinkedList;
    
/**
 * Ein Gro?raumtaxi kann mehrere Fahrg?ste transportieren.
 * Diese Implementierung ist unvollst?ndig.
 * 
 * @author David J. Barnes und Michael K?lling
 * @version 2008.03.30
 */
public class Grossraumtaxi extends Fahrzeug
{
    // Die Liste der Ziele dieses Gro?raumtaxis.
    private List<Position> ziele;
    // Die Liste der Fahrg?ste im Gro?raumtaxi.
    private List<Fahrgast> fahrgaeste;

    /**
     * Konstruktor f?r Objekte der Klasse Shuttle.
     * @param unternehmen das Taxi-Unternehmen. Darf nicht null sein.
     * @param position die Startposition des Fahrzeugs. Darf nicht null sein.
     * @throws NullPointerException Wenn unternehmen oder position null sind.
     */
    public Grossraumtaxi(Taxiunternehmen unternehmen, Position position)
    {
        super(unternehmen, position);
        ziele = new LinkedList<Position>();
        fahrgaeste = new LinkedList<Fahrgast>();
    }

    /**
     * F?hre die Aktionen eines Gro?raumtaxis aus.
     */
    public void agiere()
    {
    }

    /**
     * @return ob dieses Fahrzeug frei ist.
     */
    public boolean istFrei()
    {
        return true;
    }
    
    /**
     * Setze einen Abholpunkt.
     * @param position der Abholpunkt.
     */
    public void setzeAbholpunkt(Position position)
    {
        ziele.add(position);
        waehleNaechstesZiel();
    }
    
    /**
     * Nimm einen Fahrgast auf.
     * F?ge sein Ziel zur Liste der Ziele hinzu.
     * @param fahrgast der aufgenommene Fahrgast.
     */
    public void aufnehmen(Fahrgast fahrgast)
    {
        fahrgaeste.add(fahrgast);
        ziele.add(fahrgast.gibZiel());
        waehleNaechstesZiel();
    }

    /**
     * W?hle das n?chste Ziel, abh?ngig von der Liste
     * der m?glichen Ziele.
     */
    private void waehleNaechstesZiel()
    {
    }

    /**
     * Setze einen Fahrgast ab, dessen Ziel die aktuelle
     * Position ist.
     */
    public void fahrgastAbsetzen()
    {
    }
}
