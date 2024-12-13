# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `)]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators, check if the test cases written so far satisfy *Base Choice Coverage*. If needed, add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

1. 
Contenu de la chaine : 
- Vide
- Seulement des symboles ouvert
- Seulement des symboles fermé
- Des symboles ouvert qui correspondent
- Des symboles ouvert qui ne correspondent pas

Symbole : 
- Un seul type de symbole
- Un mix de symboles

Ordre:

- Symboles dans l'ordre 
- Symboles dans le déshordre 

2. Le statement coverage est plutôt complet, mais il manque le cas où des caractères qui ne sont pas parmi la liste des symboles sont inclus dans la liste. On va donc rajouter les tests correspondants.

3. J'ai bien des prédicats avec 2 opérateurs booléens  
`stack.isEmpty() || stack.pop() != '('` et toutes les variantes pour chaque symbole, donc il faut bien faire des tests où chacune des possibilités est testée. Mais les cas sont déjà gérés dans les tests existants.

4. 12 mutants ont été générés et 11 ont été tués, donc 92%. En regardant le rapport PIT, je me suis rendu compte que le mutant restant était en fait le `main` qui avait été utilisé pour vérifier que la méthode `isBalanced` se lançait. En retirant celui-là, on atteint donc 100% de meurtre.
