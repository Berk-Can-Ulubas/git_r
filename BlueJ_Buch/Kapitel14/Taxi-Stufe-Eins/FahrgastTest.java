/**
 * Die Test-Klasse FahrgastTest.
 *
 * @author  David J. Barnes und Michael K�lling
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
     *  Setzt das Testger�st fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    protected void setUp()
    {
    }

    /**
     * Gibt das Testger�st wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    protected void tearDown()
    {
    }

    /**
     * Teste die Erzeung eines Fahrgastes.
     * �berpr�fe, ob der Abholpunkt und das Fahrziel
     * richtig gesetzt sind.
     */
	public void testErzeugung()
	{
		Position abholpunkt = new Position(0, 0);
		Position ziel = new Position(1, 2);
		Fahrgast fahrgast1 = new Fahrgast(abholpunkt, ziel);
		assertEquals(ziel, fahrgast1.gibZiel());
		assertEquals(abholpunkt, fahrgast1.gibAbholpunkt());
	}
}
