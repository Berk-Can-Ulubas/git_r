import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.*;

/**
 * Ein einfacher Sound-Player. Erzeugen Sie eine Instanz dieser
 * Klasse zum Starten.
 * 
 * Der Sound-Player kann Sound-Clips im WAV-, AU- oder AIFF-Format
 * mit den Standard-Abtastraten abspielen.
 * 
 * @author Michael Kölling und David J Barnes 
 * @version 1.0
 */
public class SoundPlayerGUI extends JFrame
    implements ChangeListener, ActionListener
{
    private static final long serialVersionUID = 20060330L;
    private static final String VERSION = "Version 1.0";
    private static final String AUDIO_VERZEICHNIS = "audio";
    
    private JList dateiliste;
    private JSlider schieberegler;
    private JLabel infoLabel;
    private SoundMaschine player;

    /**
     * Main-Methode zum Starten von der Kommandozeile.
     */
    public static void main(String[] args)
    {
        SoundPlayerGUI gui = new SoundPlayerGUI();
    }
    
    /**
     * Erzeuge einen Sound-Player und zeige seine GUI
     * auf dem Bildschirm an.
     */
    public SoundPlayerGUI()
    {
        super("Sound-Player");
        player = new SoundMaschine();
        String[] audioFileNames = findeDateien(AUDIO_VERZEICHNIS, null);
        fensterErzeugen(audioFileNames);
    }

    /**
     * Spiele die Sound-Datei, die aktuell in der Dateiliste selektiert ist.
     * Wenn keine Datei selektiert ist oder die selektierte Datei keine
     * Sound-Datei ist, tue nichts.
     */
    private void start()
    {
        String dateiname = (String)dateiliste.getSelectedValue();
        if(dateiname == null) {  // nichts selektiert
            return;
        }
        schieberegler.setValue(0);
        boolean erfolgreich = player.start(new File(AUDIO_VERZEICHNIS, dateiname));
        if(erfolgreich) {
            zeigeClipInfo(dateiname + " (" + player.gibClipLaenge() + " Sekunden)");
        }
        else {
            zeigeClipInfo("Datei nicht abspielbar  - unbekanntes Format");
        }
    }

    /**
     * Zeige Informationen über eine selektierte Sound-Datei (Name und Länge).
     * @param text der anzuzeigende Text.
     */
    private void zeigeClipInfo(String text)
    {
        infoLabel.setText(text);
    }
    
    /**
     * Stoppe den aktuell gespielten Sound-Clip (falls einer gespielt wird).
     */
    private void stop()
    {
        player.stop();
    }

    /**
     * Pausiere den aktuell gespielten Sound-Clip (falls einer gespielt wird).
     */
    private void pause()
    {
        player.pause();
    }

    /**
     * Spiele einen pausierten Sound-Clip weiter ab.
     */
    private void weiter()
    {
        player.weiter();
    }

    /**
     * 'Beenden'-Funktion: Beenden der Anwendung.
     */
    private void beenden()
    {
        System.exit(0);
    }
    
    
    /**
     * 'Info'-Funktion: Zeige Informationen zur Anwendung.
     */
    private void zeigeInfo()
    {
        JOptionPane.showMessageDialog(this, 
                    "Sound-Player\n" + VERSION,
                    "Info zum Sound-Player", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Lade die Dateinamen aller Dateien im angegebenen Verzeichnis.
     * @param verzName name des Verzeichnisses.
     * @param suffix der Suffix der Dateien von Interesse.
     * @return die Namen der gefundenen Dateien.
     */
    private String[] findeDateien(String verzName, String suffix)
    {
        File verzeichnis = new File(verzName);
        if(verzeichnis.isDirectory()) {
            String[] alleDateien = verzeichnis.list();
            if(suffix == null) {
                return alleDateien;
            }
            else {
                List<String> selektiert = new ArrayList<String>();
                for(String dateiname : alleDateien) {
                    if(dateiname.endsWith(suffix)) {
                        selektiert.add(dateiname);
                    }
                }
                return selektiert.toArray(new String[selektiert.size()]);
            }
        }
        else {
            System.out.println("Fehler: " + verzName + " muss ein Verzeichnis sein");
            return null;
        }
    }

    // ------- ChangeListener Interface (für den JSlider) -------

    /**
     * Methode aus dem Interface ChangeListener für Änderungen am JSlider.
     * Diese Methode wird aufgerufen, wenn der Benutzer den Schieberegler
     * verändert.
     * @param evt Details über das Event.
     */
    public void stateChanged(ChangeEvent evt)
    {
        player.positioniere(schieberegler.getValue());
    }
    
    // ------- ActionListener Interface (für die JComboBox) -------

    /**
     * Methode aus dem Interface ActionListener für Änderungen an der
     * JComboBox. Diese Methode wird aufgerufen, wenn der Benutzer
     * einen anderen Eintrag in der Combo-Box auswählt.
     * @param evt Details über das Event.
     */
    public void actionPerformed(ActionEvent evt) 
    {
        JComboBox cb = (JComboBox)evt.getSource();
        String format = (String)cb.getSelectedItem();
        if(format.equals("alle Formate")) {
            format = null;
        }
        dateiliste.setListData(findeDateien(AUDIO_VERZEICHNIS, format));
    }

    // ---- Swing-Anteil zum Erzeugen des Fensters mit allen Komponenten ----
    
    /**
     * Konstruktion der kompletten grafischen Benutzungsoberfläche.
     * @param audioDateien die Dateinamen, die angezeigt werden sollen.
     */
    private void fensterErzeugen(String[] audioDateien)
    {
    	// Sicherstellen, dass die Anwendung beendet wird, wenn der
    	// Benutzer das Fenster schließt
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel contentPane = (JPanel)getContentPane();
        contentPane.setBorder(new EmptyBorder(6, 10, 10, 10));

        menuezeileErzeugen();
        
        // Ein Layout mit hübschen Abständen definieren
        contentPane.setLayout(new BorderLayout(8, 8));

        // Die Combo-Box links mit Scrollbalken erzeugen
        JPanel linkerBereich = new JPanel();
        {
            linkerBereich.setLayout(new BorderLayout(8, 8));

            String[] formate = { "alle Formate", ".wav", ".au", ".aif" };
    
            // Die Combo-Box erzeugen
            JComboBox formatListe = new JComboBox(formate);
            formatListe.addActionListener(this);
            linkerBereich.add(formatListe, BorderLayout.NORTH);
    
            // Eine scrollbare Liste der Dateinamen erzeugen
            dateiliste = new JList(audioDateien);
            dateiliste.setForeground(new Color(140,171,226));
            dateiliste.setBackground(new Color(0,0,0));
            dateiliste.setSelectionBackground(new Color(87,49,134));
            dateiliste.setSelectionForeground(new Color(140,171,226));
            JScrollPane scrollPane = new JScrollPane(dateiliste);
            scrollPane.setColumnHeaderView(new JLabel("Audio-Dateien"));
            linkerBereich.add(scrollPane, BorderLayout.CENTER);
        }
        contentPane.add(linkerBereich, BorderLayout.CENTER);

        // Create the center with image, text label, and slider
        // Mittelbereich mit Bild-Label, Text-Label und Schieberegler erzeugen
       JPanel mittelbereich = new JPanel();
        {
            mittelbereich.setLayout(new BorderLayout(8, 8));
    
            JLabel bildLabel = new JLabel(new ImageIcon("title.jpg"));
            mittelbereich.add(bildLabel, BorderLayout.NORTH);
            mittelbereich.setBackground(Color.BLACK);

            infoLabel = new JLabel("  ");
            infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            infoLabel.setForeground(new Color(140,171,226));
            mittelbereich.add(infoLabel, BorderLayout.CENTER);

            schieberegler = new JSlider(0, 100, 0);
            TitledBorder border = new TitledBorder("Positionieren");
            border.setTitleColor(Color.white);
            schieberegler.setBorder(new CompoundBorder(new EmptyBorder(6, 10, 10, 10), border));
            schieberegler.addChangeListener(this);
            schieberegler.setBackground(Color.BLACK);
            schieberegler.setMajorTickSpacing(25);
            schieberegler.setPaintTicks(true);
            mittelbereich.add(schieberegler, BorderLayout.SOUTH);
        }
        contentPane.add(mittelbereich, BorderLayout.EAST);

        // Die Tastenreihe mit den Tasten erzeugen
        JPanel tastenreihe = new JPanel();
        {
            tastenreihe.setLayout(new GridLayout(1, 0));
  
            JButton taste = new JButton("Start");
            taste.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) { start(); }
                               });
            tastenreihe.add(taste);
            
            taste = new JButton("Stop");
            taste.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) { stop(); }
                               });
            tastenreihe.add(taste);
    
            taste = new JButton("Pause");
            taste.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) { pause(); }
                               });
            tastenreihe.add(taste);
            
            taste = new JButton("Weiter");
            taste.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) { weiter(); }
                               });
            tastenreihe.add(taste);
        }
        
        contentPane.add(tastenreihe, BorderLayout.NORTH);

        // Aufbau abgeschlossen - Komponenten arrangieren lassen
        pack();
        
        // Das Fenster in der Mitte des Bildschirms platzieren und anzeigen lassen
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(d.width/2 - getWidth()/2, d.height/2 - getHeight()/2);
        setVisible(true);
    }
    
    /**
     * Erzeugen der Menüzeile.
     */
    private void menuezeileErzeugen()
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar menuezeile = new JMenuBar();
        setJMenuBar(menuezeile);
        
        JMenu menue;
        JMenuItem eintrag;
        
        // Das Datei-Menü erzeugen
        menue = new JMenu("Datei");
        menuezeile.add(menue);
        
        eintrag = new JMenuItem("Beenden");
            eintrag.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            eintrag.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { beenden(); }
                           });
        menue.add(eintrag);

        // Das Hilfe-Menü erzeugen
        menue = new JMenu("Hilfe");
        menuezeile.add(menue);
        
        eintrag = new JMenuItem("Info...");
            eintrag.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { zeigeInfo(); }
                           });
        menue.add(eintrag);
    }
}
