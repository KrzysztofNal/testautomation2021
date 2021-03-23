package pl.tmobile.prepaid.java;

import java.math.BigInteger;
import java.util.Locale;
import pl.tmobile.prepaid.java.Telephone;
import pl.tmobile.prepaid.java.main.TelephoneSamsung;

public class TrainingMain {

  public static void main(String[] args) {

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


  }


}
