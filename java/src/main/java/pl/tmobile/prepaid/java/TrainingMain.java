package pl.tmobile.prepaid.java;

public class TrainingMain {

  public static void main(String[] args) {

    int jakasZmienna = 15;

    System.out.println("Pierwszy komentarz wywołania.");

//    Telephone telephone = new Telephone();
//    System.out.println(telephone.getSerialNumber());

//    telephone.serialNumber = "ttttttttt";
//    telephone.setSerialNumber("ttttttttt");

//    System.out.println(telephone.getSerialNumber());

    Telephone telephone1 = new Telephone("oposerwer465465", (short) 4, (short) 4);
    System.out.printf(telephone1.getSerialNumber());
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
  }
}
