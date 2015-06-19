package org.everit.test.doubleparser;

import java.util.ArrayList;
import java.util.List;

public class MyDoubleParser implements DoubleParser {

  @Override
  public double strtod(final char[] str) {

    boolean minus = false;

    if ((str == null) || (str.length < 1)) {
      return 0;
    }

    List<Character> cList = new ArrayList<Character>();

    boolean onlyWhitespaces = true;
    for (char c : str) {
      if (!Character.isWhitespace(c)) {
        onlyWhitespaces = false;
        cList.add(c);
      }
    }
    if (onlyWhitespaces) {
      return 0;
    }
    Character firstChar = cList.get(0);
    if ((firstChar.equals('-')) || (firstChar.equals('+'))) {
      if (firstChar.equals('-')) {
        minus = true;
      }
      cList.remove(0);
    }

    for (Character character : cList) {
      if (Character.isDigit(character)) {

      } else if (character.equals('.')) {

      }
    }

    // TODO Implement me in 40 minutes!
    return 1;
  }

}
