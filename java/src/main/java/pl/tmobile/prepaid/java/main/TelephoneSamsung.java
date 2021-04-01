package pl.tmobile.prepaid.java.main;

import pl.tmobile.prepaid.java.Telephone;
import pl.tmobile.prepaid.java.module.StringMessage;

public class TelephoneSamsung extends Telephone {

  private String sammsungCatalogNumber;

  public TelephoneSamsung() {
    System.out.println(StringMessage.FINAL_MESSAGE);

  }

  public TelephoneSamsung(String serialNumber, short corner, Short cornerObject, int area, Integer areaObject, long pixel,
      Long pixelObject, float length, Float lengthObject, double wide, Double wideObject, boolean removableCover,
      Boolean removableCoverObject, byte buttonsNumber, char signature, String sammsungCatalogNumber) {
    super(serialNumber, corner, cornerObject, area, areaObject, pixel, pixelObject, length, lengthObject, wide, wideObject, removableCover,
        removableCoverObject, buttonsNumber, signature);
    this.sammsungCatalogNumber = sammsungCatalogNumber;
  }

  public String getSammsungCatalogNumber() {
    return sammsungCatalogNumber;
  }
}
