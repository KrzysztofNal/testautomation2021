package pl.tmobile.prepaidqa.qajunit;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Parameterized tests")
public class FirstParameterizedTest {

  @DisplayName("Parameterized test value for modulo.")
  @ParameterizedTest(name = "Parameter test with value: {0}.")
  @ValueSource(ints = {5, 15, 25})
  public void paramTest(int param) {
    assertTrue(param % 5 == 0);
  }

  @DisplayName("Parameterized test value for Strings.")
  @ParameterizedTest(name = "Parameter test with string value: {0}.")
  @ValueSource(strings = {"Hello", "Hello junit", "Hello students"})
  public void paramTest(String param) {
    assertThat(param).contains("Hello");
//    assertTrue(param.contains("Hello"));
  }

  @DisplayName("Param test with multi params.")
  @ParameterizedTest(name = "Parameterized test for multi param: {0} and {1}")
  @CsvSource(value = {"Hello ; 5", "Hello junit; 15", " Hello, students ; 25"}, delimiter = ';')
  public void multiParamTest(String stringParam, int intParam) {
    assertThat(stringParam).contains("Hello");
    assertThat(intParam % 5).isEqualTo(0);
  }

  @DisplayName("Param test with params from file.")
  @ParameterizedTest(name = "Param test for multi param: {0}, {1}")
  @CsvFileSource(resources = "/params.txt", delimiter = ';')
  public void multiCsvParamTest(String stringParam, int intParam) {
    assertThat(stringParam).contains("Hello");
    assertThat(intParam % 5).isEqualTo(0);
  }

  @DisplayName("Enum test")
  @ParameterizedTest(name = "Enum Param test: {0}")
  @EnumSource(names = {"A", "AAA"})
  public void enumTest(TestEnum param) {
    System.out.println(param);
  }

  @DisplayName("Enum test")
  @ParameterizedTest(name = "Enum Param test: {0}")
  @EnumSource(value = TestEnum.class)
  public void enumTest2(TestEnum param) {
    System.out.println(param);
  }

  enum TestEnum {
    A, AA, AAA
  }

  @ParameterizedTest(name = "Stream: {0}")
  @MethodSource("stringProvider")
  void testWithExplicitLocalMethodSource(String argument) {
    assertNotNull(argument);
  }

  static Stream<String> stringProvider() {
    return Stream.of("apple", "banan");
  }

  @ParameterizedTest(name = "List: {0}")
  @MethodSource("stringProviderList")
  void testWithExplicitLocalMethodSourceList(String argument) {
    assertNotNull(argument);
  }

  static List<String> stringProviderList() {
    return Arrays.asList("apple", "banan");
  }

  @ParameterizedTest(name = "Param test with stream as arguments: fruits: {0} , number: {1}, coordinates: {2}.")
  @MethodSource("stringIntAndListProvider")
  void testWithMultiArgMethodSource(String str, int num, List<String> list) {
    assertEquals(5, str.length());
    assertTrue(num >=1 && num <=2);
    assertEquals(2, list.size());
  }

  static Stream<Arguments> stringIntAndListProvider() {
    return Stream.of(
        arguments("apple", 1, Arrays.asList("a", "b")),
        arguments("lemon", 2, Arrays.asList("x", "y"))
    );
  }
}
