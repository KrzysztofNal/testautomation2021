package pl.tmobile.prepaid.java;

public class Telephone {

//  private String serialNumber = "4654sdfsdf";
  private String serialNumber;

//  short corner = 4; // -32768 -> 32767
  private short corner; // -32768 -> 32767
//  Short cornerObject = 4;
  private Short cornerObject;
//  int area = 2_147_483_647;     // -2147483648 -> 2147483647
//  int area;     // -2147483648 -> 2147483647
////  Integer areaObject = 2_147_483_647;
//  Integer areaObject;
////  long pixel = 9_223_372_036_854_775_807L;   // -9223372036854775808 - -> 9223372036854775807
//  long pixel;   // -9223372036854775808 - -> 9223372036854775807
////  Long pixelObject = 9_223_372_036_854_775_807L;
//  Long pixelObject;
//
////  float length = 12.65F;
//  float length;
////  Float lengthObject = 12.65F;
//  Float lengthObject;
////  double wide = 8.65;
////  double wide = 8.65;
//  Double wideObject;
//
////  boolean removableCover = true;
//  boolean removableCover;
////  Boolean removableCoverObject = true;
//  Boolean removableCoverObject;
//
////  byte buttonsNumber = 2; // -128 -> 127
//  byte buttonsNumber; // -128 -> 127
////  char signature = 72;
//  char signature;

  public String getSerialNumber() {
    return serialNumber;
  }

//  public void setSerialNumber(String serialNumber) {
//    this.serialNumber = serialNumber;
//  }


//  public Telephone() {
//  }

//  public Telephone(String serialNumber, short corner, Short cornerObject, int area, Integer areaObject, long pixel,
//      Long pixelObject, float length, Float lengthObject, Double wideObject, boolean removableCover, Boolean removableCoverObject,
//      byte buttonsNumber, char signature) {
//    this.serialNumber = serialNumber;
//    this.corner = corner;
//    this.cornerObject = cornerObject;
//    this.area = area;
//    this.areaObject = areaObject;
//    this.pixel = pixel;
//    this.pixelObject = pixelObject;
//    this.length = length;
//    this.lengthObject = lengthObject;
//    this.wideObject = wideObject;
//    this.removableCover = removableCover;
//    this.removableCoverObject = removableCoverObject;
//    this.buttonsNumber = buttonsNumber;
//    this.signature = signature;
//  }


  public Telephone(String serialNumber, short corner, Short cornerObject) {
    this.serialNumber = serialNumber;
    this.corner = corner;
    this.cornerObject = cornerObject;
  }
}
