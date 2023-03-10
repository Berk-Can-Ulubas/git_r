BlueJ-Projekt "Verein".

Autoren: David J. Barnes und Michael K?lling

Dieses Projekt ist Teil des Zusatzmaterials zum Buch

   Java lernen mit BlueJ - eine Einf?hrung in die 
   objektorientierte Programmierung, 4. Auflage
   David J. Barnes und Michael K?lling
   Pearson Education Deutschland, 2008

Zweck des Projekts
==================
Dieses Projekt soll das Verst?ndnis von Objektsammlungen
vertiefen. Die ?bungen k?nnen bearbeitet werden, nachdem
Abschnitt 4.6 von Kapitel 4 abgeschlossen wurde.

Die Aufgabe
===========
Die Mitgliedschaft in einem Verein wird durch eine Instanz
der Klasse Mitgliedschaft repr?sentiert. Eine vollst?ndige
Version der Klasse Mitgliedschaft ist im Projekt Verein
bereits vorgegeben und sollte keine Ver?nderung mehr ben?tigen.
Ein Mitgliedschaft-Objekt enth?lt Informationen ?ber den Namen
einer Person sowie den Monat und das Jahr des Zeitpunktes, an
dem die Person dem Verein beigetreten ist. Alle Daten zu einer
Mitgliedschaft werden angegeben, wenn ein Mitgliedschaft-Objekt
erzeugt wird.

Ihre Aufgabe ist es nun, die Klasse Verein, von der bereits ein
Grobger?st vorhanden ist, zu vervollst?ndigen.

Die Klasse Verein soll ihre Mitgliedschaft-Objekte in einer
Sammlung mit flexibler Gr??e speichern.

Eine neue Mitgliedschaft wird dem Verein ?ber die Methode beitreten
hinzugef?gt, die die folgende Signatur und Beschreibung hat:

    /**
     * F?ge ein neues Mitglied in die Mitgliederliste ein.
     * @param mitglied Infos ?ber das einzuf?gende Mitglied.
     */
    public void beitreten(Mitgliedschaft mitglied)

Sie k?nnen davon ausgehen, dass das Mitgliedschaft-Objekt, 
das als Parameter ?bergeben wird, bereits erzeugt wurde und
vollst?ndig initialisiert ist.

Die Klasse Verein definiert au?erdem eine Methode, die die
Anzahl der Mitglieder des Vereins ausgibt. Sie hat die folgende
Signatur und Beschreibung:

    /**
     * @return die Anzahl der Mitglieder (Mitgliedschaft-Objekte)
     *         in diesem Verein.
     */
    public int anzahlMitglieder()

Die Anzahl der Mitglieder korrespondiert mit der Anzahl der
Mitgliedschaft-Objekte, die aktuell in der Sammlung mit flexibler
Gr??e gespeichert sind.

Vervollst?ndigen Sie die Definition der Klasse Verein. Dies soll
einschlie?en:

    + Ein Datenfeld f?r ein Sammlungsobjekt mit flexibler Gr??e.
    
    + Einen parameterlosen Konstruktor, in dem ein passendes
    Sammlungsobjekt mit flexibler Gr??e zum Speichern der 
    Mitgliedschaft-Objekte.

    + Eine vollst?ndige Definition der Methode beitreten.

    + Eine vollst?ndige Definition der Methode anzahlMitglieder.

Unten sind einige Zusatzaufgaben f?r diejenigen formuliert, die
mit den zus?tzlichen M?glichkeiten von Sammlungen experimentieren
wollen.

M?gliche schrittweise Implementierung
=====================================
Diese Aufgabe wurde in einzelne Abschnitte zerlegt, um Ihnen die
Umsetzung der endg?ltigen Version in kleinen Schritten zu
erm?glichen. Wir empfehlen, dass Sie nach jedem Abschnitt das
Programm ?bersetzen und ausf?hren, um die Richtigkeit Ihrer
?nderungen zu ?berpr?fen.

1. Definieren Sie ein Datenfeld f?r ein Sammlungsobjekt mit
flexibler Gr??e. Benutzen Sie die erforderliche Import-Anweisung
f?r diese Sammlung. Erzeugen Sie im Konstruktor das Sammlungs-
objekt und weisen Sie es dem Datenfeld zu.

2. Vervollst?ndigen Sie die Methode anzahlMitglieder so, dass
diese die Gr??e des Sammlungsobjektes liefert. Diese wird vor
der Implementierung der Methode beitreten nat?rlich immer Null
liefern, aber sie wird nach deren Implementierung f?r weitere
Tests zur Verf?gung stehen.

3. Vervollst?ndigen Sie die Methode beitreten.

Wenn Sie ein neues Mitgliedschaft-Objekt in das Verein-Objekt
auf der Objektleiste einf?gen wollen, gibt es daf?r zwei
M?glichkeiten.

    + Entweder erzeugen Sie ein neues Mitgliedschaft-Objekt
    auf der Objektleiste, rufen die Methode beitreten am
    Verein-Objekt auf klicken auf das Mitgliedschaft-Objekt,
    um den Parameter zu ?bergeben.

    + Oder Sie rufen die Methode beitreten am Verein-Objekt
    auf und tippen:

    new Mitgliedschaft("Mitgliedsname hier...", Monatsnummer-hier, Jahresnummer-hier)

    in die Dialogbox f?r den Konstruktorparameter.

Wenn Sie ein neues Mitglied eingef?gt haben, dann sollten
Sie mit der Methode anzahlMitglieder ?berpr?fen, dass
a) die Methode beitreten tats?chlich in die Sammlung einf?gt
und b) dass die Methode anzahlMitglieder funktioniert.

Zusatzaufgaben
==============
Diese Zusatzaufgaben zielen darauf ab, das Projekt Verein
zu einer vollst?ndigen Anwendung auszubauen. Sie k?nnen
angegangen werden, nachdem Abschnitt 4.9 von Kapitel 4
durchgearbeitet wurde.

+ Definieren Sie eine Methode in der Klasse Verein mit
folgender Signatur und Beschreibung:

    /**
     * Liefere die Anzahl der Mitglieder, die im gegebenen
     * Monat beigetreten sind.
     * @param monat Der Monat, an dem wir interessiert sind.
     * @return wieviele Mitglieder in dem gegebenen Monat
     *         beigetreten sind.
    public int beigetretenInMonat(int monat) 

Wenn der Parameter einen Wert au?erhalb des Bereichs 1-12
hat, dann soll eine Fehlermeldung ausgegeben und Null geliefert
werden.

+ Definieren Sie eine Methode in der Klasse Verein mit
folgender Signatur und Beschreibung:

    /**
     * Entferne alle Mitglieder, die im angegebenen Monat
     * beigetreten sind, aus der Sammlung und liefere sie
     * in einem separaten Sammlungsobjekt zur?ck.
     * @param monat Der Monat des Beitritts.
     * @param jahr Das Jahr des Beitritts.
     */
    public ArrayList entfernen(int monat, int jahr)

Wenn der Parameter einen Wert au?erhalb des Bereichs 1-12
hat, dann soll eine Fehlermeldung ausgegeben und ein
Sammlungsobjekt ohne gespeicherte Objekte geliefert werden.

Achtung: Die Methode entfernen ist deutlich schwerer zu
schreiben als die anderen.
