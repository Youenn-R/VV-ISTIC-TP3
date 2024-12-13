package fr.istic.vv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BalancedStringsTest {

    @Test
    void testChaineVide() {
        assertTrue(StringUtils.isBalanced(""));
    }

    @Test
    void testUnePaire() {
        assertTrue(StringUtils.isBalanced("{}"));
    }

    @Test
    void testNiveauxImbriquesValides() {
        assertTrue(StringUtils.isBalanced("{[()]}"));
    }

    @Test
    void testNiveauxImbriquesInvalides() {
        assertFalse(StringUtils.isBalanced("{[(])}"));
    }

    @Test
    void testOuvrantsNonCorrespondants() {
        assertFalse(StringUtils.isBalanced("{{"));
    }

    @Test
    void testFermantsNonCorrespondants() {
        assertFalse(StringUtils.isBalanced("}}"));
    }

    @Test
    void testOrdreIncorrect() {
        assertFalse(StringUtils.isBalanced("]{"));
    }

    @Test
    void testSymbolesMixtesValides() {
        assertTrue(StringUtils.isBalanced("[{()}]"));
    }

    @Test
    void testSymbolesMixtesInvalides() {
        assertFalse(StringUtils.isBalanced("[{(})]"));
    }

    @Test
    void testUnSeulOuvrantNonFerme() {
        assertFalse(StringUtils.isBalanced("("));
    }

    @Test
    void testUnSeulFermantNonCorrespondant() {
        assertFalse(StringUtils.isBalanced(")"));
    }

    @Test
    void testSymbolesMixtesNonFermes() {
        assertFalse(StringUtils.isBalanced("[("));
    }

    @Test
    void testSymbolesMixtesNonCorrespondants() {
        assertFalse(StringUtils.isBalanced("[])"));
    }
    @Test
    void testSansSymbolesDeGroupe() {
        assertTrue(StringUtils.isBalanced("abc"));
    }

    @Test
    void testSymbolesMixtesEtCaracteresValides() {
        assertTrue(StringUtils.isBalanced("a{b[c]d}e"));
    }
}
