package de.hbt.fobi.anagrams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Anagrams {

  private final Collection<String> strings;

  public Anagrams(Collection<String> strings) {
    this.strings = strings;
  }

  public Collection<Set<String>> createAnagramList() {
    Map<AnagramKey, Set<String>> map = new HashMap<>();
    for (String string : strings) {
      AnagramKey anagramKey = new AnagramKey(string);
      Set<String> anagrams = map.computeIfAbsent(anagramKey, k -> new TreeSet<>());
      anagrams.add(string);
    }
    return new ArrayList<>(map.values());
  }

  public static class AnagramKey {

    private final Collection<Character> characters;

    public AnagramKey(String string) {
      this.characters = string.toLowerCase().chars().mapToObj(c -> (char) c).sorted()
          .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      AnagramKey that = (AnagramKey) o;
      return characters.equals(that.characters);
    }

    @Override
    public int hashCode() {
      return Objects.hash(characters);
    }
  }
}
