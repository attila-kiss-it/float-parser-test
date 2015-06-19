package org.everit.test.doubleparser;

public class MyDoubleParser implements DoubleParser {

  private double charNumberToDouble(final char charNumber) {
    switch (charNumber) {
    case '0':
      return 0;
    case '1':
      return 1;
    case '2':
      return 2;
    case '3':
      return 3;
    case '4':
      return 4;
    case '5':
      return 5;
    case '6':
      return 6;
    case '7':
      return 7;
    case '8':
      return 8;
    case '9':
      return 9;
    default:
      // TODO throw something
      return -1;
    }
  }

  private double sq(final int dept) {
    if (dept == 1) {
      return 1 * 10;
    } else {
      return 10 * sq(dept - 1);
    }
  }

  @Override
  public double strtod(final char[] str) {
    double result = 0.0;

    // TODO remove white space !!!!!!

    int lenghtStrArray = str.length;

    int dotPosition = lenghtStrArray;
    for (int i = 0; i < lenghtStrArray; i++) {
      if (str[i] == '.') {
        dotPosition = i;
      }
    }
    // TODO create the left side of the number
    for (int i = 0; i < dotPosition; i++) {
      result += charNumberToDouble(str[dotPosition - 1 - i]) * ten(i);
    }
    // TODO if have to create the right side of the number

    return result;

  }

  private double ten(final int number) {
    if (number > 0) {
      return sq(number);
    }
    if (number < 0) {
      return 1 / sq(number);
    }
    return 1;
  }
}
