/**
 * Ein Logeintrag repr�sentiert die Daten einer
 * Zeile in der Logdatei eines Web-Servers.
 * Die einzelnen Werte werden �ber sondierende
 * Operationen wie gibStunde() und gibMinute()
 * verf�gbar gemacht.
 * 
 * @author David J. Barnes und Michael K�lling.
 * @version 2008.03.30
 */
public class Logeintrag implements Comparable<Logeintrag>
{
    // Array, in dem die Werte einer Logzeile gehalten werden
    private int[] logzeilenwerte;
    // welcher Index liefert welchen Wert aus der Zeile
    private static final int JAHR = 0, MONAT = 1, TAG = 2,
                             STUNDE = 3, MINUTE = 4;
                      
    /**
     * Zerteile eine Logzeile so, dass die einzelnen
     * Werte verf�gbar werden.
     * @param logzeile eine einzelne Zeile aus der Logdatei.
     */
    public Logeintrag(String logzeile)
    {
        // das Array f�r die Werte einer Zeile anlegen
        logzeilenwerte = new int[5];
        // die Werte aus der Zeile auslesen
        LogzeilenZerleger scanner = new LogzeilenZerleger();
        scanner.zerlege(logzeile,logzeilenwerte);
    }
    
    /**
     * @return den Stunden-Wert eines Logeintrags.
     */
    public int gibStunde()
    {
        return logzeilenwerte[STUNDE];
    }

    /**
     * @return den Minuten-Wert eines Logeintrags.
     */
    public int gibMinute()
    {
        return logzeilenwerte[MINUTE];
    }
    
    /**
     * Erzeuge eine Repr�sentation als String.
     * Das Ergebnis ist nicht notwendigerweise
     * identisch mit der urspr�nglichen Logzeile.
     *
     * @return eine Zeichenkette, die die Werte 
     *          der Logzeile enth�lt.
     */
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        for(int wert : logzeilenwerte) {
            // bei einstelligen Werten eine f�hrende
            // Null einf�gen
            if(wert < 10) {
                buffer.append('0');
            }
            buffer.append(wert);
            buffer.append(' ');
        }
        // anh�ngende Leerzeichen abschneiden
        return buffer.toString().trim();
    }
    
    /**
     * Vergleiche die Datums- und Zeitwerte dieses Eintrags
     * mit denen eines anderen.
     * @param andererEintrag der andere Eintrag, mit dem verglichen werden soll.
     * @return Einen negativen Wert, wenn dieser Eintrag einen fr�heren
     *          Zeitpunkt repr�sentiert. Einen positiven Wert, wenn
     *          dieser Eintrag einen sp�teren Zeitpunkt repr�sentiert.
     *          Null, wenn beide Eintr�ge den gleichen Zeitpunkt
     *          repr�sentieren.
     */
    public int compareTo(Logeintrag andererEintrag)
    {
        if(andererEintrag == this) {
            // Es ist das selbe Objekt.
            return 0;
        }
        else {
            // die korrespondierenden Werte vergleichen.
            for(int i = 0; i < logzeilenwerte.length; i++) {
                int differenz = logzeilenwerte[i] - andererEintrag.logzeilenwerte[i];
                if(differenz != 0) {
                    return differenz;
                }
            }
            // kein Wertpaar ist unterschiedlich, also repr�sentieren
            // beide LogEintr�ge denselben Zeitpunkt.
            return 0;
        }
    }
}