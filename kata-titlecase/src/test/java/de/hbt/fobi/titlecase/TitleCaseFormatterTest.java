package de.hbt.fobi.titlecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class TitleCaseFormatterTest {

  @Test
  void titleCaseTest_strEmpty() {

    final Collection<String> lowercaseWords = Collections.emptyList();
    final String input = "dies ist EIN einfacher TItel";
    final String expectedResult = "Dies Ist Ein Einfacher Titel";

    String result = new TitleCaseFormatter().format(input, lowercaseWords);

    assertEquals(expectedResult, result);

  }

  @Test
  void titleCaseTest_simpleSentence() {

    final Collection<String> lowercaseWords = Arrays.asList("ist", "ein", "oft", "der", "die", "das", "dies");
    final String input = "dies ist EIN einfacher TItel";
    final String expectedResult = "Dies ist ein Einfacher Titel";

    String result = new TitleCaseFormatter().format(input, lowercaseWords);

    assertEquals(expectedResult, result);

  }

  @Test
  void titleCaseTest_allEmpty() {

    final Collection<String> lowercaseWords = Collections.singletonList("");
    final String input = "";
    final String expectedResult = "";

    String result = new TitleCaseFormatter().format(input, lowercaseWords);

    assertEquals(expectedResult, result);

  }

  @Test
  void titleCaseTest_multipleSpacesAndTabs() {

    final Collection<String> lowercaseWords = Arrays.asList("ist", "ein", "oft", "der", "die", "das", "dies");
    final String input = "dies\tist  EIN\t\teinfacher  TItel";
    final String expectedResult = "Dies ist ein Einfacher Titel";

    String result = new TitleCaseFormatter().format(input, lowercaseWords);

    assertEquals(expectedResult, result);

  }

}