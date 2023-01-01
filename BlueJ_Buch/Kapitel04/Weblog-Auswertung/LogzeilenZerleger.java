import java.util.Scanner;

/**
 * Ein LogzeilenZerleger zerlegt eine Zeile aus der
 * Logdatei eines Web-Servers in ihre logischen
 * Einheiten ('Token') und wandelt diese Token in
 * integer-Werte um.
 * Es wird hier davon ausgegangen, dass die Logdatei
 * lediglich ganzzahlige Datums- und Zeitinformationen
 * enth�lt.
 * 
 * @author David J. Barnes und Michael K�lling
 * @version 2008.03.30
 */
public class LogzeilenZerleger
{
    /**
     * Erzeuge einen Zerleger f�r Logzeilen.
     */
    public LogzeilenZerleger()
    {
    }

    /**
     * Zerlege eine Logzeile. Lege die Nummern der Zeile
     * in einem Array ab. Die Anzahl der Token 
     * muss ausreichen, um das Array zu bef�llen.
     * 
     * @param logzeile die Zeile, die zerlegt werden soll
     * @param zeilendaten das Array, in dem die Werte
     *                     gespeichert werden sollen
     */
    public void zerlege(String logzeile, int[] zeilendaten)
    {
        try{
            Scanner tokenizer = new Scanner(logzeile);
            for(int i = 0; i < zeilendaten.length; i++) {
                zeilendaten[i] = tokenizer.nextInt();
            }
        }
        catch(java.util.NoSuchElementException e) {
            System.out.println("Nicht gen�gend Eintr�ge in der Logzeile: " + logzeile);
            throw e;
        }
    }
}
