package pl.tmobile.prepaid.java;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import pl.tmobile.prepaid.java.enums.Status;
import pl.tmobile.prepaid.java.enums.TelephoneEnum;
import pl.tmobile.prepaid.java.main.Calc;
import pl.tmobile.prepaid.java.main.Calc2;
import pl.tmobile.prepaid.java.main.Calc3;
import pl.tmobile.prepaid.java.main.CalculatorInt;
import pl.tmobile.prepaid.java.main.TelephoneMotorolla;
import pl.tmobile.prepaid.java.main.TelephoneNokia;
import pl.tmobile.prepaid.java.main.TelephoneSamsung;
import pl.tmobile.prepaid.java.module.StringMessage;

public class TrainingMain {

  public static void main(String[] args) {

//    zad1();

//    ifologia();

    System.out.println("--------------------------------");
//    int i = 1;

    Calculator calculator = new Calculator(25, 5);
//    calculator.nested();
//    calculator.whileLoop();
//    calculator.doWhileLoop();
//    loops(calculator);
//    extendsAndInterface();
//    dates();
//    enums();

//    collection();


  }

  private static void collection() {
    int[] inty = {1,2,5,9,4,5};

    List<Integer> intList = new ArrayList<>();
    int ia = 5;

    Integer ii = Integer.valueOf(6);
    intList.add(1);
    intList.add(ia);
    intList.add(ia);
    intList.add(ia);
    intList.add(ia);
    intList.add(ii);
    intList.add(ii);
    intList.add(ii);
    intList.add(ii);
    intList.add(5);
    intList.add(49);
    intList.add(1268);
    intList.add(1268);
    intList.add(698);
    intList.add(6);
    intList.add(-569);
//    intList.add(null);
//    intList.add(null);
//    intList.add(null);
//    intList.add(null);

    System.out.println(intList);

    List<Integer> intlist2 = new ArrayList<>();
    intlist2.add(5);
    intlist2.add(49);
    intlist2.add(1268);
    intlist2.add(698);

    System.out.println(intList.containsAll(intlist2));
    System.out.println(intList.contains(2));
    System.out.println(intList.get(0));
    System.out.println(intList.get(1));
    System.out.println(intList.get(intList.size() - 1));
    System.out.println(intList.remove(Integer.valueOf(1268)));
    System.out.println(intList.remove(6));
    System.out.println(intList);

    System.out.println("---------------------------------------------");

    Set<Integer> intHashSet = new HashSet<>();

    intHashSet.add(6);
    intHashSet.add(6);
    intHashSet.add(6);
    intHashSet.add(156);
    intHashSet.add(156);
    intHashSet.add(16);
    intHashSet.add(16);
    intHashSet.add(1);
//    intHashSet.add(null);

    System.out.println(intHashSet);

    Set<Integer> intTreeSet = new TreeSet<>();

    intTreeSet.add(6);
    intTreeSet.add(6);
    intTreeSet.add(6);
    intTreeSet.add(156);
    intTreeSet.add(156);
    intTreeSet.add(16);
    intTreeSet.add(16);
    intTreeSet.add(1);
//    intTreeSet.add(null);

    System.out.println(intTreeSet);

//    Set<Telephone> telephones = new HashSet<>();
    Set<Telephone> telephones = new TreeSet<>();
    telephones.add(new Telephone());
    telephones.add(new Telephone());
    telephones.add(new Telephone());
    telephones.add(new Telephone());
    telephones.add(new Telephone());

    System.out.println(telephones);

    intTreeSet.addAll(intList);

    System.out.println(intTreeSet);

    intTreeSet.forEach(in -> {
      if (in < 100) {
        System.out.println(in);
      }
    });

    System.out.println("-----------------------------------------");
    List<Telephone> telephoneList = new ArrayList<>();
    telephoneList.add(new Telephone());
    telephoneList.add(new TelephoneMotorolla());
    telephoneList.add(new TelephoneNokia());
    telephoneList.add(new TelephoneSamsung());

//    System.out.println(telephoneList);

    telephoneList.forEach(tel -> {
      if  (tel instanceof TelephoneNokia) {
        System.out.println();
      }
    });

    for (int iab = 0; iab < telephoneList.size() -1; iab++){
      telephoneList.get(iab);
    }

    System.out.println("-----------------------------------------");
    Map<String, String> mapy = new HashMap<>();

    mapy.put("Name", "Ola");
    mapy.put("Name", "Kasia");
    mapy.put("Surname", "Kowalska");
    System.out.println(mapy);

    mapy.forEach((key, value) -> {
      System.out.println(key);
      System.out.println(value);
    });
    System.out.println("-----------------------------------------");

    Map<TelephoneEnum, List<Telephone>> telephonesMap = new HashMap<>();

    List<Telephone> motorallas = new ArrayList<>();

    motorallas.add(new TelephoneMotorolla());
    motorallas.add(new TelephoneMotorolla());
    motorallas.add(new TelephoneMotorolla());
    motorallas.add(new TelephoneMotorolla());

    List<Telephone> nokias = new ArrayList<>();

    nokias.add(new TelephoneNokia());
    nokias.add(new TelephoneNokia());
    nokias.add(new TelephoneNokia());
    nokias.add(new TelephoneNokia());

    telephonesMap.put(TelephoneEnum.MOTOROLLA, motorallas);
    telephonesMap.put(TelephoneEnum.NOKIA, nokias);

    System.out.println(telephonesMap);

    telephonesMap.forEach((key, value) -> {
      System.out.println(key);
      value.forEach(System.out::println);
    });

    System.out.println(telephonesMap.get(TelephoneEnum.NOKIA));

    System.out.println("-----------------------------------------------");

    long count = telephoneList.stream()
        .filter(tele -> tele instanceof TelephoneNokia)
        .count();
    System.out.println(count);

    List<Double> wides = telephoneList.stream()
        .map(telephone -> telephone.getWide())
        .collect(Collectors.toList());

    System.out.println(wides);

    Optional<Double> doubleOptional = telephoneList.stream()
        .map(telephone -> telephone.getWide())
        .filter(tele -> tele.equals(8.65))
        .findFirst();

    if (doubleOptional == null ) {

    }

    Double doubleOptional_2 = telephoneList.stream()
        .map(telephone -> telephone.getWide())
        .filter(tele -> tele.equals(8.65))
        .findFirst().get();
  }

  private static void enums() {
    status(Status.ACTIVE);

    Telephone telephone = getTelephone(TelephoneEnum.MOTOROLLA);
    System.out.println(telephone);
  }

  public static Telephone getTelephone(TelephoneEnum telephoneEnum) {
    switch (telephoneEnum) {
      case SAMSUNG:
        return new TelephoneSamsung();
      case NOKIA:
        return new TelephoneNokia();
      case MOTOROLLA:
        return new TelephoneMotorolla();
      default:
        return new Telephone();
    }
  }

  public static void status(Status status) {
    switch (status) {
      case ACTIVE:
        System.out.println("Status = " + status.getFunction());
        break;
      case STATE:
        System.out.println("Status = " + status.getFunction());
        break;
      case DELETE:
        System.out.println("Status = " + status.getFunction());
        break;
      default: System.out.println("Status brak");
    }
  }

  private static void dates() {
    LocalDate localDate = LocalDate.of(2015, 02, 20);
    System.out.println(localDate.toString());
    localDate = LocalDate.parse("2015-02-20");
    System.out.println(localDate.toString());
    localDate = LocalDate.of(2015, Month.JANUARY, 20);
    System.out.println(localDate.toString());
    localDate = LocalDate.now().minusWeeks(1);
    System.out.println(localDate.toString());

    LocalTime localTime = LocalTime.of(23, 59,59);
    System.out.println(localTime);
    localTime = LocalTime.parse("23:59:59");
    System.out.println(localTime);
    localTime = LocalTime.now().plusHours(3);
    System.out.println(localTime);

    LocalDateTime localDateTime = LocalDateTime.of(2015, 02, 20, 23, 59,59);
    System.out.println(localDateTime.toString().replace("T", "  "));
    LocalDateTime localDateTime2 = LocalDateTime.parse("2012-02-01T05:30:00");
    System.out.println(localDateTime2);

    Date date = new Date();
    System.out.println(date.getDate());

    ZoneId zoneId = ZoneId.of("Europe/Paris");
    ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
    System.out.println(zonedDateTime);
    LocalTime initialTime = LocalTime.of(6, 30, 0);
    LocalTime lastTime = initialTime.plus(Duration.ofHours(5));
    System.out.println(Duration.between(initialTime, lastTime).getSeconds());

    LocalDate localDate1 = LocalDate.now();

    System.out.println(localDate1);

    String localFormat = localDate1.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    System.out.println(localFormat);
    localFormat = localDate1.format(DateTimeFormatter.ofPattern("yyyy/dd/MM"));
    System.out.println(localFormat);
    localFormat = localDate1.format(DateTimeFormatter.ofPattern("dd_MM_yy"));
    System.out.println(localFormat);
  }

  private static void extendsAndInterface() {
    System.out.println(StringMessage.FINAL_MESSAGE);
    System.out.println(StringMessage.FINAL_MESSAGE_2);

    System.out.println(StringMessage.staticMethod("extra text"));

    TelephoneSamsung telephoneSamsung = new TelephoneSamsung();

    CalculatorInt calculat = new Calc();
    CalculatorInt calculat2 = new Calc2();
    CalculatorInt calculat3 = new Calc3();

    System.out.println(calculat.calculate("calc 1"));
    System.out.println(calculat2.calculate("calc 2"));
    System.out.println(calculat3.calculate("calc 3"));

    CalculatorInt[] calculators = {calculat, calculat2, calculat3};

    for (CalculatorInt calc : calculators) {
      System.out.println(calc.calculate("mess"));
    }

    Telephone[] telephones = {new TelephoneSamsung(), new TelephoneNokia()};
  }

  private static void loops(Calculator calculator) {
    int[] table = {1,2,5,3,6,9,9,9};
    table = new int[5];
    System.out.println("table[2] =" + table[2]);
//    table = new int[]{1,2,3,4,5,6};
    table[0] = 56;
    table[1] = 89;

    for (int i = 1; i < table.length ; i++) {
      System.out.println(table[i]);
    }

    final String ania = new String("Ania");
    String[] stringTable = {"Ania", "Ola", "Kasia", "Ola", ania, ania};

    stringTable[1] = "Dorota";

    String[][] multiTable = {{"Ania", "kasia"}, {"Ola", "Dorota", "Basia"}};

    for (int i = 0; i < multiTable.length; i++) {
      System.out.println("i: " + i);
      for (int j = 0; j < multiTable[i].length; j++) {
        System.out.println("j: " + j);
      }
      System.out.println();
    }

    for (int i : table) {
      System.out.println(i);
    }

    calculator.met(1, "message", "Kasia", "Basia", "Ola");
  }

  private static void ifologia() {
    Calculator calculator = new Calculator(25, 5);

    int result = calculator.calculate("+");
    System.out.println(result);
    result = calculator.calculate("-");
    System.out.println(result);

    result = calculator.calculate("*");
    System.out.println(result);

    result = calculator.calculate("/");
    System.out.println(result);

    Calculator calculator2 = new Calculator(25, 0);
    System.out.println(calculator2.calculate("/"));

    System.out.println(calculator2.divide());

    System.out.println("--------------------------------");
    System.out.println(calculator.calculating("+"));
//    System.out.println(calculator.calculating("t"));
  }

  private static void zad1() {
    int jakasZmienna = 15;
    System.out.println(jakasZmienna);

    System.out.println("Pierwszy komentarz wywołania.");

//    Telephone telephone = new Telephone();
//    System.out.println(telephone.getSerialNumber());

//    telephone.serialNumber = "ttttttttt";
//    telephone.setSerialNumber("ttttttttt");

//    System.out.println(telephone.getSerialNumber());
//
//    System.out.println(telephone.area);
//    System.out.println(telephone.areaObject);
//    System.out.println(telephone.corner);
//    System.out.println(telephone.cornerObject);
//    System.out.println(telephone.length);
//    System.out.println(telephone.lengthObject);
//    System.out.println(telephone.pixel);
//    System.out.println(telephone.pixelObject);
//    System.out.println(telephone.wide);
//    System.out.println(telephone.wideObject);
//    System.out.println(telephone.removableCover);
//    System.out.println(telephone.removableCoverObject);
//    System.out.println(telephone.buttonsNumber);
//    System.out.println(telephone.signature);
//
//    Telephone telephone2 = new Telephone();
//    System.out.println(telephone2.serialNumber);

    Telephone telephone3 = new Telephone(
        "oposerwer465465",
        (short) 4,
        (short) 4,
        2147483647,
        2147483647,
        9223372036854775807L,
        9223372036854775807L,
        12.65F,
        12.65F,
        8.65,
        8.65,
        true,
        true ,
        (byte) 127,
        (char) 72
    );

    System.out.println(telephone3);
    System.out.println(telephone3.getSerialNumber());
    System.out.println(telephone3.getCorner());
    System.out.println(telephone3.getCornerObject());
    System.out.println(telephone3.getArea());
    System.out.println(telephone3.getAreaObject());
    System.out.println(telephone3.getPixel());
    System.out.println(telephone3.getPixelObject());
    System.out.println(telephone3.getLength());
    System.out.println(telephone3.getLengthObject());
    System.out.println(telephone3.getWide());
    System.out.println(telephone3.getWideObject());
    System.out.println(telephone3.isRemovableCover());
    System.out.println(telephone3.getRemovableCoverObject());
    System.out.println(telephone3.getButtonsNumber());
    System.out.println(telephone3.getSignature());

//    telephone3.serialNumber = "zmiana";
//
//    TelephoneSamsung telephoneSamsung = new TelephoneSamsung();
//
//    telephoneSamsung.serialNumber = "sdfsdf";

    /*
      komentarze
    */

    System.out.println("-----------------------------------------");

    Telephone telephone5 = new Telephone((short) 5, 12L, 12.65);

    System.out.println(telephone5);
    System.out.println(telephone5.getSerialNumber());
    System.out.println(telephone5.getCorner());
    System.out.println(telephone5.getCornerObject());
    System.out.println(telephone5.getArea());
    System.out.println(telephone5.getAreaObject());
    System.out.println(telephone5.getPixel());
    System.out.println(telephone5.getPixelObject());
    System.out.println(telephone5.getLength());
    System.out.println(telephone5.getLengthObject());
    System.out.println(telephone5.getWide());
    System.out.println(telephone5.getWideObject());
    System.out.println(telephone5.isRemovableCover());
    System.out.println(telephone5.getRemovableCoverObject());
    System.out.println(telephone5.getButtonsNumber());
    System.out.println(telephone5.getSignature());

    String toString = telephone5.toStringMethode();
    System.out.println(toString);

    telephone5.toStringVoid();

    System.out.println(telephone3.toString());
    System.out.println(telephone5.toString());

    Telephone telephone4 = new Telephone(
        "oposerwer465465",
        (short) 4,
        (short) 4,
        2147483647,
        2147483647,
        9223372036854775807L,
        9223372036854775807L,
        12.65F,
        12.65F,
        8.65,
        8.65,
        true,
        true ,
        (byte) 127,
        (char) 72
    );

    System.out.println(telephone3.equals(telephone4));

    String zmienna1 = "zmienna";
    String zmienna2 = "zmienna";
    String zmienna3 = "zmienna";
    String zmienna4 = "zmienna";

    String zmiennaObjektowa1 = new String("zmienna");
    String zmiennaObjektowa2 = new String(zmienna2);
    String zmiennaObjektowa3 = new String("zmienna");

    System.out.println(zmienna1);
    System.out.println(zmienna2);
    System.out.println(zmiennaObjektowa1);
    System.out.println(zmiennaObjektowa2);
    System.out.println(zmiennaObjektowa3);

    System.out.println(zmienna1 == zmienna2);
    System.out.println(zmienna1 == zmiennaObjektowa1);
    System.out.println(zmienna1 == zmiennaObjektowa2);
    System.out.println(zmiennaObjektowa1 == zmiennaObjektowa2);
    System.out.println(zmiennaObjektowa1.equals(zmiennaObjektowa2));

    System.out.println("boolean = " + true );

    String zmienna5 = "ZMIENNA " + 65 + " ZMI";
    System.out.println(zmienna5);
    zmienna5.toLowerCase();
    System.out.println(zmienna5);

    String zmienna5a = zmienna5.toLowerCase();
    System.out.println(zmienna5a);

    int a = 5;
    int b = 5;

    System.out.println(a == b);

    Integer c = Integer.valueOf(5);
    Integer d = Integer.valueOf(5);

    System.out.println(c.equals(d));
    System.out.println(c.equals(a));

    System.out.println("----------------------------");

    int e = 8;

    int f = a + e;
    System.out.println("f = " + f );

    int g = e - a;
    System.out.println("g = " + g);

    int h = e / 2;
    System.out.println("h = " + h);

    int i = a * b;
    System.out.println("i = " + i);

    System.out.println("2 + 6 = " + (2 * 6));
    System.out.println("a + 6 = " + a * 6);
    System.out.println("(2 * 6) + (5 * 3) =" +  (2 * 6) + (5 * 3) );

    Telephone telephone = new Telephone();
    System.out.println("a = " + a);
    int j = telephone.mergeTwoValue(a , e);
    System.out.println(j);
    System.out.println("a = " + a);

    System.out.println("------------------------");
    Telephone telephone6 = new Telephone(6);

    System.out.println(telephone6.getArea());

    System.out.println(telephone4.getArea());
    System.out.println(telephone6.mergeTwoValueObject(telephone4, e));

    System.out.println(telephone4.getArea());

    int k = 26;
    int l = 5;
    int m = k % l;
    System.out.println("m = " + m );

    int n = telephone.divide(k , l);
    System.out.println("n = " + n);

    System.out.println(telephone.divide(a, 0));
    System.out.println(telephone.divide(a, 1));

    System.out.println("------------------------------------");

    boolean o = 12 < 13;
    System.out.println("o = " + o);

    boolean p = 12 <= 12;
    System.out.println("p = " + p);

    boolean r = 6 < 10;
    System.out.println("r = " + r);

    boolean s = 6 <= 6;
    System.out.println("s = " + s);

    boolean t = 6 == 6;
    System.out.println("t = " + t);

    boolean u = 6 != 5;
    System.out.println("u = " + u);

    System.out.println(telephone.divide(25, 0));
    System.out.println("--------------------------");
    System.out.println(telephone.divide(25, 1));
    System.out.println("--------------------------");
    System.out.println(telephone.divide(15, 10));
    System.out.println("--------------------------");
    System.out.println(telephone.divide(17, 10));
    System.out.println("--------------------------");
    System.out.println(telephone.divide(15, 8));

    System.out.println("------------------------------------");
  }


}
