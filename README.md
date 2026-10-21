# 🍽️ Food Delivery aplikacija

Jednostavna web aplikacija za pregled restorana i njihovih menija, razvijena pomoću programskog jezika **Java** i **Spring Boot** frameworka. 
Aplikacija omogućava korisnicima da pregledaju dostupne restorane, istraže njihovu ponudu jela i vide detaljne informacije o svakom restoranu.

## ✨ Funkcionalnosti

- 🏪 **Prikaz restorana** – Pregled svih dostupnih restorana uz informacije kao što su grad, vrsta kuhinje, ocjena i broj dostupnih jela.
- 🍕 **Prikaz jela** – Pregled objedinjene liste jela koja nude svi restorani.
- 📋 **Detalji restorana** – Prikaz detaljnih informacija o odabranom restoranu, uključujući meni, cijene jela i kategorije hrane.
- 🥗 **Oznake za vegetarijanska jela** – Jednostavno prepoznavanje jela koja su vegetarijanska.
- 🧭 **Jednostavna navigacija** – Kretanje između liste restorana, liste jela i stranica s detaljima pojedinačnih restorana.

## 🛠️ Korištene tehnologije

| Tehnologija | Opis |
|---|---|
| **Java** | Osnovni programski jezik korišten za razvoj aplikacije. |
| **Spring Boot** | Olakšava razvoj i pokretanje Java web aplikacija. |
| **Spring MVC** | Obrađuje HTTP zahtjeve i povezuje kontrolere s prikazom podataka. |
| **Thymeleaf** | Omogućava generisanje dinamičkih HTML stranica pomoću podataka iz Java objekata. |
| **Maven** | Upravlja zavisnostima projekta i omogućava njegovu izgradnju. |

## 📁 Struktura projekta

Projekat koristi standardnu Maven strukturu direktorija.

```text
food-delivery-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/example/food/
│   │   │       ├── FoodApplication.java
│   │   │       ├── controller/
│   │   │       │   └── appcontroller.java
│   │   │       ├── data/
│   │   │       │   └── demodata.java
│   │   │       └── model/
│   │   │           ├── meal.java
│   │   │           └── restaurant.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   │           ├── action.html
│   │           ├── listA.html
│   │           └── listB.html
│   └── test/
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## 📌 Glavne komponente

- **FoodApplication.java** – Glavna klasa koja služi za pokretanje Spring Boot aplikacije.
- **controller/appcontroller.java** – Obrađuje zahtjeve korisnika i određuje koje stranice treba prikazati.
- **data/demodata.java** – Sadrži unaprijed definisane probne podatke o restoranima i jelima. Aplikacija ne koristi bazu podataka za pohranu ovih podataka.
- **model/** – Sadrži modele `Meal` i `Restaurant` koji predstavljaju jela i restorane.
- **templates/** – Sadrži HTML predloške koji se prikazuju pomoću Thymeleafa:
  - `action.html` – Prikazuje detalje restorana i njegov meni.
  - `listA.html` – Prikazuje listu svih restorana.
  - `listB.html` – Prikazuje sva dostupna jela.

## 🚀 Pokretanje aplikacije

Slijedite navedene korake kako biste preuzeli projekat i pokrenuli ga na svom računaru.

### Preduslovi

Prije pokretanja aplikacije potrebno je imati instalirano:

- JDK 17 ili noviji
- Git

### 1. Kloniranje repozitorija

Otvorite terminal i izvršite sljedeću naredbu:

```bash
git clone https://github.com/aminaheljaa/food-delivery-app.git
```

Zatim uđite u direktorij projekta:

```bash
cd food-delivery-app
```

### 2. Pokretanje aplikacije

Na Windows operativnom sistemu izvršite naredbu:

```powershell
.\mvnw.cmd spring-boot:run
```

Maven Wrapper će, ako je potrebno, preuzeti odgovarajuću verziju Mavena i pokrenuti aplikaciju.

### 3. Pristup aplikaciji

Nakon uspješnog pokretanja aplikacije, otvorite web preglednik i unesite adresu:

**http://localhost:8080**

## 💡 Dodatne napomene

- Aplikacija koristi unaprijed definisane probne podatke o restoranima i jelima.
- Nije potrebno podešavati bazu podataka.
- Maven Wrapper je uključen u projekat kako bi se olakšalo njegovo pokretanje bez zasebne instalacije Mavena.

## 🎯 Cilj projekta

Cilj projekta je demonstrirati razvoj jednostavne Java web aplikacije korištenjem tehnologija Spring Boot, Spring MVC i Thymeleaf,
s fokusom na prikaz informacija o restoranima i dinamičko prikazivanje njihovih menija.

