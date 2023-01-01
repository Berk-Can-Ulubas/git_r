import java.util.List;

/**
 * Die Test-Klasse FahrgastquelleTest.
 *
 * @author David J. Barnes und Michael Kölling
 * @version 2008.03.30
 */
public class FahrgastquelleTest extends junit.framework.TestCase
{
    private Fahrgastquelle quelle;
    
    /**
     * Konstruktor fuer die Test-Klasse FahrgastquelleTest
     */
    public FahrgastquelleTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    protected void setUp()
    {
        Taxiunternehmen unternehmen = new Taxiunternehmen();
        quelle = new Fahrgastquelle(unternehmen);
        Position taxiPosition = new Position(0, 0);
        Taxi taxi = new Taxi(unternehmen, taxiPosition);
        List<Fahrzeug> fahrzeuge = unternehmen.gibFahrzeuge();
        fahrzeuge.add(taxi);
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    protected void tearDown()
    {
        quelle = null;
    }
    
    /**
     * Teste die erfolgreiche Abholung eines Fahrgastes.
     */
    public void testAbholung()
    {
        assertEquals(true, quelle.erbitteAbholung());
    }
}
