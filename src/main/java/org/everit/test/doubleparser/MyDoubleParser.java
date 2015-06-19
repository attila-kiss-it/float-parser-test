package org.everit.test.doubleparser;

public class MyDoubleParser implements DoubleParser {


    private static final int DISCARD_WHITESPACE = 0;
    private static final int INTEGRAL_FOR_DECPOINT = 1;
    private static final int FRACTIONAL = 2;
    private static final int OPTIONAL_SIGN = 3;

    @Override
    public double strtod(final char[] str) {

        int state = DISCARD_WHITESPACE;
        int pos = 0;

        boolean minus = false;
        double integralPart = 0;
        double fractionPart = 0;
        int fractionDiv = 1;


        strProcess: while (pos < str.length) {

            char c = str[pos];

            switch(state) {
            case DISCARD_WHITESPACE: // initial whitespace
                if(Character.isWhitespace(c)) {
                    pos++;
                } else {
                    state = OPTIONAL_SIGN;
                }
                break;
            case OPTIONAL_SIGN:
                if(c == '-') {
                    minus = true;
                    pos++;
                } else if(c== '+') {
                    minus = false;
                    pos++;
                }
                state = INTEGRAL_FOR_DECPOINT;
                break;
            case INTEGRAL_FOR_DECPOINT:
                if(Character.isDigit(c)) {
                    integralPart = (integralPart * 10) + (c - '0');
                    pos++;
                } else if(c == '.') {
                    state = FRACTIONAL;
                    pos++;
                } else {
                    return 0D; // problem
                }
                break;
            case FRACTIONAL:
                if(Character.isDigit(c)) {
                    fractionPart = (fractionPart * 10) + (c - '0');
                    fractionDiv *= 10;
                    pos++;
                } else {
                    break strProcess;
                }
                break;

            }


        }

        double result = integralPart + (fractionPart / fractionDiv);
        if(minus) {
            result = -result;
        }

        System.out.println("got: " + new String(str) + ", result: " + result);

        return result;

    }

}
