package pl.tmobile.prepaid.java;

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
  }
}
