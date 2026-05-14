[[_TOC_]]



# Arhitektura programskog proizvoda i podsustava

Aplikacija **SmartMenza** sastoji se od dva osnovna dijela:
- **Frontend** – Android mobilna aplikacija izrađena u Kotlinu
- **Backend** – .NET 8.0 API sustav koji upravlja podacima i poslovnom logikom

Cilj dokumenta je prikazati strukturu, međusobnu povezanost i ulogu svih modula i projekata koji čine cjelinu sustava SmartMenza

---
# Frontend


Frontend dio aplikacije izrađen je u **Android Studio (Narwhal verzija)**.  
Projekt koristi **modularnu arhitekturu**, čime se postiže bolja čitljivost, održavanje i ponovna upotreba koda.

Glavni moduli su:
- **app**
- **core**
- **mailauth**
- **googleauth**

---

<summary><span style="color:#B22222; font-weight:bold; font-size:15px;">NIJE FINALNO: Opis modula (još u izradi)</span></summary>

## **App modul**

**Lokacija:** `/app`  
**Uloga:** Glavni modul aplikacije – sadrži korisničko sučelje, navigaciju, poslovnu logiku i pozive prema ostalim modulima.

### Struktura:
- `core/` – pomoćne klase poput `SessionManager` (upravljanje sesijama korisnika).  
- `data/` – sadrži `api` i `model` podpakete.  
- `navigation/` – navigacija između fragmenata (`LoginFragment`, `RegistrationFragment`).  
- `ui.theme/` – definiranje tema, boja i tipografije (`Color.kt`, `Theme.kt`, `Type.kt`).  
- `res/` – Android resursi (layouti, stringovi, slike).  

### Uloga u arhitekturi:
- Predstavlja glavni sloj aplikacije koji povezuje sve ostale module. Sadrži korisničko sučelje, navigaciju i logiku interakcije s korisnikom te komunicira s API-jem putem modula `data` i servisnih klasa. 

---

## **Core modul**

**Lokacija:** `/core`  
**Uloga:** Definira zajedničke komponente, sučelja i apstrakcije koje koriste ostali moduli.

### Uloga u arhitekturi:
- Osiguravat će osnovne servise i pomoćne komponente dostupne svim modulima (npr. SessionManager za pohranu i upravljanje tokenima - jednom kada se prebaci). Djeluje kao zajednički temelj koji omogućava modularnost i ponovnu upotrebu koda.

---

## **Mailauth modul**

**Lokacija:** `/mailauth`  
**Uloga:** Implementira funkcionalnosti za prijavu i registraciju korisniku putem maila.

### Uloga u arhitekturi:
- Implementirat će se domenska logika vezana uz prijavu i registraciju korisnika. Komunicirat će se s bazom podataka i API-jem preko zajedničkih komponenti iz `core` modula i prikazivat će podatke kroz sučelje definirano u `app` modulu i dialog resursa u svom vlastitom modulu.

---

## **Googleauth modul**

**Lokacija:** `/googleauth`  
**Uloga:** Implementira funkcionalnosti za prijavu i registraciju korisniku putem Google OAuth.

### Uloga u arhitekturi:
- Slično kao i mailauth, samo što nema posebne resurse za prikaz UI-a vezanog za Google autentifikaciju.

---

### Predviđeni odnos između modula

| Modul | Ovisnost o | Opis komunikacije |
|:------|:------------|:------------------|
| app | core, mailauth, googleauth| Poziva sučelja i koristi implementacije. |
| core | — | Neovisan sloj koji definira apstrakcije. |
| mailauth| core | UI i logika za prijavu/registraciju putem klasičnog maila. |
| googleauth| core | UI i logika za prijavu/registraciju putem Google OAuth. |

---


Backend
=======

Backend sustav aplikacije **SmartMenza** implementiran je kao **višeslojna (layered) arhitektura** s jasno razdvojenim odgovornostima.  
Takav pristup omogućava:
*   lakše održavanje i nadogradnju sustava,
    
*   bolju testabilnost,
    
*   jasnu podjelu poslovne logike i infrastrukture,
    
*   usklađenost sa SOLID principima, posebno **Dependency Inversion Principle (DIP)**.
    
Backend se sastoji od sljedećih slojeva:
*   **SmartMenza.API**
    
*   **SmartMenza.Business**
    
*   **SmartMenza.Data**
    
*   **SmartMenza.Core**
    

* * *

**SmartMenza.API (API sloj)**
-----------------------------

**Uloga:**  
API sloj predstavlja ulaznu točku sustava i zadužen je isključivo za obradu HTTP zahtjeva i vraćanje odgovarajućih HTTP odgovora.

### Odgovornosti:

*   Definiranje REST endpointa (`Controller` klase)
    
*   Validacija osnovnih ulaznih podataka
    
*   Mapiranje odgovora u HTTP statuse (`200 OK`, `400 BadRequest`, `401 Unauthorized`, `500 InternalServerError`)
    
*   Prosljeđivanje zahtjeva poslovnom sloju
    

### Karakteristike:

*   **Nema poslovne logike**
    
*   **Nema direktnog pristupa bazi podataka**
    
*   Ovisnosti se injektiraju putem **Dependency Injection (DI)** mehanizma
    
*   Kontroleri su _clean as possible_, u skladu s preporukama profesorice
    
Primjeri kontrolera:
*   `UserController`
    
*   `DishController`
    
*   `DailyMenuController`
    

* * *

**SmartMenza.Business (Business sloj)**
---------------------------------------

**Uloga:**  
Business sloj sadrži **svu poslovnu logiku aplikacije** i predstavlja središnji dio backend sustava.

### Odgovornosti:

*   Implementacija poslovnih pravila (login, registracija, dohvat menija, filtriranje po kategorijama)
    
*   Obrada i transformacija podataka iz Data sloja
    
*   Vraćanje standardiziranih **Response DTO** objekata prema API sloju
    
*   Generiranje JWT tokena i upravljanje autentifikacijom
    

### Struktura:

*   `Services/` – implementacije servisa (`UserServices`, `DishServices`, `DailyMenuServices`)
    
*   `Services/Interfaces/` – sučelja servisa (`IUserService`, `IDishService`, `IDailyMenuService`)
    
*   `Models/` – Response DTO modeli grupirani po domenama (`Auth`, `Users`, `Dishes`, `DailyMenu`)
    

### SOLID i modularnost:

*   **Dependency Inversion Principle (DIP)**:  
    API sloj ovisi o sučeljima (`IUserService`, `IDishService`), a ne o konkretnim implementacijama
    
*   **Single Responsibility Principle (SRP)**:  
    Svaki servis ima jasno definiranu odgovornost
    
*   Jednostavno mockanje servisa u unit testovima
    

* * *

**SmartMenza.Data (Data sloj)**
-------------------------------

**Uloga:**  
Data sloj zadužen je za rad s bazom podataka i infrastrukturu vezanu uz perzistenciju podataka.

### Odgovornosti:

*   Definicija entiteta (`Dto` modeli)
    
*   Konfiguracija relacija između entiteta
    
*   Upravljanje migracijama baze podataka
    
*   Inicijalno seedanje podataka
    

### Ključne komponente:

*   `AppDBContext` – centralni EF Core kontekst
    
*   `Models/` – entiteti baze (`UserDto`, `DishDto`, `DailyMenuDto`, …)
    
*   `Migrations/` – migracije baze podataka
    

### Napomena:

*   Data sloj **ne sadrži poslovnu logiku**
    
*   Koristi se isključivo putem Business sloja
    

* * *

**SmartMenza.Core (Core / Shared sloj)**
----------------------------------------

**Uloga:**  
Core sloj sadrži zajedničke komponente koje se koriste kroz cijeli sustav.

### Odgovornosti:

*   Definicija **enum** tipova (`UserRole`, `MenuCategory`)
    
*   Dijeljene konstante i pomoćne strukture
    
*   Centralizacija zajedničkih tipova bez ovisnosti o drugim slojevima
    
Core sloj nema ovisnosti prema drugim projektima, čime se osigurava maksimalna neovisnost i ponovna upotreba.

---

SOLID principi u backend arhitekturi
====================================

Backend arhitektura posebno je prilagođena poštivanju **SOLID principa**, s naglaskom na **Dependency Inversion Principle (DIP)**.

* * *

Dependency Inversion Principle (DIP)
------------------------------------

> “High-level modules should not depend on low-level modules.  
> Both should depend on abstractions.”

### Kako je implementirano u projektu

*   Controlleri ovise o **interface-ima**, ne o konkretnim servisima
    
*   Servisi implementiraju sučelja
    
*   Dependency Injection se konfigurira u `Program.cs`


Primjer:
`builder.Services.AddScoped<IUserService, UserServices>();`

`public UserController(IUserService userService)
{
    _userService = userService;
}
`

Ostali SOLID principi 
-------------------------------

*   **S – Single Responsibility**  
    Svaka klasa ima jednu odgovornost  
    (Controller → HTTP, Service → business, Data → baza)
    
*   **O – Open/Closed**  
    Sustav se proširuje dodavanjem novih servisa/DTO-a bez izmjene postojećih
    
*   **L – Liskov Substitution**  
    Implementacije servisa zamjenjive su preko interface-a
    
*   **I – Interface Segregation**  
    Servisi imaju jasna, mala sučelja (`IUserService`, `IDishService`)

---



