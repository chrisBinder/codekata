package de.hbt.fobi.rome;

public class RomeConverter {

  public static int convertRomeToDe(String rome) {
    int result = 0;
    if (rome.startsWith("M")) {
      result += 1000;
    } else if (rome.startsWith("D")) {
      result += 500;
    } else if (rome.startsWith("C")) {

    } else if (rome.startsWith("I")) {
      result += 1;
    }
    return result;
  }

  public static String convertDeToRome(int de) {
    return "II";
  }

}
