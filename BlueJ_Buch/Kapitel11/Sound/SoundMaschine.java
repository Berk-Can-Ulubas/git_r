import java.io.*;
import javax.sound.sampled.*;

/**
 * Die Klasse SoundMaschine bietet Funktionalität zum Verarbeiten
 * von Sound-Dateien. Sounds können geladen, abgespielt, pausiert
 * und weitergespielt sowie gestoppt werden.
 * 
 * Eine SoundMaschine kann mehrere Sounds gleichzeitig abspielen,
 * aber nur der zuletzt geladene Sound kann kontrolliert werden
 * (pausieren, weiterspielen, etc.).
 * 
 * Die Sound-Maschine akzeptiert Dateien im WAV, AIFF und AU-Format
 * (wobei nicht alle WAV-Dateien unterstützt werden, abhängig von 
 * der Kodierung in der Datei).
 * 
 * @author Michael Kölling und David J Barnes 
 * @version 1.0
 */
public class SoundMaschine
{
	// Die folgenden drei Datenfelder halten Informationen über den 
	// Sound-Clip, der gerade in dieser Maschine geladen ist.
    private Clip aktuellerClip = null;
    private int aktuellerClipLaenge = 0;
    private int aktuellerClipFrameGroesse = 0;
    
    /**
     * Erzeuge eine Sound-Maschine, die Sound-Dateien abspielen kann.
     */
    public SoundMaschine()
    {
    }

    /**
     * Laden und abspielen einer angegebenen Sound-Datei. Wenn die
     * Datei nicht in einem der akzeptierten Formate vorliegt, wird
     * false zurückgeliefert. Andernfalls wird der Sound abgespielt
     * und es wird true zurückgeliefert. Die Methode kehrt sofort zum
     * Aufrufer zurück (nicht erst nachdem der Sound komplett abgespielt
     * wurde).
     * 
     * @param soundDatei  Die zu ladende Datei.
     * @return  True, wenn die Sound-Datei geladen werden konnte, false sonst.
     */
    public boolean start(File soundDatei)
    {
        if(ladeSound(soundDatei)) {
            aktuellerClip.start();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Stoppen des aktuell abgespielten Sound-Clips (wenn einer abgespielt wird).
     * Wenn kein Clip abgespielt wird, hat diese Methode keinen Effekt.
     */
    public void stop()
    {
        if(aktuellerClip != null) {
            aktuellerClip.stop();
            aktuellerClip = null;
        }
    }            

    /**
     * Pausieren des aktuell gespielten Sound-Clips. Wenn kein Clip abgespielt
     * wird, hat ein Aufruf dieser Methode keinen Effekt.
     */
    public void pause()
    {
        if(aktuellerClip != null) {
            aktuellerClip.stop();
        }
    }

    /**
     * Weiterspielen des aktuell pausierten Sound-Clips. Wenn kein Clip pausiert,
     * bleibt diese Methode ohne Effekt. 
     */
    public void weiter()
    {
        if(aktuellerClip != null) {
            aktuellerClip.start();
        }
    }

    /**
     * Setze die Abspielposition im aktuell abgespielten Sound-Clips auf den 
     * gegebenen 'wert', 'wert' gibt dabei einen Prozentwert (0 bis 100) an.
     * Wenn aktuell kein Clip abgespielt wird, bleibt die Methode ohne Effekt.
     * 
     * @param wert  Die Zielposition in der Sound-Datei, als Prozentwert.
     */
    public void positioniere(int wert)
    {
        if(aktuellerClip != null) {
            int position = aktuellerClipFrameGroesse / 100 * wert;
            aktuellerClip.setFramePosition(position);
        }
    }
    
    /**
     * Setze die Lautstärke des aktuell gespielten Sound-Clips. Wenn kein
     * Clip gespielt wird, bleibt diese Methode ohne Effekt.
     * 
     * @param pegel  Der Lautstärkepegel als ein Prozentwert (0..100).
     */
    public void setzeLautstaerke(int pegel)
    {
        if(aktuellerClip == null) {
            return;
        }
        if(pegel < 0 || pegel > 100) {
            pegel = 100;
        }

        double wert = pegel / 100.0;

        try {
            FloatControl volControl =
              (FloatControl) aktuellerClip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float)(Math.log(wert == 0.0 ? 0.0001 : wert) / Math.log(10.0) * 20.0);
            volControl.setValue(dB);
        } catch (Exception ex) {
            System.out.println("Lautstärke konnte nicht verändert werden");
        }
    }

    /**
     * Liefere die Länge des aktuell geladenen Sound-Clips (in Sekunden).
     * 
     * @return  Die Länge des aktuellen Clips, oder 0, falls
     *          kein Clip abgespielt wird.
     */
    public int gibClipLaenge()
    {
        return aktuellerClipLaenge;
    }

    /**
     * Lade die angegebene Sound-Datei in diese Sound-Maschine.
     * 
     * @return  true, falls erfolgreich,
     *          false, falls die Datei nicht dekodierbar ist.
     */
    private boolean ladeSound(File datei) 
    {
        aktuellerClipLaenge = 0;

        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(datei);
            AudioFormat format = stream.getFormat();

            // Wir können ALAW/ULAW nicht abspielen,
            // also konvertieren wir sie nach PCM
            //
            if ((format.getEncoding() == AudioFormat.Encoding.ULAW) ||
                (format.getEncoding() == AudioFormat.Encoding.ALAW)) 
            {
                AudioFormat tmp = new AudioFormat(
                                          AudioFormat.Encoding.PCM_SIGNED, 
                                          format.getSampleRate(),
                                          format.getSampleSizeInBits() * 2,
                                          format.getChannels(),
                                          format.getFrameSize() * 2,
                                          format.getFrameRate(),
                                          true);
                stream = AudioSystem.getAudioInputStream(tmp, stream);
                format = tmp;
            }
            DataLine.Info info = new DataLine.Info(Clip.class, 
                                           stream.getFormat(),
                                           ((int) stream.getFrameLength() *
                                           format.getFrameSize()));

            aktuellerClip = (Clip) AudioSystem.getLine(info);
            aktuellerClip.open(stream);
            aktuellerClipFrameGroesse = (int) stream.getFrameLength();
            aktuellerClipLaenge = (int) (aktuellerClip.getBufferSize() / 
                              (aktuellerClip.getFormat().getFrameSize() * 
                              aktuellerClip.getFormat().getFrameRate()));
            return true;
        } catch (Exception ex) {
            aktuellerClip = null;
            return false;
        }
    }
}
