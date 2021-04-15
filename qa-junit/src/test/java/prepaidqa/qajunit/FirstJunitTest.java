package prepaidqa.qajunit;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.swing.Spring;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tag("junit")
@Tags({@Tag("junit"), @Tag("sanity"), @Tag("noParam")})
@DisplayName("First junit test class.")
public class FirstJunitTest {

  private static String STRING_TESTOWY = "stringTestowy";


  @Tags({@Tag("first"), @Tag("string")})
  @Test
  @Disabled("Jira issue 1526, there is any bug")
  @DisplayName("First junit test.")
  public void firstTest() {

    String stringTest = new String("stringTestowy");

    assertEquals(5, 2 + 3);
    assertNotEquals(5, 2 + 4);
    assertTrue(STRING_TESTOWY.contains("st"));
    assertEquals(STRING_TESTOWY, stringTest);
    assertTrue(STRING_TESTOWY.equals(stringTest));
    assertTrue( 5 == 2 + 3);

  }

  @Tag("second")
  @Test
  @RepeatedTest(5)
  @DisplayName("Second junit test.")
  public void secondTest() {
    System.out.println(0.2 * 0.2);

    assertFalse(0.2 * 0.2 == 0.04);

    double result = new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue();
    System.out.println(result);

    assertEquals(result, 0.04);

  }

  @Test
  public void stringTest() {
    String simpleString = "simpleString";
    String simple = "simpleString";

    String simpleString_2 = new String("simpleString");
    String simpleString_3 = new String("simpleString");

    assertSame("simpleString", simpleString);
    assertSame(simpleString, simple);
    assertNotSame(simpleString, simpleString_2);
    assertNotSame(simpleString_2, simpleString_3);

    assertEquals(simpleString_2, simpleString);
    assertEquals(simpleString, "simpleString");
    assertEquals(simple, simpleString);
  }

  @Test
  public void googleTruth() {
    assertThat(STRING_TESTOWY).contains("tring");
  }

  @Tags({@Tag("wordpress"), @Tag("word")})
  @DisplayName("Zadanie 1")
  @Test
  public void zad1() {
    String resultString = "Wordpress powers 100% of the internet";
    String expectedString = "Wordpress powers [number]% of the internet";

    assertThat(resultString).startsWith("Wordpress powers ");
    assertThat(resultString).endsWith("% of the internet");
    assertThat(resultString).matches("Wordpress powers \\d+% of the internet");

    String result = resultString.replace("Wordpress powers ", "").replace("% of the internet", "");
    assertThat(result).matches("^\\d+$");
    int resultNumber = Integer.parseInt(result);
    assertThat(resultNumber > 0);
  }

  @Tags({@Tag("nested"), @Tag("word")})
  @Nested
  @DisplayName("Nested class test.")
  public class NestedTest {

    @Tags({@Tag("nested"), @Tag("word"), @Tag("list")})
    @DisplayName("List test")
    @Test
    public void listTest() {
      List<Integer> result = Arrays.asList(1, 2, 3, 4, 5);
      List<Integer> expected = Arrays.asList(3, 4, 5);

      assertThat(result).containsAnyIn(expected);
      assertTrue(result.containsAll(expected));
      assertThat(result).hasSize(5);
      assertThat(result).containsAnyOf(1, 2, 3);

    }
  }
}
