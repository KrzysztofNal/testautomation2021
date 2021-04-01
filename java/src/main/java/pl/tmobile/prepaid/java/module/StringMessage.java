package pl.tmobile.prepaid.java.module;

public class StringMessage {

  private StringMessage() {
  }

  private String stringMessageField_1;

  public static final String FINAL_MESSAGE = "final message";
  public static final String FINAL_MESSAGE_2 = "final message 2";


  public static String staticMethod(String extraMessage) {
    return FINAL_MESSAGE + " , " + extraMessage + " , ";
  }

  public String getStringMessageField_1() {
    return stringMessageField_1;
  }

}
