/**
 * Einige Tests mit einst�ndigen Verabredungen
 * an der Klasse Tag.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class EineStundeTests
{
    // Das zu testende Tag-Objekt.
    private Tag tag;

    /**
     * Konstruktor f�r EineStundeTests.
     */
    public EineStundeTests()
    {
    }

    /**
     * Pr�fe Basisfunktionalit�t, indem Termine am Tagesanfang,
     * am Tagesende und in der Mitte vereinbart werden.
     */
    public void dreiTermineVereinbaren()
    {
        // Mit einem "frischen" Tag-Objekt beginnen.
        tag = new Tag(1);
        // Drei einst�ndige Verabredungen erzeugen.
        Verabredung erste = new Verabredung("Java Vorlesung", 1);
        Verabredung zweite = new Verabredung("Java �bung", 1);
        Verabredung dritte = new Verabredung("John treffen", 1);
        
        // Jede Verabredung an einem anderen Zeitpunkt vereinbaren.
        tag.vereinbareTermin(9, erste);
        tag.vereinbareTermin(13, zweite);
        tag.vereinbareTermin(17, dritte);
        
        tag.termineAusgeben();
    }
    
    /**
     * Pr�fe, dass ein Termin nicht doppelt belegt werden kann.
     */
    public void testeTerminueberschneidung()
    {
        // Lege drei g�ltige Termin fest.
        dreiTermineVereinbaren();
        Verabredung falscherTermin = new Verabredung("Fehler", 1);
        tag.vereinbareTermin(9, falscherTermin);
        
        // Zeige, dass der Termin nicht eingetragen wurde.
        tag.termineAusgeben();
    }

    /**
     * Pr�fe Basisfunktionalit�t, indem ein Tag
     * komplett mit Terminen bef�llt wird.
     */
    public void verplaneKomplettenTag()
    {
        // Mit einem "frischen" Tag-Objekt beginnen.
        tag = new Tag(1);
        for(int zeitpunkt = Tag.TAGESBEGINN;
                zeitpunkt <= Tag.LETZTER_PLANBARER_TERMIN;
                zeitpunkt++) {
            tag.vereinbareTermin(zeitpunkt,
                                new Verabredung("Test " + zeitpunkt, 1));
        }
        
        tag.termineAusgeben();
    }
}
