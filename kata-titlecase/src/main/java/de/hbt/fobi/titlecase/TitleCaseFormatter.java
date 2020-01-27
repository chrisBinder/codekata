package de.hbt.fobi.titlecase;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TitleCaseFormatter {

  public String format(String str, Collection<String> lowercaseWords) {
    String[] splitted = str.toLowerCase().split("\\s+");
    return IntStream.range(0, splitted.length)
        .filter(i -> !splitted[i].trim().isEmpty())
        .mapToObj(i -> this.formatWord(splitted[i], i, lowercaseWords))
        .collect(Collectors.joining(" "));
  }

  private String formatWord(String word, int index, Collection<String> lowercaseWords) {
    if (index == 0 || lowercaseWords.stream().noneMatch(word::equalsIgnoreCase)) {
      return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
    }
    return word;
  }
}
