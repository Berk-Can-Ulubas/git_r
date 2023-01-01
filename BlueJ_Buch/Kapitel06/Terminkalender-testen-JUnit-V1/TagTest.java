/**
 * Die Test-Klasse TagTest.
 *
 * @author  David J. Barnes und Michael K�lling
 * @version 2008.03.30
 */
public class TagTest extends junit.framework.TestCase
{
    /**
     * Konstruktor fuer die Test-Klasse TagTest
     */
    public TagTest()
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
     * Teste grundlegende Funktionalit�t, indem Termine
     * an beiden Enden eines Tages und in der Mitte
     * vereinbart werden.
     */
    public void testDreiTermineVereinbaren()
    {
        Tag tag1 = new Tag(1);
        Verabredung termin1 = new Verabredung("Java Vorlesung", 1);
        Verabredung termin2 = new Verabredung("Java �bung", 1);
        Verabredung termin3 = new Verabredung("John treffen", 1);
        assertEquals(true, tag1.vereinbareTermin(9, termin1));
        assertEquals(true, tag1.vereinbareTermin(13, termin2));
        assertEquals(true, tag1.vereinbareTermin(17, termin3));
    }

    /**
     * �berpr�fe, dass Doppelbelegungen nicht zul�ssig sind.
     */
    public void testDoppelbelegung()
    {
        Tag tag1 = new Tag(1);
        Verabredung termin1 = new Verabredung("Java Vorlesung", 1);
        Verabredung termin2 = new Verabredung("Fehler", 1);
        assertEquals(true, tag1.vereinbareTermin(9, termin1));
        assertEquals(false, tag1.vereinbareTermin(9, termin2));
    }
}


