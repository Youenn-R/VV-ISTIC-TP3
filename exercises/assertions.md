# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. L'assertion va échouer car on effectue un test sur un nombre à virgule flottante, et on sait que ces nombres sont approximés. Tester une égalité stricte est donc voué à l'échec. Pour tester des nombres à virgule flottante, il faut effectuer les tests avec une tolérance, en prenant en compte une marge d'erreur.

2. `assertEquals` permet de vérifier l'égalité de la valeur des éléments, alors que `assertSame` permet de vérifier s'il s'agit exactement du même élément.

```Java

int nombreA = 1
int nombreB = 1

assertEquals(nombreA,nombreA) -> Vrai
assertSame(nombreA,nombreA) -> Vrai

assertEquals(nombreA,nombreB) -> Vrai
assertSame(nombreA,nombreB) -> Faux
```

3. On peut utilisé `fail` de plusieurs façon:
- Marquer dans son code des tests non terminés.
- Indiquer un endroit où une exception aurait dû être levée mais où cela n'a pas été le cas.
- Signaler du code qui ne devrait pas être atteint.
- Faire des assertions personnalisées : `fail` est utilisé dans les assertions de JUnit.

4. assertThrows permet de tester une exception avec plus de précision, car cela permet de placer l'assertion au bon moment dans l'exécution des tests. On peut ainsi vérifier si c'est bien la bonne exception au bon moment. Si l'exception est levée à un autre moment que celui prévuen, l'annotation @Test ne permet pas de le détecter. Donc assertThrows gagne en flexibilité et en lisibilité.





