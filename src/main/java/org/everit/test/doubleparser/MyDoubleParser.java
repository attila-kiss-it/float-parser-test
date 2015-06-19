package org.everit.test.doubleparser;

import java.util.Arrays;

public class MyDoubleParser implements DoubleParser {

  @Override
  public double strtod(final char[] str) {
    // TODO Implement me in 40 minutes!
    final char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    Arrays.sort(digits);
    boolean digitFound = false;
    double result = 0.0;
    for (char c : str) {
      int digitValue = Arrays.binarySearch(digits, c);
      if ((Arrays.binarySearch(digits, c) <= 0) || ((c == '+') || (c == '-'))
          || (!Character.isWhitespace(c) && !digitFound) || (c == '.')) { // számjegy
        if (c == '-') {
          result = result * -1;
        } else if (c == '.') {

        } else if (!digitFound) {
          digitFound = true;
          result += digitValue;
        } else {
          result = (result * 10) + digitValue;
        }
      } else {
        break;
      }
    }
    return result;
    // return 1;

  }

}
