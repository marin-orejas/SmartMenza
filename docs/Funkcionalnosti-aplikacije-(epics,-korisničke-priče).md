[[_TOC_]]


# **Epic: Upravljanje korisnicima**


##  Funkcionalnost: Registracija korisnika

<br></br>**🗒️ Korisnička priča:**  

Kao novi korisnik, želim se registrirati putem e-pošte i lozinke kako bih mogao kreirati račun i koristiti aplikaciju.

**✅ Acceptance Criteria:**
- **Given** da sam na ekranu registracije  
- **When** unesem ispravne podatke (ime, prezime, e-mail, lozinku) i kliknem “Registriraj se”  
- **Then** moj račun se kreira i sprema u bazu s odgovarajućom ulogom (student/zaposlenik)  
- **Or if** ako pokušam registrirati već postojeći e-mail, dobijem poruku o grešci 

🖼️ [Wireframe dokumentacija – Registracija korisnika](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Registracija-korisnika)



---
## Funkcionalnost: Prijava korisnika

<br></br>**🗒️ Korisnička priča:**
  
Kao registrirani korisnik, želim se prijaviti putem e-pošte i lozinke kako bih pristupio svom računu.  

**✅ Acceptance Criteria:**
- **Given** da sam već registriran  
- **When** unesem ispravne podatke i kliknem “Prijavi se”  
- **Then** sustav me autentificira i preusmjeri na glavni ekran  
- **Or if** ako su podaci pogrešni, prikazuje se odgovarajuća poruka o grešci  

🖼️ [Wireframe dokumentacija – Prijava korisnika](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Login)


---

##  Funkcionalnost: Autentifikacija putem Google računa

<br></br>**🗒️ Korisnička priča:**
  
Kao korisnik, želim se prijaviti ili registrirati pomoću Google računa kako bih brže pristupio aplikaciji bez potrebe za lozinkom.  

**✅ Acceptance Criteria:**
- **Given** da sam na ekranu prijave ili registracije  
- **When** odaberem opciju “Nastavi s Googleom”  
- **Then** aplikacija me autentificira putem Google OAuth-a  
- **And** ako sam novi korisnik, kreira se novi račun u bazi  
- **Or if** ako već postojim, samo me prijavi  


<hr style="border: none; height: 1px; background-color: #cccccc; margin: 24px 0;" />

# **Epic: Dnevni meni**

##  Funkcionalnost: Pregled dnevnog menija

<br></br>**🗒️ Korisnička priča 1:**
  
Kao student, želim vidjeti sva jela dana kako bih znao što je dostupno u menzi.

**✅ Acceptance Criteria:**
- **Given** da sam prijavljen korisnik  
- **When** otvorim sekciju "Dnevni meni"  
- **Then** prikazuje mi se popis jela s osnovnim informacijama (ime, kalorije)  

🖼️ [Wireframe dokumentacija – Pregled dnevnog menija](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Student/Dnevni-meni-%2D-Pregled-jela)



---

<br></br>**🗒️ Korisnička priča 2:**
  
Kao student, želim imati mogućnost prikazati koja jela su dostupna na ručku, odnosno na večeri kako bih lakše planirao obroke.

**✅ Acceptance Criteria:**
- **Given** da sam na ekranu za prikaz dnevne ponude  
- **When** kliknem na sekciju “Ručak” ili “Večera”  
- **Then** lista jela se ažurira i prikazuje samo jela tog tipa  
- **And** aktivna sekcija vizualno je označena  

🖼️ [Wireframe dokumentacija – Dnevni meni - Sortiranje jela](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Student/Dnevni-meni-%2D-Sortiranje-jela)

---

##  Funkcionalnost: Pregled detalja o jelu

<br></br>**🗒️ Korisnička priča:**
  
Kao student, želim pregledati detaljne informacije o jelu kako bih znao njegove sastojke i nutritivne vrijednosti.

**✅ Acceptance Criteria:**
- **Given** da sam na ekranu za prikaz dnevnih menija  
- **When** kliknem na određeno jelo  
- **Then** otvara se novi ekran s detaljnim prikazom jela  
- **And** vidim osnovne informacije, popis sastojaka, nutritivne vrijednosti, prosječnu ocjenu i recenzije  

🖼️ [Wireframe dokumentacija – Pregled detalja](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Student/Dnevni-meni--%2D-Detalji)


<hr style="border: none; height: 1px; background-color: #cccccc; margin: 24px 0;" />

# **Epic: Favoriti**

##  Funkcionalnost: CRUD najdražih jela

<br></br>**🗒️ Korisnička priča:**
  
Kao student, želim moći dodati i ukloniti jelo s liste favorita kako bih imao brzi pristup omiljenim jelima.  

**✅ Acceptance Criteria:**
- **Given** da sam na pregledu dnevnih menija  
- **When** kliknem na oznaku srca kod određenog jela  
- **Then** jelo se sprema u moju listu favorita  
- **And** ako ponovno kliknem, jelo se uklanja s liste  
- **And** mogu otvoriti listu favorita i pregledati ih  

🖼️ [Wireframe dokumentacija – Favoriti - CRUD jela](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Student/Favoriti-%2D-CRUD-jela)


<hr style="border: none; height: 1px; background-color: #cccccc; margin: 24px 0;" />

# **Epic: Recenzije**

##  Funkcionalnost: CRUD komentara i ocjena

<br></br>**🗒️ Korisnička priča 1:**
  
Kao student, želim moći ostavljati, uređivati i brisati komentare na jela kako bih podijelio svoje mišljenje o hrani.  

**✅ Acceptance Criteria:**
- **Given** da sam na detaljnijem prikazu određenog jela  
- **When** kliknem na gumb za dodavanje recenzije  
- **Then** moj komentar se sprema u bazu i prikazuje među ostalima  
- **And** mogu urediti ili obrisati vlastiti komentar  
- **And** ne mogu uređivati tuđe komentare  

🖼️ [Wireframe dokumentacija – Unos recenzije](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Student/Recenzije-%2D-prikaz/Unos-recenzije)

---

<br></br>**🗒️ Korisnička priča 2:**
  
Kao student, želim vidjeti recenzije drugih korisnika za određeno jelo kako bih znao koliko je popularno i ukusno.

**✅ Acceptance Criteria:**
- **Given** da sam na ekranu s detaljima jela  
- **When** dođem do sekcije za komentare  
- **Then** vidim popis recenzija s ocjenama, imenima korisnika i datumima  
- **Or if** ako nema recenzija, prikazuje se poruka “Nema recenzija za ovo jelo.”  

🖼️ [Wireframe dokumentacija – Prikaz recenzije](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Student/Recenzije-%2D-prikaz)

<hr style="border: none; height: 1px; background-color: #cccccc; margin: 24px 0;" />

# **Epic: Ciljevi studenta**

##  Funkcionalnost: CRUD prehrambenih ciljeva

<br></br>**🗒️ Korisnička priča:**
  
Kao student, želim ručno unijeti svoje prehrambene ciljeve (kalorije, proteini, masti) kako bih pratio napredak.

**✅ Acceptance Criteria:** 
- **Given** da se nalazim na ekranu za ciljeve  
- **When** stisnem na gumb za uređivanje ciljeva  
- **Then** unosim vlastite prehrambene ciljeve (npr. dnevni unos kalorija, proteina, masti)  
- **And** sustav sprema podatke ako su valjani  
- **Or if** ako unesem neispravan format (npr. tekst umjesto broja) sustav mi ne dozvoljava spremanje podataka  
- **And** sustav me upozori s odgovarajućom porukom  

🖼️ [Wireframe dokumentacija – Određivanje dnevnog cilja](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Student/Ciljevi-%2D-prikaz/Određivanje-dnevnog-cilja)

---

<br></br>**🗒️ Korisnička priča 2:**
  
Kao student, želim unositi i mijenjati svoj dnevni unos hrane.

**✅ Acceptance Criteria:**
- **Given** da se nalazim na ekranu za ciljeve  
- **When** kliknem na gumb za uređivanje dnevnog unosa  
- **And** uređujem stavke unosa prema tome što sam taj dan konzumirao  
- **And** podaci su u valjanom formatu  
- **Then** sustav sprema promjene  
- **And** ukupne vrijednosti (kalorije, proteini, ugljikohidrati, masti) se automatski izračunavaju  
 

🖼️ [Wireframe dokumentacija – Ažuriranje dnevnog unosa](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Student/Ciljevi-%2D-prikaz/Ažuriranje-dnevnog-unosa)

<hr style="border: none; height: 1px; background-color: #cccccc; margin: 24px 0;" />

# Epic: Upravljanje menijima

##  Funkcionalnost: Upload slike

<br></br>**🗒️ Korisnička priča:**
  
Kao zaposlenik, želim učitati vlastitu sliku jela kako bi studenti znali na koje se jelo odnosi.

**✅ Acceptance Criteria:**
- **Given** da sam odabrao detaljan pregled jela za koje želim dodati sliku  
- **When** kliknem na “Upload sliku” i odaberem datoteku  
- **Then** slika se prenosi na poslužitelj i sprema privremeno u bazu  
- **And** prikazuje se preview slike prije daljnje obrade  

🖼️ [Wireframe dokumentacija – Generiranje slike](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Zaposlenik/Meni-%2D-prikaz/Upload-slike-jela)


---

##  Funkcionalnost: CRUD menija

<br></br>**🗒️ Korisnička priča:**
  
Kao zaposlenik, želim dodavati, uređivati i brisati jela s menija kako bih ažurirao ponudu.  

**✅ Acceptance Criteria:**
- **Given** da sam prijavljen kao zaposlenik  
- **When** odaberem opciju za dodavanje, uređivanje ili brisanje jela  
- **Then** promjene se spremaju u bazu i prikazuju u aplikaciji  

🖼️ [Wireframe dokumentacija – Dodaj jelo](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Zaposlenik/Meni-%2D-prikaz/Dodaj-jelo)
<br></br>
🖼️ [Wireframe dokumentacija – Uredi jelo](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Zaposlenik/Meni-%2D-prikaz/Uredi-jelo)

<hr style="border: none; height: 1px; background-color: #cccccc; margin: 24px 0;" />

# Epic: AI tehnologije

##  Funkcionalnost: Dohvat nutritivne analize jela

<br></br>**🗒️ Korisnička priča:**
  
Kao zaposlenik, želim poslati sastojke na AI analizu kako bih dobio nutritivne vrijednosti.  

**✅ Acceptance Criteria:**
- **Given** da sam unio sastojke jela  
- **When** pošaljem ih na AI analizu  
- **Then** dobijem prikaz nutritivnih vrijednosti  

🖼️ [Wireframe dokumentacija – Analiza sastojaka](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Zaposlenik/AI-alati/Analiza-sastojaka)

---

##  Funkcionalnost: Generiranje slike jela

<br></br>**🗒️ Korisnička priča:**
  
Kao zaposlenik, želim generirati AI varijantu slike jela (poboljšana kvaliteta ili stilizirana verzija) kako bih obogatio vizualni sadržaj aplikacije.  

**✅ Acceptance Criteria:**
- **Given** da sam odabrao jelo za koje želim da se generira slika  
- **When** kliknem na “Generiraj AI sliku”  
- **Then** aplikacija šalje sliku na AI API i dobiva generiranu verziju  
- **And** prikazuje novu sliku uz mogućnost pregleda prije spremanja  

🖼️ [Wireframe dokumentacija – Generiranje slike](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Zaposlenik/AI-alati/Generiranje-slike)

<hr style="border: none; height: 1px; background-color: #cccccc; margin: 24px 0;" />

# Epic: Statistika

##  Funkcionalnost: Pregled osnovne statistike

<br></br>**🗒️ Korisnička priča:**
  
Kao zaposlenik, želim vidjeti koja su jela najpopularnija (najviše favorita i komentara) kako bih znao što studenti najviše vole.  

**✅ Acceptance Criteria:**
- **Given** da sam prijavljen kao zaposlenik  
- **When** otvorim sekciju “Statistika”  
- **Then** prikazuje se popis najpopularnijih jela  
- **And** uz svako jelo prikazan je broj favorita i broj komentara  

🖼️ [Wireframe dokumentacija – Statistika - Prikaz najpopularnijih jela](/Dokumentacija-projekta/Skice-ekrana-\(wireframe\)/Zaposlenik/Statistika-%2D-Prikaz-najpopularnijih-jela)





