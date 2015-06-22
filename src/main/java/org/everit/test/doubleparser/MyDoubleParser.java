package org.everit.test.doubleparser;

public class MyDoubleParser implements DoubleParser {

  @Override
  public double strtod(final char[] str) {
    if ((str == null) || (str.length == 0)) {
      return 0;
    }
    double cleanArray[] = null;
    double doubleValue = 0;
    boolean negative;

    int itr = 0;
    for (int i = 0; i < str.length; i++) {
      if (str[i] == '-') {
        negative = true;
      }
      if (!Character.isWhitespace(str[i])) {
        cleanArray[itr++] = str[i];
      }
    }

    return new Double(cleanArray.toString());

  }

}
