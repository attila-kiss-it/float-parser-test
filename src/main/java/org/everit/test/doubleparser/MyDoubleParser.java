package org.everit.test.doubleparser;

import java.util.ArrayList;
import java.util.List;

public class MyDoubleParser implements DoubleParser {

  private static final Character MINUS = '-';
  private static final Character PLUS = '+';
  private static final List<Integer> TENS;
  private static final List<Double> TENTH;

  static {
    TENS = new ArrayList<>();
    TENS.add(1);
    TENS.add(10);
    TENS.add(100);
    TENS.add(1000);
    TENS.add(10000);

    TENTH = new ArrayList<>();
    TENTH.add(0.1);
    TENTH.add(0.01);
    TENTH.add(0.001);
  }

  @Override
  public double strtod(final char[] str) {
    boolean isNegative = false;
    String numString = String.valueOf(str);
    if (MINUS.equals(str[0])) {
      isNegative = true;
    }
    if (MINUS.equals(str[0]) || PLUS.equals(str[0])) {
      numString = numString.substring(1);
    }

    String[] split = numString.split("\\.");
    String egeszString = "";
    if (split.length > 0) {
      egeszString = split[0];
    } else {
      egeszString = numString;
    }
    char[] tort = null;
    String tortString = null;
    if (split.length > 1) {
      tortString = split[1];
      tort = tortString.toCharArray();
    }
    char[] egesz = egeszString.toCharArray();
    double d = 0;

    for (int i = 0; i < egesz.length; i++) {
      char c = egesz[(egesz.length - i) - 1];
      Integer num = Integer.valueOf(String.valueOf(c));
      d = d + (num * TENS.get(i));
    }

    // tort
    if (tort != null) {
      for (int i = 0; i < tort.length; i++) {
        char c = tort[0];
        Integer num = Integer.valueOf(String.valueOf(c));
        d = d + (num * TENTH.get(i));
      }
    }

    if (isNegative) {
      d = d * (-1);
    }
    return d;

  }

}
