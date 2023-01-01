/**
 * Modellierung von Personen, die an einer
 * Auktion teilnehmen.
 * @author David J. Barnes und Michael Kölling.
 * @version 2008.03.30
 */
public class Person
{
    // der Name dieser Person
    private final String name;

    /**
     * Erzeuge eine neue Person mit dem angegebenen Namen.
     * @param name der Name der Person
     */
    public Person(String name)
    {
        this.name = name;
    }

    /**
     * @return den Namen der Person.
     */
    public String gibName()
    {
        return name;
    }
}
