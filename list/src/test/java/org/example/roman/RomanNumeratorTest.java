package org.example.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RomanNumeratorTest {

  private record Case(String roman, long number){}

  private static final List<Case> CASES = List.of(
    new Case("M", 1000),
    new Case("MMMIV", 3004),
    new Case("MCM", 1900),
    new Case("CM", 900),
    new Case("DXIX", 519),
    new Case("DIV", 504),
    new Case("D", 500),
    new Case("CD", 400),
    new Case("CDLXX", 470),
    new Case("C", 100),
    new Case("XC", 90),
    new Case("L", 50),
    new Case("XL", 40),
    new Case("X", 10),
    new Case("IX", 9),
    new Case("V", 5),
    new Case("IV", 4),
    new Case("I", 1)
    );


  @Test
  void getNumerals() {
    RomanNumerator underTest = new RomanNumerator();
    for(Case caze: CASES) {

      String actual = underTest.getNumerals(caze.number());
      String expected = caze.roman();

      Assertions.assertEquals(expected, actual);
    }
  }

  @Test
  void getLongValue() {
    RomanNumerator underTest = new RomanNumerator();
    for(Case caze: CASES) {

      long actual = underTest.getLongValue(caze.roman());
      long expected = caze.number();

      Assertions.assertEquals(expected, actual);
    }
  }
}