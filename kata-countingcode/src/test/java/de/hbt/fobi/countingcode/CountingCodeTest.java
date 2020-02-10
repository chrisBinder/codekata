package de.hbt.fobi.countingcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CountingCodeTest {

  @Test
  public void testEmpty() {
    CountingCode countingCode = new CountingCode();
    int count = countingCode.count(Collections.emptyList());
    Assertions.assertThat(count).isEqualTo(0);
  }

  @Test
  public void testJavaClassWithoutComments() {
    Collection<String> code = Arrays.asList(
        "package de.hbt.fobi.countingcode;",
        "",
        "public class TestClass {",
        "}");
    CountingCode countingCode = new CountingCode();
    int count = countingCode.count(code);
    Assertions.assertThat(count).isEqualTo(3);
  }

  @Test
  public void testJavaClassWithCommentsSimple() {
    Collection<String> code = Arrays.asList(
        "// This file contains 3 lines of code",
        "public interface Dave {",
        "  /**",
        "   * count the number of lines in a file",
        "   */",
        "int countLines(File inFile); // not the real signature!",
        "}");
    CountingCode countingCode = new CountingCode();
    int count = countingCode.count(code);
    Assertions.assertThat(count).isEqualTo(3);
  }

  @Test
  public void testJavaClassWithCommentsComplex() {
    Collection<String> code = Arrays.asList(
        "/*****",
        "* This is a test program with 5 lines of code",
        "*  \\/* no nesting allowed!",
        "//*****//***/// Slightly pathological comment ending...",
        "",
        "public class Hello {",
        "    public static final void main(String [] args) { // gotta love Java",
        "        // Say hello",
        "      System./*wait*/out./*for*/println/*it*/(\"Hello/*\");",
        "    }",
        "",
        "}");
    CountingCode countingCode = new CountingCode();
    int count = countingCode.count(code);
    Assertions.assertThat(count).isEqualTo(5);
  }
}