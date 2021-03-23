package pl.tmobile.prepaid.java.main;

import pl.tmobile.prepaid.java.Telephone;

public class TelephoneSamsung extends Telephone {

  public TelephoneSamsung() {
  }

  public TelephoneSamsung(String serialNumber, short corner, Short cornerObject, int area, Integer areaObject, long pixel,
      Long pixelObject, float length, Float lengthObject, double wide, Double wideObject, boolean removableCover,
      Boolean removableCoverObject, byte buttonsNumber, char signature) {
    super(serialNumber, corner, cornerObject, area, areaObject, pixel, pixelObject, length, lengthObject, wide, wideObject, removableCover,
        removableCoverObject, buttonsNumber, signature);
  }



}
