Plan iteracija - SmartMenza projekt
===================================

Pregled projekta
----------------

**Naziv projekta:** SmartMenza  
**Metodologija:** SCRUM Framework  
**Trajanje sprinta:** 2 tjedna (14 dana)  
**Ukupno sprintova:** 7  
**Razdoblje razvoja:** 16.10.2025 - 28.01.2026  
**Platforma:** Android (Kotlin) + .NET 8.0 Backend

* * *

SCRUM struktura i procesi
-------------------------

### Definition of Done (DoD)

*   [Link](https://dev.azure.com/Cverglici/Razvoj%20mobilne%20aplikacije/_wiki/wikis/Razvoj-mobilne-aplikacije.wiki/12/Definition-of-Done)

### Definition of Ready (DoR)
* [Link](https://dev.azure.com/Cverglici/Razvoj%20mobilne%20aplikacije/_wiki/wikis/Razvoj-mobilne-aplikacije.wiki/14/Definition-of-Ready)  

### Sprint eventi

*   **Sprint planning** - Prvi dan sprinta
*   **Daily Scrum** - Jednom-dvaput tjedno, zbog obveza i preklapanja u rasporedima
*   **Sprint retrospective and review** - Nakon kraja svakog sprinta

* * *
#Napomena:
Svi Acceptance kriteriji i Given/When/Then raspisane korisničke priče se nalaze ovdje: [Link](https://dev.azure.com/Cverglici/Razvoj%20mobilne%20aplikacije/_wiki/wikis/Razvoj-mobilne-aplikacije.wiki/26/Funkcionalnosti-aplikacije-(epics-korisni%C4%8Dke-pri%C4%8De))

* * *

![image.png](/.attachments/image-9389de31-1a8e-4169-b581-4dda6890987d.png)
Vizualni prikaz planiranih sprintova - datumi usklađeni s našim obvezama.

Sprint 2: Autentifikacija i upravljanje korisnicima
---------------------------------------------------

**Trajanje:** 26.10.2025 - 09.11.2025  
**Sprint cilj:** Implementirati kompletnu autentifikaciju (email i Google OAuth) s registracijom i prijavom korisnika

### User Stories i Story Points

#### 1. Registracija putem e-pošte (5 SP)

**Zadaci:**
*   Dizajn UI ekrana za registraciju (2h)
*   Kreiranje REST API endpointa za registraciju (2h)
*   Validacija unesenih podataka (2h)
*   Pohrana korisničkih podataka i uloge u bazu (1h)
*   Implementacija registracije u Android aplikaciji (3h)
*   Obrada pogrešaka i prikaz odgovarajućih poruka (1h)
*   Testiranje registracije i ispravci (1h)



* * *

#### 2. Registracija/prijava putem Google računa (8 SP)

**Zadaci:**
*   Postavljanje Google OAuth integracije u projektu (2h)
*   Implementacija Google sign-in logike (2h)
*   Preuzimanje korisničkih podataka iz Google profila (1h)
*   Slanje tokena backendu radi validacije i kreiranja/prijave korisnika (2h)
*   Backend endpoint za Google OAuth (1h)
*   Testiranje i debugging integracije (1h)

* * *

#### 3. Prijava putem e-pošte (3 SP)

**Zadaci:**
*   Dizajn UI ekrana za prijavu (1h)
*   Implementacija API endpointa za prijavu (1h)
*   Obrada API odgovora i pohrana JWT tokena u aplikaciju (2h)
*   Implementacija logike odjave i pohrane sesije (1h)
*   Validacija unosa i prikaz grešaka (1h)
*   Testiranje prijave i odjave (1h)

**Ukupno Sprint 2:** 16 Story Points

* * *

Sprint 3: Prikaz dnevnog menija i detalja jela
----------------------------------------------

**Trajanje:** 21.11.2025 - 29.11.2025  
**Sprint cilj:** Omogućiti studentima pregled dnevnog menija i detaljnih informacija o jelima

### User Stories i Story Points

#### 1. Prikaz dnevnog menija u menzi (3 SP)

**Zadaci:**
*   Dizajn UI liste jela (2h)
*   Izrada API endpointa za dohvat dnevnog menija (2h)
*   Obrada API poziva za dohvat jela (2h)
*   Prikaz jela u RecyclerView komponenti (2h)
*   Standardizacija backend DTO-a za listu jela (2h)
*   Testiranje prikaza menija (1h)

* * *

#### 2. Prikaz detalja o jelu (5 SP)

**Zadaci:**
*   Dizajn UI ekrana za detalje jela (2h)
*   Proširenje backend endpointa za detalje jela (1h)
*   Obrada API poziva za dohvat detalja (2h)
*   Implementacija prikaza podataka o jelu (3h)
*   Testiranje prikaza detalja i interakcije (1h)

**Ukupno Sprint 3:** 8 Story Points

* * *

Sprint 4: Filtriranje menija prema tipu obroka
----------------------------------------------

**Trajanje:** 30.11.2025 - 07.12.2025  
**Sprint cilj:** Implementirati filtriranje menija po kategorijama (ručak/večera)

### User Stories i Story Points

#### 1. Pregled jela prema tipu obroka (3 SP)

**Zadaci:**
*   Dodavanje UI elemenata za odabir tipa obroka (2h)
*   Implementacija frontend logike za filtriranje menija (2h)
*   Prikaz filtriranih rezultata u listi (1h)
*   Dodavanje backend kategorije za filtriranje prema tipu obroka (1h)
*   Testiranje funkcionalnosti prebacivanja (1h)

**Ukupno Sprint 4:** 3 Story Points

* * *

Sprint 5: Upload i generiranje slika, CRUD menija
-------------------------------------------------

**Trajanje:** 13.12.2025 - 26.12.2025  
**Sprint cilj:** Omogućiti zaposlenicima upravljanje menijem i slikama jela

### User Stories i Story Points

#### 1. Upload slike jela (3 SP)

**Zadaci:**
*   UI komponenta za odabir i upload slike (2h)
*   Backend API endpoint za spremanje slike (1h)
*   Prikaz preview slike nakon učitavanja (1h)
*   Testiranje funkcionalnosti uploada (1h)

* * *

#### 2. Uređivanje dnevne ponude (13 SP)

**Zadaci:**
*   Dizajn ekrana za unos/izmjenu jela (2h)
*   API endpointi za CRUD operacije (2h)
*   Implementacija CRUD logike u aplikaciji (4h)
*   Validacija podataka o jelu (1h)
*   Testiranje CRUD funkcionalnosti (2h)

* * *

#### 3. Generiranje slike pomoću AI-a (5 SP)

**Zadaci:**
*   Implementacija AI API poziva (2h)
*   Prikaz generirane slike u aplikaciji (1h)
*   Testiranje generiranja (1h)

**Ukupno Sprint 5:** 21 Story Points

* * *

Sprint 6: Prehrambeni ciljevi i AI analiza
------------------------------------------

**Trajanje:** 28.12.2025 - 11.01.2026  
**Sprint cilj:** Implementirati sustav za praćenje prehrambenih ciljeva i AI analizu sastojaka

### User Stories i Story Points

#### 1. Određivanje dnevnog cilja (5 SP)

**Zadaci:**
*   Dizajn ekrana za unos ciljeva (2h)
*   Implementacija pohrane ciljeva u bazu (2h)
*   Validacija unosa (1h)
*   Testiranje (1h)

* * *

#### 2. Ažuriranje dnevnog unosa (8 SP)

**Zadaci:**
*   UI za unos dnevnih unosa (2h)
*   CRUD operacije za unose (3h)
*   Prikaz unosa i grafički prikaz napretka (2h)
*   Implementacija izračuna ukupnih vrijednosti (2h)
*   Testiranje (1h)

* * *

#### 3. Analiza sastojaka (5 SP)

**Zadaci:**
*   Integracija AI API-ja (3h)
*   Dizajn dijela za prikaz nutritivnih podataka (1h)
*   Spremanje rezultata u bazu (1h)
*   Testiranje integracije (1h)

**Ukupno Sprint 6:** 18 Story Points

* * *

Sprint 7: Favoriti, recenzije i statistika
------------------------------------------

**Trajanje:** 20.01.2026 - 28.01.2026  
**Sprint cilj:** Implementirati sustav favorita, recenzija i statistike

### User Stories i Story Points

#### 1. Označavanje najdražih jela (5 SP)

**Zadaci:**
*   API endpointi za dodavanje, dohvat, brisanje favorita (3h)
*   Implementacija logike dodavanja i uklanjanja u aplikaciji (2h)
*   Prikaz liste favorita (2h)
*   Testiranje dodavanja/uklanjanja i prikaza (1h)

* * *

#### 2. Dodavanje ocjena i komentara (8 SP)

**Zadaci:**
*   Dizajn UI komponente za unos i prikaz komentara (1h)
*   API endpointi za CRUD operacije nad komentarima (3h)
*   Implementacija unosa, uređivanja i brisanja komentara (2h)
*   Testiranje (1h)

* * *

#### 3. Prikaz najpopularnijih jela (3 SP)

**Zadaci:**
*   Backend endpoint za dohvat najpopularnijih jela (2h)
*   Dizajn i implementacija prikaza statistike (2h)
*   Testiranje (1h)

* * *

#### 4. Pregled postojećih recenzija (2 SP)

**Zadaci:**
*   Implementacija prikaza recenzija na ekranu detalja jela (2h)
*   API poziv za dohvat svih recenzija po jelu (1h)
*   Testiranje prikaza (1h)

**Ukupno Sprint 7:** 18 Story Points

* * *

Sažetak plana iteracija
-----------------------

| Sprint | Trajanje | Cilj | Story Points |
| --- | --- | --- | --- |
| **Sprint 2** | 26.10.2025 - 09.11.2025 | Autentifikacija i upravljanje korisnicima | 16 SP |
| **Sprint 3** | 21.11.2025 - 29.11.2025 | Prikaz dnevnog menija i detalja jela | 8 SP |
| **Sprint 4** | 30.11.2025 - 07.12.2025 | Filtriranje menija prema tipu obroka | 3 SP |
| **Sprint 5** | 13.12.2025 - 26.12.2025 | Upload/generiranje slika, CRUD menija | 21 SP |
| **Sprint 6** | 28.12.2025 - 11.01.2026 | Prehrambeni ciljevi i AI analiza | 18 SP |
| **Sprint 7** | 20.01.2026 - 28.01.2026 | Favoriti, recenzije i statistika | 18 SP |
| **UKUPNO** |  |  | **84 SP** |

Računali smo kako bi jedan story point bio vrednovan kao 2 sata. To bi značilo da je tih 84 story pointsa vrijedno oko 168 sati rada. To podijeljeno na pet članova tima, iznosi 33.6 sati rada po osobi, što smo procijenili da je otprilike točno ako ne brojimo vrijeme koje smo nepotrebno gubili na uspostavljanju okruženja i borbe sa Git-om, VS-om, i Android Studiom. 
* * *

Velocity tracking
-----------------

**Prosječni velocity:** ~14 SP po sprintu (2 tjedna)  
**Planirani kapacitet:** 84 SP ukupno  
**Isporuka:** MVP verzija aplikacije do kraja Sprint 7

* * *

Rizici i mitigacijske strategije
--------------------------------

| Rizik | Vjerojatnost | Utjecaj | Mitigacija |
| --- | --- | --- | --- |
| Kašnjenje s AI integracijom | Srednja | Visok | Rezervni plan: manualni unos nutritivnih podataka |
| Google OAuth postavke | Niska | Srednji | Rana priprema OAuth credentials |
| Kompleksnost CRUD operacija | Srednja | Srednji | Pair programming, code review |
| Testing debt | Visoka | Visok | DoD uključuje obvezne unit testove |

* * *

Zaključak
---------

Plan iteracija prati SCRUM metodologiju s jasno definiranim sprintovima, user story-ima i acceptance kriterijima. Svaki sprint ima specifičan cilj i isporučuje radnu funkcionalnost (increment). Velocity tracking omogućava prilagodbu plana tijekom razvoja, dok Definition of Done osigurava kvalitetu isporuke.
**Status:** Sprint 2-4 završeni | Sprint 5-7 planirani