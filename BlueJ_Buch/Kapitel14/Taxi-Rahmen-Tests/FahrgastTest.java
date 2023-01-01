/**
 * Die Test-Klasse FahrgastTest.
 *
 * @author  David J. Barnes und Michael Kölling
 * @version 2008.03.30
 */
public class FahrgastTest extends junit.framework.TestCase
{
    /**
     * Konstruktor fuer die Test-Klasse FahrgastTest
     */
    public FahrgastTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    protected void setUp()
    {
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
     * Teste die einfache Erzeugung eines Fahrgastes.
     * Stelle sicher, dass Abholpunkt und Ziel gesetzt sind.
     */
    public void testErzeugung()
    {
        Position abholpunkt = new Position();
        Position ziel = new Position();
        Fahrgast fahrgast1 = new Fahrgast(abholpunkt, ziel);
        assertEquals(ziel, fahrgast1.gibZiel());
        assertEquals(abholpunkt, fahrgast1.gibAbholpunkt());
    }
}
