package pl.tmobile.prepaid.java;

import pl.tmobile.prepaid.java.module.StringMessage;

public class Calculator {

  private int firstNumber;
  private int secondNumber;

  public Calculator(int firstNumber, int secondNumber) {
    this.firstNumber = firstNumber;
    this.secondNumber = secondNumber;
  }

  public int calculate(String operation) {
    if (operation.equals("+")) {
      return add();
    } else if (operation.equals("-")) {
      return minus();
    } else if (operation.equals("*")) {
      return multi();
    } else if (operation.equals("/")) {
      return divide();
    } else {
      return -999999999;
    }
  }

  public int calculate(StringBuilder operation) {
    return 0;
  }

  public int calculate(StringBuilder operation , String op) {
    return 0;
  }

  public int calculating(String operation) {
    int result =  -999999999;

    switch (operation) {
      case "+":
        result = add();
        System.out.println("+");
//        break;
        return add();
      case "%":
        System.out.println("%");
//        return add();
        break;
      case "-":
        result = minus();
        System.out.println("-");
//        return minus();
        break;
      case "*" :
        result = minus();
        System.out.println("*");
//        return multi();
        break;
      case "/" :
        result = divide();
        System.out.println("/");
//        return divide();
        break;
      default: result = -999999999;
    }

    System.out.println("calculating end");

    return result;
  }


  public int divide() {
    if (secondNumber == 0) {
      return -999999999;
    }

    System.out.println(StringMessage.staticMethod("extra value"));

    return firstNumber / secondNumber;
  }

  public int multi() {
    return firstNumber * secondNumber;
  }

  public int minus() {
    return firstNumber - secondNumber;
  }

  public int add() {
    return firstNumber + secondNumber;
  }

  public static int staticAdd(int first, int second) {
    return first + second;
  }

  public void loop() {

    for (int i = 1; i <= 10; i++) {

      if (i == 5) {
        if (i >= 5) {
          if (true) {
            return;
          }

        }
      }

      for (int j = 0 ;j <= 10 ; j++){
        System.out.println("j: " + j);
      }
      System.out.println("i:" + i);
    }

    System.out.println("loop end");
  }

  public void nested() {
    loop();

    System.out.println("nested");
  }

  public void whileLoop() {
    int i = 0;

    while (i <= 10) {
      if (i == 5) {
//        break;
        return;
      }
      System.out.println(i);
      i++;

    }

    System.out.println("whileloop end");
  }

  public void doWhileLoop() {
    int i = 0;

    do {
      if (i == 5) {
//        break;
        return;
      }
      System.out.println(i);
      i++;
    } while (i <= 10);
  }

  public int met(int variable, String massage, String... variadic) {
    System.out.println("Variable: " + variable);
    System.out.println("message: " + massage);

    System.out.println(StringMessage.FINAL_MESSAGE);

    for (String var : variadic) {
      System.out.println("var: " + var);
    }

    return variable + 2;

  }



}
