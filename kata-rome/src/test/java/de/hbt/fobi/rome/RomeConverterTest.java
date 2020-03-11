package de.hbt.fobi.rome;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomeConverterTest {

  @Test
  public void testRomeToDe() {
    int result = RomeConverter.convertRomeToDe("I");
    Assertions.assertThat(result).isEqualTo(1);
  }

}
