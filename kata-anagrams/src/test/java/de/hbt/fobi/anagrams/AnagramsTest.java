package de.hbt.fobi.anagrams;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnagramsTest {

  @Test
  public void test() {
    Collection<String> strings = Arrays.asList("abc", "cba");
    Anagrams anagrams = new Anagrams();
    Collection<String> result = anagrams.createAnagramList(strings);
    Assertions.assertEquals(1, result.size());
  }
}
