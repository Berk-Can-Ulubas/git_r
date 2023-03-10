BlueJ-Projekt "Artikelbestand".
Autoren: David J. Barnes und Michael K?lling

Dieses Projekt ist Teil des Zusatzmaterials zum Buch

   Java lernen mit BlueJ - eine Einf?hrung in die 
   objektorientierte Programmierung, 4. Auflage
   David J. Barnes und Michael K?lling
   Pearson Education Deutschland, 2008

Zweck des Projektes
===================
Dieses Projekt soll das Verst?ndnis von Objektsammlungen
vertiefen, inklusive der Benutzung von Schleifen, Iteratoren
und dem Cast-Operator. Die ?bungen k?nnen bearbeitet werden,
nachdem Abschnitt 4.9 von Kapitel 4 abgeschlossen wurde.


Die Aufgabe
===========
Eine Firma verwaltet den Bestand der Artikel, die sie
verkauft. Ein Objekt der Klasse Bestandsverwalter h?lt
eine Liste beliebiger L?nge mit Artikel-Objekten. Ihre
Aufgabe ist es, die Rumpfimplementierung der Klasse
Bestandsverwalter zu vervollst?ndigen.

Die Klasse BestandDemo soll demonstrieren, wie Objekte der
Klassen Bestandsverwalter und Artikel benutzt werden k?nnen.
Sie k?nnen ein Objekt der Klasse BestandDemo interaktiv
erzeugen und seine Methode demo aufrufen. W?hrend Sie die
Klasse Bestandsverwalter weiterentwickeln, sollte diese Demo
die zunehmende Funktionalit?t demonstrieren.

Die Klasse Bestandsverwalter
============================
Die Klasse Bestandsverwalter benutzt ein LinkedList-Objekt, um
null oder mehr Artikel zu speichern. Ihre Methode neuerArtikel
f?gt einen neuen Artikel in die Sammlung ein. Die folgenden
Methoden m?ssen noch implementiert werden: aufnehmen,
findeArtikel, alleArtikelAnzeigen und mengeImBestand.

+ Die Methode aufnehmen soll den Artikel mit der gegebenen
Nummer finden und dann an diesem die Methode erhoeheBestand
aufrufen.

+ Die Methode findeArtikel soll die Sammlung durchsuchen nach
einem Artikel, dessen Nummer dem Parameter dieser Methode
entspricht. Wenn ein passender Artikel gefunden wurde, dann
soll der Artikel als Ergebnis des Aufrufs zur?ckgeliefert
werden. Wenn kein passender Artikel gefunden wurde, soll die
Methode eine null-Referenz zur?ckliefern.

+ Die Methode alleArtikelAnzeigen soll ?ber die Liste der
Artikel iterieren und f?r jeden das Aufrufergebnis seiner
Methode toString() ausgeben.

+ Die Methode mengeImBestand soll einen Artikel in der
Sammlung mit passender Nummer finden und f?r diesen die
aktuelle Menge im Bestand als Methodenergebnis liefern.
Wenn kein Artikel mit einer passenden Nummer gefunden
wurde, soll Null geliefert werden.

Die Klasse Artikel
==================
Diese Klasse ist vorgegeben und Sie sollten keine
Ver?nderungen an ihr vornehmen m?ssen.

Jeder Artikel, den die Firma anbietet, ist repr?sentiert
durch eine Instanz der Klasse Artikel, die die Artikelnummer,
den Artikelnamen und den aktuellen Bestand dieses Artikels
verwaltet. Die Klasse Artikel definiert die Methode aufnehmen,
mit der Anlieferungen dieses Artikels in den Bestand
registriert werden. Die Methode verkaufeEinen zeichnet auf,
dass dieser Artikel einmal verkauft wurde, indem der
Bestandsz?hler um Eins dekrementiert wird.


Schrittweise Implementierung
============================
Diese Aufgabe wurde in einzelne Abschnitte zerlegt, um Ihnen die
Umsetzung der endg?ltigen Version in kleinen Schritten zu
erm?glichen. Wir empfehlen, dass Sie nach jedem Abschnitt das
Programm ?bersetzen und ausf?hren, um die Richtigkeit Ihrer
?nderungen zu ?berpr?fen.

1. Implementieren Sie die Methode alleArtikelAnzeigen, um 
sicher zu stellen, dass Sie ?ber die Sammlung der Artikel
iterieren k?nnen. Geben Sie jeden Artikel einfach ?ber System.out
aus. Die Benutzung eines Iterators ist der bevorzugte Ansatz,
aber Sie k?nnen auch eine int-Variable als Index verwenden, wenn
Sie das besser verst?ndlich finden.

2. Implementieren Sie die Methode findeArtikel. Diese
unterscheidet sich von der Methode alleArtikelAnzeigen dadurch,
dass nicht notwendigerweise alle Artikel betrachtet werden
m?ssen, bevor der passende gefunden wird. Wenn beispielsweise
der erste Artikel bereits die richtige Nummer hat, dann kann
die Iteration fr?h beendet und der Artikel zur?ckgeliefert
werden. Andererseits ist es m?glich, dass es keinen Artikel
mit passender Nummer gibt. Dann wird die gesamte Sammlung
durchsucht, ohne dass ein Artikel zur?ckgeliefert werden kann.
In diesem Fall sollte eine null-Referenz zur?ckgeliefert
werden.

Wenn Sie nach einem passenden Artikel suchen, werden Sie
die Methode gibNummer an den Artikeln aufrufen m?ssen.
Dazu m?ssen Sie den Cast-Operator einsetzen, wenn Sie ein
Element aus der Liste bearbeiten wollen. Sie k?nnen sich
?ber den Cast-Operator informieren, indem Sie die Diskussion
des Projektes Auktion in Kapitel 4 lesen. Insbesondere
Abschnitt 4.9.3 besch?ftigt sich mit dem Cast-Operator.

3. Implementieren Sie die Methode mengeImBestand. Diese
ist relativ einfach umzusetzen, sobald die Methode
findeArtikel fertig ist. Beispielsweise kann mengeImBestand
die Methode findeArtikel f?r die Suche aufrufen und am
Ergebnis dann die Methode gibBestand aufrufen. Achten Sie
jedoch auf Artikel, die nicht gefunden werden k?nnen.

4. Implementieren Sie die Methode aufnehmen nach einem 
?hnlichen Schema wie bei der Methode mengeImBestand.

Freiwillige Zusatzaufgaben
==========================
+ Implementieren Sie eine Methode im Bestandsverwalter,
die alle Artikel ausgibt, deren Bestand unter einem 
gegebenen Wert liegt (der als Parameter an die Methode
?bergeben wird).

+ Modifizieren Sie die Methode neuerArtikel so, dass
ein neuer Artikel nicht in die Liste eingef?gt werden
kann, wenn diese bereits einen Artikel mit derselben
Nummer enth?lt.

+ F?gen Sie dem Bestandsverwalter eine Methode hinzu,
die einen Artikel anhand des Namens, nicht ?ber seine
Nummer findet.

    public Artikel findeArtikel(String name)

Um dies implementieren zu k?nnen, m?ssen Sie wissen, dass
zwei Strings s1 und s2 mit dem booleschen Ausdruck

    s1.equals(s2)
 
auf Gleichheit untersucht werden k?nnen. Mehr zu diesem
Thema finden Sie in Abschnitt 5.3.3.
