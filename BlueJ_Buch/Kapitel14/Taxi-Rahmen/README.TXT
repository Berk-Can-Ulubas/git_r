Projekt: Taxi-Rahmen
Autoren: David J. Barnes und Michael K?lling

Dieses Projekt ist Teil des Zusatzmaterials zum Buch

   Java lernen mit BlueJ - eine Einf?hrung in die 
   objektorientierte Programmierung, 4. Auflage
   David J. Barnes und Michael K?lling
   Pearson Education Deutschland, 2008

Dieses Projekt bietet eine Teilimplementierung einer Simulation von Taxis,
die innerhalb einer Stadt Fahrg?ste aufnehmen und transportieren.

Dies ist die erste Version dieses Projekts. Sie illustriert den Rahmen einer
Implementierung, der aus der Interaktion von CRC-Karten abgeleitet wurde.

Startpunkt:
    Erzeugen Sie ein Objekt der Klasse Taxiunternehmen und eines der Klasse 
    Fahrgastquelle. Rufen Sie die Methode erbitteAbholung an der Fahrgastquelle
    auf. Da jedoch noch keine Fahrzeuge erzeugt wurden, wird kein Fahrgast 
    jemals abgeholt werden. (Diese Funktionalit?t ist auch in der Klasse
    Demo festgehalten.)
    
    Erzeugen Sie also mindestens ein Taxi im Konstruktor der Klasse
    Taxiunternehmen und f?gen Sie es in die Menge der Fahrzeuge ein.
    Dann wird einem Fahrgast zumindest ein Taxi zugeteilt, das ihn
    aufnehmen k?nnte. Aber da sich Fahrzeuge bisher noch nicht bewegen,
    wird er dennoch nicht abgeholt werden.
    
