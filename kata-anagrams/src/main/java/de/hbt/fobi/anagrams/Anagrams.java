package de.hbt.fobi.anagrams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagrams {

  public static void main(String[] args) throws IOException {
    File file = new File("d:\\trainings\\codekata\\wordlist.txt");
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String str;
    Collection<String> strings = new ArrayList<>();
    while ((str = reader.readLine()) != null) {
      strings.add(str);
    }
    Collection<String> anagramList = new Anagrams().createAnagramList(strings);
    anagramList.forEach(System.out::println);
    System.out.println("Anagrams: " + anagramList.size());
  }

  public Collection<String> createAnagramList(Collection<String> strings) {
    Map<List<Character>, StringBuilder> map = new HashMap<>();
    for (String string : strings) {
      List<Character> charList = string.toLowerCase().chars().mapToObj(c -> (char) c).sorted()
          .collect(Collectors.toList());
      StringBuilder anagrams = map.get(charList);
      if (anagrams != null) {
        anagrams.append(" ");
        anagrams.append(string);
      } else {
        map.put(charList, new StringBuilder(string));
      }
    }
    return map.values().stream().map(StringBuilder::toString).collect(Collectors.toList());
  }
}
