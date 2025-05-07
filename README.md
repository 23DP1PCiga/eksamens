# Animal store

## Apraksts

Šī ir konsoles lietotne, kas imitē dzīvnieku veikala darbību. Lietotājs var aplūkot dzīvnieku un preču sarakstu, pievienot tos grozam, veikt apmaksājumu un pārvaldīt savu konta bilanci.

---

## Funkcionalitāte

* Dzīvnieku sortēšana un kārtošana (pēc cenas, statusa)
* Dzīvnieku rezervācija (izmaksas — 50.0 vienības)
* Preču sortēšana un kārtošana (pēc cenas, kategorijas, meklēšana pēc nosaukuma)
* Preču pievienošana grozam
* Pirkuma apstiprināšana (ja pietiek bilances)
* Bilances skatīšana un papildināšana

---


## Struktūra

* `Main.java` — galvenā klase ar izvēlni un lietotāja saskarni
* `User.java` — lietotāja klase ar grozu un bilanci
* `AnimalManager.java`, `ProductManager.java` — atbild par ielādi, kārtošanu un filtrēšanu
* `Animal.java`, `Product.java` — datu modeļi

---

## CSV faili
 * `animals.csv` — dati par dzīvniekiem
  * `products.csv` — preču saraksts


