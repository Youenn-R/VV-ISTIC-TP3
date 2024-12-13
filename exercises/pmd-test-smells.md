# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

Les différentes règles définies détectent les mauvaises odeurs suivantes : 
    - Eager test
    
Une analyse a été effectuée sur commons-math avec la règle JUnitUseExpected. Nous pouvons retrouver le résultat dans [ce fichier](./resultAnalyseJUnitUseExpected.txt). 
La première mauvaise erreur relevée provient de ce morceau de code : 

```@Test
    public void testIteratorZeroElement() {
        final int start = 1;
        final int max = 1;
        final int step = 1;

        final IntegerSequence.Incrementor inc
            = IntegerSequence.Incrementor.create()
            .withStart(start)
            .withMaximalCount(max)
            .withIncrement(step);

        Assert.assertFalse(inc.hasNext());
        try {
            inc.increment();
            Assert.fail("exception expected");
        } catch (MaxCountExceededException e) {
            // Expected.
        }
    }```
    
Nous remarquons qu'il s'agit d'un cas de test où nous souhaitons provoquer une erreur MaxCountExceededException mais nous utilisons un try-catch et une assertion au cas où cela
ne passe pas plutôt que l'annotation expected.
Nous pouvons corriger ce cas de test tel qui suit : 

```
@Test(expected=MaxCountExceededException.class)
    public void testIteratorZeroElement() {
        final int start = 1;
        final int max = 1;
        final int step = 1;

        final IntegerSequence.Incrementor inc
            = IntegerSequence.Incrementor.create()
            .withStart(start)
            .withMaximalCount(max)
            .withIncrement(step);

        Assert.assertFalse(inc.hasNext());
        inc.increment();
    }```
