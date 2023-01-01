

/**
 * Die Test-Klasse TaxiTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TaxiTest extends junit.framework.TestCase
{
    private Taxi taxi;
    private Fahrgast fahrgast;
    
    /**
     * Konstruktor fuer die Test-Klasse TaxiTest
     */
    public TaxiTest()
    {
    }

    /**
     *  Erzeuge ein Taxi und einen Fahrgast.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    protected void setUp()
    {
        Taxiunternehmen unternehmen = new Taxiunternehmen();
        // Startposition für ein Taxi.
        Position taxiPosition = new Position(0, 0);
        // Positionen für den Fahrgast.
        Position abholpunkt = new Position(1, 2);
        Position ziel = new Position(5, 6);
        
        fahrgast = new Fahrgast(abholpunkt, ziel);
        taxi = new Taxi(unternehmen, taxiPosition);
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    protected void tearDown()
    {
    }
    
    /**
     * Teste die Erzeugung und den Anfangszustand eines Taxis.
     */
    public void testErzeugung()
    {
        assertEquals(true, taxi.istFrei());
    }
    
    /**
     * Teste, ob ein Taxi nicht mehr frei ist, nachdem es
     * einen Fahrgast aufgenommen hat.
     */
    public void testAbholung()
    {
        taxi.aufnehmen(fahrgast);
        assertEquals(false, taxi.istFrei());
    }
    
    /**
     * Test that a taxi becomes free again after offloading
     * a passenger.
     * Test, ob ein Taxi wieder frei ist, nachdem es einen
     * Fahrgast abgesetzt hat.
     */
    public void testAbsetzen()
    {
        taxi.aufnehmen(fahrgast);
        assertEquals(false, taxi.istFrei());
        taxi.fahrgastAbsetzen();
        assertEquals(true, taxi.istFrei());
    }

    
    /**
     * Test, ob ein Taxi einen Fahrgast in einer vernünftigen Schrittzahl
     * aufnimmt und wieder absetzt.
     */
    public void testFuhre()
    {
        Position abholpunkt = fahrgast.gibAbholpunkt();
        Position ziel = fahrgast.gibZiel();
        // Die Anzahl der erwarteten Schritte ist die Summe
        // aus der Distanz des Taxis zum Fahrgast und der Distanz
        // des Fahrgastes vom Ziel.
        int erwarteteSchritte = taxi.gibPosition().schritteZu(abholpunkt) +
                    abholpunkt.schritteZu(ziel);

        taxi.aufnehmen(fahrgast);

        int schritte = 0;
        while(!taxi.istFrei() && schritte < erwarteteSchritte) {
            taxi.agiere();
            schritte++;
        }
        assertEquals(schritte, erwarteteSchritte);
        assertEquals(taxi.istFrei(), true);
    }    
}
