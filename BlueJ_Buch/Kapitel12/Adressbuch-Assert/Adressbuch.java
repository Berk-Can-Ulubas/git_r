import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Eine Klasse zur Verwaltung einer beliebigen Anzahl von 
 * Kontakten. Die Daten werden sowohl ?ber den Namen
 * als auch ?ber die Telefonnummer indiziert.
 * Diese Version benutzt assert-Anweisungen, um die
 * interne Konsistenz zu ?berpr?fen.
 * 
 * @author David J. Barnes und Michael K?lling.
 * @version 2008.03.30
 */
public class Adressbuch
{
    // Speicher f?r beliebige Anzahl von Kontakten.
    private TreeMap<String, Kontakt> buch;
    private int anzahlEintraege;

    /**
     * Initialisiere ein neues Adressbuch.
     */
    public Adressbuch()
    {
        buch = new TreeMap<String, Kontakt>();
        anzahlEintraege = 0;
    }
    
    /**
     * Schlage einen Namen oder eine Telefonnummer
     * nach und liefere den zugeh?rigen Kontakt.
     * @param schluessel der Name oder die Nummer zum Nachschlagen.
     * @return den zum Schl?ssel geh?renden Kontakt.
     */
    public Kontakt gibKontakt(String schluessel)
    {
        return buch.get(schluessel);
    }

    /**
     * Ist der gegebene Schl?ssel in diesem Adressbuch bekannt?
     * @param schluessel der Name oder die Nummer zum Nachschlagen.
     * @return true wenn der Schl?ssel eingetragen ist, false sonst.
     */
    public boolean schluesselBekannt(String schluessel)
    {
        return buch.containsKey(schluessel);
    }

    /**
     * F?ge einen neuen Kontakt in dieses Adressbuch ein.
     * @param kontakt der neue Kontakt.
     */
    public void neuerKontakt(Kontakt kontakt)
    {
        if(kontakt == null) {
            throw new IllegalArgumentException(
                   "Parameter in neuerKontakt ist null.");
        }
        buch.put(kontakt.gibName(), kontakt);
        buch.put(kontakt.gibTelefon(), kontakt);
        anzahlEintraege++;
        assert konsistenteGroesse() : "Inkonsistente Buchgr??e in neuerKontakt";
    }
    
    /**
     * ?ndere die Kontaktdaten, die bisher unter dem gegebenen
     * Schl?ssel eingetragen waren.
     * @param alterSchluessel einer der verwendeten Schl?ssel.
     *        Dieser Schl?ssel sollte in diesem Adressbuch bekannt sein.
     * @param daten die neuen Kontaktdaten. Darf nicht null sein.
     * @throws IllegalArgumentException Wenn einer der Parameter null ist.
     */
    public void aendereKontakt(String alterSchluessel,
                               Kontakt daten)
    {
        if(daten == null) {
            throw new IllegalArgumentException(
                    "Parameter 'daten' in aendereKontakt ist null.");
        }
        if(alterSchluessel == null){
            throw new IllegalArgumentException(
                    "Parameter 'schluessel' in aendereKontakt ist null.");
        }
        if(schluesselBekannt(alterSchluessel)){
            entferneKontakt(alterSchluessel);
            neuerKontakt(daten);
        }
    }
    
    /**
     * Suche nach allen Kontakten mit einem Schl?ssel, der mit dem
     * gegebenen Pr?fix beginnt.
     * @param pr?fix der Schl?sselpr?fix, nach dem gesucht werden
     *               soll. Die L?nge kann Null sein, aber die 
     *               Referenz darf nicht null sein.
     * @return ein Array mit den gefundenen Kontakten.
     */
    public Kontakt[] suche(String praefix)
    {
        // Eine Liste f?r die Treffer anlegen.
        List<Kontakt> treffer = new LinkedList<Kontakt>();
        if(praefix != null) {
            // Finden von Schl?sseln, die gleich dem oder gr??er als
            // der Pr?fix sind.
            SortedMap<String, Kontakt> rest = buch.tailMap(praefix);
            Iterator<String> it = rest.keySet().iterator();
            // Stoppen bei der ersten Nicht?bereinstimmung.
            boolean sucheBeendet = false;
            while(!sucheBeendet && it.hasNext()) {
                String schluessel = it.next();
                if(schluessel.startsWith(praefix)) {
                    treffer.add(buch.get(schluessel));
                }
                else {
                    sucheBeendet = true;
                }
            }
        }
        Kontakt[] ergebnisse = new Kontakt[treffer.size()];
        treffer.toArray(ergebnisse);
        return ergebnisse;
    }

    /**
     * @return die momentane Anzahl der Eintr?ge in diesem Adressbuch.
     */
    public int gibAnzahlEintraege()
    {
        return anzahlEintraege;
    }

    /**
     * Entferne den Eintrag mit dem gegebenen Schl?ssel aus diesem 
     * Adressbuch. Der Schl?ssel sollte diesem Adressbuch bekannt sein.
     * @param schl?ssel einer der Schl?ssel des Eintrags, 
     *                  der entfernt werden soll.
     * @throws IllegalArgumentException Wenn schluessel null ist.
     */
    public void entferneKontakt(String schluessel)
    {
        if(schluessel == null){
            throw new IllegalArgumentException(
                 "Parameter 'schluessel' in entferneKontakt ist null.");
        }
        if(schluesselBekannt(schluessel)) {
            Kontakt kontakt = buch.get(schluessel);
            buch.remove(kontakt.gibName());
            buch.remove(kontakt.gibTelefon());
            anzahlEintraege--;
        }
        assert !schluesselBekannt(schluessel);
        assert konsistenteGroesse() : "Inkonsistente Buchgr??e in entferneKontakt";
    }

    /**
     * @return alle Kontaktdaten, sortiert nach der
     * Sortierreihenfolge, die die Klasse Kontakt definiert.
     */
    public String alleKontaktdaten()
    {
        // Weil jeder Satz unter zwei Schl?sseln eingetragen ist,
        // muss ein Set mit den Kontakten gebildet werden. Dadurch
        // werden Duplikate entfernt.
        StringBuffer alleEintraege = new StringBuffer();
        Set<Kontakt> sortierteDaten = new TreeSet<Kontakt>(buch.values());
        for(Kontakt kontakt : sortierteDaten) {
            alleEintraege.append(kontakt);
            alleEintraege.append('\n');
            alleEintraege.append('\n');
        }
        return alleEintraege.toString();
    }
    
    /**
     * ?berpr?fe, ob das Datenfeld anzahlEintraege konsistent
     * ist mit der Anzahl der momentan gespeicherten Eintr?ge
     * im Adressbuch.
     * @return true falls das Datenfeld konsistent ist, false sonst.
     */
    private boolean konsistenteGroesse()
    {
        Collection<Kontakt> alleEintraege = buch.values();
        // Entfernen von Duplikaten, da wir mehrere Schl?ssel verwenden.
        Set<Kontakt> ohneDuplikate = new HashSet<Kontakt>(alleEintraege);
        int momentaneEintraege = ohneDuplikate.size();
        return anzahlEintraege == momentaneEintraege;
    }
}
