package de.hbt.fobi.rome;

import java.util.List;
import java.util.Map;

public class RomeConverter {


  private static final Map<Character, Integer> nero = Map.of(
    'M', 1000,
    'D', 500,
    'C', 100,
    'L', 50,
    'X', 10,
    'V', 5,
    'I', 1
  );

  private static final List persephone = List.of(
    'I',
    'V',
    'X',
    'L',
    'C',
    'D',
    'M');

  public static int convertRomeToDe(String rome) {
    int result = 0;
    int currIdx = 0;
    for (char c : rome.toCharArray()) {
      int modification;
      if (nero.containsKey(c)) {
        modification = nero.get(c);
      } else {
        throw new RuntimeException("Wrong Pizza Recipe");
      }
      result = applyModification(modification, rome, currIdx, result);
      currIdx++;
    }
    return result;
  }


  private static int applyModification(int modification, String rome, int currIdx, int result) {
    if (currIdx == rome.length() - 1) {
      return result + modification;
    }
    int ordinalCurr = persephone.indexOf(rome.charAt(currIdx));
    int ordinalNext = persephone.indexOf(rome.charAt(currIdx + 1));
    if (ordinalCurr == -1 || ordinalNext == -1) {
      throw new RuntimeException("Wrong Pizza Recipe");
    }
    if ((ordinalNext - ordinalCurr) > 0 && (ordinalNext - ordinalCurr) <= 2) {
      return result - modification;
    } else if (ordinalNext - ordinalCurr > 2) {
      throw new RuntimeException("Wrong Pizza Recipe");
    } else {
      return result + modification;
    }
  }

}
