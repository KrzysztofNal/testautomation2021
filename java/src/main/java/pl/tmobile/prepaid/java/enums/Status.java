package pl.tmobile.prepaid.java.enums;

public enum Status {

  ACTIVE("active", "activate"),
  STATE("state", "on hold"),
  DELETE("delete", "deactivate");

  String status;
  String function;

  Status(String status, String function) {
    this.status = status;
    this.function = function;
  }

  public String getStatus() {
    return status;
  }

  public String getFunction() {
    return function;
  }
}
