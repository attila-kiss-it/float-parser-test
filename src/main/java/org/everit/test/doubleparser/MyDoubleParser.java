package org.everit.test.doubleparser;

public class MyDoubleParser implements DoubleParser {

  private static final char DOT = '.';

  private static final char MINUS = '-';

  private static final char PLUS = '+';

  private boolean isMinus(final char sign) {
    if (sign == MINUS) {
      return true;
    }
    return false;
  }

  @Override
  public double strtod(final char[] str) {
    if ((str == null) || (str.length == 0)) {
      return 0;
    }

    char firstChar = str[0];
    if (firstChar == DOT) {
      return 0;
    }

    double result = 0;
    boolean isMinus = isMinus(firstChar);

    boolean isDotValue = false;
    for (char c : str) {
      if (isDotValue) {
        result += Character.digit(c, 10) * 0.1; // TODO add after dot value.
        // TODO ignore other char which not digit.
      } else if (Character.isDigit(c)) {
        result += Character.digit(c, 10);
      } else if (c == DOT) {
        isDotValue = true;
      }
    }
    return isMinus ? result * -1 : result;

  }
}
