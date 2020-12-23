package de.hbt.fobi.rome;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class RomeConverterTest {

  @Test
  public void testRomeToDe() {
    int result = RomeConverter.convertRomeToDe("I");
    Assertions.assertThat(result).isEqualTo(1);
  }

  @Test
  public void testRomeToDeSubtractionEasy() {
    int result = RomeConverter.convertRomeToDe("IV");
    Assertions.assertThat(result).isEqualTo(4);
  }

  @Test
  public void testRomeToDeMultipleSubtractions() {
    int result = RomeConverter.convertRomeToDe("CMIV");
    Assertions.assertThat(result).isEqualTo(904);
  }

  @Test
  public void testRomeToDeCrazySubtractions() {
    int result = RomeConverter.convertRomeToDe("MMMCMXCIX");
    Assertions.assertThat(result).isEqualTo(3999);
  }
  @Test
  public void testRomeToDeChainedSubstractions() {
    int result = RomeConverter.convertRomeToDe("IVL");
    Assertions.assertThat(result).isEqualTo(44);
  }

  @Test
  public void testRomeToDeError() {
    Throwable thrown = Assertions.catchThrowable(() -> { RomeConverter.convertRomeToDe("IM"); });
    Assertions.assertThat(thrown).isInstanceOf(Exception.class)
      .hasMessageContaining("Wrong Pizza Recipe");
  }

  @Test
  public void testRomeToDeWrongPizza() {
    Throwable thrown = Assertions.catchThrowable(() -> { RomeConverter.convertRomeToDe("PIZZA"); });
    Assertions.assertThat(thrown).isInstanceOf(Exception.class)
      .hasMessageContaining("Wrong Pizza Recipe");
  }


}
