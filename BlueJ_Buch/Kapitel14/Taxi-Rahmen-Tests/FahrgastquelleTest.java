

/**
 * Die Test-Klasse FahrgastquelleTest.
 *
 * @author David J. Barnes und Michael K�lling
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
     *  Setzt das Testger�st fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    protected void setUp()
    {
        Taxiunternehmen unternehmen = new Taxiunternehmen();
        quelle = new Fahrgastquelle(unternehmen);
    }

    /**
     * Gibt das Testger�st wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    protected void tearDown()
    {
        quelle = null;
    }

    /**
     * Test der erfolgreichen Abholung eines Fahrgastes.
     */
    public void testAbholung()
    {
        assertEquals(true, quelle.erbitteAbholung());
    }

}
