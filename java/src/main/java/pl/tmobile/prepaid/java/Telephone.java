package pl.tmobile.prepaid.java;

import java.util.Objects;

public class Telephone {

//  private String serialNumber = "4654sdfsdf";
  private String serialNumber;

//  short corner = 4; // -32768 -> 32767
  private short corner; // -32768 -> 32767
//  Short cornerObject = 4;
  private Short cornerObject;
//  int area = 2_147_483_647;     // -2147483648 -> 2147483647
  private int area;     // -2147483648 -> 2147483647
//  Integer areaObject = 2_147_483_647;
  private Integer areaObject;
//  long pixel = 9_223_372_036_854_775_807L;   // -9223372036854775808 - -> 9223372036854775807
  private long pixel;   // -9223372036854775808 - -> 9223372036854775807
//  Long pixelObject = 9_223_372_036_854_775_807L;
  private Long pixelObject;

//  float length = 12.65F;
  private float length;
//  Float lengthObject = 12.65F;
  private Float lengthObject;
//  double wide = 8.65;
  private double wide = 8.65;
  private Double wideObject;

//  boolean removableCover = true;
  private boolean removableCover;
//  Boolean removableCoverObject = true;
  private Boolean removableCoverObject;

//  byte buttonsNumber = 2; // -128 -> 127
  private byte buttonsNumber; // -128 -> 127
//  char signature = 72;
  private char signature;

  public String getSerialNumber() {
    return serialNumber;
  }

//  public void setSerialNumber(String serialNumber) {
//    this.serialNumber = serialNumber;
//  }


  public Telephone() {
  }

  public Telephone(
      String serialNumber,
      short corner,
      Short cornerObject,
      int area,
      Integer areaObject,
      long pixel,
      Long pixelObject,
      float length,
      Float lengthObject,
      double wide,
      Double wideObject,
      boolean removableCover,
      Boolean removableCoverObject,
      byte buttonsNumber,
      char signature) {
    this.serialNumber = serialNumber;
    this.corner = corner;
    this.cornerObject = cornerObject;
    this.area = area;
    this.areaObject = areaObject;
    this.pixel = pixel;
    this.pixelObject = pixelObject;
    this.length = length;
    this.lengthObject = lengthObject;
    this.wide = wide;
    this.wideObject = wideObject;
    this.removableCover = removableCover;
    this.removableCoverObject = removableCoverObject;
    this.buttonsNumber = buttonsNumber;
    this.signature = signature;
  }


  public Telephone(String serialNumber, short corner, Short cornerObject) {
    this.serialNumber = serialNumber;
    this.corner = corner;
    this.cornerObject = cornerObject;
  }

  public Telephone(short corner, long pixel, Double wideObject) {
    this.corner = corner;
    this.pixel = pixel;
    this.wideObject = wideObject;
  }

  public Telephone(int area) {
    this.area = area;
  }

  public short getCorner() {
    return corner;
  }

  public Short getCornerObject() {
    return cornerObject;
  }

  public int getArea() {
    return area;
  }

  public Integer getAreaObject() {
    return areaObject;
  }

  public long getPixel() {
    return pixel;
  }

  public Long getPixelObject() {
    return pixelObject;
  }

  public float getLength() {
    return length;
  }

  public Float getLengthObject() {
    return lengthObject;
  }

  public double getWide() {
    return wide;
  }

  public Double getWideObject() {
    return wideObject;
  }

  public boolean isRemovableCover() {
    return removableCover;
  }

  public Boolean getRemovableCoverObject() {
    return removableCoverObject;
  }

  public byte getButtonsNumber() {
    return buttonsNumber;
  }

  public char getSignature() {
    return signature;
  }

  public String toStringMethode() {
    return "toString";
  }

  public void toStringVoid() {
    System.out.println("toString");
  }

  //nie używać
  public void setArea(int area) {
    this.area = area;
  }

  @Override
  public String toString() {
    return "Telephone{" +
        "serialNumber='" + serialNumber + '\'' +
        ", corner=" + corner +
        ", cornerObject=" + cornerObject +
        ", area=" + area +
        ", areaObject=" + areaObject +
        ", pixel=" + pixel +
        ", pixelObject=" + pixelObject +
        ", length=" + length +
        ", lengthObject=" + lengthObject +
        ", wide=" + wide +
        ", wideObject=" + wideObject +
        ", removableCover=" + removableCover +
        ", removableCoverObject=" + removableCoverObject +
        ", buttonsNumber=" + buttonsNumber +
        ", signature=" + signature +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Telephone)) {
      return false;
    }

    Telephone telephone = (Telephone) o;
    return corner == telephone.corner && area == telephone.area && pixel == telephone.pixel
        && Float.compare(telephone.length, length) == 0 && Double.compare(telephone.wide, wide) == 0
        && removableCover == telephone.removableCover && buttonsNumber == telephone.buttonsNumber && signature == telephone.signature
        && Objects.equals(serialNumber, telephone.serialNumber) && Objects.equals(cornerObject, telephone.cornerObject)
        && Objects.equals(areaObject, telephone.areaObject) && Objects.equals(pixelObject, telephone.pixelObject)
        && Objects.equals(lengthObject, telephone.lengthObject) && Objects.equals(wideObject, telephone.wideObject)
        && Objects.equals(removableCoverObject, telephone.removableCoverObject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serialNumber, corner, cornerObject, area, areaObject, pixel, pixelObject, length, lengthObject, wide, wideObject,
        removableCover, removableCoverObject, buttonsNumber, signature);
  }

  public int mergeTwoValue(int a, int b) {
    a += 2;
    System.out.println("a inside mergeTwoValue = " + a);
    return a + b;
  }

  public int mergeTwoValueObject(Telephone telephone, int b) {
    telephone.setArea(19);  // nie używać setterów
    return telephone.getArea() + b;
  }

  public int add(int a, int b) {
    return a + b;
  }

  public int minus(int a, int b) {
    return a - b;
  }

  public int divide(int a, int b) {

    if (b == 0) {
      System.out.println("if with return 99999");
      return 999999999;
    }

    if (a > 20) {
      a = 20;
      System.out.println("if with condition a > 20");
    }

    if (b < 2) {
      b = 2;
      System.out.println("if with condition b < 2");
    }

    if ( (a > 15) && (b < 10) ) {
      a = 100;
      b = 50;
      System.out.println("if with condition (a > 15) && (b < 10)");
    }

    if ( (a > 17) || (b < 9) ){

      a = 200;
      b = 80;

      System.out.println("if with condition (a > 10) || (b < 10)");
    }

    return a / b;
  }


}
