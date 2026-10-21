Food Delivery aplikacija
Ovo je jednostavna web aplikacija za pregled restorana i njihove ponude jela, razvijena pomoću programskog jezika Java i Spring Boot frameworka. 
Aplikacija omogućava korisnicima da pregledaju restorane, istraže njihove menije i vide objedinjenu listu svih dostupnih jela.

Funkcionalnosti aplikacije
Prikaz restorana: Pregled svih dostupnih restorana s osnovnim informacijama, kao što su grad, vrsta kuhinje, ocjena i broj dostupnih jela.

Prikaz jela: Pregled svih jela koja nude restorani.

Detalji restorana: Klikom na odabrani restoran otvara se posebna stranica s informacijama o restoranu i njegovim menijem, uključujući cijene i kategorije jela.

Oznake za vegetarijanska jela: Jela su označena prema tome jesu li vegetarijanska ili nisu.

Jednostavna navigacija: Omogućen je jednostavan prelazak između liste restorana, liste jela i stranica s detaljima pojedinačnih restorana.

Korištene tehnologije
Java: Osnovni programski jezik korišten za razvoj aplikacije.

Spring Boot: Framework koji olakšava razvoj i pokretanje Java web aplikacija.

Spring MVC: Koristi se za organizaciju aplikacije, obradu HTTP zahtjeva i povezivanje kontrolera s prikazom podataka.

Thymeleaf: Omogućava prikaz podataka iz Java objekata na HTML stranicama.

Maven: Alat za upravljanje bibliotekama i zavisnostima projekta te izgradnju aplikacije.

Pokretanje aplikacije
Slijedite navedene korake kako biste preuzeli projekat i pokrenuli ga na svom računaru.

Preduvjeti
Instaliran JDK 17 ili noviji.

Instaliran Git.

Instalacija i pokretanje
1. Kloniranje repozitorija

U terminalu izvršite sljedeće naredbe:

git clone https://github.com/aminaheljaa/food-delivery-app.git
cd food-delivery-app
2. Pokretanje aplikacije pomoću Maven Wrappera

Na Windows operativnom sistemu izvršite:

./mvnw.cmd spring-boot:run
Aplikacija će se pokrenuti na zadanim postavkama, na portu 8080.

3. Pristup aplikaciji

Otvorite web preglednik i unesite adresu:

http://localhost:8080

Struktura projekta
Projekat koristi standardnu Maven strukturu direktorija.

src/
├── main/
│   ├── java/org/example/food/
│   │   ├── FoodApplication.java
│   │   ├── controller/
│   │   │   └── appcontroller.java
│   │   ├── data/
│   │   │   └── demodata.java
│   │   └── model/
│   │       ├── meal.java
│   │       └── restaurant.java
│   └── resources/
│       ├── application.properties
│       └── templates/
│           ├── action.html
│           ├── listA.html
│           └── listB.html
└── test/
Opis glavnih dijelova projekta:

FoodApplication.java – glavna klasa za pokretanje aplikacije.

controller/appcontroller.java – obrađuje zahtjeve korisnika i određuje koje će se stranice prikazati.

data/demodata.java – sadrži unaprijed definisane podatke o restoranima i jelima, bez korištenja baze podataka.

model/ – sadrži modele Meal i Restaurant koji predstavljaju jela i restorane.

templates/ – sadrži HTML stranice izrađene pomoću Thymeleafa:

action.html – prikaz detalja restorana i njegovog menija.

listA.html – prikaz svih restorana.

listB.html – prikaz svih dostupnih jela.
