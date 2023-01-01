import java.awt.*;
import javax.swing.*;

/**
 * Demonstriert das BoxLayout.
 * 
 * @author David J. Barnes und Michael Kolling
 * @version 2008.03.30
 */
public class BoxLayoutBeispiel
{
    private JFrame fenster;

    /**
     * Konstruktor für Objekte der Klasse BoxLayoutBeispiel
     */
    public BoxLayoutBeispiel()
    {
        fensterErzeugen();
    }

    /**
     * Erzeuge ein BoxLayout and füge fünf Komponenten ein.
     */
    private void fensterErzeugen()
    {
        fenster = new JFrame("BoxLayout-Beispiel");
        
        Container contentPane = fenster.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(new JButton("Erster"));
        contentPane.add(new JButton("Zweiter"));
        contentPane.add(new JButton("Der dritte String ist lang"));
        contentPane.add(new JButton("Vierter"));
        contentPane.add(new JButton("Fünfter"));
        
        fenster.pack();
        fenster.setVisible(true);
    }
}
