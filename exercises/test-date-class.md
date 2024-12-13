# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

### Constructeur et isValidDate
Constructeur et isValidDate auront les mêmes groupes de données pour les tester car le Constructeur appelle isValidDate avant de jeter ou non une exception. 
Nous avons donc plusieurs cas : 

#### Cas 1 : 
    - Le jour est entre 0 (exclus) et le nombre max de jours dans le mois désigné (inclus),
    - Le mois est entre 1 (inclus) et 12 (inclus) (sauf 2).
    
#### Cas 2 : 
    - Le jour est à 29,
    - Le mois est à Février,
    - L'année est bissextile.
    
#### Cas 3 : 
    - Le jour est à 29,
    - Le mois est à Février,
    - L'année n'est pas bissextile.
    
#### Cas 4 : 
    - Le jour est à 0,
    - Le mois est dans l'intervalle [1, 12].

#### Cas 5 :
    - Le jour est entre 1 et 28, 
    - Le mois est à 0.
    
### isLeapYear 

#### Cas 1 : 
    - L'années est un multiple de 400. 
    
#### Cas 2 : 
    - L'année n'est pas un multiple de 400,
    - L'année est un multiple de 4, 
    - L'année n'est pas un multiple de 100.
    
#### Cas 3 : 
    - L'année n'est pas un multiple de 400, 
    - L'année est un multiple de 4,
    - L'années est un multiple de 100.
    
#### Cas 4 : 
    - L'année n'est pas un multiple de 400,
    - L'année n'est pas un multiple de 4. 
    
### NextDate 

#### Cas 1 : 
    - Le jour + 1 n'est pas supérieur au nombre de jour du mois.
    
#### Cas 2 : 
    - Le mois est dans l'intervalle [0, 11]
    - Le jour + 1 est supérieur au nombre de jour du mois. 
    
#### Cas 3 : 
    - Le mois est à Décembre. 
    - Le jour +1 est supérieur au nombre de jour du mois.
    
### PreviousDate 

#### Cas 1 : 
    - Le jour - 1 est supérieur à 0.
    
#### Cas 2 : 
    - Le mois est dans l'intervalle [2, 12],
    - Le jour - 1 vaut 0. 

#### Cas 3 : 
    - Le mois est Janvier,
    - Le jour - 1 vaut 0. 
    
### getNumberOfDayByMonth

#### Cas 1 : 
    - Le mois est février,
    - L'année est bissextile. 
    
#### Cas 2 : 
    - Le mois est février,
    - L'année n'est pas bissextile.
    
#### Cas 3 : 
    - Le mois est entre Janvier et Juillet (inclus),
    - Le mois est pair.
    
#### Cas 4 : 
    - Le mois est entre Janvier et Juillet (inclus), 
    - Le mois est impair. 
    
#### Cas 5 : 
    - Le mois est entre Août et Décembre (inclus),
    - Le mois est pair.
    
#### Cas 6 : 
    - Le mois est entre Août et Décembre (inclus),
    - Le mois est impair. 
    
### compareTo : 

#### Cas 1 : 
    - Les années sont différentes 
    - La première est la plus grande.
    
#### Cas 2 : 
    - Les années sont les mêmes,
    - Les mois sont différents. 
    - La première est la plus grande.
    
#### Cas 3 : 
    - Les années sont les mêmes, 
    - Les mois sont les mêmes,
    - Les jours sont différents.
    - La première est la plus grande. 
    
#### Cas 4 : 
    - Les années sont différentes 
    - La seconde est la plus grande.
    
#### Cas 5 : 
    - Les années sont les mêmes,
    - Les mois sont différents. 
    - La seconde est la plus grande.
    
#### Cas 6 : 
    - Les années sont les mêmes, 
    - Les mois sont les mêmes,
    - Les jours sont différents.
    - La seconde est la plus grande.
    
#### Cas 7 : 
    - Les dates sont les mêmes.
    
#### Cas 8 : 
    - L'autre date est null.


Tous ces tests nous permettent d'obtenir une couverture de code de 100%.

### Evaluation des prédicats du code. 

#### isValidDate
```day > 0 && month > 0 && month < 13```
A & B & C 
| A | B | C | 
|:-:|:-:|:-:|
| 1 | 1 | 1 | Ce qui équivaut au cas 1 |
| 0 | 1 | 1 | Ce qui équivaut au cas 4 |
| 1 | 0 | 1 | Ce qui équivaut au cas 5 |
| 1 | 1 | 0 | A ajouter dans les tests en temps que cas 6 |

On en conclut un cas 6 où : 
    
- Le jour est entre 0 et 28.
- Le mois est valorisé à 13.
  
#### isLeapYear
```year % 4 == 0 && year % 100 != 0```
A & B
| A | B |
| :-: | :-: |
| 1 | 1 | Cas 2 |
| 0 | 1 | 
| 1 | 0 | Cas 3|

On en conclut un nouveau cas où : 
    
    - L'année n'est pas un multiple de 4
    - L'année est un multiple de 100.
    
Cependant tous les multiples de 4 sont des multiples de 100 donc ce cas est impossible.

### PIT 

Après un premier test nous avons une couverture de mutant 98%. 
```>> Generated 57 mutations Killed 56 (98%)```

Le mutant survivant est un mutant correspondant à : 
```3.3
Location : isValidDate
Killed by : none changed conditional boundary → SURVIVED```
Cependant, puisque nous sommes à 98% de tués, nous pouvons considérer que nous pouvons nous arrêter. 


