package de.hbt.fobi.countingcode;

import java.util.Collection;

/**
 * http://codekata.com/kata/kata13-counting-code-lines/
 *
 * <h1>Kata13: Counting Code Lines</h1>
 * <p>Counting lines of code in Java source is not quite as simple as it seems.</p>
 * <p>This week let's write something vaguely useful: a utility that counts the number of
 * lines of actual code in a Java source file. For the purpose of this exercise, a line is counted if it contains
 * something other than whitespace or text in a comment.</p>
 * <p>Remember that Java comments are either // to the end of line, or /* to the next &#42;/.
 * The block comments do not nest.There may be multiple /* ... &#42;/ comments on a line. Whitespace includes
 * tabs,spaces,carriage returns,and vertical tabs.Oh,and remember that comment start sequences that appear inside Java
 * strings should be ignored.</p>
 * <h1>Goals of the Kata</h1>
 * <p>The mixture of line-based things(single line comments,blank lines,and so on)with
 * the stream-based block comments can make solutions slightly ugly.While coding your solution,consider the structure of
 * your code,and see how well it fits the structure of the problem.As with most of these kata,consider coding multiple
 * alternative implementations.Does what you learned on the first tries affect your approach to subsequent ones?</p>
 */
public class CountingCode {

  public int count(Collection<String> codeLines) {
    int i = 0;
    boolean openComment = false;
    for (String line : codeLines) {
      if (openComment) {
        if (line.contains("*/")) {
          openComment = false;
          line = line.substring(line.indexOf("*/") + 2);
        } else {
          line = "";
        }
      }
      if (!openComment) {
        line = line.replaceAll("\"[^\"\\\\]*(\\\\.[^\"\\\\]*)*\"", "");
        line = line.replaceAll("/\\*([^*]|\\*[^/])*\\*?\\*/", "");
        if (line.contains("//")) {
          line = line.substring(0, line.indexOf("//"));
        }
        if (line.contains("/*")) {
          openComment = true;
          line = line.substring(0, line.indexOf("/*"));
        }
      }
      if (line.trim().isEmpty()) {
        continue;
      }
      i++;
    }
    return i;
  }

}
