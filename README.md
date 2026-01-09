# 🥞 Bakkerij de Pannenkoeken ( [project link](https://github.com/CaptainPancakeWithBacon/SoftwareDesign-Project) )
Waar design patterns net zo perfect samenwerken als beslag en boter

Welkom! Stap binnen bij Bakkerij de Pannenkoeken, een plek waar de geur van versgebakken pannenkoeken je tegemoet komt en waar software design patterns ongemerkt achter de schermen hun magie doen.

Dit Java-project laat zien hoe zes bekende design patterns samenwerken in een overzichtelijk, uitbreidbaar en vooral lekker logisch systeem. Geen theoretische voorbeelden, maar een echte bakkerij compleet met bestellingen, toppings, combodeals en kortingsacties.

## 👨‍🍳 De bakkers achter de schermen

Deze bakkerij wordt draaiende gehouden door:

**Lochlan van Herwijnen** – pannenkoek 1 🥞  
https://github.com/herw0011

**Gijs Borghouts** – pannenkoek 2 🥞🥓  
https://github.com/CaptainPancakeWithBacon

Samen hebben zij een systeem gebouwd waarin elk design pattern een eigen taak heeft, net zoals in een echte keuken.

## 🏠 Een kijkje in de bakkerij

Bij Bakkerij de Pannenkoeken begint alles met een bestelling. Wil je een klassieke pannenkoek, een Amerikaanse wafel, of misschien een Zuid-Afrikaanse specialiteit met chocolade en bessen?

Geen probleem. Onze software weet precies:

- hoe het product gemaakt moet worden
- welke toppings erbij kunnen
- hoe combo's worden samengesteld
- en welke korting vandaag geldt

Achter elke stap schuilt een design pattern.

## 🧱 De fundamenten van onze bakkerij (Design Patterns)

### 🏭 1. Factory Pattern – De bakker achter de toonbank (Chef Gijs)

De klant zegt wat hij wil, niet hoe het gemaakt wordt.

De Factory zorgt ervoor dat:
- pannenkoeken en wafels correct worden aangemaakt
- prijzen kloppen
- nieuwe producten makkelijk toegevoegd kunnen worden

**Voorbeelden:**
- Klassieke pannenkoek (€5.50)
- Amerikaanse pannenkoek (€7.00)
- Luikse wafel (€6.50)

**📍 Locatie:** `src/factory/`  
**🧪 Test:** `FactoryTest`

---

### 🧑‍🍳 2. Builder Pattern – De chef in de keuken (Chef Lochlan)

Sommige bestellingen zijn simpel. Andere zijn… kunstwerken.

De Builder:
- bereidt beslag
- voegt boter toe
- kiest toppings
- en levert pas iets af als het perfect is

Zo kun je stap voor stap een product samenstellen zonder chaos in de code.

**📍 Locatie:** `src/builder/`  
**🧪 Test:** `BakeryTest`

---

### 🧺 3. Composite Pattern – De ontbijtcombo's (Chef Gijs)

Waarom één item bestellen als je ook een combo kunt nemen?

Met het Composite pattern:
- combineer je meerdere producten
- kun je combo's in combo's stoppen
- wordt de prijs automatisch berekend

Voor de kassa is een combo gewoon ook eten.

**📍 Locatie:** `src/composite/`  
**🧪 Test:** `CompositeTest`

---

### 🍫 4. Decorator Pattern – Extra toppings, altijd welkom (Chef Lochlan)

Zonder toppings is het leven saai.

Decorators zorgen ervoor dat je:
- siroop
- chocolade
- bessen

kunt toevoegen zonder bestaande code aan te passen. Je kunt ze zelfs stapelen. Net als echte toppings.

**📍 Locatie:** `src/decorators/`  
**🧪 Test:** `DecoratorsTest`

---

### 💸 5. Strategy Pattern – Wie houdt er niet van korting? (Chef Gijs)

Vandaag 20% korting? Happy Hour? Bulkdeal voor grote bestellingen?

Met het Strategy pattern:
- wissel je prijsregels tijdens runtime
- blijft de order hetzelfde
- maar verandert het rekenmodel

De bakker past zich aan, zonder stress.

**📍 Locatie:** `src/strategy/`  
**🧪 Test:** `StrategyTest`

---

### 🔥 6. State Pattern – Van beslag tot perfect gebakken (Chef Lochlan)

Eten doorloopt fases:
1. Rauw
2. Aan het bakken
3. Klaar om te serveren

Het State pattern:
- beheert deze overgangen
- geeft elk stadium eigen gedrag
- voorkomt rare situaties (zoals rauwe pannenkoeken serveren)

**📍 Locatie:** `src/state/`  
**🧪 Test:** `StateTest`

## 🤝 Wanneer alles samenkomt

In de echte bakkerij werken deze patronen tegelijk:
- Factory maakt het product
- State bakt het
- builder regelt een topping
- Decorator versiert het
- Composite bundelt het
- Strategy bepaalt de prijs

Samen vormen ze één soepel systeem.

## 🧠 Het geheime ingrediënt: IFood

Alles in deze bakkerij — pannenkoeken, wafels, toppings en combo's — is uiteindelijk gewoon IFood:

```java
public interface IFood {
    String getDescription();
    double getPrice();
    void prepare();
}
```

Dankzij deze interface kan alles uniform worden behandeld. Voor de kassa maakt het niet uit wat het is — als het maar eten is.
🚀 Zin om uit te breiden?

Deze bakkerij staat open voor groei:

- Nieuwe producten? ✔️

- Nieuwe toppings? ✔️

- Nieuwe kortingen? ✔️

- Nieuwe bereidingsstappen? ✔️

Alles kan, zonder bestaande code te breken.

## 🧪 Tests & Demo

Alle patterns hebben hun eigen testklasse

Main.java laat het hele proces zien

Ontworpen om helder, leerzaam en uitbreidbaar te zijn

##  👨🏼‍🍳👨🏼‍🍳 Werkverdeling Chefs
Om in de bakkerij stress te voorkomen en chaos goed the managen hebben onze sterchefs een goede 50/50 verdeling afgesproken om mekaar goed te ondersteunen.

De chefs zien in dat een hele bakkerij managen allen niet gaat maar dat het wel essentieel is om van iedere stap iets af te weten en hebben hun werk dus ook op die manier verdeeld.

## 🥞 Tot slot

Bakkerij de Pannenkoeken is geen droge design-pattern-opdracht, maar een verhaal waarin software-architectuur tot leven komt.

Net als een goede pannenkoek:

simpel aan de buitenkant

doordacht van binnen

en altijd uit te breiden met iets extra's

### Eet smakelijk! 🚀🥞
