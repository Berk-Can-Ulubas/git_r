

/**
 * Die Test-Klasse TaxiTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TaxiTest extends junit.framework.TestCase
{
    private Taxi taxi;
    
    /**
     * Konstruktor fuer die Test-Klasse TaxiTest
     */
    public TaxiTest()
    {
    }

    /**
     *  Erzeuge ein Taxi.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    protected void setUp()
    {
        Taxiunternehmen unternehmen = new Taxiunternehmen();
        Position taxiPosition = new Position();
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
        Position abholpunkt = new Position();
        Position ziel = new Position();
        Fahrgast fahrgast = new Fahrgast(abholpunkt, ziel);
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
        testAbholung();
        taxi.fahrgastAbsetzen();
        assertEquals(true, taxi.istFrei());
    }
    
}
