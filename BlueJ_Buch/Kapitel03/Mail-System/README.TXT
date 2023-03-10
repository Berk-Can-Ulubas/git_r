Projekt: Mail-System
Autoren: David Barnes und Michael K?lling

Dieses Projekt ist Teil des Zusatzmaterials zum Buch

   Java lernen mit BlueJ - eine Einf?hrung in die 
   objektorientierte Programmierung, 4. Auflage
   David J. Barnes und Michael K?lling
   Pearson Education Deutschland, 2008

Dieses Projekt simuliert ein simples Email-System. MailClients simulieren
die Email-Programme von unterschiedlichen Benutzern. Wenn zwei oder
mehr MailClients erzeugt werden, k?nnen sich diese gegenseitig Nachrichten
schicken. (Dies ist nur eine Simulation: Es werden hier keine echten Emails
versendet. Alle Nachrichten werden nur zwischen den Exemplaren von
EmailClient in diesem Projekt ausgetauscht.)

Startpunkt: Um dieses Projekt zu benutzen erzeugen Sie
 - ein Exemplar von MailServer;
 - ein Exemplar von MailClient; Diesem MailClient muss der MailServer
   als Parameter ?bergeben werden, und es muss ein Name f?r den Benutzer
   des Clients vergeben werden.
 - ein weiteres Exemplar von MailClient mit dem selben MailServer
   und einem anderen Benutzernamen.
   
Weiterhin
 - benutzen Sie die Operation 'sendeNachricht' eines der MailClients, 
   um dem anderen Client eine Nachricht zu schicken;
 - benutzen Sie die Operation 'naechsteNachrichtAusgeben' an dem anderen
   Client, um die empfangene Nachricht anzuzeigen.

Mit diesem Projekt soll die Interaktion zwischen Objekten demonstriert werden.
Es enth?lt externe Operationsaufrufe (Aufrufe von einem Objekt an ein anderes)
und Anweisungen zur Objekterzeugung.

Der Debugger kann benutzt werden, um die Interaktionen zu verfolgen.
