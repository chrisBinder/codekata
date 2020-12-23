package de.hbt.fobi.anagrams;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class AnagramsTest {

  @Test
  void shouldReturnEmptyList() {
    Collection<String> strings = Collections.emptyList();
    Collection<Set<String>> result = new Anagrams(strings).createAnagramList();
    Assertions.assertThat(result).hasSize(0);
  }

  @Test
  void shouldFindOneAnagram() {
    Collection<String> strings = asList("abc", "cba");
    Collection<Set<String>> result = new Anagrams(strings).createAnagramList();
    Assertions.assertThat(result)
        .containsOnly(new HashSet<>(strings));
  }

  @Test
  void shouldFindOneAnagramNotCaseSensitive() {
    Collection<String> strings = asList("abc", "CAB");
    Collection<Set<String>> result = new Anagrams(strings).createAnagramList();
    Assertions.assertThat(result)
        .containsOnly(new HashSet<>(strings));
  }

  @Test
  void shouldFindNoAnagrams() {
    String string1 = "abc";
    String string2 = "dba";
    Collection<String> strings = asList(string1, string2);
    Collection<Set<String>> result = new Anagrams(strings).createAnagramList();
    Assertions.assertThat(result)
        .containsOnly(new HashSet<>(singletonList(string1)),
            new HashSet<>(singletonList(string2)));
  }

  @Test
  void shouldFindTwoAnagrams() {
    String string1 = "abc";
    String string2 = "mlb";
    String string3 = "cba";
    String string4 = "blm";
    Collection<String> strings = asList(string1, string2, string3, string4);
    Collection<Set<String>> result = new Anagrams(strings).createAnagramList();
    Assertions.assertThat(result)
        .containsOnly(new HashSet<>(asList(string1, string3)),
            new HashSet<>(asList(string2, string4)));
  }

  @Test
  void shouldHandleComplexWordlist() throws Exception {
    Collection<String> strings = readFile("wordlist.txt");
    long time = System.currentTimeMillis();
    Collection<Set<String>> anagramList = new Anagrams(strings).createAnagramList();
    System.out.println("time: " + (System.currentTimeMillis() - time) + " ms; size: " + anagramList.size());
    Assertions.assertThat(anagramList).isNotEmpty();
  }

  private Collection<String> readFile(String resourceFileName) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(
        AnagramsTest.class.getClassLoader().getResourceAsStream(resourceFileName))));
    String str;
    Collection<String> strings = new ArrayList<>();
    while ((str = reader.readLine()) != null) {
      strings.add(str);
    }
    return strings;
  }
}
